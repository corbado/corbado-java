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
 * IOSAppConfigUpdateRsp
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-21T11:14:23.049718350Z[Etc/UTC]", comments = "Generator version: 7.7.0-SNAPSHOT")
public class IOSAppConfigUpdateRsp {
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

  public static final String SERIALIZED_NAME_PROJECT_I_D = "projectID";
  @SerializedName(SERIALIZED_NAME_PROJECT_I_D)
  private String projectID;

  public static final String SERIALIZED_NAME_APP_I_D_PREFIX = "appIDPrefix";
  @SerializedName(SERIALIZED_NAME_APP_I_D_PREFIX)
  private String appIDPrefix;

  public static final String SERIALIZED_NAME_BUNDLE_I_D = "bundleID";
  @SerializedName(SERIALIZED_NAME_BUNDLE_I_D)
  private String bundleID;

  public static final String SERIALIZED_NAME_CREATED = "created";
  @SerializedName(SERIALIZED_NAME_CREATED)
  private String created;

  public static final String SERIALIZED_NAME_UPDATED = "updated";
  @SerializedName(SERIALIZED_NAME_UPDATED)
  private String updated;

  public IOSAppConfigUpdateRsp() {
  }

  public IOSAppConfigUpdateRsp httpStatusCode(Integer httpStatusCode) {
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


  public IOSAppConfigUpdateRsp message(String message) {
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


  public IOSAppConfigUpdateRsp requestData(RequestData requestData) {
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


  public IOSAppConfigUpdateRsp runtime(Float runtime) {
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


  public IOSAppConfigUpdateRsp id(String id) {
    this.id = id;
    return this;
  }

   /**
   * ID of iOS app
   * @return id
  **/
  @javax.annotation.Nonnull
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public IOSAppConfigUpdateRsp projectID(String projectID) {
    this.projectID = projectID;
    return this;
  }

   /**
   * ID of project
   * @return projectID
  **/
  @javax.annotation.Nonnull
  public String getProjectID() {
    return projectID;
  }

  public void setProjectID(String projectID) {
    this.projectID = projectID;
  }


  public IOSAppConfigUpdateRsp appIDPrefix(String appIDPrefix) {
    this.appIDPrefix = appIDPrefix;
    return this;
  }

   /**
   * Get appIDPrefix
   * @return appIDPrefix
  **/
  @javax.annotation.Nonnull
  public String getAppIDPrefix() {
    return appIDPrefix;
  }

  public void setAppIDPrefix(String appIDPrefix) {
    this.appIDPrefix = appIDPrefix;
  }


  public IOSAppConfigUpdateRsp bundleID(String bundleID) {
    this.bundleID = bundleID;
    return this;
  }

   /**
   * Get bundleID
   * @return bundleID
  **/
  @javax.annotation.Nonnull
  public String getBundleID() {
    return bundleID;
  }

  public void setBundleID(String bundleID) {
    this.bundleID = bundleID;
  }


  public IOSAppConfigUpdateRsp created(String created) {
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


  public IOSAppConfigUpdateRsp updated(String updated) {
    this.updated = updated;
    return this;
  }

   /**
   * Timestamp of when the entity was last updated in yyyy-MM-dd&#39;T&#39;HH:mm:ss format
   * @return updated
  **/
  @javax.annotation.Nonnull
  public String getUpdated() {
    return updated;
  }

  public void setUpdated(String updated) {
    this.updated = updated;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IOSAppConfigUpdateRsp iOSAppConfigUpdateRsp = (IOSAppConfigUpdateRsp) o;
    return Objects.equals(this.httpStatusCode, iOSAppConfigUpdateRsp.httpStatusCode) &&
        Objects.equals(this.message, iOSAppConfigUpdateRsp.message) &&
        Objects.equals(this.requestData, iOSAppConfigUpdateRsp.requestData) &&
        Objects.equals(this.runtime, iOSAppConfigUpdateRsp.runtime) &&
        Objects.equals(this.id, iOSAppConfigUpdateRsp.id) &&
        Objects.equals(this.projectID, iOSAppConfigUpdateRsp.projectID) &&
        Objects.equals(this.appIDPrefix, iOSAppConfigUpdateRsp.appIDPrefix) &&
        Objects.equals(this.bundleID, iOSAppConfigUpdateRsp.bundleID) &&
        Objects.equals(this.created, iOSAppConfigUpdateRsp.created) &&
        Objects.equals(this.updated, iOSAppConfigUpdateRsp.updated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(httpStatusCode, message, requestData, runtime, id, projectID, appIDPrefix, bundleID, created, updated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IOSAppConfigUpdateRsp {\n");
    sb.append("    httpStatusCode: ").append(toIndentedString(httpStatusCode)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    requestData: ").append(toIndentedString(requestData)).append("\n");
    sb.append("    runtime: ").append(toIndentedString(runtime)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    projectID: ").append(toIndentedString(projectID)).append("\n");
    sb.append("    appIDPrefix: ").append(toIndentedString(appIDPrefix)).append("\n");
    sb.append("    bundleID: ").append(toIndentedString(bundleID)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
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
    openapiFields.add("projectID");
    openapiFields.add("appIDPrefix");
    openapiFields.add("bundleID");
    openapiFields.add("created");
    openapiFields.add("updated");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("httpStatusCode");
    openapiRequiredFields.add("message");
    openapiRequiredFields.add("requestData");
    openapiRequiredFields.add("runtime");
    openapiRequiredFields.add("id");
    openapiRequiredFields.add("projectID");
    openapiRequiredFields.add("appIDPrefix");
    openapiRequiredFields.add("bundleID");
    openapiRequiredFields.add("created");
    openapiRequiredFields.add("updated");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to IOSAppConfigUpdateRsp
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!IOSAppConfigUpdateRsp.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in IOSAppConfigUpdateRsp is not found in the empty JSON string", IOSAppConfigUpdateRsp.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!IOSAppConfigUpdateRsp.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `IOSAppConfigUpdateRsp` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : IOSAppConfigUpdateRsp.openapiRequiredFields) {
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
      if (!jsonObj.get("projectID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `projectID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("projectID").toString()));
      }
      if (!jsonObj.get("appIDPrefix").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `appIDPrefix` to be a primitive type in the JSON string but got `%s`", jsonObj.get("appIDPrefix").toString()));
      }
      if (!jsonObj.get("bundleID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `bundleID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("bundleID").toString()));
      }
      if (!jsonObj.get("created").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `created` to be a primitive type in the JSON string but got `%s`", jsonObj.get("created").toString()));
      }
      if (!jsonObj.get("updated").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `updated` to be a primitive type in the JSON string but got `%s`", jsonObj.get("updated").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!IOSAppConfigUpdateRsp.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'IOSAppConfigUpdateRsp' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<IOSAppConfigUpdateRsp> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(IOSAppConfigUpdateRsp.class));

       return (TypeAdapter<T>) new TypeAdapter<IOSAppConfigUpdateRsp>() {
           @Override
           public void write(JsonWriter out, IOSAppConfigUpdateRsp value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public IOSAppConfigUpdateRsp read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of IOSAppConfigUpdateRsp given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of IOSAppConfigUpdateRsp
  * @throws IOException if the JSON string is invalid with respect to IOSAppConfigUpdateRsp
  */
  public static IOSAppConfigUpdateRsp fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, IOSAppConfigUpdateRsp.class);
  }

 /**
  * Convert an instance of IOSAppConfigUpdateRsp to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

