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
import com.corbado.generated.model.PasskeyEventType;
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

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.corbado.generated.invoker.JSON;

/**
 * PasskeyEvent
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-02T14:34:22.087477742Z[Etc/UTC]", comments = "Generator version: 7.8.0-SNAPSHOT")
public class PasskeyEvent {
  public static final String SERIALIZED_NAME_PASSKEY_EVENT_I_D = "passkeyEventID";
  @SerializedName(SERIALIZED_NAME_PASSKEY_EVENT_I_D)
  private String passkeyEventID;

  public static final String SERIALIZED_NAME_USER_I_D = "userID";
  @SerializedName(SERIALIZED_NAME_USER_I_D)
  private String userID;

  public static final String SERIALIZED_NAME_EVENT_TYPE = "eventType";
  @SerializedName(SERIALIZED_NAME_EVENT_TYPE)
  private PasskeyEventType eventType;

  public static final String SERIALIZED_NAME_CLIENT_ENV_I_D = "clientEnvID";
  @SerializedName(SERIALIZED_NAME_CLIENT_ENV_I_D)
  private String clientEnvID;

  public static final String SERIALIZED_NAME_PROCESS_I_D = "processID";
  @SerializedName(SERIALIZED_NAME_PROCESS_I_D)
  private String processID;

  public static final String SERIALIZED_NAME_CREDENTIAL_I_D = "credentialID";
  @SerializedName(SERIALIZED_NAME_CREDENTIAL_I_D)
  private String credentialID;

  public static final String SERIALIZED_NAME_EXPIRES = "expires";
  @SerializedName(SERIALIZED_NAME_EXPIRES)
  private Integer expires;

  public static final String SERIALIZED_NAME_CREATED = "created";
  @SerializedName(SERIALIZED_NAME_CREATED)
  private String created;

  public PasskeyEvent() {
  }

  public PasskeyEvent passkeyEventID(String passkeyEventID) {
    this.passkeyEventID = passkeyEventID;
    return this;
  }

  /**
   * Get passkeyEventID
   * @return passkeyEventID
   */
  @javax.annotation.Nonnull
  public String getPasskeyEventID() {
    return passkeyEventID;
  }

  public void setPasskeyEventID(String passkeyEventID) {
    this.passkeyEventID = passkeyEventID;
  }


  public PasskeyEvent userID(String userID) {
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

  public void setUserID(String userID) {
    this.userID = userID;
  }


  public PasskeyEvent eventType(PasskeyEventType eventType) {
    this.eventType = eventType;
    return this;
  }

  /**
   * Get eventType
   * @return eventType
   */
  @javax.annotation.Nonnull
  public PasskeyEventType getEventType() {
    return eventType;
  }

  public void setEventType(PasskeyEventType eventType) {
    this.eventType = eventType;
  }


  public PasskeyEvent clientEnvID(String clientEnvID) {
    this.clientEnvID = clientEnvID;
    return this;
  }

  /**
   * Get clientEnvID
   * @return clientEnvID
   */
  @javax.annotation.Nullable
  public String getClientEnvID() {
    return clientEnvID;
  }

  public void setClientEnvID(String clientEnvID) {
    this.clientEnvID = clientEnvID;
  }


  public PasskeyEvent processID(String processID) {
    this.processID = processID;
    return this;
  }

  /**
   * Get processID
   * @return processID
   */
  @javax.annotation.Nullable
  public String getProcessID() {
    return processID;
  }

  public void setProcessID(String processID) {
    this.processID = processID;
  }


  public PasskeyEvent credentialID(String credentialID) {
    this.credentialID = credentialID;
    return this;
  }

  /**
   * Get credentialID
   * @return credentialID
   */
  @javax.annotation.Nullable
  public String getCredentialID() {
    return credentialID;
  }

  public void setCredentialID(String credentialID) {
    this.credentialID = credentialID;
  }


  public PasskeyEvent expires(Integer expires) {
    this.expires = expires;
    return this;
  }

  /**
   * Get expires
   * @return expires
   */
  @javax.annotation.Nullable
  public Integer getExpires() {
    return expires;
  }

  public void setExpires(Integer expires) {
    this.expires = expires;
  }


  public PasskeyEvent created(String created) {
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

  public void setCreated(String created) {
    this.created = created;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PasskeyEvent passkeyEvent = (PasskeyEvent) o;
    return Objects.equals(this.passkeyEventID, passkeyEvent.passkeyEventID) &&
        Objects.equals(this.userID, passkeyEvent.userID) &&
        Objects.equals(this.eventType, passkeyEvent.eventType) &&
        Objects.equals(this.clientEnvID, passkeyEvent.clientEnvID) &&
        Objects.equals(this.processID, passkeyEvent.processID) &&
        Objects.equals(this.credentialID, passkeyEvent.credentialID) &&
        Objects.equals(this.expires, passkeyEvent.expires) &&
        Objects.equals(this.created, passkeyEvent.created);
  }

  @Override
  public int hashCode() {
    return Objects.hash(passkeyEventID, userID, eventType, clientEnvID, processID, credentialID, expires, created);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PasskeyEvent {\n");
    sb.append("    passkeyEventID: ").append(toIndentedString(passkeyEventID)).append("\n");
    sb.append("    userID: ").append(toIndentedString(userID)).append("\n");
    sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
    sb.append("    clientEnvID: ").append(toIndentedString(clientEnvID)).append("\n");
    sb.append("    processID: ").append(toIndentedString(processID)).append("\n");
    sb.append("    credentialID: ").append(toIndentedString(credentialID)).append("\n");
    sb.append("    expires: ").append(toIndentedString(expires)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
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
    openapiFields.add("passkeyEventID");
    openapiFields.add("userID");
    openapiFields.add("eventType");
    openapiFields.add("clientEnvID");
    openapiFields.add("processID");
    openapiFields.add("credentialID");
    openapiFields.add("expires");
    openapiFields.add("created");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("passkeyEventID");
    openapiRequiredFields.add("userID");
    openapiRequiredFields.add("eventType");
    openapiRequiredFields.add("created");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to PasskeyEvent
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!PasskeyEvent.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PasskeyEvent is not found in the empty JSON string", PasskeyEvent.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!PasskeyEvent.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `PasskeyEvent` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : PasskeyEvent.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("passkeyEventID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `passkeyEventID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("passkeyEventID").toString()));
      }
      if (!jsonObj.get("userID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `userID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("userID").toString()));
      }
      // validate the required field `eventType`
      PasskeyEventType.validateJsonElement(jsonObj.get("eventType"));
      if ((jsonObj.get("clientEnvID") != null && !jsonObj.get("clientEnvID").isJsonNull()) && !jsonObj.get("clientEnvID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `clientEnvID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("clientEnvID").toString()));
      }
      if ((jsonObj.get("processID") != null && !jsonObj.get("processID").isJsonNull()) && !jsonObj.get("processID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `processID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("processID").toString()));
      }
      if ((jsonObj.get("credentialID") != null && !jsonObj.get("credentialID").isJsonNull()) && !jsonObj.get("credentialID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `credentialID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("credentialID").toString()));
      }
      if (!jsonObj.get("created").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `created` to be a primitive type in the JSON string but got `%s`", jsonObj.get("created").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PasskeyEvent.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PasskeyEvent' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PasskeyEvent> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PasskeyEvent.class));

       return (TypeAdapter<T>) new TypeAdapter<PasskeyEvent>() {
           @Override
           public void write(JsonWriter out, PasskeyEvent value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public PasskeyEvent read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of PasskeyEvent given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of PasskeyEvent
   * @throws IOException if the JSON string is invalid with respect to PasskeyEvent
   */
  public static PasskeyEvent fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PasskeyEvent.class);
  }

  /**
   * Convert an instance of PasskeyEvent to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

