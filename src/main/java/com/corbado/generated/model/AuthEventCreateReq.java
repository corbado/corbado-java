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
import com.corbado.generated.model.ClientInformation;
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
 * AuthEventCreateReq
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-12-15T13:05:51.424266690Z[Etc/UTC]", comments = "Generator version: 7.11.0-SNAPSHOT")
public class AuthEventCreateReq {
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

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  @javax.annotation.Nonnull
  private AuthEventStatus status;

  public static final String SERIALIZED_NAME_CLIENT_INFORMATION = "clientInformation";
  @SerializedName(SERIALIZED_NAME_CLIENT_INFORMATION)
  @javax.annotation.Nonnull
  private ClientInformation clientInformation;

  public AuthEventCreateReq() {
  }

  public AuthEventCreateReq username(@javax.annotation.Nonnull String username) {
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


  public AuthEventCreateReq eventType(@javax.annotation.Nonnull AuthEventType eventType) {
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


  public AuthEventCreateReq method(@javax.annotation.Nonnull AuthEventMethod method) {
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


  public AuthEventCreateReq status(@javax.annotation.Nonnull AuthEventStatus status) {
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


  public AuthEventCreateReq clientInformation(@javax.annotation.Nonnull ClientInformation clientInformation) {
    this.clientInformation = clientInformation;
    return this;
  }

  /**
   * Get clientInformation
   * @return clientInformation
   */
  @javax.annotation.Nonnull
  public ClientInformation getClientInformation() {
    return clientInformation;
  }

  public void setClientInformation(@javax.annotation.Nonnull ClientInformation clientInformation) {
    this.clientInformation = clientInformation;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthEventCreateReq authEventCreateReq = (AuthEventCreateReq) o;
    return Objects.equals(this.username, authEventCreateReq.username) &&
        Objects.equals(this.eventType, authEventCreateReq.eventType) &&
        Objects.equals(this.method, authEventCreateReq.method) &&
        Objects.equals(this.status, authEventCreateReq.status) &&
        Objects.equals(this.clientInformation, authEventCreateReq.clientInformation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, eventType, method, status, clientInformation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthEventCreateReq {\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    clientInformation: ").append(toIndentedString(clientInformation)).append("\n");
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
    openapiFields.add("username");
    openapiFields.add("eventType");
    openapiFields.add("method");
    openapiFields.add("status");
    openapiFields.add("clientInformation");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("username");
    openapiRequiredFields.add("eventType");
    openapiRequiredFields.add("method");
    openapiRequiredFields.add("status");
    openapiRequiredFields.add("clientInformation");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to AuthEventCreateReq
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!AuthEventCreateReq.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in AuthEventCreateReq is not found in the empty JSON string", AuthEventCreateReq.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!AuthEventCreateReq.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `AuthEventCreateReq` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : AuthEventCreateReq.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("username").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `username` to be a primitive type in the JSON string but got `%s`", jsonObj.get("username").toString()));
      }
      // validate the required field `eventType`
      AuthEventType.validateJsonElement(jsonObj.get("eventType"));
      // validate the required field `method`
      AuthEventMethod.validateJsonElement(jsonObj.get("method"));
      // validate the required field `status`
      AuthEventStatus.validateJsonElement(jsonObj.get("status"));
      // validate the required field `clientInformation`
      ClientInformation.validateJsonElement(jsonObj.get("clientInformation"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!AuthEventCreateReq.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'AuthEventCreateReq' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<AuthEventCreateReq> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(AuthEventCreateReq.class));

       return (TypeAdapter<T>) new TypeAdapter<AuthEventCreateReq>() {
           @Override
           public void write(JsonWriter out, AuthEventCreateReq value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public AuthEventCreateReq read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of AuthEventCreateReq given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of AuthEventCreateReq
   * @throws IOException if the JSON string is invalid with respect to AuthEventCreateReq
   */
  public static AuthEventCreateReq fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, AuthEventCreateReq.class);
  }

  /**
   * Convert an instance of AuthEventCreateReq to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

