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
 * ProjectConfigSaveReq
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-21T11:14:23.049718350Z[Etc/UTC]", comments = "Generator version: 7.7.0-SNAPSHOT")
public class ProjectConfigSaveReq {
  public static final String SERIALIZED_NAME_EXTERNAL_NAME = "externalName";
  @SerializedName(SERIALIZED_NAME_EXTERNAL_NAME)
  private String externalName;

  public static final String SERIALIZED_NAME_APP_TYPE = "appType";
  @SerializedName(SERIALIZED_NAME_APP_TYPE)
  private AppType appType;

  public static final String SERIALIZED_NAME_PRODUCT_KEY = "productKey";
  @SerializedName(SERIALIZED_NAME_PRODUCT_KEY)
  private String productKey;

  public static final String SERIALIZED_NAME_EMAIL_FROM = "emailFrom";
  @SerializedName(SERIALIZED_NAME_EMAIL_FROM)
  private String emailFrom;

  public static final String SERIALIZED_NAME_SMS_FROM = "smsFrom";
  @SerializedName(SERIALIZED_NAME_SMS_FROM)
  private String smsFrom;

  /**
   * Defines which version of webhook is used
   */
  @JsonAdapter(ExternalApplicationProtocolVersionEnum.Adapter.class)
  public enum ExternalApplicationProtocolVersionEnum {
    V1("v1"),
    
    V2("v2");

    private String value;

    ExternalApplicationProtocolVersionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ExternalApplicationProtocolVersionEnum fromValue(String value) {
      for (ExternalApplicationProtocolVersionEnum b : ExternalApplicationProtocolVersionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ExternalApplicationProtocolVersionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ExternalApplicationProtocolVersionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ExternalApplicationProtocolVersionEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ExternalApplicationProtocolVersionEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      ExternalApplicationProtocolVersionEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_EXTERNAL_APPLICATION_PROTOCOL_VERSION = "externalApplicationProtocolVersion";
  @SerializedName(SERIALIZED_NAME_EXTERNAL_APPLICATION_PROTOCOL_VERSION)
  private ExternalApplicationProtocolVersionEnum externalApplicationProtocolVersion;

  public static final String SERIALIZED_NAME_WEBHOOK_U_R_L = "webhookURL";
  @SerializedName(SERIALIZED_NAME_WEBHOOK_U_R_L)
  private String webhookURL;

  public static final String SERIALIZED_NAME_WEBHOOK_ACTIONS = "webhookActions";
  @SerializedName(SERIALIZED_NAME_WEBHOOK_ACTIONS)
  private List<String> webhookActions = new ArrayList<>();

  public static final String SERIALIZED_NAME_WEBHOOK_USERNAME = "webhookUsername";
  @SerializedName(SERIALIZED_NAME_WEBHOOK_USERNAME)
  private String webhookUsername;

  public static final String SERIALIZED_NAME_WEBHOOK_PASSWORD = "webhookPassword";
  @SerializedName(SERIALIZED_NAME_WEBHOOK_PASSWORD)
  private String webhookPassword;

  public static final String SERIALIZED_NAME_WEBHOOK_TEST_INVALID_USERNAME = "webhookTestInvalidUsername";
  @SerializedName(SERIALIZED_NAME_WEBHOOK_TEST_INVALID_USERNAME)
  private String webhookTestInvalidUsername;

  public static final String SERIALIZED_NAME_WEBHOOK_TEST_VALID_USERNAME = "webhookTestValidUsername";
  @SerializedName(SERIALIZED_NAME_WEBHOOK_TEST_VALID_USERNAME)
  private String webhookTestValidUsername;

  public static final String SERIALIZED_NAME_WEBHOOK_TEST_VALID_PASSWORD = "webhookTestValidPassword";
  @SerializedName(SERIALIZED_NAME_WEBHOOK_TEST_VALID_PASSWORD)
  private String webhookTestValidPassword;

  public static final String SERIALIZED_NAME_EXTERNAL_APPLICATION_USERNAME = "externalApplicationUsername";
  @SerializedName(SERIALIZED_NAME_EXTERNAL_APPLICATION_USERNAME)
  private String externalApplicationUsername;

  public static final String SERIALIZED_NAME_EXTERNAL_APPLICATION_PASSWORD = "externalApplicationPassword";
  @SerializedName(SERIALIZED_NAME_EXTERNAL_APPLICATION_PASSWORD)
  private String externalApplicationPassword;

  public static final String SERIALIZED_NAME_LEGACY_AUTH_METHODS_URL = "legacyAuthMethodsUrl";
  @SerializedName(SERIALIZED_NAME_LEGACY_AUTH_METHODS_URL)
  private String legacyAuthMethodsUrl;

  public static final String SERIALIZED_NAME_PASSWORD_VERIFY_URL = "passwordVerifyUrl";
  @SerializedName(SERIALIZED_NAME_PASSWORD_VERIFY_URL)
  private String passwordVerifyUrl;

  public static final String SERIALIZED_NAME_AUTH_SUCCESS_REDIRECT_URL = "authSuccessRedirectUrl";
  @SerializedName(SERIALIZED_NAME_AUTH_SUCCESS_REDIRECT_URL)
  private String authSuccessRedirectUrl;

  public static final String SERIALIZED_NAME_PASSWORD_RESET_URL = "passwordResetUrl";
  @SerializedName(SERIALIZED_NAME_PASSWORD_RESET_URL)
  private String passwordResetUrl;

  public static final String SERIALIZED_NAME_ALLOW_USER_REGISTRATION = "allowUserRegistration";
  @SerializedName(SERIALIZED_NAME_ALLOW_USER_REGISTRATION)
  private Boolean allowUserRegistration;

  public static final String SERIALIZED_NAME_ALLOW_I_P_STICKINESS = "allowIPStickiness";
  @SerializedName(SERIALIZED_NAME_ALLOW_I_P_STICKINESS)
  private Boolean allowIPStickiness;

  /**
   * Gets or Sets passkeyAppendInterval
   */
  @JsonAdapter(PasskeyAppendIntervalEnum.Adapter.class)
  public enum PasskeyAppendIntervalEnum {
    _0D("0d"),
    
    _1D("1d"),
    
    _3D("3d"),
    
    _1W("1w"),
    
    _3W("3w"),
    
    _1M("1m"),
    
    _3M("3m");

    private String value;

    PasskeyAppendIntervalEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static PasskeyAppendIntervalEnum fromValue(String value) {
      for (PasskeyAppendIntervalEnum b : PasskeyAppendIntervalEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<PasskeyAppendIntervalEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final PasskeyAppendIntervalEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public PasskeyAppendIntervalEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return PasskeyAppendIntervalEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      PasskeyAppendIntervalEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_PASSKEY_APPEND_INTERVAL = "passkeyAppendInterval";
  @SerializedName(SERIALIZED_NAME_PASSKEY_APPEND_INTERVAL)
  private PasskeyAppendIntervalEnum passkeyAppendInterval;

  public static final String SERIALIZED_NAME_FALLBACK_LANGUAGE = "fallbackLanguage";
  @SerializedName(SERIALIZED_NAME_FALLBACK_LANGUAGE)
  private String fallbackLanguage;

  public static final String SERIALIZED_NAME_AUTO_DETECT_LANGUAGE = "autoDetectLanguage";
  @SerializedName(SERIALIZED_NAME_AUTO_DETECT_LANGUAGE)
  private Boolean autoDetectLanguage;

  public static final String SERIALIZED_NAME_HAS_EXISTING_USERS = "hasExistingUsers";
  @SerializedName(SERIALIZED_NAME_HAS_EXISTING_USERS)
  private Boolean hasExistingUsers;

  public static final String SERIALIZED_NAME_HAS_VERIFIED_SESSION = "hasVerifiedSession";
  @SerializedName(SERIALIZED_NAME_HAS_VERIFIED_SESSION)
  private Boolean hasVerifiedSession;

  public static final String SERIALIZED_NAME_HAS_GENERATED_SESSION = "hasGeneratedSession";
  @SerializedName(SERIALIZED_NAME_HAS_GENERATED_SESSION)
  private Boolean hasGeneratedSession;

  public static final String SERIALIZED_NAME_HAS_STARTED_USING_PASSKEYS = "hasStartedUsingPasskeys";
  @SerializedName(SERIALIZED_NAME_HAS_STARTED_USING_PASSKEYS)
  private Boolean hasStartedUsingPasskeys;

  public static final String SERIALIZED_NAME_HAS_STARTED_USING_SESSIONS = "hasStartedUsingSessions";
  @SerializedName(SERIALIZED_NAME_HAS_STARTED_USING_SESSIONS)
  private Boolean hasStartedUsingSessions;

  public static final String SERIALIZED_NAME_APPLICATION_URL = "applicationUrl";
  @SerializedName(SERIALIZED_NAME_APPLICATION_URL)
  private String applicationUrl;

  public static final String SERIALIZED_NAME_USE_CLI = "useCli";
  @SerializedName(SERIALIZED_NAME_USE_CLI)
  private Boolean useCli;

  public static final String SERIALIZED_NAME_DOUBLE_OPT_IN = "doubleOptIn";
  @SerializedName(SERIALIZED_NAME_DOUBLE_OPT_IN)
  private Boolean doubleOptIn;

  public static final String SERIALIZED_NAME_USER_FULL_NAME_REQUIRED = "userFullNameRequired";
  @SerializedName(SERIALIZED_NAME_USER_FULL_NAME_REQUIRED)
  private Boolean userFullNameRequired;

  public static final String SERIALIZED_NAME_WEBAUTHN_R_P_I_D = "webauthnRPID";
  @SerializedName(SERIALIZED_NAME_WEBAUTHN_R_P_I_D)
  private String webauthnRPID;

  /**
   * Gets or Sets environment
   */
  @JsonAdapter(EnvironmentEnum.Adapter.class)
  public enum EnvironmentEnum {
    DEV("dev"),
    
    PROD("prod");

    private String value;

    EnvironmentEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static EnvironmentEnum fromValue(String value) {
      for (EnvironmentEnum b : EnvironmentEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<EnvironmentEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final EnvironmentEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public EnvironmentEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return EnvironmentEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      EnvironmentEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_ENVIRONMENT = "environment";
  @SerializedName(SERIALIZED_NAME_ENVIRONMENT)
  private EnvironmentEnum environment;

  /**
   * Gets or Sets frontendFramework
   */
  @JsonAdapter(FrontendFrameworkEnum.Adapter.class)
  public enum FrontendFrameworkEnum {
    REACT("react"),
    
    VUEJS("vuejs"),
    
    VANILLAJS("vanillajs"),
    
    ANGULAR("angular"),
    
    SVELTE("svelte"),
    
    NEXTJS("nextjs"),
    
    NUXTJS("nuxtjs"),
    
    FLUTTER("flutter");

    private String value;

    FrontendFrameworkEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static FrontendFrameworkEnum fromValue(String value) {
      for (FrontendFrameworkEnum b : FrontendFrameworkEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<FrontendFrameworkEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final FrontendFrameworkEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public FrontendFrameworkEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return FrontendFrameworkEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      FrontendFrameworkEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_FRONTEND_FRAMEWORK = "frontendFramework";
  @SerializedName(SERIALIZED_NAME_FRONTEND_FRAMEWORK)
  private FrontendFrameworkEnum frontendFramework;

  /**
   * Gets or Sets backendLanguage
   */
  @JsonAdapter(BackendLanguageEnum.Adapter.class)
  public enum BackendLanguageEnum {
    JAVASCRIPT("javascript"),
    
    PHP("php"),
    
    GO("go"),
    
    OTHER("other");

    private String value;

    BackendLanguageEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static BackendLanguageEnum fromValue(String value) {
      for (BackendLanguageEnum b : BackendLanguageEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<BackendLanguageEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final BackendLanguageEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public BackendLanguageEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return BackendLanguageEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      BackendLanguageEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_BACKEND_LANGUAGE = "backendLanguage";
  @SerializedName(SERIALIZED_NAME_BACKEND_LANGUAGE)
  private BackendLanguageEnum backendLanguage;

  public static final String SERIALIZED_NAME_WEB_COMPONENT_DEBUG = "webComponentDebug";
  @SerializedName(SERIALIZED_NAME_WEB_COMPONENT_DEBUG)
  private Boolean webComponentDebug;

  public static final String SERIALIZED_NAME_SMTP_USE_CUSTOM = "smtpUseCustom";
  @SerializedName(SERIALIZED_NAME_SMTP_USE_CUSTOM)
  private Boolean smtpUseCustom;

  public static final String SERIALIZED_NAME_SMTP_HOST = "smtpHost";
  @SerializedName(SERIALIZED_NAME_SMTP_HOST)
  private String smtpHost;

  public static final String SERIALIZED_NAME_SMTP_PORT = "smtpPort";
  @SerializedName(SERIALIZED_NAME_SMTP_PORT)
  private Integer smtpPort;

  public static final String SERIALIZED_NAME_SMTP_USERNAME = "smtpUsername";
  @SerializedName(SERIALIZED_NAME_SMTP_USERNAME)
  private String smtpUsername;

  public static final String SERIALIZED_NAME_SMTP_PASSWORD = "smtpPassword";
  @SerializedName(SERIALIZED_NAME_SMTP_PASSWORD)
  private String smtpPassword;

  public static final String SERIALIZED_NAME_SUPPORT_EMAIL = "supportEmail";
  @SerializedName(SERIALIZED_NAME_SUPPORT_EMAIL)
  private String supportEmail;

  /**
   * Gets or Sets signupFlow
   */
  @JsonAdapter(SignupFlowEnum.Adapter.class)
  public enum SignupFlowEnum {
    PASSKEY_WITH_EMAIL_OTP_FALLBACK("PasskeyWithEmailOTPFallback"),
    
    EMAIL_OTP_SIGNUP("EmailOTPSignup");

    private String value;

    SignupFlowEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static SignupFlowEnum fromValue(String value) {
      for (SignupFlowEnum b : SignupFlowEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<SignupFlowEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final SignupFlowEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public SignupFlowEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return SignupFlowEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      SignupFlowEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_SIGNUP_FLOW = "signupFlow";
  @SerializedName(SERIALIZED_NAME_SIGNUP_FLOW)
  private SignupFlowEnum signupFlow;

  public static final String SERIALIZED_NAME_SIGNUP_FLOW_OPTIONS = "signupFlowOptions";
  @SerializedName(SERIALIZED_NAME_SIGNUP_FLOW_OPTIONS)
  private Object signupFlowOptions;

  /**
   * Gets or Sets loginFlow
   */
  @JsonAdapter(LoginFlowEnum.Adapter.class)
  public enum LoginFlowEnum {
    PASSKEY_WITH_EMAIL_OTP_FALLBACK("PasskeyWithEmailOTPFallback");

    private String value;

    LoginFlowEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static LoginFlowEnum fromValue(String value) {
      for (LoginFlowEnum b : LoginFlowEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<LoginFlowEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final LoginFlowEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public LoginFlowEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return LoginFlowEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      LoginFlowEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_LOGIN_FLOW = "loginFlow";
  @SerializedName(SERIALIZED_NAME_LOGIN_FLOW)
  private LoginFlowEnum loginFlow;

  public static final String SERIALIZED_NAME_LOGIN_FLOW_OPTIONS = "loginFlowOptions";
  @SerializedName(SERIALIZED_NAME_LOGIN_FLOW_OPTIONS)
  private Object loginFlowOptions;

  public static final String SERIALIZED_NAME_REQUEST_I_D = "requestID";
  @SerializedName(SERIALIZED_NAME_REQUEST_I_D)
  private String requestID;

  public static final String SERIALIZED_NAME_CLIENT_INFO = "clientInfo";
  @SerializedName(SERIALIZED_NAME_CLIENT_INFO)
  private ClientInfo clientInfo;

  public static final String SERIALIZED_NAME_ALLOW_STATIC_CHALLENGES = "allowStaticChallenges";
  @SerializedName(SERIALIZED_NAME_ALLOW_STATIC_CHALLENGES)
  private Boolean allowStaticChallenges;

  public ProjectConfigSaveReq() {
  }

  public ProjectConfigSaveReq externalName(String externalName) {
    this.externalName = externalName;
    return this;
  }

   /**
   * Get externalName
   * @return externalName
  **/
  @javax.annotation.Nullable
  public String getExternalName() {
    return externalName;
  }

  public void setExternalName(String externalName) {
    this.externalName = externalName;
  }


  public ProjectConfigSaveReq appType(AppType appType) {
    this.appType = appType;
    return this;
  }

   /**
   * Get appType
   * @return appType
  **/
  @javax.annotation.Nullable
  public AppType getAppType() {
    return appType;
  }

  public void setAppType(AppType appType) {
    this.appType = appType;
  }


  public ProjectConfigSaveReq productKey(String productKey) {
    this.productKey = productKey;
    return this;
  }

   /**
   * Get productKey
   * @return productKey
  **/
  @javax.annotation.Nullable
  public String getProductKey() {
    return productKey;
  }

  public void setProductKey(String productKey) {
    this.productKey = productKey;
  }


  public ProjectConfigSaveReq emailFrom(String emailFrom) {
    this.emailFrom = emailFrom;
    return this;
  }

   /**
   * Get emailFrom
   * @return emailFrom
  **/
  @javax.annotation.Nullable
  public String getEmailFrom() {
    return emailFrom;
  }

  public void setEmailFrom(String emailFrom) {
    this.emailFrom = emailFrom;
  }


  public ProjectConfigSaveReq smsFrom(String smsFrom) {
    this.smsFrom = smsFrom;
    return this;
  }

   /**
   * Get smsFrom
   * @return smsFrom
  **/
  @javax.annotation.Nullable
  public String getSmsFrom() {
    return smsFrom;
  }

  public void setSmsFrom(String smsFrom) {
    this.smsFrom = smsFrom;
  }


  public ProjectConfigSaveReq externalApplicationProtocolVersion(ExternalApplicationProtocolVersionEnum externalApplicationProtocolVersion) {
    this.externalApplicationProtocolVersion = externalApplicationProtocolVersion;
    return this;
  }

   /**
   * Defines which version of webhook is used
   * @return externalApplicationProtocolVersion
  **/
  @javax.annotation.Nullable
  public ExternalApplicationProtocolVersionEnum getExternalApplicationProtocolVersion() {
    return externalApplicationProtocolVersion;
  }

  public void setExternalApplicationProtocolVersion(ExternalApplicationProtocolVersionEnum externalApplicationProtocolVersion) {
    this.externalApplicationProtocolVersion = externalApplicationProtocolVersion;
  }


  public ProjectConfigSaveReq webhookURL(String webhookURL) {
    this.webhookURL = webhookURL;
    return this;
  }

   /**
   * Get webhookURL
   * @return webhookURL
  **/
  @javax.annotation.Nullable
  public String getWebhookURL() {
    return webhookURL;
  }

  public void setWebhookURL(String webhookURL) {
    this.webhookURL = webhookURL;
  }


  public ProjectConfigSaveReq webhookActions(List<String> webhookActions) {
    this.webhookActions = webhookActions;
    return this;
  }

  public ProjectConfigSaveReq addWebhookActionsItem(String webhookActionsItem) {
    if (this.webhookActions == null) {
      this.webhookActions = new ArrayList<>();
    }
    this.webhookActions.add(webhookActionsItem);
    return this;
  }

   /**
   * Get webhookActions
   * @return webhookActions
  **/
  @javax.annotation.Nullable
  public List<String> getWebhookActions() {
    return webhookActions;
  }

  public void setWebhookActions(List<String> webhookActions) {
    this.webhookActions = webhookActions;
  }


  public ProjectConfigSaveReq webhookUsername(String webhookUsername) {
    this.webhookUsername = webhookUsername;
    return this;
  }

   /**
   * Get webhookUsername
   * @return webhookUsername
  **/
  @javax.annotation.Nullable
  public String getWebhookUsername() {
    return webhookUsername;
  }

  public void setWebhookUsername(String webhookUsername) {
    this.webhookUsername = webhookUsername;
  }


  public ProjectConfigSaveReq webhookPassword(String webhookPassword) {
    this.webhookPassword = webhookPassword;
    return this;
  }

   /**
   * Get webhookPassword
   * @return webhookPassword
  **/
  @javax.annotation.Nullable
  public String getWebhookPassword() {
    return webhookPassword;
  }

  public void setWebhookPassword(String webhookPassword) {
    this.webhookPassword = webhookPassword;
  }


  public ProjectConfigSaveReq webhookTestInvalidUsername(String webhookTestInvalidUsername) {
    this.webhookTestInvalidUsername = webhookTestInvalidUsername;
    return this;
  }

   /**
   * Get webhookTestInvalidUsername
   * @return webhookTestInvalidUsername
  **/
  @javax.annotation.Nullable
  public String getWebhookTestInvalidUsername() {
    return webhookTestInvalidUsername;
  }

  public void setWebhookTestInvalidUsername(String webhookTestInvalidUsername) {
    this.webhookTestInvalidUsername = webhookTestInvalidUsername;
  }


  public ProjectConfigSaveReq webhookTestValidUsername(String webhookTestValidUsername) {
    this.webhookTestValidUsername = webhookTestValidUsername;
    return this;
  }

   /**
   * Get webhookTestValidUsername
   * @return webhookTestValidUsername
  **/
  @javax.annotation.Nullable
  public String getWebhookTestValidUsername() {
    return webhookTestValidUsername;
  }

  public void setWebhookTestValidUsername(String webhookTestValidUsername) {
    this.webhookTestValidUsername = webhookTestValidUsername;
  }


  public ProjectConfigSaveReq webhookTestValidPassword(String webhookTestValidPassword) {
    this.webhookTestValidPassword = webhookTestValidPassword;
    return this;
  }

   /**
   * Get webhookTestValidPassword
   * @return webhookTestValidPassword
  **/
  @javax.annotation.Nullable
  public String getWebhookTestValidPassword() {
    return webhookTestValidPassword;
  }

  public void setWebhookTestValidPassword(String webhookTestValidPassword) {
    this.webhookTestValidPassword = webhookTestValidPassword;
  }


  public ProjectConfigSaveReq externalApplicationUsername(String externalApplicationUsername) {
    this.externalApplicationUsername = externalApplicationUsername;
    return this;
  }

   /**
   * Get externalApplicationUsername
   * @return externalApplicationUsername
  **/
  @javax.annotation.Nullable
  public String getExternalApplicationUsername() {
    return externalApplicationUsername;
  }

  public void setExternalApplicationUsername(String externalApplicationUsername) {
    this.externalApplicationUsername = externalApplicationUsername;
  }


  public ProjectConfigSaveReq externalApplicationPassword(String externalApplicationPassword) {
    this.externalApplicationPassword = externalApplicationPassword;
    return this;
  }

   /**
   * Get externalApplicationPassword
   * @return externalApplicationPassword
  **/
  @javax.annotation.Nullable
  public String getExternalApplicationPassword() {
    return externalApplicationPassword;
  }

  public void setExternalApplicationPassword(String externalApplicationPassword) {
    this.externalApplicationPassword = externalApplicationPassword;
  }


  public ProjectConfigSaveReq legacyAuthMethodsUrl(String legacyAuthMethodsUrl) {
    this.legacyAuthMethodsUrl = legacyAuthMethodsUrl;
    return this;
  }

   /**
   * Get legacyAuthMethodsUrl
   * @return legacyAuthMethodsUrl
  **/
  @javax.annotation.Nullable
  public String getLegacyAuthMethodsUrl() {
    return legacyAuthMethodsUrl;
  }

  public void setLegacyAuthMethodsUrl(String legacyAuthMethodsUrl) {
    this.legacyAuthMethodsUrl = legacyAuthMethodsUrl;
  }


  public ProjectConfigSaveReq passwordVerifyUrl(String passwordVerifyUrl) {
    this.passwordVerifyUrl = passwordVerifyUrl;
    return this;
  }

   /**
   * Get passwordVerifyUrl
   * @return passwordVerifyUrl
  **/
  @javax.annotation.Nullable
  public String getPasswordVerifyUrl() {
    return passwordVerifyUrl;
  }

  public void setPasswordVerifyUrl(String passwordVerifyUrl) {
    this.passwordVerifyUrl = passwordVerifyUrl;
  }


  public ProjectConfigSaveReq authSuccessRedirectUrl(String authSuccessRedirectUrl) {
    this.authSuccessRedirectUrl = authSuccessRedirectUrl;
    return this;
  }

   /**
   * Get authSuccessRedirectUrl
   * @return authSuccessRedirectUrl
  **/
  @javax.annotation.Nullable
  public String getAuthSuccessRedirectUrl() {
    return authSuccessRedirectUrl;
  }

  public void setAuthSuccessRedirectUrl(String authSuccessRedirectUrl) {
    this.authSuccessRedirectUrl = authSuccessRedirectUrl;
  }


  public ProjectConfigSaveReq passwordResetUrl(String passwordResetUrl) {
    this.passwordResetUrl = passwordResetUrl;
    return this;
  }

   /**
   * Get passwordResetUrl
   * @return passwordResetUrl
  **/
  @javax.annotation.Nullable
  public String getPasswordResetUrl() {
    return passwordResetUrl;
  }

  public void setPasswordResetUrl(String passwordResetUrl) {
    this.passwordResetUrl = passwordResetUrl;
  }


  public ProjectConfigSaveReq allowUserRegistration(Boolean allowUserRegistration) {
    this.allowUserRegistration = allowUserRegistration;
    return this;
  }

   /**
   * Get allowUserRegistration
   * @return allowUserRegistration
  **/
  @javax.annotation.Nullable
  public Boolean getAllowUserRegistration() {
    return allowUserRegistration;
  }

  public void setAllowUserRegistration(Boolean allowUserRegistration) {
    this.allowUserRegistration = allowUserRegistration;
  }


  public ProjectConfigSaveReq allowIPStickiness(Boolean allowIPStickiness) {
    this.allowIPStickiness = allowIPStickiness;
    return this;
  }

   /**
   * Get allowIPStickiness
   * @return allowIPStickiness
  **/
  @javax.annotation.Nullable
  public Boolean getAllowIPStickiness() {
    return allowIPStickiness;
  }

  public void setAllowIPStickiness(Boolean allowIPStickiness) {
    this.allowIPStickiness = allowIPStickiness;
  }


  public ProjectConfigSaveReq passkeyAppendInterval(PasskeyAppendIntervalEnum passkeyAppendInterval) {
    this.passkeyAppendInterval = passkeyAppendInterval;
    return this;
  }

   /**
   * Get passkeyAppendInterval
   * @return passkeyAppendInterval
  **/
  @javax.annotation.Nullable
  public PasskeyAppendIntervalEnum getPasskeyAppendInterval() {
    return passkeyAppendInterval;
  }

  public void setPasskeyAppendInterval(PasskeyAppendIntervalEnum passkeyAppendInterval) {
    this.passkeyAppendInterval = passkeyAppendInterval;
  }


  public ProjectConfigSaveReq fallbackLanguage(String fallbackLanguage) {
    this.fallbackLanguage = fallbackLanguage;
    return this;
  }

   /**
   * Get fallbackLanguage
   * @return fallbackLanguage
  **/
  @javax.annotation.Nullable
  public String getFallbackLanguage() {
    return fallbackLanguage;
  }

  public void setFallbackLanguage(String fallbackLanguage) {
    this.fallbackLanguage = fallbackLanguage;
  }


  public ProjectConfigSaveReq autoDetectLanguage(Boolean autoDetectLanguage) {
    this.autoDetectLanguage = autoDetectLanguage;
    return this;
  }

   /**
   * Get autoDetectLanguage
   * @return autoDetectLanguage
  **/
  @javax.annotation.Nullable
  public Boolean getAutoDetectLanguage() {
    return autoDetectLanguage;
  }

  public void setAutoDetectLanguage(Boolean autoDetectLanguage) {
    this.autoDetectLanguage = autoDetectLanguage;
  }


  public ProjectConfigSaveReq hasExistingUsers(Boolean hasExistingUsers) {
    this.hasExistingUsers = hasExistingUsers;
    return this;
  }

   /**
   * Get hasExistingUsers
   * @return hasExistingUsers
  **/
  @javax.annotation.Nullable
  public Boolean getHasExistingUsers() {
    return hasExistingUsers;
  }

  public void setHasExistingUsers(Boolean hasExistingUsers) {
    this.hasExistingUsers = hasExistingUsers;
  }


  public ProjectConfigSaveReq hasVerifiedSession(Boolean hasVerifiedSession) {
    this.hasVerifiedSession = hasVerifiedSession;
    return this;
  }

   /**
   * Get hasVerifiedSession
   * @return hasVerifiedSession
  **/
  @javax.annotation.Nullable
  public Boolean getHasVerifiedSession() {
    return hasVerifiedSession;
  }

  public void setHasVerifiedSession(Boolean hasVerifiedSession) {
    this.hasVerifiedSession = hasVerifiedSession;
  }


  public ProjectConfigSaveReq hasGeneratedSession(Boolean hasGeneratedSession) {
    this.hasGeneratedSession = hasGeneratedSession;
    return this;
  }

   /**
   * Get hasGeneratedSession
   * @return hasGeneratedSession
  **/
  @javax.annotation.Nullable
  public Boolean getHasGeneratedSession() {
    return hasGeneratedSession;
  }

  public void setHasGeneratedSession(Boolean hasGeneratedSession) {
    this.hasGeneratedSession = hasGeneratedSession;
  }


  public ProjectConfigSaveReq hasStartedUsingPasskeys(Boolean hasStartedUsingPasskeys) {
    this.hasStartedUsingPasskeys = hasStartedUsingPasskeys;
    return this;
  }

   /**
   * Get hasStartedUsingPasskeys
   * @return hasStartedUsingPasskeys
  **/
  @javax.annotation.Nullable
  public Boolean getHasStartedUsingPasskeys() {
    return hasStartedUsingPasskeys;
  }

  public void setHasStartedUsingPasskeys(Boolean hasStartedUsingPasskeys) {
    this.hasStartedUsingPasskeys = hasStartedUsingPasskeys;
  }


  public ProjectConfigSaveReq hasStartedUsingSessions(Boolean hasStartedUsingSessions) {
    this.hasStartedUsingSessions = hasStartedUsingSessions;
    return this;
  }

   /**
   * Get hasStartedUsingSessions
   * @return hasStartedUsingSessions
  **/
  @javax.annotation.Nullable
  public Boolean getHasStartedUsingSessions() {
    return hasStartedUsingSessions;
  }

  public void setHasStartedUsingSessions(Boolean hasStartedUsingSessions) {
    this.hasStartedUsingSessions = hasStartedUsingSessions;
  }


  public ProjectConfigSaveReq applicationUrl(String applicationUrl) {
    this.applicationUrl = applicationUrl;
    return this;
  }

   /**
   * Get applicationUrl
   * @return applicationUrl
  **/
  @javax.annotation.Nullable
  public String getApplicationUrl() {
    return applicationUrl;
  }

  public void setApplicationUrl(String applicationUrl) {
    this.applicationUrl = applicationUrl;
  }


  public ProjectConfigSaveReq useCli(Boolean useCli) {
    this.useCli = useCli;
    return this;
  }

   /**
   * Get useCli
   * @return useCli
  **/
  @javax.annotation.Nullable
  public Boolean getUseCli() {
    return useCli;
  }

  public void setUseCli(Boolean useCli) {
    this.useCli = useCli;
  }


  public ProjectConfigSaveReq doubleOptIn(Boolean doubleOptIn) {
    this.doubleOptIn = doubleOptIn;
    return this;
  }

   /**
   * Get doubleOptIn
   * @return doubleOptIn
  **/
  @javax.annotation.Nullable
  public Boolean getDoubleOptIn() {
    return doubleOptIn;
  }

  public void setDoubleOptIn(Boolean doubleOptIn) {
    this.doubleOptIn = doubleOptIn;
  }


  public ProjectConfigSaveReq userFullNameRequired(Boolean userFullNameRequired) {
    this.userFullNameRequired = userFullNameRequired;
    return this;
  }

   /**
   * Get userFullNameRequired
   * @return userFullNameRequired
  **/
  @javax.annotation.Nullable
  public Boolean getUserFullNameRequired() {
    return userFullNameRequired;
  }

  public void setUserFullNameRequired(Boolean userFullNameRequired) {
    this.userFullNameRequired = userFullNameRequired;
  }


  public ProjectConfigSaveReq webauthnRPID(String webauthnRPID) {
    this.webauthnRPID = webauthnRPID;
    return this;
  }

   /**
   * Get webauthnRPID
   * @return webauthnRPID
  **/
  @javax.annotation.Nullable
  public String getWebauthnRPID() {
    return webauthnRPID;
  }

  public void setWebauthnRPID(String webauthnRPID) {
    this.webauthnRPID = webauthnRPID;
  }


  public ProjectConfigSaveReq environment(EnvironmentEnum environment) {
    this.environment = environment;
    return this;
  }

   /**
   * Get environment
   * @return environment
  **/
  @javax.annotation.Nullable
  public EnvironmentEnum getEnvironment() {
    return environment;
  }

  public void setEnvironment(EnvironmentEnum environment) {
    this.environment = environment;
  }


  public ProjectConfigSaveReq frontendFramework(FrontendFrameworkEnum frontendFramework) {
    this.frontendFramework = frontendFramework;
    return this;
  }

   /**
   * Get frontendFramework
   * @return frontendFramework
  **/
  @javax.annotation.Nullable
  public FrontendFrameworkEnum getFrontendFramework() {
    return frontendFramework;
  }

  public void setFrontendFramework(FrontendFrameworkEnum frontendFramework) {
    this.frontendFramework = frontendFramework;
  }


  public ProjectConfigSaveReq backendLanguage(BackendLanguageEnum backendLanguage) {
    this.backendLanguage = backendLanguage;
    return this;
  }

   /**
   * Get backendLanguage
   * @return backendLanguage
  **/
  @javax.annotation.Nullable
  public BackendLanguageEnum getBackendLanguage() {
    return backendLanguage;
  }

  public void setBackendLanguage(BackendLanguageEnum backendLanguage) {
    this.backendLanguage = backendLanguage;
  }


  public ProjectConfigSaveReq webComponentDebug(Boolean webComponentDebug) {
    this.webComponentDebug = webComponentDebug;
    return this;
  }

   /**
   * Get webComponentDebug
   * @return webComponentDebug
  **/
  @javax.annotation.Nullable
  public Boolean getWebComponentDebug() {
    return webComponentDebug;
  }

  public void setWebComponentDebug(Boolean webComponentDebug) {
    this.webComponentDebug = webComponentDebug;
  }


  public ProjectConfigSaveReq smtpUseCustom(Boolean smtpUseCustom) {
    this.smtpUseCustom = smtpUseCustom;
    return this;
  }

   /**
   * Get smtpUseCustom
   * @return smtpUseCustom
  **/
  @javax.annotation.Nullable
  public Boolean getSmtpUseCustom() {
    return smtpUseCustom;
  }

  public void setSmtpUseCustom(Boolean smtpUseCustom) {
    this.smtpUseCustom = smtpUseCustom;
  }


  public ProjectConfigSaveReq smtpHost(String smtpHost) {
    this.smtpHost = smtpHost;
    return this;
  }

   /**
   * Get smtpHost
   * @return smtpHost
  **/
  @javax.annotation.Nullable
  public String getSmtpHost() {
    return smtpHost;
  }

  public void setSmtpHost(String smtpHost) {
    this.smtpHost = smtpHost;
  }


  public ProjectConfigSaveReq smtpPort(Integer smtpPort) {
    this.smtpPort = smtpPort;
    return this;
  }

   /**
   * Get smtpPort
   * @return smtpPort
  **/
  @javax.annotation.Nullable
  public Integer getSmtpPort() {
    return smtpPort;
  }

  public void setSmtpPort(Integer smtpPort) {
    this.smtpPort = smtpPort;
  }


  public ProjectConfigSaveReq smtpUsername(String smtpUsername) {
    this.smtpUsername = smtpUsername;
    return this;
  }

   /**
   * Get smtpUsername
   * @return smtpUsername
  **/
  @javax.annotation.Nullable
  public String getSmtpUsername() {
    return smtpUsername;
  }

  public void setSmtpUsername(String smtpUsername) {
    this.smtpUsername = smtpUsername;
  }


  public ProjectConfigSaveReq smtpPassword(String smtpPassword) {
    this.smtpPassword = smtpPassword;
    return this;
  }

   /**
   * Get smtpPassword
   * @return smtpPassword
  **/
  @javax.annotation.Nullable
  public String getSmtpPassword() {
    return smtpPassword;
  }

  public void setSmtpPassword(String smtpPassword) {
    this.smtpPassword = smtpPassword;
  }


  public ProjectConfigSaveReq supportEmail(String supportEmail) {
    this.supportEmail = supportEmail;
    return this;
  }

   /**
   * Get supportEmail
   * @return supportEmail
  **/
  @javax.annotation.Nullable
  public String getSupportEmail() {
    return supportEmail;
  }

  public void setSupportEmail(String supportEmail) {
    this.supportEmail = supportEmail;
  }


  public ProjectConfigSaveReq signupFlow(SignupFlowEnum signupFlow) {
    this.signupFlow = signupFlow;
    return this;
  }

   /**
   * Get signupFlow
   * @return signupFlow
  **/
  @javax.annotation.Nullable
  public SignupFlowEnum getSignupFlow() {
    return signupFlow;
  }

  public void setSignupFlow(SignupFlowEnum signupFlow) {
    this.signupFlow = signupFlow;
  }


  public ProjectConfigSaveReq signupFlowOptions(Object signupFlowOptions) {
    this.signupFlowOptions = signupFlowOptions;
    return this;
  }

   /**
   * Get signupFlowOptions
   * @return signupFlowOptions
  **/
  @javax.annotation.Nullable
  public Object getSignupFlowOptions() {
    return signupFlowOptions;
  }

  public void setSignupFlowOptions(Object signupFlowOptions) {
    this.signupFlowOptions = signupFlowOptions;
  }


  public ProjectConfigSaveReq loginFlow(LoginFlowEnum loginFlow) {
    this.loginFlow = loginFlow;
    return this;
  }

   /**
   * Get loginFlow
   * @return loginFlow
  **/
  @javax.annotation.Nullable
  public LoginFlowEnum getLoginFlow() {
    return loginFlow;
  }

  public void setLoginFlow(LoginFlowEnum loginFlow) {
    this.loginFlow = loginFlow;
  }


  public ProjectConfigSaveReq loginFlowOptions(Object loginFlowOptions) {
    this.loginFlowOptions = loginFlowOptions;
    return this;
  }

   /**
   * Get loginFlowOptions
   * @return loginFlowOptions
  **/
  @javax.annotation.Nullable
  public Object getLoginFlowOptions() {
    return loginFlowOptions;
  }

  public void setLoginFlowOptions(Object loginFlowOptions) {
    this.loginFlowOptions = loginFlowOptions;
  }


  public ProjectConfigSaveReq requestID(String requestID) {
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


  public ProjectConfigSaveReq clientInfo(ClientInfo clientInfo) {
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


  public ProjectConfigSaveReq allowStaticChallenges(Boolean allowStaticChallenges) {
    this.allowStaticChallenges = allowStaticChallenges;
    return this;
  }

   /**
   * Get allowStaticChallenges
   * @return allowStaticChallenges
  **/
  @javax.annotation.Nullable
  public Boolean getAllowStaticChallenges() {
    return allowStaticChallenges;
  }

  public void setAllowStaticChallenges(Boolean allowStaticChallenges) {
    this.allowStaticChallenges = allowStaticChallenges;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProjectConfigSaveReq projectConfigSaveReq = (ProjectConfigSaveReq) o;
    return Objects.equals(this.externalName, projectConfigSaveReq.externalName) &&
        Objects.equals(this.appType, projectConfigSaveReq.appType) &&
        Objects.equals(this.productKey, projectConfigSaveReq.productKey) &&
        Objects.equals(this.emailFrom, projectConfigSaveReq.emailFrom) &&
        Objects.equals(this.smsFrom, projectConfigSaveReq.smsFrom) &&
        Objects.equals(this.externalApplicationProtocolVersion, projectConfigSaveReq.externalApplicationProtocolVersion) &&
        Objects.equals(this.webhookURL, projectConfigSaveReq.webhookURL) &&
        Objects.equals(this.webhookActions, projectConfigSaveReq.webhookActions) &&
        Objects.equals(this.webhookUsername, projectConfigSaveReq.webhookUsername) &&
        Objects.equals(this.webhookPassword, projectConfigSaveReq.webhookPassword) &&
        Objects.equals(this.webhookTestInvalidUsername, projectConfigSaveReq.webhookTestInvalidUsername) &&
        Objects.equals(this.webhookTestValidUsername, projectConfigSaveReq.webhookTestValidUsername) &&
        Objects.equals(this.webhookTestValidPassword, projectConfigSaveReq.webhookTestValidPassword) &&
        Objects.equals(this.externalApplicationUsername, projectConfigSaveReq.externalApplicationUsername) &&
        Objects.equals(this.externalApplicationPassword, projectConfigSaveReq.externalApplicationPassword) &&
        Objects.equals(this.legacyAuthMethodsUrl, projectConfigSaveReq.legacyAuthMethodsUrl) &&
        Objects.equals(this.passwordVerifyUrl, projectConfigSaveReq.passwordVerifyUrl) &&
        Objects.equals(this.authSuccessRedirectUrl, projectConfigSaveReq.authSuccessRedirectUrl) &&
        Objects.equals(this.passwordResetUrl, projectConfigSaveReq.passwordResetUrl) &&
        Objects.equals(this.allowUserRegistration, projectConfigSaveReq.allowUserRegistration) &&
        Objects.equals(this.allowIPStickiness, projectConfigSaveReq.allowIPStickiness) &&
        Objects.equals(this.passkeyAppendInterval, projectConfigSaveReq.passkeyAppendInterval) &&
        Objects.equals(this.fallbackLanguage, projectConfigSaveReq.fallbackLanguage) &&
        Objects.equals(this.autoDetectLanguage, projectConfigSaveReq.autoDetectLanguage) &&
        Objects.equals(this.hasExistingUsers, projectConfigSaveReq.hasExistingUsers) &&
        Objects.equals(this.hasVerifiedSession, projectConfigSaveReq.hasVerifiedSession) &&
        Objects.equals(this.hasGeneratedSession, projectConfigSaveReq.hasGeneratedSession) &&
        Objects.equals(this.hasStartedUsingPasskeys, projectConfigSaveReq.hasStartedUsingPasskeys) &&
        Objects.equals(this.hasStartedUsingSessions, projectConfigSaveReq.hasStartedUsingSessions) &&
        Objects.equals(this.applicationUrl, projectConfigSaveReq.applicationUrl) &&
        Objects.equals(this.useCli, projectConfigSaveReq.useCli) &&
        Objects.equals(this.doubleOptIn, projectConfigSaveReq.doubleOptIn) &&
        Objects.equals(this.userFullNameRequired, projectConfigSaveReq.userFullNameRequired) &&
        Objects.equals(this.webauthnRPID, projectConfigSaveReq.webauthnRPID) &&
        Objects.equals(this.environment, projectConfigSaveReq.environment) &&
        Objects.equals(this.frontendFramework, projectConfigSaveReq.frontendFramework) &&
        Objects.equals(this.backendLanguage, projectConfigSaveReq.backendLanguage) &&
        Objects.equals(this.webComponentDebug, projectConfigSaveReq.webComponentDebug) &&
        Objects.equals(this.smtpUseCustom, projectConfigSaveReq.smtpUseCustom) &&
        Objects.equals(this.smtpHost, projectConfigSaveReq.smtpHost) &&
        Objects.equals(this.smtpPort, projectConfigSaveReq.smtpPort) &&
        Objects.equals(this.smtpUsername, projectConfigSaveReq.smtpUsername) &&
        Objects.equals(this.smtpPassword, projectConfigSaveReq.smtpPassword) &&
        Objects.equals(this.supportEmail, projectConfigSaveReq.supportEmail) &&
        Objects.equals(this.signupFlow, projectConfigSaveReq.signupFlow) &&
        Objects.equals(this.signupFlowOptions, projectConfigSaveReq.signupFlowOptions) &&
        Objects.equals(this.loginFlow, projectConfigSaveReq.loginFlow) &&
        Objects.equals(this.loginFlowOptions, projectConfigSaveReq.loginFlowOptions) &&
        Objects.equals(this.requestID, projectConfigSaveReq.requestID) &&
        Objects.equals(this.clientInfo, projectConfigSaveReq.clientInfo) &&
        Objects.equals(this.allowStaticChallenges, projectConfigSaveReq.allowStaticChallenges);
  }

  @Override
  public int hashCode() {
    return Objects.hash(externalName, appType, productKey, emailFrom, smsFrom, externalApplicationProtocolVersion, webhookURL, webhookActions, webhookUsername, webhookPassword, webhookTestInvalidUsername, webhookTestValidUsername, webhookTestValidPassword, externalApplicationUsername, externalApplicationPassword, legacyAuthMethodsUrl, passwordVerifyUrl, authSuccessRedirectUrl, passwordResetUrl, allowUserRegistration, allowIPStickiness, passkeyAppendInterval, fallbackLanguage, autoDetectLanguage, hasExistingUsers, hasVerifiedSession, hasGeneratedSession, hasStartedUsingPasskeys, hasStartedUsingSessions, applicationUrl, useCli, doubleOptIn, userFullNameRequired, webauthnRPID, environment, frontendFramework, backendLanguage, webComponentDebug, smtpUseCustom, smtpHost, smtpPort, smtpUsername, smtpPassword, supportEmail, signupFlow, signupFlowOptions, loginFlow, loginFlowOptions, requestID, clientInfo, allowStaticChallenges);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProjectConfigSaveReq {\n");
    sb.append("    externalName: ").append(toIndentedString(externalName)).append("\n");
    sb.append("    appType: ").append(toIndentedString(appType)).append("\n");
    sb.append("    productKey: ").append(toIndentedString(productKey)).append("\n");
    sb.append("    emailFrom: ").append(toIndentedString(emailFrom)).append("\n");
    sb.append("    smsFrom: ").append(toIndentedString(smsFrom)).append("\n");
    sb.append("    externalApplicationProtocolVersion: ").append(toIndentedString(externalApplicationProtocolVersion)).append("\n");
    sb.append("    webhookURL: ").append(toIndentedString(webhookURL)).append("\n");
    sb.append("    webhookActions: ").append(toIndentedString(webhookActions)).append("\n");
    sb.append("    webhookUsername: ").append(toIndentedString(webhookUsername)).append("\n");
    sb.append("    webhookPassword: ").append(toIndentedString(webhookPassword)).append("\n");
    sb.append("    webhookTestInvalidUsername: ").append(toIndentedString(webhookTestInvalidUsername)).append("\n");
    sb.append("    webhookTestValidUsername: ").append(toIndentedString(webhookTestValidUsername)).append("\n");
    sb.append("    webhookTestValidPassword: ").append(toIndentedString(webhookTestValidPassword)).append("\n");
    sb.append("    externalApplicationUsername: ").append(toIndentedString(externalApplicationUsername)).append("\n");
    sb.append("    externalApplicationPassword: ").append(toIndentedString(externalApplicationPassword)).append("\n");
    sb.append("    legacyAuthMethodsUrl: ").append(toIndentedString(legacyAuthMethodsUrl)).append("\n");
    sb.append("    passwordVerifyUrl: ").append(toIndentedString(passwordVerifyUrl)).append("\n");
    sb.append("    authSuccessRedirectUrl: ").append(toIndentedString(authSuccessRedirectUrl)).append("\n");
    sb.append("    passwordResetUrl: ").append(toIndentedString(passwordResetUrl)).append("\n");
    sb.append("    allowUserRegistration: ").append(toIndentedString(allowUserRegistration)).append("\n");
    sb.append("    allowIPStickiness: ").append(toIndentedString(allowIPStickiness)).append("\n");
    sb.append("    passkeyAppendInterval: ").append(toIndentedString(passkeyAppendInterval)).append("\n");
    sb.append("    fallbackLanguage: ").append(toIndentedString(fallbackLanguage)).append("\n");
    sb.append("    autoDetectLanguage: ").append(toIndentedString(autoDetectLanguage)).append("\n");
    sb.append("    hasExistingUsers: ").append(toIndentedString(hasExistingUsers)).append("\n");
    sb.append("    hasVerifiedSession: ").append(toIndentedString(hasVerifiedSession)).append("\n");
    sb.append("    hasGeneratedSession: ").append(toIndentedString(hasGeneratedSession)).append("\n");
    sb.append("    hasStartedUsingPasskeys: ").append(toIndentedString(hasStartedUsingPasskeys)).append("\n");
    sb.append("    hasStartedUsingSessions: ").append(toIndentedString(hasStartedUsingSessions)).append("\n");
    sb.append("    applicationUrl: ").append(toIndentedString(applicationUrl)).append("\n");
    sb.append("    useCli: ").append(toIndentedString(useCli)).append("\n");
    sb.append("    doubleOptIn: ").append(toIndentedString(doubleOptIn)).append("\n");
    sb.append("    userFullNameRequired: ").append(toIndentedString(userFullNameRequired)).append("\n");
    sb.append("    webauthnRPID: ").append(toIndentedString(webauthnRPID)).append("\n");
    sb.append("    environment: ").append(toIndentedString(environment)).append("\n");
    sb.append("    frontendFramework: ").append(toIndentedString(frontendFramework)).append("\n");
    sb.append("    backendLanguage: ").append(toIndentedString(backendLanguage)).append("\n");
    sb.append("    webComponentDebug: ").append(toIndentedString(webComponentDebug)).append("\n");
    sb.append("    smtpUseCustom: ").append(toIndentedString(smtpUseCustom)).append("\n");
    sb.append("    smtpHost: ").append(toIndentedString(smtpHost)).append("\n");
    sb.append("    smtpPort: ").append(toIndentedString(smtpPort)).append("\n");
    sb.append("    smtpUsername: ").append(toIndentedString(smtpUsername)).append("\n");
    sb.append("    smtpPassword: ").append(toIndentedString(smtpPassword)).append("\n");
    sb.append("    supportEmail: ").append(toIndentedString(supportEmail)).append("\n");
    sb.append("    signupFlow: ").append(toIndentedString(signupFlow)).append("\n");
    sb.append("    signupFlowOptions: ").append(toIndentedString(signupFlowOptions)).append("\n");
    sb.append("    loginFlow: ").append(toIndentedString(loginFlow)).append("\n");
    sb.append("    loginFlowOptions: ").append(toIndentedString(loginFlowOptions)).append("\n");
    sb.append("    requestID: ").append(toIndentedString(requestID)).append("\n");
    sb.append("    clientInfo: ").append(toIndentedString(clientInfo)).append("\n");
    sb.append("    allowStaticChallenges: ").append(toIndentedString(allowStaticChallenges)).append("\n");
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
    openapiFields.add("externalName");
    openapiFields.add("appType");
    openapiFields.add("productKey");
    openapiFields.add("emailFrom");
    openapiFields.add("smsFrom");
    openapiFields.add("externalApplicationProtocolVersion");
    openapiFields.add("webhookURL");
    openapiFields.add("webhookActions");
    openapiFields.add("webhookUsername");
    openapiFields.add("webhookPassword");
    openapiFields.add("webhookTestInvalidUsername");
    openapiFields.add("webhookTestValidUsername");
    openapiFields.add("webhookTestValidPassword");
    openapiFields.add("externalApplicationUsername");
    openapiFields.add("externalApplicationPassword");
    openapiFields.add("legacyAuthMethodsUrl");
    openapiFields.add("passwordVerifyUrl");
    openapiFields.add("authSuccessRedirectUrl");
    openapiFields.add("passwordResetUrl");
    openapiFields.add("allowUserRegistration");
    openapiFields.add("allowIPStickiness");
    openapiFields.add("passkeyAppendInterval");
    openapiFields.add("fallbackLanguage");
    openapiFields.add("autoDetectLanguage");
    openapiFields.add("hasExistingUsers");
    openapiFields.add("hasVerifiedSession");
    openapiFields.add("hasGeneratedSession");
    openapiFields.add("hasStartedUsingPasskeys");
    openapiFields.add("hasStartedUsingSessions");
    openapiFields.add("applicationUrl");
    openapiFields.add("useCli");
    openapiFields.add("doubleOptIn");
    openapiFields.add("userFullNameRequired");
    openapiFields.add("webauthnRPID");
    openapiFields.add("environment");
    openapiFields.add("frontendFramework");
    openapiFields.add("backendLanguage");
    openapiFields.add("webComponentDebug");
    openapiFields.add("smtpUseCustom");
    openapiFields.add("smtpHost");
    openapiFields.add("smtpPort");
    openapiFields.add("smtpUsername");
    openapiFields.add("smtpPassword");
    openapiFields.add("supportEmail");
    openapiFields.add("signupFlow");
    openapiFields.add("signupFlowOptions");
    openapiFields.add("loginFlow");
    openapiFields.add("loginFlowOptions");
    openapiFields.add("requestID");
    openapiFields.add("clientInfo");
    openapiFields.add("allowStaticChallenges");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to ProjectConfigSaveReq
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ProjectConfigSaveReq.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ProjectConfigSaveReq is not found in the empty JSON string", ProjectConfigSaveReq.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!ProjectConfigSaveReq.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ProjectConfigSaveReq` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("externalName") != null && !jsonObj.get("externalName").isJsonNull()) && !jsonObj.get("externalName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `externalName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("externalName").toString()));
      }
      // validate the optional field `appType`
      if (jsonObj.get("appType") != null && !jsonObj.get("appType").isJsonNull()) {
        AppType.validateJsonElement(jsonObj.get("appType"));
      }
      if ((jsonObj.get("productKey") != null && !jsonObj.get("productKey").isJsonNull()) && !jsonObj.get("productKey").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productKey` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productKey").toString()));
      }
      if ((jsonObj.get("emailFrom") != null && !jsonObj.get("emailFrom").isJsonNull()) && !jsonObj.get("emailFrom").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `emailFrom` to be a primitive type in the JSON string but got `%s`", jsonObj.get("emailFrom").toString()));
      }
      if ((jsonObj.get("smsFrom") != null && !jsonObj.get("smsFrom").isJsonNull()) && !jsonObj.get("smsFrom").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `smsFrom` to be a primitive type in the JSON string but got `%s`", jsonObj.get("smsFrom").toString()));
      }
      if ((jsonObj.get("externalApplicationProtocolVersion") != null && !jsonObj.get("externalApplicationProtocolVersion").isJsonNull()) && !jsonObj.get("externalApplicationProtocolVersion").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `externalApplicationProtocolVersion` to be a primitive type in the JSON string but got `%s`", jsonObj.get("externalApplicationProtocolVersion").toString()));
      }
      // validate the optional field `externalApplicationProtocolVersion`
      if (jsonObj.get("externalApplicationProtocolVersion") != null && !jsonObj.get("externalApplicationProtocolVersion").isJsonNull()) {
        ExternalApplicationProtocolVersionEnum.validateJsonElement(jsonObj.get("externalApplicationProtocolVersion"));
      }
      if ((jsonObj.get("webhookURL") != null && !jsonObj.get("webhookURL").isJsonNull()) && !jsonObj.get("webhookURL").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `webhookURL` to be a primitive type in the JSON string but got `%s`", jsonObj.get("webhookURL").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("webhookActions") != null && !jsonObj.get("webhookActions").isJsonNull() && !jsonObj.get("webhookActions").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `webhookActions` to be an array in the JSON string but got `%s`", jsonObj.get("webhookActions").toString()));
      }
      if ((jsonObj.get("webhookUsername") != null && !jsonObj.get("webhookUsername").isJsonNull()) && !jsonObj.get("webhookUsername").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `webhookUsername` to be a primitive type in the JSON string but got `%s`", jsonObj.get("webhookUsername").toString()));
      }
      if ((jsonObj.get("webhookPassword") != null && !jsonObj.get("webhookPassword").isJsonNull()) && !jsonObj.get("webhookPassword").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `webhookPassword` to be a primitive type in the JSON string but got `%s`", jsonObj.get("webhookPassword").toString()));
      }
      if ((jsonObj.get("webhookTestInvalidUsername") != null && !jsonObj.get("webhookTestInvalidUsername").isJsonNull()) && !jsonObj.get("webhookTestInvalidUsername").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `webhookTestInvalidUsername` to be a primitive type in the JSON string but got `%s`", jsonObj.get("webhookTestInvalidUsername").toString()));
      }
      if ((jsonObj.get("webhookTestValidUsername") != null && !jsonObj.get("webhookTestValidUsername").isJsonNull()) && !jsonObj.get("webhookTestValidUsername").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `webhookTestValidUsername` to be a primitive type in the JSON string but got `%s`", jsonObj.get("webhookTestValidUsername").toString()));
      }
      if ((jsonObj.get("webhookTestValidPassword") != null && !jsonObj.get("webhookTestValidPassword").isJsonNull()) && !jsonObj.get("webhookTestValidPassword").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `webhookTestValidPassword` to be a primitive type in the JSON string but got `%s`", jsonObj.get("webhookTestValidPassword").toString()));
      }
      if ((jsonObj.get("externalApplicationUsername") != null && !jsonObj.get("externalApplicationUsername").isJsonNull()) && !jsonObj.get("externalApplicationUsername").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `externalApplicationUsername` to be a primitive type in the JSON string but got `%s`", jsonObj.get("externalApplicationUsername").toString()));
      }
      if ((jsonObj.get("externalApplicationPassword") != null && !jsonObj.get("externalApplicationPassword").isJsonNull()) && !jsonObj.get("externalApplicationPassword").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `externalApplicationPassword` to be a primitive type in the JSON string but got `%s`", jsonObj.get("externalApplicationPassword").toString()));
      }
      if ((jsonObj.get("legacyAuthMethodsUrl") != null && !jsonObj.get("legacyAuthMethodsUrl").isJsonNull()) && !jsonObj.get("legacyAuthMethodsUrl").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `legacyAuthMethodsUrl` to be a primitive type in the JSON string but got `%s`", jsonObj.get("legacyAuthMethodsUrl").toString()));
      }
      if ((jsonObj.get("passwordVerifyUrl") != null && !jsonObj.get("passwordVerifyUrl").isJsonNull()) && !jsonObj.get("passwordVerifyUrl").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `passwordVerifyUrl` to be a primitive type in the JSON string but got `%s`", jsonObj.get("passwordVerifyUrl").toString()));
      }
      if ((jsonObj.get("authSuccessRedirectUrl") != null && !jsonObj.get("authSuccessRedirectUrl").isJsonNull()) && !jsonObj.get("authSuccessRedirectUrl").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `authSuccessRedirectUrl` to be a primitive type in the JSON string but got `%s`", jsonObj.get("authSuccessRedirectUrl").toString()));
      }
      if ((jsonObj.get("passwordResetUrl") != null && !jsonObj.get("passwordResetUrl").isJsonNull()) && !jsonObj.get("passwordResetUrl").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `passwordResetUrl` to be a primitive type in the JSON string but got `%s`", jsonObj.get("passwordResetUrl").toString()));
      }
      if ((jsonObj.get("passkeyAppendInterval") != null && !jsonObj.get("passkeyAppendInterval").isJsonNull()) && !jsonObj.get("passkeyAppendInterval").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `passkeyAppendInterval` to be a primitive type in the JSON string but got `%s`", jsonObj.get("passkeyAppendInterval").toString()));
      }
      // validate the optional field `passkeyAppendInterval`
      if (jsonObj.get("passkeyAppendInterval") != null && !jsonObj.get("passkeyAppendInterval").isJsonNull()) {
        PasskeyAppendIntervalEnum.validateJsonElement(jsonObj.get("passkeyAppendInterval"));
      }
      if ((jsonObj.get("fallbackLanguage") != null && !jsonObj.get("fallbackLanguage").isJsonNull()) && !jsonObj.get("fallbackLanguage").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `fallbackLanguage` to be a primitive type in the JSON string but got `%s`", jsonObj.get("fallbackLanguage").toString()));
      }
      if ((jsonObj.get("applicationUrl") != null && !jsonObj.get("applicationUrl").isJsonNull()) && !jsonObj.get("applicationUrl").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `applicationUrl` to be a primitive type in the JSON string but got `%s`", jsonObj.get("applicationUrl").toString()));
      }
      if ((jsonObj.get("webauthnRPID") != null && !jsonObj.get("webauthnRPID").isJsonNull()) && !jsonObj.get("webauthnRPID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `webauthnRPID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("webauthnRPID").toString()));
      }
      if ((jsonObj.get("environment") != null && !jsonObj.get("environment").isJsonNull()) && !jsonObj.get("environment").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `environment` to be a primitive type in the JSON string but got `%s`", jsonObj.get("environment").toString()));
      }
      // validate the optional field `environment`
      if (jsonObj.get("environment") != null && !jsonObj.get("environment").isJsonNull()) {
        EnvironmentEnum.validateJsonElement(jsonObj.get("environment"));
      }
      if ((jsonObj.get("frontendFramework") != null && !jsonObj.get("frontendFramework").isJsonNull()) && !jsonObj.get("frontendFramework").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `frontendFramework` to be a primitive type in the JSON string but got `%s`", jsonObj.get("frontendFramework").toString()));
      }
      // validate the optional field `frontendFramework`
      if (jsonObj.get("frontendFramework") != null && !jsonObj.get("frontendFramework").isJsonNull()) {
        FrontendFrameworkEnum.validateJsonElement(jsonObj.get("frontendFramework"));
      }
      if ((jsonObj.get("backendLanguage") != null && !jsonObj.get("backendLanguage").isJsonNull()) && !jsonObj.get("backendLanguage").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `backendLanguage` to be a primitive type in the JSON string but got `%s`", jsonObj.get("backendLanguage").toString()));
      }
      // validate the optional field `backendLanguage`
      if (jsonObj.get("backendLanguage") != null && !jsonObj.get("backendLanguage").isJsonNull()) {
        BackendLanguageEnum.validateJsonElement(jsonObj.get("backendLanguage"));
      }
      if ((jsonObj.get("smtpHost") != null && !jsonObj.get("smtpHost").isJsonNull()) && !jsonObj.get("smtpHost").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `smtpHost` to be a primitive type in the JSON string but got `%s`", jsonObj.get("smtpHost").toString()));
      }
      if ((jsonObj.get("smtpUsername") != null && !jsonObj.get("smtpUsername").isJsonNull()) && !jsonObj.get("smtpUsername").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `smtpUsername` to be a primitive type in the JSON string but got `%s`", jsonObj.get("smtpUsername").toString()));
      }
      if ((jsonObj.get("smtpPassword") != null && !jsonObj.get("smtpPassword").isJsonNull()) && !jsonObj.get("smtpPassword").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `smtpPassword` to be a primitive type in the JSON string but got `%s`", jsonObj.get("smtpPassword").toString()));
      }
      if ((jsonObj.get("supportEmail") != null && !jsonObj.get("supportEmail").isJsonNull()) && !jsonObj.get("supportEmail").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `supportEmail` to be a primitive type in the JSON string but got `%s`", jsonObj.get("supportEmail").toString()));
      }
      if ((jsonObj.get("signupFlow") != null && !jsonObj.get("signupFlow").isJsonNull()) && !jsonObj.get("signupFlow").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `signupFlow` to be a primitive type in the JSON string but got `%s`", jsonObj.get("signupFlow").toString()));
      }
      // validate the optional field `signupFlow`
      if (jsonObj.get("signupFlow") != null && !jsonObj.get("signupFlow").isJsonNull()) {
        SignupFlowEnum.validateJsonElement(jsonObj.get("signupFlow"));
      }
      if ((jsonObj.get("loginFlow") != null && !jsonObj.get("loginFlow").isJsonNull()) && !jsonObj.get("loginFlow").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `loginFlow` to be a primitive type in the JSON string but got `%s`", jsonObj.get("loginFlow").toString()));
      }
      // validate the optional field `loginFlow`
      if (jsonObj.get("loginFlow") != null && !jsonObj.get("loginFlow").isJsonNull()) {
        LoginFlowEnum.validateJsonElement(jsonObj.get("loginFlow"));
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
       if (!ProjectConfigSaveReq.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ProjectConfigSaveReq' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ProjectConfigSaveReq> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ProjectConfigSaveReq.class));

       return (TypeAdapter<T>) new TypeAdapter<ProjectConfigSaveReq>() {
           @Override
           public void write(JsonWriter out, ProjectConfigSaveReq value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ProjectConfigSaveReq read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of ProjectConfigSaveReq given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of ProjectConfigSaveReq
  * @throws IOException if the JSON string is invalid with respect to ProjectConfigSaveReq
  */
  public static ProjectConfigSaveReq fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ProjectConfigSaveReq.class);
  }

 /**
  * Convert an instance of ProjectConfigSaveReq to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

