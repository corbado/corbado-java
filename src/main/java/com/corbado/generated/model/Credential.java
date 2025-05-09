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
import com.corbado.generated.model.AaguidDetails;
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
 * Credential
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-14T05:38:33.191503012Z[Etc/UTC]", comments = "Generator version: 7.13.0-SNAPSHOT")
public class Credential {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  @javax.annotation.Nonnull
  private String id;

  public static final String SERIALIZED_NAME_CREDENTIAL_I_D = "credentialID";
  @SerializedName(SERIALIZED_NAME_CREDENTIAL_I_D)
  @javax.annotation.Nonnull
  private String credentialID;

  public static final String SERIALIZED_NAME_ATTESTATION_TYPE = "attestationType";
  @SerializedName(SERIALIZED_NAME_ATTESTATION_TYPE)
  @javax.annotation.Nonnull
  private String attestationType;

  /**
   * Gets or Sets transport
   */
  @JsonAdapter(TransportEnum.Adapter.class)
  public enum TransportEnum {
    USB("usb"),
    
    NFC("nfc"),
    
    BLE("ble"),
    
    INTERNAL("internal"),
    
    HYBRID("hybrid"),
    
    SMART_CARD("smart-card");

    private String value;

    TransportEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TransportEnum fromValue(String value) {
      for (TransportEnum b : TransportEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<TransportEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TransportEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TransportEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return TransportEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      TransportEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_TRANSPORT = "transport";
  @SerializedName(SERIALIZED_NAME_TRANSPORT)
  @javax.annotation.Nonnull
  private List<TransportEnum> transport = new ArrayList<>();

  public static final String SERIALIZED_NAME_BACKUP_ELIGIBLE = "backupEligible";
  @SerializedName(SERIALIZED_NAME_BACKUP_ELIGIBLE)
  @javax.annotation.Nonnull
  private Boolean backupEligible;

  public static final String SERIALIZED_NAME_BACKUP_STATE = "backupState";
  @SerializedName(SERIALIZED_NAME_BACKUP_STATE)
  @javax.annotation.Nonnull
  private Boolean backupState;

  public static final String SERIALIZED_NAME_AUTHENTICATOR_A_A_G_U_I_D = "authenticatorAAGUID";
  @SerializedName(SERIALIZED_NAME_AUTHENTICATOR_A_A_G_U_I_D)
  @javax.annotation.Nonnull
  private String authenticatorAAGUID;

  public static final String SERIALIZED_NAME_SOURCE_O_S = "sourceOS";
  @SerializedName(SERIALIZED_NAME_SOURCE_O_S)
  @javax.annotation.Nonnull
  private String sourceOS;

  public static final String SERIALIZED_NAME_SOURCE_BROWSER = "sourceBrowser";
  @SerializedName(SERIALIZED_NAME_SOURCE_BROWSER)
  @javax.annotation.Nonnull
  private String sourceBrowser;

  public static final String SERIALIZED_NAME_LAST_USED = "lastUsed";
  @SerializedName(SERIALIZED_NAME_LAST_USED)
  @javax.annotation.Nonnull
  private String lastUsed;

  public static final String SERIALIZED_NAME_LAST_USED_MS = "lastUsedMs";
  @SerializedName(SERIALIZED_NAME_LAST_USED_MS)
  @javax.annotation.Nonnull
  private Long lastUsedMs;

  public static final String SERIALIZED_NAME_CREATED = "created";
  @SerializedName(SERIALIZED_NAME_CREATED)
  @javax.annotation.Nonnull
  private String created;

  public static final String SERIALIZED_NAME_CREATED_MS = "createdMs";
  @SerializedName(SERIALIZED_NAME_CREATED_MS)
  @javax.annotation.Nonnull
  private Long createdMs;

  /**
   * Status
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    PENDING("pending"),
    
    ACTIVE("active");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return StatusEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      StatusEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  @javax.annotation.Nonnull
  private StatusEnum status;

  public static final String SERIALIZED_NAME_AAGUID_DETAILS = "aaguidDetails";
  @SerializedName(SERIALIZED_NAME_AAGUID_DETAILS)
  @javax.annotation.Nonnull
  private AaguidDetails aaguidDetails;

  public Credential() {
  }

  public Credential id(@javax.annotation.Nonnull String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  @javax.annotation.Nonnull
  public String getId() {
    return id;
  }

  public void setId(@javax.annotation.Nonnull String id) {
    this.id = id;
  }


  public Credential credentialID(@javax.annotation.Nonnull String credentialID) {
    this.credentialID = credentialID;
    return this;
  }

  /**
   * Get credentialID
   * @return credentialID
   */
  @javax.annotation.Nonnull
  public String getCredentialID() {
    return credentialID;
  }

  public void setCredentialID(@javax.annotation.Nonnull String credentialID) {
    this.credentialID = credentialID;
  }


  public Credential attestationType(@javax.annotation.Nonnull String attestationType) {
    this.attestationType = attestationType;
    return this;
  }

  /**
   * Get attestationType
   * @return attestationType
   */
  @javax.annotation.Nonnull
  public String getAttestationType() {
    return attestationType;
  }

  public void setAttestationType(@javax.annotation.Nonnull String attestationType) {
    this.attestationType = attestationType;
  }


  public Credential transport(@javax.annotation.Nonnull List<TransportEnum> transport) {
    this.transport = transport;
    return this;
  }

  public Credential addTransportItem(TransportEnum transportItem) {
    if (this.transport == null) {
      this.transport = new ArrayList<>();
    }
    this.transport.add(transportItem);
    return this;
  }

  /**
   * Get transport
   * @return transport
   */
  @javax.annotation.Nonnull
  public List<TransportEnum> getTransport() {
    return transport;
  }

  public void setTransport(@javax.annotation.Nonnull List<TransportEnum> transport) {
    this.transport = transport;
  }


  public Credential backupEligible(@javax.annotation.Nonnull Boolean backupEligible) {
    this.backupEligible = backupEligible;
    return this;
  }

  /**
   * Get backupEligible
   * @return backupEligible
   */
  @javax.annotation.Nonnull
  public Boolean getBackupEligible() {
    return backupEligible;
  }

  public void setBackupEligible(@javax.annotation.Nonnull Boolean backupEligible) {
    this.backupEligible = backupEligible;
  }


  public Credential backupState(@javax.annotation.Nonnull Boolean backupState) {
    this.backupState = backupState;
    return this;
  }

  /**
   * Get backupState
   * @return backupState
   */
  @javax.annotation.Nonnull
  public Boolean getBackupState() {
    return backupState;
  }

  public void setBackupState(@javax.annotation.Nonnull Boolean backupState) {
    this.backupState = backupState;
  }


  public Credential authenticatorAAGUID(@javax.annotation.Nonnull String authenticatorAAGUID) {
    this.authenticatorAAGUID = authenticatorAAGUID;
    return this;
  }

  /**
   * Get authenticatorAAGUID
   * @return authenticatorAAGUID
   */
  @javax.annotation.Nonnull
  public String getAuthenticatorAAGUID() {
    return authenticatorAAGUID;
  }

  public void setAuthenticatorAAGUID(@javax.annotation.Nonnull String authenticatorAAGUID) {
    this.authenticatorAAGUID = authenticatorAAGUID;
  }


  public Credential sourceOS(@javax.annotation.Nonnull String sourceOS) {
    this.sourceOS = sourceOS;
    return this;
  }

  /**
   * Get sourceOS
   * @return sourceOS
   */
  @javax.annotation.Nonnull
  public String getSourceOS() {
    return sourceOS;
  }

  public void setSourceOS(@javax.annotation.Nonnull String sourceOS) {
    this.sourceOS = sourceOS;
  }


  public Credential sourceBrowser(@javax.annotation.Nonnull String sourceBrowser) {
    this.sourceBrowser = sourceBrowser;
    return this;
  }

  /**
   * Get sourceBrowser
   * @return sourceBrowser
   */
  @javax.annotation.Nonnull
  public String getSourceBrowser() {
    return sourceBrowser;
  }

  public void setSourceBrowser(@javax.annotation.Nonnull String sourceBrowser) {
    this.sourceBrowser = sourceBrowser;
  }


  public Credential lastUsed(@javax.annotation.Nonnull String lastUsed) {
    this.lastUsed = lastUsed;
    return this;
  }

  /**
   * Timestamp of when the passkey was last used in yyyy-MM-dd&#39;T&#39;HH:mm:ss format
   * @return lastUsed
   */
  @javax.annotation.Nonnull
  public String getLastUsed() {
    return lastUsed;
  }

  public void setLastUsed(@javax.annotation.Nonnull String lastUsed) {
    this.lastUsed = lastUsed;
  }


  public Credential lastUsedMs(@javax.annotation.Nonnull Long lastUsedMs) {
    this.lastUsedMs = lastUsedMs;
    return this;
  }

  /**
   * Get lastUsedMs
   * @return lastUsedMs
   */
  @javax.annotation.Nonnull
  public Long getLastUsedMs() {
    return lastUsedMs;
  }

  public void setLastUsedMs(@javax.annotation.Nonnull Long lastUsedMs) {
    this.lastUsedMs = lastUsedMs;
  }


  public Credential created(@javax.annotation.Nonnull String created) {
    this.created = created;
    return this;
  }

  /**
   * Timestamp of when the entity was created in yyyy-MM-dd&#39;T&#39;HH:mm:ss format
   * @return created
   */
  @javax.annotation.Nonnull
  public String getCreated() {
    return created;
  }

  public void setCreated(@javax.annotation.Nonnull String created) {
    this.created = created;
  }


  public Credential createdMs(@javax.annotation.Nonnull Long createdMs) {
    this.createdMs = createdMs;
    return this;
  }

  /**
   * Get createdMs
   * @return createdMs
   */
  @javax.annotation.Nonnull
  public Long getCreatedMs() {
    return createdMs;
  }

  public void setCreatedMs(@javax.annotation.Nonnull Long createdMs) {
    this.createdMs = createdMs;
  }


  public Credential status(@javax.annotation.Nonnull StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Status
   * @return status
   */
  @javax.annotation.Nonnull
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(@javax.annotation.Nonnull StatusEnum status) {
    this.status = status;
  }


  public Credential aaguidDetails(@javax.annotation.Nonnull AaguidDetails aaguidDetails) {
    this.aaguidDetails = aaguidDetails;
    return this;
  }

  /**
   * Get aaguidDetails
   * @return aaguidDetails
   */
  @javax.annotation.Nonnull
  public AaguidDetails getAaguidDetails() {
    return aaguidDetails;
  }

  public void setAaguidDetails(@javax.annotation.Nonnull AaguidDetails aaguidDetails) {
    this.aaguidDetails = aaguidDetails;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Credential credential = (Credential) o;
    return Objects.equals(this.id, credential.id) &&
        Objects.equals(this.credentialID, credential.credentialID) &&
        Objects.equals(this.attestationType, credential.attestationType) &&
        Objects.equals(this.transport, credential.transport) &&
        Objects.equals(this.backupEligible, credential.backupEligible) &&
        Objects.equals(this.backupState, credential.backupState) &&
        Objects.equals(this.authenticatorAAGUID, credential.authenticatorAAGUID) &&
        Objects.equals(this.sourceOS, credential.sourceOS) &&
        Objects.equals(this.sourceBrowser, credential.sourceBrowser) &&
        Objects.equals(this.lastUsed, credential.lastUsed) &&
        Objects.equals(this.lastUsedMs, credential.lastUsedMs) &&
        Objects.equals(this.created, credential.created) &&
        Objects.equals(this.createdMs, credential.createdMs) &&
        Objects.equals(this.status, credential.status) &&
        Objects.equals(this.aaguidDetails, credential.aaguidDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, credentialID, attestationType, transport, backupEligible, backupState, authenticatorAAGUID, sourceOS, sourceBrowser, lastUsed, lastUsedMs, created, createdMs, status, aaguidDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Credential {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    credentialID: ").append(toIndentedString(credentialID)).append("\n");
    sb.append("    attestationType: ").append(toIndentedString(attestationType)).append("\n");
    sb.append("    transport: ").append(toIndentedString(transport)).append("\n");
    sb.append("    backupEligible: ").append(toIndentedString(backupEligible)).append("\n");
    sb.append("    backupState: ").append(toIndentedString(backupState)).append("\n");
    sb.append("    authenticatorAAGUID: ").append(toIndentedString(authenticatorAAGUID)).append("\n");
    sb.append("    sourceOS: ").append(toIndentedString(sourceOS)).append("\n");
    sb.append("    sourceBrowser: ").append(toIndentedString(sourceBrowser)).append("\n");
    sb.append("    lastUsed: ").append(toIndentedString(lastUsed)).append("\n");
    sb.append("    lastUsedMs: ").append(toIndentedString(lastUsedMs)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdMs: ").append(toIndentedString(createdMs)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    aaguidDetails: ").append(toIndentedString(aaguidDetails)).append("\n");
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
    openapiFields.add("id");
    openapiFields.add("credentialID");
    openapiFields.add("attestationType");
    openapiFields.add("transport");
    openapiFields.add("backupEligible");
    openapiFields.add("backupState");
    openapiFields.add("authenticatorAAGUID");
    openapiFields.add("sourceOS");
    openapiFields.add("sourceBrowser");
    openapiFields.add("lastUsed");
    openapiFields.add("lastUsedMs");
    openapiFields.add("created");
    openapiFields.add("createdMs");
    openapiFields.add("status");
    openapiFields.add("aaguidDetails");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("id");
    openapiRequiredFields.add("credentialID");
    openapiRequiredFields.add("attestationType");
    openapiRequiredFields.add("transport");
    openapiRequiredFields.add("backupEligible");
    openapiRequiredFields.add("backupState");
    openapiRequiredFields.add("authenticatorAAGUID");
    openapiRequiredFields.add("sourceOS");
    openapiRequiredFields.add("sourceBrowser");
    openapiRequiredFields.add("lastUsed");
    openapiRequiredFields.add("lastUsedMs");
    openapiRequiredFields.add("created");
    openapiRequiredFields.add("createdMs");
    openapiRequiredFields.add("status");
    openapiRequiredFields.add("aaguidDetails");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to Credential
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!Credential.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in Credential is not found in the empty JSON string", Credential.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!Credential.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `Credential` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : Credential.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if (!jsonObj.get("credentialID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `credentialID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("credentialID").toString()));
      }
      if (!jsonObj.get("attestationType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `attestationType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("attestationType").toString()));
      }
      // ensure the required json array is present
      if (jsonObj.get("transport") == null) {
        throw new IllegalArgumentException("Expected the field `linkedContent` to be an array in the JSON string but got `null`");
      } else if (!jsonObj.get("transport").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `transport` to be an array in the JSON string but got `%s`", jsonObj.get("transport").toString()));
      }
      if (!jsonObj.get("authenticatorAAGUID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `authenticatorAAGUID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("authenticatorAAGUID").toString()));
      }
      if (!jsonObj.get("sourceOS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `sourceOS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("sourceOS").toString()));
      }
      if (!jsonObj.get("sourceBrowser").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `sourceBrowser` to be a primitive type in the JSON string but got `%s`", jsonObj.get("sourceBrowser").toString()));
      }
      if (!jsonObj.get("lastUsed").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `lastUsed` to be a primitive type in the JSON string but got `%s`", jsonObj.get("lastUsed").toString()));
      }
      if (!jsonObj.get("created").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `created` to be a primitive type in the JSON string but got `%s`", jsonObj.get("created").toString()));
      }
      if (!jsonObj.get("status").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `status` to be a primitive type in the JSON string but got `%s`", jsonObj.get("status").toString()));
      }
      // validate the required field `status`
      StatusEnum.validateJsonElement(jsonObj.get("status"));
      // validate the required field `aaguidDetails`
      AaguidDetails.validateJsonElement(jsonObj.get("aaguidDetails"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Credential.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Credential' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Credential> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Credential.class));

       return (TypeAdapter<T>) new TypeAdapter<Credential>() {
           @Override
           public void write(JsonWriter out, Credential value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public Credential read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of Credential given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of Credential
   * @throws IOException if the JSON string is invalid with respect to Credential
   */
  public static Credential fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Credential.class);
  }

  /**
   * Convert an instance of Credential to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

