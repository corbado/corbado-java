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
import com.corbado.generated.model.RequestData;
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
 * GenericRsp
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-02T14:34:22.087477742Z[Etc/UTC]", comments = "Generator version: 7.8.0-SNAPSHOT")
public class GenericRsp {
  public static final String SERIALIZED_NAME_HTTP_STATUS_CODE = "httpStatusCode";
  @SerializedName(SERIALIZED_NAME_HTTP_STATUS_CODE)
  private Integer httpStatusCode;

  public static final String SERIALIZED_NAME_MESSAGE = "message";
  @SerializedName(SERIALIZED_NAME_MESSAGE)
  private String message;

  public static final String SERIALIZED_NAME_REQUEST_DATA = "requestData";
  @SerializedName(SERIALIZED_NAME_REQUEST_DATA)
  private RequestData requestData;

  public static final String SERIALIZED_NAME_RUNTIME = "runtime";
  @SerializedName(SERIALIZED_NAME_RUNTIME)
  private Float runtime;

  public GenericRsp() {
  }

  public GenericRsp httpStatusCode(Integer httpStatusCode) {
    this.httpStatusCode = httpStatusCode;
    return this;
  }

  /**
   * HTTP status code of operation
   * minimum: 200
   * maximum: 599
   * @return httpStatusCode
   */
  @javax.annotation.Nonnull
  public Integer getHttpStatusCode() {
    return httpStatusCode;
  }

  public void setHttpStatusCode(Integer httpStatusCode) {
    this.httpStatusCode = httpStatusCode;
  }


  public GenericRsp message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
   */
  @javax.annotation.Nonnull
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  public GenericRsp requestData(RequestData requestData) {
    this.requestData = requestData;
    return this;
  }

  /**
   * Get requestData
   * @return requestData
   */
  @javax.annotation.Nonnull
  public RequestData getRequestData() {
    return requestData;
  }

  public void setRequestData(RequestData requestData) {
    this.requestData = requestData;
  }


  public GenericRsp runtime(Float runtime) {
    this.runtime = runtime;
    return this;
  }

  /**
   * Runtime in seconds for this request
   * @return runtime
   */
  @javax.annotation.Nonnull
  public Float getRuntime() {
    return runtime;
  }

  public void setRuntime(Float runtime) {
    this.runtime = runtime;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GenericRsp genericRsp = (GenericRsp) o;
    return Objects.equals(this.httpStatusCode, genericRsp.httpStatusCode) &&
        Objects.equals(this.message, genericRsp.message) &&
        Objects.equals(this.requestData, genericRsp.requestData) &&
        Objects.equals(this.runtime, genericRsp.runtime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(httpStatusCode, message, requestData, runtime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GenericRsp {\n");
    sb.append("    httpStatusCode: ").append(toIndentedString(httpStatusCode)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    requestData: ").append(toIndentedString(requestData)).append("\n");
    sb.append("    runtime: ").append(toIndentedString(runtime)).append("\n");
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
    openapiFields.add("httpStatusCode");
    openapiFields.add("message");
    openapiFields.add("requestData");
    openapiFields.add("runtime");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("httpStatusCode");
    openapiRequiredFields.add("message");
    openapiRequiredFields.add("requestData");
    openapiRequiredFields.add("runtime");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to GenericRsp
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!GenericRsp.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in GenericRsp is not found in the empty JSON string", GenericRsp.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!GenericRsp.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `GenericRsp` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : GenericRsp.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("message").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `message` to be a primitive type in the JSON string but got `%s`", jsonObj.get("message").toString()));
      }
      // validate the required field `requestData`
      RequestData.validateJsonElement(jsonObj.get("requestData"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!GenericRsp.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'GenericRsp' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<GenericRsp> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(GenericRsp.class));

       return (TypeAdapter<T>) new TypeAdapter<GenericRsp>() {
           @Override
           public void write(JsonWriter out, GenericRsp value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public GenericRsp read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of GenericRsp given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of GenericRsp
   * @throws IOException if the JSON string is invalid with respect to GenericRsp
   */
  public static GenericRsp fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, GenericRsp.class);
  }

  /**
   * Convert an instance of GenericRsp to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

