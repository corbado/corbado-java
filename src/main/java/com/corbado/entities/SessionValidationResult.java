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
@Builder
public class SessionValidationResult {

  /** Indicates success of validation by session service. */
  @Builder.Default boolean authenticated = false;

  /** The user ID. */
  private String userID;

  /** The full name. */
  private String fullName;
}
