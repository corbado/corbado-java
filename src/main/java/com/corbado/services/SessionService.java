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

  /** The short session cookie name. */
  private String shortSessionCookieName;

  /** The issuer. */
  private String issuer;

  /** The jwks uri. */
  private String jwksUri;

  /** The last short session validation result. */
  private String lastShortSessionValidationResult;

  /** The jwk provider. */
  private JwkProvider jwkProvider;

  /**
   * Instantiates a new session service.
   *
   * @param shortSessionCookieName the short session cookie name
   * @param issuer the issuer
   * @param jwksUri the jwks uri
   * @param shortSessionLength the short session length
   * @param cacheKeys the cache keys
   */
  public SessionService(
      final String shortSessionCookieName,
      final String issuer,
      final String jwksUri,
      Integer shortSessionLength,
      final boolean cacheKeys) {

    ValidationUtils.validateNotEmpty(shortSessionCookieName, issuer, jwksUri);
    shortSessionLength = (shortSessionLength != null) ? shortSessionLength : DEFAULT_SESSION_LENGTH;

    this.shortSessionCookieName = shortSessionCookieName;
    this.issuer = issuer;
    this.jwksUri = jwksUri;

    JwkProviderBuilder jwkProviderBuilder;
    try {
      jwkProviderBuilder = new JwkProviderBuilder(new URL(jwksUri));
      if (cacheKeys) {
        jwkProviderBuilder.cached(JWK_CACHE_SIZE, shortSessionLength, TimeUnit.SECONDS);
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
        config.getShortSessionCookieName(),
        config.getIssuer(),
        config.getFrontendApi() + "/.well-known/jwks",
        config.getShortSessionLength(),
        config.isCacheKeys());
  }

  /**
   * Sets the issuer mismatch error.
   *
   * @param issuer the new issuer mismatch error
   */
  public void setIssuerMismatchError(final String issuer) {
    this.lastShortSessionValidationResult =
        String.format("Mismatch in issuer (configured: %s, JWT: %s)", this.issuer, issuer);
  }

  /**
   * Gets the and validate short session value.
   *
   * @param shortSession the short session
   * @return the and validate short session value
   */
  private SessionValidationResult getAndValidateUserFromShortSessionValue(
      final String shortSession) {

    if (shortSession == null || shortSession.isEmpty()) {
      throw new IllegalArgumentException("Session value cannot be null or empty");
    }
    try {
      // Get the signing key
      DecodedJWT decodedJwt = JWT.decode(shortSession);
      final Jwk jwk = this.jwkProvider.get(decodedJwt.getKeyId());
      if (jwk == null) {
        throw new SigningKeyNotFoundException(shortSession, null);
      }
      final RSAPublicKey publicKey = (RSAPublicKey) jwk.getPublicKey();

      // Verify and decode the JWT using the signing key
      final Algorithm algorithm = Algorithm.RSA256(publicKey);
      final JWTVerifier verifier = JWT.require(algorithm).withIssuer(issuer).build();
      decodedJwt = verifier.verify(shortSession);

      return SessionValidationResult.builder()
          .authenticated(true)
          .fullName(decodedJwt.getClaim("name").asString())
          .userID(decodedJwt.getClaim("sub").asString())
          .build();

    } catch (final IncorrectClaimException e) {
      // Be careful of the case where issuer does not match. You have probably forgotten to set
      // the cname in config class.
      if (StringUtils.equals(e.getClaimName(), "iss")) {
        final String message =
            e.getMessage()
                + "Be careful of the case where issuer does not match. You have probably forgotten to set the cname in config class.";
        final IncorrectClaimException exception =
            new IncorrectClaimException(message, e.getClaimName(), e.getClaimValue());

        setValidationError(exception);
        return new SessionValidationResult(exception);
      }
      setValidationError(e);
      return new SessionValidationResult(e);

    } catch (final JwkException | JWTVerificationException e) {
      setValidationError(e);
      return new SessionValidationResult(e);
    }
  }

  /**
   * Retrieves userID and full name if 'shortSession' is valid.
   *
   * @param shortSession the short session
   * @return the current user{@link SessionValidationResult}
   */
  public SessionValidationResult getAndValidateCurrentUser(final String shortSession) {

    return getAndValidateUserFromShortSessionValue(shortSession);
  }

  /**
   * Sets the validation error.
   *
   * @param error the new validation error
   */
  private void setValidationError(@NonNull final Exception error) {
    this.lastShortSessionValidationResult =
        String.format("JWT validation failed: %s", error.getMessage());
  }
}
