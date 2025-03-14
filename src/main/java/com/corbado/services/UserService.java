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

/**
 * Service class responsible for managing user operations in the Corbado system. This class provides
 * functionality for creating and managing user accounts, including their status and authentication
 * details.
 *
 * <p>The service supports:
 *
 * <ul>
 *   <li>User creation with custom status
 *   <li>WebAuthn integration for passwordless authentication
 *   <li>User status management
 * </ul>
 *
 * <p>This service is typically used in conjunction with the Corbado authentication system to manage
 * user accounts and their authentication methods.
 *
 * @see com.corbado.entities.UserEntity
 * @see com.corbado.generated.model.UserStatus
 * @see com.corbado.exceptions.CorbadoServerException
 */
public class UserService extends ApiService<UsersApi> {

  /**
   * Constructor for UserService.
   *
   * @param client User API client for making requests to the Corbado backend
   */
  public UserService(final UsersApi client) {
    super(client);
  }

  /**
   * Creates a new user in the system with the specified parameters.
   *
   * <p>This method creates a user with:
   *
   * <ul>
   *   <li>A full name for display purposes
   *   <li>A status indicating their account state
   *   <li>Optional WebAuthn ID for passwordless authentication
   * </ul>
   *
   * @param fullName the user's full name for display purposes
   * @param status the initial status of the user account
   * @param explicitWebauthnID optional WebAuthn ID for passwordless authentication
   * @return the created user entity
   * @throws CorbadoServerException if any server-side error occurs during user creation
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
      return new UserEntity(this.client.userCreate(request));
    } catch (final ApiException e) {
      throw new CorbadoServerException(e);
    }
  }

  /**
   * Creates a new user in the system using a predefined request object.
   *
   * <p>This method allows for more flexible user creation by accepting a complete request object
   * that can include additional parameters not available in the simplified create method.
   *
   * @param request the complete user creation request containing all necessary parameters
   * @return the created user response
   * @throws CorbadoServerException if any server-side error occurs during user creation
   */
  public UserEntity create(@NonNull final UserCreateReq request) throws CorbadoServerException {
    Objects.requireNonNull(
        request.getStatus(), "Required field 'UserCreateReq.status' in 'request' cannot be null");

    try {
      return new UserEntity(this.client.userCreate(request));
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
      return new UserEntity(this.client.userCreate(request));
    } catch (final ApiException e) {
      throw new CorbadoServerException(e);
    }
  }

  /**
   * Delete user.
   *
   * @param userId the user id
   * @throws CorbadoServerException exception thrown on error or if user is not found.
   */
  public void delete(@NonNull final String userId) throws CorbadoServerException {
    try {
      this.client.userDelete(userId);

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
  public UserEntity get(@NonNull final String userId) throws CorbadoServerException {
    try {
      return new UserEntity(this.client.userGet(userId));
    } catch (final ApiException e) {
      throw new CorbadoServerException(e);
    }
  }
}
