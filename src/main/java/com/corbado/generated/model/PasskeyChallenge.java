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
import com.corbado.generated.model.PasskeyChallengeStatus;
import com.corbado.generated.model.PasskeyChallengeType;
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
 * PasskeyChallenge
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-13T12:08:31.183817564Z[Etc/UTC]", comments = "Generator version: 7.8.0-SNAPSHOT")
public class PasskeyChallenge {
  public static final String SERIALIZED_NAME_CHALLENGE_I_D = "challengeID";
  @SerializedName(SERIALIZED_NAME_CHALLENGE_I_D)
  private String challengeID;

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private PasskeyChallengeType type;

  public static final String SERIALIZED_NAME_VALUE = "value";
  @SerializedName(SERIALIZED_NAME_VALUE)
  private String value;

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private PasskeyChallengeStatus status;

  public static final String SERIALIZED_NAME_CREATED = "created";
  @SerializedName(SERIALIZED_NAME_CREATED)
  private Long created;

  public static final String SERIALIZED_NAME_EXPIRES = "expires";
  @SerializedName(SERIALIZED_NAME_EXPIRES)
  private Long expires;

  public PasskeyChallenge() {
  }

  public PasskeyChallenge challengeID(String challengeID) {
    this.challengeID = challengeID;
    return this;
  }

  /**
   * Get challengeID
   * @return challengeID
   */
  @javax.annotation.Nonnull
  public String getChallengeID() {
    return challengeID;
  }

  public void setChallengeID(String challengeID) {
    this.challengeID = challengeID;
  }


  public PasskeyChallenge type(PasskeyChallengeType type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   */
  @javax.annotation.Nonnull
  public PasskeyChallengeType getType() {
    return type;
  }

  public void setType(PasskeyChallengeType type) {
    this.type = type;
  }


  public PasskeyChallenge value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
   */
  @javax.annotation.Nonnull
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  public PasskeyChallenge status(PasskeyChallengeStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   */
  @javax.annotation.Nonnull
  public PasskeyChallengeStatus getStatus() {
    return status;
  }

  public void setStatus(PasskeyChallengeStatus status) {
    this.status = status;
  }


  public PasskeyChallenge created(Long created) {
    this.created = created;
    return this;
  }

  /**
   * Get created
   * @return created
   */
  @javax.annotation.Nonnull
  public Long getCreated() {
    return created;
  }

  public void setCreated(Long created) {
    this.created = created;
  }


  public PasskeyChallenge expires(Long expires) {
    this.expires = expires;
    return this;
  }

  /**
   * Get expires
   * @return expires
   */
  @javax.annotation.Nonnull
  public Long getExpires() {
    return expires;
  }

  public void setExpires(Long expires) {
    this.expires = expires;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PasskeyChallenge passkeyChallenge = (PasskeyChallenge) o;
    return Objects.equals(this.challengeID, passkeyChallenge.challengeID) &&
        Objects.equals(this.type, passkeyChallenge.type) &&
        Objects.equals(this.value, passkeyChallenge.value) &&
        Objects.equals(this.status, passkeyChallenge.status) &&
        Objects.equals(this.created, passkeyChallenge.created) &&
        Objects.equals(this.expires, passkeyChallenge.expires);
  }

  @Override
  public int hashCode() {
    return Objects.hash(challengeID, type, value, status, created, expires);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PasskeyChallenge {\n");
    sb.append("    challengeID: ").append(toIndentedString(challengeID)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    expires: ").append(toIndentedString(expires)).append("\n");
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
    openapiFields.add("challengeID");
    openapiFields.add("type");
    openapiFields.add("value");
    openapiFields.add("status");
    openapiFields.add("created");
    openapiFields.add("expires");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("challengeID");
    openapiRequiredFields.add("type");
    openapiRequiredFields.add("value");
    openapiRequiredFields.add("status");
    openapiRequiredFields.add("created");
    openapiRequiredFields.add("expires");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to PasskeyChallenge
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!PasskeyChallenge.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PasskeyChallenge is not found in the empty JSON string", PasskeyChallenge.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!PasskeyChallenge.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `PasskeyChallenge` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : PasskeyChallenge.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("challengeID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `challengeID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("challengeID").toString()));
      }
      // validate the required field `type`
      PasskeyChallengeType.validateJsonElement(jsonObj.get("type"));
      if (!jsonObj.get("value").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `value` to be a primitive type in the JSON string but got `%s`", jsonObj.get("value").toString()));
      }
      // validate the required field `status`
      PasskeyChallengeStatus.validateJsonElement(jsonObj.get("status"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PasskeyChallenge.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PasskeyChallenge' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PasskeyChallenge> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PasskeyChallenge.class));

       return (TypeAdapter<T>) new TypeAdapter<PasskeyChallenge>() {
           @Override
           public void write(JsonWriter out, PasskeyChallenge value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public PasskeyChallenge read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of PasskeyChallenge given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of PasskeyChallenge
   * @throws IOException if the JSON string is invalid with respect to PasskeyChallenge
   */
  public static PasskeyChallenge fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PasskeyChallenge.class);
  }

  /**
   * Convert an instance of PasskeyChallenge to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

