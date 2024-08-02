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

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.corbado.generated.invoker.JSON;

/**
 * PasskeyIntelFlags
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-02T14:34:22.087477742Z[Etc/UTC]", comments = "Generator version: 7.8.0-SNAPSHOT")
public class PasskeyIntelFlags {
  public static final String SERIALIZED_NAME_FORCE_PASSKEY_APPEND = "forcePasskeyAppend";
  @SerializedName(SERIALIZED_NAME_FORCE_PASSKEY_APPEND)
  private Boolean forcePasskeyAppend;

  public PasskeyIntelFlags() {
  }

  public PasskeyIntelFlags forcePasskeyAppend(Boolean forcePasskeyAppend) {
    this.forcePasskeyAppend = forcePasskeyAppend;
    return this;
  }

  /**
   * Get forcePasskeyAppend
   * @return forcePasskeyAppend
   */
  @javax.annotation.Nonnull
  public Boolean getForcePasskeyAppend() {
    return forcePasskeyAppend;
  }

  public void setForcePasskeyAppend(Boolean forcePasskeyAppend) {
    this.forcePasskeyAppend = forcePasskeyAppend;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PasskeyIntelFlags passkeyIntelFlags = (PasskeyIntelFlags) o;
    return Objects.equals(this.forcePasskeyAppend, passkeyIntelFlags.forcePasskeyAppend);
  }

  @Override
  public int hashCode() {
    return Objects.hash(forcePasskeyAppend);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PasskeyIntelFlags {\n");
    sb.append("    forcePasskeyAppend: ").append(toIndentedString(forcePasskeyAppend)).append("\n");
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
    openapiFields.add("forcePasskeyAppend");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("forcePasskeyAppend");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to PasskeyIntelFlags
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!PasskeyIntelFlags.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PasskeyIntelFlags is not found in the empty JSON string", PasskeyIntelFlags.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!PasskeyIntelFlags.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `PasskeyIntelFlags` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : PasskeyIntelFlags.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PasskeyIntelFlags.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PasskeyIntelFlags' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PasskeyIntelFlags> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PasskeyIntelFlags.class));

       return (TypeAdapter<T>) new TypeAdapter<PasskeyIntelFlags>() {
           @Override
           public void write(JsonWriter out, PasskeyIntelFlags value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public PasskeyIntelFlags read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of PasskeyIntelFlags given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of PasskeyIntelFlags
   * @throws IOException if the JSON string is invalid with respect to PasskeyIntelFlags
   */
  public static PasskeyIntelFlags fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PasskeyIntelFlags.class);
  }

  /**
   * Convert an instance of PasskeyIntelFlags to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

