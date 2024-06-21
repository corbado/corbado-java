/*
 * Corbado Backend API
 *  # Introduction This documentation gives an overview of all Corbado Backend API calls to implement passwordless authentication with Passkeys.  The Corbado Backend API is organized around REST principles. It uses resource-oriented URLs with verbs (HTTP methods) and HTTP status codes. Requests need to be valid JSON payloads. We always return JSON.  The Corbado Backend API specification is written in **OpenAPI Version 3.0.3**. You can download it via the download button at the top and use it to generate clients in languages we do not provide officially for example.  # Authentication To authenticate your API requests HTTP Basic Auth is used.  You need to set the projectID as username and the API secret as password. The authorization header looks as follows:  `Basic <<projectID>:<API secret>>`  The **authorization header** needs to be **Base64 encoded** to be working. If the authorization header is missing or incorrect, the API will respond with status code 401.  # Error types As mentioned above we make use of HTTP status codes. **4xx** errors indicate so called client errors, meaning the error occurred on client side and you need to fix it. **5xx** errors indicate server errors, which means the error occurred on server side and outside your control.  Besides HTTP status codes Corbado uses what we call error types which gives more details in error cases and help you to debug your request.  ## internal_error The error type **internal_error** is used when some internal error occurred at Corbado. You can retry your request but usually there is nothing you can do about it. All internal errors get logged and will triggert an alert to our operations team which takes care of the situation as soon as possible.  ## not_found The error type **not_found** is used when you try to get a resource which cannot be found. Most common case is that you provided a wrong ID.  ## method_not_allowed The error type **method_not_allowed** is used when you use a HTTP method (GET for example) on a resource/endpoint which it not supports.   ## validation_error The error type **validation_error** is used when there is validation error on the data you provided in the request payload or path. There will be detailed information in the JSON response about the validation error like what exactly went wrong on what field.   ## project_id_mismatch The error type **project_id_mismatch** is used when there is a project ID you provided mismatch.  ## login_error The error type **login_error** is used when the authentication failed. Most common case is that you provided a wrong pair of project ID and API secret. As mentioned above with use HTTP Basic Auth for authentication.  ## invalid_json The error type **invalid_json** is used when you send invalid JSON as request body. There will be detailed information in the JSON response about what went wrong.  ## rate_limited The error type **rate_limited** is used when ran into rate limiting of the Corbado Backend API. Right now you can do a maximum of **2000 requests** within **10 seconds** from a **single IP**. Throttle your requests and try again. If you think you need more contact support@corbado.com.  ## invalid_origin The error type **invalid_origin** is used when the API has been called from a origin which is not authorized (CORS). Add the origin to your project at https://app.corbado.com/app/settings/credentials/authorized-origins.  ## already_exists The error type **already_exists** is used when you try create a resource which already exists. Most common case is that there is some unique constraint on one of the fields.  # Security and privacy Corbado services are designed, developed, monitored, and updated with security at our core to protect you and your customers’ data and privacy.  ## Security  ### Infrastructure security Corbado leverages highly available and secure cloud infrastructure to ensure that our services are always available and securely delivered. Corbado's services are operated in uvensys GmbH's data centers in Germany and comply with ISO standard 27001. All data centers have redundant power and internet connections to avoid failure. The main location of the servers used is in Linden and offers 24/7 support. We do not use any AWS, GCP or Azure services.  Each server is monitored 24/7 and in the event of problems, automated information is sent via SMS and e-mail. The monitoring is done by the external service provider Serverguard24 GmbH.   All Corbado hardware and networking is routinely updated and audited to ensure systems are secure and that least privileged access is followed. Additionally we implement robust logging and audit protocols that allow us high visibility into system use.  ### Responsible disclosure program Here at Corbado, we take the security of our user’s data and of our services seriously. As such, we encourage responsible security research on Corbado services and products. If you believe you’ve discovered a potential vulnerability, please let us know by emailing us at [security@corbado.com](mailto:security@corbado.com). We will acknowledge your email within 2 business days. As public disclosures of a security vulnerability could put the entire Corbado community at risk, we ask that you keep such potential vulnerabilities confidential until we are able to address them. We aim to resolve critical issues within 30 days of disclosure. Please make a good faith effort to avoid violating privacy, destroying data, or interrupting or degrading the Corbado service. Please only interact with accounts you own or for which you have explicit permission from the account holder. While researching, please refrain from:  - Distributed Denial of Service (DDoS) - Spamming - Social engineering or phishing of Corbado employees or contractors - Any attacks against Corbado's physical property or data centers  Thank you for helping to keep Corbado and our users safe!  ### Rate limiting At Corbado, we apply rate limit policies on our APIs in order to protect your application and user management infrastructure, so your users will have a frictionless non-interrupted experience.  Corbado responds with HTTP status code 429 (too many requests) when the rate limits exceed. Your code logic should be able to handle such cases by checking the status code on the response and recovering from such cases. If a retry is needed, it is best to allow for a back-off to avoid going into an infinite retry loop.  The current rate limit for all our API endpoints is **max. 100 requests per 10 seconds**.  ## Privacy Corbado is committed to protecting the personal data of our customers and their customers. Corbado has in place appropriate data security measures that meet industry standards. We regularly review and make enhancements to our processes, products, documentation, and contracts to help support ours and our customers’ compliance for the processing of personal data.  We try to minimize the usage and processing of personally identifiable information. Therefore, all our services are constructed to avoid unnecessary data consumption.  To make our services work, we only require the following data: - any kind of identifier (e.g. UUID, phone number, email address) - IP address (only temporarily for rate limiting aspects) - User agent (for device management) 
 *
 * The version of the OpenAPI document: 1.0.0
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
 * WebAuthnCredentialItemRsp
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-21T11:14:23.049718350Z[Etc/UTC]", comments = "Generator version: 7.7.0-SNAPSHOT")
public class WebAuthnCredentialItemRsp {
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

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_CREDENTIAL_HASH = "credentialHash";
  @SerializedName(SERIALIZED_NAME_CREDENTIAL_HASH)
  private String credentialHash;

  public static final String SERIALIZED_NAME_AAGUID = "aaguid";
  @SerializedName(SERIALIZED_NAME_AAGUID)
  private String aaguid;

  public static final String SERIALIZED_NAME_ATTESTATION_TYPE = "attestationType";
  @SerializedName(SERIALIZED_NAME_ATTESTATION_TYPE)
  private String attestationType;

  public static final String SERIALIZED_NAME_BACKUP_STATE = "backupState";
  @SerializedName(SERIALIZED_NAME_BACKUP_STATE)
  private Boolean backupState;

  public static final String SERIALIZED_NAME_BACKUP_ELIGIBLE = "backupEligible";
  @SerializedName(SERIALIZED_NAME_BACKUP_ELIGIBLE)
  private Boolean backupEligible;

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
  private List<TransportEnum> transport = new ArrayList<>();

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
  private StatusEnum status;

  public static final String SERIALIZED_NAME_USER_AGENT = "userAgent";
  @SerializedName(SERIALIZED_NAME_USER_AGENT)
  private String userAgent;

  public static final String SERIALIZED_NAME_CREATED = "created";
  @SerializedName(SERIALIZED_NAME_CREATED)
  private String created;

  public static final String SERIALIZED_NAME_AUTHENTICATOR_I_D = "authenticatorID";
  @SerializedName(SERIALIZED_NAME_AUTHENTICATOR_I_D)
  private String authenticatorID;

  public static final String SERIALIZED_NAME_AUTHENTICATOR_NAME = "authenticatorName";
  @SerializedName(SERIALIZED_NAME_AUTHENTICATOR_NAME)
  private String authenticatorName;

  public static final String SERIALIZED_NAME_LAST_USED = "lastUsed";
  @SerializedName(SERIALIZED_NAME_LAST_USED)
  private String lastUsed;

  public static final String SERIALIZED_NAME_LAST_USED_DEVICE_NAME = "lastUsedDeviceName";
  @SerializedName(SERIALIZED_NAME_LAST_USED_DEVICE_NAME)
  private String lastUsedDeviceName;

  public WebAuthnCredentialItemRsp() {
  }

  public WebAuthnCredentialItemRsp httpStatusCode(Integer httpStatusCode) {
    this.httpStatusCode = httpStatusCode;
    return this;
  }

   /**
   * HTTP status code of operation
   * minimum: 200
   * maximum: 599
   * @return httpStatusCode
  **/
  @javax.annotation.Nonnull
  public Integer getHttpStatusCode() {
    return httpStatusCode;
  }

  public void setHttpStatusCode(Integer httpStatusCode) {
    this.httpStatusCode = httpStatusCode;
  }


  public WebAuthnCredentialItemRsp message(String message) {
    this.message = message;
    return this;
  }

   /**
   * Get message
   * @return message
  **/
  @javax.annotation.Nonnull
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  public WebAuthnCredentialItemRsp requestData(RequestData requestData) {
    this.requestData = requestData;
    return this;
  }

   /**
   * Get requestData
   * @return requestData
  **/
  @javax.annotation.Nonnull
  public RequestData getRequestData() {
    return requestData;
  }

  public void setRequestData(RequestData requestData) {
    this.requestData = requestData;
  }


  public WebAuthnCredentialItemRsp runtime(Float runtime) {
    this.runtime = runtime;
    return this;
  }

   /**
   * Runtime in seconds for this request
   * @return runtime
  **/
  @javax.annotation.Nonnull
  public Float getRuntime() {
    return runtime;
  }

  public void setRuntime(Float runtime) {
    this.runtime = runtime;
  }


  public WebAuthnCredentialItemRsp id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Credential ID
   * @return id
  **/
  @javax.annotation.Nonnull
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public WebAuthnCredentialItemRsp credentialHash(String credentialHash) {
    this.credentialHash = credentialHash;
    return this;
  }

   /**
   * Get credentialHash
   * @return credentialHash
  **/
  @javax.annotation.Nonnull
  public String getCredentialHash() {
    return credentialHash;
  }

  public void setCredentialHash(String credentialHash) {
    this.credentialHash = credentialHash;
  }


  public WebAuthnCredentialItemRsp aaguid(String aaguid) {
    this.aaguid = aaguid;
    return this;
  }

   /**
   * Get aaguid
   * @return aaguid
  **/
  @javax.annotation.Nonnull
  public String getAaguid() {
    return aaguid;
  }

  public void setAaguid(String aaguid) {
    this.aaguid = aaguid;
  }


  public WebAuthnCredentialItemRsp attestationType(String attestationType) {
    this.attestationType = attestationType;
    return this;
  }

   /**
   * Get attestationType
   * @return attestationType
  **/
  @javax.annotation.Nonnull
  public String getAttestationType() {
    return attestationType;
  }

  public void setAttestationType(String attestationType) {
    this.attestationType = attestationType;
  }


  public WebAuthnCredentialItemRsp backupState(Boolean backupState) {
    this.backupState = backupState;
    return this;
  }

   /**
   * Backup state
   * @return backupState
  **/
  @javax.annotation.Nullable
  public Boolean getBackupState() {
    return backupState;
  }

  public void setBackupState(Boolean backupState) {
    this.backupState = backupState;
  }


  public WebAuthnCredentialItemRsp backupEligible(Boolean backupEligible) {
    this.backupEligible = backupEligible;
    return this;
  }

   /**
   * Backup eligible
   * @return backupEligible
  **/
  @javax.annotation.Nonnull
  public Boolean getBackupEligible() {
    return backupEligible;
  }

  public void setBackupEligible(Boolean backupEligible) {
    this.backupEligible = backupEligible;
  }


  public WebAuthnCredentialItemRsp transport(List<TransportEnum> transport) {
    this.transport = transport;
    return this;
  }

  public WebAuthnCredentialItemRsp addTransportItem(TransportEnum transportItem) {
    if (this.transport == null) {
      this.transport = new ArrayList<>();
    }
    this.transport.add(transportItem);
    return this;
  }

   /**
   * Transport
   * @return transport
  **/
  @javax.annotation.Nonnull
  public List<TransportEnum> getTransport() {
    return transport;
  }

  public void setTransport(List<TransportEnum> transport) {
    this.transport = transport;
  }


  public WebAuthnCredentialItemRsp status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Status
   * @return status
  **/
  @javax.annotation.Nonnull
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  public WebAuthnCredentialItemRsp userAgent(String userAgent) {
    this.userAgent = userAgent;
    return this;
  }

   /**
   * User agent
   * @return userAgent
  **/
  @javax.annotation.Nonnull
  public String getUserAgent() {
    return userAgent;
  }

  public void setUserAgent(String userAgent) {
    this.userAgent = userAgent;
  }


  public WebAuthnCredentialItemRsp created(String created) {
    this.created = created;
    return this;
  }

   /**
   * Timestamp of when the entity was created in yyyy-MM-dd&#39;T&#39;HH:mm:ss format
   * @return created
  **/
  @javax.annotation.Nonnull
  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }


  public WebAuthnCredentialItemRsp authenticatorID(String authenticatorID) {
    this.authenticatorID = authenticatorID;
    return this;
  }

   /**
   * Authenticator ID
   * @return authenticatorID
  **/
  @javax.annotation.Nonnull
  public String getAuthenticatorID() {
    return authenticatorID;
  }

  public void setAuthenticatorID(String authenticatorID) {
    this.authenticatorID = authenticatorID;
  }


  public WebAuthnCredentialItemRsp authenticatorName(String authenticatorName) {
    this.authenticatorName = authenticatorName;
    return this;
  }

   /**
   * Get authenticatorName
   * @return authenticatorName
  **/
  @javax.annotation.Nonnull
  public String getAuthenticatorName() {
    return authenticatorName;
  }

  public void setAuthenticatorName(String authenticatorName) {
    this.authenticatorName = authenticatorName;
  }


  public WebAuthnCredentialItemRsp lastUsed(String lastUsed) {
    this.lastUsed = lastUsed;
    return this;
  }

   /**
   * Timestamp of when the passkey was last used in yyyy-MM-dd&#39;T&#39;HH:mm:ss format
   * @return lastUsed
  **/
  @javax.annotation.Nonnull
  public String getLastUsed() {
    return lastUsed;
  }

  public void setLastUsed(String lastUsed) {
    this.lastUsed = lastUsed;
  }


  public WebAuthnCredentialItemRsp lastUsedDeviceName(String lastUsedDeviceName) {
    this.lastUsedDeviceName = lastUsedDeviceName;
    return this;
  }

   /**
   * Get lastUsedDeviceName
   * @return lastUsedDeviceName
  **/
  @javax.annotation.Nonnull
  public String getLastUsedDeviceName() {
    return lastUsedDeviceName;
  }

  public void setLastUsedDeviceName(String lastUsedDeviceName) {
    this.lastUsedDeviceName = lastUsedDeviceName;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WebAuthnCredentialItemRsp webAuthnCredentialItemRsp = (WebAuthnCredentialItemRsp) o;
    return Objects.equals(this.httpStatusCode, webAuthnCredentialItemRsp.httpStatusCode) &&
        Objects.equals(this.message, webAuthnCredentialItemRsp.message) &&
        Objects.equals(this.requestData, webAuthnCredentialItemRsp.requestData) &&
        Objects.equals(this.runtime, webAuthnCredentialItemRsp.runtime) &&
        Objects.equals(this.id, webAuthnCredentialItemRsp.id) &&
        Objects.equals(this.credentialHash, webAuthnCredentialItemRsp.credentialHash) &&
        Objects.equals(this.aaguid, webAuthnCredentialItemRsp.aaguid) &&
        Objects.equals(this.attestationType, webAuthnCredentialItemRsp.attestationType) &&
        Objects.equals(this.backupState, webAuthnCredentialItemRsp.backupState) &&
        Objects.equals(this.backupEligible, webAuthnCredentialItemRsp.backupEligible) &&
        Objects.equals(this.transport, webAuthnCredentialItemRsp.transport) &&
        Objects.equals(this.status, webAuthnCredentialItemRsp.status) &&
        Objects.equals(this.userAgent, webAuthnCredentialItemRsp.userAgent) &&
        Objects.equals(this.created, webAuthnCredentialItemRsp.created) &&
        Objects.equals(this.authenticatorID, webAuthnCredentialItemRsp.authenticatorID) &&
        Objects.equals(this.authenticatorName, webAuthnCredentialItemRsp.authenticatorName) &&
        Objects.equals(this.lastUsed, webAuthnCredentialItemRsp.lastUsed) &&
        Objects.equals(this.lastUsedDeviceName, webAuthnCredentialItemRsp.lastUsedDeviceName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(httpStatusCode, message, requestData, runtime, id, credentialHash, aaguid, attestationType, backupState, backupEligible, transport, status, userAgent, created, authenticatorID, authenticatorName, lastUsed, lastUsedDeviceName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WebAuthnCredentialItemRsp {\n");
    sb.append("    httpStatusCode: ").append(toIndentedString(httpStatusCode)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    requestData: ").append(toIndentedString(requestData)).append("\n");
    sb.append("    runtime: ").append(toIndentedString(runtime)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    credentialHash: ").append(toIndentedString(credentialHash)).append("\n");
    sb.append("    aaguid: ").append(toIndentedString(aaguid)).append("\n");
    sb.append("    attestationType: ").append(toIndentedString(attestationType)).append("\n");
    sb.append("    backupState: ").append(toIndentedString(backupState)).append("\n");
    sb.append("    backupEligible: ").append(toIndentedString(backupEligible)).append("\n");
    sb.append("    transport: ").append(toIndentedString(transport)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    userAgent: ").append(toIndentedString(userAgent)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    authenticatorID: ").append(toIndentedString(authenticatorID)).append("\n");
    sb.append("    authenticatorName: ").append(toIndentedString(authenticatorName)).append("\n");
    sb.append("    lastUsed: ").append(toIndentedString(lastUsed)).append("\n");
    sb.append("    lastUsedDeviceName: ").append(toIndentedString(lastUsedDeviceName)).append("\n");
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
    openapiFields.add("id");
    openapiFields.add("credentialHash");
    openapiFields.add("aaguid");
    openapiFields.add("attestationType");
    openapiFields.add("backupState");
    openapiFields.add("backupEligible");
    openapiFields.add("transport");
    openapiFields.add("status");
    openapiFields.add("userAgent");
    openapiFields.add("created");
    openapiFields.add("authenticatorID");
    openapiFields.add("authenticatorName");
    openapiFields.add("lastUsed");
    openapiFields.add("lastUsedDeviceName");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("httpStatusCode");
    openapiRequiredFields.add("message");
    openapiRequiredFields.add("requestData");
    openapiRequiredFields.add("runtime");
    openapiRequiredFields.add("id");
    openapiRequiredFields.add("credentialHash");
    openapiRequiredFields.add("aaguid");
    openapiRequiredFields.add("attestationType");
    openapiRequiredFields.add("backupEligible");
    openapiRequiredFields.add("transport");
    openapiRequiredFields.add("status");
    openapiRequiredFields.add("userAgent");
    openapiRequiredFields.add("created");
    openapiRequiredFields.add("authenticatorID");
    openapiRequiredFields.add("authenticatorName");
    openapiRequiredFields.add("lastUsed");
    openapiRequiredFields.add("lastUsedDeviceName");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to WebAuthnCredentialItemRsp
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!WebAuthnCredentialItemRsp.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in WebAuthnCredentialItemRsp is not found in the empty JSON string", WebAuthnCredentialItemRsp.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!WebAuthnCredentialItemRsp.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `WebAuthnCredentialItemRsp` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : WebAuthnCredentialItemRsp.openapiRequiredFields) {
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
      if (!jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if (!jsonObj.get("credentialHash").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `credentialHash` to be a primitive type in the JSON string but got `%s`", jsonObj.get("credentialHash").toString()));
      }
      if (!jsonObj.get("aaguid").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `aaguid` to be a primitive type in the JSON string but got `%s`", jsonObj.get("aaguid").toString()));
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
      if (!jsonObj.get("status").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `status` to be a primitive type in the JSON string but got `%s`", jsonObj.get("status").toString()));
      }
      // validate the required field `status`
      StatusEnum.validateJsonElement(jsonObj.get("status"));
      if (!jsonObj.get("userAgent").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `userAgent` to be a primitive type in the JSON string but got `%s`", jsonObj.get("userAgent").toString()));
      }
      if (!jsonObj.get("created").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `created` to be a primitive type in the JSON string but got `%s`", jsonObj.get("created").toString()));
      }
      if (!jsonObj.get("authenticatorID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `authenticatorID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("authenticatorID").toString()));
      }
      if (!jsonObj.get("authenticatorName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `authenticatorName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("authenticatorName").toString()));
      }
      if (!jsonObj.get("lastUsed").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `lastUsed` to be a primitive type in the JSON string but got `%s`", jsonObj.get("lastUsed").toString()));
      }
      if (!jsonObj.get("lastUsedDeviceName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `lastUsedDeviceName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("lastUsedDeviceName").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!WebAuthnCredentialItemRsp.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'WebAuthnCredentialItemRsp' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<WebAuthnCredentialItemRsp> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(WebAuthnCredentialItemRsp.class));

       return (TypeAdapter<T>) new TypeAdapter<WebAuthnCredentialItemRsp>() {
           @Override
           public void write(JsonWriter out, WebAuthnCredentialItemRsp value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public WebAuthnCredentialItemRsp read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of WebAuthnCredentialItemRsp given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of WebAuthnCredentialItemRsp
  * @throws IOException if the JSON string is invalid with respect to WebAuthnCredentialItemRsp
  */
  public static WebAuthnCredentialItemRsp fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, WebAuthnCredentialItemRsp.class);
  }

 /**
  * Convert an instance of WebAuthnCredentialItemRsp to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

