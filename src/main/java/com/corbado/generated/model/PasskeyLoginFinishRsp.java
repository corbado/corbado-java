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
import com.corbado.generated.model.PasskeyData;
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
 * PasskeyLoginFinishRsp
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-08T15:52:19.373962904Z[Etc/UTC]", comments = "Generator version: 7.12.0-SNAPSHOT")
public class PasskeyLoginFinishRsp {
  public static final String SERIALIZED_NAME_PASSKEY_DATA = "passkeyData";
  @SerializedName(SERIALIZED_NAME_PASSKEY_DATA)
  @javax.annotation.Nonnull
  private PasskeyData passkeyData;

  public static final String SERIALIZED_NAME_SIGNED_PASSKEY_DATA = "signedPasskeyData";
  @SerializedName(SERIALIZED_NAME_SIGNED_PASSKEY_DATA)
  @javax.annotation.Nullable
  private String signedPasskeyData;

  public PasskeyLoginFinishRsp() {
  }

  public PasskeyLoginFinishRsp passkeyData(@javax.annotation.Nonnull PasskeyData passkeyData) {
    this.passkeyData = passkeyData;
    return this;
  }

  /**
   * Get passkeyData
   * @return passkeyData
   */
  @javax.annotation.Nonnull
  public PasskeyData getPasskeyData() {
    return passkeyData;
  }

  public void setPasskeyData(@javax.annotation.Nonnull PasskeyData passkeyData) {
    this.passkeyData = passkeyData;
  }


  public PasskeyLoginFinishRsp signedPasskeyData(@javax.annotation.Nullable String signedPasskeyData) {
    this.signedPasskeyData = signedPasskeyData;
    return this;
  }

  /**
   * Get signedPasskeyData
   * @return signedPasskeyData
   */
  @javax.annotation.Nullable
  public String getSignedPasskeyData() {
    return signedPasskeyData;
  }

  public void setSignedPasskeyData(@javax.annotation.Nullable String signedPasskeyData) {
    this.signedPasskeyData = signedPasskeyData;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PasskeyLoginFinishRsp passkeyLoginFinishRsp = (PasskeyLoginFinishRsp) o;
    return Objects.equals(this.passkeyData, passkeyLoginFinishRsp.passkeyData) &&
        Objects.equals(this.signedPasskeyData, passkeyLoginFinishRsp.signedPasskeyData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(passkeyData, signedPasskeyData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PasskeyLoginFinishRsp {\n");
    sb.append("    passkeyData: ").append(toIndentedString(passkeyData)).append("\n");
    sb.append("    signedPasskeyData: ").append(toIndentedString(signedPasskeyData)).append("\n");
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
    openapiFields.add("passkeyData");
    openapiFields.add("signedPasskeyData");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("passkeyData");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to PasskeyLoginFinishRsp
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!PasskeyLoginFinishRsp.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PasskeyLoginFinishRsp is not found in the empty JSON string", PasskeyLoginFinishRsp.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!PasskeyLoginFinishRsp.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `PasskeyLoginFinishRsp` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : PasskeyLoginFinishRsp.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the required field `passkeyData`
      PasskeyData.validateJsonElement(jsonObj.get("passkeyData"));
      if ((jsonObj.get("signedPasskeyData") != null && !jsonObj.get("signedPasskeyData").isJsonNull()) && !jsonObj.get("signedPasskeyData").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `signedPasskeyData` to be a primitive type in the JSON string but got `%s`", jsonObj.get("signedPasskeyData").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PasskeyLoginFinishRsp.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PasskeyLoginFinishRsp' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PasskeyLoginFinishRsp> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PasskeyLoginFinishRsp.class));

       return (TypeAdapter<T>) new TypeAdapter<PasskeyLoginFinishRsp>() {
           @Override
           public void write(JsonWriter out, PasskeyLoginFinishRsp value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public PasskeyLoginFinishRsp read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of PasskeyLoginFinishRsp given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of PasskeyLoginFinishRsp
   * @throws IOException if the JSON string is invalid with respect to PasskeyLoginFinishRsp
   */
  public static PasskeyLoginFinishRsp fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PasskeyLoginFinishRsp.class);
  }

  /**
   * Convert an instance of PasskeyLoginFinishRsp to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

