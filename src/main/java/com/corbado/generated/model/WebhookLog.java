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
 * Webhook log entry
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-21T11:14:23.049718350Z[Etc/UTC]", comments = "Generator version: 7.7.0-SNAPSHOT")
public class WebhookLog {
  public static final String SERIALIZED_NAME_WEBHOOK_I_D = "webhookID";
  @SerializedName(SERIALIZED_NAME_WEBHOOK_I_D)
  private String webhookID;

  public static final String SERIALIZED_NAME_PROJECT_I_D = "projectID";
  @SerializedName(SERIALIZED_NAME_PROJECT_I_D)
  private String projectID;

  public static final String SERIALIZED_NAME_ACTION = "action";
  @SerializedName(SERIALIZED_NAME_ACTION)
  private String action;

  public static final String SERIALIZED_NAME_RESPONSE_I_D = "responseID";
  @SerializedName(SERIALIZED_NAME_RESPONSE_I_D)
  private String responseID;

  public static final String SERIALIZED_NAME_REQUEST_U_R_L = "requestURL";
  @SerializedName(SERIALIZED_NAME_REQUEST_U_R_L)
  private String requestURL;

  public static final String SERIALIZED_NAME_REQUEST_BODY = "requestBody";
  @SerializedName(SERIALIZED_NAME_REQUEST_BODY)
  private String requestBody;

  public static final String SERIALIZED_NAME_RESPONSE_STATUS = "responseStatus";
  @SerializedName(SERIALIZED_NAME_RESPONSE_STATUS)
  private Integer responseStatus;

  public static final String SERIALIZED_NAME_RESPONSE_HEADERS = "responseHeaders";
  @SerializedName(SERIALIZED_NAME_RESPONSE_HEADERS)
  private Object responseHeaders;

  public static final String SERIALIZED_NAME_RESPONSE_BODY = "responseBody";
  @SerializedName(SERIALIZED_NAME_RESPONSE_BODY)
  private String responseBody;

  public static final String SERIALIZED_NAME_RESPONSE_ERROR = "responseError";
  @SerializedName(SERIALIZED_NAME_RESPONSE_ERROR)
  private String responseError;

  public static final String SERIALIZED_NAME_RUNTIME = "runtime";
  @SerializedName(SERIALIZED_NAME_RUNTIME)
  private Float runtime;

  public static final String SERIALIZED_NAME_CREATED = "created";
  @SerializedName(SERIALIZED_NAME_CREATED)
  private String created;

  public WebhookLog() {
  }

  public WebhookLog webhookID(String webhookID) {
    this.webhookID = webhookID;
    return this;
  }

   /**
   * Unique ID of webhook request which will be randomly generated on server side
   * @return webhookID
  **/
  @javax.annotation.Nonnull
  public String getWebhookID() {
    return webhookID;
  }

  public void setWebhookID(String webhookID) {
    this.webhookID = webhookID;
  }


  public WebhookLog projectID(String projectID) {
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


  public WebhookLog action(String action) {
    this.action = action;
    return this;
  }

   /**
   * Webhook action
   * @return action
  **/
  @javax.annotation.Nonnull
  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }


  public WebhookLog responseID(String responseID) {
    this.responseID = responseID;
    return this;
  }

   /**
   * Unique ID of response, you can provide your own while responding to the webhook, if not the ID will be randomly generated on server side. This has the same meaning as overriding requestID for API requests. 
   * @return responseID
  **/
  @javax.annotation.Nonnull
  public String getResponseID() {
    return responseID;
  }

  public void setResponseID(String responseID) {
    this.responseID = responseID;
  }


  public WebhookLog requestURL(String requestURL) {
    this.requestURL = requestURL;
    return this;
  }

   /**
   * Absolute request URL of webhook backend
   * @return requestURL
  **/
  @javax.annotation.Nonnull
  public String getRequestURL() {
    return requestURL;
  }

  public void setRequestURL(String requestURL) {
    this.requestURL = requestURL;
  }


  public WebhookLog requestBody(String requestBody) {
    this.requestBody = requestBody;
    return this;
  }

   /**
   * Request contents that were sent to webhook backend
   * @return requestBody
  **/
  @javax.annotation.Nonnull
  public String getRequestBody() {
    return requestBody;
  }

  public void setRequestBody(String requestBody) {
    this.requestBody = requestBody;
  }


  public WebhookLog responseStatus(Integer responseStatus) {
    this.responseStatus = responseStatus;
    return this;
  }

   /**
   * Response HTTP status that was returned by webhook backend
   * @return responseStatus
  **/
  @javax.annotation.Nonnull
  public Integer getResponseStatus() {
    return responseStatus;
  }

  public void setResponseStatus(Integer responseStatus) {
    this.responseStatus = responseStatus;
  }


  public WebhookLog responseHeaders(Object responseHeaders) {
    this.responseHeaders = responseHeaders;
    return this;
  }

   /**
   * Response HTTP headers that were returned by webhook backend
   * @return responseHeaders
  **/
  @javax.annotation.Nonnull
  public Object getResponseHeaders() {
    return responseHeaders;
  }

  public void setResponseHeaders(Object responseHeaders) {
    this.responseHeaders = responseHeaders;
  }


  public WebhookLog responseBody(String responseBody) {
    this.responseBody = responseBody;
    return this;
  }

   /**
   * Response body JSON data that was returned by webhook backend
   * @return responseBody
  **/
  @javax.annotation.Nonnull
  public String getResponseBody() {
    return responseBody;
  }

  public void setResponseBody(String responseBody) {
    this.responseBody = responseBody;
  }


  public WebhookLog responseError(String responseError) {
    this.responseError = responseError;
    return this;
  }

   /**
   * Response error if present
   * @return responseError
  **/
  @javax.annotation.Nonnull
  public String getResponseError() {
    return responseError;
  }

  public void setResponseError(String responseError) {
    this.responseError = responseError;
  }


  public WebhookLog runtime(Float runtime) {
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


  public WebhookLog created(String created) {
    this.created = created;
    return this;
  }

   /**
   * Timestamp of when the request was performed in RFC3339 format
   * @return created
  **/
  @javax.annotation.Nonnull
  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WebhookLog webhookLog = (WebhookLog) o;
    return Objects.equals(this.webhookID, webhookLog.webhookID) &&
        Objects.equals(this.projectID, webhookLog.projectID) &&
        Objects.equals(this.action, webhookLog.action) &&
        Objects.equals(this.responseID, webhookLog.responseID) &&
        Objects.equals(this.requestURL, webhookLog.requestURL) &&
        Objects.equals(this.requestBody, webhookLog.requestBody) &&
        Objects.equals(this.responseStatus, webhookLog.responseStatus) &&
        Objects.equals(this.responseHeaders, webhookLog.responseHeaders) &&
        Objects.equals(this.responseBody, webhookLog.responseBody) &&
        Objects.equals(this.responseError, webhookLog.responseError) &&
        Objects.equals(this.runtime, webhookLog.runtime) &&
        Objects.equals(this.created, webhookLog.created);
  }

  @Override
  public int hashCode() {
    return Objects.hash(webhookID, projectID, action, responseID, requestURL, requestBody, responseStatus, responseHeaders, responseBody, responseError, runtime, created);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WebhookLog {\n");
    sb.append("    webhookID: ").append(toIndentedString(webhookID)).append("\n");
    sb.append("    projectID: ").append(toIndentedString(projectID)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    responseID: ").append(toIndentedString(responseID)).append("\n");
    sb.append("    requestURL: ").append(toIndentedString(requestURL)).append("\n");
    sb.append("    requestBody: ").append(toIndentedString(requestBody)).append("\n");
    sb.append("    responseStatus: ").append(toIndentedString(responseStatus)).append("\n");
    sb.append("    responseHeaders: ").append(toIndentedString(responseHeaders)).append("\n");
    sb.append("    responseBody: ").append(toIndentedString(responseBody)).append("\n");
    sb.append("    responseError: ").append(toIndentedString(responseError)).append("\n");
    sb.append("    runtime: ").append(toIndentedString(runtime)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
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
    openapiFields.add("webhookID");
    openapiFields.add("projectID");
    openapiFields.add("action");
    openapiFields.add("responseID");
    openapiFields.add("requestURL");
    openapiFields.add("requestBody");
    openapiFields.add("responseStatus");
    openapiFields.add("responseHeaders");
    openapiFields.add("responseBody");
    openapiFields.add("responseError");
    openapiFields.add("runtime");
    openapiFields.add("created");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("webhookID");
    openapiRequiredFields.add("projectID");
    openapiRequiredFields.add("action");
    openapiRequiredFields.add("responseID");
    openapiRequiredFields.add("requestURL");
    openapiRequiredFields.add("requestBody");
    openapiRequiredFields.add("responseStatus");
    openapiRequiredFields.add("responseHeaders");
    openapiRequiredFields.add("responseBody");
    openapiRequiredFields.add("responseError");
    openapiRequiredFields.add("runtime");
    openapiRequiredFields.add("created");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to WebhookLog
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!WebhookLog.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in WebhookLog is not found in the empty JSON string", WebhookLog.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!WebhookLog.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `WebhookLog` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : WebhookLog.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("webhookID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `webhookID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("webhookID").toString()));
      }
      if (!jsonObj.get("projectID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `projectID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("projectID").toString()));
      }
      if (!jsonObj.get("action").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `action` to be a primitive type in the JSON string but got `%s`", jsonObj.get("action").toString()));
      }
      if (!jsonObj.get("responseID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `responseID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("responseID").toString()));
      }
      if (!jsonObj.get("requestURL").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `requestURL` to be a primitive type in the JSON string but got `%s`", jsonObj.get("requestURL").toString()));
      }
      if (!jsonObj.get("requestBody").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `requestBody` to be a primitive type in the JSON string but got `%s`", jsonObj.get("requestBody").toString()));
      }
      if (!jsonObj.get("responseBody").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `responseBody` to be a primitive type in the JSON string but got `%s`", jsonObj.get("responseBody").toString()));
      }
      if (!jsonObj.get("responseError").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `responseError` to be a primitive type in the JSON string but got `%s`", jsonObj.get("responseError").toString()));
      }
      if (!jsonObj.get("created").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `created` to be a primitive type in the JSON string but got `%s`", jsonObj.get("created").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!WebhookLog.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'WebhookLog' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<WebhookLog> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(WebhookLog.class));

       return (TypeAdapter<T>) new TypeAdapter<WebhookLog>() {
           @Override
           public void write(JsonWriter out, WebhookLog value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public WebhookLog read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of WebhookLog given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of WebhookLog
  * @throws IOException if the JSON string is invalid with respect to WebhookLog
  */
  public static WebhookLog fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, WebhookLog.class);
  }

 /**
  * Convert an instance of WebhookLog to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

