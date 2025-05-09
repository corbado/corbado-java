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
import com.corbado.generated.model.ErrorRspAllOfError;
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

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.corbado.generated.invoker.JSON;

/**
 * ErrorRsp
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-14T05:38:33.191503012Z[Etc/UTC]", comments = "Generator version: 7.13.0-SNAPSHOT")
public class ErrorRsp {
  public static final String SERIALIZED_NAME_HTTP_STATUS_CODE = "httpStatusCode";
  @SerializedName(SERIALIZED_NAME_HTTP_STATUS_CODE)
  @javax.annotation.Nonnull
  private Integer httpStatusCode;

  public static final String SERIALIZED_NAME_MESSAGE = "message";
  @SerializedName(SERIALIZED_NAME_MESSAGE)
  @javax.annotation.Nonnull
  private String message;

  public static final String SERIALIZED_NAME_REQUEST_DATA = "requestData";
  @SerializedName(SERIALIZED_NAME_REQUEST_DATA)
  @javax.annotation.Nonnull
  private RequestData requestData;

  public static final String SERIALIZED_NAME_RUNTIME = "runtime";
  @SerializedName(SERIALIZED_NAME_RUNTIME)
  @javax.annotation.Nonnull
  private Float runtime;

  public static final String SERIALIZED_NAME_DATA = "data";
  @SerializedName(SERIALIZED_NAME_DATA)
  @javax.annotation.Nullable
  private Object data;

  public static final String SERIALIZED_NAME_ERROR = "error";
  @SerializedName(SERIALIZED_NAME_ERROR)
  @javax.annotation.Nonnull
  private ErrorRspAllOfError error;

  public ErrorRsp() {
  }

  public ErrorRsp httpStatusCode(@javax.annotation.Nonnull Integer httpStatusCode) {
    this.httpStatusCode = httpStatusCode;
    return this;
  }

  /**
   * HTTP status code of operation
   * @return httpStatusCode
   */
  @javax.annotation.Nonnull
  public Integer getHttpStatusCode() {
    return httpStatusCode;
  }

  public void setHttpStatusCode(@javax.annotation.Nonnull Integer httpStatusCode) {
    this.httpStatusCode = httpStatusCode;
  }


  public ErrorRsp message(@javax.annotation.Nonnull String message) {
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

  public void setMessage(@javax.annotation.Nonnull String message) {
    this.message = message;
  }


  public ErrorRsp requestData(@javax.annotation.Nonnull RequestData requestData) {
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

  public void setRequestData(@javax.annotation.Nonnull RequestData requestData) {
    this.requestData = requestData;
  }


  public ErrorRsp runtime(@javax.annotation.Nonnull Float runtime) {
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

  public void setRuntime(@javax.annotation.Nonnull Float runtime) {
    this.runtime = runtime;
  }


  public ErrorRsp data(@javax.annotation.Nullable Object data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   * @return data
   */
  @javax.annotation.Nullable
  public Object getData() {
    return data;
  }

  public void setData(@javax.annotation.Nullable Object data) {
    this.data = data;
  }


  public ErrorRsp error(@javax.annotation.Nonnull ErrorRspAllOfError error) {
    this.error = error;
    return this;
  }

  /**
   * Get error
   * @return error
   */
  @javax.annotation.Nonnull
  public ErrorRspAllOfError getError() {
    return error;
  }

  public void setError(@javax.annotation.Nonnull ErrorRspAllOfError error) {
    this.error = error;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorRsp errorRsp = (ErrorRsp) o;
    return Objects.equals(this.httpStatusCode, errorRsp.httpStatusCode) &&
        Objects.equals(this.message, errorRsp.message) &&
        Objects.equals(this.requestData, errorRsp.requestData) &&
        Objects.equals(this.runtime, errorRsp.runtime) &&
        Objects.equals(this.data, errorRsp.data) &&
        Objects.equals(this.error, errorRsp.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(httpStatusCode, message, requestData, runtime, data, error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorRsp {\n");
    sb.append("    httpStatusCode: ").append(toIndentedString(httpStatusCode)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    requestData: ").append(toIndentedString(requestData)).append("\n");
    sb.append("    runtime: ").append(toIndentedString(runtime)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
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
    openapiFields.add("data");
    openapiFields.add("error");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("httpStatusCode");
    openapiRequiredFields.add("message");
    openapiRequiredFields.add("requestData");
    openapiRequiredFields.add("runtime");
    openapiRequiredFields.add("error");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to ErrorRsp
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ErrorRsp.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ErrorRsp is not found in the empty JSON string", ErrorRsp.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!ErrorRsp.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ErrorRsp` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : ErrorRsp.openapiRequiredFields) {
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
      // validate the required field `error`
      ErrorRspAllOfError.validateJsonElement(jsonObj.get("error"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ErrorRsp.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ErrorRsp' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ErrorRsp> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ErrorRsp.class));

       return (TypeAdapter<T>) new TypeAdapter<ErrorRsp>() {
           @Override
           public void write(JsonWriter out, ErrorRsp value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ErrorRsp read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of ErrorRsp given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of ErrorRsp
   * @throws IOException if the JSON string is invalid with respect to ErrorRsp
   */
  public static ErrorRsp fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ErrorRsp.class);
  }

  /**
   * Convert an instance of ErrorRsp to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

