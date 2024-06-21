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


package com.corbado.generated.invoker;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.JsonElement;
import io.gsonfire.GsonFireBuilder;
import io.gsonfire.TypeSelector;

import okio.ByteString;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.HashMap;

/*
 * A JSON utility class
 *
 * NOTE: in the future, this class may be converted to static, which may break
 *       backward-compatibility
 */
public class JSON {
    private static Gson gson;
    private static boolean isLenientOnJson = false;
    private static DateTypeAdapter dateTypeAdapter = new DateTypeAdapter();
    private static SqlDateTypeAdapter sqlDateTypeAdapter = new SqlDateTypeAdapter();
    private static OffsetDateTimeTypeAdapter offsetDateTimeTypeAdapter = new OffsetDateTimeTypeAdapter();
    private static LocalDateTypeAdapter localDateTypeAdapter = new LocalDateTypeAdapter();
    private static ByteArrayAdapter byteArrayAdapter = new ByteArrayAdapter();

    @SuppressWarnings("unchecked")
    public static GsonBuilder createGson() {
        GsonFireBuilder fireBuilder = new GsonFireBuilder()
        ;
        GsonBuilder builder = fireBuilder.createGsonBuilder();
        return builder;
    }

    private static String getDiscriminatorValue(JsonElement readElement, String discriminatorField) {
        JsonElement element = readElement.getAsJsonObject().get(discriminatorField);
        if (null == element) {
            throw new IllegalArgumentException("missing discriminator field: <" + discriminatorField + ">");
        }
        return element.getAsString();
    }

    /**
     * Returns the Java class that implements the OpenAPI schema for the specified discriminator value.
     *
     * @param classByDiscriminatorValue The map of discriminator values to Java classes.
     * @param discriminatorValue The value of the OpenAPI discriminator in the input data.
     * @return The Java class that implements the OpenAPI schema
     */
    private static Class getClassByDiscriminator(Map classByDiscriminatorValue, String discriminatorValue) {
        Class clazz = (Class) classByDiscriminatorValue.get(discriminatorValue);
        if (null == clazz) {
            throw new IllegalArgumentException("cannot determine model class of name: <" + discriminatorValue + ">");
        }
        return clazz;
    }

    static {
        GsonBuilder gsonBuilder = createGson();
        gsonBuilder.registerTypeAdapter(Date.class, dateTypeAdapter);
        gsonBuilder.registerTypeAdapter(java.sql.Date.class, sqlDateTypeAdapter);
        gsonBuilder.registerTypeAdapter(OffsetDateTime.class, offsetDateTimeTypeAdapter);
        gsonBuilder.registerTypeAdapter(LocalDate.class, localDateTypeAdapter);
        gsonBuilder.registerTypeAdapter(byte[].class, byteArrayAdapter);
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.AndroidAppConfigDeleteReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.AndroidAppConfigItem.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.AndroidAppConfigListRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.AndroidAppConfigSaveReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.AndroidAppConfigSaveRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.AndroidAppConfigUpdateReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.AndroidAppConfigUpdateRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.AssociationTokenCreateReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.AssociationTokenCreateRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.AssociationTokenCreateRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.AuthMethodsListReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.AuthMethodsListRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.AuthMethodsListRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.AuthTokenValidateReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.AuthTokenValidateRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.ClientInfo.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.CustomLoginIdentifier.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.Email.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.EmailCode.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.EmailCodeGetRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.EmailCodeGetRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.EmailCodeSendReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.EmailCodeSendRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.EmailCodeSendRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.EmailCodeValidateReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.EmailCodeValidateRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.EmailLink.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.EmailLinkGetRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.EmailLinkGetRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.EmailLinkSendReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.EmailLinkSendRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.EmailLinkSendRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.EmailLinkValidateRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.EmailLinksDeleteReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.EmailLinksValidateReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.EmailTemplateCreateReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.EmailTemplateCreateRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.EmailTemplateCreateRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.EmailTemplateDeleteReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.EmailValidationResult.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.EmptyReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.ErrorRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.ErrorRspAllOfError.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.ErrorRspAllOfErrorValidation.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.ExampleGetRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.FullUser.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.GenericRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.IOSAppConfigDeleteReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.IOSAppConfigItem.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.IOSAppConfigListRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.IOSAppConfigSaveReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.IOSAppConfigSaveRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.IOSAppConfigUpdateReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.IOSAppConfigUpdateRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.LongSession.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.LongSessionGetRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.LongSessionGetRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.LongSessionListRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.LongSessionListRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.LongSessionRevokeReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.Paging.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.PhoneNumber.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.PhoneNumberValidationResult.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.ProjectConfig.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.ProjectConfigGetRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.ProjectConfigSaveReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.ProjectConfigWebhookTestReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.ProjectConfigWebhookTestRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.ProjectConfigWebhookTestRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.ProjectSecretCreateReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.ProjectSecretCreateRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.ProjectSecretDeleteReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.ProjectSecretItem.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.ProjectSecretListRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.RequestData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.RequestLog.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.RequestLogGetRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.RequestLogsListRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.RequestLogsListRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.SessionConfig.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.SessionConfigGetRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.SessionConfigUpdateReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.SessionTokenCreateReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.SessionTokenCreateRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.SessionTokenCreateRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.SessionTokenVerifyReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.SessionTokenVerifyRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.SessionTokenVerifyRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.SmsCodeSendReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.SmsCodeSendRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.SmsCodeSendRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.SmsCodeValidateReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.SmsCodeValidateRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.SmsTemplateCreateReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.SmsTemplateCreateRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.SmsTemplateCreateRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.SmsTemplateDeleteReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.TrackingBackupState.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.TrackingBackupStateGetRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.TrackingBrowserDetailedStats.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.TrackingBrowserDetailedStatsListRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.TrackingBrowserDetailedStatsListRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.TrackingBrowserStats.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.TrackingBrowserStatsListRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.TrackingBrowserStatsListRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.TrackingDetailedStats.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.TrackingDetailedStatsListRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.TrackingDetailedStatsListRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.TrackingEnums.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.TrackingEnumsGetRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.TrackingOSDetailedStats.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.TrackingOSDetailedStatsListRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.TrackingOSDetailedStatsListRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.TrackingOSStats.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.TrackingOSStatsListRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.TrackingOSStatsListRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.TrackingRawListRow.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.TrackingRawListRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.TrackingStats.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.TrackingStatsListRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.TrackingStatsListRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.User.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserAuthLog.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserAuthLogListRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserAuthLogListRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserCreateReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserCreateRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserCreateRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserCustomLoginIdentifierCreateReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserCustomLoginIdentifierCreateRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserCustomLoginIdentifierCreateRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserCustomLoginIdentifierDeleteReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserCustomLoginIdentifierGetRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserCustomLoginIdentifierGetRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserDeleteReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserDevice.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserDeviceListRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserEmail.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserEmailCreateReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserEmailCreateRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserEmailCreateRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserEmailDeleteReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserEmailGetRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserEmailGetRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserExistsReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserExistsRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserGetRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserListRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserListRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserPhoneNumber.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserPhoneNumberCreateReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserPhoneNumberCreateRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserPhoneNumberCreateRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserPhoneNumberDeleteReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserPhoneNumberGetRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserPhoneNumberGetRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserSocialAccount.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserStats.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserStatsListRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserStatsListRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserUpdateReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserUpdateRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.UserUsername.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.ValidateEmailReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.ValidateEmailRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.ValidatePhoneNumberReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.ValidatePhoneNumberRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.ValidationEmail.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.ValidationPhoneNumber.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebAuthnAssociateStartReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebAuthnAssociateStartRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebAuthnAuthenticateFinishRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebAuthnAuthenticateStartReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebAuthnAuthenticateStartRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebAuthnAuthenticateSuccess.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebAuthnAuthenticatorUpdateReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebAuthnCredentialExistsReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebAuthnCredentialExistsRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebAuthnCredentialItemRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebAuthnCredentialListRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebAuthnCredentialReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebAuthnCredentialRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebAuthnFinishReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebAuthnMediationStartReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebAuthnMediationStartRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebAuthnRegisterFinishRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebAuthnRegisterStartReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebAuthnRegisterStartRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebauthnSettingCreate.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebauthnSettingCreateReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebauthnSettingCreateRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebauthnSettingDeleteReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebauthnSettingGetRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebauthnSettingItem.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebauthnSettingListRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebauthnSettingUpdateReq.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebauthnSettingUpdateRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebauthnStatsAuthenticator.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebauthnStatsAuthenticatorRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebauthnStatsAuthenticatorRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebauthnStatsType.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebauthnStatsTypeRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebauthnStatsTypeRspAllOfData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebhookLog.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebhookLogsListRsp.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new com.corbado.generated.model.WebhookLogsListRspAllOfData.CustomTypeAdapterFactory());
        gson = gsonBuilder.create();
    }

    /**
     * Get Gson.
     *
     * @return Gson
     */
    public static Gson getGson() {
        return gson;
    }

    /**
     * Set Gson.
     *
     * @param gson Gson
     */
    public static void setGson(Gson gson) {
        JSON.gson = gson;
    }

    public static void setLenientOnJson(boolean lenientOnJson) {
        isLenientOnJson = lenientOnJson;
    }

    /**
     * Serialize the given Java object into JSON string.
     *
     * @param obj Object
     * @return String representation of the JSON
     */
    public static String serialize(Object obj) {
        return gson.toJson(obj);
    }

    /**
     * Deserialize the given JSON string to Java object.
     *
     * @param <T>        Type
     * @param body       The JSON string
     * @param returnType The type to deserialize into
     * @return The deserialized Java object
     */
    @SuppressWarnings("unchecked")
    public static <T> T deserialize(String body, Type returnType) {
        try {
            if (isLenientOnJson) {
                JsonReader jsonReader = new JsonReader(new StringReader(body));
                // see https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/stream/JsonReader.html#setLenient(boolean)
                jsonReader.setLenient(true);
                return gson.fromJson(jsonReader, returnType);
            } else {
                return gson.fromJson(body, returnType);
            }
        } catch (JsonParseException e) {
            // Fallback processing when failed to parse JSON form response body:
            // return the response body string directly for the String return type;
            if (returnType.equals(String.class)) {
                return (T) body;
            } else {
                throw (e);
            }
        }
    }

    /**
     * Gson TypeAdapter for Byte Array type
     */
    public static class ByteArrayAdapter extends TypeAdapter<byte[]> {

        @Override
        public void write(JsonWriter out, byte[] value) throws IOException {
            if (value == null) {
                out.nullValue();
            } else {
                out.value(ByteString.of(value).base64());
            }
        }

        @Override
        public byte[] read(JsonReader in) throws IOException {
            switch (in.peek()) {
                case NULL:
                    in.nextNull();
                    return null;
                default:
                    String bytesAsBase64 = in.nextString();
                    ByteString byteString = ByteString.decodeBase64(bytesAsBase64);
                    return byteString.toByteArray();
            }
        }
    }

    /**
     * Gson TypeAdapter for JSR310 OffsetDateTime type
     */
    public static class OffsetDateTimeTypeAdapter extends TypeAdapter<OffsetDateTime> {

        private DateTimeFormatter formatter;

        public OffsetDateTimeTypeAdapter() {
            this(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        }

        public OffsetDateTimeTypeAdapter(DateTimeFormatter formatter) {
            this.formatter = formatter;
        }

        public void setFormat(DateTimeFormatter dateFormat) {
            this.formatter = dateFormat;
        }

        @Override
        public void write(JsonWriter out, OffsetDateTime date) throws IOException {
            if (date == null) {
                out.nullValue();
            } else {
                out.value(formatter.format(date));
            }
        }

        @Override
        public OffsetDateTime read(JsonReader in) throws IOException {
            switch (in.peek()) {
                case NULL:
                    in.nextNull();
                    return null;
                default:
                    String date = in.nextString();
                    if (date.endsWith("+0000")) {
                        date = date.substring(0, date.length()-5) + "Z";
                    }
                    return OffsetDateTime.parse(date, formatter);
            }
        }
    }

    /**
     * Gson TypeAdapter for JSR310 LocalDate type
     */
    public static class LocalDateTypeAdapter extends TypeAdapter<LocalDate> {

        private DateTimeFormatter formatter;

        public LocalDateTypeAdapter() {
            this(DateTimeFormatter.ISO_LOCAL_DATE);
        }

        public LocalDateTypeAdapter(DateTimeFormatter formatter) {
            this.formatter = formatter;
        }

        public void setFormat(DateTimeFormatter dateFormat) {
            this.formatter = dateFormat;
        }

        @Override
        public void write(JsonWriter out, LocalDate date) throws IOException {
            if (date == null) {
                out.nullValue();
            } else {
                out.value(formatter.format(date));
            }
        }

        @Override
        public LocalDate read(JsonReader in) throws IOException {
            switch (in.peek()) {
                case NULL:
                    in.nextNull();
                    return null;
                default:
                    String date = in.nextString();
                    return LocalDate.parse(date, formatter);
            }
        }
    }

    public static void setOffsetDateTimeFormat(DateTimeFormatter dateFormat) {
        offsetDateTimeTypeAdapter.setFormat(dateFormat);
    }

    public static void setLocalDateFormat(DateTimeFormatter dateFormat) {
        localDateTypeAdapter.setFormat(dateFormat);
    }

    /**
     * Gson TypeAdapter for java.sql.Date type
     * If the dateFormat is null, a simple "yyyy-MM-dd" format will be used
     * (more efficient than SimpleDateFormat).
     */
    public static class SqlDateTypeAdapter extends TypeAdapter<java.sql.Date> {

        private DateFormat dateFormat;

        public SqlDateTypeAdapter() {}

        public SqlDateTypeAdapter(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        public void setFormat(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        @Override
        public void write(JsonWriter out, java.sql.Date date) throws IOException {
            if (date == null) {
                out.nullValue();
            } else {
                String value;
                if (dateFormat != null) {
                    value = dateFormat.format(date);
                } else {
                    value = date.toString();
                }
                out.value(value);
            }
        }

        @Override
        public java.sql.Date read(JsonReader in) throws IOException {
            switch (in.peek()) {
                case NULL:
                    in.nextNull();
                    return null;
                default:
                    String date = in.nextString();
                    try {
                        if (dateFormat != null) {
                            return new java.sql.Date(dateFormat.parse(date).getTime());
                        }
                        return new java.sql.Date(ISO8601Utils.parse(date, new ParsePosition(0)).getTime());
                    } catch (ParseException e) {
                        throw new JsonParseException(e);
                    }
            }
        }
    }

    /**
     * Gson TypeAdapter for java.util.Date type
     * If the dateFormat is null, ISO8601Utils will be used.
     */
    public static class DateTypeAdapter extends TypeAdapter<Date> {

        private DateFormat dateFormat;

        public DateTypeAdapter() {}

        public DateTypeAdapter(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        public void setFormat(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        @Override
        public void write(JsonWriter out, Date date) throws IOException {
            if (date == null) {
                out.nullValue();
            } else {
                String value;
                if (dateFormat != null) {
                    value = dateFormat.format(date);
                } else {
                    value = ISO8601Utils.format(date, true);
                }
                out.value(value);
            }
        }

        @Override
        public Date read(JsonReader in) throws IOException {
            try {
                switch (in.peek()) {
                    case NULL:
                        in.nextNull();
                        return null;
                    default:
                        String date = in.nextString();
                        try {
                            if (dateFormat != null) {
                                return dateFormat.parse(date);
                            }
                            return ISO8601Utils.parse(date, new ParsePosition(0));
                        } catch (ParseException e) {
                            throw new JsonParseException(e);
                        }
                }
            } catch (IllegalArgumentException e) {
                throw new JsonParseException(e);
            }
        }
    }

    public static void setDateFormat(DateFormat dateFormat) {
        dateTypeAdapter.setFormat(dateFormat);
    }

    public static void setSqlDateFormat(DateFormat dateFormat) {
        sqlDateTypeAdapter.setFormat(dateFormat);
    }
}
