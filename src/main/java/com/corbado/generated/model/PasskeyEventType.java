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
 * Gets or Sets passkeyEventType
 */
@JsonAdapter(PasskeyEventType.Adapter.class)
public enum PasskeyEventType {
  
  USER_LOGIN_BLACKLISTED("user-login-blacklisted"),
  
  LOGIN_EXPLICIT_ABORT("login-explicit-abort"),
  
  LOGIN_ERROR("login-error"),
  
  LOGIN_ERROR_UNTYPED("login-error-untyped"),
  
  LOGIN_ONE_TAP_SWITCH("login-one-tap-switch"),
  
  USER_APPEND_AFTER_CROSS_PLATFORM_BLACKLISTED("user-append-after-cross-platform-blacklisted"),
  
  USER_APPEND_AFTER_LOGIN_ERROR_BLACKLISTED("user-append-after-login-error-blacklisted"),
  
  APPEND_CREDENTIAL_EXISTS("append-credential-exists"),
  
  APPEND_EXPLICIT_ABORT("append-explicit-abort"),
  
  APPEND_ERROR("append-error");

  private String value;

  PasskeyEventType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static PasskeyEventType fromValue(String value) {
    for (PasskeyEventType b : PasskeyEventType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<PasskeyEventType> {
    @Override
    public void write(final JsonWriter jsonWriter, final PasskeyEventType enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public PasskeyEventType read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return PasskeyEventType.fromValue(value);
    }
  }

  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
    String value = jsonElement.getAsString();
    PasskeyEventType.fromValue(value);
  }
}

