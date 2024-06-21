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
import com.corbado.generated.model.AppType;
import com.corbado.generated.model.ClientInfo;
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
 * SessionConfigUpdateReq
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-21T11:14:23.049718350Z[Etc/UTC]", comments = "Generator version: 7.7.0-SNAPSHOT")
public class SessionConfigUpdateReq {
  public static final String SERIALIZED_NAME_APP_TYPE = "appType";
  @SerializedName(SERIALIZED_NAME_APP_TYPE)
  private AppType appType;

  public static final String SERIALIZED_NAME_ACTIVE = "active";
  @SerializedName(SERIALIZED_NAME_ACTIVE)
  private Boolean active;

  public static final String SERIALIZED_NAME_SHORT_LIFETIME_MINUTES = "shortLifetimeMinutes";
  @SerializedName(SERIALIZED_NAME_SHORT_LIFETIME_MINUTES)
  private Integer shortLifetimeMinutes;

  public static final String SERIALIZED_NAME_SHORT_COOKIE_DOMAIN = "shortCookieDomain";
  @SerializedName(SERIALIZED_NAME_SHORT_COOKIE_DOMAIN)
  private String shortCookieDomain;

  public static final String SERIALIZED_NAME_SHORT_COOKIE_SECURE = "shortCookieSecure";
  @SerializedName(SERIALIZED_NAME_SHORT_COOKIE_SECURE)
  private Boolean shortCookieSecure;

  /**
   * Gets or Sets shortCookieSameSite
   */
  @JsonAdapter(ShortCookieSameSiteEnum.Adapter.class)
  public enum ShortCookieSameSiteEnum {
    LAX("lax"),
    
    STRICT("strict"),
    
    NONE("none");

    private String value;

    ShortCookieSameSiteEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ShortCookieSameSiteEnum fromValue(String value) {
      for (ShortCookieSameSiteEnum b : ShortCookieSameSiteEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ShortCookieSameSiteEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ShortCookieSameSiteEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ShortCookieSameSiteEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ShortCookieSameSiteEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      ShortCookieSameSiteEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_SHORT_COOKIE_SAME_SITE = "shortCookieSameSite";
  @SerializedName(SERIALIZED_NAME_SHORT_COOKIE_SAME_SITE)
  private ShortCookieSameSiteEnum shortCookieSameSite;

  public static final String SERIALIZED_NAME_LONG_LIFETIME_VALUE = "longLifetimeValue";
  @SerializedName(SERIALIZED_NAME_LONG_LIFETIME_VALUE)
  private Integer longLifetimeValue;

  /**
   * Gets or Sets longLifetimeUnit
   */
  @JsonAdapter(LongLifetimeUnitEnum.Adapter.class)
  public enum LongLifetimeUnitEnum {
    MIN("min"),
    
    HOUR("hour");

    private String value;

    LongLifetimeUnitEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static LongLifetimeUnitEnum fromValue(String value) {
      for (LongLifetimeUnitEnum b : LongLifetimeUnitEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<LongLifetimeUnitEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final LongLifetimeUnitEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public LongLifetimeUnitEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return LongLifetimeUnitEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      LongLifetimeUnitEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_LONG_LIFETIME_UNIT = "longLifetimeUnit";
  @SerializedName(SERIALIZED_NAME_LONG_LIFETIME_UNIT)
  private LongLifetimeUnitEnum longLifetimeUnit;

  public static final String SERIALIZED_NAME_LONG_INACTIVITY_VALUE = "longInactivityValue";
  @SerializedName(SERIALIZED_NAME_LONG_INACTIVITY_VALUE)
  private Integer longInactivityValue;

  /**
   * Gets or Sets longInactivityUnit
   */
  @JsonAdapter(LongInactivityUnitEnum.Adapter.class)
  public enum LongInactivityUnitEnum {
    MIN("min"),
    
    HOUR("hour");

    private String value;

    LongInactivityUnitEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static LongInactivityUnitEnum fromValue(String value) {
      for (LongInactivityUnitEnum b : LongInactivityUnitEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<LongInactivityUnitEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final LongInactivityUnitEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public LongInactivityUnitEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return LongInactivityUnitEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      LongInactivityUnitEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_LONG_INACTIVITY_UNIT = "longInactivityUnit";
  @SerializedName(SERIALIZED_NAME_LONG_INACTIVITY_UNIT)
  private LongInactivityUnitEnum longInactivityUnit;

  public static final String SERIALIZED_NAME_JWT_AUDIENCE = "jwtAudience";
  @SerializedName(SERIALIZED_NAME_JWT_AUDIENCE)
  private String jwtAudience;

  public static final String SERIALIZED_NAME_REQUEST_I_D = "requestID";
  @SerializedName(SERIALIZED_NAME_REQUEST_I_D)
  private String requestID;

  public static final String SERIALIZED_NAME_CLIENT_INFO = "clientInfo";
  @SerializedName(SERIALIZED_NAME_CLIENT_INFO)
  private ClientInfo clientInfo;

  public SessionConfigUpdateReq() {
  }

  public SessionConfigUpdateReq appType(AppType appType) {
    this.appType = appType;
    return this;
  }

   /**
   * Get appType
   * @return appType
  **/
  @javax.annotation.Nonnull
  public AppType getAppType() {
    return appType;
  }

  public void setAppType(AppType appType) {
    this.appType = appType;
  }


  public SessionConfigUpdateReq active(Boolean active) {
    this.active = active;
    return this;
  }

   /**
   * Get active
   * @return active
  **/
  @javax.annotation.Nullable
  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }


  public SessionConfigUpdateReq shortLifetimeMinutes(Integer shortLifetimeMinutes) {
    this.shortLifetimeMinutes = shortLifetimeMinutes;
    return this;
  }

   /**
   * Get shortLifetimeMinutes
   * @return shortLifetimeMinutes
  **/
  @javax.annotation.Nullable
  public Integer getShortLifetimeMinutes() {
    return shortLifetimeMinutes;
  }

  public void setShortLifetimeMinutes(Integer shortLifetimeMinutes) {
    this.shortLifetimeMinutes = shortLifetimeMinutes;
  }


  public SessionConfigUpdateReq shortCookieDomain(String shortCookieDomain) {
    this.shortCookieDomain = shortCookieDomain;
    return this;
  }

   /**
   * Get shortCookieDomain
   * @return shortCookieDomain
  **/
  @javax.annotation.Nullable
  public String getShortCookieDomain() {
    return shortCookieDomain;
  }

  public void setShortCookieDomain(String shortCookieDomain) {
    this.shortCookieDomain = shortCookieDomain;
  }


  public SessionConfigUpdateReq shortCookieSecure(Boolean shortCookieSecure) {
    this.shortCookieSecure = shortCookieSecure;
    return this;
  }

   /**
   * Get shortCookieSecure
   * @return shortCookieSecure
  **/
  @javax.annotation.Nullable
  public Boolean getShortCookieSecure() {
    return shortCookieSecure;
  }

  public void setShortCookieSecure(Boolean shortCookieSecure) {
    this.shortCookieSecure = shortCookieSecure;
  }


  public SessionConfigUpdateReq shortCookieSameSite(ShortCookieSameSiteEnum shortCookieSameSite) {
    this.shortCookieSameSite = shortCookieSameSite;
    return this;
  }

   /**
   * Get shortCookieSameSite
   * @return shortCookieSameSite
  **/
  @javax.annotation.Nullable
  public ShortCookieSameSiteEnum getShortCookieSameSite() {
    return shortCookieSameSite;
  }

  public void setShortCookieSameSite(ShortCookieSameSiteEnum shortCookieSameSite) {
    this.shortCookieSameSite = shortCookieSameSite;
  }


  public SessionConfigUpdateReq longLifetimeValue(Integer longLifetimeValue) {
    this.longLifetimeValue = longLifetimeValue;
    return this;
  }

   /**
   * Get longLifetimeValue
   * @return longLifetimeValue
  **/
  @javax.annotation.Nullable
  public Integer getLongLifetimeValue() {
    return longLifetimeValue;
  }

  public void setLongLifetimeValue(Integer longLifetimeValue) {
    this.longLifetimeValue = longLifetimeValue;
  }


  public SessionConfigUpdateReq longLifetimeUnit(LongLifetimeUnitEnum longLifetimeUnit) {
    this.longLifetimeUnit = longLifetimeUnit;
    return this;
  }

   /**
   * Get longLifetimeUnit
   * @return longLifetimeUnit
  **/
  @javax.annotation.Nullable
  public LongLifetimeUnitEnum getLongLifetimeUnit() {
    return longLifetimeUnit;
  }

  public void setLongLifetimeUnit(LongLifetimeUnitEnum longLifetimeUnit) {
    this.longLifetimeUnit = longLifetimeUnit;
  }


  public SessionConfigUpdateReq longInactivityValue(Integer longInactivityValue) {
    this.longInactivityValue = longInactivityValue;
    return this;
  }

   /**
   * Get longInactivityValue
   * @return longInactivityValue
  **/
  @javax.annotation.Nullable
  public Integer getLongInactivityValue() {
    return longInactivityValue;
  }

  public void setLongInactivityValue(Integer longInactivityValue) {
    this.longInactivityValue = longInactivityValue;
  }


  public SessionConfigUpdateReq longInactivityUnit(LongInactivityUnitEnum longInactivityUnit) {
    this.longInactivityUnit = longInactivityUnit;
    return this;
  }

   /**
   * Get longInactivityUnit
   * @return longInactivityUnit
  **/
  @javax.annotation.Nullable
  public LongInactivityUnitEnum getLongInactivityUnit() {
    return longInactivityUnit;
  }

  public void setLongInactivityUnit(LongInactivityUnitEnum longInactivityUnit) {
    this.longInactivityUnit = longInactivityUnit;
  }


  public SessionConfigUpdateReq jwtAudience(String jwtAudience) {
    this.jwtAudience = jwtAudience;
    return this;
  }

   /**
   * Get jwtAudience
   * @return jwtAudience
  **/
  @javax.annotation.Nullable
  public String getJwtAudience() {
    return jwtAudience;
  }

  public void setJwtAudience(String jwtAudience) {
    this.jwtAudience = jwtAudience;
  }


  public SessionConfigUpdateReq requestID(String requestID) {
    this.requestID = requestID;
    return this;
  }

   /**
   * Unique ID of request, you can provide your own while making the request, if not the ID will be randomly generated on server side
   * @return requestID
  **/
  @javax.annotation.Nullable
  public String getRequestID() {
    return requestID;
  }

  public void setRequestID(String requestID) {
    this.requestID = requestID;
  }


  public SessionConfigUpdateReq clientInfo(ClientInfo clientInfo) {
    this.clientInfo = clientInfo;
    return this;
  }

   /**
   * Get clientInfo
   * @return clientInfo
  **/
  @javax.annotation.Nullable
  public ClientInfo getClientInfo() {
    return clientInfo;
  }

  public void setClientInfo(ClientInfo clientInfo) {
    this.clientInfo = clientInfo;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SessionConfigUpdateReq sessionConfigUpdateReq = (SessionConfigUpdateReq) o;
    return Objects.equals(this.appType, sessionConfigUpdateReq.appType) &&
        Objects.equals(this.active, sessionConfigUpdateReq.active) &&
        Objects.equals(this.shortLifetimeMinutes, sessionConfigUpdateReq.shortLifetimeMinutes) &&
        Objects.equals(this.shortCookieDomain, sessionConfigUpdateReq.shortCookieDomain) &&
        Objects.equals(this.shortCookieSecure, sessionConfigUpdateReq.shortCookieSecure) &&
        Objects.equals(this.shortCookieSameSite, sessionConfigUpdateReq.shortCookieSameSite) &&
        Objects.equals(this.longLifetimeValue, sessionConfigUpdateReq.longLifetimeValue) &&
        Objects.equals(this.longLifetimeUnit, sessionConfigUpdateReq.longLifetimeUnit) &&
        Objects.equals(this.longInactivityValue, sessionConfigUpdateReq.longInactivityValue) &&
        Objects.equals(this.longInactivityUnit, sessionConfigUpdateReq.longInactivityUnit) &&
        Objects.equals(this.jwtAudience, sessionConfigUpdateReq.jwtAudience) &&
        Objects.equals(this.requestID, sessionConfigUpdateReq.requestID) &&
        Objects.equals(this.clientInfo, sessionConfigUpdateReq.clientInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appType, active, shortLifetimeMinutes, shortCookieDomain, shortCookieSecure, shortCookieSameSite, longLifetimeValue, longLifetimeUnit, longInactivityValue, longInactivityUnit, jwtAudience, requestID, clientInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SessionConfigUpdateReq {\n");
    sb.append("    appType: ").append(toIndentedString(appType)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    shortLifetimeMinutes: ").append(toIndentedString(shortLifetimeMinutes)).append("\n");
    sb.append("    shortCookieDomain: ").append(toIndentedString(shortCookieDomain)).append("\n");
    sb.append("    shortCookieSecure: ").append(toIndentedString(shortCookieSecure)).append("\n");
    sb.append("    shortCookieSameSite: ").append(toIndentedString(shortCookieSameSite)).append("\n");
    sb.append("    longLifetimeValue: ").append(toIndentedString(longLifetimeValue)).append("\n");
    sb.append("    longLifetimeUnit: ").append(toIndentedString(longLifetimeUnit)).append("\n");
    sb.append("    longInactivityValue: ").append(toIndentedString(longInactivityValue)).append("\n");
    sb.append("    longInactivityUnit: ").append(toIndentedString(longInactivityUnit)).append("\n");
    sb.append("    jwtAudience: ").append(toIndentedString(jwtAudience)).append("\n");
    sb.append("    requestID: ").append(toIndentedString(requestID)).append("\n");
    sb.append("    clientInfo: ").append(toIndentedString(clientInfo)).append("\n");
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
    openapiFields.add("appType");
    openapiFields.add("active");
    openapiFields.add("shortLifetimeMinutes");
    openapiFields.add("shortCookieDomain");
    openapiFields.add("shortCookieSecure");
    openapiFields.add("shortCookieSameSite");
    openapiFields.add("longLifetimeValue");
    openapiFields.add("longLifetimeUnit");
    openapiFields.add("longInactivityValue");
    openapiFields.add("longInactivityUnit");
    openapiFields.add("jwtAudience");
    openapiFields.add("requestID");
    openapiFields.add("clientInfo");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("appType");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to SessionConfigUpdateReq
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!SessionConfigUpdateReq.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in SessionConfigUpdateReq is not found in the empty JSON string", SessionConfigUpdateReq.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!SessionConfigUpdateReq.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `SessionConfigUpdateReq` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : SessionConfigUpdateReq.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the required field `appType`
      AppType.validateJsonElement(jsonObj.get("appType"));
      if ((jsonObj.get("shortCookieDomain") != null && !jsonObj.get("shortCookieDomain").isJsonNull()) && !jsonObj.get("shortCookieDomain").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `shortCookieDomain` to be a primitive type in the JSON string but got `%s`", jsonObj.get("shortCookieDomain").toString()));
      }
      if ((jsonObj.get("shortCookieSameSite") != null && !jsonObj.get("shortCookieSameSite").isJsonNull()) && !jsonObj.get("shortCookieSameSite").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `shortCookieSameSite` to be a primitive type in the JSON string but got `%s`", jsonObj.get("shortCookieSameSite").toString()));
      }
      // validate the optional field `shortCookieSameSite`
      if (jsonObj.get("shortCookieSameSite") != null && !jsonObj.get("shortCookieSameSite").isJsonNull()) {
        ShortCookieSameSiteEnum.validateJsonElement(jsonObj.get("shortCookieSameSite"));
      }
      if ((jsonObj.get("longLifetimeUnit") != null && !jsonObj.get("longLifetimeUnit").isJsonNull()) && !jsonObj.get("longLifetimeUnit").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `longLifetimeUnit` to be a primitive type in the JSON string but got `%s`", jsonObj.get("longLifetimeUnit").toString()));
      }
      // validate the optional field `longLifetimeUnit`
      if (jsonObj.get("longLifetimeUnit") != null && !jsonObj.get("longLifetimeUnit").isJsonNull()) {
        LongLifetimeUnitEnum.validateJsonElement(jsonObj.get("longLifetimeUnit"));
      }
      if ((jsonObj.get("longInactivityUnit") != null && !jsonObj.get("longInactivityUnit").isJsonNull()) && !jsonObj.get("longInactivityUnit").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `longInactivityUnit` to be a primitive type in the JSON string but got `%s`", jsonObj.get("longInactivityUnit").toString()));
      }
      // validate the optional field `longInactivityUnit`
      if (jsonObj.get("longInactivityUnit") != null && !jsonObj.get("longInactivityUnit").isJsonNull()) {
        LongInactivityUnitEnum.validateJsonElement(jsonObj.get("longInactivityUnit"));
      }
      if ((jsonObj.get("jwtAudience") != null && !jsonObj.get("jwtAudience").isJsonNull()) && !jsonObj.get("jwtAudience").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `jwtAudience` to be a primitive type in the JSON string but got `%s`", jsonObj.get("jwtAudience").toString()));
      }
      if ((jsonObj.get("requestID") != null && !jsonObj.get("requestID").isJsonNull()) && !jsonObj.get("requestID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `requestID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("requestID").toString()));
      }
      // validate the optional field `clientInfo`
      if (jsonObj.get("clientInfo") != null && !jsonObj.get("clientInfo").isJsonNull()) {
        ClientInfo.validateJsonElement(jsonObj.get("clientInfo"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!SessionConfigUpdateReq.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'SessionConfigUpdateReq' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<SessionConfigUpdateReq> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(SessionConfigUpdateReq.class));

       return (TypeAdapter<T>) new TypeAdapter<SessionConfigUpdateReq>() {
           @Override
           public void write(JsonWriter out, SessionConfigUpdateReq value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public SessionConfigUpdateReq read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of SessionConfigUpdateReq given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of SessionConfigUpdateReq
  * @throws IOException if the JSON string is invalid with respect to SessionConfigUpdateReq
  */
  public static SessionConfigUpdateReq fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, SessionConfigUpdateReq.class);
  }

 /**
  * Convert an instance of SessionConfigUpdateReq to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

