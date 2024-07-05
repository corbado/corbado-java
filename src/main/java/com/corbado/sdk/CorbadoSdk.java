package com.corbado.sdk;

import java.util.HashMap;
import java.util.Map;

import com.corbado.exceptions.StandardException;
import com.corbado.generated.api.UserApi;
import com.corbado.generated.invoker.ApiClient;
import com.corbado.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/** The Class CorbadoSdk. */
public class CorbadoSdk {

  public static final String CORBADO_HEADER_NAME = "X-Corbado-SDK";

  /** The configuration class. */
  private Config config;

  private UserService users;

  private ApiClient client;

  public CorbadoSdk(final Config config) throws StandardException {
    this.config = config;
    initializeClient();
  }

  // Getters
  /**
   * Gets the config.
   *
   * @return the config
   */
  public Config getConfig() {
    return config;
  }

  // TODO: add language version
  private String getLanguageVersion() {
    return "1.8";
  }

  public UserService getUsers() {
    if (users == null) {
      this.users = new UserService(new UserApi(client));
    }
    return users;
  }

  // TODO: sdk version
  private String getVersion() {
    return "1.0.0";
  }

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

  // Setters
  /**
   * Sets the config.
   *
   * @param config the new config
   */
  public void setConfig(final Config config) {
    this.config = config;
  }
}
