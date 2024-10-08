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
 * Gets or Sets authEventMethod
 */
@JsonAdapter(AuthEventMethod.Adapter.class)
public enum AuthEventMethod {
  
  PASSWORD("password"),
  
  EMAIL_OTP("email_otp"),
  
  EMAIL_LINK("email_link"),
  
  PHONE_OTP("phone_otp"),
  
  PASSKEY("passkey"),
  
  SOCIAL_GITHUB("social_github"),
  
  SOCIAL_GOOGLE("social_google"),
  
  SOCIAL_MICROSOFT("social_microsoft");

  private String value;

  AuthEventMethod(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static AuthEventMethod fromValue(String value) {
    for (AuthEventMethod b : AuthEventMethod.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<AuthEventMethod> {
    @Override
    public void write(final JsonWriter jsonWriter, final AuthEventMethod enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public AuthEventMethod read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return AuthEventMethod.fromValue(value);
    }
  }

  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
    String value = jsonElement.getAsString();
    AuthEventMethod.fromValue(value);
  }
}

