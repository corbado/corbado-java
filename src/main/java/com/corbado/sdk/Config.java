package com.corbado.sdk;

import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.lang3.StringUtils;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
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
@Builder
public class Config {

  /** The Constant HTTPS prefix. */
  private static final String HTTPS = "https://";

  // Fields

  /** The Constant API_VERSION. */
  private static final String API_VERSION = "2";

  /** API secret must begin with this prefix. */
  private static final String API_SERCRET_PREFIX = "corbado1_";

  /** Project Id must begin with this prefix. */
  private static final String PROJECT_ID_PREFIX = "pro-";

  /** The project id with custom setter. Must be provided. */
  @NonNull @Getter private String projectId;

  /** The api secret with custom setter. Must be provided. */
  @NonNull @Getter private String apiSecret;

  /** The backend api with custom setter. Default value: "https://backendapi.cloud.corbado.io/v2" */
  @Getter @Builder.Default private String backendApi = "https://backendapi.cloud.corbado.io/v2";

  /** The short session cookie name. Default value: "cbo_short_session" */
  @Getter @Setter @Builder.Default private String shortSessionCookieName = "cbo_short_session";

  /** The issuer. Used for session verification. */
  @Getter @Setter private String issuer;

  /** The frontend api with custom setter. */
  @Getter private String frontendApi;

  /** The short session length for session service. Default = 300. */
  @Getter @Setter @Builder.Default private Integer shortSessionLength = 300;

  /** Flag to cache keys in session service. Default = true. */
  @Getter @Setter @Builder.Default private boolean cacheKeys = true;

  /** The cname. Replaces issuer field if present. */
  @Getter @Setter private String cname;

  // Constructors
  /**
   * Instantiates a new config.
   *
   * @param projectId the project id
   * @param apiSecret the api secret
   */
  public Config(@NonNull final String projectId, @NonNull final String apiSecret) {

    setProjectId(projectId); // set and validate
    setApiSecret(apiSecret);

    // default values
    setFrontendApi(projectId);
    setIssuer(this.frontendApi);
  }

  /**
   * Instantiates a new config.
   *
   * @param projectId the project id
   * @param apiSecret the api secret
   * @param backendApi the backend api
   */
  public Config(
      @NonNull final String projectId,
      @NonNull final String apiSecret,
      @NonNull final String backendApi) {
    this(projectId, apiSecret);
    setBackendApi(backendApi);
  }

  // Custom Getters and Setters
  /**
   * Sets the api secret.
   *
   * @param apiSecret the new api secret
   * @throws IllegalArgumentException If the API secret does not start with "corbado1_".
   */
  public void setApiSecret(String apiSecret) {
    apiSecret = StringUtils.trim(apiSecret);
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
  public void setBackendApi(String backendApi) {
    backendApi = StringUtils.trim(backendApi);
    try {
      new URL(backendApi); // Validate URL syntax
    } catch (final MalformedURLException e) {
      throw new IllegalArgumentException("Invalid backend API URL: " + e.getMessage());
    }

    this.backendApi =
        StringUtils.appendIfMissing(
            backendApi, "/v" + API_VERSION); // add v2 to the end of backendApi
  }

  /**
   * Sets the frontend api.
   *
   * @param frontendApi the new frontend api
   * @throws IllegalArgumentException If the URL is invalid.
   */
  public void setFrontendApi(String frontendApi) {
    frontendApi = StringUtils.trim(frontendApi);
    frontendApi = StringUtils.prependIfMissing(frontendApi, HTTPS);
    frontendApi = StringUtils.appendIfMissing(frontendApi, ".frontendapi.corbado.io");

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
  public void setProjectId(@NonNull String projectId) {
    projectId = StringUtils.trim(projectId);
    if (!projectId.startsWith(PROJECT_ID_PREFIX)) {
      throw new IllegalArgumentException(
          "Invalid project ID, must start with 'pro-', but was: " + projectId);
    }
    this.projectId = projectId;
  }

  /**
   * Instantiates a new config.
   *
   * @param projectId the project id
   * @param apiSecret the api secret
   * @param backendApi the backend api
   * @param shortSessionCookieName the short session cookie name
   * @param issuer the issuer
   * @param frontendApi the frontend api
   * @param shortSessionLength the short session length
   * @param cacheKeys the cache keys
   * @param cname the cname
   */
  public Config(
      @NonNull final String projectId,
      @NonNull final String apiSecret,
      final String backendApi,
      final String shortSessionCookieName,
      final String issuer,
      final String frontendApi,
      final Integer shortSessionLength,
      final boolean cacheKeys,
      String cname) {

    setProjectId(projectId);
    setApiSecret(apiSecret);
    setBackendApi(backendApi);
    setShortSessionCookieName(shortSessionCookieName);
    if (StringUtils.isEmpty(frontendApi)) {
      setFrontendApi(projectId);
    } else {
      setFrontendApi(frontendApi);
    }
    setShortSessionLength(shortSessionLength);
    setCacheKeys(cacheKeys);
    setCname(cname);

    if (StringUtils.isNotEmpty(cname)) {
      cname = StringUtils.prependIfMissing(cname, HTTPS);
      // Override issuer if cname is present
      setIssuer(cname);
      // if cname is not defined, but issuer was set manually
    } else if (StringUtils.isNotEmpty(issuer)) {
      setIssuer(issuer);
    } else {
      // else use default issuer
      setIssuer(this.frontendApi);
    }
  }
}
