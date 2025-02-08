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
import com.corbado.generated.model.ConnectTokenData;
import com.corbado.generated.model.ConnectTokenStatus;
import com.corbado.generated.model.ConnectTokenType;
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
 * ConnectToken
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-08T15:52:19.373962904Z[Etc/UTC]", comments = "Generator version: 7.12.0-SNAPSHOT")
public class ConnectToken {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  @javax.annotation.Nonnull
  private String id;

  public static final String SERIALIZED_NAME_TOKEN_TYPE = "tokenType";
  @SerializedName(SERIALIZED_NAME_TOKEN_TYPE)
  @javax.annotation.Nonnull
  private ConnectTokenType tokenType;

  public static final String SERIALIZED_NAME_DATA = "data";
  @SerializedName(SERIALIZED_NAME_DATA)
  @javax.annotation.Nonnull
  private ConnectTokenData data;

  public static final String SERIALIZED_NAME_CONNECT_TOKEN_STATUS = "connectTokenStatus";
  @SerializedName(SERIALIZED_NAME_CONNECT_TOKEN_STATUS)
  @javax.annotation.Nonnull
  private ConnectTokenStatus connectTokenStatus;

  public static final String SERIALIZED_NAME_SECRET = "secret";
  @SerializedName(SERIALIZED_NAME_SECRET)
  @javax.annotation.Nullable
  private String secret;

  public static final String SERIALIZED_NAME_EXPIRES = "expires";
  @SerializedName(SERIALIZED_NAME_EXPIRES)
  @javax.annotation.Nonnull
  private Integer expires;

  public ConnectToken() {
  }

  public ConnectToken id(@javax.annotation.Nonnull String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  @javax.annotation.Nonnull
  public String getId() {
    return id;
  }

  public void setId(@javax.annotation.Nonnull String id) {
    this.id = id;
  }


  public ConnectToken tokenType(@javax.annotation.Nonnull ConnectTokenType tokenType) {
    this.tokenType = tokenType;
    return this;
  }

  /**
   * Get tokenType
   * @return tokenType
   */
  @javax.annotation.Nonnull
  public ConnectTokenType getTokenType() {
    return tokenType;
  }

  public void setTokenType(@javax.annotation.Nonnull ConnectTokenType tokenType) {
    this.tokenType = tokenType;
  }


  public ConnectToken data(@javax.annotation.Nonnull ConnectTokenData data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   * @return data
   */
  @javax.annotation.Nonnull
  public ConnectTokenData getData() {
    return data;
  }

  public void setData(@javax.annotation.Nonnull ConnectTokenData data) {
    this.data = data;
  }


  public ConnectToken connectTokenStatus(@javax.annotation.Nonnull ConnectTokenStatus connectTokenStatus) {
    this.connectTokenStatus = connectTokenStatus;
    return this;
  }

  /**
   * Get connectTokenStatus
   * @return connectTokenStatus
   */
  @javax.annotation.Nonnull
  public ConnectTokenStatus getConnectTokenStatus() {
    return connectTokenStatus;
  }

  public void setConnectTokenStatus(@javax.annotation.Nonnull ConnectTokenStatus connectTokenStatus) {
    this.connectTokenStatus = connectTokenStatus;
  }


  public ConnectToken secret(@javax.annotation.Nullable String secret) {
    this.secret = secret;
    return this;
  }

  /**
   * Get secret
   * @return secret
   */
  @javax.annotation.Nullable
  public String getSecret() {
    return secret;
  }

  public void setSecret(@javax.annotation.Nullable String secret) {
    this.secret = secret;
  }


  public ConnectToken expires(@javax.annotation.Nonnull Integer expires) {
    this.expires = expires;
    return this;
  }

  /**
   * Get expires
   * @return expires
   */
  @javax.annotation.Nonnull
  public Integer getExpires() {
    return expires;
  }

  public void setExpires(@javax.annotation.Nonnull Integer expires) {
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
    ConnectToken connectToken = (ConnectToken) o;
    return Objects.equals(this.id, connectToken.id) &&
        Objects.equals(this.tokenType, connectToken.tokenType) &&
        Objects.equals(this.data, connectToken.data) &&
        Objects.equals(this.connectTokenStatus, connectToken.connectTokenStatus) &&
        Objects.equals(this.secret, connectToken.secret) &&
        Objects.equals(this.expires, connectToken.expires);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, tokenType, data, connectTokenStatus, secret, expires);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnectToken {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    tokenType: ").append(toIndentedString(tokenType)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    connectTokenStatus: ").append(toIndentedString(connectTokenStatus)).append("\n");
    sb.append("    secret: ").append(toIndentedString(secret)).append("\n");
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
    openapiFields.add("id");
    openapiFields.add("tokenType");
    openapiFields.add("data");
    openapiFields.add("connectTokenStatus");
    openapiFields.add("secret");
    openapiFields.add("expires");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("id");
    openapiRequiredFields.add("tokenType");
    openapiRequiredFields.add("data");
    openapiRequiredFields.add("connectTokenStatus");
    openapiRequiredFields.add("expires");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to ConnectToken
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ConnectToken.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ConnectToken is not found in the empty JSON string", ConnectToken.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!ConnectToken.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ConnectToken` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : ConnectToken.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      // validate the required field `tokenType`
      ConnectTokenType.validateJsonElement(jsonObj.get("tokenType"));
      // validate the required field `data`
      ConnectTokenData.validateJsonElement(jsonObj.get("data"));
      // validate the required field `connectTokenStatus`
      ConnectTokenStatus.validateJsonElement(jsonObj.get("connectTokenStatus"));
      if ((jsonObj.get("secret") != null && !jsonObj.get("secret").isJsonNull()) && !jsonObj.get("secret").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `secret` to be a primitive type in the JSON string but got `%s`", jsonObj.get("secret").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ConnectToken.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ConnectToken' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ConnectToken> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ConnectToken.class));

       return (TypeAdapter<T>) new TypeAdapter<ConnectToken>() {
           @Override
           public void write(JsonWriter out, ConnectToken value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ConnectToken read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of ConnectToken given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of ConnectToken
   * @throws IOException if the JSON string is invalid with respect to ConnectToken
   */
  public static ConnectToken fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ConnectToken.class);
  }

  /**
   * Convert an instance of ConnectToken to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

