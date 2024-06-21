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


import com.corbado.generated.model.TrackingBackupStateGetRsp;
import com.corbado.generated.model.TrackingBrowserDetailedStatsListRsp;
import com.corbado.generated.model.TrackingBrowserStatsListRsp;
import com.corbado.generated.model.TrackingDetailedStatsListRsp;
import com.corbado.generated.model.TrackingEnumsGetRsp;
import com.corbado.generated.model.TrackingOSDetailedStatsListRsp;
import com.corbado.generated.model.TrackingOSStatsListRsp;
import com.corbado.generated.model.TrackingRawListRsp;
import com.corbado.generated.model.TrackingStatsListRsp;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyzerApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public AnalyzerApi() {
        this(Configuration.getDefaultApiClient());
    }

    public AnalyzerApi(ApiClient apiClient) {
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
     * Build call for trackingAllRequest
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
        <tr><td> 200 </td><td> Contains a list of raw tracking data per vistor </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call trackingAllRequestCall(String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/tracking";

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
    private okhttp3.Call trackingAllRequestValidateBeforeCall(String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
        return trackingAllRequestCall(remoteAddress, userAgent, sort, filter, page, pageSize, _callback);

    }

    /**
     * 
     * Provides project&#39;s passkeys raw tracking data per visitor
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return TrackingRawListRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains a list of raw tracking data per vistor </td><td>  -  </td></tr>
     </table>
     */
    public TrackingRawListRsp trackingAllRequest(String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<TrackingRawListRsp> localVarResp = trackingAllRequestWithHttpInfo(remoteAddress, userAgent, sort, filter, page, pageSize);
        return localVarResp.getData();
    }

    /**
     * 
     * Provides project&#39;s passkeys raw tracking data per visitor
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return ApiResponse&lt;TrackingRawListRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains a list of raw tracking data per vistor </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<TrackingRawListRsp> trackingAllRequestWithHttpInfo(String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        okhttp3.Call localVarCall = trackingAllRequestValidateBeforeCall(remoteAddress, userAgent, sort, filter, page, pageSize, null);
        Type localVarReturnType = new TypeToken<TrackingRawListRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Provides project&#39;s passkeys raw tracking data per visitor
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
        <tr><td> 200 </td><td> Contains a list of raw tracking data per vistor </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call trackingAllRequestAsync(String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback<TrackingRawListRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = trackingAllRequestValidateBeforeCall(remoteAddress, userAgent, sort, filter, page, pageSize, _callback);
        Type localVarReturnType = new TypeToken<TrackingRawListRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for trackingBackupStateGet
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
        <tr><td> 200 </td><td> Contains tracking credential backup state data </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call trackingBackupStateGetCall(String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/tracking/backupState";

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
    private okhttp3.Call trackingBackupStateGetValidateBeforeCall(String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
        return trackingBackupStateGetCall(remoteAddress, userAgent, sort, filter, page, pageSize, _callback);

    }

    /**
     * 
     * Provides tracking credential backup state data
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return TrackingBackupStateGetRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains tracking credential backup state data </td><td>  -  </td></tr>
     </table>
     */
    public TrackingBackupStateGetRsp trackingBackupStateGet(String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<TrackingBackupStateGetRsp> localVarResp = trackingBackupStateGetWithHttpInfo(remoteAddress, userAgent, sort, filter, page, pageSize);
        return localVarResp.getData();
    }

    /**
     * 
     * Provides tracking credential backup state data
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return ApiResponse&lt;TrackingBackupStateGetRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains tracking credential backup state data </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<TrackingBackupStateGetRsp> trackingBackupStateGetWithHttpInfo(String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        okhttp3.Call localVarCall = trackingBackupStateGetValidateBeforeCall(remoteAddress, userAgent, sort, filter, page, pageSize, null);
        Type localVarReturnType = new TypeToken<TrackingBackupStateGetRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Provides tracking credential backup state data
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
        <tr><td> 200 </td><td> Contains tracking credential backup state data </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call trackingBackupStateGetAsync(String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback<TrackingBackupStateGetRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = trackingBackupStateGetValidateBeforeCall(remoteAddress, userAgent, sort, filter, page, pageSize, _callback);
        Type localVarReturnType = new TypeToken<TrackingBackupStateGetRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for trackingBrowserDetailedStatsList
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
        <tr><td> 200 </td><td> Contains a list of all browser tracking data </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call trackingBrowserDetailedStatsListCall(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/tracking/browser/stats/detailed";

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
    private okhttp3.Call trackingBrowserDetailedStatsListValidateBeforeCall(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'granularity' is set
        if (granularity == null) {
            throw new ApiException("Missing the required parameter 'granularity' when calling trackingBrowserDetailedStatsList(Async)");
        }

        return trackingBrowserDetailedStatsListCall(granularity, remoteAddress, userAgent, sort, filter, page, pageSize, _callback);

    }

    /**
     * 
     * Provides detailed browser tracking data
     * @param granularity Data granularity (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return TrackingBrowserDetailedStatsListRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains a list of all browser tracking data </td><td>  -  </td></tr>
     </table>
     */
    public TrackingBrowserDetailedStatsListRsp trackingBrowserDetailedStatsList(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<TrackingBrowserDetailedStatsListRsp> localVarResp = trackingBrowserDetailedStatsListWithHttpInfo(granularity, remoteAddress, userAgent, sort, filter, page, pageSize);
        return localVarResp.getData();
    }

    /**
     * 
     * Provides detailed browser tracking data
     * @param granularity Data granularity (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return ApiResponse&lt;TrackingBrowserDetailedStatsListRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains a list of all browser tracking data </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<TrackingBrowserDetailedStatsListRsp> trackingBrowserDetailedStatsListWithHttpInfo(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        okhttp3.Call localVarCall = trackingBrowserDetailedStatsListValidateBeforeCall(granularity, remoteAddress, userAgent, sort, filter, page, pageSize, null);
        Type localVarReturnType = new TypeToken<TrackingBrowserDetailedStatsListRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Provides detailed browser tracking data
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
        <tr><td> 200 </td><td> Contains a list of all browser tracking data </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call trackingBrowserDetailedStatsListAsync(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback<TrackingBrowserDetailedStatsListRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = trackingBrowserDetailedStatsListValidateBeforeCall(granularity, remoteAddress, userAgent, sort, filter, page, pageSize, _callback);
        Type localVarReturnType = new TypeToken<TrackingBrowserDetailedStatsListRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for trackingBrowserStatsList
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
        <tr><td> 200 </td><td> Contains a list of aggregated browser tracking data </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call trackingBrowserStatsListCall(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/tracking/browser/stats";

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
    private okhttp3.Call trackingBrowserStatsListValidateBeforeCall(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'granularity' is set
        if (granularity == null) {
            throw new ApiException("Missing the required parameter 'granularity' when calling trackingBrowserStatsList(Async)");
        }

        return trackingBrowserStatsListCall(granularity, remoteAddress, userAgent, sort, filter, page, pageSize, _callback);

    }

    /**
     * 
     * Provides browser tracking data
     * @param granularity Data granularity (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return TrackingBrowserStatsListRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains a list of aggregated browser tracking data </td><td>  -  </td></tr>
     </table>
     */
    public TrackingBrowserStatsListRsp trackingBrowserStatsList(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<TrackingBrowserStatsListRsp> localVarResp = trackingBrowserStatsListWithHttpInfo(granularity, remoteAddress, userAgent, sort, filter, page, pageSize);
        return localVarResp.getData();
    }

    /**
     * 
     * Provides browser tracking data
     * @param granularity Data granularity (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return ApiResponse&lt;TrackingBrowserStatsListRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains a list of aggregated browser tracking data </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<TrackingBrowserStatsListRsp> trackingBrowserStatsListWithHttpInfo(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        okhttp3.Call localVarCall = trackingBrowserStatsListValidateBeforeCall(granularity, remoteAddress, userAgent, sort, filter, page, pageSize, null);
        Type localVarReturnType = new TypeToken<TrackingBrowserStatsListRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Provides browser tracking data
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
        <tr><td> 200 </td><td> Contains a list of aggregated browser tracking data </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call trackingBrowserStatsListAsync(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback<TrackingBrowserStatsListRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = trackingBrowserStatsListValidateBeforeCall(granularity, remoteAddress, userAgent, sort, filter, page, pageSize, _callback);
        Type localVarReturnType = new TypeToken<TrackingBrowserStatsListRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for trackingDetailedStatsList
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
        <tr><td> 200 </td><td> Contains a list of all tracking data </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call trackingDetailedStatsListCall(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/tracking/stats/detailed";

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
    private okhttp3.Call trackingDetailedStatsListValidateBeforeCall(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'granularity' is set
        if (granularity == null) {
            throw new ApiException("Missing the required parameter 'granularity' when calling trackingDetailedStatsList(Async)");
        }

        return trackingDetailedStatsListCall(granularity, remoteAddress, userAgent, sort, filter, page, pageSize, _callback);

    }

    /**
     * 
     * Provides detailed tracking data
     * @param granularity Data granularity (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return TrackingDetailedStatsListRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains a list of all tracking data </td><td>  -  </td></tr>
     </table>
     */
    public TrackingDetailedStatsListRsp trackingDetailedStatsList(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<TrackingDetailedStatsListRsp> localVarResp = trackingDetailedStatsListWithHttpInfo(granularity, remoteAddress, userAgent, sort, filter, page, pageSize);
        return localVarResp.getData();
    }

    /**
     * 
     * Provides detailed tracking data
     * @param granularity Data granularity (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return ApiResponse&lt;TrackingDetailedStatsListRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains a list of all tracking data </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<TrackingDetailedStatsListRsp> trackingDetailedStatsListWithHttpInfo(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        okhttp3.Call localVarCall = trackingDetailedStatsListValidateBeforeCall(granularity, remoteAddress, userAgent, sort, filter, page, pageSize, null);
        Type localVarReturnType = new TypeToken<TrackingDetailedStatsListRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Provides detailed tracking data
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
        <tr><td> 200 </td><td> Contains a list of all tracking data </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call trackingDetailedStatsListAsync(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback<TrackingDetailedStatsListRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = trackingDetailedStatsListValidateBeforeCall(granularity, remoteAddress, userAgent, sort, filter, page, pageSize, _callback);
        Type localVarReturnType = new TypeToken<TrackingDetailedStatsListRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for trackingEnumsGet
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains tracking enum values </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call trackingEnumsGetCall(String remoteAddress, String userAgent, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/tracking/enums";

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
    private okhttp3.Call trackingEnumsGetValidateBeforeCall(String remoteAddress, String userAgent, final ApiCallback _callback) throws ApiException {
        return trackingEnumsGetCall(remoteAddress, userAgent, _callback);

    }

    /**
     * 
     * Provides tracking enum values
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @return TrackingEnumsGetRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains tracking enum values </td><td>  -  </td></tr>
     </table>
     */
    public TrackingEnumsGetRsp trackingEnumsGet(String remoteAddress, String userAgent) throws ApiException {
        ApiResponse<TrackingEnumsGetRsp> localVarResp = trackingEnumsGetWithHttpInfo(remoteAddress, userAgent);
        return localVarResp.getData();
    }

    /**
     * 
     * Provides tracking enum values
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @return ApiResponse&lt;TrackingEnumsGetRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains tracking enum values </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<TrackingEnumsGetRsp> trackingEnumsGetWithHttpInfo(String remoteAddress, String userAgent) throws ApiException {
        okhttp3.Call localVarCall = trackingEnumsGetValidateBeforeCall(remoteAddress, userAgent, null);
        Type localVarReturnType = new TypeToken<TrackingEnumsGetRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Provides tracking enum values
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains tracking enum values </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call trackingEnumsGetAsync(String remoteAddress, String userAgent, final ApiCallback<TrackingEnumsGetRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = trackingEnumsGetValidateBeforeCall(remoteAddress, userAgent, _callback);
        Type localVarReturnType = new TypeToken<TrackingEnumsGetRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for trackingOSDetailedStatsList
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
        <tr><td> 200 </td><td> Contains a list of all OS tracking data </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call trackingOSDetailedStatsListCall(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/tracking/os/stats/detailed";

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
    private okhttp3.Call trackingOSDetailedStatsListValidateBeforeCall(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'granularity' is set
        if (granularity == null) {
            throw new ApiException("Missing the required parameter 'granularity' when calling trackingOSDetailedStatsList(Async)");
        }

        return trackingOSDetailedStatsListCall(granularity, remoteAddress, userAgent, sort, filter, page, pageSize, _callback);

    }

    /**
     * 
     * Provides detailed OS tracking data
     * @param granularity Data granularity (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return TrackingOSDetailedStatsListRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains a list of all OS tracking data </td><td>  -  </td></tr>
     </table>
     */
    public TrackingOSDetailedStatsListRsp trackingOSDetailedStatsList(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<TrackingOSDetailedStatsListRsp> localVarResp = trackingOSDetailedStatsListWithHttpInfo(granularity, remoteAddress, userAgent, sort, filter, page, pageSize);
        return localVarResp.getData();
    }

    /**
     * 
     * Provides detailed OS tracking data
     * @param granularity Data granularity (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return ApiResponse&lt;TrackingOSDetailedStatsListRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains a list of all OS tracking data </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<TrackingOSDetailedStatsListRsp> trackingOSDetailedStatsListWithHttpInfo(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        okhttp3.Call localVarCall = trackingOSDetailedStatsListValidateBeforeCall(granularity, remoteAddress, userAgent, sort, filter, page, pageSize, null);
        Type localVarReturnType = new TypeToken<TrackingOSDetailedStatsListRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Provides detailed OS tracking data
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
        <tr><td> 200 </td><td> Contains a list of all OS tracking data </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call trackingOSDetailedStatsListAsync(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback<TrackingOSDetailedStatsListRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = trackingOSDetailedStatsListValidateBeforeCall(granularity, remoteAddress, userAgent, sort, filter, page, pageSize, _callback);
        Type localVarReturnType = new TypeToken<TrackingOSDetailedStatsListRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for trackingOSStatsList
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
        <tr><td> 200 </td><td> Contains a list of aggregated OS tracking data </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call trackingOSStatsListCall(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/tracking/os/stats";

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
    private okhttp3.Call trackingOSStatsListValidateBeforeCall(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'granularity' is set
        if (granularity == null) {
            throw new ApiException("Missing the required parameter 'granularity' when calling trackingOSStatsList(Async)");
        }

        return trackingOSStatsListCall(granularity, remoteAddress, userAgent, sort, filter, page, pageSize, _callback);

    }

    /**
     * 
     * Provides os tracking data
     * @param granularity Data granularity (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return TrackingOSStatsListRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains a list of aggregated OS tracking data </td><td>  -  </td></tr>
     </table>
     */
    public TrackingOSStatsListRsp trackingOSStatsList(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<TrackingOSStatsListRsp> localVarResp = trackingOSStatsListWithHttpInfo(granularity, remoteAddress, userAgent, sort, filter, page, pageSize);
        return localVarResp.getData();
    }

    /**
     * 
     * Provides os tracking data
     * @param granularity Data granularity (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return ApiResponse&lt;TrackingOSStatsListRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains a list of aggregated OS tracking data </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<TrackingOSStatsListRsp> trackingOSStatsListWithHttpInfo(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        okhttp3.Call localVarCall = trackingOSStatsListValidateBeforeCall(granularity, remoteAddress, userAgent, sort, filter, page, pageSize, null);
        Type localVarReturnType = new TypeToken<TrackingOSStatsListRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Provides os tracking data
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
        <tr><td> 200 </td><td> Contains a list of aggregated OS tracking data </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call trackingOSStatsListAsync(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback<TrackingOSStatsListRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = trackingOSStatsListValidateBeforeCall(granularity, remoteAddress, userAgent, sort, filter, page, pageSize, _callback);
        Type localVarReturnType = new TypeToken<TrackingOSStatsListRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for trackingStatsList
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
        <tr><td> 200 </td><td> Contains a list of all aggregated statistics for tracking data </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call trackingStatsListCall(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/tracking/stats";

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
    private okhttp3.Call trackingStatsListValidateBeforeCall(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'granularity' is set
        if (granularity == null) {
            throw new ApiException("Missing the required parameter 'granularity' when calling trackingStatsList(Async)");
        }

        return trackingStatsListCall(granularity, remoteAddress, userAgent, sort, filter, page, pageSize, _callback);

    }

    /**
     * 
     * Provides aggregated statstics for project&#39;s passkeys tracking data
     * @param granularity Data granularity (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return TrackingStatsListRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains a list of all aggregated statistics for tracking data </td><td>  -  </td></tr>
     </table>
     */
    public TrackingStatsListRsp trackingStatsList(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<TrackingStatsListRsp> localVarResp = trackingStatsListWithHttpInfo(granularity, remoteAddress, userAgent, sort, filter, page, pageSize);
        return localVarResp.getData();
    }

    /**
     * 
     * Provides aggregated statstics for project&#39;s passkeys tracking data
     * @param granularity Data granularity (required)
     * @param remoteAddress Client&#39;s remote address (optional)
     * @param userAgent Client&#39;s user agent (optional)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return ApiResponse&lt;TrackingStatsListRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contains a list of all aggregated statistics for tracking data </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<TrackingStatsListRsp> trackingStatsListWithHttpInfo(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        okhttp3.Call localVarCall = trackingStatsListValidateBeforeCall(granularity, remoteAddress, userAgent, sort, filter, page, pageSize, null);
        Type localVarReturnType = new TypeToken<TrackingStatsListRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Provides aggregated statstics for project&#39;s passkeys tracking data
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
        <tr><td> 200 </td><td> Contains a list of all aggregated statistics for tracking data </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call trackingStatsListAsync(String granularity, String remoteAddress, String userAgent, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback<TrackingStatsListRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = trackingStatsListValidateBeforeCall(granularity, remoteAddress, userAgent, sort, filter, page, pageSize, _callback);
        Type localVarReturnType = new TypeToken<TrackingStatsListRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
