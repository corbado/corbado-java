package com.corbado.exceptions;

import com.corbado.generated.invoker.ApiException;

/** Custom exception class for server-related errors. */
// TODO: Complete
public class CorbadoServerException extends Exception {

  private static final long serialVersionUID = 5970919574670247150L;

  private final int httpStatusCode;
  private final String body;

  /**
   * Convert ApiException to ServerException.
   *
   * @param e ApiException to be converted
   * @throws StandardException If response body is not a string
   */
  public CorbadoServerException(final ApiException e) {
    this(e.getCode(), e.getResponseBody());
  }

  public CorbadoServerException(final int statusCode, final String body) {
    httpStatusCode = statusCode;
    this.body = body;
  }

  public String getBody() {
    return body;
  }

  public int getHttpStatusCode() {
    return httpStatusCode;
  }
}
