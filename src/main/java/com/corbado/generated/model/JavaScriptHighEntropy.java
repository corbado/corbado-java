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
 * JavaScriptHighEntropy
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-12-15T13:05:51.424266690Z[Etc/UTC]", comments = "Generator version: 7.11.0-SNAPSHOT")
public class JavaScriptHighEntropy {
  public static final String SERIALIZED_NAME_PLATFORM = "platform";
  @SerializedName(SERIALIZED_NAME_PLATFORM)
  @javax.annotation.Nonnull
  private String platform;

  public static final String SERIALIZED_NAME_PLATFORM_VERSION = "platformVersion";
  @SerializedName(SERIALIZED_NAME_PLATFORM_VERSION)
  @javax.annotation.Nonnull
  private String platformVersion;

  public static final String SERIALIZED_NAME_MOBILE = "mobile";
  @SerializedName(SERIALIZED_NAME_MOBILE)
  @javax.annotation.Nonnull
  private Boolean mobile;

  public JavaScriptHighEntropy() {
  }

  public JavaScriptHighEntropy platform(@javax.annotation.Nonnull String platform) {
    this.platform = platform;
    return this;
  }

  /**
   * Get platform
   * @return platform
   */
  @javax.annotation.Nonnull
  public String getPlatform() {
    return platform;
  }

  public void setPlatform(@javax.annotation.Nonnull String platform) {
    this.platform = platform;
  }


  public JavaScriptHighEntropy platformVersion(@javax.annotation.Nonnull String platformVersion) {
    this.platformVersion = platformVersion;
    return this;
  }

  /**
   * Get platformVersion
   * @return platformVersion
   */
  @javax.annotation.Nonnull
  public String getPlatformVersion() {
    return platformVersion;
  }

  public void setPlatformVersion(@javax.annotation.Nonnull String platformVersion) {
    this.platformVersion = platformVersion;
  }


  public JavaScriptHighEntropy mobile(@javax.annotation.Nonnull Boolean mobile) {
    this.mobile = mobile;
    return this;
  }

  /**
   * Get mobile
   * @return mobile
   */
  @javax.annotation.Nonnull
  public Boolean getMobile() {
    return mobile;
  }

  public void setMobile(@javax.annotation.Nonnull Boolean mobile) {
    this.mobile = mobile;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JavaScriptHighEntropy javaScriptHighEntropy = (JavaScriptHighEntropy) o;
    return Objects.equals(this.platform, javaScriptHighEntropy.platform) &&
        Objects.equals(this.platformVersion, javaScriptHighEntropy.platformVersion) &&
        Objects.equals(this.mobile, javaScriptHighEntropy.mobile);
  }

  @Override
  public int hashCode() {
    return Objects.hash(platform, platformVersion, mobile);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JavaScriptHighEntropy {\n");
    sb.append("    platform: ").append(toIndentedString(platform)).append("\n");
    sb.append("    platformVersion: ").append(toIndentedString(platformVersion)).append("\n");
    sb.append("    mobile: ").append(toIndentedString(mobile)).append("\n");
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
    openapiFields.add("platform");
    openapiFields.add("platformVersion");
    openapiFields.add("mobile");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("platform");
    openapiRequiredFields.add("platformVersion");
    openapiRequiredFields.add("mobile");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to JavaScriptHighEntropy
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!JavaScriptHighEntropy.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in JavaScriptHighEntropy is not found in the empty JSON string", JavaScriptHighEntropy.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!JavaScriptHighEntropy.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `JavaScriptHighEntropy` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : JavaScriptHighEntropy.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("platform").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `platform` to be a primitive type in the JSON string but got `%s`", jsonObj.get("platform").toString()));
      }
      if (!jsonObj.get("platformVersion").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `platformVersion` to be a primitive type in the JSON string but got `%s`", jsonObj.get("platformVersion").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!JavaScriptHighEntropy.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'JavaScriptHighEntropy' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<JavaScriptHighEntropy> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(JavaScriptHighEntropy.class));

       return (TypeAdapter<T>) new TypeAdapter<JavaScriptHighEntropy>() {
           @Override
           public void write(JsonWriter out, JavaScriptHighEntropy value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public JavaScriptHighEntropy read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of JavaScriptHighEntropy given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of JavaScriptHighEntropy
   * @throws IOException if the JSON string is invalid with respect to JavaScriptHighEntropy
   */
  public static JavaScriptHighEntropy fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, JavaScriptHighEntropy.class);
  }

  /**
   * Convert an instance of JavaScriptHighEntropy to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

