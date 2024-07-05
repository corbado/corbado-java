package com.corbado.sdk;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Configuration class for setting up project parameters.
 *
 * <p>This class encapsulates project configuration details including project ID, API secret,
 * backend API URL, and other parameters. It provides validation for these fields and computes
 * derived properties like frontend API URL and issuer.
 */
public class Config {

  // Fields

  /** The project id. */
  private String projectId;

  /** The api secret. */
  private String apiSecret;

  /** The backend api. */
  private String backendApi = "https://backendapi.corbado.io";

  /** The short session cookie name. */
  private String shortSessionCookieName = "cbo_short_session";

  /** The issuer. */
  private String issuer;

  /** The frontend api. */
  private String frontendApi;

  /**
   * Instantiates a new config.
   *
   * @param projectId the project id
   * @param apiSecret the api secret
   */
  // Constructors
  public Config(final String projectId, final String apiSecret) {
    setProjectId(projectId); // set and validate
    setApiSecret(apiSecret);

    // default values
    setFrontendApi("https://" + projectId + ".frontendapi.corbado.io");
    setIssuer(this.frontendApi);
  }

  // Constructors
  public Config(final String projectId, final String apiSecret, final String backendApi) {
    this(projectId, apiSecret);
    setBackendApi(backendApi);
  }

  /**
   * Gets the api secret.
   *
   * @return the api secret
   */
  public String getApiSecret() {
    return this.apiSecret;
  }

  /**
   * Gets the backend api.
   *
   * @return the backend api
   */
  public String getBackendApi() {
    return this.backendApi;
  }

  /**
   * Gets the frontend api.
   *
   * @return the frontend api
   */
  public String getFrontendApi() {
    return this.frontendApi;
  }

  /**
   * Gets the issuer.
   *
   * @return the issuer
   */
  public String getIssuer() {
    return this.issuer;
  }

  // Getters and Setters
  /**
   * Gets the project id.
   *
   * @return the project id
   */
  public String getProjectId() {
    return this.projectId;
  }

  /**
   * Gets the short session cookie name.
   *
   * @return the short session cookie name
   */
  public String getShortSessionCookieName() {
    return this.shortSessionCookieName;
  }

  /**
   * Sets the api secret.
   *
   * @param apiSecret the new api secret
   * @throws IllegalArgumentException If the API secret does not start with "corbado1_".
   */
  public void setApiSecret(final String apiSecret) {
    if (!apiSecret.startsWith("corbado1_")) {
      throw new IllegalArgumentException(
          "Invalid API Secret, must start with 'corbado1_', but was: " + apiSecret);
    }
    this.apiSecret = apiSecret;
  }

  /**
   * Sets the backend api.
   *
   * @param backendApi the new backend api
   * @throws IllegalArgumentException If the URL is invalid.
   */
  public void setBackendApi(final String backendApi) {
    try {
      new URL(backendApi); // Validate URL syntax
    } catch (final MalformedURLException e) {
      throw new IllegalArgumentException("Invalid backend API URL: " + e.getMessage());
    }
    this.backendApi = backendApi;
  }

  /**
   * Sets the frontend api.
   *
   * @param frontendApi the new frontend api
   * @throws IllegalArgumentException If the URL is invalid.
   */
  public void setFrontendApi(final String frontendApi) {
    try {
      new URL(frontendApi); // Validate URL syntax
    } catch (final MalformedURLException e) {
      throw new IllegalArgumentException("Invalid frontend API URL: " + e.getMessage());
    }
    this.frontendApi = frontendApi;
  }

  /**
   * Sets the issuer.
   *
   * @param issuer the new issuer
   */
  public void setIssuer(final String issuer) {
    this.issuer = issuer;
  }

  /**
   * Sets the project id.
   *
   * @param projectId the new project id
   * @throws IllegalArgumentException If the project Id does not start with "pro-".
   */
  public void setProjectId(final String projectId) {
    if (!projectId.startsWith("pro-")) {
      throw new IllegalArgumentException(
          "Invalid project ID, must start with 'pro-', but was: " + projectId);
    }
    this.projectId = projectId;
  }

  /**
   * Sets the short session cookie name.
   *
   * @param shortSessionCookieName the new short session cookie name
   */
  public void setShortSessionCookieName(final String shortSessionCookieName) {
    this.shortSessionCookieName = shortSessionCookieName;
  }
}
