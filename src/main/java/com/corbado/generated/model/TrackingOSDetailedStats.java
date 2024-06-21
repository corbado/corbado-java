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
 * TrackingOSDetailedStats
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-21T11:14:23.049718350Z[Etc/UTC]", comments = "Generator version: 7.7.0-SNAPSHOT")
public class TrackingOSDetailedStats {
  public static final String SERIALIZED_NAME_TIME_POINT = "timePoint";
  @SerializedName(SERIALIZED_NAME_TIME_POINT)
  private String timePoint;

  public static final String SERIALIZED_NAME_OS_NAME = "osName";
  @SerializedName(SERIALIZED_NAME_OS_NAME)
  private String osName;

  public static final String SERIALIZED_NAME_OS_VERSION = "osVersion";
  @SerializedName(SERIALIZED_NAME_OS_VERSION)
  private String osVersion;

  /**
   * Gets or Sets osPlatform
   */
  @JsonAdapter(OsPlatformEnum.Adapter.class)
  public enum OsPlatformEnum {
    DESKTOP("desktop"),
    
    MOBILE("mobile"),
    
    UNKNOWN("unknown");

    private String value;

    OsPlatformEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static OsPlatformEnum fromValue(String value) {
      for (OsPlatformEnum b : OsPlatformEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<OsPlatformEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final OsPlatformEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public OsPlatformEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return OsPlatformEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      OsPlatformEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_OS_PLATFORM = "osPlatform";
  @SerializedName(SERIALIZED_NAME_OS_PLATFORM)
  private OsPlatformEnum osPlatform;

  public static final String SERIALIZED_NAME_CNT = "cnt";
  @SerializedName(SERIALIZED_NAME_CNT)
  private Integer cnt;

  public static final String SERIALIZED_NAME_WEBAUTHN = "webauthn";
  @SerializedName(SERIALIZED_NAME_WEBAUTHN)
  private Integer webauthn;

  public static final String SERIALIZED_NAME_PLATFORM = "platform";
  @SerializedName(SERIALIZED_NAME_PLATFORM)
  private Integer platform;

  public static final String SERIALIZED_NAME_CONDITIONAL_UI = "conditional_ui";
  @SerializedName(SERIALIZED_NAME_CONDITIONAL_UI)
  private Integer conditionalUi;

  public TrackingOSDetailedStats() {
  }

  public TrackingOSDetailedStats timePoint(String timePoint) {
    this.timePoint = timePoint;
    return this;
  }

   /**
   * Get timePoint
   * @return timePoint
  **/
  @javax.annotation.Nonnull
  public String getTimePoint() {
    return timePoint;
  }

  public void setTimePoint(String timePoint) {
    this.timePoint = timePoint;
  }


  public TrackingOSDetailedStats osName(String osName) {
    this.osName = osName;
    return this;
  }

   /**
   * Get osName
   * @return osName
  **/
  @javax.annotation.Nonnull
  public String getOsName() {
    return osName;
  }

  public void setOsName(String osName) {
    this.osName = osName;
  }


  public TrackingOSDetailedStats osVersion(String osVersion) {
    this.osVersion = osVersion;
    return this;
  }

   /**
   * Get osVersion
   * @return osVersion
  **/
  @javax.annotation.Nonnull
  public String getOsVersion() {
    return osVersion;
  }

  public void setOsVersion(String osVersion) {
    this.osVersion = osVersion;
  }


  public TrackingOSDetailedStats osPlatform(OsPlatformEnum osPlatform) {
    this.osPlatform = osPlatform;
    return this;
  }

   /**
   * Get osPlatform
   * @return osPlatform
  **/
  @javax.annotation.Nonnull
  public OsPlatformEnum getOsPlatform() {
    return osPlatform;
  }

  public void setOsPlatform(OsPlatformEnum osPlatform) {
    this.osPlatform = osPlatform;
  }


  public TrackingOSDetailedStats cnt(Integer cnt) {
    this.cnt = cnt;
    return this;
  }

   /**
   * Get cnt
   * @return cnt
  **/
  @javax.annotation.Nonnull
  public Integer getCnt() {
    return cnt;
  }

  public void setCnt(Integer cnt) {
    this.cnt = cnt;
  }


  public TrackingOSDetailedStats webauthn(Integer webauthn) {
    this.webauthn = webauthn;
    return this;
  }

   /**
   * Get webauthn
   * @return webauthn
  **/
  @javax.annotation.Nonnull
  public Integer getWebauthn() {
    return webauthn;
  }

  public void setWebauthn(Integer webauthn) {
    this.webauthn = webauthn;
  }


  public TrackingOSDetailedStats platform(Integer platform) {
    this.platform = platform;
    return this;
  }

   /**
   * Get platform
   * @return platform
  **/
  @javax.annotation.Nonnull
  public Integer getPlatform() {
    return platform;
  }

  public void setPlatform(Integer platform) {
    this.platform = platform;
  }


  public TrackingOSDetailedStats conditionalUi(Integer conditionalUi) {
    this.conditionalUi = conditionalUi;
    return this;
  }

   /**
   * Get conditionalUi
   * @return conditionalUi
  **/
  @javax.annotation.Nonnull
  public Integer getConditionalUi() {
    return conditionalUi;
  }

  public void setConditionalUi(Integer conditionalUi) {
    this.conditionalUi = conditionalUi;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TrackingOSDetailedStats trackingOSDetailedStats = (TrackingOSDetailedStats) o;
    return Objects.equals(this.timePoint, trackingOSDetailedStats.timePoint) &&
        Objects.equals(this.osName, trackingOSDetailedStats.osName) &&
        Objects.equals(this.osVersion, trackingOSDetailedStats.osVersion) &&
        Objects.equals(this.osPlatform, trackingOSDetailedStats.osPlatform) &&
        Objects.equals(this.cnt, trackingOSDetailedStats.cnt) &&
        Objects.equals(this.webauthn, trackingOSDetailedStats.webauthn) &&
        Objects.equals(this.platform, trackingOSDetailedStats.platform) &&
        Objects.equals(this.conditionalUi, trackingOSDetailedStats.conditionalUi);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timePoint, osName, osVersion, osPlatform, cnt, webauthn, platform, conditionalUi);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TrackingOSDetailedStats {\n");
    sb.append("    timePoint: ").append(toIndentedString(timePoint)).append("\n");
    sb.append("    osName: ").append(toIndentedString(osName)).append("\n");
    sb.append("    osVersion: ").append(toIndentedString(osVersion)).append("\n");
    sb.append("    osPlatform: ").append(toIndentedString(osPlatform)).append("\n");
    sb.append("    cnt: ").append(toIndentedString(cnt)).append("\n");
    sb.append("    webauthn: ").append(toIndentedString(webauthn)).append("\n");
    sb.append("    platform: ").append(toIndentedString(platform)).append("\n");
    sb.append("    conditionalUi: ").append(toIndentedString(conditionalUi)).append("\n");
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
    openapiFields.add("timePoint");
    openapiFields.add("osName");
    openapiFields.add("osVersion");
    openapiFields.add("osPlatform");
    openapiFields.add("cnt");
    openapiFields.add("webauthn");
    openapiFields.add("platform");
    openapiFields.add("conditional_ui");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("timePoint");
    openapiRequiredFields.add("osName");
    openapiRequiredFields.add("osVersion");
    openapiRequiredFields.add("osPlatform");
    openapiRequiredFields.add("cnt");
    openapiRequiredFields.add("webauthn");
    openapiRequiredFields.add("platform");
    openapiRequiredFields.add("conditional_ui");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to TrackingOSDetailedStats
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!TrackingOSDetailedStats.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in TrackingOSDetailedStats is not found in the empty JSON string", TrackingOSDetailedStats.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!TrackingOSDetailedStats.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `TrackingOSDetailedStats` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : TrackingOSDetailedStats.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("timePoint").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `timePoint` to be a primitive type in the JSON string but got `%s`", jsonObj.get("timePoint").toString()));
      }
      if (!jsonObj.get("osName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `osName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("osName").toString()));
      }
      if (!jsonObj.get("osVersion").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `osVersion` to be a primitive type in the JSON string but got `%s`", jsonObj.get("osVersion").toString()));
      }
      if (!jsonObj.get("osPlatform").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `osPlatform` to be a primitive type in the JSON string but got `%s`", jsonObj.get("osPlatform").toString()));
      }
      // validate the required field `osPlatform`
      OsPlatformEnum.validateJsonElement(jsonObj.get("osPlatform"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!TrackingOSDetailedStats.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'TrackingOSDetailedStats' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<TrackingOSDetailedStats> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(TrackingOSDetailedStats.class));

       return (TypeAdapter<T>) new TypeAdapter<TrackingOSDetailedStats>() {
           @Override
           public void write(JsonWriter out, TrackingOSDetailedStats value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public TrackingOSDetailedStats read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of TrackingOSDetailedStats given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of TrackingOSDetailedStats
  * @throws IOException if the JSON string is invalid with respect to TrackingOSDetailedStats
  */
  public static TrackingOSDetailedStats fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, TrackingOSDetailedStats.class);
  }

 /**
  * Convert an instance of TrackingOSDetailedStats to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

