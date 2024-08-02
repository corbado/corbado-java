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
 * ProjectConfigUpdateCnameReq
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-02T14:34:22.087477742Z[Etc/UTC]", comments = "Generator version: 7.8.0-SNAPSHOT")
public class ProjectConfigUpdateCnameReq {
  public static final String SERIALIZED_NAME_CNAME = "cname";
  @SerializedName(SERIALIZED_NAME_CNAME)
  private String cname;

  public ProjectConfigUpdateCnameReq() {
  }

  public ProjectConfigUpdateCnameReq cname(String cname) {
    this.cname = cname;
    return this;
  }

  /**
   * Get cname
   * @return cname
   */
  @javax.annotation.Nonnull
  public String getCname() {
    return cname;
  }

  public void setCname(String cname) {
    this.cname = cname;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProjectConfigUpdateCnameReq projectConfigUpdateCnameReq = (ProjectConfigUpdateCnameReq) o;
    return Objects.equals(this.cname, projectConfigUpdateCnameReq.cname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cname);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProjectConfigUpdateCnameReq {\n");
    sb.append("    cname: ").append(toIndentedString(cname)).append("\n");
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
    openapiFields.add("cname");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("cname");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to ProjectConfigUpdateCnameReq
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ProjectConfigUpdateCnameReq.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ProjectConfigUpdateCnameReq is not found in the empty JSON string", ProjectConfigUpdateCnameReq.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!ProjectConfigUpdateCnameReq.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ProjectConfigUpdateCnameReq` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : ProjectConfigUpdateCnameReq.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("cname").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `cname` to be a primitive type in the JSON string but got `%s`", jsonObj.get("cname").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ProjectConfigUpdateCnameReq.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ProjectConfigUpdateCnameReq' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ProjectConfigUpdateCnameReq> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ProjectConfigUpdateCnameReq.class));

       return (TypeAdapter<T>) new TypeAdapter<ProjectConfigUpdateCnameReq>() {
           @Override
           public void write(JsonWriter out, ProjectConfigUpdateCnameReq value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ProjectConfigUpdateCnameReq read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of ProjectConfigUpdateCnameReq given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of ProjectConfigUpdateCnameReq
   * @throws IOException if the JSON string is invalid with respect to ProjectConfigUpdateCnameReq
   */
  public static ProjectConfigUpdateCnameReq fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ProjectConfigUpdateCnameReq.class);
  }

  /**
   * Convert an instance of ProjectConfigUpdateCnameReq to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

