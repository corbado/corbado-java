package com.corbado.services;

import com.auth0.jwk.Jwk;
import com.auth0.jwk.JwkException;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.JwkProviderBuilder;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.corbado.entities.UserEntity;
import com.corbado.utils.ValidationUtils;
import java.security.interfaces.RSAPublicKey;
import java.util.concurrent.TimeUnit;
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

  /** The short session cookie name. */
  private String shortSessionCookieName;

  /** The issuer. */
  private String issuer;

  /** The jwks uri. */
  private String jwksUri;

  /** The last short session validation result. */
  private String lastShortSessionValidationResult;

  /** The short session length. */
  private int shortSessionLength = 300; // Default short session length in seconds

  /** The cache keys. */
  private boolean cacheKeys = false;

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
      final int shortSessionLength,
      final boolean cacheKeys) {

    ValidationUtils.validateNotEmpty(shortSessionCookieName, issuer, jwksUri);

    this.shortSessionCookieName = shortSessionCookieName;
    this.issuer = issuer;
    this.jwksUri = jwksUri;
    this.shortSessionLength = shortSessionLength;
    this.cacheKeys = cacheKeys;

    final JwkProviderBuilder jwkProviderBuilder = new JwkProviderBuilder(this.jwksUri);
    if (cacheKeys) {
      jwkProviderBuilder.cached(JWK_CACHE_SIZE, shortSessionLength, TimeUnit.SECONDS);
    }
    this.jwkProvider = jwkProviderBuilder.build();
  }

  /**
   * Gets the and validate short session value.
   *
   * @param shortSession the short session
   * @return the and validate short session value
   * @throws JwkException if no jwk can be found using the given kid
   */
  public UserEntity getAndValidateShortSessionValue(final String shortSession) {

    if (shortSession == null || shortSession.isEmpty()) {
      return UserEntity.builder().authenticated(false).build();
    }
    try {
      // Get the signing key
      DecodedJWT decodedJwt = JWT.decode(shortSession);
      final Jwk jwk = jwkProvider.get(decodedJwt.getKeyId());
      final RSAPublicKey publicKey = (RSAPublicKey) jwk.getPublicKey();

      // Verify and decode the JWT using the signing key
      final Algorithm algorithm = Algorithm.RSA256(publicKey);
      final JWTVerifier verifier = JWT.require(algorithm).build();

      decodedJwt = verifier.verify(shortSession);
      System.out.println(decodedJwt);

    } catch (final JwkException e) {
      setValidationError(e);
      return UserEntity.builder().authenticated(false).build();
    }
    return null;
  }

  /**
   * Gets the current user.
   *
   * @param shortSession the short session
   * @return the current user
   */
  public UserEntity getCurrentUser(final String shortSession) {
    if (shortSession == null || shortSession.isEmpty()) {
      return UserEntity.builder().authenticated(false).build();
    }
    return getAndValidateShortSessionValue(shortSession);
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
   * Sets the validation error.
   *
   * @param error the new validation error
   */
  public void setValidationError(@NonNull final Exception error) {
    this.lastShortSessionValidationResult =
        String.format("JWT validation failed: %s", error.getMessage());
  }
}
