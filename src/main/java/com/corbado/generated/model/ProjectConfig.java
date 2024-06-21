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
 * ProjectConfig
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-21T11:14:23.049718350Z[Etc/UTC]", comments = "Generator version: 7.7.0-SNAPSHOT")
public class ProjectConfig {
  public static final String SERIALIZED_NAME_PROJECT_I_D = "projectID";
  @SerializedName(SERIALIZED_NAME_PROJECT_I_D)
  private String projectID;

  public static final String SERIALIZED_NAME_EXTERNAL_NAME = "externalName";
  @SerializedName(SERIALIZED_NAME_EXTERNAL_NAME)
  private String externalName;

  public static final String SERIALIZED_NAME_APP_TYPE = "appType";
  @SerializedName(SERIALIZED_NAME_APP_TYPE)
  private AppType appType;

  public static final String SERIALIZED_NAME_PRODUCT_KEY = "productKey";
  @SerializedName(SERIALIZED_NAME_PRODUCT_KEY)
  private String productKey;

  public static final String SERIALIZED_NAME_PROJECT_SUBSCRIPTION_I_D = "projectSubscriptionID";
  @SerializedName(SERIALIZED_NAME_PROJECT_SUBSCRIPTION_I_D)
  private String projectSubscriptionID;

  public static final String SERIALIZED_NAME_EMAIL_FROM = "emailFrom";
  @SerializedName(SERIALIZED_NAME_EMAIL_FROM)
  private String emailFrom;

  public static final String SERIALIZED_NAME_SMS_FROM = "smsFrom";
  @SerializedName(SERIALIZED_NAME_SMS_FROM)
  private String smsFrom;

  public static final String SERIALIZED_NAME_EXTERNAL_APPLICATION_PROTOCOL_VERSION = "externalApplicationProtocolVersion";
  @SerializedName(SERIALIZED_NAME_EXTERNAL_APPLICATION_PROTOCOL_VERSION)
  private String externalApplicationProtocolVersion;

  public static final String SERIALIZED_NAME_WEBHOOK_U_R_L = "webhookURL";
  @SerializedName(SERIALIZED_NAME_WEBHOOK_U_R_L)
  private String webhookURL;

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
    NOT_SPECIFIED("not_specified"),
    
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

  public static final String SERIALIZED_NAME_CLI_SECRET = "cliSecret";
  @SerializedName(SERIALIZED_NAME_CLI_SECRET)
  private String cliSecret;

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
    NOT_SPECIFIED("not_specified"),
    
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
    NOT_SPECIFIED("not_specified"),
    
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

  public static final String SERIALIZED_NAME_BACKEND_A_P_I_URL = "backendAPIUrl";
  @SerializedName(SERIALIZED_NAME_BACKEND_A_P_I_URL)
  private String backendAPIUrl;

  public static final String SERIALIZED_NAME_FRONTEND_A_P_I_URL = "frontendAPIUrl";
  @SerializedName(SERIALIZED_NAME_FRONTEND_A_P_I_URL)
  private String frontendAPIUrl;

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

  public static final String SERIALIZED_NAME_CNAME = "cname";
  @SerializedName(SERIALIZED_NAME_CNAME)
  private String cname;

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

  public static final String SERIALIZED_NAME_WEBHOOK_ACTIONS = "webhookActions";
  @SerializedName(SERIALIZED_NAME_WEBHOOK_ACTIONS)
  private List<String> webhookActions = new ArrayList<>();

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

  public static final String SERIALIZED_NAME_ALLOW_STATIC_CHALLENGES = "allowStaticChallenges";
  @SerializedName(SERIALIZED_NAME_ALLOW_STATIC_CHALLENGES)
  private Boolean allowStaticChallenges;

  public static final String SERIALIZED_NAME_CREATED = "created";
  @SerializedName(SERIALIZED_NAME_CREATED)
  private String created;

  public static final String SERIALIZED_NAME_UPDATED = "updated";
  @SerializedName(SERIALIZED_NAME_UPDATED)
  private String updated;

  /**
   * Gets or Sets status
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    ACTIVE("active"),
    
    CONFIGURING("configuring");

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

  public ProjectConfig() {
  }

  public ProjectConfig projectID(String projectID) {
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


  public ProjectConfig externalName(String externalName) {
    this.externalName = externalName;
    return this;
  }

   /**
   * Get externalName
   * @return externalName
  **/
  @javax.annotation.Nonnull
  public String getExternalName() {
    return externalName;
  }

  public void setExternalName(String externalName) {
    this.externalName = externalName;
  }


  public ProjectConfig appType(AppType appType) {
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


  public ProjectConfig productKey(String productKey) {
    this.productKey = productKey;
    return this;
  }

   /**
   * Get productKey
   * @return productKey
  **/
  @javax.annotation.Nonnull
  public String getProductKey() {
    return productKey;
  }

  public void setProductKey(String productKey) {
    this.productKey = productKey;
  }


  public ProjectConfig projectSubscriptionID(String projectSubscriptionID) {
    this.projectSubscriptionID = projectSubscriptionID;
    return this;
  }

   /**
   * Get projectSubscriptionID
   * @return projectSubscriptionID
  **/
  @javax.annotation.Nonnull
  public String getProjectSubscriptionID() {
    return projectSubscriptionID;
  }

  public void setProjectSubscriptionID(String projectSubscriptionID) {
    this.projectSubscriptionID = projectSubscriptionID;
  }


  public ProjectConfig emailFrom(String emailFrom) {
    this.emailFrom = emailFrom;
    return this;
  }

   /**
   * Get emailFrom
   * @return emailFrom
  **/
  @javax.annotation.Nonnull
  public String getEmailFrom() {
    return emailFrom;
  }

  public void setEmailFrom(String emailFrom) {
    this.emailFrom = emailFrom;
  }


  public ProjectConfig smsFrom(String smsFrom) {
    this.smsFrom = smsFrom;
    return this;
  }

   /**
   * Get smsFrom
   * @return smsFrom
  **/
  @javax.annotation.Nonnull
  public String getSmsFrom() {
    return smsFrom;
  }

  public void setSmsFrom(String smsFrom) {
    this.smsFrom = smsFrom;
  }


  public ProjectConfig externalApplicationProtocolVersion(String externalApplicationProtocolVersion) {
    this.externalApplicationProtocolVersion = externalApplicationProtocolVersion;
    return this;
  }

   /**
   * Get externalApplicationProtocolVersion
   * @return externalApplicationProtocolVersion
  **/
  @javax.annotation.Nonnull
  public String getExternalApplicationProtocolVersion() {
    return externalApplicationProtocolVersion;
  }

  public void setExternalApplicationProtocolVersion(String externalApplicationProtocolVersion) {
    this.externalApplicationProtocolVersion = externalApplicationProtocolVersion;
  }


  public ProjectConfig webhookURL(String webhookURL) {
    this.webhookURL = webhookURL;
    return this;
  }

   /**
   * Get webhookURL
   * @return webhookURL
  **/
  @javax.annotation.Nonnull
  public String getWebhookURL() {
    return webhookURL;
  }

  public void setWebhookURL(String webhookURL) {
    this.webhookURL = webhookURL;
  }


  public ProjectConfig webhookUsername(String webhookUsername) {
    this.webhookUsername = webhookUsername;
    return this;
  }

   /**
   * Get webhookUsername
   * @return webhookUsername
  **/
  @javax.annotation.Nonnull
  public String getWebhookUsername() {
    return webhookUsername;
  }

  public void setWebhookUsername(String webhookUsername) {
    this.webhookUsername = webhookUsername;
  }


  public ProjectConfig webhookPassword(String webhookPassword) {
    this.webhookPassword = webhookPassword;
    return this;
  }

   /**
   * Get webhookPassword
   * @return webhookPassword
  **/
  @javax.annotation.Nonnull
  public String getWebhookPassword() {
    return webhookPassword;
  }

  public void setWebhookPassword(String webhookPassword) {
    this.webhookPassword = webhookPassword;
  }


  public ProjectConfig webhookTestInvalidUsername(String webhookTestInvalidUsername) {
    this.webhookTestInvalidUsername = webhookTestInvalidUsername;
    return this;
  }

   /**
   * Get webhookTestInvalidUsername
   * @return webhookTestInvalidUsername
  **/
  @javax.annotation.Nonnull
  public String getWebhookTestInvalidUsername() {
    return webhookTestInvalidUsername;
  }

  public void setWebhookTestInvalidUsername(String webhookTestInvalidUsername) {
    this.webhookTestInvalidUsername = webhookTestInvalidUsername;
  }


  public ProjectConfig webhookTestValidUsername(String webhookTestValidUsername) {
    this.webhookTestValidUsername = webhookTestValidUsername;
    return this;
  }

   /**
   * Get webhookTestValidUsername
   * @return webhookTestValidUsername
  **/
  @javax.annotation.Nonnull
  public String getWebhookTestValidUsername() {
    return webhookTestValidUsername;
  }

  public void setWebhookTestValidUsername(String webhookTestValidUsername) {
    this.webhookTestValidUsername = webhookTestValidUsername;
  }


  public ProjectConfig webhookTestValidPassword(String webhookTestValidPassword) {
    this.webhookTestValidPassword = webhookTestValidPassword;
    return this;
  }

   /**
   * Get webhookTestValidPassword
   * @return webhookTestValidPassword
  **/
  @javax.annotation.Nonnull
  public String getWebhookTestValidPassword() {
    return webhookTestValidPassword;
  }

  public void setWebhookTestValidPassword(String webhookTestValidPassword) {
    this.webhookTestValidPassword = webhookTestValidPassword;
  }


  public ProjectConfig externalApplicationUsername(String externalApplicationUsername) {
    this.externalApplicationUsername = externalApplicationUsername;
    return this;
  }

   /**
   * Get externalApplicationUsername
   * @return externalApplicationUsername
  **/
  @javax.annotation.Nonnull
  public String getExternalApplicationUsername() {
    return externalApplicationUsername;
  }

  public void setExternalApplicationUsername(String externalApplicationUsername) {
    this.externalApplicationUsername = externalApplicationUsername;
  }


  public ProjectConfig externalApplicationPassword(String externalApplicationPassword) {
    this.externalApplicationPassword = externalApplicationPassword;
    return this;
  }

   /**
   * Get externalApplicationPassword
   * @return externalApplicationPassword
  **/
  @javax.annotation.Nonnull
  public String getExternalApplicationPassword() {
    return externalApplicationPassword;
  }

  public void setExternalApplicationPassword(String externalApplicationPassword) {
    this.externalApplicationPassword = externalApplicationPassword;
  }


  public ProjectConfig legacyAuthMethodsUrl(String legacyAuthMethodsUrl) {
    this.legacyAuthMethodsUrl = legacyAuthMethodsUrl;
    return this;
  }

   /**
   * Get legacyAuthMethodsUrl
   * @return legacyAuthMethodsUrl
  **/
  @javax.annotation.Nonnull
  public String getLegacyAuthMethodsUrl() {
    return legacyAuthMethodsUrl;
  }

  public void setLegacyAuthMethodsUrl(String legacyAuthMethodsUrl) {
    this.legacyAuthMethodsUrl = legacyAuthMethodsUrl;
  }


  public ProjectConfig passwordVerifyUrl(String passwordVerifyUrl) {
    this.passwordVerifyUrl = passwordVerifyUrl;
    return this;
  }

   /**
   * Get passwordVerifyUrl
   * @return passwordVerifyUrl
  **/
  @javax.annotation.Nonnull
  public String getPasswordVerifyUrl() {
    return passwordVerifyUrl;
  }

  public void setPasswordVerifyUrl(String passwordVerifyUrl) {
    this.passwordVerifyUrl = passwordVerifyUrl;
  }


  public ProjectConfig authSuccessRedirectUrl(String authSuccessRedirectUrl) {
    this.authSuccessRedirectUrl = authSuccessRedirectUrl;
    return this;
  }

   /**
   * Get authSuccessRedirectUrl
   * @return authSuccessRedirectUrl
  **/
  @javax.annotation.Nonnull
  public String getAuthSuccessRedirectUrl() {
    return authSuccessRedirectUrl;
  }

  public void setAuthSuccessRedirectUrl(String authSuccessRedirectUrl) {
    this.authSuccessRedirectUrl = authSuccessRedirectUrl;
  }


  public ProjectConfig passwordResetUrl(String passwordResetUrl) {
    this.passwordResetUrl = passwordResetUrl;
    return this;
  }

   /**
   * Get passwordResetUrl
   * @return passwordResetUrl
  **/
  @javax.annotation.Nonnull
  public String getPasswordResetUrl() {
    return passwordResetUrl;
  }

  public void setPasswordResetUrl(String passwordResetUrl) {
    this.passwordResetUrl = passwordResetUrl;
  }


  public ProjectConfig allowUserRegistration(Boolean allowUserRegistration) {
    this.allowUserRegistration = allowUserRegistration;
    return this;
  }

   /**
   * Get allowUserRegistration
   * @return allowUserRegistration
  **/
  @javax.annotation.Nonnull
  public Boolean getAllowUserRegistration() {
    return allowUserRegistration;
  }

  public void setAllowUserRegistration(Boolean allowUserRegistration) {
    this.allowUserRegistration = allowUserRegistration;
  }


  public ProjectConfig allowIPStickiness(Boolean allowIPStickiness) {
    this.allowIPStickiness = allowIPStickiness;
    return this;
  }

   /**
   * Get allowIPStickiness
   * @return allowIPStickiness
  **/
  @javax.annotation.Nonnull
  public Boolean getAllowIPStickiness() {
    return allowIPStickiness;
  }

  public void setAllowIPStickiness(Boolean allowIPStickiness) {
    this.allowIPStickiness = allowIPStickiness;
  }


  public ProjectConfig passkeyAppendInterval(PasskeyAppendIntervalEnum passkeyAppendInterval) {
    this.passkeyAppendInterval = passkeyAppendInterval;
    return this;
  }

   /**
   * Get passkeyAppendInterval
   * @return passkeyAppendInterval
  **/
  @javax.annotation.Nonnull
  public PasskeyAppendIntervalEnum getPasskeyAppendInterval() {
    return passkeyAppendInterval;
  }

  public void setPasskeyAppendInterval(PasskeyAppendIntervalEnum passkeyAppendInterval) {
    this.passkeyAppendInterval = passkeyAppendInterval;
  }


  public ProjectConfig cliSecret(String cliSecret) {
    this.cliSecret = cliSecret;
    return this;
  }

   /**
   * Get cliSecret
   * @return cliSecret
  **/
  @javax.annotation.Nonnull
  public String getCliSecret() {
    return cliSecret;
  }

  public void setCliSecret(String cliSecret) {
    this.cliSecret = cliSecret;
  }


  public ProjectConfig fallbackLanguage(String fallbackLanguage) {
    this.fallbackLanguage = fallbackLanguage;
    return this;
  }

   /**
   * Get fallbackLanguage
   * @return fallbackLanguage
  **/
  @javax.annotation.Nonnull
  public String getFallbackLanguage() {
    return fallbackLanguage;
  }

  public void setFallbackLanguage(String fallbackLanguage) {
    this.fallbackLanguage = fallbackLanguage;
  }


  public ProjectConfig autoDetectLanguage(Boolean autoDetectLanguage) {
    this.autoDetectLanguage = autoDetectLanguage;
    return this;
  }

   /**
   * Get autoDetectLanguage
   * @return autoDetectLanguage
  **/
  @javax.annotation.Nonnull
  public Boolean getAutoDetectLanguage() {
    return autoDetectLanguage;
  }

  public void setAutoDetectLanguage(Boolean autoDetectLanguage) {
    this.autoDetectLanguage = autoDetectLanguage;
  }


  public ProjectConfig hasExistingUsers(Boolean hasExistingUsers) {
    this.hasExistingUsers = hasExistingUsers;
    return this;
  }

   /**
   * Get hasExistingUsers
   * @return hasExistingUsers
  **/
  @javax.annotation.Nonnull
  public Boolean getHasExistingUsers() {
    return hasExistingUsers;
  }

  public void setHasExistingUsers(Boolean hasExistingUsers) {
    this.hasExistingUsers = hasExistingUsers;
  }


  public ProjectConfig hasVerifiedSession(Boolean hasVerifiedSession) {
    this.hasVerifiedSession = hasVerifiedSession;
    return this;
  }

   /**
   * Get hasVerifiedSession
   * @return hasVerifiedSession
  **/
  @javax.annotation.Nonnull
  public Boolean getHasVerifiedSession() {
    return hasVerifiedSession;
  }

  public void setHasVerifiedSession(Boolean hasVerifiedSession) {
    this.hasVerifiedSession = hasVerifiedSession;
  }


  public ProjectConfig hasGeneratedSession(Boolean hasGeneratedSession) {
    this.hasGeneratedSession = hasGeneratedSession;
    return this;
  }

   /**
   * Get hasGeneratedSession
   * @return hasGeneratedSession
  **/
  @javax.annotation.Nonnull
  public Boolean getHasGeneratedSession() {
    return hasGeneratedSession;
  }

  public void setHasGeneratedSession(Boolean hasGeneratedSession) {
    this.hasGeneratedSession = hasGeneratedSession;
  }


  public ProjectConfig hasStartedUsingPasskeys(Boolean hasStartedUsingPasskeys) {
    this.hasStartedUsingPasskeys = hasStartedUsingPasskeys;
    return this;
  }

   /**
   * Get hasStartedUsingPasskeys
   * @return hasStartedUsingPasskeys
  **/
  @javax.annotation.Nonnull
  public Boolean getHasStartedUsingPasskeys() {
    return hasStartedUsingPasskeys;
  }

  public void setHasStartedUsingPasskeys(Boolean hasStartedUsingPasskeys) {
    this.hasStartedUsingPasskeys = hasStartedUsingPasskeys;
  }


  public ProjectConfig hasStartedUsingSessions(Boolean hasStartedUsingSessions) {
    this.hasStartedUsingSessions = hasStartedUsingSessions;
    return this;
  }

   /**
   * Get hasStartedUsingSessions
   * @return hasStartedUsingSessions
  **/
  @javax.annotation.Nonnull
  public Boolean getHasStartedUsingSessions() {
    return hasStartedUsingSessions;
  }

  public void setHasStartedUsingSessions(Boolean hasStartedUsingSessions) {
    this.hasStartedUsingSessions = hasStartedUsingSessions;
  }


  public ProjectConfig environment(EnvironmentEnum environment) {
    this.environment = environment;
    return this;
  }

   /**
   * Get environment
   * @return environment
  **/
  @javax.annotation.Nonnull
  public EnvironmentEnum getEnvironment() {
    return environment;
  }

  public void setEnvironment(EnvironmentEnum environment) {
    this.environment = environment;
  }


  public ProjectConfig frontendFramework(FrontendFrameworkEnum frontendFramework) {
    this.frontendFramework = frontendFramework;
    return this;
  }

   /**
   * Get frontendFramework
   * @return frontendFramework
  **/
  @javax.annotation.Nonnull
  public FrontendFrameworkEnum getFrontendFramework() {
    return frontendFramework;
  }

  public void setFrontendFramework(FrontendFrameworkEnum frontendFramework) {
    this.frontendFramework = frontendFramework;
  }


  public ProjectConfig backendLanguage(BackendLanguageEnum backendLanguage) {
    this.backendLanguage = backendLanguage;
    return this;
  }

   /**
   * Get backendLanguage
   * @return backendLanguage
  **/
  @javax.annotation.Nonnull
  public BackendLanguageEnum getBackendLanguage() {
    return backendLanguage;
  }

  public void setBackendLanguage(BackendLanguageEnum backendLanguage) {
    this.backendLanguage = backendLanguage;
  }


  public ProjectConfig backendAPIUrl(String backendAPIUrl) {
    this.backendAPIUrl = backendAPIUrl;
    return this;
  }

   /**
   * Get backendAPIUrl
   * @return backendAPIUrl
  **/
  @javax.annotation.Nonnull
  public String getBackendAPIUrl() {
    return backendAPIUrl;
  }

  public void setBackendAPIUrl(String backendAPIUrl) {
    this.backendAPIUrl = backendAPIUrl;
  }


  public ProjectConfig frontendAPIUrl(String frontendAPIUrl) {
    this.frontendAPIUrl = frontendAPIUrl;
    return this;
  }

   /**
   * Get frontendAPIUrl
   * @return frontendAPIUrl
  **/
  @javax.annotation.Nonnull
  public String getFrontendAPIUrl() {
    return frontendAPIUrl;
  }

  public void setFrontendAPIUrl(String frontendAPIUrl) {
    this.frontendAPIUrl = frontendAPIUrl;
  }


  public ProjectConfig applicationUrl(String applicationUrl) {
    this.applicationUrl = applicationUrl;
    return this;
  }

   /**
   * Get applicationUrl
   * @return applicationUrl
  **/
  @javax.annotation.Nonnull
  public String getApplicationUrl() {
    return applicationUrl;
  }

  public void setApplicationUrl(String applicationUrl) {
    this.applicationUrl = applicationUrl;
  }


  public ProjectConfig useCli(Boolean useCli) {
    this.useCli = useCli;
    return this;
  }

   /**
   * Get useCli
   * @return useCli
  **/
  @javax.annotation.Nonnull
  public Boolean getUseCli() {
    return useCli;
  }

  public void setUseCli(Boolean useCli) {
    this.useCli = useCli;
  }


  public ProjectConfig doubleOptIn(Boolean doubleOptIn) {
    this.doubleOptIn = doubleOptIn;
    return this;
  }

   /**
   * Get doubleOptIn
   * @return doubleOptIn
  **/
  @javax.annotation.Nonnull
  public Boolean getDoubleOptIn() {
    return doubleOptIn;
  }

  public void setDoubleOptIn(Boolean doubleOptIn) {
    this.doubleOptIn = doubleOptIn;
  }


  public ProjectConfig userFullNameRequired(Boolean userFullNameRequired) {
    this.userFullNameRequired = userFullNameRequired;
    return this;
  }

   /**
   * Get userFullNameRequired
   * @return userFullNameRequired
  **/
  @javax.annotation.Nonnull
  public Boolean getUserFullNameRequired() {
    return userFullNameRequired;
  }

  public void setUserFullNameRequired(Boolean userFullNameRequired) {
    this.userFullNameRequired = userFullNameRequired;
  }


  public ProjectConfig webauthnRPID(String webauthnRPID) {
    this.webauthnRPID = webauthnRPID;
    return this;
  }

   /**
   * Get webauthnRPID
   * @return webauthnRPID
  **/
  @javax.annotation.Nonnull
  public String getWebauthnRPID() {
    return webauthnRPID;
  }

  public void setWebauthnRPID(String webauthnRPID) {
    this.webauthnRPID = webauthnRPID;
  }


  public ProjectConfig cname(String cname) {
    this.cname = cname;
    return this;
  }

   /**
   * Get cname
   * @return cname
  **/
  @javax.annotation.Nonnull
  public String getCname() {
    return cname;
  }

  public void setCname(String cname) {
    this.cname = cname;
  }


  public ProjectConfig webComponentDebug(Boolean webComponentDebug) {
    this.webComponentDebug = webComponentDebug;
    return this;
  }

   /**
   * Get webComponentDebug
   * @return webComponentDebug
  **/
  @javax.annotation.Nonnull
  public Boolean getWebComponentDebug() {
    return webComponentDebug;
  }

  public void setWebComponentDebug(Boolean webComponentDebug) {
    this.webComponentDebug = webComponentDebug;
  }


  public ProjectConfig smtpUseCustom(Boolean smtpUseCustom) {
    this.smtpUseCustom = smtpUseCustom;
    return this;
  }

   /**
   * Get smtpUseCustom
   * @return smtpUseCustom
  **/
  @javax.annotation.Nonnull
  public Boolean getSmtpUseCustom() {
    return smtpUseCustom;
  }

  public void setSmtpUseCustom(Boolean smtpUseCustom) {
    this.smtpUseCustom = smtpUseCustom;
  }


  public ProjectConfig smtpHost(String smtpHost) {
    this.smtpHost = smtpHost;
    return this;
  }

   /**
   * Get smtpHost
   * @return smtpHost
  **/
  @javax.annotation.Nonnull
  public String getSmtpHost() {
    return smtpHost;
  }

  public void setSmtpHost(String smtpHost) {
    this.smtpHost = smtpHost;
  }


  public ProjectConfig smtpPort(Integer smtpPort) {
    this.smtpPort = smtpPort;
    return this;
  }

   /**
   * Get smtpPort
   * @return smtpPort
  **/
  @javax.annotation.Nonnull
  public Integer getSmtpPort() {
    return smtpPort;
  }

  public void setSmtpPort(Integer smtpPort) {
    this.smtpPort = smtpPort;
  }


  public ProjectConfig smtpUsername(String smtpUsername) {
    this.smtpUsername = smtpUsername;
    return this;
  }

   /**
   * Get smtpUsername
   * @return smtpUsername
  **/
  @javax.annotation.Nonnull
  public String getSmtpUsername() {
    return smtpUsername;
  }

  public void setSmtpUsername(String smtpUsername) {
    this.smtpUsername = smtpUsername;
  }


  public ProjectConfig smtpPassword(String smtpPassword) {
    this.smtpPassword = smtpPassword;
    return this;
  }

   /**
   * Get smtpPassword
   * @return smtpPassword
  **/
  @javax.annotation.Nonnull
  public String getSmtpPassword() {
    return smtpPassword;
  }

  public void setSmtpPassword(String smtpPassword) {
    this.smtpPassword = smtpPassword;
  }


  public ProjectConfig supportEmail(String supportEmail) {
    this.supportEmail = supportEmail;
    return this;
  }

   /**
   * Get supportEmail
   * @return supportEmail
  **/
  @javax.annotation.Nonnull
  public String getSupportEmail() {
    return supportEmail;
  }

  public void setSupportEmail(String supportEmail) {
    this.supportEmail = supportEmail;
  }


  public ProjectConfig webhookActions(List<String> webhookActions) {
    this.webhookActions = webhookActions;
    return this;
  }

  public ProjectConfig addWebhookActionsItem(String webhookActionsItem) {
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
  @javax.annotation.Nonnull
  public List<String> getWebhookActions() {
    return webhookActions;
  }

  public void setWebhookActions(List<String> webhookActions) {
    this.webhookActions = webhookActions;
  }


  public ProjectConfig signupFlow(SignupFlowEnum signupFlow) {
    this.signupFlow = signupFlow;
    return this;
  }

   /**
   * Get signupFlow
   * @return signupFlow
  **/
  @javax.annotation.Nonnull
  public SignupFlowEnum getSignupFlow() {
    return signupFlow;
  }

  public void setSignupFlow(SignupFlowEnum signupFlow) {
    this.signupFlow = signupFlow;
  }


  public ProjectConfig signupFlowOptions(Object signupFlowOptions) {
    this.signupFlowOptions = signupFlowOptions;
    return this;
  }

   /**
   * Get signupFlowOptions
   * @return signupFlowOptions
  **/
  @javax.annotation.Nonnull
  public Object getSignupFlowOptions() {
    return signupFlowOptions;
  }

  public void setSignupFlowOptions(Object signupFlowOptions) {
    this.signupFlowOptions = signupFlowOptions;
  }


  public ProjectConfig loginFlow(LoginFlowEnum loginFlow) {
    this.loginFlow = loginFlow;
    return this;
  }

   /**
   * Get loginFlow
   * @return loginFlow
  **/
  @javax.annotation.Nonnull
  public LoginFlowEnum getLoginFlow() {
    return loginFlow;
  }

  public void setLoginFlow(LoginFlowEnum loginFlow) {
    this.loginFlow = loginFlow;
  }


  public ProjectConfig loginFlowOptions(Object loginFlowOptions) {
    this.loginFlowOptions = loginFlowOptions;
    return this;
  }

   /**
   * Get loginFlowOptions
   * @return loginFlowOptions
  **/
  @javax.annotation.Nonnull
  public Object getLoginFlowOptions() {
    return loginFlowOptions;
  }

  public void setLoginFlowOptions(Object loginFlowOptions) {
    this.loginFlowOptions = loginFlowOptions;
  }


  public ProjectConfig allowStaticChallenges(Boolean allowStaticChallenges) {
    this.allowStaticChallenges = allowStaticChallenges;
    return this;
  }

   /**
   * Get allowStaticChallenges
   * @return allowStaticChallenges
  **/
  @javax.annotation.Nonnull
  public Boolean getAllowStaticChallenges() {
    return allowStaticChallenges;
  }

  public void setAllowStaticChallenges(Boolean allowStaticChallenges) {
    this.allowStaticChallenges = allowStaticChallenges;
  }


  public ProjectConfig created(String created) {
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


  public ProjectConfig updated(String updated) {
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


  public ProjectConfig status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @javax.annotation.Nonnull
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProjectConfig projectConfig = (ProjectConfig) o;
    return Objects.equals(this.projectID, projectConfig.projectID) &&
        Objects.equals(this.externalName, projectConfig.externalName) &&
        Objects.equals(this.appType, projectConfig.appType) &&
        Objects.equals(this.productKey, projectConfig.productKey) &&
        Objects.equals(this.projectSubscriptionID, projectConfig.projectSubscriptionID) &&
        Objects.equals(this.emailFrom, projectConfig.emailFrom) &&
        Objects.equals(this.smsFrom, projectConfig.smsFrom) &&
        Objects.equals(this.externalApplicationProtocolVersion, projectConfig.externalApplicationProtocolVersion) &&
        Objects.equals(this.webhookURL, projectConfig.webhookURL) &&
        Objects.equals(this.webhookUsername, projectConfig.webhookUsername) &&
        Objects.equals(this.webhookPassword, projectConfig.webhookPassword) &&
        Objects.equals(this.webhookTestInvalidUsername, projectConfig.webhookTestInvalidUsername) &&
        Objects.equals(this.webhookTestValidUsername, projectConfig.webhookTestValidUsername) &&
        Objects.equals(this.webhookTestValidPassword, projectConfig.webhookTestValidPassword) &&
        Objects.equals(this.externalApplicationUsername, projectConfig.externalApplicationUsername) &&
        Objects.equals(this.externalApplicationPassword, projectConfig.externalApplicationPassword) &&
        Objects.equals(this.legacyAuthMethodsUrl, projectConfig.legacyAuthMethodsUrl) &&
        Objects.equals(this.passwordVerifyUrl, projectConfig.passwordVerifyUrl) &&
        Objects.equals(this.authSuccessRedirectUrl, projectConfig.authSuccessRedirectUrl) &&
        Objects.equals(this.passwordResetUrl, projectConfig.passwordResetUrl) &&
        Objects.equals(this.allowUserRegistration, projectConfig.allowUserRegistration) &&
        Objects.equals(this.allowIPStickiness, projectConfig.allowIPStickiness) &&
        Objects.equals(this.passkeyAppendInterval, projectConfig.passkeyAppendInterval) &&
        Objects.equals(this.cliSecret, projectConfig.cliSecret) &&
        Objects.equals(this.fallbackLanguage, projectConfig.fallbackLanguage) &&
        Objects.equals(this.autoDetectLanguage, projectConfig.autoDetectLanguage) &&
        Objects.equals(this.hasExistingUsers, projectConfig.hasExistingUsers) &&
        Objects.equals(this.hasVerifiedSession, projectConfig.hasVerifiedSession) &&
        Objects.equals(this.hasGeneratedSession, projectConfig.hasGeneratedSession) &&
        Objects.equals(this.hasStartedUsingPasskeys, projectConfig.hasStartedUsingPasskeys) &&
        Objects.equals(this.hasStartedUsingSessions, projectConfig.hasStartedUsingSessions) &&
        Objects.equals(this.environment, projectConfig.environment) &&
        Objects.equals(this.frontendFramework, projectConfig.frontendFramework) &&
        Objects.equals(this.backendLanguage, projectConfig.backendLanguage) &&
        Objects.equals(this.backendAPIUrl, projectConfig.backendAPIUrl) &&
        Objects.equals(this.frontendAPIUrl, projectConfig.frontendAPIUrl) &&
        Objects.equals(this.applicationUrl, projectConfig.applicationUrl) &&
        Objects.equals(this.useCli, projectConfig.useCli) &&
        Objects.equals(this.doubleOptIn, projectConfig.doubleOptIn) &&
        Objects.equals(this.userFullNameRequired, projectConfig.userFullNameRequired) &&
        Objects.equals(this.webauthnRPID, projectConfig.webauthnRPID) &&
        Objects.equals(this.cname, projectConfig.cname) &&
        Objects.equals(this.webComponentDebug, projectConfig.webComponentDebug) &&
        Objects.equals(this.smtpUseCustom, projectConfig.smtpUseCustom) &&
        Objects.equals(this.smtpHost, projectConfig.smtpHost) &&
        Objects.equals(this.smtpPort, projectConfig.smtpPort) &&
        Objects.equals(this.smtpUsername, projectConfig.smtpUsername) &&
        Objects.equals(this.smtpPassword, projectConfig.smtpPassword) &&
        Objects.equals(this.supportEmail, projectConfig.supportEmail) &&
        Objects.equals(this.webhookActions, projectConfig.webhookActions) &&
        Objects.equals(this.signupFlow, projectConfig.signupFlow) &&
        Objects.equals(this.signupFlowOptions, projectConfig.signupFlowOptions) &&
        Objects.equals(this.loginFlow, projectConfig.loginFlow) &&
        Objects.equals(this.loginFlowOptions, projectConfig.loginFlowOptions) &&
        Objects.equals(this.allowStaticChallenges, projectConfig.allowStaticChallenges) &&
        Objects.equals(this.created, projectConfig.created) &&
        Objects.equals(this.updated, projectConfig.updated) &&
        Objects.equals(this.status, projectConfig.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(projectID, externalName, appType, productKey, projectSubscriptionID, emailFrom, smsFrom, externalApplicationProtocolVersion, webhookURL, webhookUsername, webhookPassword, webhookTestInvalidUsername, webhookTestValidUsername, webhookTestValidPassword, externalApplicationUsername, externalApplicationPassword, legacyAuthMethodsUrl, passwordVerifyUrl, authSuccessRedirectUrl, passwordResetUrl, allowUserRegistration, allowIPStickiness, passkeyAppendInterval, cliSecret, fallbackLanguage, autoDetectLanguage, hasExistingUsers, hasVerifiedSession, hasGeneratedSession, hasStartedUsingPasskeys, hasStartedUsingSessions, environment, frontendFramework, backendLanguage, backendAPIUrl, frontendAPIUrl, applicationUrl, useCli, doubleOptIn, userFullNameRequired, webauthnRPID, cname, webComponentDebug, smtpUseCustom, smtpHost, smtpPort, smtpUsername, smtpPassword, supportEmail, webhookActions, signupFlow, signupFlowOptions, loginFlow, loginFlowOptions, allowStaticChallenges, created, updated, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProjectConfig {\n");
    sb.append("    projectID: ").append(toIndentedString(projectID)).append("\n");
    sb.append("    externalName: ").append(toIndentedString(externalName)).append("\n");
    sb.append("    appType: ").append(toIndentedString(appType)).append("\n");
    sb.append("    productKey: ").append(toIndentedString(productKey)).append("\n");
    sb.append("    projectSubscriptionID: ").append(toIndentedString(projectSubscriptionID)).append("\n");
    sb.append("    emailFrom: ").append(toIndentedString(emailFrom)).append("\n");
    sb.append("    smsFrom: ").append(toIndentedString(smsFrom)).append("\n");
    sb.append("    externalApplicationProtocolVersion: ").append(toIndentedString(externalApplicationProtocolVersion)).append("\n");
    sb.append("    webhookURL: ").append(toIndentedString(webhookURL)).append("\n");
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
    sb.append("    cliSecret: ").append(toIndentedString(cliSecret)).append("\n");
    sb.append("    fallbackLanguage: ").append(toIndentedString(fallbackLanguage)).append("\n");
    sb.append("    autoDetectLanguage: ").append(toIndentedString(autoDetectLanguage)).append("\n");
    sb.append("    hasExistingUsers: ").append(toIndentedString(hasExistingUsers)).append("\n");
    sb.append("    hasVerifiedSession: ").append(toIndentedString(hasVerifiedSession)).append("\n");
    sb.append("    hasGeneratedSession: ").append(toIndentedString(hasGeneratedSession)).append("\n");
    sb.append("    hasStartedUsingPasskeys: ").append(toIndentedString(hasStartedUsingPasskeys)).append("\n");
    sb.append("    hasStartedUsingSessions: ").append(toIndentedString(hasStartedUsingSessions)).append("\n");
    sb.append("    environment: ").append(toIndentedString(environment)).append("\n");
    sb.append("    frontendFramework: ").append(toIndentedString(frontendFramework)).append("\n");
    sb.append("    backendLanguage: ").append(toIndentedString(backendLanguage)).append("\n");
    sb.append("    backendAPIUrl: ").append(toIndentedString(backendAPIUrl)).append("\n");
    sb.append("    frontendAPIUrl: ").append(toIndentedString(frontendAPIUrl)).append("\n");
    sb.append("    applicationUrl: ").append(toIndentedString(applicationUrl)).append("\n");
    sb.append("    useCli: ").append(toIndentedString(useCli)).append("\n");
    sb.append("    doubleOptIn: ").append(toIndentedString(doubleOptIn)).append("\n");
    sb.append("    userFullNameRequired: ").append(toIndentedString(userFullNameRequired)).append("\n");
    sb.append("    webauthnRPID: ").append(toIndentedString(webauthnRPID)).append("\n");
    sb.append("    cname: ").append(toIndentedString(cname)).append("\n");
    sb.append("    webComponentDebug: ").append(toIndentedString(webComponentDebug)).append("\n");
    sb.append("    smtpUseCustom: ").append(toIndentedString(smtpUseCustom)).append("\n");
    sb.append("    smtpHost: ").append(toIndentedString(smtpHost)).append("\n");
    sb.append("    smtpPort: ").append(toIndentedString(smtpPort)).append("\n");
    sb.append("    smtpUsername: ").append(toIndentedString(smtpUsername)).append("\n");
    sb.append("    smtpPassword: ").append(toIndentedString(smtpPassword)).append("\n");
    sb.append("    supportEmail: ").append(toIndentedString(supportEmail)).append("\n");
    sb.append("    webhookActions: ").append(toIndentedString(webhookActions)).append("\n");
    sb.append("    signupFlow: ").append(toIndentedString(signupFlow)).append("\n");
    sb.append("    signupFlowOptions: ").append(toIndentedString(signupFlowOptions)).append("\n");
    sb.append("    loginFlow: ").append(toIndentedString(loginFlow)).append("\n");
    sb.append("    loginFlowOptions: ").append(toIndentedString(loginFlowOptions)).append("\n");
    sb.append("    allowStaticChallenges: ").append(toIndentedString(allowStaticChallenges)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
    openapiFields.add("projectID");
    openapiFields.add("externalName");
    openapiFields.add("appType");
    openapiFields.add("productKey");
    openapiFields.add("projectSubscriptionID");
    openapiFields.add("emailFrom");
    openapiFields.add("smsFrom");
    openapiFields.add("externalApplicationProtocolVersion");
    openapiFields.add("webhookURL");
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
    openapiFields.add("cliSecret");
    openapiFields.add("fallbackLanguage");
    openapiFields.add("autoDetectLanguage");
    openapiFields.add("hasExistingUsers");
    openapiFields.add("hasVerifiedSession");
    openapiFields.add("hasGeneratedSession");
    openapiFields.add("hasStartedUsingPasskeys");
    openapiFields.add("hasStartedUsingSessions");
    openapiFields.add("environment");
    openapiFields.add("frontendFramework");
    openapiFields.add("backendLanguage");
    openapiFields.add("backendAPIUrl");
    openapiFields.add("frontendAPIUrl");
    openapiFields.add("applicationUrl");
    openapiFields.add("useCli");
    openapiFields.add("doubleOptIn");
    openapiFields.add("userFullNameRequired");
    openapiFields.add("webauthnRPID");
    openapiFields.add("cname");
    openapiFields.add("webComponentDebug");
    openapiFields.add("smtpUseCustom");
    openapiFields.add("smtpHost");
    openapiFields.add("smtpPort");
    openapiFields.add("smtpUsername");
    openapiFields.add("smtpPassword");
    openapiFields.add("supportEmail");
    openapiFields.add("webhookActions");
    openapiFields.add("signupFlow");
    openapiFields.add("signupFlowOptions");
    openapiFields.add("loginFlow");
    openapiFields.add("loginFlowOptions");
    openapiFields.add("allowStaticChallenges");
    openapiFields.add("created");
    openapiFields.add("updated");
    openapiFields.add("status");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("projectID");
    openapiRequiredFields.add("externalName");
    openapiRequiredFields.add("appType");
    openapiRequiredFields.add("productKey");
    openapiRequiredFields.add("projectSubscriptionID");
    openapiRequiredFields.add("emailFrom");
    openapiRequiredFields.add("smsFrom");
    openapiRequiredFields.add("externalApplicationProtocolVersion");
    openapiRequiredFields.add("webhookURL");
    openapiRequiredFields.add("webhookUsername");
    openapiRequiredFields.add("webhookPassword");
    openapiRequiredFields.add("webhookTestInvalidUsername");
    openapiRequiredFields.add("webhookTestValidUsername");
    openapiRequiredFields.add("webhookTestValidPassword");
    openapiRequiredFields.add("externalApplicationUsername");
    openapiRequiredFields.add("externalApplicationPassword");
    openapiRequiredFields.add("legacyAuthMethodsUrl");
    openapiRequiredFields.add("passwordVerifyUrl");
    openapiRequiredFields.add("authSuccessRedirectUrl");
    openapiRequiredFields.add("passwordResetUrl");
    openapiRequiredFields.add("allowUserRegistration");
    openapiRequiredFields.add("allowIPStickiness");
    openapiRequiredFields.add("passkeyAppendInterval");
    openapiRequiredFields.add("cliSecret");
    openapiRequiredFields.add("fallbackLanguage");
    openapiRequiredFields.add("autoDetectLanguage");
    openapiRequiredFields.add("hasExistingUsers");
    openapiRequiredFields.add("hasVerifiedSession");
    openapiRequiredFields.add("hasGeneratedSession");
    openapiRequiredFields.add("hasStartedUsingPasskeys");
    openapiRequiredFields.add("hasStartedUsingSessions");
    openapiRequiredFields.add("environment");
    openapiRequiredFields.add("frontendFramework");
    openapiRequiredFields.add("backendLanguage");
    openapiRequiredFields.add("backendAPIUrl");
    openapiRequiredFields.add("frontendAPIUrl");
    openapiRequiredFields.add("applicationUrl");
    openapiRequiredFields.add("useCli");
    openapiRequiredFields.add("doubleOptIn");
    openapiRequiredFields.add("userFullNameRequired");
    openapiRequiredFields.add("webauthnRPID");
    openapiRequiredFields.add("cname");
    openapiRequiredFields.add("webComponentDebug");
    openapiRequiredFields.add("smtpUseCustom");
    openapiRequiredFields.add("smtpHost");
    openapiRequiredFields.add("smtpPort");
    openapiRequiredFields.add("smtpUsername");
    openapiRequiredFields.add("smtpPassword");
    openapiRequiredFields.add("supportEmail");
    openapiRequiredFields.add("webhookActions");
    openapiRequiredFields.add("signupFlow");
    openapiRequiredFields.add("signupFlowOptions");
    openapiRequiredFields.add("loginFlow");
    openapiRequiredFields.add("loginFlowOptions");
    openapiRequiredFields.add("allowStaticChallenges");
    openapiRequiredFields.add("created");
    openapiRequiredFields.add("updated");
    openapiRequiredFields.add("status");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to ProjectConfig
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ProjectConfig.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ProjectConfig is not found in the empty JSON string", ProjectConfig.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!ProjectConfig.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ProjectConfig` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : ProjectConfig.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("projectID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `projectID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("projectID").toString()));
      }
      if (!jsonObj.get("externalName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `externalName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("externalName").toString()));
      }
      // validate the required field `appType`
      AppType.validateJsonElement(jsonObj.get("appType"));
      if (!jsonObj.get("productKey").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productKey` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productKey").toString()));
      }
      if (!jsonObj.get("projectSubscriptionID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `projectSubscriptionID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("projectSubscriptionID").toString()));
      }
      if (!jsonObj.get("emailFrom").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `emailFrom` to be a primitive type in the JSON string but got `%s`", jsonObj.get("emailFrom").toString()));
      }
      if (!jsonObj.get("smsFrom").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `smsFrom` to be a primitive type in the JSON string but got `%s`", jsonObj.get("smsFrom").toString()));
      }
      if (!jsonObj.get("externalApplicationProtocolVersion").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `externalApplicationProtocolVersion` to be a primitive type in the JSON string but got `%s`", jsonObj.get("externalApplicationProtocolVersion").toString()));
      }
      if (!jsonObj.get("webhookURL").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `webhookURL` to be a primitive type in the JSON string but got `%s`", jsonObj.get("webhookURL").toString()));
      }
      if (!jsonObj.get("webhookUsername").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `webhookUsername` to be a primitive type in the JSON string but got `%s`", jsonObj.get("webhookUsername").toString()));
      }
      if (!jsonObj.get("webhookPassword").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `webhookPassword` to be a primitive type in the JSON string but got `%s`", jsonObj.get("webhookPassword").toString()));
      }
      if (!jsonObj.get("webhookTestInvalidUsername").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `webhookTestInvalidUsername` to be a primitive type in the JSON string but got `%s`", jsonObj.get("webhookTestInvalidUsername").toString()));
      }
      if (!jsonObj.get("webhookTestValidUsername").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `webhookTestValidUsername` to be a primitive type in the JSON string but got `%s`", jsonObj.get("webhookTestValidUsername").toString()));
      }
      if (!jsonObj.get("webhookTestValidPassword").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `webhookTestValidPassword` to be a primitive type in the JSON string but got `%s`", jsonObj.get("webhookTestValidPassword").toString()));
      }
      if (!jsonObj.get("externalApplicationUsername").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `externalApplicationUsername` to be a primitive type in the JSON string but got `%s`", jsonObj.get("externalApplicationUsername").toString()));
      }
      if (!jsonObj.get("externalApplicationPassword").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `externalApplicationPassword` to be a primitive type in the JSON string but got `%s`", jsonObj.get("externalApplicationPassword").toString()));
      }
      if (!jsonObj.get("legacyAuthMethodsUrl").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `legacyAuthMethodsUrl` to be a primitive type in the JSON string but got `%s`", jsonObj.get("legacyAuthMethodsUrl").toString()));
      }
      if (!jsonObj.get("passwordVerifyUrl").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `passwordVerifyUrl` to be a primitive type in the JSON string but got `%s`", jsonObj.get("passwordVerifyUrl").toString()));
      }
      if (!jsonObj.get("authSuccessRedirectUrl").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `authSuccessRedirectUrl` to be a primitive type in the JSON string but got `%s`", jsonObj.get("authSuccessRedirectUrl").toString()));
      }
      if (!jsonObj.get("passwordResetUrl").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `passwordResetUrl` to be a primitive type in the JSON string but got `%s`", jsonObj.get("passwordResetUrl").toString()));
      }
      if (!jsonObj.get("passkeyAppendInterval").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `passkeyAppendInterval` to be a primitive type in the JSON string but got `%s`", jsonObj.get("passkeyAppendInterval").toString()));
      }
      // validate the required field `passkeyAppendInterval`
      PasskeyAppendIntervalEnum.validateJsonElement(jsonObj.get("passkeyAppendInterval"));
      if (!jsonObj.get("cliSecret").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `cliSecret` to be a primitive type in the JSON string but got `%s`", jsonObj.get("cliSecret").toString()));
      }
      if (!jsonObj.get("fallbackLanguage").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `fallbackLanguage` to be a primitive type in the JSON string but got `%s`", jsonObj.get("fallbackLanguage").toString()));
      }
      if (!jsonObj.get("environment").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `environment` to be a primitive type in the JSON string but got `%s`", jsonObj.get("environment").toString()));
      }
      // validate the required field `environment`
      EnvironmentEnum.validateJsonElement(jsonObj.get("environment"));
      if (!jsonObj.get("frontendFramework").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `frontendFramework` to be a primitive type in the JSON string but got `%s`", jsonObj.get("frontendFramework").toString()));
      }
      // validate the required field `frontendFramework`
      FrontendFrameworkEnum.validateJsonElement(jsonObj.get("frontendFramework"));
      if (!jsonObj.get("backendLanguage").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `backendLanguage` to be a primitive type in the JSON string but got `%s`", jsonObj.get("backendLanguage").toString()));
      }
      // validate the required field `backendLanguage`
      BackendLanguageEnum.validateJsonElement(jsonObj.get("backendLanguage"));
      if (!jsonObj.get("backendAPIUrl").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `backendAPIUrl` to be a primitive type in the JSON string but got `%s`", jsonObj.get("backendAPIUrl").toString()));
      }
      if (!jsonObj.get("frontendAPIUrl").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `frontendAPIUrl` to be a primitive type in the JSON string but got `%s`", jsonObj.get("frontendAPIUrl").toString()));
      }
      if (!jsonObj.get("applicationUrl").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `applicationUrl` to be a primitive type in the JSON string but got `%s`", jsonObj.get("applicationUrl").toString()));
      }
      if (!jsonObj.get("webauthnRPID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `webauthnRPID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("webauthnRPID").toString()));
      }
      if (!jsonObj.get("cname").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `cname` to be a primitive type in the JSON string but got `%s`", jsonObj.get("cname").toString()));
      }
      if (!jsonObj.get("smtpHost").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `smtpHost` to be a primitive type in the JSON string but got `%s`", jsonObj.get("smtpHost").toString()));
      }
      if (!jsonObj.get("smtpUsername").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `smtpUsername` to be a primitive type in the JSON string but got `%s`", jsonObj.get("smtpUsername").toString()));
      }
      if (!jsonObj.get("smtpPassword").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `smtpPassword` to be a primitive type in the JSON string but got `%s`", jsonObj.get("smtpPassword").toString()));
      }
      if (!jsonObj.get("supportEmail").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `supportEmail` to be a primitive type in the JSON string but got `%s`", jsonObj.get("supportEmail").toString()));
      }
      // ensure the required json array is present
      if (jsonObj.get("webhookActions") == null) {
        throw new IllegalArgumentException("Expected the field `linkedContent` to be an array in the JSON string but got `null`");
      } else if (!jsonObj.get("webhookActions").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `webhookActions` to be an array in the JSON string but got `%s`", jsonObj.get("webhookActions").toString()));
      }
      if (!jsonObj.get("signupFlow").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `signupFlow` to be a primitive type in the JSON string but got `%s`", jsonObj.get("signupFlow").toString()));
      }
      // validate the required field `signupFlow`
      SignupFlowEnum.validateJsonElement(jsonObj.get("signupFlow"));
      if (!jsonObj.get("loginFlow").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `loginFlow` to be a primitive type in the JSON string but got `%s`", jsonObj.get("loginFlow").toString()));
      }
      // validate the required field `loginFlow`
      LoginFlowEnum.validateJsonElement(jsonObj.get("loginFlow"));
      if (!jsonObj.get("created").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `created` to be a primitive type in the JSON string but got `%s`", jsonObj.get("created").toString()));
      }
      if (!jsonObj.get("updated").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `updated` to be a primitive type in the JSON string but got `%s`", jsonObj.get("updated").toString()));
      }
      if (!jsonObj.get("status").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `status` to be a primitive type in the JSON string but got `%s`", jsonObj.get("status").toString()));
      }
      // validate the required field `status`
      StatusEnum.validateJsonElement(jsonObj.get("status"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ProjectConfig.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ProjectConfig' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ProjectConfig> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ProjectConfig.class));

       return (TypeAdapter<T>) new TypeAdapter<ProjectConfig>() {
           @Override
           public void write(JsonWriter out, ProjectConfig value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ProjectConfig read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of ProjectConfig given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of ProjectConfig
  * @throws IOException if the JSON string is invalid with respect to ProjectConfig
  */
  public static ProjectConfig fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ProjectConfig.class);
  }

 /**
  * Convert an instance of ProjectConfig to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

