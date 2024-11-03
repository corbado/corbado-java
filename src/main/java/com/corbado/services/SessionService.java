package com.corbado.services;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.interfaces.RSAPublicKey;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;

import com.auth0.jwk.InvalidPublicKeyException;
import com.auth0.jwk.Jwk;
import com.auth0.jwk.JwkException;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.JwkProviderBuilder;
import com.auth0.jwk.SigningKeyNotFoundException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.IncorrectClaimException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.corbado.entities.UserEntity;
import com.corbado.enums.exception.ValidationErrorType;
import com.corbado.exceptions.TokenValidationException;
import com.corbado.sdk.Config;
import com.corbado.utils.ValidationUtils;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * This class provides functionality for managing sessions, including validation and retrieval of
 * user information from short-term session tokens.
 */
@Getter
@Setter
public class SessionService {

  /** Number of keys that can be cached. */
  private static final int JWK_CACHE_SIZE = 100;

  /** The Constant DEFAULT_SESSION_LENGTH. */
  private static final int DEFAULT_SESSION_LENGTH = 300;

  /** The issuer. */
  private String issuer;

  /** The jwks uri. */
  private String jwksUri;

  /** The last short session validation result. */
  private String lastSessionTokenValidationResult;

  /** The jwk provider. */
  private JwkProvider jwkProvider;

  private final String projectId;

  /**
   * Instantiates a new session service.
   *
   * @param issuer the issuer
   * @param jwksUri the jwks uri
   * @param sessionTokenLength the short session length. Defaults to 300.
   * @param cacheKeys the cache keys
   */
  public SessionService(
      final String issuer,
      final String jwksUri,
      Integer sessionTokenLength,
      final boolean cacheKeys,
      final String projectId) {

    ValidationUtils.validateNotEmpty(issuer, jwksUri, projectId);
    sessionTokenLength = (sessionTokenLength != null) ? sessionTokenLength : DEFAULT_SESSION_LENGTH;

    this.issuer = issuer;
    this.jwksUri = jwksUri;
    this.projectId = projectId;

    JwkProviderBuilder jwkProviderBuilder;
    try {
      jwkProviderBuilder = new JwkProviderBuilder(new URL(jwksUri));
      if (cacheKeys) {
        jwkProviderBuilder.cached(JWK_CACHE_SIZE, sessionTokenLength, TimeUnit.SECONDS);
      }
      this.jwkProvider = jwkProviderBuilder.build();
    } catch (final MalformedURLException e) {
      // MalformedURL should not happen, since its validated in config before. We do not want to
      // retrow this error to make code generation with lombok easier.
    }
  }

  /**
   * Instantiates a new session service from config.
   *
   * @param config the config
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
   * Sets the issuer mismatch error.
   *
   * @param issuer the new issuer mismatch error
   */
  public void setIssuerMismatchError(final String issuer) {
    this.lastSessionTokenValidationResult =
        String.format("Mismatch in issuer (configured: %s, JWT: %s)", this.issuer, issuer);
  }

  /**
   * Gets the and validate user from short session value.
   *
   * @param sessionToken the short session
   * @return User entity from short session value
   * @throws JWTVerificationException the JWT verification exception
   * @throws JwkException the jwk exception
   * @throws IncorrectClaimException the incorrect claim exception
   */
  public UserEntity validateToken(final String sessionToken) throws TokenValidationException {

    if (sessionToken == null || sessionToken.isEmpty()) {
      throw new TokenValidationException(
          ValidationErrorType.CODE_EMPTY_SESSION_TOKEN, "Session token is empty");
    }
    DecodedJWT decodedJwt = null;
    try {
      // Get the signing key
      decodedJwt = JWT.decode(sessionToken);
      final Jwk jwk = this.jwkProvider.get(decodedJwt.getKeyId());
      if (jwk == null) {
        throw new SigningKeyNotFoundException(sessionToken, null);
      }
      final RSAPublicKey publicKey = (RSAPublicKey) jwk.getPublicKey();

      // Verify and decode the JWT using the signing key
      final Algorithm algorithm = Algorithm.RSA256(publicKey);
      final JWTVerifier verifier = JWT.require(algorithm).build();
      decodedJwt = verifier.verify(sessionToken);
    } catch (final InvalidPublicKeyException e) {
      throw new TokenValidationException(ValidationErrorType.CODE_INVALID_PUBLIC_KEY, e.getMessage(), e);
    } catch (final TokenExpiredException e) {
      throw new TokenValidationException(ValidationErrorType.CODE_JWT_EXPIRED, e.getMessage(), e);

    } catch (final SignatureVerificationException e) {
      throw new TokenValidationException(
          ValidationErrorType.CODE_JWT_INVALID_SIGNATURE, e.getMessage(), e);

    } catch (final JWTVerificationException e) {
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
      throw new TokenValidationException(
          ValidationErrorType.CODE_INVALID_TOKEN,
          "Unexpected exception during token validation: " + sessionToken,
          e);
    }
    validateIssuer(decodedJwt.getClaim("iss").asString(), this.projectId);
    return new UserEntity(
        // TODO: add UserStatus
        decodedJwt.getClaim("sub").asString(), null, decodedJwt.getClaim("name").asString(), null);
  }

  private void validateIssuer(String tokenIssuer, String sessionToken)
      throws TokenValidationException {
    // Check if issuer is empty
    if (tokenIssuer == null || StringUtils.isBlank(tokenIssuer)) {
      throw new TokenValidationException(
          ValidationErrorType.CODE_EMPTY_ISSUER, "Issuer is empty. Session token: " + sessionToken);
    }

    // Check for old Frontend API (without .cloud.)
    final String expectedOld = "https://" + this.projectId + ".frontendapi.corbado.io";
    if (tokenIssuer.equals(expectedOld)) {
      return;
    }

    // Check for new Frontend API (with .cloud.)
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
