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
import com.corbado.generated.model.Paging;
import com.corbado.generated.model.PasskeyEvent;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 * PasskeyEventList
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-12-15T13:05:51.424266690Z[Etc/UTC]", comments = "Generator version: 7.11.0-SNAPSHOT")
public class PasskeyEventList {
  public static final String SERIALIZED_NAME_PASSKEY_EVENTS = "passkeyEvents";
  @SerializedName(SERIALIZED_NAME_PASSKEY_EVENTS)
  @javax.annotation.Nonnull
  private List<PasskeyEvent> passkeyEvents = new ArrayList<>();

  public static final String SERIALIZED_NAME_PAGING = "paging";
  @SerializedName(SERIALIZED_NAME_PAGING)
  @javax.annotation.Nonnull
  private Paging paging;

  public PasskeyEventList() {
  }

  public PasskeyEventList passkeyEvents(@javax.annotation.Nonnull List<PasskeyEvent> passkeyEvents) {
    this.passkeyEvents = passkeyEvents;
    return this;
  }

  public PasskeyEventList addPasskeyEventsItem(PasskeyEvent passkeyEventsItem) {
    if (this.passkeyEvents == null) {
      this.passkeyEvents = new ArrayList<>();
    }
    this.passkeyEvents.add(passkeyEventsItem);
    return this;
  }

  /**
   * Get passkeyEvents
   * @return passkeyEvents
   */
  @javax.annotation.Nonnull
  public List<PasskeyEvent> getPasskeyEvents() {
    return passkeyEvents;
  }

  public void setPasskeyEvents(@javax.annotation.Nonnull List<PasskeyEvent> passkeyEvents) {
    this.passkeyEvents = passkeyEvents;
  }


  public PasskeyEventList paging(@javax.annotation.Nonnull Paging paging) {
    this.paging = paging;
    return this;
  }

  /**
   * Get paging
   * @return paging
   */
  @javax.annotation.Nonnull
  public Paging getPaging() {
    return paging;
  }

  public void setPaging(@javax.annotation.Nonnull Paging paging) {
    this.paging = paging;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PasskeyEventList passkeyEventList = (PasskeyEventList) o;
    return Objects.equals(this.passkeyEvents, passkeyEventList.passkeyEvents) &&
        Objects.equals(this.paging, passkeyEventList.paging);
  }

  @Override
  public int hashCode() {
    return Objects.hash(passkeyEvents, paging);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PasskeyEventList {\n");
    sb.append("    passkeyEvents: ").append(toIndentedString(passkeyEvents)).append("\n");
    sb.append("    paging: ").append(toIndentedString(paging)).append("\n");
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
    openapiFields.add("passkeyEvents");
    openapiFields.add("paging");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("passkeyEvents");
    openapiRequiredFields.add("paging");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to PasskeyEventList
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!PasskeyEventList.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PasskeyEventList is not found in the empty JSON string", PasskeyEventList.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!PasskeyEventList.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `PasskeyEventList` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : PasskeyEventList.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // ensure the json data is an array
      if (!jsonObj.get("passkeyEvents").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `passkeyEvents` to be an array in the JSON string but got `%s`", jsonObj.get("passkeyEvents").toString()));
      }

      JsonArray jsonArraypasskeyEvents = jsonObj.getAsJsonArray("passkeyEvents");
      // validate the required field `passkeyEvents` (array)
      for (int i = 0; i < jsonArraypasskeyEvents.size(); i++) {
        PasskeyEvent.validateJsonElement(jsonArraypasskeyEvents.get(i));
      };
      // validate the required field `paging`
      Paging.validateJsonElement(jsonObj.get("paging"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PasskeyEventList.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PasskeyEventList' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PasskeyEventList> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PasskeyEventList.class));

       return (TypeAdapter<T>) new TypeAdapter<PasskeyEventList>() {
           @Override
           public void write(JsonWriter out, PasskeyEventList value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public PasskeyEventList read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of PasskeyEventList given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of PasskeyEventList
   * @throws IOException if the JSON string is invalid with respect to PasskeyEventList
   */
  public static PasskeyEventList fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PasskeyEventList.class);
  }

  /**
   * Convert an instance of PasskeyEventList to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

