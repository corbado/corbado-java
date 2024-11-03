package com.corbado.enums.exception;

import com.corbado.exceptions.TokenValidationException;

/** Enum representing error types for {@link TokenValidationException}. */
public enum ValidationErrorType {

  /** The invalid token. */
  CODE_INVALID_TOKEN("Invalid token"),

  /** The empty session token. */
  CODE_EMPTY_SESSION_TOKEN("Session token is empty"),

  /** The empty issuer. */
  CODE_EMPTY_ISSUER("Issuer is empty"),

  CODE_JWT_BEFORE("Token is not valid yet"),

  CODE_JWT_EXPIRED("Token is expired"),

  CODE_INVALID_PUBLIC_KEY("Public key is invalid"),

  CODE_JWT_INVALID_SIGNATURE("Token signature is invalid"),

  /** The issuer missmatch. */
  CODE_ISSUER_MISSMATCH("Token issuer does not match");

  /** The description. */
  private final String description;

  /**
   * Instantiates a new validation error type.
   *
   * @param description the description
   */
  ValidationErrorType(final String description) {
    this.description = description;
  }

  /**
   * To string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return this.description;
  }
}
