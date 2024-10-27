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
 * Entry point for the Corbado SDK.
 *
 * <p>This class provides interfaces to interact with the Corbado API, including user, session and
 * identifier services.
 */
@Slf4j
public class CorbadoSdk {

  private static final String CURRENT_SDK_VERSION = "2.0.0";

  /** The Constant CORBADO_HEADER_NAME. */
  private static final String CORBADO_HEADER_NAME = "X-Corbado-SDK";

  /** The configuration class. */
  @Getter private final Config config;

  /** The users API. */
  @Getter(lazy = true)
  private final UserService users = new UserService(new UsersApi(this.client));

  /** The identifiers API. */
  @Getter(lazy = true)
  private final IdentifierService identifiers =
      new IdentifierService(new IdentifiersApi(this.client));

  /** The sessions API. */
  @Getter(lazy = true)
  private final SessionService sessions = new SessionService(this.config);

  /** The client. */
  private ApiClient client;

  /**
   * Instantiates a new corbado sdk.
   *
   * @param config the config
   * @throws StandardException the standard exception
   */
  public CorbadoSdk(final @NonNull Config config) throws StandardException {
    this.config = config;
    initializeClient();
  }

  /**
   * Initialize client.
   *
   * @throws StandardException the standard exception
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

  // Getters

  /**
   * Gets the language version.
   *
   * @return the language version
   */
  private static String getLanguageVersion() {
    return System.getProperty("java.version");
  }

  /**
   * Gets the version.
   *
   * @return the version
   */
  public static String getVersion() {
    return CURRENT_SDK_VERSION;
  }
}
