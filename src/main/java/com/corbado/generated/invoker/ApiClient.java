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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import com.corbado.generated.invoker.auth.ApiKeyAuth;
import com.corbado.generated.invoker.auth.Authentication;
import com.corbado.generated.invoker.auth.HttpBasicAuth;
import com.corbado.generated.invoker.auth.HttpBearerAuth;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;

/** ApiClient class. */
public class ApiClient {

  private String basePath = "https://backendapi.corbado.io";
  protected List<ServerConfiguration> servers =
      new ArrayList<>(
          Arrays.asList(
              new ServerConfiguration(
                  "https://backendapi.corbado.io", "No description provided", new HashMap<>())));
  protected Integer serverIndex = 0;
  protected Map<String, String> serverVariables = null;
  private boolean debugging = false;
  private final Map<String, String> defaultHeaderMap = new HashMap<>();
  private final Map<String, String> defaultCookieMap = new HashMap<>();
  private String tempFolderPath = null;

  private Map<String, Authentication> authentications;

  private DateFormat dateFormat;
  private DateFormat datetimeFormat;
  private boolean lenientDatetimeFormat;
  private int dateLength;

  private InputStream sslCaCert;
  private boolean verifyingSsl;
  private KeyManager[] keyManagers;

  private OkHttpClient httpClient;
  private JSON json;

  private HttpLoggingInterceptor loggingInterceptor;

  /** Basic constructor for ApiClient */
  public ApiClient() {
    init();
    initHttpClient();

    // Setup authentications (key: authentication name, value: authentication).
    authentications.put("basicAuth", new HttpBasicAuth());
    authentications.put("bearerAuth", new HttpBearerAuth("bearer"));
    authentications.put("projectID", new ApiKeyAuth("header", "X-Corbado-ProjectID"));
    // Prevent the authentications from being modified.
    authentications = Collections.unmodifiableMap(authentications);
  }

  /**
   * Basic constructor with custom OkHttpClient
   *
   * @param client a {@link okhttp3.OkHttpClient} object
   */
  public ApiClient(final OkHttpClient client) {
    init();

    httpClient = client;

    // Setup authentications (key: authentication name, value: authentication).
    authentications.put("basicAuth", new HttpBasicAuth());
    authentications.put("bearerAuth", new HttpBearerAuth("bearer"));
    authentications.put("projectID", new ApiKeyAuth("header", "X-Corbado-ProjectID"));
    // Prevent the authentications from being modified.
    authentications = Collections.unmodifiableMap(authentications);
  }

  /**
   * Add a default cookie.
   *
   * @param key The cookie's key
   * @param value The cookie's value
   * @return ApiClient
   */
  public ApiClient addDefaultCookie(final String key, final String value) {
    defaultCookieMap.put(key, value);
    return this;
  }

  /**
   * Add a default header.
   *
   * @param key The header's key
   * @param value The header's value
   * @return ApiClient
   */
  public ApiClient addDefaultHeader(final String key, final String value) {
    defaultHeaderMap.put(key, value);
    return this;
  }

  /**
   * Add a Content-Disposition Header for the given key and file to the MultipartBody Builder.
   *
   * @param mpBuilder MultipartBody.Builder
   * @param key The key of the Header element
   * @param file The file to add to the Header
   */
  private void addPartToMultiPartBuilder(
      final MultipartBody.Builder mpBuilder, final String key, final File file) {
    final Headers partHeaders =
        Headers.of(
            "Content-Disposition",
            "form-data; name=\"" + key + "\"; filename=\"" + file.getName() + "\"");
    final MediaType mediaType = MediaType.parse(guessContentTypeFromFile(file));
    mpBuilder.addPart(partHeaders, RequestBody.create(file, mediaType));
  }

  /**
   * Add a Content-Disposition Header for the given key and complex object to the MultipartBody
   * Builder.
   *
   * @param mpBuilder MultipartBody.Builder
   * @param key The key of the Header element
   * @param obj The complex object to add to the Header
   */
  private void addPartToMultiPartBuilder(
      final MultipartBody.Builder mpBuilder, final String key, final Object obj) {
    RequestBody requestBody;
    if (obj instanceof String) {
      requestBody = RequestBody.create((String) obj, MediaType.parse("text/plain"));
    } else {
      String content;
      if (obj != null) {
        content = JSON.serialize(obj);
      } else {
        content = null;
      }
      requestBody = RequestBody.create(content, MediaType.parse("application/json"));
    }

    final Headers partHeaders =
        Headers.of("Content-Disposition", "form-data; name=\"" + key + "\"");
    mpBuilder.addPart(partHeaders, requestBody);
  }

  /**
   * Apply SSL related settings to httpClient according to the current values of verifyingSsl and
   * sslCaCert.
   */
  private void applySslSettings() {
    try {
      TrustManager[] trustManagers;
      HostnameVerifier hostnameVerifier;
      if (!verifyingSsl) {
        trustManagers =
            new TrustManager[] {
              new X509TrustManager() {
                @Override
                public void checkClientTrusted(
                    final java.security.cert.X509Certificate[] chain, final String authType)
                    throws CertificateException {}

                @Override
                public void checkServerTrusted(
                    final java.security.cert.X509Certificate[] chain, final String authType)
                    throws CertificateException {}

                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                  return new java.security.cert.X509Certificate[] {};
                }
              }
            };
        hostnameVerifier = (hostname, session) -> true;
      } else {
        final TrustManagerFactory trustManagerFactory =
            TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());

        if (sslCaCert == null) {
          trustManagerFactory.init((KeyStore) null);
        } else {
          final char[] password = null; // Any password will work.
          final CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
          final Collection<? extends Certificate> certificates =
              certificateFactory.generateCertificates(sslCaCert);
          if (certificates.isEmpty()) {
            throw new IllegalArgumentException("expected non-empty set of trusted certificates");
          }
          final KeyStore caKeyStore = newEmptyKeyStore(password);
          int index = 0;
          for (final Certificate certificate : certificates) {
            final String certificateAlias = "ca" + (index++);
            caKeyStore.setCertificateEntry(certificateAlias, certificate);
          }
          trustManagerFactory.init(caKeyStore);
        }
        trustManagers = trustManagerFactory.getTrustManagers();
        hostnameVerifier = OkHostnameVerifier.INSTANCE;
      }

      final SSLContext sslContext = SSLContext.getInstance("TLS");
      sslContext.init(keyManagers, trustManagers, new SecureRandom());
      httpClient =
          httpClient
              .newBuilder()
              .sslSocketFactory(sslContext.getSocketFactory(), (X509TrustManager) trustManagers[0])
              .hostnameVerifier(hostnameVerifier)
              .build();
    } catch (final GeneralSecurityException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Build HTTP call with the given options.
   *
   * @param baseUrl The base URL
   * @param path The sub-path of the HTTP URL
   * @param method The request method, one of "GET", "HEAD", "OPTIONS", "POST", "PUT", "PATCH" and
   *     "DELETE"
   * @param queryParams The query parameters
   * @param collectionQueryParams The collection query parameters
   * @param body The request body object
   * @param headerParams The header parameters
   * @param cookieParams The cookie parameters
   * @param formParams The form parameters
   * @param authNames The authentications to apply
   * @param callback Callback for upload/download progress
   * @return The HTTP call
   * @throws com.corbado.generated.invoker.ApiException If fail to serialize the request body object
   */
  public Call buildCall(
      final String baseUrl,
      final String path,
      final String method,
      final List<Pair> queryParams,
      final List<Pair> collectionQueryParams,
      final Object body,
      final Map<String, String> headerParams,
      final Map<String, String> cookieParams,
      final Map<String, Object> formParams,
      final String[] authNames,
      final ApiCallback callback)
      throws ApiException {
    final Request request =
        buildRequest(
            baseUrl,
            path,
            method,
            queryParams,
            collectionQueryParams,
            body,
            headerParams,
            cookieParams,
            formParams,
            authNames,
            callback);

    return httpClient.newCall(request);
  }

  /**
   * Build an HTTP request with the given options.
   *
   * @param baseUrl The base URL
   * @param path The sub-path of the HTTP URL
   * @param method The request method, one of "GET", "HEAD", "OPTIONS", "POST", "PUT", "PATCH" and
   *     "DELETE"
   * @param queryParams The query parameters
   * @param collectionQueryParams The collection query parameters
   * @param body The request body object
   * @param headerParams The header parameters
   * @param cookieParams The cookie parameters
   * @param formParams The form parameters
   * @param authNames The authentications to apply
   * @param callback Callback for upload/download progress
   * @return The HTTP request
   * @throws com.corbado.generated.invoker.ApiException If fail to serialize the request body object
   */
  public Request buildRequest(
      final String baseUrl,
      final String path,
      final String method,
      final List<Pair> queryParams,
      final List<Pair> collectionQueryParams,
      final Object body,
      final Map<String, String> headerParams,
      final Map<String, String> cookieParams,
      final Map<String, Object> formParams,
      final String[] authNames,
      final ApiCallback callback)
      throws ApiException {
    // aggregate queryParams (non-collection) and collectionQueryParams into allQueryParams
    final List<Pair> allQueryParams = new ArrayList<>(queryParams);
    allQueryParams.addAll(collectionQueryParams);

    final String url = buildUrl(baseUrl, path, queryParams, collectionQueryParams);

    // prepare HTTP request body
    RequestBody reqBody;
    final String contentType = headerParams.get("Content-Type");
    String contentTypePure = contentType;
    if (contentTypePure != null && contentTypePure.contains(";")) {
      contentTypePure = contentType.substring(0, contentType.indexOf(";"));
    }
    if (!HttpMethod.permitsRequestBody(method)) {
      reqBody = null;
    } else if ("application/x-www-form-urlencoded".equals(contentTypePure)) {
      reqBody = buildRequestBodyFormEncoding(formParams);
    } else if ("multipart/form-data".equals(contentTypePure)) {
      reqBody = buildRequestBodyMultipart(formParams);
    } else if (body == null) {
      if ("DELETE".equals(method)) {
        // allow calling DELETE without sending a request body
        reqBody = null;
      } else {
        // use an empty request body (for POST, PUT and PATCH)
        reqBody = RequestBody.create("", contentType == null ? null : MediaType.parse(contentType));
      }
    } else {
      reqBody = serialize(body, contentType);
    }

    // update parameters with authentication settings
    updateParamsForAuth(
        authNames,
        allQueryParams,
        headerParams,
        cookieParams,
        requestBodyToString(reqBody),
        method,
        URI.create(url));

    final Request.Builder reqBuilder = new Request.Builder().url(url);
    processHeaderParams(headerParams, reqBuilder);
    processCookieParams(cookieParams, reqBuilder);

    // Associate callback with request (if not null) so interceptor can
    // access it when creating ProgressResponseBody
    reqBuilder.tag(callback);

    Request request = null;

    if (callback != null && reqBody != null) {
      final ProgressRequestBody progressRequestBody = new ProgressRequestBody(reqBody, callback);
      request = reqBuilder.method(method, progressRequestBody).build();
    } else {
      request = reqBuilder.method(method, reqBody).build();
    }

    return request;
  }

  /**
   * Build a form-encoding request body with the given form parameters.
   *
   * @param formParams Form parameters in the form of Map
   * @return RequestBody
   */
  public RequestBody buildRequestBodyFormEncoding(final Map<String, Object> formParams) {
    final okhttp3.FormBody.Builder formBuilder = new okhttp3.FormBody.Builder();
    for (final Entry<String, Object> param : formParams.entrySet()) {
      formBuilder.add(param.getKey(), parameterToString(param.getValue()));
    }
    return formBuilder.build();
  }

  /**
   * Build a multipart (file uploading) request body with the given form parameters, which could
   * contain text fields and file fields.
   *
   * @param formParams Form parameters in the form of Map
   * @return RequestBody
   */
  public RequestBody buildRequestBodyMultipart(final Map<String, Object> formParams) {
    final MultipartBody.Builder mpBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
    for (final Entry<String, Object> param : formParams.entrySet()) {
      if (param.getValue() instanceof File) {
        final File file = (File) param.getValue();
        addPartToMultiPartBuilder(mpBuilder, param.getKey(), file);
      } else if (param.getValue() instanceof List) {
        final List list = (List) param.getValue();
        for (final Object item : list) {
          if (item instanceof File) {
            addPartToMultiPartBuilder(mpBuilder, param.getKey(), (File) item);
          } else {
            addPartToMultiPartBuilder(mpBuilder, param.getKey(), param.getValue());
          }
        }
      } else {
        addPartToMultiPartBuilder(mpBuilder, param.getKey(), param.getValue());
      }
    }
    return mpBuilder.build();
  }

  /**
   * Build full URL by concatenating base path, the given sub path and query parameters.
   *
   * @param baseUrl The base URL
   * @param path The sub path
   * @param queryParams The query parameters
   * @param collectionQueryParams The collection query parameters
   * @return The full URL
   */
  public String buildUrl(
      final String baseUrl,
      final String path,
      final List<Pair> queryParams,
      final List<Pair> collectionQueryParams) {
    final StringBuilder url = new StringBuilder();
    if (baseUrl != null) {
      url.append(baseUrl).append(path);
    } else {
      String baseURL;
      if (serverIndex != null) {
        if (serverIndex < 0 || serverIndex >= servers.size()) {
          throw new ArrayIndexOutOfBoundsException(
              String.format(
                  "Invalid index %d when selecting the host settings. Must be less than %d",
                  serverIndex, servers.size()));
        }
        baseURL = servers.get(serverIndex).URL(serverVariables);
      } else {
        baseURL = basePath;
      }
      url.append(baseURL).append(path);
    }

    if (queryParams != null && !queryParams.isEmpty()) {
      // support (constant) query string in `path`, e.g. "/posts?draft=1"
      String prefix = path.contains("?") ? "&" : "?";
      for (final Pair param : queryParams) {
        if (param.getValue() != null) {
          if (prefix != null) {
            url.append(prefix);
            prefix = null;
          } else {
            url.append("&");
          }
          final String value = parameterToString(param.getValue());
          url.append(escapeString(param.getName())).append("=").append(escapeString(value));
        }
      }
    }

    if (collectionQueryParams != null && !collectionQueryParams.isEmpty()) {
      String prefix = url.toString().contains("?") ? "&" : "?";
      for (final Pair param : collectionQueryParams) {
        if (param.getValue() != null) {
          if (prefix != null) {
            url.append(prefix);
            prefix = null;
          } else {
            url.append("&");
          }
          final String value = parameterToString(param.getValue());
          // collection query parameter value already escaped as part of parameterToPairs
          url.append(escapeString(param.getName())).append("=").append(value);
        }
      }
    }

    return url.toString();
  }

  /**
   * Formats the specified collection path parameter to a string value.
   *
   * @param collectionFormat The collection format of the parameter.
   * @param value The value of the parameter.
   * @return String representation of the parameter
   */
  public String collectionPathParameterToString(
      final String collectionFormat, final Collection value) {
    // create the value based on the collection format
    if ("multi".equals(collectionFormat)) {
      // not valid for path params
      return parameterToString(value);
    }

    // collectionFormat is assumed to be "csv" by default
    String delimiter = ",";

    if ("ssv".equals(collectionFormat)) {
      delimiter = " ";
    } else if ("tsv".equals(collectionFormat)) {
      delimiter = "\t";
    } else if ("pipes".equals(collectionFormat)) {
      delimiter = "|";
    }

    final StringBuilder sb = new StringBuilder();
    for (final Object item : value) {
      sb.append(delimiter);
      sb.append(parameterToString(item));
    }

    return sb.substring(delimiter.length());
  }

  /**
   * Deserialize response body to Java object, according to the return type and the Content-Type
   * response header.
   *
   * @param <T> Type
   * @param response HTTP response
   * @param returnType The type of the Java object
   * @return The deserialized Java object
   * @throws com.corbado.generated.invoker.ApiException If fail to deserialize response body, i.e.
   *     cannot read response body or the Content-Type of the response is not supported.
   */
  @SuppressWarnings("unchecked")
  public <T> T deserialize(final Response response, final Type returnType) throws ApiException {
    if (response == null || returnType == null) {
      return null;
    }

    if ("byte[]".equals(returnType.toString())) {
      // Handle binary response (byte array).
      try {
        return (T) response.body().bytes();
      } catch (final IOException e) {
        throw new ApiException(e);
      }
    } else if (returnType.equals(File.class)) {
      // Handle file downloading.
      return (T) downloadFileFromResponse(response);
    }

    String respBody;
    try {
      if (response.body() != null) {
        respBody = response.body().string();
      } else {
        respBody = null;
      }
    } catch (final IOException e) {
      throw new ApiException(e);
    }

    if (respBody == null || "".equals(respBody)) {
      return null;
    }

    String contentType = response.headers().get("Content-Type");
    if (contentType == null) {
      // ensuring a default content type
      contentType = "application/json";
    }
    if (isJsonMime(contentType)) {
      return JSON.deserialize(respBody, returnType);
    } else if (returnType.equals(String.class)) {
      // Expecting string, return the raw response body.
      return (T) respBody;
    } else {
      throw new ApiException(
          "Content type \"" + contentType + "\" is not supported for type: " + returnType,
          response.code(),
          response.headers().toMultimap(),
          respBody);
    }
  }

  /**
   * Download file from the given response.
   *
   * @param response An instance of the Response object
   * @throws com.corbado.generated.invoker.ApiException If fail to read file content from response
   *     and write to disk
   * @return Downloaded file
   */
  public File downloadFileFromResponse(final Response response) throws ApiException {
    try {
      final File file = prepareDownloadFile(response);
      final BufferedSink sink = Okio.buffer(Okio.sink(file));
      sink.writeAll(response.body().source());
      sink.close();
      return file;
    } catch (final IOException e) {
      throw new ApiException(e);
    }
  }

  /**
   * Escape the given string to be used as URL query value.
   *
   * @param str String to be escaped
   * @return Escaped string
   */
  public String escapeString(final String str) {
    try {
      return URLEncoder.encode(str, "utf8").replace("+", "%20");
    } catch (final UnsupportedEncodingException e) {
      return str;
    }
  }

  /**
   * {@link #execute(Call, Type)}
   *
   * @param <T> Type
   * @param call An instance of the Call object
   * @return ApiResponse&lt;T&gt;
   * @throws com.corbado.generated.invoker.ApiException If fail to execute the call
   */
  public <T> ApiResponse<T> execute(final Call call) throws ApiException {
    return execute(call, null);
  }

  /**
   * Execute HTTP call and deserialize the HTTP response body into the given return type.
   *
   * @param returnType The return type used to deserialize HTTP response body
   * @param <T> The return type corresponding to (same with) returnType
   * @param call Call
   * @return ApiResponse object containing response status, headers and data, which is a Java object
   *     deserialized from response body and would be null when returnType is null.
   * @throws com.corbado.generated.invoker.ApiException If fail to execute the call
   */
  public <T> ApiResponse<T> execute(final Call call, final Type returnType) throws ApiException {
    try {
      final Response response = call.execute();
      final T data = handleResponse(response, returnType);
      return new ApiResponse<>(response.code(), response.headers().toMultimap(), data);
    } catch (final IOException e) {
      throw new ApiException(e);
    }
  }

  /**
   * {@link #executeAsync(Call, Type, ApiCallback)}
   *
   * @param <T> Type
   * @param call An instance of the Call object
   * @param callback ApiCallback&lt;T&gt;
   */
  public <T> void executeAsync(final Call call, final ApiCallback<T> callback) {
    executeAsync(call, null, callback);
  }

  /**
   * Execute HTTP call asynchronously.
   *
   * @param <T> Type
   * @param call The callback to be executed when the API call finishes
   * @param returnType Return type
   * @param callback ApiCallback
   * @see #execute(Call, Type)
   */
  @SuppressWarnings("unchecked")
  public <T> void executeAsync(
      final Call call, final Type returnType, final ApiCallback<T> callback) {
    call.enqueue(
        new Callback() {
          @Override
          public void onFailure(final Call call, final IOException e) {
            callback.onFailure(new ApiException(e), 0, null);
          }

          @Override
          public void onResponse(final Call call, final Response response) throws IOException {
            T result;
            try {
              result = (T) handleResponse(response, returnType);
            } catch (final ApiException e) {
              callback.onFailure(e, response.code(), response.headers().toMultimap());
              return;
            } catch (final Exception e) {
              callback.onFailure(
                  new ApiException(e), response.code(), response.headers().toMultimap());
              return;
            }
            callback.onSuccess(result, response.code(), response.headers().toMultimap());
          }
        });
  }

  /**
   * Get authentication for the given name.
   *
   * @param authName The authentication name
   * @return The authentication, null if not found
   */
  public Authentication getAuthentication(final String authName) {
    return authentications.get(authName);
  }

  /**
   * Get authentications (key: authentication name, value: authentication).
   *
   * @return Map of authentication objects
   */
  public Map<String, Authentication> getAuthentications() {
    return authentications;
  }

  /**
   * Get base path
   *
   * @return Base path
   */
  public String getBasePath() {
    return basePath;
  }

  /**
   * Get connection timeout (in milliseconds).
   *
   * @return Timeout in milliseconds
   */
  public int getConnectTimeout() {
    return httpClient.connectTimeoutMillis();
  }

  /**
   * Getter for the field <code>dateFormat</code>.
   *
   * @return a {@link java.text.DateFormat} object
   */
  public DateFormat getDateFormat() {
    return dateFormat;
  }

  /**
   * Get HTTP client
   *
   * @return An instance of OkHttpClient
   */
  public OkHttpClient getHttpClient() {
    return httpClient;
  }

  /**
   * Get JSON
   *
   * @return JSON object
   */
  public JSON getJSON() {
    return json;
  }

  /**
   * Getter for the field <code>keyManagers</code>.
   *
   * @return an array of {@link javax.net.ssl.KeyManager} objects
   */
  public KeyManager[] getKeyManagers() {
    return keyManagers;
  }

  /**
   * Get network interceptor to add it to the httpClient to track download progress for async
   * requests.
   */
  private Interceptor getProgressInterceptor() {
    return chain -> {
      final Request request = chain.request();
      final Response originalResponse = chain.proceed(request);
      if (request.tag() instanceof ApiCallback) {
        final ApiCallback callback = (ApiCallback) request.tag();
        return originalResponse
            .newBuilder()
            .body(new ProgressResponseBody(originalResponse.body(), callback))
            .build();
      }
      return originalResponse;
    };
  }

  /**
   * Get read timeout (in milliseconds).
   *
   * @return Timeout in milliseconds
   */
  public int getReadTimeout() {
    return httpClient.readTimeoutMillis();
  }

  public Integer getServerIndex() {
    return serverIndex;
  }

  public List<ServerConfiguration> getServers() {
    return servers;
  }

  public Map<String, String> getServerVariables() {
    return serverVariables;
  }

  /**
   * Get SSL CA cert.
   *
   * @return Input stream to the SSL CA cert
   */
  public InputStream getSslCaCert() {
    return sslCaCert;
  }

  /**
   * The path of temporary folder used to store downloaded files from endpoints with file response.
   * The default value is <code>null</code>, i.e. using the system's default temporary folder.
   *
   * @see <a
   *     href="https://docs.oracle.com/javase/7/docs/api/java/nio/file/Files.html#createTempFile(java.lang.String,%20java.lang.String,%20java.nio.file.attribute.FileAttribute...)">createTempFile</a>
   * @return Temporary folder path
   */
  public String getTempFolderPath() {
    return tempFolderPath;
  }

  /**
   * Get write timeout (in milliseconds).
   *
   * @return Timeout in milliseconds
   */
  public int getWriteTimeout() {
    return httpClient.writeTimeoutMillis();
  }

  /**
   * Guess Content-Type header from the given file (defaults to "application/octet-stream").
   *
   * @param file The given file
   * @return The guessed Content-Type
   */
  public String guessContentTypeFromFile(final File file) {
    final String contentType = URLConnection.guessContentTypeFromName(file.getName());
    if (contentType == null) {
      return "application/octet-stream";
    } else {
      return contentType;
    }
  }

  /**
   * Handle the given response, return the deserialized object when the response is successful.
   *
   * @param <T> Type
   * @param response Response
   * @param returnType Return type
   * @return Type
   * @throws com.corbado.generated.invoker.ApiException If the response has an unsuccessful status
   *     code or fail to deserialize the response body
   */
  public <T> T handleResponse(final Response response, final Type returnType) throws ApiException {
    if (response.isSuccessful()) {
      if (returnType == null || response.code() == 204) {
        // returning null if the returnType is not defined,
        // or the status code is 204 (No Content)
        if (response.body() != null) {
          try {
            response.body().close();
          } catch (final Exception e) {
            throw new ApiException(
                response.message(), e, response.code(), response.headers().toMultimap());
          }
        }
        return null;
      } else {
        return deserialize(response, returnType);
      }
    } else {
      String respBody = null;
      if (response.body() != null) {
        try {
          respBody = response.body().string();
        } catch (final IOException e) {
          throw new ApiException(
              response.message(), e, response.code(), response.headers().toMultimap());
        }
      }
      throw new ApiException(
          response.message(), response.code(), response.headers().toMultimap(), respBody);
    }
  }

  private void init() {
    verifyingSsl = true;

    json = new JSON();

    // Set default User-Agent.
    setUserAgent("OpenAPI-Generator/1.0.0/java");

    authentications = new HashMap<>();
  }

  private void initHttpClient() {
    initHttpClient(Collections.<Interceptor>emptyList());
  }

  private void initHttpClient(final List<Interceptor> interceptors) {
    final OkHttpClient.Builder builder = new OkHttpClient.Builder();
    builder.addNetworkInterceptor(getProgressInterceptor());
    for (final Interceptor interceptor : interceptors) {
      builder.addInterceptor(interceptor);
    }

    httpClient = builder.build();
  }

  /**
   * Check that whether debugging is enabled for this API client.
   *
   * @return True if debugging is enabled, false otherwise.
   */
  public boolean isDebugging() {
    return debugging;
  }

  /**
   * Check if the given MIME is a JSON MIME. JSON MIME examples: application/json application/json;
   * charset=UTF8 APPLICATION/JSON application/vnd.company+json "* / *" is also default to JSON
   *
   * @param mime MIME (Multipurpose Internet Mail Extensions)
   * @return True if the given MIME is JSON, false otherwise.
   */
  public boolean isJsonMime(final String mime) {
    final String jsonMime = "(?i)^(application/json|[^;/ \t]+/[^;/ \t]+[+]json)[ \t]*(;.*)?$";
    return mime != null && (mime.matches(jsonMime) || "*/*".equals(mime));
  }

  /**
   * True if isVerifyingSsl flag is on
   *
   * @return True if isVerifySsl flag is on
   */
  public boolean isVerifyingSsl() {
    return verifyingSsl;
  }

  private KeyStore newEmptyKeyStore(final char[] password) throws GeneralSecurityException {
    try {
      final KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
      keyStore.load(null, password);
      return keyStore;
    } catch (final IOException e) {
      throw new AssertionError(e);
    }
  }

  /**
   * Formats the specified query parameter to a list containing a single {@code Pair} object.
   *
   * <p>Note that {@code value} must not be a collection.
   *
   * @param name The name of the parameter.
   * @param value The value of the parameter.
   * @return A list containing a single {@code Pair} object.
   */
  public List<Pair> parameterToPair(final String name, final Object value) {
    final List<Pair> params = new ArrayList<>();

    // preconditions
    if (name == null || name.isEmpty() || value == null || value instanceof Collection) {
      return params;
    }

    params.add(new Pair(name, parameterToString(value)));
    return params;
  }

  /**
   * Formats the specified collection query parameters to a list of {@code Pair} objects.
   *
   * <p>Note that the values of each of the returned Pair objects are percent-encoded.
   *
   * @param collectionFormat The collection format of the parameter.
   * @param name The name of the parameter.
   * @param value The value of the parameter.
   * @return A list of {@code Pair} objects.
   */
  public List<Pair> parameterToPairs(
      final String collectionFormat, final String name, final Collection value) {
    final List<Pair> params = new ArrayList<>();

    // preconditions
    if (name == null || name.isEmpty() || value == null || value.isEmpty()) {
      return params;
    }

    // create the params based on the collection format
    if ("multi".equals(collectionFormat)) {
      for (final Object item : value) {
        params.add(new Pair(name, escapeString(parameterToString(item))));
      }
      return params;
    }

    // collectionFormat is assumed to be "csv" by default
    String delimiter = ",";

    // escape all delimiters except commas, which are URI reserved
    // characters
    if ("ssv".equals(collectionFormat)) {
      delimiter = escapeString(" ");
    } else if ("tsv".equals(collectionFormat)) {
      delimiter = escapeString("\t");
    } else if ("pipes".equals(collectionFormat)) {
      delimiter = escapeString("|");
    }

    final StringBuilder sb = new StringBuilder();
    for (final Object item : value) {
      sb.append(delimiter);
      sb.append(escapeString(parameterToString(item)));
    }

    params.add(new Pair(name, sb.substring(delimiter.length())));

    return params;
  }

  /**
   * Format the given parameter object into string.
   *
   * @param param Parameter
   * @return String representation of the parameter
   */
  public String parameterToString(final Object param) {
    if (param == null) {
      return "";
    } else if (param instanceof Date
        || param instanceof OffsetDateTime
        || param instanceof LocalDate) {
      // Serialize to json string and remove the " enclosing characters
      final String jsonStr = JSON.serialize(param);
      return jsonStr.substring(1, jsonStr.length() - 1);
    } else if (param instanceof Collection) {
      final StringBuilder b = new StringBuilder();
      for (final Object o : (Collection) param) {
        if (b.length() > 0) {
          b.append(",");
        }
        b.append(o);
      }
      return b.toString();
    } else {
      return String.valueOf(param);
    }
  }

  /**
   * Prepare file for download
   *
   * @param response An instance of the Response object
   * @return Prepared file for the download
   * @throws java.io.IOException If fail to prepare file for download
   */
  public File prepareDownloadFile(final Response response) throws IOException {
    String filename = null;
    final String contentDisposition = response.header("Content-Disposition");
    if (contentDisposition != null && !"".equals(contentDisposition)) {
      // Get filename from the Content-Disposition header.
      final Pattern pattern = Pattern.compile("filename=['\"]?([^'\"\\s]+)['\"]?");
      final Matcher matcher = pattern.matcher(contentDisposition);
      if (matcher.find()) {
        filename = sanitizeFilename(matcher.group(1));
      }
    }

    String prefix = null;
    String suffix = null;
    if (filename == null) {
      prefix = "download-";
      suffix = "";
    } else {
      final int pos = filename.lastIndexOf(".");
      if (pos == -1) {
        prefix = filename + "-";
      } else {
        prefix = filename.substring(0, pos) + "-";
        suffix = filename.substring(pos);
      }
      // Files.createTempFile requires the prefix to be at least three characters long
      if (prefix.length() < 3) {
        prefix = "download-";
      }
    }

    if (tempFolderPath == null) {
      return Files.createTempFile(prefix, suffix).toFile();
    } else {
      return Files.createTempFile(Paths.get(tempFolderPath), prefix, suffix).toFile();
    }
  }

  /**
   * Set cookie parameters to the request builder, including default cookies.
   *
   * @param cookieParams Cookie parameters in the form of Map
   * @param reqBuilder Request.Builder
   */
  public void processCookieParams(
      final Map<String, String> cookieParams, final Request.Builder reqBuilder) {
    for (final Entry<String, String> param : cookieParams.entrySet()) {
      reqBuilder.addHeader("Cookie", String.format("%s=%s", param.getKey(), param.getValue()));
    }
    for (final Entry<String, String> param : defaultCookieMap.entrySet()) {
      if (!cookieParams.containsKey(param.getKey())) {
        reqBuilder.addHeader("Cookie", String.format("%s=%s", param.getKey(), param.getValue()));
      }
    }
  }

  /**
   * Set header parameters to the request builder, including default headers.
   *
   * @param headerParams Header parameters in the form of Map
   * @param reqBuilder Request.Builder
   */
  public void processHeaderParams(
      final Map<String, String> headerParams, final Request.Builder reqBuilder) {
    for (final Entry<String, String> param : headerParams.entrySet()) {
      reqBuilder.header(param.getKey(), parameterToString(param.getValue()));
    }
    for (final Entry<String, String> header : defaultHeaderMap.entrySet()) {
      if (!headerParams.containsKey(header.getKey())) {
        reqBuilder.header(header.getKey(), parameterToString(header.getValue()));
      }
    }
  }

  /**
   * Convert the HTTP request body to a string.
   *
   * @param requestBody The HTTP request object
   * @return The string representation of the HTTP request body
   * @throws com.corbado.generated.invoker.ApiException If fail to serialize the request body object
   *     into a string
   */
  private String requestBodyToString(final RequestBody requestBody) throws ApiException {
    if (requestBody != null) {
      try {
        final Buffer buffer = new Buffer();
        requestBody.writeTo(buffer);
        return buffer.readUtf8();
      } catch (final IOException e) {
        throw new ApiException(e);
      }
    }

    // empty http request body
    return "";
  }

  /**
   * Sanitize filename by removing path. e.g. ../../sun.gif becomes sun.gif
   *
   * @param filename The filename to be sanitized
   * @return The sanitized filename
   */
  public String sanitizeFilename(final String filename) {
    return filename.replaceAll(".*[/\\\\]", "");
  }

  /**
   * Select the Accept header's value from the given accepts array: if JSON exists in the given
   * array, use it; otherwise use all of them (joining into a string)
   *
   * @param accepts The accepts array to select from
   * @return The Accept header to use. If the given array is empty, null will be returned (not to
   *     set the Accept header explicitly).
   */
  public String selectHeaderAccept(final String[] accepts) {
    if (accepts.length == 0) {
      return null;
    }
    for (final String accept : accepts) {
      if (isJsonMime(accept)) {
        return accept;
      }
    }
    return StringUtil.join(accepts, ",");
  }

  /**
   * Select the Content-Type header's value from the given array: if JSON exists in the given array,
   * use it; otherwise use the first one of the array.
   *
   * @param contentTypes The Content-Type array to select from
   * @return The Content-Type header to use. If the given array is empty, returns null. If it
   *     matches "any", JSON will be used.
   */
  public String selectHeaderContentType(final String[] contentTypes) {
    if (contentTypes.length == 0) {
      return null;
    }

    if ("*/*".equals(contentTypes[0])) {
      return "application/json";
    }

    for (final String contentType : contentTypes) {
      if (isJsonMime(contentType)) {
        return contentType;
      }
    }

    return contentTypes[0];
  }

  /**
   * Serialize the given Java object into request body according to the object's class and the
   * request Content-Type.
   *
   * @param obj The Java object
   * @param contentType The request Content-Type
   * @return The serialized request body
   * @throws com.corbado.generated.invoker.ApiException If fail to serialize the given object
   */
  public RequestBody serialize(final Object obj, final String contentType) throws ApiException {
    if (obj instanceof byte[]) {
      // Binary (byte array) body parameter support.
      return RequestBody.create((byte[]) obj, MediaType.parse(contentType));
    } else if (obj instanceof File) {
      // File body parameter support.
      return RequestBody.create((File) obj, MediaType.parse(contentType));
    } else if ("text/plain".equals(contentType) && obj instanceof String) {
      return RequestBody.create((String) obj, MediaType.parse(contentType));
    } else if (isJsonMime(contentType)) {
      String content;
      if (obj != null) {
        content = JSON.serialize(obj);
      } else {
        content = null;
      }
      return RequestBody.create(content, MediaType.parse(contentType));
    } else if (obj instanceof String) {
      return RequestBody.create((String) obj, MediaType.parse(contentType));
    } else {
      throw new ApiException("Content type \"" + contentType + "\" is not supported");
    }
  }

  /**
   * Helper method to set access token for the first OAuth2 authentication.
   *
   * @param accessToken Access token
   */
  public void setAccessToken(final String accessToken) {
    throw new RuntimeException("No OAuth2 authentication configured!");
  }

  /**
   * Helper method to set API key value for the first API key authentication.
   *
   * @param apiKey API key
   */
  public void setApiKey(final String apiKey) {
    for (final Authentication auth : authentications.values()) {
      if (auth instanceof ApiKeyAuth) {
        ((ApiKeyAuth) auth).setApiKey(apiKey);
        return;
      }
    }
    throw new RuntimeException("No API key authentication configured!");
  }

  /**
   * Helper method to set API key prefix for the first API key authentication.
   *
   * @param apiKeyPrefix API key prefix
   */
  public void setApiKeyPrefix(final String apiKeyPrefix) {
    for (final Authentication auth : authentications.values()) {
      if (auth instanceof ApiKeyAuth) {
        ((ApiKeyAuth) auth).setApiKeyPrefix(apiKeyPrefix);
        return;
      }
    }
    throw new RuntimeException("No API key authentication configured!");
  }

  /**
   * Helper method to set credentials for AWSV4 Signature
   *
   * @param accessKey Access Key
   * @param secretKey Secret Key
   * @param region Region
   * @param service Service to access to
   */
  public void setAWS4Configuration(
      final String accessKey, final String secretKey, final String region, final String service) {
    throw new RuntimeException("No AWS4 authentication configured!");
  }

  /**
   * Helper method to set credentials for AWSV4 Signature
   *
   * @param accessKey Access Key
   * @param secretKey Secret Key
   * @param sessionToken Session Token
   * @param region Region
   * @param service Service to access to
   */
  public void setAWS4Configuration(
      final String accessKey,
      final String secretKey,
      final String sessionToken,
      final String region,
      final String service) {
    throw new RuntimeException("No AWS4 authentication configured!");
  }

  /**
   * Set base path
   *
   * @param basePath Base path of the URL (e.g https://backendapi.corbado.io
   * @return An instance of OkHttpClient
   */
  public ApiClient setBasePath(final String basePath) {
    this.basePath = basePath;
    this.serverIndex = null;
    return this;
  }

  /**
   * Helper method to set access token for the first Bearer authentication.
   *
   * @param bearerToken Bearer token
   */
  public void setBearerToken(final String bearerToken) {
    setBearerToken(() -> bearerToken);
  }

  /**
   * Helper method to set the supplier of access tokens for Bearer authentication.
   *
   * @param tokenSupplier The supplier of bearer tokens
   */
  public void setBearerToken(final Supplier<String> tokenSupplier) {
    for (final Authentication auth : authentications.values()) {
      if (auth instanceof HttpBearerAuth) {
        ((HttpBearerAuth) auth).setBearerToken(tokenSupplier);
        return;
      }
    }
    throw new RuntimeException("No Bearer authentication configured!");
  }

  /**
   * Sets the connect timeout (in milliseconds). A value of 0 means no timeout, otherwise values
   * must be between 1 and {@link java.lang.Integer#MAX_VALUE}.
   *
   * @param connectionTimeout connection timeout in milliseconds
   * @return Api client
   */
  public ApiClient setConnectTimeout(final int connectionTimeout) {
    httpClient =
        httpClient.newBuilder().connectTimeout(connectionTimeout, TimeUnit.MILLISECONDS).build();
    return this;
  }

  /**
   * Setter for the field <code>dateFormat</code>.
   *
   * @param dateFormat a {@link java.text.DateFormat} object
   * @return a {@link com.corbado.generated.invoker.ApiClient} object
   */
  public ApiClient setDateFormat(final DateFormat dateFormat) {
    JSON.setDateFormat(dateFormat);
    return this;
  }

  /**
   * Enable/disable debugging for this API client.
   *
   * @param debugging To enable (true) or disable (false) debugging
   * @return ApiClient
   */
  public ApiClient setDebugging(final boolean debugging) {
    if (debugging != this.debugging) {
      if (debugging) {
        loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(Level.BODY);
        httpClient = httpClient.newBuilder().addInterceptor(loggingInterceptor).build();
      } else {
        final OkHttpClient.Builder builder = httpClient.newBuilder();
        builder.interceptors().remove(loggingInterceptor);
        httpClient = builder.build();
        loggingInterceptor = null;
      }
    }
    this.debugging = debugging;
    return this;
  }

  /**
   * Set HTTP client, which must never be null.
   *
   * @param newHttpClient An instance of OkHttpClient
   * @return Api Client
   * @throws java.lang.NullPointerException when newHttpClient is null
   */
  public ApiClient setHttpClient(final OkHttpClient newHttpClient) {
    this.httpClient = Objects.requireNonNull(newHttpClient, "HttpClient must not be null!");
    return this;
  }

  /**
   * Set JSON
   *
   * @param json JSON object
   * @return Api client
   */
  public ApiClient setJSON(final JSON json) {
    this.json = json;
    return this;
  }

  /**
   * Configure client keys to use for authorization in an SSL session. Use null to reset to default.
   *
   * @param managers The KeyManagers to use
   * @return ApiClient
   */
  public ApiClient setKeyManagers(final KeyManager[] managers) {
    this.keyManagers = managers;
    applySslSettings();
    return this;
  }

  /**
   * Set LenientOnJson.
   *
   * @param lenientOnJson a boolean
   * @return a {@link com.corbado.generated.invoker.ApiClient} object
   */
  public ApiClient setLenientOnJson(final boolean lenientOnJson) {
    JSON.setLenientOnJson(lenientOnJson);
    return this;
  }

  /**
   * Set LocalDateFormat.
   *
   * @param dateFormat a {@link java.time.format.DateTimeFormatter} object
   * @return a {@link com.corbado.generated.invoker.ApiClient} object
   */
  public ApiClient setLocalDateFormat(final DateTimeFormatter dateFormat) {
    JSON.setLocalDateFormat(dateFormat);
    return this;
  }

  /**
   * Set OffsetDateTimeFormat.
   *
   * @param dateFormat a {@link java.time.format.DateTimeFormatter} object
   * @return a {@link com.corbado.generated.invoker.ApiClient} object
   */
  public ApiClient setOffsetDateTimeFormat(final DateTimeFormatter dateFormat) {
    JSON.setOffsetDateTimeFormat(dateFormat);
    return this;
  }

  /**
   * Helper method to set password for the first HTTP basic authentication.
   *
   * @param password Password
   */
  public void setPassword(final String password) {
    for (final Authentication auth : authentications.values()) {
      if (auth instanceof HttpBasicAuth) {
        ((HttpBasicAuth) auth).setPassword(password);
        return;
      }
    }
    throw new RuntimeException("No HTTP basic authentication configured!");
  }

  /**
   * Sets the read timeout (in milliseconds). A value of 0 means no timeout, otherwise values must
   * be between 1 and {@link java.lang.Integer#MAX_VALUE}.
   *
   * @param readTimeout read timeout in milliseconds
   * @return Api client
   */
  public ApiClient setReadTimeout(final int readTimeout) {
    httpClient = httpClient.newBuilder().readTimeout(readTimeout, TimeUnit.MILLISECONDS).build();
    return this;
  }

  public ApiClient setServerIndex(final Integer serverIndex) {
    this.serverIndex = serverIndex;
    return this;
  }

  public ApiClient setServers(final List<ServerConfiguration> servers) {
    this.servers = servers;
    return this;
  }

  public ApiClient setServerVariables(final Map<String, String> serverVariables) {
    this.serverVariables = serverVariables;
    return this;
  }

  /**
   * Set SqlDateFormat.
   *
   * @param dateFormat a {@link java.text.DateFormat} object
   * @return a {@link com.corbado.generated.invoker.ApiClient} object
   */
  public ApiClient setSqlDateFormat(final DateFormat dateFormat) {
    JSON.setSqlDateFormat(dateFormat);
    return this;
  }

  /**
   * Configure the CA certificate to be trusted when making https requests. Use null to reset to
   * default.
   *
   * @param sslCaCert input stream for SSL CA cert
   * @return ApiClient
   */
  public ApiClient setSslCaCert(final InputStream sslCaCert) {
    this.sslCaCert = sslCaCert;
    applySslSettings();
    return this;
  }

  /**
   * Set the temporary folder path (for downloading files)
   *
   * @param tempFolderPath Temporary folder path
   * @return ApiClient
   */
  public ApiClient setTempFolderPath(final String tempFolderPath) {
    this.tempFolderPath = tempFolderPath;
    return this;
  }

  /**
   * Set the User-Agent header's value (by adding to the default header map).
   *
   * @param userAgent HTTP request's user agent
   * @return ApiClient
   */
  public ApiClient setUserAgent(final String userAgent) {
    addDefaultHeader("User-Agent", userAgent);
    return this;
  }

  /**
   * Helper method to set username for the first HTTP basic authentication.
   *
   * @param username Username
   */
  public void setUsername(final String username) {
    for (final Authentication auth : authentications.values()) {
      if (auth instanceof HttpBasicAuth) {
        ((HttpBasicAuth) auth).setUsername(username);
        return;
      }
    }
    throw new RuntimeException("No HTTP basic authentication configured!");
  }

  /**
   * Configure whether to verify certificate and hostname when making https requests. Default to
   * true. NOTE: Do NOT set to false in production code, otherwise you would face multiple types of
   * cryptographic attacks.
   *
   * @param verifyingSsl True to verify TLS/SSL connection
   * @return ApiClient
   */
  public ApiClient setVerifyingSsl(final boolean verifyingSsl) {
    this.verifyingSsl = verifyingSsl;
    applySslSettings();
    return this;
  }

  /**
   * Sets the write timeout (in milliseconds). A value of 0 means no timeout, otherwise values must
   * be between 1 and {@link java.lang.Integer#MAX_VALUE}.
   *
   * @param writeTimeout connection timeout in milliseconds
   * @return Api client
   */
  public ApiClient setWriteTimeout(final int writeTimeout) {
    httpClient = httpClient.newBuilder().writeTimeout(writeTimeout, TimeUnit.MILLISECONDS).build();
    return this;
  }

  /**
   * Update query and header parameters based on authentication settings.
   *
   * @param authNames The authentications to apply
   * @param queryParams List of query parameters
   * @param headerParams Map of header parameters
   * @param cookieParams Map of cookie parameters
   * @param payload HTTP request body
   * @param method HTTP method
   * @param uri URI
   * @throws com.corbado.generated.invoker.ApiException If fails to update the parameters
   */
  public void updateParamsForAuth(
      final String[] authNames,
      final List<Pair> queryParams,
      final Map<String, String> headerParams,
      final Map<String, String> cookieParams,
      final String payload,
      final String method,
      final URI uri)
      throws ApiException {
    for (final String authName : authNames) {
      final Authentication auth = authentications.get(authName);
      if (auth == null) {
        throw new RuntimeException("Authentication undefined: " + authName);
      }
      auth.applyToParams(queryParams, headerParams, cookieParams, payload, method, uri);
    }
  }
}
