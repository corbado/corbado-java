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
 * DecisionInsights
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-14T05:38:33.191503012Z[Etc/UTC]", comments = "Generator version: 7.13.0-SNAPSHOT")
public class DecisionInsights {
  public static final String SERIALIZED_NAME_TAG = "tag";
  @SerializedName(SERIALIZED_NAME_TAG)
  @javax.annotation.Nonnull
  private DecisionTag tag;

  public static final String SERIALIZED_NAME_IS_C_D_A_CANDIDATE = "isCDACandidate";
  @SerializedName(SERIALIZED_NAME_IS_C_D_A_CANDIDATE)
  @javax.annotation.Nonnull
  private Boolean isCDACandidate;

  public static final String SERIALIZED_NAME_IS_RESTRICTED_BROWSER = "isRestrictedBrowser";
  @SerializedName(SERIALIZED_NAME_IS_RESTRICTED_BROWSER)
  @javax.annotation.Nonnull
  private Boolean isRestrictedBrowser;

  public static final String SERIALIZED_NAME_EXPERIMENTS = "experiments";
  @SerializedName(SERIALIZED_NAME_EXPERIMENTS)
  @javax.annotation.Nonnull
  private List<String> experiments = new ArrayList<>();

  public DecisionInsights() {
  }

  public DecisionInsights tag(@javax.annotation.Nonnull DecisionTag tag) {
    this.tag = tag;
    return this;
  }

  /**
   * Get tag
   * @return tag
   */
  @javax.annotation.Nonnull
  public DecisionTag getTag() {
    return tag;
  }

  public void setTag(@javax.annotation.Nonnull DecisionTag tag) {
    this.tag = tag;
  }


  public DecisionInsights isCDACandidate(@javax.annotation.Nonnull Boolean isCDACandidate) {
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

  public void setIsCDACandidate(@javax.annotation.Nonnull Boolean isCDACandidate) {
    this.isCDACandidate = isCDACandidate;
  }


  public DecisionInsights isRestrictedBrowser(@javax.annotation.Nonnull Boolean isRestrictedBrowser) {
    this.isRestrictedBrowser = isRestrictedBrowser;
    return this;
  }

  /**
   * Get isRestrictedBrowser
   * @return isRestrictedBrowser
   */
  @javax.annotation.Nonnull
  public Boolean getIsRestrictedBrowser() {
    return isRestrictedBrowser;
  }

  public void setIsRestrictedBrowser(@javax.annotation.Nonnull Boolean isRestrictedBrowser) {
    this.isRestrictedBrowser = isRestrictedBrowser;
  }


  public DecisionInsights experiments(@javax.annotation.Nonnull List<String> experiments) {
    this.experiments = experiments;
    return this;
  }

  public DecisionInsights addExperimentsItem(String experimentsItem) {
    if (this.experiments == null) {
      this.experiments = new ArrayList<>();
    }
    this.experiments.add(experimentsItem);
    return this;
  }

  /**
   * Get experiments
   * @return experiments
   */
  @javax.annotation.Nonnull
  public List<String> getExperiments() {
    return experiments;
  }

  public void setExperiments(@javax.annotation.Nonnull List<String> experiments) {
    this.experiments = experiments;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DecisionInsights decisionInsights = (DecisionInsights) o;
    return Objects.equals(this.tag, decisionInsights.tag) &&
        Objects.equals(this.isCDACandidate, decisionInsights.isCDACandidate) &&
        Objects.equals(this.isRestrictedBrowser, decisionInsights.isRestrictedBrowser) &&
        Objects.equals(this.experiments, decisionInsights.experiments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tag, isCDACandidate, isRestrictedBrowser, experiments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DecisionInsights {\n");
    sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
    sb.append("    isCDACandidate: ").append(toIndentedString(isCDACandidate)).append("\n");
    sb.append("    isRestrictedBrowser: ").append(toIndentedString(isRestrictedBrowser)).append("\n");
    sb.append("    experiments: ").append(toIndentedString(experiments)).append("\n");
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
    openapiFields.add("tag");
    openapiFields.add("isCDACandidate");
    openapiFields.add("isRestrictedBrowser");
    openapiFields.add("experiments");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("tag");
    openapiRequiredFields.add("isCDACandidate");
    openapiRequiredFields.add("isRestrictedBrowser");
    openapiRequiredFields.add("experiments");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to DecisionInsights
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!DecisionInsights.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in DecisionInsights is not found in the empty JSON string", DecisionInsights.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!DecisionInsights.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `DecisionInsights` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : DecisionInsights.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the required field `tag`
      DecisionTag.validateJsonElement(jsonObj.get("tag"));
      // ensure the required json array is present
      if (jsonObj.get("experiments") == null) {
        throw new IllegalArgumentException("Expected the field `linkedContent` to be an array in the JSON string but got `null`");
      } else if (!jsonObj.get("experiments").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `experiments` to be an array in the JSON string but got `%s`", jsonObj.get("experiments").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!DecisionInsights.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'DecisionInsights' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<DecisionInsights> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(DecisionInsights.class));

       return (TypeAdapter<T>) new TypeAdapter<DecisionInsights>() {
           @Override
           public void write(JsonWriter out, DecisionInsights value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public DecisionInsights read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of DecisionInsights given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of DecisionInsights
   * @throws IOException if the JSON string is invalid with respect to DecisionInsights
   */
  public static DecisionInsights fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, DecisionInsights.class);
  }

  /**
   * Convert an instance of DecisionInsights to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

