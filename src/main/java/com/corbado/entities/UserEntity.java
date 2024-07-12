package com.corbado.entities;

import com.corbado.exceptions.StandardException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** The Class UserEntity. */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {

  /** Text response in case the user is not authenticated. */
  public static final String NO_AUTH = "User is not authenticated";

  /** Is user authenticated. */
  private boolean authenticated;

  /** The user id. */
  @Builder.Default private String userId = "";

  /** The name. */
  @Builder.Default private String name = "";

  /** The email. */
  @Builder.Default private String email = "";

  /** The phone number. */
  @Builder.Default private String phoneNumber = "";

  /**
   * Gets the user id.
   *
   * @return the user id
   * @throws StandardException the standard exception
   */
  public String getUserId() throws StandardException {
    if (!authenticated) {
      throw new StandardException(NO_AUTH);
    }
    return userId;
  }

  /**
   * Gets the name.
   *
   * @return the name
   * @throws StandardException the standard exception
   */
  public String getName() throws StandardException {
    if (!authenticated) {
      throw new StandardException(NO_AUTH);
    }
    return name;
  }

  /**
   * Gets the email.
   *
   * @return the email
   * @throws StandardException the standard exception
   */
  public String getEmail() throws StandardException {
    if (!authenticated) {
      throw new StandardException(NO_AUTH);
    }
    return email;
  }

  /**
   * Gets the phone number.
   *
   * @return the phone number
   * @throws StandardException the standard exception
   */
  public String getPhoneNumber() throws StandardException {
    if (!authenticated) {
      throw new StandardException(NO_AUTH);
    }
    return phoneNumber;
  }

  /**
   * Creates the authenticated user.
   *
   * @param userId the user id
   * @param name the name
   * @param email the email
   * @param phoneNumber the phone number
   * @return the user entity
   */
  public static UserEntity createAuthenticatedUser(
      final String userId, final String name, final String email, final String phoneNumber) {
    return UserEntity.builder()
        .name(name)
        .authenticated(true)
        .userId(userId)
        .email(email)
        .phoneNumber(phoneNumber)
        .build();
  }
}
