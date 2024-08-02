package com.corbado.entities;

import com.corbado.generated.model.User;
import com.corbado.generated.model.UserStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/** The wrapper around generated {@link User} class to be used by SDK. */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserEntity extends User {

  /**
   * Instantiates a new user entity.
   *
   * @param authenticated the authenticated
   */
  public UserEntity(
      @NonNull final String userID,
      final String explicitWebauthnID,
      final String fullName,
      final UserStatus status) {

    setUserID(userID);
    setExplicitWebauthnID(explicitWebauthnID);
    setFullName(fullName);
    setStatus(status);
  }

  /**
   * Instantiates a new user entity.
   *
   * @param user the user
   */
  public UserEntity(final User user) {
    this(user.getUserID(), user.getExplicitWebauthnID(), user.getFullName(), user.getStatus());
  }
}
