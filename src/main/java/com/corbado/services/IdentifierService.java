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
import com.corbado.generated.model.Paging;
import com.corbado.services.base.ApiService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import lombok.NonNull;

/**
 * Service class responsible for managing user login identifiers in the Corbado system. This class
 * provides functionality for creating, updating, and managing various types of login identifiers
 * (email, phone, username) associated with user accounts.
 *
 * <p>The service supports:
 *
 * <ul>
 *   <li>Creation of new login identifiers
 *   <li>Status management of identifiers (pending, verified, primary)
 *   <li>Listing and filtering of identifiers
 *   <li>Pagination support for large result sets
 *   <li>Deletion of identifiers
 * </ul>
 *
 * <p>This service is typically used in conjunction with the UserService to manage the various ways
 * users can authenticate with the system.
 *
 * @see com.corbado.generated.model.Identifier
 * @see com.corbado.generated.model.IdentifierType
 * @see com.corbado.generated.model.IdentifierStatus
 * @see com.corbado.exceptions.CorbadoServerException
 */
public class IdentifierService extends ApiService<IdentifiersApi> {

  /** The prefix used for user IDs in the system. */
  private static String USER_ID_PREFIX = "usr-";

  /**
   * Constructs a new IdentifierService with the specified API client.
   *
   * @param client the IdentifiersApi client for making requests to the Corbado backend
   */
  public IdentifierService(final IdentifiersApi client) {
    super(client);
  }

  /**
   * Creates a new login identifier for a user.
   *
   * <p>This method creates an identifier with:
   *
   * <ul>
   *   <li>A specific type (email, phone, username)
   *   <li>A value (the actual identifier)
   *   <li>A status (pending, verified, primary)
   * </ul>
   *
   * @param userID the ID of the user to create the identifier for
   * @param identifierCreateReq the request containing identifier details
   * @return the created identifier
   * @throws CorbadoServerException if any server-side error occurs during creation
   */
  public Identifier create(
      @NonNull final String userID, @NonNull final IdentifierCreateReq identifierCreateReq)
      throws CorbadoServerException {
    // Validate required fields
    Objects.requireNonNull(
        identifierCreateReq.getIdentifierType(),
        "Required field 'IdentifierCreateReq.identifierType' in"
            + " 'identifierCreateReq' cannot be null\"");
    Objects.requireNonNull(
        identifierCreateReq.getIdentifierValue(),
        "Required field 'IdentifierCreateReq.identifierValue' in"
            + " 'identifierCreateReq' cannot be null\"");
    Objects.requireNonNull(
        identifierCreateReq.getStatus(),
        "Required field 'IdentifierCreateReq.status' in 'identifierCreateReq' cannot be null\"");

    try {
      return this.client.identifierCreate(userID, identifierCreateReq);
    } catch (final ApiException e) {
      throw new CorbadoServerException(e);
    }
  }

  /**
   * Returns a paginated list of identifiers with optional filtering and sorting.
   *
   * @param sort field to sort by (optional)
   * @param filter list of filter criteria (optional)
   * @param page page number (optional, defaults to 1)
   * @param pageSize number of items per page (optional, defaults to 10)
   * @return a list of matching identifiers with pagination information
   * @throws CorbadoServerException if any server-side error occurs during retrieval
   */
  public IdentifierList list(
      @Nullable final String sort,
      @Nullable final List<String> filter,
      @Nullable final Integer page,
      @Nullable final Integer pageSize)
      throws CorbadoServerException {
    try {
      return this.client.identifierList(sort, filter, page, pageSize);
    } catch (final ApiException e) {
      throw new CorbadoServerException(e);
    }
  }

  /**
   * Returns a paginated list of all identifiers without filtering.
   *
   * @param page page number (optional, defaults to 1)
   * @param pageSize number of items per page (optional, defaults to 10)
   * @return a list of all identifiers with pagination information
   * @throws CorbadoServerException if any server-side error occurs during retrieval
   */
  public IdentifierList listAllWithPaging(
      @Nullable final Integer page, @Nullable final Integer pageSize)
      throws CorbadoServerException {
    return list(null, null, page, pageSize);
  }

  /**
   * Retrieves identifiers matching a specific value and type.
   *
   * @param value the identifier value to search for
   * @param type the type of identifier to search for
   * @return a list of matching identifiers
   * @throws CorbadoServerException if any server-side error occurs during retrieval
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
   * Retrieves identifiers matching a specific value and type with pagination support.
   *
   * @param sort field to sort by (optional)
   * @param value the identifier value to search for
   * @param type the type of identifier to search for
   * @param page page number (optional, defaults to 1)
   * @param pageSize number of items per page (optional, defaults to 10)
   * @return a list of matching identifiers with pagination information
   * @throws CorbadoServerException if any server-side error occurs during retrieval
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
   * Checks if an identifier with the specified value and type exists.
   *
   * @param value the identifier value to check
   * @param type the type of identifier to check
   * @return true if an identifier exists with the given value and type
   * @throws CorbadoServerException if any server-side error occurs during the check
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
   * Lists all identifiers associated with a specific user with pagination support.
   *
   * @param userID the user ID (with or without 'usr-' prefix)
   * @param page page number (optional, defaults to 1)
   * @param pageSize number of items per page (optional, defaults to 10)
   * @return a list of the user's identifiers with pagination information
   * @throws CorbadoServerException if any server-side error occurs during retrieval
   */
  public IdentifierList listAllByUserIdWithPaging(
      @NonNull String userID, @Nullable final Integer page, @Nullable final Integer pageSize)
      throws CorbadoServerException {
    // Remove prefix if present for filtering
    if (userID.startsWith(USER_ID_PREFIX)) {
      userID = userID.substring(USER_ID_PREFIX.length());
    }
    return list(null, Arrays.asList("userID:eq:" + userID), page, pageSize);
  }

  /**
   * Lists all identifiers of a specific type associated with a user with pagination support.
   *
   * @param userID the user ID (with or without 'usr-' prefix)
   * @param type the type of identifier to list
   * @param page page number (optional, defaults to 1)
   * @param pageSize number of items per page (optional, defaults to 10)
   * @return a list of the user's identifiers of the specified type with pagination information
   * @throws CorbadoServerException if any server-side error occurs during retrieval
   */
  public IdentifierList listAllByUserIdAndTypeWithPaging(
      @NonNull String userID,
      @NonNull final IdentifierType type,
      @Nullable final Integer page,
      @Nullable final Integer pageSize)
      throws CorbadoServerException {
    // Remove prefix if present for filtering
    if (userID.startsWith(USER_ID_PREFIX)) {
      userID = userID.substring(USER_ID_PREFIX.length());
    }
    return list(
        null, Arrays.asList("userID:eq:" + userID, "identifierType:eq:" + type), page, pageSize);
  }

  /**
   * Retrieves all email addresses associated with a user, handling pagination automatically.
   *
   * @param userID the user ID to get email addresses for
   * @return a complete list of all email addresses associated with the user
   * @throws CorbadoServerException if any server-side error occurs during retrieval
   */
  public List<Identifier> listAllEmailsByUserId(@NonNull final String userID)
      throws CorbadoServerException {
    final ArrayList<Identifier> list = new ArrayList<>();
    final IdentifierList firstRes =
        listAllByUserIdAndTypeWithPaging(userID, IdentifierType.EMAIL, null, null);
    list.addAll(firstRes.getIdentifiers());
    final Paging paging = firstRes.getPaging();

    // Fetch all remaining pages if they exist
    while (paging.getPage() < paging.getTotalPages()) {
      final Integer currentPage = paging.getPage();
      paging.setPage(currentPage + 1);
      final IdentifierList temp =
          listAllByUserIdAndTypeWithPaging(userID, IdentifierType.EMAIL, paging.getPage(), null);
      list.addAll(temp.getIdentifiers());
    }

    return list;
  }

  /**
   * Updates the status of a login identifier.
   *
   * @param userID the ID of the user who owns the identifier
   * @param identifierID the ID of the identifier to update
   * @param identifierUpdateReq the update request containing the new status
   * @return the updated identifier
   * @throws CorbadoServerException if any server-side error occurs during the update
   */
  public Identifier updateStatus(
      @NonNull final String userID,
      @NonNull final String identifierID,
      @NonNull final IdentifierUpdateReq identifierUpdateReq)
      throws CorbadoServerException {
    try {
      return this.client.identifierUpdate(userID, identifierID, identifierUpdateReq);
    } catch (final ApiException e) {
      throw new CorbadoServerException(e);
    }
  }

  /**
   * Updates the status of a login identifier using a simplified interface.
   *
   * @param userID the ID of the user who owns the identifier
   * @param identifierID the ID of the identifier to update
   * @param status the new status to set for the identifier
   * @return the updated identifier
   * @throws CorbadoServerException if any server-side error occurs during the update
   */
  public Identifier updateStatus(
      @NonNull final String userID,
      @NonNull final String identifierID,
      @NonNull final IdentifierStatus status)
      throws CorbadoServerException {
    return updateStatus(userID, identifierID, new IdentifierUpdateReq().status(status));
  }

  /**
   * Deletes a login identifier from a user's account.
   *
   * @param userID the ID of the user who owns the identifier
   * @param identifierID the ID of the identifier to delete
   * @throws CorbadoServerException if any server-side error occurs during deletion
   */
  public void delete(@NonNull final String userID, @NonNull final String identifierID)
      throws CorbadoServerException {
    try {
      this.client.identifierDelete(userID, identifierID);
    } catch (final ApiException e) {
      throw new CorbadoServerException(e);
    }
  }
}
