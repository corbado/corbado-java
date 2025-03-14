package com.corbado.services;

import com.auth0.jwk.InvalidPublicKeyException;
import com.auth0.jwk.Jwk;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.JwkProviderBuilder;
import com.auth0.jwk.SigningKeyNotFoundException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.corbado.entities.UserEntity;
import com.corbado.enums.exception.ValidationErrorType;
import com.corbado.exceptions.TokenValidationException;
import com.corbado.sdk.Config;
import com.corbado.utils.ValidationUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.interfaces.RSAPublicKey;
import java.util.concurrent.TimeUnit;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

/**
 * Service class responsible for managing user sessions and validating session tokens. This class
 * provides functionality to validate and extract user information from session tokens using JWT
 * (JSON Web Token) verification.
 *
 * <p>The service supports:
 *
 * <ul>
 *   <li>JWT token validation using RSA256 algorithm
 *   <li>JWKS (JSON Web Key Set) integration for key management
 *   <li>Configurable session token length and caching
 *   <li>Issuer validation with support for both old and new Frontend API formats
 *   <li>Custom domain/CNAME support
 * </ul>
 *
 * <p>This service is typically used in conjunction with the Corbado authentication system to manage
 * user sessions and validate session tokens in a secure manner.
 *
 * <p>The service implements a robust token validation process that includes:
 *
 * <ul>
 *   <li>Signature verification using RSA256
 *   <li>Token expiration checking
 *   <li>Issuer validation with backward compatibility
 *   <li>Comprehensive error handling with specific error types
 * </ul>
 *
 * @see com.corbado.sdk.Config
 * @see com.corbado.entities.UserEntity
 * @see com.corbado.exceptions.TokenValidationException
 */
@Getter
@Setter
public class SessionService {

  /** Maximum number of JWK keys that can be cached to optimize performance. */
  private static final int JWK_CACHE_SIZE = 100;

  /**
   * Default session token length in seconds (5 minutes). Used when no custom length is provided.
   */
  private static final int DEFAULT_SESSION_LENGTH = 300;

  /** The expected issuer of the JWT tokens. Can be a custom domain or CNAME. */
  private String issuer;

  /** URI for the JSON Web Key Set (JWKS) endpoint used to fetch public keys. */
  private String jwksUri;

  /** Provider for retrieving and caching JSON Web Keys to optimize key fetching. */
  private JwkProvider jwkProvider;

  /** The project ID used for issuer validation and constructing expected issuer URLs. */
  private final String projectId;

  /**
   * Constructs a new SessionService with the specified configuration parameters.
   *
   * @param issuer the expected issuer of the JWT tokens
   * @param jwksUri the URI for the JSON Web Key Set endpoint
   * @param sessionTokenLength the length of the session token in seconds (if null, uses default)
   * @param cacheKeys whether to enable JWK caching
   * @param projectId the project ID used for issuer validation
   * @throws IllegalArgumentException if any of the required parameters are empty or null
   */
  public SessionService(
      final String issuer,
      final String jwksUri,
      Integer sessionTokenLength,
      final boolean cacheKeys,
      final String projectId) {

    // Validate required parameters
    ValidationUtils.validateNotEmpty(issuer, jwksUri, projectId);
    sessionTokenLength = (sessionTokenLength != null) ? sessionTokenLength : DEFAULT_SESSION_LENGTH;

    this.issuer = issuer;
    this.jwksUri = jwksUri;
    this.projectId = projectId;

    // Initialize the JWK provider with optional caching
    JwkProviderBuilder jwkProviderBuilder;
    try {
      jwkProviderBuilder = new JwkProviderBuilder(new URL(jwksUri));
      if (cacheKeys) {
        // Configure caching with specified size and duration
        jwkProviderBuilder.cached(JWK_CACHE_SIZE, sessionTokenLength, TimeUnit.SECONDS);
      }
      this.jwkProvider = jwkProviderBuilder.build();
    } catch (final MalformedURLException e) {
      // MalformedURL should not happen, since its validated in config before. We do not want to
      // retrow this error to make code generation with lombok easier.
    }
  }

  /**
   * Constructs a new SessionService using configuration from a Config object. This constructor
   * provides a convenient way to initialize the service using the standard configuration format.
   *
   * @param config the configuration object containing all necessary parameters
   * @throws IllegalArgumentException if any required configuration values are missing
   */
  public SessionService(@NonNull final Config config) {
    this(
        config.getIssuer(),
        config.getFrontendApi() + "/.well-known/jwks",
        config.getSessionTokenLength(),
        config.isCacheKeys(),
        config.getProjectId());
  }

  /**
   * Validates a session token and extracts user information. This method performs the following
   * validations:
   *
   * <ul>
   *   <li>Verifies the JWT signature using the appropriate public key
   *   <li>Validates the token expiration
   *   <li>Validates the token issuer
   *   <li>Extracts user information from the token claims
   * </ul>
   *
   * <p>The validation process includes comprehensive error handling for various scenarios:
   *
   * <ul>
   *   <li>Empty or null tokens
   *   <li>Invalid public keys
   *   <li>Expired tokens
   *   <li>Invalid signatures
   *   <li>Tokens used before their valid date
   *   <li>General JWT verification failures
   * </ul>
   *
   * @param sessionToken the JWT token to validate
   * @return a UserEntity containing the user's information
   * @throws TokenValidationException if the token is invalid, expired, or has an incorrect issuer
   */
  public UserEntity validateToken(final String sessionToken) throws TokenValidationException {

    // Validate token presence
    if (sessionToken == null || sessionToken.isEmpty()) {
      throw new TokenValidationException(
          ValidationErrorType.CODE_EMPTY_SESSION_TOKEN, "Session token is empty");
    }
    DecodedJWT decodedJwt = null;
    try {
      // Decode the token to get the key ID
      decodedJwt = JWT.decode(sessionToken);
      final Jwk jwk = this.jwkProvider.get(decodedJwt.getKeyId());
      if (jwk == null) {
        throw new SigningKeyNotFoundException(sessionToken, null);
      }
      final RSAPublicKey publicKey = (RSAPublicKey) jwk.getPublicKey();

      // Verify the token signature and claims
      final Algorithm algorithm = Algorithm.RSA256(publicKey);
      final JWTVerifier verifier = JWT.require(algorithm).build();
      decodedJwt = verifier.verify(sessionToken);
    } catch (final InvalidPublicKeyException e) {
      throw new TokenValidationException(
          ValidationErrorType.CODE_INVALID_PUBLIC_KEY, e.getMessage(), e);
    } catch (final TokenExpiredException e) {
      throw new TokenValidationException(ValidationErrorType.CODE_JWT_EXPIRED, e.getMessage(), e);

    } catch (final SignatureVerificationException e) {
      throw new TokenValidationException(
          ValidationErrorType.CODE_JWT_INVALID_SIGNATURE, e.getMessage(), e);

    } catch (final JWTVerificationException e) {
      // Handle specific JWT verification errors
      ValidationErrorType errorType = null;
      if (StringUtils.startsWith(e.getMessage(), "The Token can't be used before")) {
        errorType = ValidationErrorType.CODE_JWT_BEFORE;
      } else {
        errorType = ValidationErrorType.CODE_INVALID_TOKEN;
      }
      throw new TokenValidationException(
          errorType,
          "JWTVerificationException exception during token validation: "
              + sessionToken
              + ". Detailed message: "
              + e.getMessage(),
          e);
    } catch (final Exception e) {
      // Handle unexpected errors
      throw new TokenValidationException(
          ValidationErrorType.CODE_INVALID_TOKEN,
          "Unexpected exception during token validation: " + sessionToken,
          e);
    }

    // Validate the token issuer
    validateIssuer(decodedJwt.getClaim("iss").asString(), this.projectId);

    // Create and return user entity from token claims
    return new UserEntity(
        // TODO: add UserStatus
        decodedJwt.getClaim("sub").asString(), null, decodedJwt.getClaim("name").asString(), null);
  }

  /**
   * Validates the issuer of a JWT token. This method checks the token issuer against:
   *
   * <ul>
   *   <li>The old Frontend API format (without .cloud.)
   *   <li>The new Frontend API format (with .cloud.)
   *   <li>The configured issuer (for custom domains/CNAMEs)
   * </ul>
   *
   * <p>This validation ensures backward compatibility with both old and new API formats while
   * supporting custom domain configurations.
   *
   * @param tokenIssuer the issuer from the JWT token
   * @param sessionToken the session token for error reporting
   * @throws TokenValidationException if the issuer is invalid or doesn't match any expected values
   */
  private void validateIssuer(String tokenIssuer, String sessionToken)
      throws TokenValidationException {
    // Check if issuer is empty
    if (tokenIssuer == null || StringUtils.isBlank(tokenIssuer)) {
      throw new TokenValidationException(
          ValidationErrorType.CODE_EMPTY_ISSUER, "Issuer is empty. Session token: " + sessionToken);
    }

    // Check for old Frontend API format (without .cloud.)
    final String expectedOld = "https://" + this.projectId + ".frontendapi.corbado.io";
    if (tokenIssuer.equals(expectedOld)) {
      return;
    }

    // Check for new Frontend API format (with .cloud.)
    final String expectedNew = "https://" + this.projectId + ".frontendapi.cloud.corbado.io";
    if (tokenIssuer.equals(expectedNew)) {
      return;
    }

    // Check against the configured issuer (e.g., a custom domain or CNAME)
    if (!tokenIssuer.equals(this.issuer)) {
      throw new TokenValidationException(
          ValidationErrorType.CODE_ISSUER_MISSMATCH,
          "Issuer mismatch (configured via FrontendAPI: '"
              + this.issuer
              + "', JWT issuer: '"
              + tokenIssuer
              + "')");
    }
  }
}
