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
import com.corbado.generated.model.LongSessionStatus;
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
 * LongSession
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-02T14:34:22.087477742Z[Etc/UTC]", comments = "Generator version: 7.8.0-SNAPSHOT")
public class LongSession {
  public static final String SERIALIZED_NAME_LONG_SESSION_I_D = "longSessionID";
  @SerializedName(SERIALIZED_NAME_LONG_SESSION_I_D)
  private String longSessionID;

  public static final String SERIALIZED_NAME_USER_I_D = "userID";
  @SerializedName(SERIALIZED_NAME_USER_I_D)
  private String userID;

  public static final String SERIALIZED_NAME_IDENTIFIER_VALUE = "identifierValue";
  @SerializedName(SERIALIZED_NAME_IDENTIFIER_VALUE)
  private String identifierValue;

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private LongSessionStatus status;

  public static final String SERIALIZED_NAME_EXPIRES = "expires";
  @SerializedName(SERIALIZED_NAME_EXPIRES)
  private String expires;

  public LongSession() {
  }

  public LongSession longSessionID(String longSessionID) {
    this.longSessionID = longSessionID;
    return this;
  }

  /**
   * Get longSessionID
   * @return longSessionID
   */
  @javax.annotation.Nonnull
  public String getLongSessionID() {
    return longSessionID;
  }

  public void setLongSessionID(String longSessionID) {
    this.longSessionID = longSessionID;
  }


  public LongSession userID(String userID) {
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

  public void setUserID(String userID) {
    this.userID = userID;
  }


  public LongSession identifierValue(String identifierValue) {
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

  public void setIdentifierValue(String identifierValue) {
    this.identifierValue = identifierValue;
  }


  public LongSession status(LongSessionStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   */
  @javax.annotation.Nonnull
  public LongSessionStatus getStatus() {
    return status;
  }

  public void setStatus(LongSessionStatus status) {
    this.status = status;
  }


  public LongSession expires(String expires) {
    this.expires = expires;
    return this;
  }

  /**
   * Get expires
   * @return expires
   */
  @javax.annotation.Nonnull
  public String getExpires() {
    return expires;
  }

  public void setExpires(String expires) {
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
    LongSession longSession = (LongSession) o;
    return Objects.equals(this.longSessionID, longSession.longSessionID) &&
        Objects.equals(this.userID, longSession.userID) &&
        Objects.equals(this.identifierValue, longSession.identifierValue) &&
        Objects.equals(this.status, longSession.status) &&
        Objects.equals(this.expires, longSession.expires);
  }

  @Override
  public int hashCode() {
    return Objects.hash(longSessionID, userID, identifierValue, status, expires);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LongSession {\n");
    sb.append("    longSessionID: ").append(toIndentedString(longSessionID)).append("\n");
    sb.append("    userID: ").append(toIndentedString(userID)).append("\n");
    sb.append("    identifierValue: ").append(toIndentedString(identifierValue)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
    openapiFields.add("longSessionID");
    openapiFields.add("userID");
    openapiFields.add("identifierValue");
    openapiFields.add("status");
    openapiFields.add("expires");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("longSessionID");
    openapiRequiredFields.add("userID");
    openapiRequiredFields.add("identifierValue");
    openapiRequiredFields.add("status");
    openapiRequiredFields.add("expires");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to LongSession
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!LongSession.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in LongSession is not found in the empty JSON string", LongSession.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!LongSession.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `LongSession` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : LongSession.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("longSessionID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `longSessionID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("longSessionID").toString()));
      }
      if (!jsonObj.get("userID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `userID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("userID").toString()));
      }
      if (!jsonObj.get("identifierValue").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `identifierValue` to be a primitive type in the JSON string but got `%s`", jsonObj.get("identifierValue").toString()));
      }
      // validate the required field `status`
      LongSessionStatus.validateJsonElement(jsonObj.get("status"));
      if (!jsonObj.get("expires").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `expires` to be a primitive type in the JSON string but got `%s`", jsonObj.get("expires").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!LongSession.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'LongSession' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<LongSession> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(LongSession.class));

       return (TypeAdapter<T>) new TypeAdapter<LongSession>() {
           @Override
           public void write(JsonWriter out, LongSession value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public LongSession read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of LongSession given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of LongSession
   * @throws IOException if the JSON string is invalid with respect to LongSession
   */
  public static LongSession fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, LongSession.class);
  }

  /**
   * Convert an instance of LongSession to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

