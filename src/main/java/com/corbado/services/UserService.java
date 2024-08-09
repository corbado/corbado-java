package com.corbado.services;

import com.corbado.entities.UserEntity;
import com.corbado.exceptions.CorbadoServerException;
import com.corbado.generated.api.UsersApi;
import com.corbado.generated.invoker.ApiException;
import com.corbado.generated.model.UserCreateReq;
import com.corbado.generated.model.UserStatus;
import com.corbado.services.base.ApiService;
import java.util.Objects;
import javax.annotation.Nullable;
import lombok.NonNull;

/** Service for managing users. */
public class UserService extends ApiService<UsersApi> {

  /**
   * Constructor for UserService.
   *
   * @param client User API client
   */
  public UserService(final UsersApi client) {
    super(client);
  }

  /**
   * Create a user.
   *
   * @param request User create request
   * @return UserCreateRsp Response
   * @throws CorbadoServerException If any server-side error occurs.
   */
  public UserEntity create(@NonNull final UserCreateReq request) throws CorbadoServerException {
    Objects.requireNonNull(
        request.getStatus(), "Required field 'UserCreateReq.status' in 'request' cannot be null");

    try {
      return new UserEntity(client.userCreate(request));
    } catch (final ApiException e) {
      throw new CorbadoServerException(e);
    }
  }

  /**
   * Create a user.
   *
   * @param fullName the full name
   * @param status the status
   * @param explicitWebauthnID the explicit webauthn ID
   * @return the user entity
   * @throws CorbadoServerException If any server-side error occurs
   */
  public UserEntity create(
      @NonNull final String fullName,
      @NonNull final UserStatus status,
      @Nullable final String explicitWebauthnID)
      throws CorbadoServerException {

    final UserCreateReq request =
        new UserCreateReq()
            .fullName(fullName)
            .status(status)
            .explicitWebauthnID(explicitWebauthnID);
    try {
      return new UserEntity(client.userCreate(request));
    } catch (final ApiException e) {
      throw new CorbadoServerException(e);
    }
  }

  /**
   * Creates the active user by name.
   *
   * @param fullName the full name
   * @return the user entity
   * @throws CorbadoServerException If any server-side error occurs
   */
  public UserEntity createActiveByName(@NonNull final String fullName)
      throws CorbadoServerException {

    final UserCreateReq request = new UserCreateReq().fullName(fullName).status(UserStatus.ACTIVE);
    try {
      return new UserEntity(client.userCreate(request));
    } catch (final ApiException e) {
      throw new CorbadoServerException(e);
    }
  }

  /**
   * Delete user.
   *
   * @param userId the user id
   * @return the user entity
   * @throws CorbadoServerException the corbado server exception
   */
  public UserEntity delete(final String userId) throws CorbadoServerException {
    try {
      return new UserEntity(client.userDelete(userId));

    } catch (final ApiException e) {
      throw new CorbadoServerException(e);
    }
  }

  /**
   * Get user.
   *
   * @param userId User ID
   * @return UserGetRsp Response
   * @throws CorbadoServerException If any server-side error occurs.
   */
  public UserEntity get(final String userId) throws CorbadoServerException {
    try {
      return new UserEntity(client.userGet(userId));
    } catch (final ApiException e) {
      throw new CorbadoServerException(e);
    }
  }
}
