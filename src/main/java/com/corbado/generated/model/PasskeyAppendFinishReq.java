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
 * PasskeyAppendFinishReq
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-08T15:52:19.373962904Z[Etc/UTC]", comments = "Generator version: 7.12.0-SNAPSHOT")
public class PasskeyAppendFinishReq {
  public static final String SERIALIZED_NAME_USER_I_D = "userID";
  @SerializedName(SERIALIZED_NAME_USER_I_D)
  @javax.annotation.Nonnull
  private String userID;

  public static final String SERIALIZED_NAME_PROCESS_I_D = "processID";
  @SerializedName(SERIALIZED_NAME_PROCESS_I_D)
  @javax.annotation.Nonnull
  private String processID;

  public static final String SERIALIZED_NAME_ATTESTATION_RESPONSE = "attestationResponse";
  @SerializedName(SERIALIZED_NAME_ATTESTATION_RESPONSE)
  @javax.annotation.Nonnull
  private String attestationResponse;

  public static final String SERIALIZED_NAME_CLIENT_INFORMATION = "clientInformation";
  @SerializedName(SERIALIZED_NAME_CLIENT_INFORMATION)
  @javax.annotation.Nonnull
  private ClientInformation clientInformation;

  public static final String SERIALIZED_NAME_SEND_NOTIFICATION = "sendNotification";
  @SerializedName(SERIALIZED_NAME_SEND_NOTIFICATION)
  @javax.annotation.Nullable
  private Boolean sendNotification;

  public PasskeyAppendFinishReq() {
  }

  public PasskeyAppendFinishReq userID(@javax.annotation.Nonnull String userID) {
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


  public PasskeyAppendFinishReq processID(@javax.annotation.Nonnull String processID) {
    this.processID = processID;
    return this;
  }

  /**
   * Get processID
   * @return processID
   */
  @javax.annotation.Nonnull
  public String getProcessID() {
    return processID;
  }

  public void setProcessID(@javax.annotation.Nonnull String processID) {
    this.processID = processID;
  }


  public PasskeyAppendFinishReq attestationResponse(@javax.annotation.Nonnull String attestationResponse) {
    this.attestationResponse = attestationResponse;
    return this;
  }

  /**
   * Get attestationResponse
   * @return attestationResponse
   */
  @javax.annotation.Nonnull
  public String getAttestationResponse() {
    return attestationResponse;
  }

  public void setAttestationResponse(@javax.annotation.Nonnull String attestationResponse) {
    this.attestationResponse = attestationResponse;
  }


  public PasskeyAppendFinishReq clientInformation(@javax.annotation.Nonnull ClientInformation clientInformation) {
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


  public PasskeyAppendFinishReq sendNotification(@javax.annotation.Nullable Boolean sendNotification) {
    this.sendNotification = sendNotification;
    return this;
  }

  /**
   * Get sendNotification
   * @return sendNotification
   */
  @javax.annotation.Nullable
  public Boolean getSendNotification() {
    return sendNotification;
  }

  public void setSendNotification(@javax.annotation.Nullable Boolean sendNotification) {
    this.sendNotification = sendNotification;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PasskeyAppendFinishReq passkeyAppendFinishReq = (PasskeyAppendFinishReq) o;
    return Objects.equals(this.userID, passkeyAppendFinishReq.userID) &&
        Objects.equals(this.processID, passkeyAppendFinishReq.processID) &&
        Objects.equals(this.attestationResponse, passkeyAppendFinishReq.attestationResponse) &&
        Objects.equals(this.clientInformation, passkeyAppendFinishReq.clientInformation) &&
        Objects.equals(this.sendNotification, passkeyAppendFinishReq.sendNotification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userID, processID, attestationResponse, clientInformation, sendNotification);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PasskeyAppendFinishReq {\n");
    sb.append("    userID: ").append(toIndentedString(userID)).append("\n");
    sb.append("    processID: ").append(toIndentedString(processID)).append("\n");
    sb.append("    attestationResponse: ").append(toIndentedString(attestationResponse)).append("\n");
    sb.append("    clientInformation: ").append(toIndentedString(clientInformation)).append("\n");
    sb.append("    sendNotification: ").append(toIndentedString(sendNotification)).append("\n");
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
    openapiFields.add("userID");
    openapiFields.add("processID");
    openapiFields.add("attestationResponse");
    openapiFields.add("clientInformation");
    openapiFields.add("sendNotification");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("userID");
    openapiRequiredFields.add("processID");
    openapiRequiredFields.add("attestationResponse");
    openapiRequiredFields.add("clientInformation");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to PasskeyAppendFinishReq
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!PasskeyAppendFinishReq.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PasskeyAppendFinishReq is not found in the empty JSON string", PasskeyAppendFinishReq.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!PasskeyAppendFinishReq.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `PasskeyAppendFinishReq` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : PasskeyAppendFinishReq.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("userID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `userID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("userID").toString()));
      }
      if (!jsonObj.get("processID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `processID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("processID").toString()));
      }
      if (!jsonObj.get("attestationResponse").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `attestationResponse` to be a primitive type in the JSON string but got `%s`", jsonObj.get("attestationResponse").toString()));
      }
      // validate the required field `clientInformation`
      ClientInformation.validateJsonElement(jsonObj.get("clientInformation"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PasskeyAppendFinishReq.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PasskeyAppendFinishReq' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PasskeyAppendFinishReq> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PasskeyAppendFinishReq.class));

       return (TypeAdapter<T>) new TypeAdapter<PasskeyAppendFinishReq>() {
           @Override
           public void write(JsonWriter out, PasskeyAppendFinishReq value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public PasskeyAppendFinishReq read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of PasskeyAppendFinishReq given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of PasskeyAppendFinishReq
   * @throws IOException if the JSON string is invalid with respect to PasskeyAppendFinishReq
   */
  public static PasskeyAppendFinishReq fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PasskeyAppendFinishReq.class);
  }

  /**
   * Convert an instance of PasskeyAppendFinishReq to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

