/*
 * Corbado Backend API
 *  # Introduction This documentation gives an overview of all Corbado Backend API calls to implement passwordless authentication with Passkeys. 
 *
 * The version of the OpenAPI document: 2.0.0
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
import com.corbado.generated.model.LongSession;
import com.corbado.generated.model.LongSessionCreateReq;
import com.corbado.generated.model.LongSessionUpdateReq;
import com.corbado.generated.model.ShortSession;
import com.corbado.generated.model.ShortSessionCreateReq;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SessionsApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public SessionsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public SessionsApi(ApiClient apiClient) {
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
     * Build call for longSessionCreate
     * @param userID ID of user (required)
     * @param longSessionCreateReq  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Long session has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call longSessionCreateCall(String userID, LongSessionCreateReq longSessionCreateReq, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = longSessionCreateReq;

        // create path and map variables
        String localVarPath = "/users/{userID}/longSessions"
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

        String[] localVarAuthNames = new String[] { "basicAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call longSessionCreateValidateBeforeCall(String userID, LongSessionCreateReq longSessionCreateReq, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'userID' is set
        if (userID == null) {
            throw new ApiException("Missing the required parameter 'userID' when calling longSessionCreate(Async)");
        }

        return longSessionCreateCall(userID, longSessionCreateReq, _callback);

    }

    /**
     * 
     * Create a new long session
     * @param userID ID of user (required)
     * @param longSessionCreateReq  (optional)
     * @return LongSession
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Long session has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public LongSession longSessionCreate(String userID, LongSessionCreateReq longSessionCreateReq) throws ApiException {
        ApiResponse<LongSession> localVarResp = longSessionCreateWithHttpInfo(userID, longSessionCreateReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Create a new long session
     * @param userID ID of user (required)
     * @param longSessionCreateReq  (optional)
     * @return ApiResponse&lt;LongSession&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Long session has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<LongSession> longSessionCreateWithHttpInfo(String userID, LongSessionCreateReq longSessionCreateReq) throws ApiException {
        okhttp3.Call localVarCall = longSessionCreateValidateBeforeCall(userID, longSessionCreateReq, null);
        Type localVarReturnType = new TypeToken<LongSession>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Create a new long session
     * @param userID ID of user (required)
     * @param longSessionCreateReq  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Long session has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call longSessionCreateAsync(String userID, LongSessionCreateReq longSessionCreateReq, final ApiCallback<LongSession> _callback) throws ApiException {

        okhttp3.Call localVarCall = longSessionCreateValidateBeforeCall(userID, longSessionCreateReq, _callback);
        Type localVarReturnType = new TypeToken<LongSession>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for longSessionGet
     * @param longSessionID ID of long session (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Long session has been returned </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call longSessionGetCall(String longSessionID, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/longSessions/{longSessionID}"
            .replace("{" + "longSessionID" + "}", localVarApiClient.escapeString(longSessionID.toString()));

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

        String[] localVarAuthNames = new String[] { "basicAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call longSessionGetValidateBeforeCall(String longSessionID, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'longSessionID' is set
        if (longSessionID == null) {
            throw new ApiException("Missing the required parameter 'longSessionID' when calling longSessionGet(Async)");
        }

        return longSessionGetCall(longSessionID, _callback);

    }

    /**
     * 
     * Retrieves a long session by ID
     * @param longSessionID ID of long session (required)
     * @return LongSession
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Long session has been returned </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public LongSession longSessionGet(String longSessionID) throws ApiException {
        ApiResponse<LongSession> localVarResp = longSessionGetWithHttpInfo(longSessionID);
        return localVarResp.getData();
    }

    /**
     * 
     * Retrieves a long session by ID
     * @param longSessionID ID of long session (required)
     * @return ApiResponse&lt;LongSession&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Long session has been returned </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<LongSession> longSessionGetWithHttpInfo(String longSessionID) throws ApiException {
        okhttp3.Call localVarCall = longSessionGetValidateBeforeCall(longSessionID, null);
        Type localVarReturnType = new TypeToken<LongSession>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Retrieves a long session by ID
     * @param longSessionID ID of long session (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Long session has been returned </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call longSessionGetAsync(String longSessionID, final ApiCallback<LongSession> _callback) throws ApiException {

        okhttp3.Call localVarCall = longSessionGetValidateBeforeCall(longSessionID, _callback);
        Type localVarReturnType = new TypeToken<LongSession>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for longSessionUpdate
     * @param userID ID of user (required)
     * @param longSessionID ID of long session (required)
     * @param longSessionUpdateReq  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Long session has been updated </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call longSessionUpdateCall(String userID, String longSessionID, LongSessionUpdateReq longSessionUpdateReq, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = longSessionUpdateReq;

        // create path and map variables
        String localVarPath = "/users/{userID}/longSessions/{longSessionID}"
            .replace("{" + "userID" + "}", localVarApiClient.escapeString(userID.toString()))
            .replace("{" + "longSessionID" + "}", localVarApiClient.escapeString(longSessionID.toString()));

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

        String[] localVarAuthNames = new String[] { "basicAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call longSessionUpdateValidateBeforeCall(String userID, String longSessionID, LongSessionUpdateReq longSessionUpdateReq, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'userID' is set
        if (userID == null) {
            throw new ApiException("Missing the required parameter 'userID' when calling longSessionUpdate(Async)");
        }

        // verify the required parameter 'longSessionID' is set
        if (longSessionID == null) {
            throw new ApiException("Missing the required parameter 'longSessionID' when calling longSessionUpdate(Async)");
        }

        return longSessionUpdateCall(userID, longSessionID, longSessionUpdateReq, _callback);

    }

    /**
     * 
     * Updates long session status
     * @param userID ID of user (required)
     * @param longSessionID ID of long session (required)
     * @param longSessionUpdateReq  (optional)
     * @return LongSession
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Long session has been updated </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public LongSession longSessionUpdate(String userID, String longSessionID, LongSessionUpdateReq longSessionUpdateReq) throws ApiException {
        ApiResponse<LongSession> localVarResp = longSessionUpdateWithHttpInfo(userID, longSessionID, longSessionUpdateReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Updates long session status
     * @param userID ID of user (required)
     * @param longSessionID ID of long session (required)
     * @param longSessionUpdateReq  (optional)
     * @return ApiResponse&lt;LongSession&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Long session has been updated </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<LongSession> longSessionUpdateWithHttpInfo(String userID, String longSessionID, LongSessionUpdateReq longSessionUpdateReq) throws ApiException {
        okhttp3.Call localVarCall = longSessionUpdateValidateBeforeCall(userID, longSessionID, longSessionUpdateReq, null);
        Type localVarReturnType = new TypeToken<LongSession>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Updates long session status
     * @param userID ID of user (required)
     * @param longSessionID ID of long session (required)
     * @param longSessionUpdateReq  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Long session has been updated </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call longSessionUpdateAsync(String userID, String longSessionID, LongSessionUpdateReq longSessionUpdateReq, final ApiCallback<LongSession> _callback) throws ApiException {

        okhttp3.Call localVarCall = longSessionUpdateValidateBeforeCall(userID, longSessionID, longSessionUpdateReq, _callback);
        Type localVarReturnType = new TypeToken<LongSession>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for shortSessionCreate
     * @param userID ID of user (required)
     * @param longSessionID ID of long session (required)
     * @param shortSessionCreateReq  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Short session has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call shortSessionCreateCall(String userID, String longSessionID, ShortSessionCreateReq shortSessionCreateReq, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = shortSessionCreateReq;

        // create path and map variables
        String localVarPath = "/users/{userID}/longSessions/{longSessionID}/shortSessions"
            .replace("{" + "userID" + "}", localVarApiClient.escapeString(userID.toString()))
            .replace("{" + "longSessionID" + "}", localVarApiClient.escapeString(longSessionID.toString()));

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

        String[] localVarAuthNames = new String[] { "basicAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call shortSessionCreateValidateBeforeCall(String userID, String longSessionID, ShortSessionCreateReq shortSessionCreateReq, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'userID' is set
        if (userID == null) {
            throw new ApiException("Missing the required parameter 'userID' when calling shortSessionCreate(Async)");
        }

        // verify the required parameter 'longSessionID' is set
        if (longSessionID == null) {
            throw new ApiException("Missing the required parameter 'longSessionID' when calling shortSessionCreate(Async)");
        }

        return shortSessionCreateCall(userID, longSessionID, shortSessionCreateReq, _callback);

    }

    /**
     * 
     * Create a new short session
     * @param userID ID of user (required)
     * @param longSessionID ID of long session (required)
     * @param shortSessionCreateReq  (optional)
     * @return ShortSession
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Short session has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ShortSession shortSessionCreate(String userID, String longSessionID, ShortSessionCreateReq shortSessionCreateReq) throws ApiException {
        ApiResponse<ShortSession> localVarResp = shortSessionCreateWithHttpInfo(userID, longSessionID, shortSessionCreateReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Create a new short session
     * @param userID ID of user (required)
     * @param longSessionID ID of long session (required)
     * @param shortSessionCreateReq  (optional)
     * @return ApiResponse&lt;ShortSession&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Short session has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ShortSession> shortSessionCreateWithHttpInfo(String userID, String longSessionID, ShortSessionCreateReq shortSessionCreateReq) throws ApiException {
        okhttp3.Call localVarCall = shortSessionCreateValidateBeforeCall(userID, longSessionID, shortSessionCreateReq, null);
        Type localVarReturnType = new TypeToken<ShortSession>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Create a new short session
     * @param userID ID of user (required)
     * @param longSessionID ID of long session (required)
     * @param shortSessionCreateReq  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Short session has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call shortSessionCreateAsync(String userID, String longSessionID, ShortSessionCreateReq shortSessionCreateReq, final ApiCallback<ShortSession> _callback) throws ApiException {

        okhttp3.Call localVarCall = shortSessionCreateValidateBeforeCall(userID, longSessionID, shortSessionCreateReq, _callback);
        Type localVarReturnType = new TypeToken<ShortSession>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for userLongSessionGet
     * @param userID ID of user (required)
     * @param longSessionID ID of long session (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Long session has been returned </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userLongSessionGetCall(String userID, String longSessionID, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/users/{userID}/longSessions/{longSessionID}"
            .replace("{" + "userID" + "}", localVarApiClient.escapeString(userID.toString()))
            .replace("{" + "longSessionID" + "}", localVarApiClient.escapeString(longSessionID.toString()));

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

        String[] localVarAuthNames = new String[] { "basicAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call userLongSessionGetValidateBeforeCall(String userID, String longSessionID, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'userID' is set
        if (userID == null) {
            throw new ApiException("Missing the required parameter 'userID' when calling userLongSessionGet(Async)");
        }

        // verify the required parameter 'longSessionID' is set
        if (longSessionID == null) {
            throw new ApiException("Missing the required parameter 'longSessionID' when calling userLongSessionGet(Async)");
        }

        return userLongSessionGetCall(userID, longSessionID, _callback);

    }

    /**
     * 
     * Retrieves a long session by ID and user ID
     * @param userID ID of user (required)
     * @param longSessionID ID of long session (required)
     * @return LongSession
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Long session has been returned </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public LongSession userLongSessionGet(String userID, String longSessionID) throws ApiException {
        ApiResponse<LongSession> localVarResp = userLongSessionGetWithHttpInfo(userID, longSessionID);
        return localVarResp.getData();
    }

    /**
     * 
     * Retrieves a long session by ID and user ID
     * @param userID ID of user (required)
     * @param longSessionID ID of long session (required)
     * @return ApiResponse&lt;LongSession&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Long session has been returned </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<LongSession> userLongSessionGetWithHttpInfo(String userID, String longSessionID) throws ApiException {
        okhttp3.Call localVarCall = userLongSessionGetValidateBeforeCall(userID, longSessionID, null);
        Type localVarReturnType = new TypeToken<LongSession>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Retrieves a long session by ID and user ID
     * @param userID ID of user (required)
     * @param longSessionID ID of long session (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Long session has been returned </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userLongSessionGetAsync(String userID, String longSessionID, final ApiCallback<LongSession> _callback) throws ApiException {

        okhttp3.Call localVarCall = userLongSessionGetValidateBeforeCall(userID, longSessionID, _callback);
        Type localVarReturnType = new TypeToken<LongSession>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
