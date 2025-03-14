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
import com.corbado.generated.model.WebhookEventType;
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
 * WebhookEndpointCreateReq
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-14T05:38:33.191503012Z[Etc/UTC]", comments = "Generator version: 7.13.0-SNAPSHOT")
public class WebhookEndpointCreateReq {
  public static final String SERIALIZED_NAME_URL = "url";
  @SerializedName(SERIALIZED_NAME_URL)
  @javax.annotation.Nonnull
  private String url;

  public static final String SERIALIZED_NAME_BASIC_AUTH_USERNAME = "basicAuthUsername";
  @SerializedName(SERIALIZED_NAME_BASIC_AUTH_USERNAME)
  @javax.annotation.Nullable
  private String basicAuthUsername;

  public static final String SERIALIZED_NAME_BASIC_AUTH_PASSWORD = "basicAuthPassword";
  @SerializedName(SERIALIZED_NAME_BASIC_AUTH_PASSWORD)
  @javax.annotation.Nullable
  private String basicAuthPassword;

  public static final String SERIALIZED_NAME_SUBSCRIBED_EVENTS = "subscribedEvents";
  @SerializedName(SERIALIZED_NAME_SUBSCRIBED_EVENTS)
  @javax.annotation.Nonnull
  private List<WebhookEventType> subscribedEvents = new ArrayList<>();

  public static final String SERIALIZED_NAME_CUSTOM_HEADERS = "customHeaders";
  @SerializedName(SERIALIZED_NAME_CUSTOM_HEADERS)
  @javax.annotation.Nonnull
  private Object customHeaders;

  public WebhookEndpointCreateReq() {
  }

  public WebhookEndpointCreateReq url(@javax.annotation.Nonnull String url) {
    this.url = url;
    return this;
  }

  /**
   * Get url
   * @return url
   */
  @javax.annotation.Nonnull
  public String getUrl() {
    return url;
  }

  public void setUrl(@javax.annotation.Nonnull String url) {
    this.url = url;
  }


  public WebhookEndpointCreateReq basicAuthUsername(@javax.annotation.Nullable String basicAuthUsername) {
    this.basicAuthUsername = basicAuthUsername;
    return this;
  }

  /**
   * Get basicAuthUsername
   * @return basicAuthUsername
   */
  @javax.annotation.Nullable
  public String getBasicAuthUsername() {
    return basicAuthUsername;
  }

  public void setBasicAuthUsername(@javax.annotation.Nullable String basicAuthUsername) {
    this.basicAuthUsername = basicAuthUsername;
  }


  public WebhookEndpointCreateReq basicAuthPassword(@javax.annotation.Nullable String basicAuthPassword) {
    this.basicAuthPassword = basicAuthPassword;
    return this;
  }

  /**
   * Get basicAuthPassword
   * @return basicAuthPassword
   */
  @javax.annotation.Nullable
  public String getBasicAuthPassword() {
    return basicAuthPassword;
  }

  public void setBasicAuthPassword(@javax.annotation.Nullable String basicAuthPassword) {
    this.basicAuthPassword = basicAuthPassword;
  }


  public WebhookEndpointCreateReq subscribedEvents(@javax.annotation.Nonnull List<WebhookEventType> subscribedEvents) {
    this.subscribedEvents = subscribedEvents;
    return this;
  }

  public WebhookEndpointCreateReq addSubscribedEventsItem(WebhookEventType subscribedEventsItem) {
    if (this.subscribedEvents == null) {
      this.subscribedEvents = new ArrayList<>();
    }
    this.subscribedEvents.add(subscribedEventsItem);
    return this;
  }

  /**
   * Get subscribedEvents
   * @return subscribedEvents
   */
  @javax.annotation.Nonnull
  public List<WebhookEventType> getSubscribedEvents() {
    return subscribedEvents;
  }

  public void setSubscribedEvents(@javax.annotation.Nonnull List<WebhookEventType> subscribedEvents) {
    this.subscribedEvents = subscribedEvents;
  }


  public WebhookEndpointCreateReq customHeaders(@javax.annotation.Nonnull Object customHeaders) {
    this.customHeaders = customHeaders;
    return this;
  }

  /**
   * Get customHeaders
   * @return customHeaders
   */
  @javax.annotation.Nonnull
  public Object getCustomHeaders() {
    return customHeaders;
  }

  public void setCustomHeaders(@javax.annotation.Nonnull Object customHeaders) {
    this.customHeaders = customHeaders;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WebhookEndpointCreateReq webhookEndpointCreateReq = (WebhookEndpointCreateReq) o;
    return Objects.equals(this.url, webhookEndpointCreateReq.url) &&
        Objects.equals(this.basicAuthUsername, webhookEndpointCreateReq.basicAuthUsername) &&
        Objects.equals(this.basicAuthPassword, webhookEndpointCreateReq.basicAuthPassword) &&
        Objects.equals(this.subscribedEvents, webhookEndpointCreateReq.subscribedEvents) &&
        Objects.equals(this.customHeaders, webhookEndpointCreateReq.customHeaders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url, basicAuthUsername, basicAuthPassword, subscribedEvents, customHeaders);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WebhookEndpointCreateReq {\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    basicAuthUsername: ").append(toIndentedString(basicAuthUsername)).append("\n");
    sb.append("    basicAuthPassword: ").append(toIndentedString(basicAuthPassword)).append("\n");
    sb.append("    subscribedEvents: ").append(toIndentedString(subscribedEvents)).append("\n");
    sb.append("    customHeaders: ").append(toIndentedString(customHeaders)).append("\n");
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
    openapiFields.add("url");
    openapiFields.add("basicAuthUsername");
    openapiFields.add("basicAuthPassword");
    openapiFields.add("subscribedEvents");
    openapiFields.add("customHeaders");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("url");
    openapiRequiredFields.add("subscribedEvents");
    openapiRequiredFields.add("customHeaders");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to WebhookEndpointCreateReq
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!WebhookEndpointCreateReq.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in WebhookEndpointCreateReq is not found in the empty JSON string", WebhookEndpointCreateReq.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!WebhookEndpointCreateReq.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `WebhookEndpointCreateReq` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : WebhookEndpointCreateReq.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("url").toString()));
      }
      if ((jsonObj.get("basicAuthUsername") != null && !jsonObj.get("basicAuthUsername").isJsonNull()) && !jsonObj.get("basicAuthUsername").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `basicAuthUsername` to be a primitive type in the JSON string but got `%s`", jsonObj.get("basicAuthUsername").toString()));
      }
      if ((jsonObj.get("basicAuthPassword") != null && !jsonObj.get("basicAuthPassword").isJsonNull()) && !jsonObj.get("basicAuthPassword").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `basicAuthPassword` to be a primitive type in the JSON string but got `%s`", jsonObj.get("basicAuthPassword").toString()));
      }
      // ensure the required json array is present
      if (jsonObj.get("subscribedEvents") == null) {
        throw new IllegalArgumentException("Expected the field `linkedContent` to be an array in the JSON string but got `null`");
      } else if (!jsonObj.get("subscribedEvents").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `subscribedEvents` to be an array in the JSON string but got `%s`", jsonObj.get("subscribedEvents").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!WebhookEndpointCreateReq.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'WebhookEndpointCreateReq' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<WebhookEndpointCreateReq> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(WebhookEndpointCreateReq.class));

       return (TypeAdapter<T>) new TypeAdapter<WebhookEndpointCreateReq>() {
           @Override
           public void write(JsonWriter out, WebhookEndpointCreateReq value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public WebhookEndpointCreateReq read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of WebhookEndpointCreateReq given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of WebhookEndpointCreateReq
   * @throws IOException if the JSON string is invalid with respect to WebhookEndpointCreateReq
   */
  public static WebhookEndpointCreateReq fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, WebhookEndpointCreateReq.class);
  }

  /**
   * Convert an instance of WebhookEndpointCreateReq to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

