package com.corbado.services;

import com.corbado.exceptions.CorbadoServerException;
import com.corbado.generated.api.IdentifiersApi;
import com.corbado.generated.invoker.ApiException;
import com.corbado.generated.model.Identifier;
import com.corbado.generated.model.IdentifierCreateReq;
import com.corbado.generated.model.IdentifierList;
import com.corbado.generated.model.IdentifierStatus;
import com.corbado.generated.model.IdentifierType;
import com.corbado.generated.model.IdentifierUpdateReq;
import com.corbado.services.base.ApiService;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import lombok.NonNull;

/** This class provides functionality for managing login identifiers. */
public class IdentifierService extends ApiService<IdentifiersApi> {

  /**
   * Instantiates a new identifier service.
   *
   * @param client the client
   */
  public IdentifierService(final IdentifiersApi client) {
    super(client);
  }

  /**
   * Create a new login identifier.
   *
   * @param userID ID of user (required)
   * @param identifierCreateReq
   * @return Identifier
   * @throws CorbadoServerException If fail to call the API, e.g. server error or cannot deserialize
   *     the response body
   */
  public Identifier create(
      @NonNull final String userID, @NonNull final IdentifierCreateReq identifierCreateReq)
      throws CorbadoServerException {
    Objects.requireNonNull(
        identifierCreateReq.getIdentifierType(),
        "Required field 'IdentifierCreateReq.identifierType' in 'identifierCreateReq' cannot be null\"");
    Objects.requireNonNull(
        identifierCreateReq.getIdentifierValue(),
        "Required field 'IdentifierCreateReq.identifierValue' in 'identifierCreateReq' cannot be null\"");
    Objects.requireNonNull(
        identifierCreateReq.getStatus(),
        "Required field 'IdentifierCreateReq.status' in 'identifierCreateReq' cannot be null\"");

    try {
      return client.identifierCreate(userID, identifierCreateReq);
      //      client.identifierList(userID, null, null, null)
    } catch (final ApiException e) {
      throw new CorbadoServerException(e);
    }
  }

  /**
   * Returns a list of matching identifiers
   *
   * @param sort Field sorting (optional)
   * @param filter Field filtering (optional)
   * @param page Page number (optional, default to 1)
   * @param pageSize Number of items per page (optional, default to 10)
   * @return IdentifierList list of matching identifiers
   * @throws CorbadoServerException If fail to call the API, e.g. server error or cannot deserialize
   *     the response body
   */
  public IdentifierList list(
      @Nullable final String sort,
      @Nullable final List<String> filter,
      @Nullable final Integer page,
      @Nullable final Integer pageSize)
      throws CorbadoServerException {
    try {
      return client.identifierList(sort, filter, page, pageSize);
    } catch (final ApiException e) {
      throw new CorbadoServerException(e);
    }
  }

  /**
   * Returns a list of matching identifiers
   *
   * @param page Page number (optional, default to 1)
   * @param pageSize Number of items per page (optional, default to 10)
   * @return IdentifierList list of matching identifiers
   * @throws CorbadoServerException If fail to call the API, e.g. server error or cannot deserialize
   *     the response body
   */
  public IdentifierList listAllWithPaging(
      @Nullable final Integer page, @Nullable final Integer pageSize)
      throws CorbadoServerException {
    return list(null, null, page, pageSize);
  }

  /**
   * Gets the by value and type.
   *
   * @param value the value
   * @param type the type
   * @return the by value and type
   * @throws CorbadoServerException the corbado server exception
   */
  public IdentifierList listByValueAndType(
      @NonNull final String value, @NonNull final IdentifierType type)
      throws CorbadoServerException {
    return list(
        null,
        Arrays.asList("identifierValue:eq:" + value, "identifierType:eq:" + type),
        null,
        null);
  }

  /**
   * Gets the identifiers matching identifier value and identifier type.
   *
   * @param sort the sort
   * @param value the identifier value
   * @param type the identifier type
   * @param page the page
   * @param pageSize the page size
   * @return list of matching identifiers
   * @throws CorbadoServerException tIf fail to call the API, e.g. server error or cannot
   *     deserialize the response body
   */
  public IdentifierList listByValueAndTypeWithPaging(
      @Nullable final String sort,
      @NonNull final String value,
      @NonNull final IdentifierType type,
      @Nullable final Integer page,
      @Nullable final Integer pageSize)
      throws CorbadoServerException {
    return list(
        sort,
        Arrays.asList("identifierValue:eq:" + value, "identifierType:eq:" + type),
        page,
        pageSize);
  }

  /**
   * Exists by value and type.
   *
   * @return the identifier list
   * @throws ApiException the api exception
   * @throws CorbadoServerException If fail to call the API, e.g. server error or cannot deserialize
   *     the response body
   */
  public boolean existsByValueAndType(
      @NonNull final String value, @NonNull final IdentifierType type)
      throws CorbadoServerException {

    final IdentifierList ret =
        list(
            null,
            Arrays.asList("identifierValue:eq:" + value, "identifierType:eq:" + type),
            null,
            null);
    return !ret.getIdentifiers().isEmpty();
  }

  /**
   * List by user id with paging.
   *
   * @param userID the user ID
   * @param page the page
   * @param pageSize the page size
   * @return the identifier list
   * @throws CorbadoServerException If fail to call the API, e.g. server error or cannot deserialize
   *     the response body
   */
  // TODO: finish impl.
  public IdentifierList listAllByUserIdWithPaging(
      @NonNull final String userID, @Nullable final Integer page, @Nullable final Integer pageSize)
      throws CorbadoServerException {
    return list(null, Arrays.asList("userID:eq:" + userID), page, pageSize);
  }

  /**
   * Updates a login identifier (e.g. from pending to verified)
   *
   * @param userID ID of user (required)
   * @param identifierID ID of login identifier (required)
   * @param identifierUpdateReq (required)
   * @return Identifier
   * @throws CorbadoServerException If fail to call the API, e.g. server error or cannot deserialize
   *     the response body
   */
  public Identifier updateStatus(
      @NonNull final String userID,
      @NonNull final String identifierID,
      @NonNull final IdentifierUpdateReq identifierUpdateReq)
      throws CorbadoServerException {
    try {
      return client.identifierUpdate(userID, identifierID, identifierUpdateReq);
    } catch (final ApiException e) {
      throw new CorbadoServerException(e);
    }
  }

  /**
   * Updates a login identifier (e.g. from pending to verified)
   *
   * @param userID ID of user (required)
   * @param identifierID ID of login identifier (required)
   * @param status IdentifierStatus (required)
   * @return Identifier
   * @throws CorbadoServerException If fail to call the API, e.g. server error or cannot deserialize
   *     the response body
   */
  public Identifier updateStatus(
      @NonNull final String userID,
      @NonNull final String identifierID,
      @NonNull final IdentifierStatus status)
      throws CorbadoServerException {
    return updateStatus(userID, identifierID, new IdentifierUpdateReq().status(status));
  }
}
