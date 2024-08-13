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
 * Gets or Sets passkeyChallengeStatus
 */
@JsonAdapter(PasskeyChallengeStatus.Adapter.class)
public enum PasskeyChallengeStatus {
  
  PENDING("pending"),
  
  COMPLETED("completed"),
  
  CONSUMED("consumed");

  private String value;

  PasskeyChallengeStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static PasskeyChallengeStatus fromValue(String value) {
    for (PasskeyChallengeStatus b : PasskeyChallengeStatus.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<PasskeyChallengeStatus> {
    @Override
    public void write(final JsonWriter jsonWriter, final PasskeyChallengeStatus enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public PasskeyChallengeStatus read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return PasskeyChallengeStatus.fromValue(value);
    }
  }

  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
    String value = jsonElement.getAsString();
    PasskeyChallengeStatus.fromValue(value);
  }
}
