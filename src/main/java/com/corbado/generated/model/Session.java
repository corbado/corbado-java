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
import com.corbado.generated.model.SessionStatus;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.corbado.generated.invoker.JSON;

/**
 * Session
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-14T05:38:33.191503012Z[Etc/UTC]", comments = "Generator version: 7.13.0-SNAPSHOT")
public class Session {
  public static final String SERIALIZED_NAME_SESSION_I_D = "sessionID";
  @SerializedName(SERIALIZED_NAME_SESSION_I_D)
  @javax.annotation.Nonnull
  private String sessionID;

  public static final String SERIALIZED_NAME_USER_I_D = "userID";
  @SerializedName(SERIALIZED_NAME_USER_I_D)
  @javax.annotation.Nonnull
  private String userID;

  public static final String SERIALIZED_NAME_IDENTIFIER_VALUE = "identifierValue";
  @SerializedName(SERIALIZED_NAME_IDENTIFIER_VALUE)
  @javax.annotation.Nonnull
  private String identifierValue;

  public static final String SERIALIZED_NAME_CREATED_MS = "createdMs";
  @SerializedName(SERIALIZED_NAME_CREATED_MS)
  @javax.annotation.Nonnull
  private Long createdMs;

  public static final String SERIALIZED_NAME_LAST_ACTION_MS = "lastActionMs";
  @SerializedName(SERIALIZED_NAME_LAST_ACTION_MS)
  @javax.annotation.Nonnull
  private Long lastActionMs;

  public static final String SERIALIZED_NAME_EXPIRES_MS = "expiresMs";
  @SerializedName(SERIALIZED_NAME_EXPIRES_MS)
  @javax.annotation.Nonnull
  private Long expiresMs;

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  @javax.annotation.Nonnull
  private SessionStatus status;

  public Session() {
  }

  public Session sessionID(@javax.annotation.Nonnull String sessionID) {
    this.sessionID = sessionID;
    return this;
  }

  /**
   * Get sessionID
   * @return sessionID
   */
  @javax.annotation.Nonnull
  public String getSessionID() {
    return sessionID;
  }

  public void setSessionID(@javax.annotation.Nonnull String sessionID) {
    this.sessionID = sessionID;
  }


  public Session userID(@javax.annotation.Nonnull String userID) {
    this.userID = userID;
    return this;
  }

  /**
   * Get userID
   * @return userID
   */
  @javax.annotation.Nonnull
  public String getUserID() {
    return userID;
  }

  public void setUserID(@javax.annotation.Nonnull String userID) {
    this.userID = userID;
  }


  public Session identifierValue(@javax.annotation.Nonnull String identifierValue) {
    this.identifierValue = identifierValue;
    return this;
  }

  /**
   * Get identifierValue
   * @return identifierValue
   */
  @javax.annotation.Nonnull
  public String getIdentifierValue() {
    return identifierValue;
  }

  public void setIdentifierValue(@javax.annotation.Nonnull String identifierValue) {
    this.identifierValue = identifierValue;
  }


  public Session createdMs(@javax.annotation.Nonnull Long createdMs) {
    this.createdMs = createdMs;
    return this;
  }

  /**
   * Get createdMs
   * @return createdMs
   */
  @javax.annotation.Nonnull
  public Long getCreatedMs() {
    return createdMs;
  }

  public void setCreatedMs(@javax.annotation.Nonnull Long createdMs) {
    this.createdMs = createdMs;
  }


  public Session lastActionMs(@javax.annotation.Nonnull Long lastActionMs) {
    this.lastActionMs = lastActionMs;
    return this;
  }

  /**
   * Get lastActionMs
   * @return lastActionMs
   */
  @javax.annotation.Nonnull
  public Long getLastActionMs() {
    return lastActionMs;
  }

  public void setLastActionMs(@javax.annotation.Nonnull Long lastActionMs) {
    this.lastActionMs = lastActionMs;
  }


  public Session expiresMs(@javax.annotation.Nonnull Long expiresMs) {
    this.expiresMs = expiresMs;
    return this;
  }

  /**
   * Get expiresMs
   * @return expiresMs
   */
  @javax.annotation.Nonnull
  public Long getExpiresMs() {
    return expiresMs;
  }

  public void setExpiresMs(@javax.annotation.Nonnull Long expiresMs) {
    this.expiresMs = expiresMs;
  }


  public Session status(@javax.annotation.Nonnull SessionStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   */
  @javax.annotation.Nonnull
  public SessionStatus getStatus() {
    return status;
  }

  public void setStatus(@javax.annotation.Nonnull SessionStatus status) {
    this.status = status;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Session session = (Session) o;
    return Objects.equals(this.sessionID, session.sessionID) &&
        Objects.equals(this.userID, session.userID) &&
        Objects.equals(this.identifierValue, session.identifierValue) &&
        Objects.equals(this.createdMs, session.createdMs) &&
        Objects.equals(this.lastActionMs, session.lastActionMs) &&
        Objects.equals(this.expiresMs, session.expiresMs) &&
        Objects.equals(this.status, session.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sessionID, userID, identifierValue, createdMs, lastActionMs, expiresMs, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Session {\n");
    sb.append("    sessionID: ").append(toIndentedString(sessionID)).append("\n");
    sb.append("    userID: ").append(toIndentedString(userID)).append("\n");
    sb.append("    identifierValue: ").append(toIndentedString(identifierValue)).append("\n");
    sb.append("    createdMs: ").append(toIndentedString(createdMs)).append("\n");
    sb.append("    lastActionMs: ").append(toIndentedString(lastActionMs)).append("\n");
    sb.append("    expiresMs: ").append(toIndentedString(expiresMs)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("sessionID");
    openapiFields.add("userID");
    openapiFields.add("identifierValue");
    openapiFields.add("createdMs");
    openapiFields.add("lastActionMs");
    openapiFields.add("expiresMs");
    openapiFields.add("status");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("sessionID");
    openapiRequiredFields.add("userID");
    openapiRequiredFields.add("identifierValue");
    openapiRequiredFields.add("createdMs");
    openapiRequiredFields.add("lastActionMs");
    openapiRequiredFields.add("expiresMs");
    openapiRequiredFields.add("status");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to Session
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!Session.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in Session is not found in the empty JSON string", Session.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!Session.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `Session` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : Session.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("sessionID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `sessionID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("sessionID").toString()));
      }
      if (!jsonObj.get("userID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `userID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("userID").toString()));
      }
      if (!jsonObj.get("identifierValue").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `identifierValue` to be a primitive type in the JSON string but got `%s`", jsonObj.get("identifierValue").toString()));
      }
      // validate the required field `status`
      SessionStatus.validateJsonElement(jsonObj.get("status"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Session.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Session' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Session> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Session.class));

       return (TypeAdapter<T>) new TypeAdapter<Session>() {
           @Override
           public void write(JsonWriter out, Session value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public Session read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of Session given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of Session
   * @throws IOException if the JSON string is invalid with respect to Session
   */
  public static Session fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Session.class);
  }

  /**
   * Convert an instance of Session to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

