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
import com.corbado.generated.model.IdentifierStatus;
import com.corbado.generated.model.IdentifierType;
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
 * Identifier
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-08T15:52:19.373962904Z[Etc/UTC]", comments = "Generator version: 7.12.0-SNAPSHOT")
public class Identifier {
  public static final String SERIALIZED_NAME_IDENTIFIER_I_D = "identifierID";
  @SerializedName(SERIALIZED_NAME_IDENTIFIER_I_D)
  @javax.annotation.Nonnull
  private String identifierID;

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  @javax.annotation.Nonnull
  private IdentifierType type;

  public static final String SERIALIZED_NAME_VALUE = "value";
  @SerializedName(SERIALIZED_NAME_VALUE)
  @javax.annotation.Nonnull
  private String value;

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  @javax.annotation.Nonnull
  private IdentifierStatus status;

  public static final String SERIALIZED_NAME_USER_I_D = "userID";
  @SerializedName(SERIALIZED_NAME_USER_I_D)
  @javax.annotation.Nonnull
  private String userID;

  public Identifier() {
  }

  public Identifier identifierID(@javax.annotation.Nonnull String identifierID) {
    this.identifierID = identifierID;
    return this;
  }

  /**
   * Get identifierID
   * @return identifierID
   */
  @javax.annotation.Nonnull
  public String getIdentifierID() {
    return identifierID;
  }

  public void setIdentifierID(@javax.annotation.Nonnull String identifierID) {
    this.identifierID = identifierID;
  }


  public Identifier type(@javax.annotation.Nonnull IdentifierType type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   */
  @javax.annotation.Nonnull
  public IdentifierType getType() {
    return type;
  }

  public void setType(@javax.annotation.Nonnull IdentifierType type) {
    this.type = type;
  }


  public Identifier value(@javax.annotation.Nonnull String value) {
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

  public void setValue(@javax.annotation.Nonnull String value) {
    this.value = value;
  }


  public Identifier status(@javax.annotation.Nonnull IdentifierStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   */
  @javax.annotation.Nonnull
  public IdentifierStatus getStatus() {
    return status;
  }

  public void setStatus(@javax.annotation.Nonnull IdentifierStatus status) {
    this.status = status;
  }


  public Identifier userID(@javax.annotation.Nonnull String userID) {
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



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Identifier identifier = (Identifier) o;
    return Objects.equals(this.identifierID, identifier.identifierID) &&
        Objects.equals(this.type, identifier.type) &&
        Objects.equals(this.value, identifier.value) &&
        Objects.equals(this.status, identifier.status) &&
        Objects.equals(this.userID, identifier.userID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identifierID, type, value, status, userID);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Identifier {\n");
    sb.append("    identifierID: ").append(toIndentedString(identifierID)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    userID: ").append(toIndentedString(userID)).append("\n");
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
    openapiFields.add("identifierID");
    openapiFields.add("type");
    openapiFields.add("value");
    openapiFields.add("status");
    openapiFields.add("userID");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("identifierID");
    openapiRequiredFields.add("type");
    openapiRequiredFields.add("value");
    openapiRequiredFields.add("status");
    openapiRequiredFields.add("userID");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to Identifier
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!Identifier.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in Identifier is not found in the empty JSON string", Identifier.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!Identifier.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `Identifier` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : Identifier.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("identifierID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `identifierID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("identifierID").toString()));
      }
      // validate the required field `type`
      IdentifierType.validateJsonElement(jsonObj.get("type"));
      if (!jsonObj.get("value").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `value` to be a primitive type in the JSON string but got `%s`", jsonObj.get("value").toString()));
      }
      // validate the required field `status`
      IdentifierStatus.validateJsonElement(jsonObj.get("status"));
      if (!jsonObj.get("userID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `userID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("userID").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Identifier.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Identifier' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Identifier> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Identifier.class));

       return (TypeAdapter<T>) new TypeAdapter<Identifier>() {
           @Override
           public void write(JsonWriter out, Identifier value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public Identifier read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of Identifier given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of Identifier
   * @throws IOException if the JSON string is invalid with respect to Identifier
   */
  public static Identifier fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Identifier.class);
  }

  /**
   * Convert an instance of Identifier to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

