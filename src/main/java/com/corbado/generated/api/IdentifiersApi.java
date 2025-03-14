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
import com.corbado.generated.model.Identifier;
import com.corbado.generated.model.IdentifierCreateReq;
import com.corbado.generated.model.IdentifierList;
import com.corbado.generated.model.IdentifierUpdateReq;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IdentifiersApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public IdentifiersApi() {
        this(Configuration.getDefaultApiClient());
    }

    public IdentifiersApi(ApiClient apiClient) {
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
     * Build call for identifierCreate
     * @param userID ID of user (required)
     * @param identifierCreateReq  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Identifier has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call identifierCreateCall(String userID, IdentifierCreateReq identifierCreateReq, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = identifierCreateReq;

        // create path and map variables
        String localVarPath = "/users/{userID}/identifiers"
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
    private okhttp3.Call identifierCreateValidateBeforeCall(String userID, IdentifierCreateReq identifierCreateReq, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'userID' is set
        if (userID == null) {
            throw new ApiException("Missing the required parameter 'userID' when calling identifierCreate(Async)");
        }

        // verify the required parameter 'identifierCreateReq' is set
        if (identifierCreateReq == null) {
            throw new ApiException("Missing the required parameter 'identifierCreateReq' when calling identifierCreate(Async)");
        }

        return identifierCreateCall(userID, identifierCreateReq, _callback);

    }

    /**
     * 
     * Create a new login identifier
     * @param userID ID of user (required)
     * @param identifierCreateReq  (required)
     * @return Identifier
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Identifier has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public Identifier identifierCreate(String userID, IdentifierCreateReq identifierCreateReq) throws ApiException {
        ApiResponse<Identifier> localVarResp = identifierCreateWithHttpInfo(userID, identifierCreateReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Create a new login identifier
     * @param userID ID of user (required)
     * @param identifierCreateReq  (required)
     * @return ApiResponse&lt;Identifier&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Identifier has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Identifier> identifierCreateWithHttpInfo(String userID, IdentifierCreateReq identifierCreateReq) throws ApiException {
        okhttp3.Call localVarCall = identifierCreateValidateBeforeCall(userID, identifierCreateReq, null);
        Type localVarReturnType = new TypeToken<Identifier>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Create a new login identifier
     * @param userID ID of user (required)
     * @param identifierCreateReq  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Identifier has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call identifierCreateAsync(String userID, IdentifierCreateReq identifierCreateReq, final ApiCallback<Identifier> _callback) throws ApiException {

        okhttp3.Call localVarCall = identifierCreateValidateBeforeCall(userID, identifierCreateReq, _callback);
        Type localVarReturnType = new TypeToken<Identifier>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for identifierDelete
     * @param userID ID of user (required)
     * @param identifierID ID of login identifier (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Operation succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call identifierDeleteCall(String userID, String identifierID, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/users/{userID}/identifiers/{identifierID}"
            .replace("{" + "userID" + "}", localVarApiClient.escapeString(userID.toString()))
            .replace("{" + "identifierID" + "}", localVarApiClient.escapeString(identifierID.toString()));

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
    private okhttp3.Call identifierDeleteValidateBeforeCall(String userID, String identifierID, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'userID' is set
        if (userID == null) {
            throw new ApiException("Missing the required parameter 'userID' when calling identifierDelete(Async)");
        }

        // verify the required parameter 'identifierID' is set
        if (identifierID == null) {
            throw new ApiException("Missing the required parameter 'identifierID' when calling identifierDelete(Async)");
        }

        return identifierDeleteCall(userID, identifierID, _callback);

    }

    /**
     * 
     * Delete an existing login identifier
     * @param userID ID of user (required)
     * @param identifierID ID of login identifier (required)
     * @return GenericRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Operation succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public GenericRsp identifierDelete(String userID, String identifierID) throws ApiException {
        ApiResponse<GenericRsp> localVarResp = identifierDeleteWithHttpInfo(userID, identifierID);
        return localVarResp.getData();
    }

    /**
     * 
     * Delete an existing login identifier
     * @param userID ID of user (required)
     * @param identifierID ID of login identifier (required)
     * @return ApiResponse&lt;GenericRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Operation succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<GenericRsp> identifierDeleteWithHttpInfo(String userID, String identifierID) throws ApiException {
        okhttp3.Call localVarCall = identifierDeleteValidateBeforeCall(userID, identifierID, null);
        Type localVarReturnType = new TypeToken<GenericRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Delete an existing login identifier
     * @param userID ID of user (required)
     * @param identifierID ID of login identifier (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Operation succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call identifierDeleteAsync(String userID, String identifierID, final ApiCallback<GenericRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = identifierDeleteValidateBeforeCall(userID, identifierID, _callback);
        Type localVarReturnType = new TypeToken<GenericRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for identifierList
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List of all matching identifiers </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call identifierListCall(String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/identifiers";

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
    private okhttp3.Call identifierListValidateBeforeCall(String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {
        return identifierListCall(sort, filter, page, pageSize, _callback);

    }

    /**
     * 
     * Returns a list of matching identifiers
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return IdentifierList
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List of all matching identifiers </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public IdentifierList identifierList(String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<IdentifierList> localVarResp = identifierListWithHttpInfo(sort, filter, page, pageSize);
        return localVarResp.getData();
    }

    /**
     * 
     * Returns a list of matching identifiers
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @return ApiResponse&lt;IdentifierList&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List of all matching identifiers </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<IdentifierList> identifierListWithHttpInfo(String sort, List<String> filter, Integer page, Integer pageSize) throws ApiException {
        okhttp3.Call localVarCall = identifierListValidateBeforeCall(sort, filter, page, pageSize, null);
        Type localVarReturnType = new TypeToken<IdentifierList>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Returns a list of matching identifiers
     * @param sort Field sorting (optional)
     * @param filter Field filtering (optional)
     * @param page Page number (optional, default to 1)
     * @param pageSize Number of items per page (optional, default to 10)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List of all matching identifiers </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call identifierListAsync(String sort, List<String> filter, Integer page, Integer pageSize, final ApiCallback<IdentifierList> _callback) throws ApiException {

        okhttp3.Call localVarCall = identifierListValidateBeforeCall(sort, filter, page, pageSize, _callback);
        Type localVarReturnType = new TypeToken<IdentifierList>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for identifierUpdate
     * @param userID ID of user (required)
     * @param identifierID ID of login identifier (required)
     * @param identifierUpdateReq  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Identifier has been updated </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call identifierUpdateCall(String userID, String identifierID, IdentifierUpdateReq identifierUpdateReq, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = identifierUpdateReq;

        // create path and map variables
        String localVarPath = "/users/{userID}/identifiers/{identifierID}"
            .replace("{" + "userID" + "}", localVarApiClient.escapeString(userID.toString()))
            .replace("{" + "identifierID" + "}", localVarApiClient.escapeString(identifierID.toString()));

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
    private okhttp3.Call identifierUpdateValidateBeforeCall(String userID, String identifierID, IdentifierUpdateReq identifierUpdateReq, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'userID' is set
        if (userID == null) {
            throw new ApiException("Missing the required parameter 'userID' when calling identifierUpdate(Async)");
        }

        // verify the required parameter 'identifierID' is set
        if (identifierID == null) {
            throw new ApiException("Missing the required parameter 'identifierID' when calling identifierUpdate(Async)");
        }

        // verify the required parameter 'identifierUpdateReq' is set
        if (identifierUpdateReq == null) {
            throw new ApiException("Missing the required parameter 'identifierUpdateReq' when calling identifierUpdate(Async)");
        }

        return identifierUpdateCall(userID, identifierID, identifierUpdateReq, _callback);

    }

    /**
     * 
     * Updates a login identifier (e.g. from pending to verified)
     * @param userID ID of user (required)
     * @param identifierID ID of login identifier (required)
     * @param identifierUpdateReq  (required)
     * @return Identifier
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Identifier has been updated </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public Identifier identifierUpdate(String userID, String identifierID, IdentifierUpdateReq identifierUpdateReq) throws ApiException {
        ApiResponse<Identifier> localVarResp = identifierUpdateWithHttpInfo(userID, identifierID, identifierUpdateReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Updates a login identifier (e.g. from pending to verified)
     * @param userID ID of user (required)
     * @param identifierID ID of login identifier (required)
     * @param identifierUpdateReq  (required)
     * @return ApiResponse&lt;Identifier&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Identifier has been updated </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Identifier> identifierUpdateWithHttpInfo(String userID, String identifierID, IdentifierUpdateReq identifierUpdateReq) throws ApiException {
        okhttp3.Call localVarCall = identifierUpdateValidateBeforeCall(userID, identifierID, identifierUpdateReq, null);
        Type localVarReturnType = new TypeToken<Identifier>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Updates a login identifier (e.g. from pending to verified)
     * @param userID ID of user (required)
     * @param identifierID ID of login identifier (required)
     * @param identifierUpdateReq  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Identifier has been updated </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call identifierUpdateAsync(String userID, String identifierID, IdentifierUpdateReq identifierUpdateReq, final ApiCallback<Identifier> _callback) throws ApiException {

        okhttp3.Call localVarCall = identifierUpdateValidateBeforeCall(userID, identifierID, identifierUpdateReq, _callback);
        Type localVarReturnType = new TypeToken<Identifier>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
