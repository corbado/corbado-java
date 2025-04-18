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
 * ParsedDeviceInfo
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-14T05:38:33.191503012Z[Etc/UTC]", comments = "Generator version: 7.13.0-SNAPSHOT")
public class ParsedDeviceInfo {
  public static final String SERIALIZED_NAME_BROWSER_NAME = "browserName";
  @SerializedName(SERIALIZED_NAME_BROWSER_NAME)
  @javax.annotation.Nonnull
  private String browserName;

  public static final String SERIALIZED_NAME_BROWSER_VERSION = "browserVersion";
  @SerializedName(SERIALIZED_NAME_BROWSER_VERSION)
  @javax.annotation.Nonnull
  private String browserVersion;

  public static final String SERIALIZED_NAME_OS_NAME = "osName";
  @SerializedName(SERIALIZED_NAME_OS_NAME)
  @javax.annotation.Nonnull
  private String osName;

  public static final String SERIALIZED_NAME_OS_VERSION = "osVersion";
  @SerializedName(SERIALIZED_NAME_OS_VERSION)
  @javax.annotation.Nonnull
  private String osVersion;

  public ParsedDeviceInfo() {
  }

  public ParsedDeviceInfo browserName(@javax.annotation.Nonnull String browserName) {
    this.browserName = browserName;
    return this;
  }

  /**
   * Get browserName
   * @return browserName
   */
  @javax.annotation.Nonnull
  public String getBrowserName() {
    return browserName;
  }

  public void setBrowserName(@javax.annotation.Nonnull String browserName) {
    this.browserName = browserName;
  }


  public ParsedDeviceInfo browserVersion(@javax.annotation.Nonnull String browserVersion) {
    this.browserVersion = browserVersion;
    return this;
  }

  /**
   * Get browserVersion
   * @return browserVersion
   */
  @javax.annotation.Nonnull
  public String getBrowserVersion() {
    return browserVersion;
  }

  public void setBrowserVersion(@javax.annotation.Nonnull String browserVersion) {
    this.browserVersion = browserVersion;
  }


  public ParsedDeviceInfo osName(@javax.annotation.Nonnull String osName) {
    this.osName = osName;
    return this;
  }

  /**
   * Get osName
   * @return osName
   */
  @javax.annotation.Nonnull
  public String getOsName() {
    return osName;
  }

  public void setOsName(@javax.annotation.Nonnull String osName) {
    this.osName = osName;
  }


  public ParsedDeviceInfo osVersion(@javax.annotation.Nonnull String osVersion) {
    this.osVersion = osVersion;
    return this;
  }

  /**
   * Get osVersion
   * @return osVersion
   */
  @javax.annotation.Nonnull
  public String getOsVersion() {
    return osVersion;
  }

  public void setOsVersion(@javax.annotation.Nonnull String osVersion) {
    this.osVersion = osVersion;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ParsedDeviceInfo parsedDeviceInfo = (ParsedDeviceInfo) o;
    return Objects.equals(this.browserName, parsedDeviceInfo.browserName) &&
        Objects.equals(this.browserVersion, parsedDeviceInfo.browserVersion) &&
        Objects.equals(this.osName, parsedDeviceInfo.osName) &&
        Objects.equals(this.osVersion, parsedDeviceInfo.osVersion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(browserName, browserVersion, osName, osVersion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ParsedDeviceInfo {\n");
    sb.append("    browserName: ").append(toIndentedString(browserName)).append("\n");
    sb.append("    browserVersion: ").append(toIndentedString(browserVersion)).append("\n");
    sb.append("    osName: ").append(toIndentedString(osName)).append("\n");
    sb.append("    osVersion: ").append(toIndentedString(osVersion)).append("\n");
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
    openapiFields.add("browserName");
    openapiFields.add("browserVersion");
    openapiFields.add("osName");
    openapiFields.add("osVersion");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("browserName");
    openapiRequiredFields.add("browserVersion");
    openapiRequiredFields.add("osName");
    openapiRequiredFields.add("osVersion");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to ParsedDeviceInfo
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ParsedDeviceInfo.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ParsedDeviceInfo is not found in the empty JSON string", ParsedDeviceInfo.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!ParsedDeviceInfo.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ParsedDeviceInfo` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : ParsedDeviceInfo.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("browserName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `browserName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("browserName").toString()));
      }
      if (!jsonObj.get("browserVersion").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `browserVersion` to be a primitive type in the JSON string but got `%s`", jsonObj.get("browserVersion").toString()));
      }
      if (!jsonObj.get("osName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `osName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("osName").toString()));
      }
      if (!jsonObj.get("osVersion").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `osVersion` to be a primitive type in the JSON string but got `%s`", jsonObj.get("osVersion").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ParsedDeviceInfo.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ParsedDeviceInfo' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ParsedDeviceInfo> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ParsedDeviceInfo.class));

       return (TypeAdapter<T>) new TypeAdapter<ParsedDeviceInfo>() {
           @Override
           public void write(JsonWriter out, ParsedDeviceInfo value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ParsedDeviceInfo read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of ParsedDeviceInfo given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of ParsedDeviceInfo
   * @throws IOException if the JSON string is invalid with respect to ParsedDeviceInfo
   */
  public static ParsedDeviceInfo fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ParsedDeviceInfo.class);
  }

  /**
   * Convert an instance of ParsedDeviceInfo to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

