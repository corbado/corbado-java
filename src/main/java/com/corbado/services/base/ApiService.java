package com.corbado.services.base;

/**
 * Abstract service for interaction with backend API.
 */
public abstract class ApiService<T> {
  /**
   * Client for API interactions.
   */
  protected T client;

  protected ApiService(final T client) {
    super();
    this.client = client;
  }


}
