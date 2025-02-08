package com.corbado.exceptions;

import com.corbado.enums.exception.ValidationErrorType;
import lombok.Getter;

/**
 * TokenValidationException is a custom exception used to indicate issues during token validation.
 * This exception is typically thrown when the token's issuer, format, or other key attributes do
 * not meet the expected validation criteria.
 *
 * <p>This exception wraps a specific {@link ValidationErrorType} enum value to categorize the type
 * of validation error encountered, and it provides a descriptive message detailing the reason for
 * the exception. Additionally, it can wrap an underlying exception that caused the validation
 * failure, allowing for more detailed error tracing.
 *
 * <p>Typical usage includes handling invalid token attributes, such as missing or mismatched
 * issuers, empty tokens, or other validation failures.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * try {
 *     validateToken(token);
 * } catch (SomeOtherException e) {
 *     throw new TokenValidationException(ValidationErrorType.ISSUER_MISMATCH,
 *         "Issuer mismatch (configured issuer: 'expected.com', JWT issuer: 'actual.com')", e);
 * }
 * }</pre>
 *
 * @see ValidationErrorType
 */
public class TokenValidationException extends RuntimeException {

  /** The Constant serialVersionUID. */
  @Getter private static final long serialVersionUID = -2978676337061777870L;

  /** The error type. */
  @Getter private final ValidationErrorType errorType;

  /**
   * Constructs a new TokenValidationException with a specified error type, a detailed message, and
   * an optional original exception that caused this validation failure.
   *
   * @param errorType the type of validation error encountered, represented by {@link
   *     ValidationErrorType}
   * @param message a descriptive message providing additional context for the validation error
   * @param cause the original exception that caused this validation failure, if any
   */
  public TokenValidationException(
      final ValidationErrorType errorType, final String message, final Throwable cause) {
    super(message, cause);
    this.errorType = errorType;
  }

  /**
   * Constructs a new TokenValidationException with a specified error type and detailed message,
   * without an underlying cause.
   *
   * @param errorType the type of validation error encountered, represented by {@link
   *     ValidationErrorType}
   * @param message a descriptive message providing additional context for the validation error
   */
  public TokenValidationException(final ValidationErrorType errorType, final String message) {
    super(message);
    this.errorType = errorType;
  }
}
