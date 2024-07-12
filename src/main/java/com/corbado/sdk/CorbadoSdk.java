package com.corbado.sdk;

import com.corbado.exceptions.StandardException;
import com.corbado.generated.api.UserApi;
import com.corbado.generated.invoker.ApiClient;
import com.corbado.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/** The Class CorbadoSdk. */
public class CorbadoSdk {

  /** The Constant CORBADO_HEADER_NAME. */
  private static final String CORBADO_HEADER_NAME = "X-Corbado-SDK";

  /** The configuration class. */
  @Getter @Setter private Config config;

  /** The user API. */
  @Getter(lazy = true)
  private final UserService users = new UserService(new UserApi(this.client));

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
    tempClient.setApiKey(this.config.getProjectId());

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
  // TODO: add language version
  private String getLanguageVersion() {
    return "1.8";
  }

  /**
   * Gets the version.
   *
   * @return the version
   */
  // TODO: sdk version
  public String getVersion() {
    return "1.0.0";
  }
}
