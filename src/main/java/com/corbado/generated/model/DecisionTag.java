/*
 * Corbado Backend API
 *  # Introduction This documentation gives an overview of all Corbado Backend API calls to implement passwordless authentication with Passkeys. 
 *
 * The version of the OpenAPI document: 2.0.0
 * Contact: support@corbado.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.corbado.generated.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.JsonElement;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * Gets or Sets decisionTag
 */
@JsonAdapter(DecisionTag.Adapter.class)
public enum DecisionTag {
  
  ENV_NO_PK_SUPPORT("env-no-pk-support"),
  
  USER_NO_PKS("user-no-pks"),
  
  USER_LOGIN_BLACKLISTED("user-login-blacklisted"),
  
  USER_SECURITY_KEY("user-security-key"),
  
  USER_POSITIVE_ENV_HISTORY("user-positive-env-history"),
  
  USER_NEGATIVE_ENV_HISTORY("user-negative-env-history"),
  
  ENV_BLACKLISTED("env-blacklisted"),
  
  USER_PLATFORM_PK_HIGH_CONFIDENCE("user-platform-pk-high-confidence"),
  
  USER_CROSS_PLATFORM_PK_HIGH_CONFIDENCE("user-cross-platform-pk-high-confidence"),
  
  USER_ENV_NO_PKS("user-env-no-pks"),
  
  DEFAULT_DENY("default-deny"),
  
  PASSKEY_LIST_INITIATED_PROCESS("passkey-list-initiated-process"),
  
  USER_APPEND_BLACKLISTED("user-append-blacklisted"),
  
  PROCESS_PK_LOGIN_SK_COMPLETED("process-pk-login-sk-completed"),
  
  PROCESS_PK_LOGIN_PLATFORM_COMPLETED("process-pk-login-platform-completed"),
  
  PROCESS_PK_LOGIN_NOT_OFFERED("process-pk-login-not-offered"),
  
  PROCESS_PK_LOGIN_INCOMPLETE("process-pk-login-incomplete"),
  
  PROCESS_PK_LOGIN_CROSS_PLATFORM_COMPLETED("process-pk-login-cross-platform-completed");

  private String value;

  DecisionTag(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static DecisionTag fromValue(String value) {
    for (DecisionTag b : DecisionTag.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<DecisionTag> {
    @Override
    public void write(final JsonWriter jsonWriter, final DecisionTag enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public DecisionTag read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return DecisionTag.fromValue(value);
    }
  }

  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
    String value = jsonElement.getAsString();
    DecisionTag.fromValue(value);
  }
}
