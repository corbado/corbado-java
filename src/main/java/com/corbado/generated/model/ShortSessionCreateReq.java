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
import com.corbado.generated.model.AppType;
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
 * ShortSessionCreateReq
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-13T12:08:31.183817564Z[Etc/UTC]", comments = "Generator version: 7.8.0-SNAPSHOT")
public class ShortSessionCreateReq {
  public static final String SERIALIZED_NAME_APP_TYPE = "appType";
  @SerializedName(SERIALIZED_NAME_APP_TYPE)
  private AppType appType;

  public static final String SERIALIZED_NAME_ISSUER = "issuer";
  @SerializedName(SERIALIZED_NAME_ISSUER)
  private String issuer;

  public ShortSessionCreateReq() {
  }

  public ShortSessionCreateReq appType(AppType appType) {
    this.appType = appType;
    return this;
  }

  /**
   * Get appType
   * @return appType
   */
  @javax.annotation.Nonnull
  public AppType getAppType() {
    return appType;
  }

  public void setAppType(AppType appType) {
    this.appType = appType;
  }


  public ShortSessionCreateReq issuer(String issuer) {
    this.issuer = issuer;
    return this;
  }

  /**
   * Get issuer
   * @return issuer
   */
  @javax.annotation.Nonnull
  public String getIssuer() {
    return issuer;
  }

  public void setIssuer(String issuer) {
    this.issuer = issuer;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShortSessionCreateReq shortSessionCreateReq = (ShortSessionCreateReq) o;
    return Objects.equals(this.appType, shortSessionCreateReq.appType) &&
        Objects.equals(this.issuer, shortSessionCreateReq.issuer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appType, issuer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShortSessionCreateReq {\n");
    sb.append("    appType: ").append(toIndentedString(appType)).append("\n");
    sb.append("    issuer: ").append(toIndentedString(issuer)).append("\n");
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
    openapiFields.add("appType");
    openapiFields.add("issuer");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("appType");
    openapiRequiredFields.add("issuer");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to ShortSessionCreateReq
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ShortSessionCreateReq.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ShortSessionCreateReq is not found in the empty JSON string", ShortSessionCreateReq.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!ShortSessionCreateReq.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ShortSessionCreateReq` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : ShortSessionCreateReq.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the required field `appType`
      AppType.validateJsonElement(jsonObj.get("appType"));
      if (!jsonObj.get("issuer").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `issuer` to be a primitive type in the JSON string but got `%s`", jsonObj.get("issuer").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ShortSessionCreateReq.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ShortSessionCreateReq' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ShortSessionCreateReq> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ShortSessionCreateReq.class));

       return (TypeAdapter<T>) new TypeAdapter<ShortSessionCreateReq>() {
           @Override
           public void write(JsonWriter out, ShortSessionCreateReq value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ShortSessionCreateReq read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of ShortSessionCreateReq given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of ShortSessionCreateReq
   * @throws IOException if the JSON string is invalid with respect to ShortSessionCreateReq
   */
  public static ShortSessionCreateReq fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ShortSessionCreateReq.class);
  }

  /**
   * Convert an instance of ShortSessionCreateReq to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
