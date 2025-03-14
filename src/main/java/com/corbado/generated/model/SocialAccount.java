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
 * SocialAccount
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-14T05:38:33.191503012Z[Etc/UTC]", comments = "Generator version: 7.13.0-SNAPSHOT")
public class SocialAccount {
  public static final String SERIALIZED_NAME_SOCIAL_ACCOUNT_I_D = "socialAccountID";
  @SerializedName(SERIALIZED_NAME_SOCIAL_ACCOUNT_I_D)
  @javax.annotation.Nonnull
  private String socialAccountID;

  public static final String SERIALIZED_NAME_PROVIDER_TYPE = "providerType";
  @SerializedName(SERIALIZED_NAME_PROVIDER_TYPE)
  @javax.annotation.Nonnull
  private String providerType;

  public static final String SERIALIZED_NAME_IDENTIFIER_VALUE = "identifierValue";
  @SerializedName(SERIALIZED_NAME_IDENTIFIER_VALUE)
  @javax.annotation.Nonnull
  private String identifierValue;

  public static final String SERIALIZED_NAME_USER_I_D = "userID";
  @SerializedName(SERIALIZED_NAME_USER_I_D)
  @javax.annotation.Nonnull
  private String userID;

  public static final String SERIALIZED_NAME_FOREIGN_I_D = "foreignID";
  @SerializedName(SERIALIZED_NAME_FOREIGN_I_D)
  @javax.annotation.Nonnull
  private String foreignID;

  public static final String SERIALIZED_NAME_AVATAR_U_R_L = "avatarURL";
  @SerializedName(SERIALIZED_NAME_AVATAR_U_R_L)
  @javax.annotation.Nonnull
  private String avatarURL;

  public static final String SERIALIZED_NAME_FULL_NAME = "fullName";
  @SerializedName(SERIALIZED_NAME_FULL_NAME)
  @javax.annotation.Nonnull
  private String fullName;

  public SocialAccount() {
  }

  public SocialAccount socialAccountID(@javax.annotation.Nonnull String socialAccountID) {
    this.socialAccountID = socialAccountID;
    return this;
  }

  /**
   * Get socialAccountID
   * @return socialAccountID
   */
  @javax.annotation.Nonnull
  public String getSocialAccountID() {
    return socialAccountID;
  }

  public void setSocialAccountID(@javax.annotation.Nonnull String socialAccountID) {
    this.socialAccountID = socialAccountID;
  }


  public SocialAccount providerType(@javax.annotation.Nonnull String providerType) {
    this.providerType = providerType;
    return this;
  }

  /**
   * Get providerType
   * @return providerType
   */
  @javax.annotation.Nonnull
  public String getProviderType() {
    return providerType;
  }

  public void setProviderType(@javax.annotation.Nonnull String providerType) {
    this.providerType = providerType;
  }


  public SocialAccount identifierValue(@javax.annotation.Nonnull String identifierValue) {
    this.identifierValue = identifierValue;
    return this;
  }

  /**
   * Get identifierValue
   * @return identifierValue
   */
  @javax.annotation.Nonnull
  public String getIdentifierValue() {
    return identifierValue;
  }

  public void setIdentifierValue(@javax.annotation.Nonnull String identifierValue) {
    this.identifierValue = identifierValue;
  }


  public SocialAccount userID(@javax.annotation.Nonnull String userID) {
    this.userID = userID;
    return this;
  }

  /**
   * Get userID
   * @return userID
   */
  @javax.annotation.Nonnull
  public String getUserID() {
    return userID;
  }

  public void setUserID(@javax.annotation.Nonnull String userID) {
    this.userID = userID;
  }


  public SocialAccount foreignID(@javax.annotation.Nonnull String foreignID) {
    this.foreignID = foreignID;
    return this;
  }

  /**
   * Get foreignID
   * @return foreignID
   */
  @javax.annotation.Nonnull
  public String getForeignID() {
    return foreignID;
  }

  public void setForeignID(@javax.annotation.Nonnull String foreignID) {
    this.foreignID = foreignID;
  }


  public SocialAccount avatarURL(@javax.annotation.Nonnull String avatarURL) {
    this.avatarURL = avatarURL;
    return this;
  }

  /**
   * Get avatarURL
   * @return avatarURL
   */
  @javax.annotation.Nonnull
  public String getAvatarURL() {
    return avatarURL;
  }

  public void setAvatarURL(@javax.annotation.Nonnull String avatarURL) {
    this.avatarURL = avatarURL;
  }


  public SocialAccount fullName(@javax.annotation.Nonnull String fullName) {
    this.fullName = fullName;
    return this;
  }

  /**
   * Get fullName
   * @return fullName
   */
  @javax.annotation.Nonnull
  public String getFullName() {
    return fullName;
  }

  public void setFullName(@javax.annotation.Nonnull String fullName) {
    this.fullName = fullName;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SocialAccount socialAccount = (SocialAccount) o;
    return Objects.equals(this.socialAccountID, socialAccount.socialAccountID) &&
        Objects.equals(this.providerType, socialAccount.providerType) &&
        Objects.equals(this.identifierValue, socialAccount.identifierValue) &&
        Objects.equals(this.userID, socialAccount.userID) &&
        Objects.equals(this.foreignID, socialAccount.foreignID) &&
        Objects.equals(this.avatarURL, socialAccount.avatarURL) &&
        Objects.equals(this.fullName, socialAccount.fullName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(socialAccountID, providerType, identifierValue, userID, foreignID, avatarURL, fullName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SocialAccount {\n");
    sb.append("    socialAccountID: ").append(toIndentedString(socialAccountID)).append("\n");
    sb.append("    providerType: ").append(toIndentedString(providerType)).append("\n");
    sb.append("    identifierValue: ").append(toIndentedString(identifierValue)).append("\n");
    sb.append("    userID: ").append(toIndentedString(userID)).append("\n");
    sb.append("    foreignID: ").append(toIndentedString(foreignID)).append("\n");
    sb.append("    avatarURL: ").append(toIndentedString(avatarURL)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
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
    openapiFields.add("socialAccountID");
    openapiFields.add("providerType");
    openapiFields.add("identifierValue");
    openapiFields.add("userID");
    openapiFields.add("foreignID");
    openapiFields.add("avatarURL");
    openapiFields.add("fullName");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("socialAccountID");
    openapiRequiredFields.add("providerType");
    openapiRequiredFields.add("identifierValue");
    openapiRequiredFields.add("userID");
    openapiRequiredFields.add("foreignID");
    openapiRequiredFields.add("avatarURL");
    openapiRequiredFields.add("fullName");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to SocialAccount
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!SocialAccount.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in SocialAccount is not found in the empty JSON string", SocialAccount.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!SocialAccount.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `SocialAccount` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : SocialAccount.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("socialAccountID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `socialAccountID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("socialAccountID").toString()));
      }
      if (!jsonObj.get("providerType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `providerType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("providerType").toString()));
      }
      if (!jsonObj.get("identifierValue").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `identifierValue` to be a primitive type in the JSON string but got `%s`", jsonObj.get("identifierValue").toString()));
      }
      if (!jsonObj.get("userID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `userID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("userID").toString()));
      }
      if (!jsonObj.get("foreignID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `foreignID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("foreignID").toString()));
      }
      if (!jsonObj.get("avatarURL").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `avatarURL` to be a primitive type in the JSON string but got `%s`", jsonObj.get("avatarURL").toString()));
      }
      if (!jsonObj.get("fullName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `fullName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("fullName").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!SocialAccount.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'SocialAccount' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<SocialAccount> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(SocialAccount.class));

       return (TypeAdapter<T>) new TypeAdapter<SocialAccount>() {
           @Override
           public void write(JsonWriter out, SocialAccount value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public SocialAccount read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of SocialAccount given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of SocialAccount
   * @throws IOException if the JSON string is invalid with respect to SocialAccount
   */
  public static SocialAccount fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, SocialAccount.class);
  }

  /**
   * Convert an instance of SocialAccount to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

