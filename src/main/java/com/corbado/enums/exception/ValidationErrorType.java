package com.corbado.enums.exception;

import com.corbado.exceptions.TokenValidationException;

/**
 * Enumeration representing different types of validation errors that can occur during token
 * validation.
 *
 * <p>This enum is used by the {@link TokenValidationException} to categorize and describe specific
 * validation failures that occur when validating JWT tokens. Each error type has a human-readable
 * description that explains the nature of the validation failure.
 *
 * <p>The validation errors cover various aspects of token validation including:
 *
 * <ul>
 *   <li>Token format and structure
 *   <li>Token expiration and validity timing
 *   <li>Token signature verification
 *   <li>Issuer validation
 *   <li>Public key validation
 * </ul>
 *
 * @see com.corbado.exceptions.TokenValidationException
 */
public enum ValidationErrorType {

  /** Indicates that the token is malformed or invalid in some way. */
  CODE_INVALID_TOKEN("Invalid token"),
  /** Indicates that the session token is empty or null. */
  CODE_EMPTY_SESSION_TOKEN("Session token is empty"),
  /** Indicates that the token's issuer claim is missing or empty. */
  CODE_EMPTY_ISSUER("Issuer is empty"),
  /** Indicates that the token's "not before" (nbf) claim indicates the token is not yet valid. */
  CODE_JWT_BEFORE("Token is not valid yet"),
  /** Indicates that the token has expired according to its "expiration" (exp) claim. */
  CODE_JWT_EXPIRED("Token is expired"),
  /** Indicates that the public key used for signature verification is invalid. */
  CODE_INVALID_PUBLIC_KEY("Public key is invalid"),
  /** Indicates that the token's signature verification failed. */
  CODE_JWT_INVALID_SIGNATURE("Token signature is invalid"),
  /** Indicates that the token's issuer doesn't match the expected issuer. */
  CODE_ISSUER_MISSMATCH("Token issuer does not match");

  /** The human-readable description of the validation error. */
  private final String description;

  /**
   * Constructs a new validation error type with the specified description.
   *
   * @param description a human-readable description of the validation error
   */
  ValidationErrorType(final String description) {
    this.description = description;
  }

  /**
   * Returns the human-readable description of the validation error.
   *
   * @return the description of the validation error
   */
  @Override
  public String toString() {
    return this.description;
  }
}
