package com.corbado.services;

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
import com.auth0.jwt.interfaces.DecodedJWT;
import com.corbado.entities.SessionValidationResult;
import com.corbado.sdk.Config;
import com.corbado.utils.ValidationUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.interfaces.RSAPublicKey;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
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

  /** The session token cookie name. */
  private String sessionTokenCookieName;

  /** The issuer. */
  private String issuer;

  /** The jwks uri. */
  private String jwksUri;

  /** The last short session validation result. */
  private String lastSessionTokenValidationResult;

  /** The jwk provider. */
  private JwkProvider jwkProvider;

  /**
   * Instantiates a new session service.
   *
   * @param sessionTokenCookieName the short session cookie name
   * @param issuer the issuer
   * @param jwksUri the jwks uri
   * @param sessionTokenLength the short session length
   * @param cacheKeys the cache keys
   */
  public SessionService(
      final String sessionTokenCookieName,
      final String issuer,
      final String jwksUri,
      Integer sessionTokenLength,
      final boolean cacheKeys) {

    ValidationUtils.validateNotEmpty(sessionTokenCookieName, issuer, jwksUri);
    sessionTokenLength = (sessionTokenLength != null) ? sessionTokenLength : DEFAULT_SESSION_LENGTH;

    this.sessionTokenCookieName = sessionTokenCookieName;
    this.issuer = issuer;
    this.jwksUri = jwksUri;

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
        config.getSessionTokenCookieName(),
        config.getIssuer(),
        config.getFrontendApi() + "/.well-known/jwks",
        config.getSessionTokenLength(),
        config.isCacheKeys());
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
   * @return the and validate user from short session value
   * @throws JWTVerificationException the JWT verification exception
   * @throws JwkException the jwk exception
   * @throws IncorrectClaimException the incorrect claim exception
   */
  public SessionValidationResult validateToken(final String sessionToken)
      throws JWTVerificationException, JwkException, IncorrectClaimException {

    if (sessionToken == null || sessionToken.isEmpty()) {
      throw new IllegalArgumentException("Session value cannot be null or empty");
    }
    try {
      // Get the signing key
      DecodedJWT decodedJwt = JWT.decode(sessionToken);
      final Jwk jwk = this.jwkProvider.get(decodedJwt.getKeyId());
      if (jwk == null) {
        throw new SigningKeyNotFoundException(sessionToken, null);
      }
      final RSAPublicKey publicKey = (RSAPublicKey) jwk.getPublicKey();

      // Verify and decode the JWT using the signing key
      final Algorithm algorithm = Algorithm.RSA256(publicKey);
      final JWTVerifier verifier = JWT.require(algorithm).build();
      decodedJwt = verifier.verify(sessionToken);

      return SessionValidationResult.builder()
          .fullName(decodedJwt.getClaim("name").asString())
          .userID(decodedJwt.getClaim("sub").asString())
          .build();

    } catch (final IncorrectClaimException e) {
      // Be careful of the case where issuer does not match. You have probably forgotten to set
      // the cname in config class. We add an additional message to the exception and retrow it to
      // underline its importance.
      if (StringUtils.equals(e.getClaimName(), "iss")) {
        final String message =
            e.getMessage()
                + "Be careful of the case where issuer does not match. "
                + "You have probably forgotten to set the cname in config class.";
        throw new IncorrectClaimException(message, e.getClaimName(), e.getClaimValue());
      }
      throw e;

    } catch (final JwkException | JWTVerificationException e) {
      throw e;
    }
  }
}
