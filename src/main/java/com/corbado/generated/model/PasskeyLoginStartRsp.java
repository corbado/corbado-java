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
import com.corbado.generated.model.DecisionTag;
import com.corbado.generated.model.DetectionTag;
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

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.corbado.generated.invoker.JSON;

/**
 * PasskeyLoginStartRsp
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-13T12:08:31.183817564Z[Etc/UTC]", comments = "Generator version: 7.8.0-SNAPSHOT")
public class PasskeyLoginStartRsp {
  public static final String SERIALIZED_NAME_LOGIN_ALLOW = "loginAllow";
  @SerializedName(SERIALIZED_NAME_LOGIN_ALLOW)
  private Boolean loginAllow;

  public static final String SERIALIZED_NAME_DETECTION_TAGS = "detectionTags";
  @SerializedName(SERIALIZED_NAME_DETECTION_TAGS)
  private List<DetectionTag> detectionTags = new ArrayList<>();

  public static final String SERIALIZED_NAME_DECISION_TAG = "decisionTag";
  @SerializedName(SERIALIZED_NAME_DECISION_TAG)
  private DecisionTag decisionTag;

  public static final String SERIALIZED_NAME_ASSERTION_OPTIONS = "assertionOptions";
  @SerializedName(SERIALIZED_NAME_ASSERTION_OPTIONS)
  private String assertionOptions;

  public static final String SERIALIZED_NAME_IS_C_D_A_CANDIDATE = "isCDACandidate";
  @SerializedName(SERIALIZED_NAME_IS_C_D_A_CANDIDATE)
  private Boolean isCDACandidate;

  public PasskeyLoginStartRsp() {
  }

  public PasskeyLoginStartRsp loginAllow(Boolean loginAllow) {
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

  public void setLoginAllow(Boolean loginAllow) {
    this.loginAllow = loginAllow;
  }


  public PasskeyLoginStartRsp detectionTags(List<DetectionTag> detectionTags) {
    this.detectionTags = detectionTags;
    return this;
  }

  public PasskeyLoginStartRsp addDetectionTagsItem(DetectionTag detectionTagsItem) {
    if (this.detectionTags == null) {
      this.detectionTags = new ArrayList<>();
    }
    this.detectionTags.add(detectionTagsItem);
    return this;
  }

  /**
   * Get detectionTags
   * @return detectionTags
   */
  @javax.annotation.Nonnull
  public List<DetectionTag> getDetectionTags() {
    return detectionTags;
  }

  public void setDetectionTags(List<DetectionTag> detectionTags) {
    this.detectionTags = detectionTags;
  }


  public PasskeyLoginStartRsp decisionTag(DecisionTag decisionTag) {
    this.decisionTag = decisionTag;
    return this;
  }

  /**
   * Get decisionTag
   * @return decisionTag
   */
  @javax.annotation.Nonnull
  public DecisionTag getDecisionTag() {
    return decisionTag;
  }

  public void setDecisionTag(DecisionTag decisionTag) {
    this.decisionTag = decisionTag;
  }


  public PasskeyLoginStartRsp assertionOptions(String assertionOptions) {
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

  public void setAssertionOptions(String assertionOptions) {
    this.assertionOptions = assertionOptions;
  }


  public PasskeyLoginStartRsp isCDACandidate(Boolean isCDACandidate) {
    this.isCDACandidate = isCDACandidate;
    return this;
  }

  /**
   * Get isCDACandidate
   * @return isCDACandidate
   */
  @javax.annotation.Nonnull
  public Boolean getIsCDACandidate() {
    return isCDACandidate;
  }

  public void setIsCDACandidate(Boolean isCDACandidate) {
    this.isCDACandidate = isCDACandidate;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PasskeyLoginStartRsp passkeyLoginStartRsp = (PasskeyLoginStartRsp) o;
    return Objects.equals(this.loginAllow, passkeyLoginStartRsp.loginAllow) &&
        Objects.equals(this.detectionTags, passkeyLoginStartRsp.detectionTags) &&
        Objects.equals(this.decisionTag, passkeyLoginStartRsp.decisionTag) &&
        Objects.equals(this.assertionOptions, passkeyLoginStartRsp.assertionOptions) &&
        Objects.equals(this.isCDACandidate, passkeyLoginStartRsp.isCDACandidate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(loginAllow, detectionTags, decisionTag, assertionOptions, isCDACandidate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PasskeyLoginStartRsp {\n");
    sb.append("    loginAllow: ").append(toIndentedString(loginAllow)).append("\n");
    sb.append("    detectionTags: ").append(toIndentedString(detectionTags)).append("\n");
    sb.append("    decisionTag: ").append(toIndentedString(decisionTag)).append("\n");
    sb.append("    assertionOptions: ").append(toIndentedString(assertionOptions)).append("\n");
    sb.append("    isCDACandidate: ").append(toIndentedString(isCDACandidate)).append("\n");
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
    openapiFields.add("detectionTags");
    openapiFields.add("decisionTag");
    openapiFields.add("assertionOptions");
    openapiFields.add("isCDACandidate");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("loginAllow");
    openapiRequiredFields.add("detectionTags");
    openapiRequiredFields.add("decisionTag");
    openapiRequiredFields.add("assertionOptions");
    openapiRequiredFields.add("isCDACandidate");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to PasskeyLoginStartRsp
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!PasskeyLoginStartRsp.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PasskeyLoginStartRsp is not found in the empty JSON string", PasskeyLoginStartRsp.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!PasskeyLoginStartRsp.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `PasskeyLoginStartRsp` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : PasskeyLoginStartRsp.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // ensure the json data is an array
      if (!jsonObj.get("detectionTags").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `detectionTags` to be an array in the JSON string but got `%s`", jsonObj.get("detectionTags").toString()));
      }

      JsonArray jsonArraydetectionTags = jsonObj.getAsJsonArray("detectionTags");
      // validate the required field `detectionTags` (array)
      for (int i = 0; i < jsonArraydetectionTags.size(); i++) {
        DetectionTag.validateJsonElement(jsonArraydetectionTags.get(i));
      };
      // validate the required field `decisionTag`
      DecisionTag.validateJsonElement(jsonObj.get("decisionTag"));
      if (!jsonObj.get("assertionOptions").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `assertionOptions` to be a primitive type in the JSON string but got `%s`", jsonObj.get("assertionOptions").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PasskeyLoginStartRsp.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PasskeyLoginStartRsp' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PasskeyLoginStartRsp> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PasskeyLoginStartRsp.class));

       return (TypeAdapter<T>) new TypeAdapter<PasskeyLoginStartRsp>() {
           @Override
           public void write(JsonWriter out, PasskeyLoginStartRsp value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public PasskeyLoginStartRsp read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of PasskeyLoginStartRsp given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of PasskeyLoginStartRsp
   * @throws IOException if the JSON string is invalid with respect to PasskeyLoginStartRsp
   */
  public static PasskeyLoginStartRsp fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PasskeyLoginStartRsp.class);
  }

  /**
   * Convert an instance of PasskeyLoginStartRsp to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

