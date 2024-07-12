package com.corbado.services;

import com.corbado.exceptions.CorbadoServerException;
import com.corbado.generated.api.UserApi;
import com.corbado.generated.invoker.ApiException;
import com.corbado.generated.model.GenericRsp;
import com.corbado.generated.model.UserCreateReq;
import com.corbado.generated.model.UserCreateRsp;
import com.corbado.generated.model.UserDeleteReq;
import com.corbado.generated.model.UserGetRsp;
import com.corbado.generated.model.UserListRsp;
import com.corbado.services.base.ApiService;
import java.util.List;

// TODO: Auto-generated Javadoc
/** Service for managing users. */
public class UserService extends ApiService<UserApi> {

  /**
   * s Constructor for UserService.
   *
   * @param client User API client
   */
  public UserService(final UserApi client) {
    super(client);
  }

  /**
   * Create a user.
   *
   * @param request User create request
   * @return UserCreateRsp Response
   * @throws CorbadoServerException If any server-side error occurs.
   */
  public UserCreateRsp create(final UserCreateReq request) throws CorbadoServerException {
    try {
      return client.userCreate(request);
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
  public GenericRsp delete(final String userId, final UserDeleteReq request)
      throws CorbadoServerException {
    try {
      return client.userDelete(userId, request);
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
  public UserGetRsp get(final String userId) throws CorbadoServerException {
    return get(userId, null, null);
  }

  /**
   * Get user.
   *
   * @param userId User ID
   * @param remoteAddr Remote address
   * @param userAgent User agent
   * @return UserGetRsp Response
   * @throws CorbadoServerException If any server-side error occurs.
   */
  public UserGetRsp get(final String userId, final String remoteAddr, final String userAgent)
      throws CorbadoServerException {
    try {
      return client.userGet(userId, remoteAddr, userAgent);
    } catch (final ApiException e) {
      throw new CorbadoServerException(e);
    }
  }

  /**
   * List users with paging.
   *
   * @param remoteAddr Remote address
   * @param userAgent User agent
   * @param sort Sort
   * @param filterArgs Filter arguments. Use null if not needed.
   * @param page Page number. Use null if not needed.
   * @param pageSize Page size. Use null if not needed.
   * @return UserListRsp Response
   * @throws CorbadoServerException If any server-side error occurs.
   * @throws IllegalArgumentException if page or pageSize <=0
   */
  public UserListRsp listUsers(
      final String remoteAddr,
      final String userAgent,
      final String sort,
      final List<String> filterArgs,
      final Integer page,
      final Integer pageSize)
      throws CorbadoServerException, IllegalArgumentException {
    try {
      if (page != null && page <= 0) {
        throw new IllegalArgumentException("age can not be <= 0");
      }
      if (pageSize != null && pageSize <= 0) {
        throw new IllegalArgumentException("Page size can not be <= 0");
      }

      return client.userList(remoteAddr, userAgent, sort, filterArgs, page, pageSize);
    } catch (final ApiException e) {
      throw new CorbadoServerException(e);
    }
  }
}
