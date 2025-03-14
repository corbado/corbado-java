package com.corbado.sdk;

import java.net.MalformedURLException;
import java.net.URL;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * Configuration class for setting up project parameters in the Corbado SDK.
 *
 * <p>This class encapsulates all configuration details required to initialize and use the Corbado
 * SDK, including project identification, API credentials, and service endpoints. It provides
 * validation for these fields and computes derived properties like frontend API URL and issuer.
 *
 * <p>The configuration supports:
 *
 * <ul>
 *   <li>Project identification with project ID and API secret
 *   <li>Custom API endpoints for frontend and backend services
 *   <li>Session token configuration
 *   <li>Custom domain (CNAME) support
 *   <li>JWKS caching configuration
 * </ul>
 *
 * <p>All mandatory fields are validated during initialization to ensure proper SDK operation.
 *
 * @see com.corbado.sdk.CorbadoSdk
 * @see com.corbado.services.SessionService
 */
@Slf4j
@Builder
public class Config {

  /** The HTTPS protocol prefix used for secure connections. */
  private static final String HTTPS = "https://";

  /** The current version of the Corbado API. */
  private static final String API_VERSION = "2";

  /** The required prefix for API secrets. */
  private static final String API_SERCRET_PREFIX = "corbado1_";

  /** The required prefix for project IDs. */
  private static final String PROJECT_ID_PREFIX = "pro-";

  // ---------- Mandatory fields ----------
  /** The project ID used to identify the project in the Corbado system. Must start with "pro-". */
  @NonNull @Getter private String projectId;

  /** The API secret used for authentication. Must start with "corbado1_". */
  @NonNull @Getter private String apiSecret;

  /** The frontend API endpoint URL. Used for client-side operations. */
  @Getter private String frontendApi;

  /** The backend API endpoint URL. Used for server-side operations. */
  @Getter private String backendApi;

  // ---------- Non-mandatory fields ----------
  /** The issuer URL used for session verification. Defaults to frontend API if not specified. */
  @Getter @Setter private String issuer;

  /**
   * The lifetime duration for session service tokens in seconds. Defaults to 300 seconds (5
   * minutes).
   */
  @Getter @Setter @Builder.Default private Integer sessionTokenLength = 300;

  /** Whether to cache JWKS keys in the session service. Defaults to true for better performance. */
  @Getter @Setter @Builder.Default private boolean cacheKeys = true;

  /** The custom domain (CNAME) that replaces the issuer field if present. */
  @Getter @Setter private String cname;

  /**
   * Sets the API secret with validation.
   *
   * @param apiSecret the new API secret to set
   * @throws IllegalArgumentException if the API secret is null or doesn't start with "corbado1_"
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
   * Sets the backend API URL with validation and version suffix.
   *
   * @param backendApi the new backend API URL to set
   * @throws IllegalArgumentException if the URL is invalid
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
   * Sets the frontend API URL with validation.
   *
   * @param frontendApi the new frontend API URL to set
   * @throws IllegalArgumentException if the URL is invalid
   */
  public void setFrontendApi(String frontendApi) {
    frontendApi = StringUtils.trim(frontendApi);

    try {
      new URL(frontendApi); // Validate URL syntax
    } catch (final MalformedURLException e) {
      throw new IllegalArgumentException("Invalid frontend API URL: " + e.getMessage());
    }
    this.frontendApi = frontendApi;
  }

  /**
   * Sets the project ID with validation.
   *
   * @param projectId the new project ID to set
   * @throws IllegalArgumentException if the project ID is null or doesn't start with "pro-"
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
   * Constructs a new Config instance with all parameters.
   *
   * <p>This constructor initializes all configuration fields and performs necessary validations.
   * The issuer is set based on the following priority:
   *
   * <ol>
   *   <li>CNAME if provided
   *   <li>Explicit issuer if provided
   *   <li>Frontend API URL as fallback
   * </ol>
   *
   * @param projectId the project ID (required)
   * @param apiSecret the API secret (required)
   * @param frontendApi the frontend API URL (optional)
   * @param backendApi the backend API URL (optional)
   * @param issuer the issuer URL (optional)
   * @param sessionTokenLength the session token lifetime in seconds (optional)
   * @param cacheKeys whether to cache JWKS keys (optional)
   * @param cname the custom domain (optional)
   * @throws IllegalArgumentException if any required field validation fails
   */
  public Config(
      @NonNull String projectId,
      @NonNull String apiSecret,
      String frontendApi,
      String backendApi,
      String issuer,
      Integer sessionTokenLength,
      boolean cacheKeys,
      String cname) {
    setProjectId(projectId);
    setApiSecret(apiSecret);
    setBackendApi(backendApi);
    setFrontendApi(frontendApi);

    setSessionTokenLength(sessionTokenLength);
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
