package com.corbado.sdk;

import java.net.MalformedURLException;
import java.net.URL;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Configuration class for setting up project parameters.
 *
 * <p>This class encapsulates project configuration details including project ID, API secret,
 * backend API URL, and other parameters. It provides validation for these fields and computes
 * derived properties like frontend API URL and issuer.
 */
@Slf4j
public class Config {

  // Fields

  /** API secret must begin with this prefix. */
  private static final String API_SERCRET_PREFIX = "corbado1_";

  /** Project Id must begin with this prefix. */
  private static final String PROJECT_ID_PREFIX = "pro-";

  /** The project id with custom setter. */
  @Getter private String projectId;

  /** The api secret with custom setter. */
  @Getter private String apiSecret;

  /** The backend api with custom setter. */
  @Getter private String backendApi = "https://backendapi.cloud.corbado.io/v2";

  /** The short session cookie name. */
  @Getter @Setter private String shortSessionCookieName = "cbo_short_session";

  /** The issuer. */
  @Getter @Setter private String issuer;

  /** The frontend api with custom setter. */
  @Getter private String frontendApi;

  /** The short session length for session service. Default = 300. */
  @Getter @Setter private Integer shortSessionLength = 300;

  /** Flag to cache keys in session service. Default = true. */
  @Getter @Setter boolean cacheKeys = true;

  // Constructors
  /**
   * Instantiates a new config.
   *
   * @param projectId the project id
   * @param apiSecret the api secret
   */
  public Config(final String projectId, final String apiSecret) {

    setProjectId(projectId); // set and validate
    setApiSecret(apiSecret);

    // default values
    setFrontendApi("https://" + projectId + ".frontendapi.corbado.io");
    setIssuer(this.frontendApi);
  }

  /**
   * Instantiates a new config.
   *
   * @param projectId the project id
   * @param apiSecret the api secret
   * @param backendApi the backend api
   */
  public Config(final String projectId, final String apiSecret, final String backendApi) {
    this(projectId, apiSecret);
    setBackendApi(backendApi);
  }

  // Getters and Setters
  /**
   * Sets the api secret.
   *
   * @param apiSecret the new api secret
   * @throws IllegalArgumentException If the API secret does not start with "corbado1_".
   */
  public void setApiSecret(final String apiSecret) {
    if (!apiSecret.startsWith(API_SERCRET_PREFIX)) {
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
   * Sets the project id.
   *
   * @param projectId the new project id
   * @throws IllegalArgumentException If the project Id does not start with "pro-".
   */
  public void setProjectId(final String projectId) {
    if (!projectId.startsWith(PROJECT_ID_PREFIX)) {
      throw new IllegalArgumentException(
          "Invalid project ID, must start with 'pro-', but was: " + projectId);
    }
    this.projectId = projectId;
  }
}
