package com.corbado.enums.exception;

import com.corbado.exceptions.TokenValidationException;

/** Enum representing error types for {@link TokenValidationException}. */
public enum ValidationErrorType {

  /** The invalid token. */
  INVALID_TOKEN("Invalid token"),

  /** The signing key error. */
  SIGNING_KEY_ERROR("Could not retrieve signing key"),

  /** The empty session token. */
  EMPTY_SESSION_TOKEN("Session token is empty"),

  /** The empty issuer. */
  EMPTY_ISSUER("Issuer is empty"),

  /** The issuer missmatch. */
  ISSUER_MISSMATCH("Token issuer does not match");

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
    return description;
  }
}
