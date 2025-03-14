package com.corbado.sdk;

import com.corbado.exceptions.StandardException;
import com.corbado.generated.api.IdentifiersApi;
import com.corbado.generated.api.UsersApi;
import com.corbado.generated.invoker.ApiClient;
import com.corbado.services.IdentifierService;
import com.corbado.services.SessionService;
import com.corbado.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * Main entry point for the Corbado SDK.
 *
 * <p>This class serves as the central hub for interacting with the Corbado authentication system.
 * It provides access to all major services including user management, session handling, and
 * identifier management.
 *
 * <p>The SDK supports:
 *
 * <ul>
 *   <li>User management (creation, retrieval, deletion)
 *   <li>Session handling and validation
 *   <li>Login identifier management
 *   <li>Automatic API client configuration
 *   <li>Version tracking and reporting
 * </ul>
 *
 * <p>It automatically handles API client initialization, authentication, and service management.
 *
 * @see com.corbado.services.UserService
 * @see com.corbado.services.SessionService
 * @see com.corbado.services.IdentifierService
 * @see com.corbado.sdk.Config
 */
@Slf4j
public class CorbadoSdk {

  /** The current version of the SDK. */
  private static final String CURRENT_SDK_VERSION = "2.0.0b";

  /** The header name used to identify SDK requests. */
  private static final String CORBADO_HEADER_NAME = "X-Corbado-SDK";

  /** The configuration instance containing all SDK settings. */
  @Getter private final Config config;

  /** The user management service. Lazily initialized. */
  @Getter(lazy = true)
  private final UserService users = new UserService(new UsersApi(this.client));

  /** The identifier management service. Lazily initialized. */
  @Getter(lazy = true)
  private final IdentifierService identifiers =
      new IdentifierService(new IdentifiersApi(this.client));

  /** The session management service. Lazily initialized. */
  @Getter(lazy = true)
  private final SessionService sessions = new SessionService(this.config);

  /** The API client used for making requests to the Corbado backend. */
  private ApiClient client;

  /**
   * Constructs a new CorbadoSdk instance with the specified configuration.
   *
   * <p>This constructor initializes the SDK with the provided configuration and sets up the API
   * client with proper authentication and headers.
   *
   * @param config the configuration object containing all necessary settings
   * @throws StandardException if there is an error initializing the API client
   */
  public CorbadoSdk(final @NonNull Config config) throws StandardException {
    this.config = config;
    initializeClient();
  }

  /**
   * Initializes the API client with proper configuration and headers.
   *
   * <p>This method sets up the API client with:
   *
   * <ul>
   *   <li>Base URL from configuration
   *   <li>Authentication credentials
   *   <li>SDK version information
   *   <li>Language version information
   * </ul>
   *
   * @throws StandardException if there is an error setting up the API clients
   */
  private void initializeClient() throws StandardException {
    final ApiClient tempClient = new ApiClient();

    tempClient.setBasePath(this.config.getBackendApi());
    tempClient.setUsername(this.config.getProjectId());
    tempClient.setPassword(this.config.getApiSecret());
    // Additional info for requests
    final Map<String, String> data = new HashMap<>();
    data.put("name", "Java SDK");
    data.put("sdkVersion", getVersion());
    data.put("languageVersion", getLanguageVersion());

    final ObjectMapper objectMapper = new ObjectMapper();
    try {
      final String headerValue = objectMapper.writeValueAsString(data);
      tempClient.addDefaultHeader(CORBADO_HEADER_NAME, headerValue);
    } catch (final JsonProcessingException e) {
      throw new StandardException(e.getMessage());
    }

    this.client = tempClient;
  }

  /**
   * Gets the current Java runtime version.
   *
   * <p>This method retrieves the Java version from the system properties. In the extremely unlikely
   * case that the "java.version" property is not set, it will return "unknown" instead of null.
   *
   * @return the Java version string, or "unknown" if the version cannot be determined
   */
  private static String getLanguageVersion() {
    final String version = System.getProperty("java.version");
    return version != null ? version : "unknown";
  }

  /**
   * Gets the current version of the SDK.
   *
   * @return the SDK version string
   */
  public static String getVersion() {
    return CURRENT_SDK_VERSION;
  }
}
