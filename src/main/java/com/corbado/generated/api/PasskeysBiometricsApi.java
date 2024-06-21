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


package com.corbado.generated.api;

import com.corbado.generated.invoker.ApiCallback;
import com.corbado.generated.invoker.ApiClient;
import com.corbado.generated.invoker.ApiException;
import com.corbado.generated.invoker.ApiResponse;
import com.corbado.generated.invoker.Configuration;
import com.corbado.generated.invoker.Pair;
import com.corbado.generated.invoker.ProgressRequestBody;
import com.corbado.generated.invoker.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.corbado.generated.model.EmptyReq;
import com.corbado.generated.model.ErrorRsp;
import com.corbado.generated.model.GenericRsp;
import com.corbado.generated.model.WebAuthnAssociateStartReq;
import com.corbado.generated.model.WebAuthnAssociateStartRsp;
import com.corbado.generated.model.WebAuthnAuthenticateFinishRsp;
import com.corbado.generated.model.WebAuthnAuthenticateStartReq;
import com.corbado.generated.model.WebAuthnAuthenticateStartRsp;
import com.corbado.generated.model.WebAuthnAuthenticatorUpdateReq;
import com.corbado.generated.model.WebAuthnCredentialExistsReq;
import com.corbado.generated.model.WebAuthnCredentialExistsRsp;
import com.corbado.generated.model.WebAuthnCredentialListRsp;
import com.corbado.generated.model.WebAuthnCredentialReq;
import com.corbado.generated.model.WebAuthnCredentialRsp;
import com.corbado.generated.model.WebAuthnFinishReq;
import com.corbado.generated.model.WebAuthnMediationStartReq;
import com.corbado.generated.model.WebAuthnMediationStartRsp;
import com.corbado.generated.model.WebAuthnRegisterFinishRsp;
import com.corbado.generated.model.WebAuthnRegisterStartReq;
import com.corbado.generated.model.WebAuthnRegisterStartRsp;
import com.corbado.generated.model.WebauthnSettingCreateReq;
import com.corbado.generated.model.WebauthnSettingCreateRsp;
import com.corbado.generated.model.WebauthnSettingDeleteReq;
import com.corbado.generated.model.WebauthnSettingGetRsp;
import com.corbado.generated.model.WebauthnSettingListRsp;
import com.corbado.generated.model.WebauthnSettingUpdateReq;
import com.corbado.generated.model.WebauthnSettingUpdateRsp;
import com.corbado.generated.model.WebauthnStatsAuthenticatorRsp;
import com.corbado.generated.model.WebauthnStatsTypeRsp;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PasskeysBiometricsApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public PasskeysBiometricsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public PasskeysBiometricsApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public int getHostIndex() {
        return localHostIndex;
    }

    public void setHostIndex(int hostIndex) {
        this.localHostIndex = hostIndex;
    }

    public String getCustomBaseUrl() {
        return localCustomBaseUrl;
    }

    public void setCustomBaseUrl(String customBaseUrl) {
        this.localCustomBaseUrl = customBaseUrl;
    }

    /**
     * Build call for webAuthnAssociateStart
     * @param webAuthnAssociateStartReq  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) association started successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnAssociateStartCall(WebAuthnAssociateStartReq webAuthnAssociateStartReq, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = webAuthnAssociateStartReq;

        // create path and map variables
        String localVarPath = "/v1/webauthn/associate/start";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "basicAuth", "projectID" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call webAuthnAssociateStartValidateBeforeCall(WebAuthnAssociateStartReq webAuthnAssociateStartReq, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'webAuthnAssociateStartReq' is set
        if (webAuthnAssociateStartReq == null) {
            throw new ApiException("Missing the required parameter 'webAuthnAssociateStartReq' when calling webAuthnAssociateStart(Async)");
        }

        return webAuthnAssociateStartCall(webAuthnAssociateStartReq, _callback);

    }

    /**
     * 
     * Starts association token flow for Passkeys (Biometrics)
     * @param webAuthnAssociateStartReq  (required)
     * @return WebAuthnAssociateStartRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) association started successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public WebAuthnAssociateStartRsp webAuthnAssociateStart(WebAuthnAssociateStartReq webAuthnAssociateStartReq) throws ApiException {
        ApiResponse<WebAuthnAssociateStartRsp> localVarResp = webAuthnAssociateStartWithHttpInfo(webAuthnAssociateStartReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Starts association token flow for Passkeys (Biometrics)
     * @param webAuthnAssociateStartReq  (required)
     * @return ApiResponse&lt;WebAuthnAssociateStartRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) association started successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<WebAuthnAssociateStartRsp> webAuthnAssociateStartWithHttpInfo(WebAuthnAssociateStartReq webAuthnAssociateStartReq) throws ApiException {
        okhttp3.Call localVarCall = webAuthnAssociateStartValidateBeforeCall(webAuthnAssociateStartReq, null);
        Type localVarReturnType = new TypeToken<WebAuthnAssociateStartRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Starts association token flow for Passkeys (Biometrics)
     * @param webAuthnAssociateStartReq  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) association started successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnAssociateStartAsync(WebAuthnAssociateStartReq webAuthnAssociateStartReq, final ApiCallback<WebAuthnAssociateStartRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = webAuthnAssociateStartValidateBeforeCall(webAuthnAssociateStartReq, _callback);
        Type localVarReturnType = new TypeToken<WebAuthnAssociateStartRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for webAuthnAuthenticateFinish
     * @param webAuthnFinishReq  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) authentication finished successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnAuthenticateFinishCall(WebAuthnFinishReq webAuthnFinishReq, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = webAuthnFinishReq;

        // create path and map variables
        String localVarPath = "/v1/webauthn/authenticate/finish";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "basicAuth", "projectID" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call webAuthnAuthenticateFinishValidateBeforeCall(WebAuthnFinishReq webAuthnFinishReq, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'webAuthnFinishReq' is set
        if (webAuthnFinishReq == null) {
            throw new ApiException("Missing the required parameter 'webAuthnFinishReq' when calling webAuthnAuthenticateFinish(Async)");
        }

        return webAuthnAuthenticateFinishCall(webAuthnFinishReq, _callback);

    }

    /**
     * 
     * Completes authentication of a user for Passkeys (Biometrics)
     * @param webAuthnFinishReq  (required)
     * @return WebAuthnAuthenticateFinishRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) authentication finished successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public WebAuthnAuthenticateFinishRsp webAuthnAuthenticateFinish(WebAuthnFinishReq webAuthnFinishReq) throws ApiException {
        ApiResponse<WebAuthnAuthenticateFinishRsp> localVarResp = webAuthnAuthenticateFinishWithHttpInfo(webAuthnFinishReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Completes authentication of a user for Passkeys (Biometrics)
     * @param webAuthnFinishReq  (required)
     * @return ApiResponse&lt;WebAuthnAuthenticateFinishRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) authentication finished successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<WebAuthnAuthenticateFinishRsp> webAuthnAuthenticateFinishWithHttpInfo(WebAuthnFinishReq webAuthnFinishReq) throws ApiException {
        okhttp3.Call localVarCall = webAuthnAuthenticateFinishValidateBeforeCall(webAuthnFinishReq, null);
        Type localVarReturnType = new TypeToken<WebAuthnAuthenticateFinishRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Completes authentication of a user for Passkeys (Biometrics)
     * @param webAuthnFinishReq  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) authentication finished successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnAuthenticateFinishAsync(WebAuthnFinishReq webAuthnFinishReq, final ApiCallback<WebAuthnAuthenticateFinishRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = webAuthnAuthenticateFinishValidateBeforeCall(webAuthnFinishReq, _callback);
        Type localVarReturnType = new TypeToken<WebAuthnAuthenticateFinishRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for webAuthnAuthenticateStart
     * @param webAuthnAuthenticateStartReq  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) authentication started successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnAuthenticateStartCall(WebAuthnAuthenticateStartReq webAuthnAuthenticateStartReq, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = webAuthnAuthenticateStartReq;

        // create path and map variables
        String localVarPath = "/v1/webauthn/authenticate/start";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "basicAuth", "projectID" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call webAuthnAuthenticateStartValidateBeforeCall(WebAuthnAuthenticateStartReq webAuthnAuthenticateStartReq, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'webAuthnAuthenticateStartReq' is set
        if (webAuthnAuthenticateStartReq == null) {
            throw new ApiException("Missing the required parameter 'webAuthnAuthenticateStartReq' when calling webAuthnAuthenticateStart(Async)");
        }

        return webAuthnAuthenticateStartCall(webAuthnAuthenticateStartReq, _callback);

    }

    /**
     * 
     * Starts authentication of a user for Passkeys (Biometrics)
     * @param webAuthnAuthenticateStartReq  (required)
     * @return WebAuthnAuthenticateStartRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) authentication started successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public WebAuthnAuthenticateStartRsp webAuthnAuthenticateStart(WebAuthnAuthenticateStartReq webAuthnAuthenticateStartReq) throws ApiException {
        ApiResponse<WebAuthnAuthenticateStartRsp> localVarResp = webAuthnAuthenticateStartWithHttpInfo(webAuthnAuthenticateStartReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Starts authentication of a user for Passkeys (Biometrics)
     * @param webAuthnAuthenticateStartReq  (required)
     * @return ApiResponse&lt;WebAuthnAuthenticateStartRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) authentication started successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<WebAuthnAuthenticateStartRsp> webAuthnAuthenticateStartWithHttpInfo(WebAuthnAuthenticateStartReq webAuthnAuthenticateStartReq) throws ApiException {
        okhttp3.Call localVarCall = webAuthnAuthenticateStartValidateBeforeCall(webAuthnAuthenticateStartReq, null);
        Type localVarReturnType = new TypeToken<WebAuthnAuthenticateStartRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Starts authentication of a user for Passkeys (Biometrics)
     * @param webAuthnAuthenticateStartReq  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) authentication started successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnAuthenticateStartAsync(WebAuthnAuthenticateStartReq webAuthnAuthenticateStartReq, final ApiCallback<WebAuthnAuthenticateStartRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = webAuthnAuthenticateStartValidateBeforeCall(webAuthnAuthenticateStartReq, _callback);
        Type localVarReturnType = new TypeToken<WebAuthnAuthenticateStartRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for webAuthnAuthenticatorUpdate
     * @param authenticatorID ID of authenticator (required)
     * @param webAuthnAuthenticatorUpdateReq  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Operation succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnAuthenticatorUpdateCall(String authenticatorID, WebAuthnAuthenticatorUpdateReq webAuthnAuthenticatorUpdateReq, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = webAuthnAuthenticatorUpdateReq;

        // create path and map variables
        String localVarPath = "/v1/webauthn/authenticator/{authenticatorID}"
            .replace("{" + "authenticatorID" + "}", localVarApiClient.escapeString(authenticatorID.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "basicAuth", "projectID" };
        return localVarApiClient.buildCall(basePath, localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call webAuthnAuthenticatorUpdateValidateBeforeCall(String authenticatorID, WebAuthnAuthenticatorUpdateReq webAuthnAuthenticatorUpdateReq, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'authenticatorID' is set
        if (authenticatorID == null) {
            throw new ApiException("Missing the required parameter 'authenticatorID' when calling webAuthnAuthenticatorUpdate(Async)");
        }

        // verify the required parameter 'webAuthnAuthenticatorUpdateReq' is set
        if (webAuthnAuthenticatorUpdateReq == null) {
            throw new ApiException("Missing the required parameter 'webAuthnAuthenticatorUpdateReq' when calling webAuthnAuthenticatorUpdate(Async)");
        }

        return webAuthnAuthenticatorUpdateCall(authenticatorID, webAuthnAuthenticatorUpdateReq, _callback);

    }

    /**
     * 
     * Update authenticator
     * @param authenticatorID ID of authenticator (required)
     * @param webAuthnAuthenticatorUpdateReq  (required)
     * @return GenericRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Operation succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public GenericRsp webAuthnAuthenticatorUpdate(String authenticatorID, WebAuthnAuthenticatorUpdateReq webAuthnAuthenticatorUpdateReq) throws ApiException {
        ApiResponse<GenericRsp> localVarResp = webAuthnAuthenticatorUpdateWithHttpInfo(authenticatorID, webAuthnAuthenticatorUpdateReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Update authenticator
     * @param authenticatorID ID of authenticator (required)
     * @param webAuthnAuthenticatorUpdateReq  (required)
     * @return ApiResponse&lt;GenericRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Operation succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<GenericRsp> webAuthnAuthenticatorUpdateWithHttpInfo(String authenticatorID, WebAuthnAuthenticatorUpdateReq webAuthnAuthenticatorUpdateReq) throws ApiException {
        okhttp3.Call localVarCall = webAuthnAuthenticatorUpdateValidateBeforeCall(authenticatorID, webAuthnAuthenticatorUpdateReq, null);
        Type localVarReturnType = new TypeToken<GenericRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Update authenticator
     * @param authenticatorID ID of authenticator (required)
     * @param webAuthnAuthenticatorUpdateReq  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Operation succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnAuthenticatorUpdateAsync(String authenticatorID, WebAuthnAuthenticatorUpdateReq webAuthnAuthenticatorUpdateReq, final ApiCallback<GenericRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = webAuthnAuthenticatorUpdateValidateBeforeCall(authenticatorID, webAuthnAuthenticatorUpdateReq, _callback);
        Type localVarReturnType = new TypeToken<GenericRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for webAuthnCredentialDelete
     * @param userID ID of user (required)
     * @param credentialID ID of credential (required)
     * @param emptyReq  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Operation succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnCredentialDeleteCall(String userID, String credentialID, EmptyReq emptyReq, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = emptyReq;

        // create path and map variables
        String localVarPath = "/v1/users/{userID}/credentials/{credentialID}"
            .replace("{" + "userID" + "}", localVarApiClient.escapeString(userID.toString()))
            .replace("{" + "credentialID" + "}", localVarApiClient.escapeString(credentialID.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "basicAuth", "projectID" };
        return localVarApiClient.buildCall(basePath, localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call webAuthnCredentialDeleteValidateBeforeCall(String userID, String credentialID, EmptyReq emptyReq, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'userID' is set
        if (userID == null) {
            throw new ApiException("Missing the required parameter 'userID' when calling webAuthnCredentialDelete(Async)");
        }

        // verify the required parameter 'credentialID' is set
        if (credentialID == null) {
            throw new ApiException("Missing the required parameter 'credentialID' when calling webAuthnCredentialDelete(Async)");
        }

        // verify the required parameter 'emptyReq' is set
        if (emptyReq == null) {
            throw new ApiException("Missing the required parameter 'emptyReq' when calling webAuthnCredentialDelete(Async)");
        }

        return webAuthnCredentialDeleteCall(userID, credentialID, emptyReq, _callback);

    }

    /**
     * 
     * Delete credential
     * @param userID ID of user (required)
     * @param credentialID ID of credential (required)
     * @param emptyReq  (required)
     * @return GenericRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Operation succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public GenericRsp webAuthnCredentialDelete(String userID, String credentialID, EmptyReq emptyReq) throws ApiException {
        ApiResponse<GenericRsp> localVarResp = webAuthnCredentialDeleteWithHttpInfo(userID, credentialID, emptyReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Delete credential
     * @param userID ID of user (required)
     * @param credentialID ID of credential (required)
     * @param emptyReq  (required)
     * @return ApiResponse&lt;GenericRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Operation succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<GenericRsp> webAuthnCredentialDeleteWithHttpInfo(String userID, String credentialID, EmptyReq emptyReq) throws ApiException {
        okhttp3.Call localVarCall = webAuthnCredentialDeleteValidateBeforeCall(userID, credentialID, emptyReq, null);
        Type localVarReturnType = new TypeToken<GenericRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Delete credential
     * @param userID ID of user (required)
     * @param credentialID ID of credential (required)
     * @param emptyReq  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Operation succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnCredentialDeleteAsync(String userID, String credentialID, EmptyReq emptyReq, final ApiCallback<GenericRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = webAuthnCredentialDeleteValidateBeforeCall(userID, credentialID, emptyReq, _callback);
        Type localVarReturnType = new TypeToken<GenericRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for webAuthnCredentialExists
     * @param webAuthnCredentialExistsReq  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) credentials check completed </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnCredentialExistsCall(WebAuthnCredentialExistsReq webAuthnCredentialExistsReq, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = webAuthnCredentialExistsReq;

        // create path and map variables
        String localVarPath = "/v1/webauthn/credential/exists";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "basicAuth", "projectID" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call webAuthnCredentialExistsValidateBeforeCall(WebAuthnCredentialExistsReq webAuthnCredentialExistsReq, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'webAuthnCredentialExistsReq' is set
        if (webAuthnCredentialExistsReq == null) {
            throw new ApiException("Missing the required parameter 'webAuthnCredentialExistsReq' when calling webAuthnCredentialExists(Async)");
        }

        return webAuthnCredentialExistsCall(webAuthnCredentialExistsReq, _callback);

    }

    /**
     * 
     * Checks if active webauthn credential exists for provided user and device
     * @param webAuthnCredentialExistsReq  (required)
     * @return WebAuthnCredentialExistsRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) credentials check completed </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public WebAuthnCredentialExistsRsp webAuthnCredentialExists(WebAuthnCredentialExistsReq webAuthnCredentialExistsReq) throws ApiException {
        ApiResponse<WebAuthnCredentialExistsRsp> localVarResp = webAuthnCredentialExistsWithHttpInfo(webAuthnCredentialExistsReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Checks if active webauthn credential exists for provided user and device
     * @param webAuthnCredentialExistsReq  (required)
     * @return ApiResponse&lt;WebAuthnCredentialExistsRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) credentials check completed </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<WebAuthnCredentialExistsRsp> webAuthnCredentialExistsWithHttpInfo(WebAuthnCredentialExistsReq webAuthnCredentialExistsReq) throws ApiException {
        okhttp3.Call localVarCall = webAuthnCredentialExistsValidateBeforeCall(webAuthnCredentialExistsReq, null);
        Type localVarReturnType = new TypeToken<WebAuthnCredentialExistsRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Checks if active webauthn credential exists for provided user and device
     * @param webAuthnCredentialExistsReq  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) credentials check completed </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnCredentialExistsAsync(WebAuthnCredentialExistsReq webAuthnCredentialExistsReq, final ApiCallback<WebAuthnCredentialExistsRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = webAuthnCredentialExistsValidateBeforeCall(webAuthnCredentialExistsReq, _callback);
        Type localVarReturnType = new TypeToken<WebAuthnCredentialExistsRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for webAuthnCredentialList
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Webauthn credential list successfully retrieved </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnCredentialListCall(String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/webauthn/credential";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (remoteAddress != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("remoteAddress", remoteAddress));
        }

        if (userAgent != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("userAgent", userAgent));
        }

        if (sort != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("sort", sort));
        }

        if (filter != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("multi", "filter[]", filter));
        }

        if (page != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page", page));
        }

        if (pageSize != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("pageSize", pageSize));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "basicAuth", "projectID", "bearerAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call webAuthnCredentialListValidateBeforeCall(String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
        return webAuthnCredentialListCall(remoteAddress, userAgent, sort, filter, page, pageSize, _callback);

    }

    /**
     * 
     * Lists webauthn credentials users
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return WebAuthnCredentialListRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Webauthn credential list successfully retrieved </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public WebAuthnCredentialListRsp webAuthnCredentialList(String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<WebAuthnCredentialListRsp> localVarResp = webAuthnCredentialListWithHttpInfo(remoteAddress, userAgent, sort, filter, page, pageSize);
        return localVarResp.getData();
    }

    /**
     * 
     * Lists webauthn credentials users
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return ApiResponse&lt;WebAuthnCredentialListRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Webauthn credential list successfully retrieved </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<WebAuthnCredentialListRsp> webAuthnCredentialListWithHttpInfo(String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        okhttp3.Call localVarCall = webAuthnCredentialListValidateBeforeCall(remoteAddress, userAgent, sort, filter, page, pageSize, null);
        Type localVarReturnType = new TypeToken<WebAuthnCredentialListRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Lists webauthn credentials users
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Webauthn credential list successfully retrieved </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnCredentialListAsync(String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback<WebAuthnCredentialListRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = webAuthnCredentialListValidateBeforeCall(remoteAddress, userAgent, sort, filter, page, pageSize, _callback);
        Type localVarReturnType = new TypeToken<WebAuthnCredentialListRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for webAuthnCredentialUpdate
     * @param credentialID ID of credential (required)
     * @param webAuthnCredentialReq  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) authentication started successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnCredentialUpdateCall(String credentialID, WebAuthnCredentialReq webAuthnCredentialReq, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = webAuthnCredentialReq;

        // create path and map variables
        String localVarPath = "/v1/webauthn/credential/{credentialID}"
            .replace("{" + "credentialID" + "}", localVarApiClient.escapeString(credentialID.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "basicAuth", "projectID" };
        return localVarApiClient.buildCall(basePath, localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call webAuthnCredentialUpdateValidateBeforeCall(String credentialID, WebAuthnCredentialReq webAuthnCredentialReq, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'credentialID' is set
        if (credentialID == null) {
            throw new ApiException("Missing the required parameter 'credentialID' when calling webAuthnCredentialUpdate(Async)");
        }

        // verify the required parameter 'webAuthnCredentialReq' is set
        if (webAuthnCredentialReq == null) {
            throw new ApiException("Missing the required parameter 'webAuthnCredentialReq' when calling webAuthnCredentialUpdate(Async)");
        }

        return webAuthnCredentialUpdateCall(credentialID, webAuthnCredentialReq, _callback);

    }

    /**
     * 
     * Update credential
     * @param credentialID ID of credential (required)
     * @param webAuthnCredentialReq  (required)
     * @return WebAuthnCredentialRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) authentication started successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public WebAuthnCredentialRsp webAuthnCredentialUpdate(String credentialID, WebAuthnCredentialReq webAuthnCredentialReq) throws ApiException {
        ApiResponse<WebAuthnCredentialRsp> localVarResp = webAuthnCredentialUpdateWithHttpInfo(credentialID, webAuthnCredentialReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Update credential
     * @param credentialID ID of credential (required)
     * @param webAuthnCredentialReq  (required)
     * @return ApiResponse&lt;WebAuthnCredentialRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) authentication started successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<WebAuthnCredentialRsp> webAuthnCredentialUpdateWithHttpInfo(String credentialID, WebAuthnCredentialReq webAuthnCredentialReq) throws ApiException {
        okhttp3.Call localVarCall = webAuthnCredentialUpdateValidateBeforeCall(credentialID, webAuthnCredentialReq, null);
        Type localVarReturnType = new TypeToken<WebAuthnCredentialRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Update credential
     * @param credentialID ID of credential (required)
     * @param webAuthnCredentialReq  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) authentication started successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnCredentialUpdateAsync(String credentialID, WebAuthnCredentialReq webAuthnCredentialReq, final ApiCallback<WebAuthnCredentialRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = webAuthnCredentialUpdateValidateBeforeCall(credentialID, webAuthnCredentialReq, _callback);
        Type localVarReturnType = new TypeToken<WebAuthnCredentialRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for webAuthnMediationStart
     * @param webAuthnMediationStartReq  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) mediation started successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnMediationStartCall(WebAuthnMediationStartReq webAuthnMediationStartReq, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = webAuthnMediationStartReq;

        // create path and map variables
        String localVarPath = "/v1/webauthn/mediation/start";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "basicAuth", "projectID" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call webAuthnMediationStartValidateBeforeCall(WebAuthnMediationStartReq webAuthnMediationStartReq, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'webAuthnMediationStartReq' is set
        if (webAuthnMediationStartReq == null) {
            throw new ApiException("Missing the required parameter 'webAuthnMediationStartReq' when calling webAuthnMediationStart(Async)");
        }

        return webAuthnMediationStartCall(webAuthnMediationStartReq, _callback);

    }

    /**
     * 
     * Starts mediation for Passkeys (Biometrics)
     * @param webAuthnMediationStartReq  (required)
     * @return WebAuthnMediationStartRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) mediation started successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public WebAuthnMediationStartRsp webAuthnMediationStart(WebAuthnMediationStartReq webAuthnMediationStartReq) throws ApiException {
        ApiResponse<WebAuthnMediationStartRsp> localVarResp = webAuthnMediationStartWithHttpInfo(webAuthnMediationStartReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Starts mediation for Passkeys (Biometrics)
     * @param webAuthnMediationStartReq  (required)
     * @return ApiResponse&lt;WebAuthnMediationStartRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) mediation started successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<WebAuthnMediationStartRsp> webAuthnMediationStartWithHttpInfo(WebAuthnMediationStartReq webAuthnMediationStartReq) throws ApiException {
        okhttp3.Call localVarCall = webAuthnMediationStartValidateBeforeCall(webAuthnMediationStartReq, null);
        Type localVarReturnType = new TypeToken<WebAuthnMediationStartRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Starts mediation for Passkeys (Biometrics)
     * @param webAuthnMediationStartReq  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) mediation started successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnMediationStartAsync(WebAuthnMediationStartReq webAuthnMediationStartReq, final ApiCallback<WebAuthnMediationStartRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = webAuthnMediationStartValidateBeforeCall(webAuthnMediationStartReq, _callback);
        Type localVarReturnType = new TypeToken<WebAuthnMediationStartRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for webAuthnRegisterFinish
     * @param webAuthnFinishReq  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) authentication finished successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnRegisterFinishCall(WebAuthnFinishReq webAuthnFinishReq, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = webAuthnFinishReq;

        // create path and map variables
        String localVarPath = "/v1/webauthn/register/finish";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "basicAuth", "projectID" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call webAuthnRegisterFinishValidateBeforeCall(WebAuthnFinishReq webAuthnFinishReq, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'webAuthnFinishReq' is set
        if (webAuthnFinishReq == null) {
            throw new ApiException("Missing the required parameter 'webAuthnFinishReq' when calling webAuthnRegisterFinish(Async)");
        }

        return webAuthnRegisterFinishCall(webAuthnFinishReq, _callback);

    }

    /**
     * 
     * Completes registration of a user for Passkeys (Biometrics)
     * @param webAuthnFinishReq  (required)
     * @return WebAuthnRegisterFinishRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) authentication finished successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public WebAuthnRegisterFinishRsp webAuthnRegisterFinish(WebAuthnFinishReq webAuthnFinishReq) throws ApiException {
        ApiResponse<WebAuthnRegisterFinishRsp> localVarResp = webAuthnRegisterFinishWithHttpInfo(webAuthnFinishReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Completes registration of a user for Passkeys (Biometrics)
     * @param webAuthnFinishReq  (required)
     * @return ApiResponse&lt;WebAuthnRegisterFinishRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) authentication finished successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<WebAuthnRegisterFinishRsp> webAuthnRegisterFinishWithHttpInfo(WebAuthnFinishReq webAuthnFinishReq) throws ApiException {
        okhttp3.Call localVarCall = webAuthnRegisterFinishValidateBeforeCall(webAuthnFinishReq, null);
        Type localVarReturnType = new TypeToken<WebAuthnRegisterFinishRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Completes registration of a user for Passkeys (Biometrics)
     * @param webAuthnFinishReq  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) authentication finished successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnRegisterFinishAsync(WebAuthnFinishReq webAuthnFinishReq, final ApiCallback<WebAuthnRegisterFinishRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = webAuthnRegisterFinishValidateBeforeCall(webAuthnFinishReq, _callback);
        Type localVarReturnType = new TypeToken<WebAuthnRegisterFinishRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for webAuthnRegisterStart
     * @param webAuthnRegisterStartReq  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) registration initiated successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnRegisterStartCall(WebAuthnRegisterStartReq webAuthnRegisterStartReq, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = webAuthnRegisterStartReq;

        // create path and map variables
        String localVarPath = "/v1/webauthn/register/start";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "basicAuth", "projectID" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call webAuthnRegisterStartValidateBeforeCall(WebAuthnRegisterStartReq webAuthnRegisterStartReq, final ApiCallback _callback) throws ApiException {
        return webAuthnRegisterStartCall(webAuthnRegisterStartReq, _callback);

    }

    /**
     * 
     * Starts registration of a user for Passkeys (Biometrics)
     * @param webAuthnRegisterStartReq  (optional)
     * @return WebAuthnRegisterStartRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) registration initiated successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public WebAuthnRegisterStartRsp webAuthnRegisterStart(WebAuthnRegisterStartReq webAuthnRegisterStartReq) throws ApiException {
        ApiResponse<WebAuthnRegisterStartRsp> localVarResp = webAuthnRegisterStartWithHttpInfo(webAuthnRegisterStartReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Starts registration of a user for Passkeys (Biometrics)
     * @param webAuthnRegisterStartReq  (optional)
     * @return ApiResponse&lt;WebAuthnRegisterStartRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) registration initiated successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<WebAuthnRegisterStartRsp> webAuthnRegisterStartWithHttpInfo(WebAuthnRegisterStartReq webAuthnRegisterStartReq) throws ApiException {
        okhttp3.Call localVarCall = webAuthnRegisterStartValidateBeforeCall(webAuthnRegisterStartReq, null);
        Type localVarReturnType = new TypeToken<WebAuthnRegisterStartRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Starts registration of a user for Passkeys (Biometrics)
     * @param webAuthnRegisterStartReq  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) registration initiated successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnRegisterStartAsync(WebAuthnRegisterStartReq webAuthnRegisterStartReq, final ApiCallback<WebAuthnRegisterStartRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = webAuthnRegisterStartValidateBeforeCall(webAuthnRegisterStartReq, _callback);
        Type localVarReturnType = new TypeToken<WebAuthnRegisterStartRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for webAuthnSettingCreate
     * @param webauthnSettingCreateReq  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) setting successfully created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnSettingCreateCall(WebauthnSettingCreateReq webauthnSettingCreateReq, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = webauthnSettingCreateReq;

        // create path and map variables
        String localVarPath = "/v1/webauthn/settings";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "basicAuth", "projectID", "bearerAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call webAuthnSettingCreateValidateBeforeCall(WebauthnSettingCreateReq webauthnSettingCreateReq, final ApiCallback _callback) throws ApiException {
        return webAuthnSettingCreateCall(webauthnSettingCreateReq, _callback);

    }

    /**
     * 
     * Creates a new setting for Passkeys (Biometrics)
     * @param webauthnSettingCreateReq  (optional)
     * @return WebauthnSettingCreateRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) setting successfully created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public WebauthnSettingCreateRsp webAuthnSettingCreate(WebauthnSettingCreateReq webauthnSettingCreateReq) throws ApiException {
        ApiResponse<WebauthnSettingCreateRsp> localVarResp = webAuthnSettingCreateWithHttpInfo(webauthnSettingCreateReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Creates a new setting for Passkeys (Biometrics)
     * @param webauthnSettingCreateReq  (optional)
     * @return ApiResponse&lt;WebauthnSettingCreateRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) setting successfully created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<WebauthnSettingCreateRsp> webAuthnSettingCreateWithHttpInfo(WebauthnSettingCreateReq webauthnSettingCreateReq) throws ApiException {
        okhttp3.Call localVarCall = webAuthnSettingCreateValidateBeforeCall(webauthnSettingCreateReq, null);
        Type localVarReturnType = new TypeToken<WebauthnSettingCreateRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Creates a new setting for Passkeys (Biometrics)
     * @param webauthnSettingCreateReq  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkeys (Biometrics) setting successfully created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnSettingCreateAsync(WebauthnSettingCreateReq webauthnSettingCreateReq, final ApiCallback<WebauthnSettingCreateRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = webAuthnSettingCreateValidateBeforeCall(webauthnSettingCreateReq, _callback);
        Type localVarReturnType = new TypeToken<WebauthnSettingCreateRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for webAuthnSettingDelete
     * @param settingID ID from create (required)
     * @param webauthnSettingDeleteReq  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Operation succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnSettingDeleteCall(String settingID, WebauthnSettingDeleteReq webauthnSettingDeleteReq, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = webauthnSettingDeleteReq;

        // create path and map variables
        String localVarPath = "/v1/webauthn/settings/{settingID}"
            .replace("{" + "settingID" + "}", localVarApiClient.escapeString(settingID.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "basicAuth", "projectID", "bearerAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call webAuthnSettingDeleteValidateBeforeCall(String settingID, WebauthnSettingDeleteReq webauthnSettingDeleteReq, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settingID' is set
        if (settingID == null) {
            throw new ApiException("Missing the required parameter 'settingID' when calling webAuthnSettingDelete(Async)");
        }

        return webAuthnSettingDeleteCall(settingID, webauthnSettingDeleteReq, _callback);

    }

    /**
     * 
     * Deletes a setting by id for Passkeys (Biometrics)
     * @param settingID ID from create (required)
     * @param webauthnSettingDeleteReq  (optional)
     * @return GenericRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Operation succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public GenericRsp webAuthnSettingDelete(String settingID, WebauthnSettingDeleteReq webauthnSettingDeleteReq) throws ApiException {
        ApiResponse<GenericRsp> localVarResp = webAuthnSettingDeleteWithHttpInfo(settingID, webauthnSettingDeleteReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Deletes a setting by id for Passkeys (Biometrics)
     * @param settingID ID from create (required)
     * @param webauthnSettingDeleteReq  (optional)
     * @return ApiResponse&lt;GenericRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Operation succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<GenericRsp> webAuthnSettingDeleteWithHttpInfo(String settingID, WebauthnSettingDeleteReq webauthnSettingDeleteReq) throws ApiException {
        okhttp3.Call localVarCall = webAuthnSettingDeleteValidateBeforeCall(settingID, webauthnSettingDeleteReq, null);
        Type localVarReturnType = new TypeToken<GenericRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Deletes a setting by id for Passkeys (Biometrics)
     * @param settingID ID from create (required)
     * @param webauthnSettingDeleteReq  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Operation succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnSettingDeleteAsync(String settingID, WebauthnSettingDeleteReq webauthnSettingDeleteReq, final ApiCallback<GenericRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = webAuthnSettingDeleteValidateBeforeCall(settingID, webauthnSettingDeleteReq, _callback);
        Type localVarReturnType = new TypeToken<GenericRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for webAuthnSettingGet
     * @param settingID ID from create (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains a Passkeys (Biometrics) setting </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnSettingGetCall(String settingID, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/webauthn/settings/{settingID}"
            .replace("{" + "settingID" + "}", localVarApiClient.escapeString(settingID.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "basicAuth", "projectID", "bearerAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call webAuthnSettingGetValidateBeforeCall(String settingID, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settingID' is set
        if (settingID == null) {
            throw new ApiException("Missing the required parameter 'settingID' when calling webAuthnSettingGet(Async)");
        }

        return webAuthnSettingGetCall(settingID, _callback);

    }

    /**
     * 
     * Gets a setting by id for Passkeys (Biometrics)
     * @param settingID ID from create (required)
     * @return WebauthnSettingGetRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains a Passkeys (Biometrics) setting </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public WebauthnSettingGetRsp webAuthnSettingGet(String settingID) throws ApiException {
        ApiResponse<WebauthnSettingGetRsp> localVarResp = webAuthnSettingGetWithHttpInfo(settingID);
        return localVarResp.getData();
    }

    /**
     * 
     * Gets a setting by id for Passkeys (Biometrics)
     * @param settingID ID from create (required)
     * @return ApiResponse&lt;WebauthnSettingGetRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains a Passkeys (Biometrics) setting </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<WebauthnSettingGetRsp> webAuthnSettingGetWithHttpInfo(String settingID) throws ApiException {
        okhttp3.Call localVarCall = webAuthnSettingGetValidateBeforeCall(settingID, null);
        Type localVarReturnType = new TypeToken<WebauthnSettingGetRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Gets a setting by id for Passkeys (Biometrics)
     * @param settingID ID from create (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains a Passkeys (Biometrics) setting </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnSettingGetAsync(String settingID, final ApiCallback<WebauthnSettingGetRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = webAuthnSettingGetValidateBeforeCall(settingID, _callback);
        Type localVarReturnType = new TypeToken<WebauthnSettingGetRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for webAuthnSettingList
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains a list of all Passkeys (Biometrics) settings </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnSettingListCall(String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/webauthn/settings";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (remoteAddress != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("remoteAddress", remoteAddress));
        }

        if (userAgent != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("userAgent", userAgent));
        }

        if (sort != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("sort", sort));
        }

        if (filter != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("multi", "filter[]", filter));
        }

        if (page != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page", page));
        }

        if (pageSize != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("pageSize", pageSize));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "basicAuth", "projectID", "bearerAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call webAuthnSettingListValidateBeforeCall(String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
        return webAuthnSettingListCall(remoteAddress, userAgent, sort, filter, page, pageSize, _callback);

    }

    /**
     * 
     * Lists all settings for Passkeys (Biometrics)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return WebauthnSettingListRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains a list of all Passkeys (Biometrics) settings </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public WebauthnSettingListRsp webAuthnSettingList(String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<WebauthnSettingListRsp> localVarResp = webAuthnSettingListWithHttpInfo(remoteAddress, userAgent, sort, filter, page, pageSize);
        return localVarResp.getData();
    }

    /**
     * 
     * Lists all settings for Passkeys (Biometrics)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return ApiResponse&lt;WebauthnSettingListRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains a list of all Passkeys (Biometrics) settings </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<WebauthnSettingListRsp> webAuthnSettingListWithHttpInfo(String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        okhttp3.Call localVarCall = webAuthnSettingListValidateBeforeCall(remoteAddress, userAgent, sort, filter, page, pageSize, null);
        Type localVarReturnType = new TypeToken<WebauthnSettingListRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Lists all settings for Passkeys (Biometrics)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains a list of all Passkeys (Biometrics) settings </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnSettingListAsync(String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback<WebauthnSettingListRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = webAuthnSettingListValidateBeforeCall(remoteAddress, userAgent, sort, filter, page, pageSize, _callback);
        Type localVarReturnType = new TypeToken<WebauthnSettingListRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for webAuthnSettingPut
     * @param settingID ID from create (required)
     * @param webauthnSettingUpdateReq  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains a Passkeys (Biometrics) setting </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnSettingPutCall(String settingID, WebauthnSettingUpdateReq webauthnSettingUpdateReq, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = webauthnSettingUpdateReq;

        // create path and map variables
        String localVarPath = "/v1/webauthn/settings/{settingID}"
            .replace("{" + "settingID" + "}", localVarApiClient.escapeString(settingID.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "basicAuth", "projectID", "bearerAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call webAuthnSettingPutValidateBeforeCall(String settingID, WebauthnSettingUpdateReq webauthnSettingUpdateReq, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'settingID' is set
        if (settingID == null) {
            throw new ApiException("Missing the required parameter 'settingID' when calling webAuthnSettingPut(Async)");
        }

        return webAuthnSettingPutCall(settingID, webauthnSettingUpdateReq, _callback);

    }

    /**
     * 
     * Updates a setting by id for Passkeys (Biometrics)
     * @param settingID ID from create (required)
     * @param webauthnSettingUpdateReq  (optional)
     * @return WebauthnSettingUpdateRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains a Passkeys (Biometrics) setting </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public WebauthnSettingUpdateRsp webAuthnSettingPut(String settingID, WebauthnSettingUpdateReq webauthnSettingUpdateReq) throws ApiException {
        ApiResponse<WebauthnSettingUpdateRsp> localVarResp = webAuthnSettingPutWithHttpInfo(settingID, webauthnSettingUpdateReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Updates a setting by id for Passkeys (Biometrics)
     * @param settingID ID from create (required)
     * @param webauthnSettingUpdateReq  (optional)
     * @return ApiResponse&lt;WebauthnSettingUpdateRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains a Passkeys (Biometrics) setting </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<WebauthnSettingUpdateRsp> webAuthnSettingPutWithHttpInfo(String settingID, WebauthnSettingUpdateReq webauthnSettingUpdateReq) throws ApiException {
        okhttp3.Call localVarCall = webAuthnSettingPutValidateBeforeCall(settingID, webauthnSettingUpdateReq, null);
        Type localVarReturnType = new TypeToken<WebauthnSettingUpdateRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Updates a setting by id for Passkeys (Biometrics)
     * @param settingID ID from create (required)
     * @param webauthnSettingUpdateReq  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains a Passkeys (Biometrics) setting </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnSettingPutAsync(String settingID, WebauthnSettingUpdateReq webauthnSettingUpdateReq, final ApiCallback<WebauthnSettingUpdateRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = webAuthnSettingPutValidateBeforeCall(settingID, webauthnSettingUpdateReq, _callback);
        Type localVarReturnType = new TypeToken<WebauthnSettingUpdateRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for webAuthnStatsAuthenticator
     * @param granularity Data granularity (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains Passkeys (Biometrics) authenticator statistics </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnStatsAuthenticatorCall(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/webauthn/stats/authenticator";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (remoteAddress != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("remoteAddress", remoteAddress));
        }

        if (userAgent != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("userAgent", userAgent));
        }

        if (sort != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("sort", sort));
        }

        if (filter != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("multi", "filter[]", filter));
        }

        if (page != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page", page));
        }

        if (pageSize != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("pageSize", pageSize));
        }

        if (granularity != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("granularity", granularity));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "basicAuth", "projectID", "bearerAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call webAuthnStatsAuthenticatorValidateBeforeCall(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'granularity' is set
        if (granularity == null) {
            throw new ApiException("Missing the required parameter 'granularity' when calling webAuthnStatsAuthenticator(Async)");
        }

        return webAuthnStatsAuthenticatorCall(granularity, remoteAddress, userAgent, sort, filter, page, pageSize, _callback);

    }

    /**
     * 
     * Provides Passkeys (Biometrics) authenticator statistics
     * @param granularity Data granularity (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return WebauthnStatsAuthenticatorRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains Passkeys (Biometrics) authenticator statistics </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public WebauthnStatsAuthenticatorRsp webAuthnStatsAuthenticator(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<WebauthnStatsAuthenticatorRsp> localVarResp = webAuthnStatsAuthenticatorWithHttpInfo(granularity, remoteAddress, userAgent, sort, filter, page, pageSize);
        return localVarResp.getData();
    }

    /**
     * 
     * Provides Passkeys (Biometrics) authenticator statistics
     * @param granularity Data granularity (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return ApiResponse&lt;WebauthnStatsAuthenticatorRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains Passkeys (Biometrics) authenticator statistics </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<WebauthnStatsAuthenticatorRsp> webAuthnStatsAuthenticatorWithHttpInfo(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        okhttp3.Call localVarCall = webAuthnStatsAuthenticatorValidateBeforeCall(granularity, remoteAddress, userAgent, sort, filter, page, pageSize, null);
        Type localVarReturnType = new TypeToken<WebauthnStatsAuthenticatorRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Provides Passkeys (Biometrics) authenticator statistics
     * @param granularity Data granularity (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains Passkeys (Biometrics) authenticator statistics </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnStatsAuthenticatorAsync(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback<WebauthnStatsAuthenticatorRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = webAuthnStatsAuthenticatorValidateBeforeCall(granularity, remoteAddress, userAgent, sort, filter, page, pageSize, _callback);
        Type localVarReturnType = new TypeToken<WebauthnStatsAuthenticatorRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for webAuthnStatsType
     * @param granularity Data granularity (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains Passkeys (Biometrics) statistics </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnStatsTypeCall(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/webauthn/stats/type";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (remoteAddress != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("remoteAddress", remoteAddress));
        }

        if (userAgent != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("userAgent", userAgent));
        }

        if (sort != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("sort", sort));
        }

        if (filter != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("multi", "filter[]", filter));
        }

        if (page != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page", page));
        }

        if (pageSize != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("pageSize", pageSize));
        }

        if (granularity != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("granularity", granularity));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "basicAuth", "projectID", "bearerAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call webAuthnStatsTypeValidateBeforeCall(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'granularity' is set
        if (granularity == null) {
            throw new ApiException("Missing the required parameter 'granularity' when calling webAuthnStatsType(Async)");
        }

        return webAuthnStatsTypeCall(granularity, remoteAddress, userAgent, sort, filter, page, pageSize, _callback);

    }

    /**
     * 
     * Provides Passkeys (Biometrics) type statistics
     * @param granularity Data granularity (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return WebauthnStatsTypeRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains Passkeys (Biometrics) statistics </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public WebauthnStatsTypeRsp webAuthnStatsType(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<WebauthnStatsTypeRsp> localVarResp = webAuthnStatsTypeWithHttpInfo(granularity, remoteAddress, userAgent, sort, filter, page, pageSize);
        return localVarResp.getData();
    }

    /**
     * 
     * Provides Passkeys (Biometrics) type statistics
     * @param granularity Data granularity (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return ApiResponse&lt;WebauthnStatsTypeRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains Passkeys (Biometrics) statistics </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<WebauthnStatsTypeRsp> webAuthnStatsTypeWithHttpInfo(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        okhttp3.Call localVarCall = webAuthnStatsTypeValidateBeforeCall(granularity, remoteAddress, userAgent, sort, filter, page, pageSize, null);
        Type localVarReturnType = new TypeToken<WebauthnStatsTypeRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Provides Passkeys (Biometrics) type statistics
     * @param granularity Data granularity (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains Passkeys (Biometrics) statistics </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call webAuthnStatsTypeAsync(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback<WebauthnStatsTypeRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = webAuthnStatsTypeValidateBeforeCall(granularity, remoteAddress, userAgent, sort, filter, page, pageSize, _callback);
        Type localVarReturnType = new TypeToken<WebauthnStatsTypeRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
