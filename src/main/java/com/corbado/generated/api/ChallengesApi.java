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


import com.corbado.generated.model.Challenge;
import com.corbado.generated.model.ChallengeCreateReq;
import com.corbado.generated.model.ChallengeUpdateReq;
import com.corbado.generated.model.ErrorRsp;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChallengesApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public ChallengesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ChallengesApi(ApiClient apiClient) {
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
     * Build call for challengeCreate
     * @param userID ID of user (required)
     * @param challengeCreateReq  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Challenge has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call challengeCreateCall(String userID, ChallengeCreateReq challengeCreateReq, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = challengeCreateReq;

        // create path and map variables
        String localVarPath = "/users/{userID}/challenges"
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
    private okhttp3.Call challengeCreateValidateBeforeCall(String userID, ChallengeCreateReq challengeCreateReq, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'userID' is set
        if (userID == null) {
            throw new ApiException("Missing the required parameter 'userID' when calling challengeCreate(Async)");
        }

        // verify the required parameter 'challengeCreateReq' is set
        if (challengeCreateReq == null) {
            throw new ApiException("Missing the required parameter 'challengeCreateReq' when calling challengeCreate(Async)");
        }

        return challengeCreateCall(userID, challengeCreateReq, _callback);

    }

    /**
     * 
     * Create a new challenge to verify a login identifier
     * @param userID ID of user (required)
     * @param challengeCreateReq  (required)
     * @return Challenge
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Challenge has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public Challenge challengeCreate(String userID, ChallengeCreateReq challengeCreateReq) throws ApiException {
        ApiResponse<Challenge> localVarResp = challengeCreateWithHttpInfo(userID, challengeCreateReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Create a new challenge to verify a login identifier
     * @param userID ID of user (required)
     * @param challengeCreateReq  (required)
     * @return ApiResponse&lt;Challenge&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Challenge has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Challenge> challengeCreateWithHttpInfo(String userID, ChallengeCreateReq challengeCreateReq) throws ApiException {
        okhttp3.Call localVarCall = challengeCreateValidateBeforeCall(userID, challengeCreateReq, null);
        Type localVarReturnType = new TypeToken<Challenge>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Create a new challenge to verify a login identifier
     * @param userID ID of user (required)
     * @param challengeCreateReq  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Challenge has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call challengeCreateAsync(String userID, ChallengeCreateReq challengeCreateReq, final ApiCallback<Challenge> _callback) throws ApiException {

        okhttp3.Call localVarCall = challengeCreateValidateBeforeCall(userID, challengeCreateReq, _callback);
        Type localVarReturnType = new TypeToken<Challenge>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for challengeUpdate
     * @param userID ID of user (required)
     * @param challengeID ID of challenge (required)
     * @param challengeUpdateReq  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Challenge has been updated </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call challengeUpdateCall(String userID, String challengeID, ChallengeUpdateReq challengeUpdateReq, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = challengeUpdateReq;

        // create path and map variables
        String localVarPath = "/users/{userID}/challenges/{challengeID}"
            .replace("{" + "userID" + "}", localVarApiClient.escapeString(userID.toString()))
            .replace("{" + "challengeID" + "}", localVarApiClient.escapeString(challengeID.toString()));

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
    private okhttp3.Call challengeUpdateValidateBeforeCall(String userID, String challengeID, ChallengeUpdateReq challengeUpdateReq, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'userID' is set
        if (userID == null) {
            throw new ApiException("Missing the required parameter 'userID' when calling challengeUpdate(Async)");
        }

        // verify the required parameter 'challengeID' is set
        if (challengeID == null) {
            throw new ApiException("Missing the required parameter 'challengeID' when calling challengeUpdate(Async)");
        }

        // verify the required parameter 'challengeUpdateReq' is set
        if (challengeUpdateReq == null) {
            throw new ApiException("Missing the required parameter 'challengeUpdateReq' when calling challengeUpdate(Async)");
        }

        return challengeUpdateCall(userID, challengeID, challengeUpdateReq, _callback);

    }

    /**
     * 
     * Updates a challenge (e.g. from pending to completed)
     * @param userID ID of user (required)
     * @param challengeID ID of challenge (required)
     * @param challengeUpdateReq  (required)
     * @return Challenge
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Challenge has been updated </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public Challenge challengeUpdate(String userID, String challengeID, ChallengeUpdateReq challengeUpdateReq) throws ApiException {
        ApiResponse<Challenge> localVarResp = challengeUpdateWithHttpInfo(userID, challengeID, challengeUpdateReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Updates a challenge (e.g. from pending to completed)
     * @param userID ID of user (required)
     * @param challengeID ID of challenge (required)
     * @param challengeUpdateReq  (required)
     * @return ApiResponse&lt;Challenge&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Challenge has been updated </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Challenge> challengeUpdateWithHttpInfo(String userID, String challengeID, ChallengeUpdateReq challengeUpdateReq) throws ApiException {
        okhttp3.Call localVarCall = challengeUpdateValidateBeforeCall(userID, challengeID, challengeUpdateReq, null);
        Type localVarReturnType = new TypeToken<Challenge>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Updates a challenge (e.g. from pending to completed)
     * @param userID ID of user (required)
     * @param challengeID ID of challenge (required)
     * @param challengeUpdateReq  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Challenge has been updated </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call challengeUpdateAsync(String userID, String challengeID, ChallengeUpdateReq challengeUpdateReq, final ApiCallback<Challenge> _callback) throws ApiException {

        okhttp3.Call localVarCall = challengeUpdateValidateBeforeCall(userID, challengeID, challengeUpdateReq, _callback);
        Type localVarReturnType = new TypeToken<Challenge>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
