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
import com.corbado.generated.model.GenericRsp;
import com.corbado.generated.model.PasskeyEvent;
import com.corbado.generated.model.PasskeyEventCreateReq;
import com.corbado.generated.model.PasskeyEventList;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PasskeyEventsApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public PasskeyEventsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public PasskeyEventsApi(ApiClient apiClient) {
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
     * Build call for passkeyEventCreate
     * @param userID ID of user (required)
     * @param passkeyEventCreateReq  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkey event has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call passkeyEventCreateCall(String userID, PasskeyEventCreateReq passkeyEventCreateReq, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = passkeyEventCreateReq;

        // create path and map variables
        String localVarPath = "/users/{userID}/passkeyEvents"
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
    private okhttp3.Call passkeyEventCreateValidateBeforeCall(String userID, PasskeyEventCreateReq passkeyEventCreateReq, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'userID' is set
        if (userID == null) {
            throw new ApiException("Missing the required parameter 'userID' when calling passkeyEventCreate(Async)");
        }

        // verify the required parameter 'passkeyEventCreateReq' is set
        if (passkeyEventCreateReq == null) {
            throw new ApiException("Missing the required parameter 'passkeyEventCreateReq' when calling passkeyEventCreate(Async)");
        }

        return passkeyEventCreateCall(userID, passkeyEventCreateReq, _callback);

    }

    /**
     * 
     * Create a new passkey event for a user
     * @param userID ID of user (required)
     * @param passkeyEventCreateReq  (required)
     * @return PasskeyEvent
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkey event has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public PasskeyEvent passkeyEventCreate(String userID, PasskeyEventCreateReq passkeyEventCreateReq) throws ApiException {
        ApiResponse<PasskeyEvent> localVarResp = passkeyEventCreateWithHttpInfo(userID, passkeyEventCreateReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Create a new passkey event for a user
     * @param userID ID of user (required)
     * @param passkeyEventCreateReq  (required)
     * @return ApiResponse&lt;PasskeyEvent&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkey event has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<PasskeyEvent> passkeyEventCreateWithHttpInfo(String userID, PasskeyEventCreateReq passkeyEventCreateReq) throws ApiException {
        okhttp3.Call localVarCall = passkeyEventCreateValidateBeforeCall(userID, passkeyEventCreateReq, null);
        Type localVarReturnType = new TypeToken<PasskeyEvent>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Create a new passkey event for a user
     * @param userID ID of user (required)
     * @param passkeyEventCreateReq  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkey event has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call passkeyEventCreateAsync(String userID, PasskeyEventCreateReq passkeyEventCreateReq, final ApiCallback<PasskeyEvent> _callback) throws ApiException {

        okhttp3.Call localVarCall = passkeyEventCreateValidateBeforeCall(userID, passkeyEventCreateReq, _callback);
        Type localVarReturnType = new TypeToken<PasskeyEvent>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for passkeyEventDelete
     * @param userID ID of user (required)
     * @param passkeyEventID ID of a passkey event (required)
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
    public okhttp3.Call passkeyEventDeleteCall(String userID, String passkeyEventID, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/users/{userID}/passkeyEvents/{passkeyEventID}"
            .replace("{" + "userID" + "}", localVarApiClient.escapeString(userID.toString()))
            .replace("{" + "passkeyEventID" + "}", localVarApiClient.escapeString(passkeyEventID.toString()));

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
        return localVarApiClient.buildCall(basePath, localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call passkeyEventDeleteValidateBeforeCall(String userID, String passkeyEventID, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'userID' is set
        if (userID == null) {
            throw new ApiException("Missing the required parameter 'userID' when calling passkeyEventDelete(Async)");
        }

        // verify the required parameter 'passkeyEventID' is set
        if (passkeyEventID == null) {
            throw new ApiException("Missing the required parameter 'passkeyEventID' when calling passkeyEventDelete(Async)");
        }

        return passkeyEventDeleteCall(userID, passkeyEventID, _callback);

    }

    /**
     * 
     * Deletes an existing passkey event
     * @param userID ID of user (required)
     * @param passkeyEventID ID of a passkey event (required)
     * @return GenericRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Operation succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public GenericRsp passkeyEventDelete(String userID, String passkeyEventID) throws ApiException {
        ApiResponse<GenericRsp> localVarResp = passkeyEventDeleteWithHttpInfo(userID, passkeyEventID);
        return localVarResp.getData();
    }

    /**
     * 
     * Deletes an existing passkey event
     * @param userID ID of user (required)
     * @param passkeyEventID ID of a passkey event (required)
     * @return ApiResponse&lt;GenericRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Operation succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<GenericRsp> passkeyEventDeleteWithHttpInfo(String userID, String passkeyEventID) throws ApiException {
        okhttp3.Call localVarCall = passkeyEventDeleteValidateBeforeCall(userID, passkeyEventID, null);
        Type localVarReturnType = new TypeToken<GenericRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Deletes an existing passkey event
     * @param userID ID of user (required)
     * @param passkeyEventID ID of a passkey event (required)
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
    public okhttp3.Call passkeyEventDeleteAsync(String userID, String passkeyEventID, final ApiCallback<GenericRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = passkeyEventDeleteValidateBeforeCall(userID, passkeyEventID, _callback);
        Type localVarReturnType = new TypeToken<GenericRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for passkeyEventList
     * @param userID ID of user (required)
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
        <tr><td> 200 </td><td> List of all matching passkey events </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call passkeyEventListCall(String userID, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/users/{userID}/passkeyEvents"
            .replace("{" + "userID" + "}", localVarApiClient.escapeString(userID.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

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

        String[] localVarAuthNames = new String[] { "basicAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call passkeyEventListValidateBeforeCall(String userID, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'userID' is set
        if (userID == null) {
            throw new ApiException("Missing the required parameter 'userID' when calling passkeyEventList(Async)");
        }

        return passkeyEventListCall(userID, sort, filter, page, pageSize, _callback);

    }

    /**
     * 
     * Returns a list of matching passkey events
     * @param userID ID of user (required)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return PasskeyEventList
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List of all matching passkey events </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public PasskeyEventList passkeyEventList(String userID, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<PasskeyEventList> localVarResp = passkeyEventListWithHttpInfo(userID, sort, filter, page, pageSize);
        return localVarResp.getData();
    }

    /**
     * 
     * Returns a list of matching passkey events
     * @param userID ID of user (required)
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return ApiResponse&lt;PasskeyEventList&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List of all matching passkey events </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<PasskeyEventList> passkeyEventListWithHttpInfo(String userID, String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        okhttp3.Call localVarCall = passkeyEventListValidateBeforeCall(userID, sort, filter, page, pageSize, null);
        Type localVarReturnType = new TypeToken<PasskeyEventList>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Returns a list of matching passkey events
     * @param userID ID of user (required)
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
        <tr><td> 200 </td><td> List of all matching passkey events </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call passkeyEventListAsync(String userID, String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback<PasskeyEventList> _callback) throws ApiException {

        okhttp3.Call localVarCall = passkeyEventListValidateBeforeCall(userID, sort, filter, page, pageSize, _callback);
        Type localVarReturnType = new TypeToken<PasskeyEventList>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
