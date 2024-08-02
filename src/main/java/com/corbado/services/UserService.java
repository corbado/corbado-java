package com.corbado.services;

import com.corbado.entities.UserEntity;
import com.corbado.exceptions.CorbadoServerException;
import com.corbado.generated.api.UsersApi;
import com.corbado.generated.invoker.ApiException;
import com.corbado.generated.model.UserCreateReq;
import com.corbado.services.base.ApiService;

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
  public UserEntity create(final UserCreateReq request) throws CorbadoServerException {
    try {
      return new UserEntity(client.userCreate(request));
    } catch (final ApiException e) {
      throw new CorbadoServerException(e);
    }
  }

  /**
   * Delete user.
   *
   * @param userId User ID
   * @param request Request
   * @return GenericRsp Response
   * @throws CorbadoServerException If any server-side error occurs.
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
