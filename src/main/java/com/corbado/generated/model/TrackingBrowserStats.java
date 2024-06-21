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
 * TrackingBrowserStats
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-21T11:14:23.049718350Z[Etc/UTC]", comments = "Generator version: 7.7.0-SNAPSHOT")
public class TrackingBrowserStats {
  public static final String SERIALIZED_NAME_TIME_POINT = "timePoint";
  @SerializedName(SERIALIZED_NAME_TIME_POINT)
  private String timePoint;

  public static final String SERIALIZED_NAME_CHROME = "chrome";
  @SerializedName(SERIALIZED_NAME_CHROME)
  private Integer chrome;

  public static final String SERIALIZED_NAME_SAFARI = "safari";
  @SerializedName(SERIALIZED_NAME_SAFARI)
  private Integer safari;

  public static final String SERIALIZED_NAME_EDGE = "edge";
  @SerializedName(SERIALIZED_NAME_EDGE)
  private Integer edge;

  public static final String SERIALIZED_NAME_FIREFOX = "firefox";
  @SerializedName(SERIALIZED_NAME_FIREFOX)
  private Integer firefox;

  public static final String SERIALIZED_NAME_OTHER = "other";
  @SerializedName(SERIALIZED_NAME_OTHER)
  private Integer other;

  public TrackingBrowserStats() {
  }

  public TrackingBrowserStats timePoint(String timePoint) {
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


  public TrackingBrowserStats chrome(Integer chrome) {
    this.chrome = chrome;
    return this;
  }

   /**
   * Get chrome
   * @return chrome
  **/
  @javax.annotation.Nonnull
  public Integer getChrome() {
    return chrome;
  }

  public void setChrome(Integer chrome) {
    this.chrome = chrome;
  }


  public TrackingBrowserStats safari(Integer safari) {
    this.safari = safari;
    return this;
  }

   /**
   * Get safari
   * @return safari
  **/
  @javax.annotation.Nonnull
  public Integer getSafari() {
    return safari;
  }

  public void setSafari(Integer safari) {
    this.safari = safari;
  }


  public TrackingBrowserStats edge(Integer edge) {
    this.edge = edge;
    return this;
  }

   /**
   * Get edge
   * @return edge
  **/
  @javax.annotation.Nonnull
  public Integer getEdge() {
    return edge;
  }

  public void setEdge(Integer edge) {
    this.edge = edge;
  }


  public TrackingBrowserStats firefox(Integer firefox) {
    this.firefox = firefox;
    return this;
  }

   /**
   * Get firefox
   * @return firefox
  **/
  @javax.annotation.Nonnull
  public Integer getFirefox() {
    return firefox;
  }

  public void setFirefox(Integer firefox) {
    this.firefox = firefox;
  }


  public TrackingBrowserStats other(Integer other) {
    this.other = other;
    return this;
  }

   /**
   * Get other
   * @return other
  **/
  @javax.annotation.Nonnull
  public Integer getOther() {
    return other;
  }

  public void setOther(Integer other) {
    this.other = other;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TrackingBrowserStats trackingBrowserStats = (TrackingBrowserStats) o;
    return Objects.equals(this.timePoint, trackingBrowserStats.timePoint) &&
        Objects.equals(this.chrome, trackingBrowserStats.chrome) &&
        Objects.equals(this.safari, trackingBrowserStats.safari) &&
        Objects.equals(this.edge, trackingBrowserStats.edge) &&
        Objects.equals(this.firefox, trackingBrowserStats.firefox) &&
        Objects.equals(this.other, trackingBrowserStats.other);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timePoint, chrome, safari, edge, firefox, other);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TrackingBrowserStats {\n");
    sb.append("    timePoint: ").append(toIndentedString(timePoint)).append("\n");
    sb.append("    chrome: ").append(toIndentedString(chrome)).append("\n");
    sb.append("    safari: ").append(toIndentedString(safari)).append("\n");
    sb.append("    edge: ").append(toIndentedString(edge)).append("\n");
    sb.append("    firefox: ").append(toIndentedString(firefox)).append("\n");
    sb.append("    other: ").append(toIndentedString(other)).append("\n");
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
    openapiFields.add("chrome");
    openapiFields.add("safari");
    openapiFields.add("edge");
    openapiFields.add("firefox");
    openapiFields.add("other");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("timePoint");
    openapiRequiredFields.add("chrome");
    openapiRequiredFields.add("safari");
    openapiRequiredFields.add("edge");
    openapiRequiredFields.add("firefox");
    openapiRequiredFields.add("other");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to TrackingBrowserStats
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!TrackingBrowserStats.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in TrackingBrowserStats is not found in the empty JSON string", TrackingBrowserStats.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!TrackingBrowserStats.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `TrackingBrowserStats` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : TrackingBrowserStats.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("timePoint").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `timePoint` to be a primitive type in the JSON string but got `%s`", jsonObj.get("timePoint").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!TrackingBrowserStats.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'TrackingBrowserStats' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<TrackingBrowserStats> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(TrackingBrowserStats.class));

       return (TypeAdapter<T>) new TypeAdapter<TrackingBrowserStats>() {
           @Override
           public void write(JsonWriter out, TrackingBrowserStats value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public TrackingBrowserStats read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of TrackingBrowserStats given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of TrackingBrowserStats
  * @throws IOException if the JSON string is invalid with respect to TrackingBrowserStats
  */
  public static TrackingBrowserStats fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, TrackingBrowserStats.class);
  }

 /**
  * Convert an instance of TrackingBrowserStats to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

