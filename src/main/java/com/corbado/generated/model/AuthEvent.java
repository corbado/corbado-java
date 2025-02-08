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
import com.corbado.generated.model.AuthEventMethod;
import com.corbado.generated.model.AuthEventStatus;
import com.corbado.generated.model.AuthEventType;
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
 * AuthEvent
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-08T15:52:19.373962904Z[Etc/UTC]", comments = "Generator version: 7.12.0-SNAPSHOT")
public class AuthEvent {
  public static final String SERIALIZED_NAME_AUTH_EVENT_I_D = "authEventID";
  @SerializedName(SERIALIZED_NAME_AUTH_EVENT_I_D)
  @javax.annotation.Nonnull
  private String authEventID;

  public static final String SERIALIZED_NAME_USER_I_D = "userID";
  @SerializedName(SERIALIZED_NAME_USER_I_D)
  @javax.annotation.Nonnull
  private String userID;

  public static final String SERIALIZED_NAME_USERNAME = "username";
  @SerializedName(SERIALIZED_NAME_USERNAME)
  @javax.annotation.Nonnull
  private String username;

  public static final String SERIALIZED_NAME_EVENT_TYPE = "eventType";
  @SerializedName(SERIALIZED_NAME_EVENT_TYPE)
  @javax.annotation.Nonnull
  private AuthEventType eventType;

  public static final String SERIALIZED_NAME_METHOD = "method";
  @SerializedName(SERIALIZED_NAME_METHOD)
  @javax.annotation.Nonnull
  private AuthEventMethod method;

  public static final String SERIALIZED_NAME_CREATED = "created";
  @SerializedName(SERIALIZED_NAME_CREATED)
  @javax.annotation.Nonnull
  private String created;

  public static final String SERIALIZED_NAME_CREATED_MS = "createdMs";
  @SerializedName(SERIALIZED_NAME_CREATED_MS)
  @javax.annotation.Nonnull
  private Long createdMs;

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  @javax.annotation.Nonnull
  private AuthEventStatus status;

  public AuthEvent() {
  }

  public AuthEvent authEventID(@javax.annotation.Nonnull String authEventID) {
    this.authEventID = authEventID;
    return this;
  }

  /**
   * Get authEventID
   * @return authEventID
   */
  @javax.annotation.Nonnull
  public String getAuthEventID() {
    return authEventID;
  }

  public void setAuthEventID(@javax.annotation.Nonnull String authEventID) {
    this.authEventID = authEventID;
  }


  public AuthEvent userID(@javax.annotation.Nonnull String userID) {
    this.userID = userID;
    return this;
  }

  /**
   * ID of the user
   * @return userID
   */
  @javax.annotation.Nonnull
  public String getUserID() {
    return userID;
  }

  public void setUserID(@javax.annotation.Nonnull String userID) {
    this.userID = userID;
  }


  public AuthEvent username(@javax.annotation.Nonnull String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
   */
  @javax.annotation.Nonnull
  public String getUsername() {
    return username;
  }

  public void setUsername(@javax.annotation.Nonnull String username) {
    this.username = username;
  }


  public AuthEvent eventType(@javax.annotation.Nonnull AuthEventType eventType) {
    this.eventType = eventType;
    return this;
  }

  /**
   * Get eventType
   * @return eventType
   */
  @javax.annotation.Nonnull
  public AuthEventType getEventType() {
    return eventType;
  }

  public void setEventType(@javax.annotation.Nonnull AuthEventType eventType) {
    this.eventType = eventType;
  }


  public AuthEvent method(@javax.annotation.Nonnull AuthEventMethod method) {
    this.method = method;
    return this;
  }

  /**
   * Get method
   * @return method
   */
  @javax.annotation.Nonnull
  public AuthEventMethod getMethod() {
    return method;
  }

  public void setMethod(@javax.annotation.Nonnull AuthEventMethod method) {
    this.method = method;
  }


  public AuthEvent created(@javax.annotation.Nonnull String created) {
    this.created = created;
    return this;
  }

  /**
   * Timestamp of when the entity was created in yyyy-MM-dd&#39;T&#39;HH:mm:ss format
   * @return created
   */
  @javax.annotation.Nonnull
  public String getCreated() {
    return created;
  }

  public void setCreated(@javax.annotation.Nonnull String created) {
    this.created = created;
  }


  public AuthEvent createdMs(@javax.annotation.Nonnull Long createdMs) {
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


  public AuthEvent status(@javax.annotation.Nonnull AuthEventStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   */
  @javax.annotation.Nonnull
  public AuthEventStatus getStatus() {
    return status;
  }

  public void setStatus(@javax.annotation.Nonnull AuthEventStatus status) {
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
    AuthEvent authEvent = (AuthEvent) o;
    return Objects.equals(this.authEventID, authEvent.authEventID) &&
        Objects.equals(this.userID, authEvent.userID) &&
        Objects.equals(this.username, authEvent.username) &&
        Objects.equals(this.eventType, authEvent.eventType) &&
        Objects.equals(this.method, authEvent.method) &&
        Objects.equals(this.created, authEvent.created) &&
        Objects.equals(this.createdMs, authEvent.createdMs) &&
        Objects.equals(this.status, authEvent.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(authEventID, userID, username, eventType, method, created, createdMs, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthEvent {\n");
    sb.append("    authEventID: ").append(toIndentedString(authEventID)).append("\n");
    sb.append("    userID: ").append(toIndentedString(userID)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdMs: ").append(toIndentedString(createdMs)).append("\n");
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
    openapiFields.add("authEventID");
    openapiFields.add("userID");
    openapiFields.add("username");
    openapiFields.add("eventType");
    openapiFields.add("method");
    openapiFields.add("created");
    openapiFields.add("createdMs");
    openapiFields.add("status");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("authEventID");
    openapiRequiredFields.add("userID");
    openapiRequiredFields.add("username");
    openapiRequiredFields.add("eventType");
    openapiRequiredFields.add("method");
    openapiRequiredFields.add("created");
    openapiRequiredFields.add("createdMs");
    openapiRequiredFields.add("status");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to AuthEvent
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!AuthEvent.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in AuthEvent is not found in the empty JSON string", AuthEvent.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!AuthEvent.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `AuthEvent` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : AuthEvent.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("authEventID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `authEventID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("authEventID").toString()));
      }
      if (!jsonObj.get("userID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `userID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("userID").toString()));
      }
      if (!jsonObj.get("username").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `username` to be a primitive type in the JSON string but got `%s`", jsonObj.get("username").toString()));
      }
      // validate the required field `eventType`
      AuthEventType.validateJsonElement(jsonObj.get("eventType"));
      // validate the required field `method`
      AuthEventMethod.validateJsonElement(jsonObj.get("method"));
      if (!jsonObj.get("created").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `created` to be a primitive type in the JSON string but got `%s`", jsonObj.get("created").toString()));
      }
      // validate the required field `status`
      AuthEventStatus.validateJsonElement(jsonObj.get("status"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!AuthEvent.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'AuthEvent' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<AuthEvent> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(AuthEvent.class));

       return (TypeAdapter<T>) new TypeAdapter<AuthEvent>() {
           @Override
           public void write(JsonWriter out, AuthEvent value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public AuthEvent read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of AuthEvent given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of AuthEvent
   * @throws IOException if the JSON string is invalid with respect to AuthEvent
   */
  public static AuthEvent fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, AuthEvent.class);
  }

  /**
   * Convert an instance of AuthEvent to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

