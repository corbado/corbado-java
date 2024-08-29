package com.corbado.exceptions;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.corbado.generated.invoker.ApiException;
import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/** Custom exception class for server-related errors. */
@ToString
public class CorbadoServerException extends Exception {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 5970919574670247150L;

  /** The http status code. */
  @Getter private final int httpStatusCode;

  /** The body. */
  @NonNull @Getter private final ErrorResponse errorResponse;

  /**
   * Convert ApiException to ServerException.
   *
   * @param e ApiException to be converted
   * @throws StandardException If response body is not a string
   */
  public CorbadoServerException(@NonNull final ApiException e) {
    this(e.getCode(), e.getResponseBody());
  }

  /**
   * Instantiates a new corbado server exception.
   *
   * @param statusCode the status code
   * @param body the body
   */
  public CorbadoServerException(final int statusCode, final String body) {
    final Gson gson = new Gson();
    this.httpStatusCode = statusCode;
    this.errorResponse = gson.fromJson(body, ErrorResponse.class);
  }

  /**
   * Gets the request id.
   *
   * @return the request id
   */
  public String getRequestId() {
    final Optional<String> requestId =
        Optional.ofNullable(this.errorResponse)
            .map(ErrorResponse::getRequestData)
            .map(RequestData::getRequestID);

    if (requestId.isPresent()) {
      return requestId.get();
    }
    // requestId should always be present
    return null;
  }

  /**
   * Gets the validation messages.
   *
   * @return the validation messages
   */
  public List<ValidationMessage> getValidationMessages() {
    final Optional<List<ValidationMessage>> validationMessages =
        Optional.ofNullable(this.errorResponse)
            .map(ErrorResponse::getError)
            .map(ErrorDetails::getValidation);

    if (validationMessages.isPresent()) {
      return validationMessages.get();
    }
    return Collections.emptyList();
  }

  /** The Class ErrorResponse. */
  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public static class ErrorResponse {

    /** The error. */
    private ErrorDetails error;

    /** The http status code. */
    private int httpStatusCode;

    /** The request data. */
    private RequestData requestData;

    /** The runtime. */
    private double runtime;
  }

  /** The Class ErrorDetails. */
  @Data
  @AllArgsConstructor
  public static class ErrorDetails {

    /** The links. */
    private List<String> links;

    /** The type. */
    private String type;

    /** The validation. */
    private List<ValidationMessage> validation;
  }

  /** The Class ValidationDetails. */
  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public static class ValidationMessage {

    /** The field. */
    private String field;

    /** The message. */
    private String message;
  }

  /** The Class RequestData. */
  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public static class RequestData {

    /** The link. */
    private String link;

    /** The request ID. */
    private String requestID;
  }
}
