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
 * EmailTemplateCreateReq
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-21T11:14:23.049718350Z[Etc/UTC]", comments = "Generator version: 7.7.0-SNAPSHOT")
public class EmailTemplateCreateReq {
  /**
   * Gets or Sets lang
   */
  @JsonAdapter(LangEnum.Adapter.class)
  public enum LangEnum {
    EN("en"),
    
    DE("de"),
    
    FR("fr");

    private String value;

    LangEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static LangEnum fromValue(String value) {
      for (LangEnum b : LangEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<LangEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final LangEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public LangEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return LangEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      LangEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_LANG = "lang";
  @SerializedName(SERIALIZED_NAME_LANG)
  private LangEnum lang;

  /**
   * Gets or Sets type
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    EMAIL_LINK("email_link"),
    
    EMAIL_LINK_LOGIN("email_link_login"),
    
    LOGIN_NOTIFICATION("login_notification"),
    
    PASSKEY_NOTIFICATION("passkey_notification"),
    
    EMAIL_CODE("email_code");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<TypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return TypeEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      TypeEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private TypeEnum type;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_SUBJECT = "subject";
  @SerializedName(SERIALIZED_NAME_SUBJECT)
  private String subject;

  public static final String SERIALIZED_NAME_ACTION = "action";
  @SerializedName(SERIALIZED_NAME_ACTION)
  private String action;

  public static final String SERIALIZED_NAME_PLAIN_TEXT_BODY = "plainTextBody";
  @SerializedName(SERIALIZED_NAME_PLAIN_TEXT_BODY)
  private String plainTextBody;

  public static final String SERIALIZED_NAME_HTML_TEXT_TITLE = "htmlTextTitle";
  @SerializedName(SERIALIZED_NAME_HTML_TEXT_TITLE)
  private String htmlTextTitle;

  public static final String SERIALIZED_NAME_HTML_TEXT_BODY = "htmlTextBody";
  @SerializedName(SERIALIZED_NAME_HTML_TEXT_BODY)
  private String htmlTextBody;

  public static final String SERIALIZED_NAME_HTML_TEXT_BUTTON = "htmlTextButton";
  @SerializedName(SERIALIZED_NAME_HTML_TEXT_BUTTON)
  private String htmlTextButton;

  public static final String SERIALIZED_NAME_HTML_COLOR_FONT = "htmlColorFont";
  @SerializedName(SERIALIZED_NAME_HTML_COLOR_FONT)
  private String htmlColorFont;

  public static final String SERIALIZED_NAME_HTML_COLOR_BACKGROUND_OUTER = "htmlColorBackgroundOuter";
  @SerializedName(SERIALIZED_NAME_HTML_COLOR_BACKGROUND_OUTER)
  private String htmlColorBackgroundOuter;

  public static final String SERIALIZED_NAME_HTML_COLOR_BACKGROUND_INNER = "htmlColorBackgroundInner";
  @SerializedName(SERIALIZED_NAME_HTML_COLOR_BACKGROUND_INNER)
  private String htmlColorBackgroundInner;

  public static final String SERIALIZED_NAME_HTML_COLOR_BUTTON = "htmlColorButton";
  @SerializedName(SERIALIZED_NAME_HTML_COLOR_BUTTON)
  private String htmlColorButton;

  public static final String SERIALIZED_NAME_HTML_COLOR_BUTTON_FONT = "htmlColorButtonFont";
  @SerializedName(SERIALIZED_NAME_HTML_COLOR_BUTTON_FONT)
  private String htmlColorButtonFont;

  public static final String SERIALIZED_NAME_IS_DEFAULT = "isDefault";
  @SerializedName(SERIALIZED_NAME_IS_DEFAULT)
  private Boolean isDefault;

  public static final String SERIALIZED_NAME_REQUEST_I_D = "requestID";
  @SerializedName(SERIALIZED_NAME_REQUEST_I_D)
  private String requestID;

  public static final String SERIALIZED_NAME_CLIENT_INFO = "clientInfo";
  @SerializedName(SERIALIZED_NAME_CLIENT_INFO)
  private ClientInfo clientInfo;

  public EmailTemplateCreateReq() {
  }

  public EmailTemplateCreateReq lang(LangEnum lang) {
    this.lang = lang;
    return this;
  }

   /**
   * Get lang
   * @return lang
  **/
  @javax.annotation.Nonnull
  public LangEnum getLang() {
    return lang;
  }

  public void setLang(LangEnum lang) {
    this.lang = lang;
  }


  public EmailTemplateCreateReq type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @javax.annotation.Nonnull
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }


  public EmailTemplateCreateReq name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @javax.annotation.Nonnull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public EmailTemplateCreateReq subject(String subject) {
    this.subject = subject;
    return this;
  }

   /**
   * Get subject
   * @return subject
  **/
  @javax.annotation.Nonnull
  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }


  public EmailTemplateCreateReq action(String action) {
    this.action = action;
    return this;
  }

   /**
   * Get action
   * @return action
  **/
  @javax.annotation.Nullable
  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }


  public EmailTemplateCreateReq plainTextBody(String plainTextBody) {
    this.plainTextBody = plainTextBody;
    return this;
  }

   /**
   * Get plainTextBody
   * @return plainTextBody
  **/
  @javax.annotation.Nonnull
  public String getPlainTextBody() {
    return plainTextBody;
  }

  public void setPlainTextBody(String plainTextBody) {
    this.plainTextBody = plainTextBody;
  }


  public EmailTemplateCreateReq htmlTextTitle(String htmlTextTitle) {
    this.htmlTextTitle = htmlTextTitle;
    return this;
  }

   /**
   * Get htmlTextTitle
   * @return htmlTextTitle
  **/
  @javax.annotation.Nonnull
  public String getHtmlTextTitle() {
    return htmlTextTitle;
  }

  public void setHtmlTextTitle(String htmlTextTitle) {
    this.htmlTextTitle = htmlTextTitle;
  }


  public EmailTemplateCreateReq htmlTextBody(String htmlTextBody) {
    this.htmlTextBody = htmlTextBody;
    return this;
  }

   /**
   * Get htmlTextBody
   * @return htmlTextBody
  **/
  @javax.annotation.Nonnull
  public String getHtmlTextBody() {
    return htmlTextBody;
  }

  public void setHtmlTextBody(String htmlTextBody) {
    this.htmlTextBody = htmlTextBody;
  }


  public EmailTemplateCreateReq htmlTextButton(String htmlTextButton) {
    this.htmlTextButton = htmlTextButton;
    return this;
  }

   /**
   * Get htmlTextButton
   * @return htmlTextButton
  **/
  @javax.annotation.Nonnull
  public String getHtmlTextButton() {
    return htmlTextButton;
  }

  public void setHtmlTextButton(String htmlTextButton) {
    this.htmlTextButton = htmlTextButton;
  }


  public EmailTemplateCreateReq htmlColorFont(String htmlColorFont) {
    this.htmlColorFont = htmlColorFont;
    return this;
  }

   /**
   * Get htmlColorFont
   * @return htmlColorFont
  **/
  @javax.annotation.Nonnull
  public String getHtmlColorFont() {
    return htmlColorFont;
  }

  public void setHtmlColorFont(String htmlColorFont) {
    this.htmlColorFont = htmlColorFont;
  }


  public EmailTemplateCreateReq htmlColorBackgroundOuter(String htmlColorBackgroundOuter) {
    this.htmlColorBackgroundOuter = htmlColorBackgroundOuter;
    return this;
  }

   /**
   * Get htmlColorBackgroundOuter
   * @return htmlColorBackgroundOuter
  **/
  @javax.annotation.Nonnull
  public String getHtmlColorBackgroundOuter() {
    return htmlColorBackgroundOuter;
  }

  public void setHtmlColorBackgroundOuter(String htmlColorBackgroundOuter) {
    this.htmlColorBackgroundOuter = htmlColorBackgroundOuter;
  }


  public EmailTemplateCreateReq htmlColorBackgroundInner(String htmlColorBackgroundInner) {
    this.htmlColorBackgroundInner = htmlColorBackgroundInner;
    return this;
  }

   /**
   * Get htmlColorBackgroundInner
   * @return htmlColorBackgroundInner
  **/
  @javax.annotation.Nonnull
  public String getHtmlColorBackgroundInner() {
    return htmlColorBackgroundInner;
  }

  public void setHtmlColorBackgroundInner(String htmlColorBackgroundInner) {
    this.htmlColorBackgroundInner = htmlColorBackgroundInner;
  }


  public EmailTemplateCreateReq htmlColorButton(String htmlColorButton) {
    this.htmlColorButton = htmlColorButton;
    return this;
  }

   /**
   * Get htmlColorButton
   * @return htmlColorButton
  **/
  @javax.annotation.Nonnull
  public String getHtmlColorButton() {
    return htmlColorButton;
  }

  public void setHtmlColorButton(String htmlColorButton) {
    this.htmlColorButton = htmlColorButton;
  }


  public EmailTemplateCreateReq htmlColorButtonFont(String htmlColorButtonFont) {
    this.htmlColorButtonFont = htmlColorButtonFont;
    return this;
  }

   /**
   * Get htmlColorButtonFont
   * @return htmlColorButtonFont
  **/
  @javax.annotation.Nonnull
  public String getHtmlColorButtonFont() {
    return htmlColorButtonFont;
  }

  public void setHtmlColorButtonFont(String htmlColorButtonFont) {
    this.htmlColorButtonFont = htmlColorButtonFont;
  }


  public EmailTemplateCreateReq isDefault(Boolean isDefault) {
    this.isDefault = isDefault;
    return this;
  }

   /**
   * Get isDefault
   * @return isDefault
  **/
  @javax.annotation.Nonnull
  public Boolean getIsDefault() {
    return isDefault;
  }

  public void setIsDefault(Boolean isDefault) {
    this.isDefault = isDefault;
  }


  public EmailTemplateCreateReq requestID(String requestID) {
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


  public EmailTemplateCreateReq clientInfo(ClientInfo clientInfo) {
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
    EmailTemplateCreateReq emailTemplateCreateReq = (EmailTemplateCreateReq) o;
    return Objects.equals(this.lang, emailTemplateCreateReq.lang) &&
        Objects.equals(this.type, emailTemplateCreateReq.type) &&
        Objects.equals(this.name, emailTemplateCreateReq.name) &&
        Objects.equals(this.subject, emailTemplateCreateReq.subject) &&
        Objects.equals(this.action, emailTemplateCreateReq.action) &&
        Objects.equals(this.plainTextBody, emailTemplateCreateReq.plainTextBody) &&
        Objects.equals(this.htmlTextTitle, emailTemplateCreateReq.htmlTextTitle) &&
        Objects.equals(this.htmlTextBody, emailTemplateCreateReq.htmlTextBody) &&
        Objects.equals(this.htmlTextButton, emailTemplateCreateReq.htmlTextButton) &&
        Objects.equals(this.htmlColorFont, emailTemplateCreateReq.htmlColorFont) &&
        Objects.equals(this.htmlColorBackgroundOuter, emailTemplateCreateReq.htmlColorBackgroundOuter) &&
        Objects.equals(this.htmlColorBackgroundInner, emailTemplateCreateReq.htmlColorBackgroundInner) &&
        Objects.equals(this.htmlColorButton, emailTemplateCreateReq.htmlColorButton) &&
        Objects.equals(this.htmlColorButtonFont, emailTemplateCreateReq.htmlColorButtonFont) &&
        Objects.equals(this.isDefault, emailTemplateCreateReq.isDefault) &&
        Objects.equals(this.requestID, emailTemplateCreateReq.requestID) &&
        Objects.equals(this.clientInfo, emailTemplateCreateReq.clientInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lang, type, name, subject, action, plainTextBody, htmlTextTitle, htmlTextBody, htmlTextButton, htmlColorFont, htmlColorBackgroundOuter, htmlColorBackgroundInner, htmlColorButton, htmlColorButtonFont, isDefault, requestID, clientInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmailTemplateCreateReq {\n");
    sb.append("    lang: ").append(toIndentedString(lang)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    plainTextBody: ").append(toIndentedString(plainTextBody)).append("\n");
    sb.append("    htmlTextTitle: ").append(toIndentedString(htmlTextTitle)).append("\n");
    sb.append("    htmlTextBody: ").append(toIndentedString(htmlTextBody)).append("\n");
    sb.append("    htmlTextButton: ").append(toIndentedString(htmlTextButton)).append("\n");
    sb.append("    htmlColorFont: ").append(toIndentedString(htmlColorFont)).append("\n");
    sb.append("    htmlColorBackgroundOuter: ").append(toIndentedString(htmlColorBackgroundOuter)).append("\n");
    sb.append("    htmlColorBackgroundInner: ").append(toIndentedString(htmlColorBackgroundInner)).append("\n");
    sb.append("    htmlColorButton: ").append(toIndentedString(htmlColorButton)).append("\n");
    sb.append("    htmlColorButtonFont: ").append(toIndentedString(htmlColorButtonFont)).append("\n");
    sb.append("    isDefault: ").append(toIndentedString(isDefault)).append("\n");
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
    openapiFields.add("lang");
    openapiFields.add("type");
    openapiFields.add("name");
    openapiFields.add("subject");
    openapiFields.add("action");
    openapiFields.add("plainTextBody");
    openapiFields.add("htmlTextTitle");
    openapiFields.add("htmlTextBody");
    openapiFields.add("htmlTextButton");
    openapiFields.add("htmlColorFont");
    openapiFields.add("htmlColorBackgroundOuter");
    openapiFields.add("htmlColorBackgroundInner");
    openapiFields.add("htmlColorButton");
    openapiFields.add("htmlColorButtonFont");
    openapiFields.add("isDefault");
    openapiFields.add("requestID");
    openapiFields.add("clientInfo");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("lang");
    openapiRequiredFields.add("type");
    openapiRequiredFields.add("name");
    openapiRequiredFields.add("subject");
    openapiRequiredFields.add("plainTextBody");
    openapiRequiredFields.add("htmlTextTitle");
    openapiRequiredFields.add("htmlTextBody");
    openapiRequiredFields.add("htmlTextButton");
    openapiRequiredFields.add("htmlColorFont");
    openapiRequiredFields.add("htmlColorBackgroundOuter");
    openapiRequiredFields.add("htmlColorBackgroundInner");
    openapiRequiredFields.add("htmlColorButton");
    openapiRequiredFields.add("htmlColorButtonFont");
    openapiRequiredFields.add("isDefault");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to EmailTemplateCreateReq
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!EmailTemplateCreateReq.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in EmailTemplateCreateReq is not found in the empty JSON string", EmailTemplateCreateReq.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!EmailTemplateCreateReq.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `EmailTemplateCreateReq` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : EmailTemplateCreateReq.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("lang").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `lang` to be a primitive type in the JSON string but got `%s`", jsonObj.get("lang").toString()));
      }
      // validate the required field `lang`
      LangEnum.validateJsonElement(jsonObj.get("lang"));
      if (!jsonObj.get("type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("type").toString()));
      }
      // validate the required field `type`
      TypeEnum.validateJsonElement(jsonObj.get("type"));
      if (!jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      if (!jsonObj.get("subject").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `subject` to be a primitive type in the JSON string but got `%s`", jsonObj.get("subject").toString()));
      }
      if ((jsonObj.get("action") != null && !jsonObj.get("action").isJsonNull()) && !jsonObj.get("action").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `action` to be a primitive type in the JSON string but got `%s`", jsonObj.get("action").toString()));
      }
      if (!jsonObj.get("plainTextBody").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `plainTextBody` to be a primitive type in the JSON string but got `%s`", jsonObj.get("plainTextBody").toString()));
      }
      if (!jsonObj.get("htmlTextTitle").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `htmlTextTitle` to be a primitive type in the JSON string but got `%s`", jsonObj.get("htmlTextTitle").toString()));
      }
      if (!jsonObj.get("htmlTextBody").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `htmlTextBody` to be a primitive type in the JSON string but got `%s`", jsonObj.get("htmlTextBody").toString()));
      }
      if (!jsonObj.get("htmlTextButton").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `htmlTextButton` to be a primitive type in the JSON string but got `%s`", jsonObj.get("htmlTextButton").toString()));
      }
      if (!jsonObj.get("htmlColorFont").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `htmlColorFont` to be a primitive type in the JSON string but got `%s`", jsonObj.get("htmlColorFont").toString()));
      }
      if (!jsonObj.get("htmlColorBackgroundOuter").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `htmlColorBackgroundOuter` to be a primitive type in the JSON string but got `%s`", jsonObj.get("htmlColorBackgroundOuter").toString()));
      }
      if (!jsonObj.get("htmlColorBackgroundInner").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `htmlColorBackgroundInner` to be a primitive type in the JSON string but got `%s`", jsonObj.get("htmlColorBackgroundInner").toString()));
      }
      if (!jsonObj.get("htmlColorButton").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `htmlColorButton` to be a primitive type in the JSON string but got `%s`", jsonObj.get("htmlColorButton").toString()));
      }
      if (!jsonObj.get("htmlColorButtonFont").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `htmlColorButtonFont` to be a primitive type in the JSON string but got `%s`", jsonObj.get("htmlColorButtonFont").toString()));
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
       if (!EmailTemplateCreateReq.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'EmailTemplateCreateReq' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<EmailTemplateCreateReq> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(EmailTemplateCreateReq.class));

       return (TypeAdapter<T>) new TypeAdapter<EmailTemplateCreateReq>() {
           @Override
           public void write(JsonWriter out, EmailTemplateCreateReq value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public EmailTemplateCreateReq read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of EmailTemplateCreateReq given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of EmailTemplateCreateReq
  * @throws IOException if the JSON string is invalid with respect to EmailTemplateCreateReq
  */
  public static EmailTemplateCreateReq fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, EmailTemplateCreateReq.class);
  }

 /**
  * Convert an instance of EmailTemplateCreateReq to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

