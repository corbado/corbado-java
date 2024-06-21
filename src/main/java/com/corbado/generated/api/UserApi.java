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


import com.corbado.generated.model.ErrorRsp;
import com.corbado.generated.model.GenericRsp;
import com.corbado.generated.model.UserAuthLogListRsp;
import com.corbado.generated.model.UserCreateReq;
import com.corbado.generated.model.UserCreateRsp;
import com.corbado.generated.model.UserCustomLoginIdentifierCreateReq;
import com.corbado.generated.model.UserCustomLoginIdentifierCreateRsp;
import com.corbado.generated.model.UserCustomLoginIdentifierDeleteReq;
import com.corbado.generated.model.UserCustomLoginIdentifierGetRsp;
import com.corbado.generated.model.UserDeleteReq;
import com.corbado.generated.model.UserDeviceListRsp;
import com.corbado.generated.model.UserEmailCreateReq;
import com.corbado.generated.model.UserEmailCreateRsp;
import com.corbado.generated.model.UserEmailDeleteReq;
import com.corbado.generated.model.UserEmailGetRsp;
import com.corbado.generated.model.UserExistsReq;
import com.corbado.generated.model.UserExistsRsp;
import com.corbado.generated.model.UserGetRsp;
import com.corbado.generated.model.UserListRsp;
import com.corbado.generated.model.UserPhoneNumberCreateReq;
import com.corbado.generated.model.UserPhoneNumberCreateRsp;
import com.corbado.generated.model.UserPhoneNumberDeleteReq;
import com.corbado.generated.model.UserPhoneNumberGetRsp;
import com.corbado.generated.model.UserStatsListRsp;
import com.corbado.generated.model.UserUpdateReq;
import com.corbado.generated.model.UserUpdateRsp;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public UserApi() {
        this(Configuration.getDefaultApiClient());
    }

    public UserApi(ApiClient apiClient) {
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
     * Build call for userAuthLogList
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
        <tr><td> 200 </td><td> Auth methods successfully retrieved </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userAuthLogListCall(String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/userauthlogs";

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
    private okhttp3.Call userAuthLogListValidateBeforeCall(String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
        return userAuthLogListCall(remoteAddress, userAgent, sort, filter, page, pageSize, _callback);

    }

    /**
     * 
     * Lists user auth log
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return UserAuthLogListRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Auth methods successfully retrieved </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public UserAuthLogListRsp userAuthLogList(String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<UserAuthLogListRsp> localVarResp = userAuthLogListWithHttpInfo(remoteAddress, userAgent, sort, filter, page, pageSize);
        return localVarResp.getData();
    }

    /**
     * 
     * Lists user auth log
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return ApiResponse&lt;UserAuthLogListRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Auth methods successfully retrieved </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<UserAuthLogListRsp> userAuthLogListWithHttpInfo(String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        okhttp3.Call localVarCall = userAuthLogListValidateBeforeCall(remoteAddress, userAgent, sort, filter, page, pageSize, null);
        Type localVarReturnType = new TypeToken<UserAuthLogListRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Lists user auth log
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
        <tr><td> 200 </td><td> Auth methods successfully retrieved </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userAuthLogListAsync(String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback<UserAuthLogListRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = userAuthLogListValidateBeforeCall(remoteAddress, userAgent, sort, filter, page, pageSize, _callback);
        Type localVarReturnType = new TypeToken<UserAuthLogListRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for userCreate
     * @param userCreateReq  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User successfully created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userCreateCall(UserCreateReq userCreateReq, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = userCreateReq;

        // create path and map variables
        String localVarPath = "/v1/users";

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
    private okhttp3.Call userCreateValidateBeforeCall(UserCreateReq userCreateReq, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'userCreateReq' is set
        if (userCreateReq == null) {
            throw new ApiException("Missing the required parameter 'userCreateReq' when calling userCreate(Async)");
        }

        return userCreateCall(userCreateReq, _callback);

    }

    /**
     * 
     * Creates a new user
     * @param userCreateReq  (required)
     * @return UserCreateRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User successfully created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public UserCreateRsp userCreate(UserCreateReq userCreateReq) throws ApiException {
        ApiResponse<UserCreateRsp> localVarResp = userCreateWithHttpInfo(userCreateReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Creates a new user
     * @param userCreateReq  (required)
     * @return ApiResponse&lt;UserCreateRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User successfully created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<UserCreateRsp> userCreateWithHttpInfo(UserCreateReq userCreateReq) throws ApiException {
        okhttp3.Call localVarCall = userCreateValidateBeforeCall(userCreateReq, null);
        Type localVarReturnType = new TypeToken<UserCreateRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Creates a new user
     * @param userCreateReq  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User successfully created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userCreateAsync(UserCreateReq userCreateReq, final ApiCallback<UserCreateRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = userCreateValidateBeforeCall(userCreateReq, _callback);
        Type localVarReturnType = new TypeToken<UserCreateRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for userCustomLoginIdentifierCreate
     * @param userID ID of user (required)
     * @param userCustomLoginIdentifierCreateReq  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User custom login identifier created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userCustomLoginIdentifierCreateCall(String userID, UserCustomLoginIdentifierCreateReq userCustomLoginIdentifierCreateReq, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = userCustomLoginIdentifierCreateReq;

        // create path and map variables
        String localVarPath = "/v1/users/{userID}/customLoginIdentifiers"
            .replace("{" + "userID" + "}", localVarApiClient.escapeString(userID.toString()));

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
    private okhttp3.Call userCustomLoginIdentifierCreateValidateBeforeCall(String userID, UserCustomLoginIdentifierCreateReq userCustomLoginIdentifierCreateReq, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'userID' is set
        if (userID == null) {
            throw new ApiException("Missing the required parameter 'userID' when calling userCustomLoginIdentifierCreate(Async)");
        }

        // verify the required parameter 'userCustomLoginIdentifierCreateReq' is set
        if (userCustomLoginIdentifierCreateReq == null) {
            throw new ApiException("Missing the required parameter 'userCustomLoginIdentifierCreateReq' when calling userCustomLoginIdentifierCreate(Async)");
        }

        return userCustomLoginIdentifierCreateCall(userID, userCustomLoginIdentifierCreateReq, _callback);

    }

    /**
     * 
     * Add a custom login identifier to an existing user
     * @param userID ID of user (required)
     * @param userCustomLoginIdentifierCreateReq  (required)
     * @return UserCustomLoginIdentifierCreateRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User custom login identifier created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public UserCustomLoginIdentifierCreateRsp userCustomLoginIdentifierCreate(String userID, UserCustomLoginIdentifierCreateReq userCustomLoginIdentifierCreateReq) throws ApiException {
        ApiResponse<UserCustomLoginIdentifierCreateRsp> localVarResp = userCustomLoginIdentifierCreateWithHttpInfo(userID, userCustomLoginIdentifierCreateReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Add a custom login identifier to an existing user
     * @param userID ID of user (required)
     * @param userCustomLoginIdentifierCreateReq  (required)
     * @return ApiResponse&lt;UserCustomLoginIdentifierCreateRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User custom login identifier created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<UserCustomLoginIdentifierCreateRsp> userCustomLoginIdentifierCreateWithHttpInfo(String userID, UserCustomLoginIdentifierCreateReq userCustomLoginIdentifierCreateReq) throws ApiException {
        okhttp3.Call localVarCall = userCustomLoginIdentifierCreateValidateBeforeCall(userID, userCustomLoginIdentifierCreateReq, null);
        Type localVarReturnType = new TypeToken<UserCustomLoginIdentifierCreateRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Add a custom login identifier to an existing user
     * @param userID ID of user (required)
     * @param userCustomLoginIdentifierCreateReq  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User custom login identifier created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userCustomLoginIdentifierCreateAsync(String userID, UserCustomLoginIdentifierCreateReq userCustomLoginIdentifierCreateReq, final ApiCallback<UserCustomLoginIdentifierCreateRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = userCustomLoginIdentifierCreateValidateBeforeCall(userID, userCustomLoginIdentifierCreateReq, _callback);
        Type localVarReturnType = new TypeToken<UserCustomLoginIdentifierCreateRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for userCustomLoginIdentifierDelete
     * @param userID ID of user (required)
     * @param customLoginIdentifierID ID of custom login identifier (required)
     * @param userCustomLoginIdentifierDeleteReq  (required)
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
    public okhttp3.Call userCustomLoginIdentifierDeleteCall(String userID, String customLoginIdentifierID, UserCustomLoginIdentifierDeleteReq userCustomLoginIdentifierDeleteReq, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = userCustomLoginIdentifierDeleteReq;

        // create path and map variables
        String localVarPath = "/v1/users/{userID}/customLoginIdentifiers/{customLoginIdentifierID}"
            .replace("{" + "userID" + "}", localVarApiClient.escapeString(userID.toString()))
            .replace("{" + "customLoginIdentifierID" + "}", localVarApiClient.escapeString(customLoginIdentifierID.toString()));

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
    private okhttp3.Call userCustomLoginIdentifierDeleteValidateBeforeCall(String userID, String customLoginIdentifierID, UserCustomLoginIdentifierDeleteReq userCustomLoginIdentifierDeleteReq, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'userID' is set
        if (userID == null) {
            throw new ApiException("Missing the required parameter 'userID' when calling userCustomLoginIdentifierDelete(Async)");
        }

        // verify the required parameter 'customLoginIdentifierID' is set
        if (customLoginIdentifierID == null) {
            throw new ApiException("Missing the required parameter 'customLoginIdentifierID' when calling userCustomLoginIdentifierDelete(Async)");
        }

        // verify the required parameter 'userCustomLoginIdentifierDeleteReq' is set
        if (userCustomLoginIdentifierDeleteReq == null) {
            throw new ApiException("Missing the required parameter 'userCustomLoginIdentifierDeleteReq' when calling userCustomLoginIdentifierDelete(Async)");
        }

        return userCustomLoginIdentifierDeleteCall(userID, customLoginIdentifierID, userCustomLoginIdentifierDeleteReq, _callback);

    }

    /**
     * 
     * Delete a user&#39;s custom login identifier
     * @param userID ID of user (required)
     * @param customLoginIdentifierID ID of custom login identifier (required)
     * @param userCustomLoginIdentifierDeleteReq  (required)
     * @return GenericRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Operation succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public GenericRsp userCustomLoginIdentifierDelete(String userID, String customLoginIdentifierID, UserCustomLoginIdentifierDeleteReq userCustomLoginIdentifierDeleteReq) throws ApiException {
        ApiResponse<GenericRsp> localVarResp = userCustomLoginIdentifierDeleteWithHttpInfo(userID, customLoginIdentifierID, userCustomLoginIdentifierDeleteReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Delete a user&#39;s custom login identifier
     * @param userID ID of user (required)
     * @param customLoginIdentifierID ID of custom login identifier (required)
     * @param userCustomLoginIdentifierDeleteReq  (required)
     * @return ApiResponse&lt;GenericRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Operation succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<GenericRsp> userCustomLoginIdentifierDeleteWithHttpInfo(String userID, String customLoginIdentifierID, UserCustomLoginIdentifierDeleteReq userCustomLoginIdentifierDeleteReq) throws ApiException {
        okhttp3.Call localVarCall = userCustomLoginIdentifierDeleteValidateBeforeCall(userID, customLoginIdentifierID, userCustomLoginIdentifierDeleteReq, null);
        Type localVarReturnType = new TypeToken<GenericRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Delete a user&#39;s custom login identifier
     * @param userID ID of user (required)
     * @param customLoginIdentifierID ID of custom login identifier (required)
     * @param userCustomLoginIdentifierDeleteReq  (required)
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
    public okhttp3.Call userCustomLoginIdentifierDeleteAsync(String userID, String customLoginIdentifierID, UserCustomLoginIdentifierDeleteReq userCustomLoginIdentifierDeleteReq, final ApiCallback<GenericRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = userCustomLoginIdentifierDeleteValidateBeforeCall(userID, customLoginIdentifierID, userCustomLoginIdentifierDeleteReq, _callback);
        Type localVarReturnType = new TypeToken<GenericRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for userCustomLoginIdentifierGet
     * @param userID ID of user (required)
     * @param customLoginIdentifierID ID of custom login identifier (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User custom login identifier successfully retrieved </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userCustomLoginIdentifierGetCall(String userID, String customLoginIdentifierID, String remoteAddress, String userAgent, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/users/{userID}/customLoginIdentifiers/{customLoginIdentifierID}"
            .replace("{" + "userID" + "}", localVarApiClient.escapeString(userID.toString()))
            .replace("{" + "customLoginIdentifierID" + "}", localVarApiClient.escapeString(customLoginIdentifierID.toString()));

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
    private okhttp3.Call userCustomLoginIdentifierGetValidateBeforeCall(String userID, String customLoginIdentifierID, String remoteAddress, String userAgent, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'userID' is set
        if (userID == null) {
            throw new ApiException("Missing the required parameter 'userID' when calling userCustomLoginIdentifierGet(Async)");
        }

        // verify the required parameter 'customLoginIdentifierID' is set
        if (customLoginIdentifierID == null) {
            throw new ApiException("Missing the required parameter 'customLoginIdentifierID' when calling userCustomLoginIdentifierGet(Async)");
        }

        return userCustomLoginIdentifierGetCall(userID, customLoginIdentifierID, remoteAddress, userAgent, _callback);

    }

    /**
     * 
     * Get a user&#39;s custom login identifier
     * @param userID ID of user (required)
     * @param customLoginIdentifierID ID of custom login identifier (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @return UserCustomLoginIdentifierGetRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User custom login identifier successfully retrieved </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public UserCustomLoginIdentifierGetRsp userCustomLoginIdentifierGet(String userID, String customLoginIdentifierID, String remoteAddress, String userAgent) throws ApiException {
        ApiResponse<UserCustomLoginIdentifierGetRsp> localVarResp = userCustomLoginIdentifierGetWithHttpInfo(userID, customLoginIdentifierID, remoteAddress, userAgent);
        return localVarResp.getData();
    }

    /**
     * 
     * Get a user&#39;s custom login identifier
     * @param userID ID of user (required)
     * @param customLoginIdentifierID ID of custom login identifier (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @return ApiResponse&lt;UserCustomLoginIdentifierGetRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User custom login identifier successfully retrieved </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<UserCustomLoginIdentifierGetRsp> userCustomLoginIdentifierGetWithHttpInfo(String userID, String customLoginIdentifierID, String remoteAddress, String userAgent) throws ApiException {
        okhttp3.Call localVarCall = userCustomLoginIdentifierGetValidateBeforeCall(userID, customLoginIdentifierID, remoteAddress, userAgent, null);
        Type localVarReturnType = new TypeToken<UserCustomLoginIdentifierGetRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Get a user&#39;s custom login identifier
     * @param userID ID of user (required)
     * @param customLoginIdentifierID ID of custom login identifier (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User custom login identifier successfully retrieved </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userCustomLoginIdentifierGetAsync(String userID, String customLoginIdentifierID, String remoteAddress, String userAgent, final ApiCallback<UserCustomLoginIdentifierGetRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = userCustomLoginIdentifierGetValidateBeforeCall(userID, customLoginIdentifierID, remoteAddress, userAgent, _callback);
        Type localVarReturnType = new TypeToken<UserCustomLoginIdentifierGetRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for userDelete
     * @param userID ID of user (required)
     * @param userDeleteReq  (required)
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
    public okhttp3.Call userDeleteCall(String userID, UserDeleteReq userDeleteReq, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = userDeleteReq;

        // create path and map variables
        String localVarPath = "/v1/users/{userID}"
            .replace("{" + "userID" + "}", localVarApiClient.escapeString(userID.toString()));

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
    private okhttp3.Call userDeleteValidateBeforeCall(String userID, UserDeleteReq userDeleteReq, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'userID' is set
        if (userID == null) {
            throw new ApiException("Missing the required parameter 'userID' when calling userDelete(Async)");
        }

        // verify the required parameter 'userDeleteReq' is set
        if (userDeleteReq == null) {
            throw new ApiException("Missing the required parameter 'userDeleteReq' when calling userDelete(Async)");
        }

        return userDeleteCall(userID, userDeleteReq, _callback);

    }

    /**
     * 
     * Deletes a user
     * @param userID ID of user (required)
     * @param userDeleteReq  (required)
     * @return GenericRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Operation succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public GenericRsp userDelete(String userID, UserDeleteReq userDeleteReq) throws ApiException {
        ApiResponse<GenericRsp> localVarResp = userDeleteWithHttpInfo(userID, userDeleteReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Deletes a user
     * @param userID ID of user (required)
     * @param userDeleteReq  (required)
     * @return ApiResponse&lt;GenericRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Operation succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<GenericRsp> userDeleteWithHttpInfo(String userID, UserDeleteReq userDeleteReq) throws ApiException {
        okhttp3.Call localVarCall = userDeleteValidateBeforeCall(userID, userDeleteReq, null);
        Type localVarReturnType = new TypeToken<GenericRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Deletes a user
     * @param userID ID of user (required)
     * @param userDeleteReq  (required)
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
    public okhttp3.Call userDeleteAsync(String userID, UserDeleteReq userDeleteReq, final ApiCallback<GenericRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = userDeleteValidateBeforeCall(userID, userDeleteReq, _callback);
        Type localVarReturnType = new TypeToken<GenericRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for userDeviceList
     * @param userID ID of user (required)
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
        <tr><td> 200 </td><td> Contains a list of all devices </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userDeviceListCall(String userID, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/users/{userID}/devices"
            .replace("{" + "userID" + "}", localVarApiClient.escapeString(userID.toString()));

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
    private okhttp3.Call userDeviceListValidateBeforeCall(String userID, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'userID' is set
        if (userID == null) {
            throw new ApiException("Missing the required parameter 'userID' when calling userDeviceList(Async)");
        }

        return userDeviceListCall(userID, remoteAddress, userAgent, sort, filter, page, pageSize, _callback);

    }

    /**
     * 
     * Provides all register devices for given user
     * @param userID ID of user (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return UserDeviceListRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains a list of all devices </td><td>  -  </td></tr>
     </table>
     */
    public UserDeviceListRsp userDeviceList(String userID, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<UserDeviceListRsp> localVarResp = userDeviceListWithHttpInfo(userID, remoteAddress, userAgent, sort, filter, page, pageSize);
        return localVarResp.getData();
    }

    /**
     * 
     * Provides all register devices for given user
     * @param userID ID of user (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return ApiResponse&lt;UserDeviceListRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains a list of all devices </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<UserDeviceListRsp> userDeviceListWithHttpInfo(String userID, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        okhttp3.Call localVarCall = userDeviceListValidateBeforeCall(userID, remoteAddress, userAgent, sort, filter, page, pageSize, null);
        Type localVarReturnType = new TypeToken<UserDeviceListRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Provides all register devices for given user
     * @param userID ID of user (required)
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
        <tr><td> 200 </td><td> Contains a list of all devices </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userDeviceListAsync(String userID, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback<UserDeviceListRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = userDeviceListValidateBeforeCall(userID, remoteAddress, userAgent, sort, filter, page, pageSize, _callback);
        Type localVarReturnType = new TypeToken<UserDeviceListRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for userEmailCreate
     * @param userID ID of user (required)
     * @param userEmailCreateReq  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User email found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userEmailCreateCall(String userID, UserEmailCreateReq userEmailCreateReq, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = userEmailCreateReq;

        // create path and map variables
        String localVarPath = "/v1/users/{userID}/emails"
            .replace("{" + "userID" + "}", localVarApiClient.escapeString(userID.toString()));

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
    private okhttp3.Call userEmailCreateValidateBeforeCall(String userID, UserEmailCreateReq userEmailCreateReq, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'userID' is set
        if (userID == null) {
            throw new ApiException("Missing the required parameter 'userID' when calling userEmailCreate(Async)");
        }

        // verify the required parameter 'userEmailCreateReq' is set
        if (userEmailCreateReq == null) {
            throw new ApiException("Missing the required parameter 'userEmailCreateReq' when calling userEmailCreate(Async)");
        }

        return userEmailCreateCall(userID, userEmailCreateReq, _callback);

    }

    /**
     * 
     * Add an email to an existing user
     * @param userID ID of user (required)
     * @param userEmailCreateReq  (required)
     * @return UserEmailCreateRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User email found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public UserEmailCreateRsp userEmailCreate(String userID, UserEmailCreateReq userEmailCreateReq) throws ApiException {
        ApiResponse<UserEmailCreateRsp> localVarResp = userEmailCreateWithHttpInfo(userID, userEmailCreateReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Add an email to an existing user
     * @param userID ID of user (required)
     * @param userEmailCreateReq  (required)
     * @return ApiResponse&lt;UserEmailCreateRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User email found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<UserEmailCreateRsp> userEmailCreateWithHttpInfo(String userID, UserEmailCreateReq userEmailCreateReq) throws ApiException {
        okhttp3.Call localVarCall = userEmailCreateValidateBeforeCall(userID, userEmailCreateReq, null);
        Type localVarReturnType = new TypeToken<UserEmailCreateRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Add an email to an existing user
     * @param userID ID of user (required)
     * @param userEmailCreateReq  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User email found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userEmailCreateAsync(String userID, UserEmailCreateReq userEmailCreateReq, final ApiCallback<UserEmailCreateRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = userEmailCreateValidateBeforeCall(userID, userEmailCreateReq, _callback);
        Type localVarReturnType = new TypeToken<UserEmailCreateRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for userEmailDelete
     * @param userID ID of user (required)
     * @param emailID ID of email (required)
     * @param userEmailDeleteReq  (required)
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
    public okhttp3.Call userEmailDeleteCall(String userID, String emailID, UserEmailDeleteReq userEmailDeleteReq, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = userEmailDeleteReq;

        // create path and map variables
        String localVarPath = "/v1/users/{userID}/emails/{emailID}"
            .replace("{" + "userID" + "}", localVarApiClient.escapeString(userID.toString()))
            .replace("{" + "emailID" + "}", localVarApiClient.escapeString(emailID.toString()));

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
    private okhttp3.Call userEmailDeleteValidateBeforeCall(String userID, String emailID, UserEmailDeleteReq userEmailDeleteReq, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'userID' is set
        if (userID == null) {
            throw new ApiException("Missing the required parameter 'userID' when calling userEmailDelete(Async)");
        }

        // verify the required parameter 'emailID' is set
        if (emailID == null) {
            throw new ApiException("Missing the required parameter 'emailID' when calling userEmailDelete(Async)");
        }

        // verify the required parameter 'userEmailDeleteReq' is set
        if (userEmailDeleteReq == null) {
            throw new ApiException("Missing the required parameter 'userEmailDeleteReq' when calling userEmailDelete(Async)");
        }

        return userEmailDeleteCall(userID, emailID, userEmailDeleteReq, _callback);

    }

    /**
     * 
     * Delete a user&#39;s email
     * @param userID ID of user (required)
     * @param emailID ID of email (required)
     * @param userEmailDeleteReq  (required)
     * @return GenericRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Operation succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public GenericRsp userEmailDelete(String userID, String emailID, UserEmailDeleteReq userEmailDeleteReq) throws ApiException {
        ApiResponse<GenericRsp> localVarResp = userEmailDeleteWithHttpInfo(userID, emailID, userEmailDeleteReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Delete a user&#39;s email
     * @param userID ID of user (required)
     * @param emailID ID of email (required)
     * @param userEmailDeleteReq  (required)
     * @return ApiResponse&lt;GenericRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Operation succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<GenericRsp> userEmailDeleteWithHttpInfo(String userID, String emailID, UserEmailDeleteReq userEmailDeleteReq) throws ApiException {
        okhttp3.Call localVarCall = userEmailDeleteValidateBeforeCall(userID, emailID, userEmailDeleteReq, null);
        Type localVarReturnType = new TypeToken<GenericRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Delete a user&#39;s email
     * @param userID ID of user (required)
     * @param emailID ID of email (required)
     * @param userEmailDeleteReq  (required)
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
    public okhttp3.Call userEmailDeleteAsync(String userID, String emailID, UserEmailDeleteReq userEmailDeleteReq, final ApiCallback<GenericRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = userEmailDeleteValidateBeforeCall(userID, emailID, userEmailDeleteReq, _callback);
        Type localVarReturnType = new TypeToken<GenericRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for userEmailGet
     * @param userID ID of user (required)
     * @param emailID ID of email (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User email successfully created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userEmailGetCall(String userID, String emailID, String remoteAddress, String userAgent, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/users/{userID}/emails/{emailID}"
            .replace("{" + "userID" + "}", localVarApiClient.escapeString(userID.toString()))
            .replace("{" + "emailID" + "}", localVarApiClient.escapeString(emailID.toString()));

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
    private okhttp3.Call userEmailGetValidateBeforeCall(String userID, String emailID, String remoteAddress, String userAgent, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'userID' is set
        if (userID == null) {
            throw new ApiException("Missing the required parameter 'userID' when calling userEmailGet(Async)");
        }

        // verify the required parameter 'emailID' is set
        if (emailID == null) {
            throw new ApiException("Missing the required parameter 'emailID' when calling userEmailGet(Async)");
        }

        return userEmailGetCall(userID, emailID, remoteAddress, userAgent, _callback);

    }

    /**
     * 
     * Get a user&#39;s email
     * @param userID ID of user (required)
     * @param emailID ID of email (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @return UserEmailGetRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User email successfully created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public UserEmailGetRsp userEmailGet(String userID, String emailID, String remoteAddress, String userAgent) throws ApiException {
        ApiResponse<UserEmailGetRsp> localVarResp = userEmailGetWithHttpInfo(userID, emailID, remoteAddress, userAgent);
        return localVarResp.getData();
    }

    /**
     * 
     * Get a user&#39;s email
     * @param userID ID of user (required)
     * @param emailID ID of email (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @return ApiResponse&lt;UserEmailGetRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User email successfully created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<UserEmailGetRsp> userEmailGetWithHttpInfo(String userID, String emailID, String remoteAddress, String userAgent) throws ApiException {
        okhttp3.Call localVarCall = userEmailGetValidateBeforeCall(userID, emailID, remoteAddress, userAgent, null);
        Type localVarReturnType = new TypeToken<UserEmailGetRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Get a user&#39;s email
     * @param userID ID of user (required)
     * @param emailID ID of email (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User email successfully created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userEmailGetAsync(String userID, String emailID, String remoteAddress, String userAgent, final ApiCallback<UserEmailGetRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = userEmailGetValidateBeforeCall(userID, emailID, remoteAddress, userAgent, _callback);
        Type localVarReturnType = new TypeToken<UserEmailGetRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for userExists
     * @param userExistsReq  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User existence check completed </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userExistsCall(UserExistsReq userExistsReq, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = userExistsReq;

        // create path and map variables
        String localVarPath = "/v1/users/exists";

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
    private okhttp3.Call userExistsValidateBeforeCall(UserExistsReq userExistsReq, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'userExistsReq' is set
        if (userExistsReq == null) {
            throw new ApiException("Missing the required parameter 'userExistsReq' when calling userExists(Async)");
        }

        return userExistsCall(userExistsReq, _callback);

    }

    /**
     * 
     * Checks if a confirmed user exists for provided login identifier
     * @param userExistsReq  (required)
     * @return UserExistsRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User existence check completed </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public UserExistsRsp userExists(UserExistsReq userExistsReq) throws ApiException {
        ApiResponse<UserExistsRsp> localVarResp = userExistsWithHttpInfo(userExistsReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Checks if a confirmed user exists for provided login identifier
     * @param userExistsReq  (required)
     * @return ApiResponse&lt;UserExistsRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User existence check completed </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<UserExistsRsp> userExistsWithHttpInfo(UserExistsReq userExistsReq) throws ApiException {
        okhttp3.Call localVarCall = userExistsValidateBeforeCall(userExistsReq, null);
        Type localVarReturnType = new TypeToken<UserExistsRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Checks if a confirmed user exists for provided login identifier
     * @param userExistsReq  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User existence check completed </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userExistsAsync(UserExistsReq userExistsReq, final ApiCallback<UserExistsRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = userExistsValidateBeforeCall(userExistsReq, _callback);
        Type localVarReturnType = new TypeToken<UserExistsRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for userGet
     * @param userID ID of user (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User successfully retrieved </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userGetCall(String userID, String remoteAddress, String userAgent, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/users/{userID}"
            .replace("{" + "userID" + "}", localVarApiClient.escapeString(userID.toString()));

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
    private okhttp3.Call userGetValidateBeforeCall(String userID, String remoteAddress, String userAgent, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'userID' is set
        if (userID == null) {
            throw new ApiException("Missing the required parameter 'userID' when calling userGet(Async)");
        }

        return userGetCall(userID, remoteAddress, userAgent, _callback);

    }

    /**
     * 
     * Get a user by ID
     * @param userID ID of user (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @return UserGetRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User successfully retrieved </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public UserGetRsp userGet(String userID, String remoteAddress, String userAgent) throws ApiException {
        ApiResponse<UserGetRsp> localVarResp = userGetWithHttpInfo(userID, remoteAddress, userAgent);
        return localVarResp.getData();
    }

    /**
     * 
     * Get a user by ID
     * @param userID ID of user (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @return ApiResponse&lt;UserGetRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User successfully retrieved </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<UserGetRsp> userGetWithHttpInfo(String userID, String remoteAddress, String userAgent) throws ApiException {
        okhttp3.Call localVarCall = userGetValidateBeforeCall(userID, remoteAddress, userAgent, null);
        Type localVarReturnType = new TypeToken<UserGetRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Get a user by ID
     * @param userID ID of user (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User successfully retrieved </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userGetAsync(String userID, String remoteAddress, String userAgent, final ApiCallback<UserGetRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = userGetValidateBeforeCall(userID, remoteAddress, userAgent, _callback);
        Type localVarReturnType = new TypeToken<UserGetRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for userList
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
        <tr><td> 200 </td><td> Users successfully retrieved </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userListCall(String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/users";

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
    private okhttp3.Call userListValidateBeforeCall(String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
        return userListCall(remoteAddress, userAgent, sort, filter, page, pageSize, _callback);

    }

    /**
     * 
     * Lists project users
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return UserListRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Users successfully retrieved </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public UserListRsp userList(String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<UserListRsp> localVarResp = userListWithHttpInfo(remoteAddress, userAgent, sort, filter, page, pageSize);
        return localVarResp.getData();
    }

    /**
     * 
     * Lists project users
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return ApiResponse&lt;UserListRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Users successfully retrieved </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<UserListRsp> userListWithHttpInfo(String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        okhttp3.Call localVarCall = userListValidateBeforeCall(remoteAddress, userAgent, sort, filter, page, pageSize, null);
        Type localVarReturnType = new TypeToken<UserListRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Lists project users
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
        <tr><td> 200 </td><td> Users successfully retrieved </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userListAsync(String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback<UserListRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = userListValidateBeforeCall(remoteAddress, userAgent, sort, filter, page, pageSize, _callback);
        Type localVarReturnType = new TypeToken<UserListRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for userPhoneNumberCreate
     * @param userID ID of user (required)
     * @param userPhoneNumberCreateReq  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User phone number successfully added </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userPhoneNumberCreateCall(String userID, UserPhoneNumberCreateReq userPhoneNumberCreateReq, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = userPhoneNumberCreateReq;

        // create path and map variables
        String localVarPath = "/v1/users/{userID}/phoneNumbers"
            .replace("{" + "userID" + "}", localVarApiClient.escapeString(userID.toString()));

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
    private okhttp3.Call userPhoneNumberCreateValidateBeforeCall(String userID, UserPhoneNumberCreateReq userPhoneNumberCreateReq, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'userID' is set
        if (userID == null) {
            throw new ApiException("Missing the required parameter 'userID' when calling userPhoneNumberCreate(Async)");
        }

        // verify the required parameter 'userPhoneNumberCreateReq' is set
        if (userPhoneNumberCreateReq == null) {
            throw new ApiException("Missing the required parameter 'userPhoneNumberCreateReq' when calling userPhoneNumberCreate(Async)");
        }

        return userPhoneNumberCreateCall(userID, userPhoneNumberCreateReq, _callback);

    }

    /**
     * 
     * Add a phone number to an existing user
     * @param userID ID of user (required)
     * @param userPhoneNumberCreateReq  (required)
     * @return UserPhoneNumberCreateRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User phone number successfully added </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public UserPhoneNumberCreateRsp userPhoneNumberCreate(String userID, UserPhoneNumberCreateReq userPhoneNumberCreateReq) throws ApiException {
        ApiResponse<UserPhoneNumberCreateRsp> localVarResp = userPhoneNumberCreateWithHttpInfo(userID, userPhoneNumberCreateReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Add a phone number to an existing user
     * @param userID ID of user (required)
     * @param userPhoneNumberCreateReq  (required)
     * @return ApiResponse&lt;UserPhoneNumberCreateRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User phone number successfully added </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<UserPhoneNumberCreateRsp> userPhoneNumberCreateWithHttpInfo(String userID, UserPhoneNumberCreateReq userPhoneNumberCreateReq) throws ApiException {
        okhttp3.Call localVarCall = userPhoneNumberCreateValidateBeforeCall(userID, userPhoneNumberCreateReq, null);
        Type localVarReturnType = new TypeToken<UserPhoneNumberCreateRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Add a phone number to an existing user
     * @param userID ID of user (required)
     * @param userPhoneNumberCreateReq  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User phone number successfully added </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userPhoneNumberCreateAsync(String userID, UserPhoneNumberCreateReq userPhoneNumberCreateReq, final ApiCallback<UserPhoneNumberCreateRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = userPhoneNumberCreateValidateBeforeCall(userID, userPhoneNumberCreateReq, _callback);
        Type localVarReturnType = new TypeToken<UserPhoneNumberCreateRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for userPhoneNumberDelete
     * @param userID ID of user (required)
     * @param phoneNumberID ID of phone number (required)
     * @param userPhoneNumberDeleteReq  (required)
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
    public okhttp3.Call userPhoneNumberDeleteCall(String userID, String phoneNumberID, UserPhoneNumberDeleteReq userPhoneNumberDeleteReq, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = userPhoneNumberDeleteReq;

        // create path and map variables
        String localVarPath = "/v1/users/{userID}/phoneNumbers/{phoneNumberID}"
            .replace("{" + "userID" + "}", localVarApiClient.escapeString(userID.toString()))
            .replace("{" + "phoneNumberID" + "}", localVarApiClient.escapeString(phoneNumberID.toString()));

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
    private okhttp3.Call userPhoneNumberDeleteValidateBeforeCall(String userID, String phoneNumberID, UserPhoneNumberDeleteReq userPhoneNumberDeleteReq, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'userID' is set
        if (userID == null) {
            throw new ApiException("Missing the required parameter 'userID' when calling userPhoneNumberDelete(Async)");
        }

        // verify the required parameter 'phoneNumberID' is set
        if (phoneNumberID == null) {
            throw new ApiException("Missing the required parameter 'phoneNumberID' when calling userPhoneNumberDelete(Async)");
        }

        // verify the required parameter 'userPhoneNumberDeleteReq' is set
        if (userPhoneNumberDeleteReq == null) {
            throw new ApiException("Missing the required parameter 'userPhoneNumberDeleteReq' when calling userPhoneNumberDelete(Async)");
        }

        return userPhoneNumberDeleteCall(userID, phoneNumberID, userPhoneNumberDeleteReq, _callback);

    }

    /**
     * 
     * Delete a user&#39;s phone number
     * @param userID ID of user (required)
     * @param phoneNumberID ID of phone number (required)
     * @param userPhoneNumberDeleteReq  (required)
     * @return GenericRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Operation succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public GenericRsp userPhoneNumberDelete(String userID, String phoneNumberID, UserPhoneNumberDeleteReq userPhoneNumberDeleteReq) throws ApiException {
        ApiResponse<GenericRsp> localVarResp = userPhoneNumberDeleteWithHttpInfo(userID, phoneNumberID, userPhoneNumberDeleteReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Delete a user&#39;s phone number
     * @param userID ID of user (required)
     * @param phoneNumberID ID of phone number (required)
     * @param userPhoneNumberDeleteReq  (required)
     * @return ApiResponse&lt;GenericRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Operation succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<GenericRsp> userPhoneNumberDeleteWithHttpInfo(String userID, String phoneNumberID, UserPhoneNumberDeleteReq userPhoneNumberDeleteReq) throws ApiException {
        okhttp3.Call localVarCall = userPhoneNumberDeleteValidateBeforeCall(userID, phoneNumberID, userPhoneNumberDeleteReq, null);
        Type localVarReturnType = new TypeToken<GenericRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Delete a user&#39;s phone number
     * @param userID ID of user (required)
     * @param phoneNumberID ID of phone number (required)
     * @param userPhoneNumberDeleteReq  (required)
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
    public okhttp3.Call userPhoneNumberDeleteAsync(String userID, String phoneNumberID, UserPhoneNumberDeleteReq userPhoneNumberDeleteReq, final ApiCallback<GenericRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = userPhoneNumberDeleteValidateBeforeCall(userID, phoneNumberID, userPhoneNumberDeleteReq, _callback);
        Type localVarReturnType = new TypeToken<GenericRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for userPhoneNumberGet
     * @param userID ID of user (required)
     * @param phoneNumberID ID of phone number (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User phone number found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userPhoneNumberGetCall(String userID, String phoneNumberID, String remoteAddress, String userAgent, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/users/{userID}/phoneNumbers/{phoneNumberID}"
            .replace("{" + "userID" + "}", localVarApiClient.escapeString(userID.toString()))
            .replace("{" + "phoneNumberID" + "}", localVarApiClient.escapeString(phoneNumberID.toString()));

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

        String[] localVarAuthNames = new String[] { "projectID" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call userPhoneNumberGetValidateBeforeCall(String userID, String phoneNumberID, String remoteAddress, String userAgent, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'userID' is set
        if (userID == null) {
            throw new ApiException("Missing the required parameter 'userID' when calling userPhoneNumberGet(Async)");
        }

        // verify the required parameter 'phoneNumberID' is set
        if (phoneNumberID == null) {
            throw new ApiException("Missing the required parameter 'phoneNumberID' when calling userPhoneNumberGet(Async)");
        }

        return userPhoneNumberGetCall(userID, phoneNumberID, remoteAddress, userAgent, _callback);

    }

    /**
     * 
     * Get a user&#39;s phone number
     * @param userID ID of user (required)
     * @param phoneNumberID ID of phone number (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @return UserPhoneNumberGetRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User phone number found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public UserPhoneNumberGetRsp userPhoneNumberGet(String userID, String phoneNumberID, String remoteAddress, String userAgent) throws ApiException {
        ApiResponse<UserPhoneNumberGetRsp> localVarResp = userPhoneNumberGetWithHttpInfo(userID, phoneNumberID, remoteAddress, userAgent);
        return localVarResp.getData();
    }

    /**
     * 
     * Get a user&#39;s phone number
     * @param userID ID of user (required)
     * @param phoneNumberID ID of phone number (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @return ApiResponse&lt;UserPhoneNumberGetRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User phone number found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<UserPhoneNumberGetRsp> userPhoneNumberGetWithHttpInfo(String userID, String phoneNumberID, String remoteAddress, String userAgent) throws ApiException {
        okhttp3.Call localVarCall = userPhoneNumberGetValidateBeforeCall(userID, phoneNumberID, remoteAddress, userAgent, null);
        Type localVarReturnType = new TypeToken<UserPhoneNumberGetRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Get a user&#39;s phone number
     * @param userID ID of user (required)
     * @param phoneNumberID ID of phone number (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User phone number found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userPhoneNumberGetAsync(String userID, String phoneNumberID, String remoteAddress, String userAgent, final ApiCallback<UserPhoneNumberGetRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = userPhoneNumberGetValidateBeforeCall(userID, phoneNumberID, remoteAddress, userAgent, _callback);
        Type localVarReturnType = new TypeToken<UserPhoneNumberGetRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for userStatsList
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
        <tr><td> 200 </td><td> Contains a list of all aggregated statistics for user data </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userStatsListCall(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/users/stats";

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
    private okhttp3.Call userStatsListValidateBeforeCall(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'granularity' is set
        if (granularity == null) {
            throw new ApiException("Missing the required parameter 'granularity' when calling userStatsList(Async)");
        }

        return userStatsListCall(granularity, remoteAddress, userAgent, sort, filter, page, pageSize, _callback);

    }

    /**
     * 
     * Provides aggregated user stats for project
     * @param granularity Data granularity (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return UserStatsListRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains a list of all aggregated statistics for user data </td><td>  -  </td></tr>
     </table>
     */
    public UserStatsListRsp userStatsList(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<UserStatsListRsp> localVarResp = userStatsListWithHttpInfo(granularity, remoteAddress, userAgent, sort, filter, page, pageSize);
        return localVarResp.getData();
    }

    /**
     * 
     * Provides aggregated user stats for project
     * @param granularity Data granularity (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return ApiResponse&lt;UserStatsListRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains a list of all aggregated statistics for user data </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<UserStatsListRsp> userStatsListWithHttpInfo(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        okhttp3.Call localVarCall = userStatsListValidateBeforeCall(granularity, remoteAddress, userAgent, sort, filter, page, pageSize, null);
        Type localVarReturnType = new TypeToken<UserStatsListRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Provides aggregated user stats for project
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
        <tr><td> 200 </td><td> Contains a list of all aggregated statistics for user data </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userStatsListAsync(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback<UserStatsListRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = userStatsListValidateBeforeCall(granularity, remoteAddress, userAgent, sort, filter, page, pageSize, _callback);
        Type localVarReturnType = new TypeToken<UserStatsListRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for userUpdate
     * @param userID ID of user (required)
     * @param userUpdateReq  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User successfully updated </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userUpdateCall(String userID, UserUpdateReq userUpdateReq, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = userUpdateReq;

        // create path and map variables
        String localVarPath = "/v1/users/{userID}"
            .replace("{" + "userID" + "}", localVarApiClient.escapeString(userID.toString()));

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
    private okhttp3.Call userUpdateValidateBeforeCall(String userID, UserUpdateReq userUpdateReq, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'userID' is set
        if (userID == null) {
            throw new ApiException("Missing the required parameter 'userID' when calling userUpdate(Async)");
        }

        // verify the required parameter 'userUpdateReq' is set
        if (userUpdateReq == null) {
            throw new ApiException("Missing the required parameter 'userUpdateReq' when calling userUpdate(Async)");
        }

        return userUpdateCall(userID, userUpdateReq, _callback);

    }

    /**
     * 
     * Updates a user
     * @param userID ID of user (required)
     * @param userUpdateReq  (required)
     * @return UserUpdateRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User successfully updated </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public UserUpdateRsp userUpdate(String userID, UserUpdateReq userUpdateReq) throws ApiException {
        ApiResponse<UserUpdateRsp> localVarResp = userUpdateWithHttpInfo(userID, userUpdateReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Updates a user
     * @param userID ID of user (required)
     * @param userUpdateReq  (required)
     * @return ApiResponse&lt;UserUpdateRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User successfully updated </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<UserUpdateRsp> userUpdateWithHttpInfo(String userID, UserUpdateReq userUpdateReq) throws ApiException {
        okhttp3.Call localVarCall = userUpdateValidateBeforeCall(userID, userUpdateReq, null);
        Type localVarReturnType = new TypeToken<UserUpdateRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Updates a user
     * @param userID ID of user (required)
     * @param userUpdateReq  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> User successfully updated </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userUpdateAsync(String userID, UserUpdateReq userUpdateReq, final ApiCallback<UserUpdateRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = userUpdateValidateBeforeCall(userID, userUpdateReq, _callback);
        Type localVarReturnType = new TypeToken<UserUpdateRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
