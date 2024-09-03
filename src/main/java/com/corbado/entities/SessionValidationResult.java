package com.corbado.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** Result class for SessionService validation. */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

/**
 * The Class SessionValidationResultBuilder.
 */
@Builder
public class SessionValidationResult {

  /** The user ID. */
  private String userID;

  /** The full name. */
  private String fullName;

  /** The error. */
  private Exception error;
}
