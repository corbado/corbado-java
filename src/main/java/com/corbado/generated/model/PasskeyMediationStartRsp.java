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
 * PasskeyMediationStartRsp
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-14T05:38:33.191503012Z[Etc/UTC]", comments = "Generator version: 7.13.0-SNAPSHOT")
public class PasskeyMediationStartRsp {
  public static final String SERIALIZED_NAME_LOGIN_ALLOW = "loginAllow";
  @SerializedName(SERIALIZED_NAME_LOGIN_ALLOW)
  @javax.annotation.Nonnull
  private Boolean loginAllow;

  public static final String SERIALIZED_NAME_ASSERTION_OPTIONS = "assertionOptions";
  @SerializedName(SERIALIZED_NAME_ASSERTION_OPTIONS)
  @javax.annotation.Nonnull
  private String assertionOptions;

  public PasskeyMediationStartRsp() {
  }

  public PasskeyMediationStartRsp loginAllow(@javax.annotation.Nonnull Boolean loginAllow) {
    this.loginAllow = loginAllow;
    return this;
  }

  /**
   * Get loginAllow
   * @return loginAllow
   */
  @javax.annotation.Nonnull
  public Boolean getLoginAllow() {
    return loginAllow;
  }

  public void setLoginAllow(@javax.annotation.Nonnull Boolean loginAllow) {
    this.loginAllow = loginAllow;
  }


  public PasskeyMediationStartRsp assertionOptions(@javax.annotation.Nonnull String assertionOptions) {
    this.assertionOptions = assertionOptions;
    return this;
  }

  /**
   * Get assertionOptions
   * @return assertionOptions
   */
  @javax.annotation.Nonnull
  public String getAssertionOptions() {
    return assertionOptions;
  }

  public void setAssertionOptions(@javax.annotation.Nonnull String assertionOptions) {
    this.assertionOptions = assertionOptions;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PasskeyMediationStartRsp passkeyMediationStartRsp = (PasskeyMediationStartRsp) o;
    return Objects.equals(this.loginAllow, passkeyMediationStartRsp.loginAllow) &&
        Objects.equals(this.assertionOptions, passkeyMediationStartRsp.assertionOptions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(loginAllow, assertionOptions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PasskeyMediationStartRsp {\n");
    sb.append("    loginAllow: ").append(toIndentedString(loginAllow)).append("\n");
    sb.append("    assertionOptions: ").append(toIndentedString(assertionOptions)).append("\n");
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
    openapiFields.add("loginAllow");
    openapiFields.add("assertionOptions");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("loginAllow");
    openapiRequiredFields.add("assertionOptions");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to PasskeyMediationStartRsp
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!PasskeyMediationStartRsp.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PasskeyMediationStartRsp is not found in the empty JSON string", PasskeyMediationStartRsp.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!PasskeyMediationStartRsp.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `PasskeyMediationStartRsp` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : PasskeyMediationStartRsp.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("assertionOptions").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `assertionOptions` to be a primitive type in the JSON string but got `%s`", jsonObj.get("assertionOptions").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PasskeyMediationStartRsp.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PasskeyMediationStartRsp' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PasskeyMediationStartRsp> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PasskeyMediationStartRsp.class));

       return (TypeAdapter<T>) new TypeAdapter<PasskeyMediationStartRsp>() {
           @Override
           public void write(JsonWriter out, PasskeyMediationStartRsp value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public PasskeyMediationStartRsp read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of PasskeyMediationStartRsp given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of PasskeyMediationStartRsp
   * @throws IOException if the JSON string is invalid with respect to PasskeyMediationStartRsp
   */
  public static PasskeyMediationStartRsp fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PasskeyMediationStartRsp.class);
  }

  /**
   * Convert an instance of PasskeyMediationStartRsp to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

