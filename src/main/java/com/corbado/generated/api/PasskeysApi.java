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
import com.corbado.generated.model.PasskeyAppendFinishReq;
import com.corbado.generated.model.PasskeyAppendFinishRsp;
import com.corbado.generated.model.PasskeyAppendStartReq;
import com.corbado.generated.model.PasskeyAppendStartRsp;
import com.corbado.generated.model.PasskeyLoginFinishReq;
import com.corbado.generated.model.PasskeyLoginFinishRsp;
import com.corbado.generated.model.PasskeyLoginStartReq;
import com.corbado.generated.model.PasskeyLoginStartRsp;
import com.corbado.generated.model.PasskeyMediationFinishReq;
import com.corbado.generated.model.PasskeyMediationFinishRsp;
import com.corbado.generated.model.PasskeyMediationStartReq;
import com.corbado.generated.model.PasskeyMediationStartRsp;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PasskeysApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public PasskeysApi() {
        this(Configuration.getDefaultApiClient());
    }

    public PasskeysApi(ApiClient apiClient) {
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
     * Build call for passkeyAppendFinish
     * @param passkeyAppendFinishReq  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkey append succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call passkeyAppendFinishCall(PasskeyAppendFinishReq passkeyAppendFinishReq, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = passkeyAppendFinishReq;

        // create path and map variables
        String localVarPath = "/passkey/append/finish";

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
    private okhttp3.Call passkeyAppendFinishValidateBeforeCall(PasskeyAppendFinishReq passkeyAppendFinishReq, final ApiCallback _callback) throws ApiException {
        return passkeyAppendFinishCall(passkeyAppendFinishReq, _callback);

    }

    /**
     * 
     * Completes a challenge for creating a new passkey
     * @param passkeyAppendFinishReq  (optional)
     * @return PasskeyAppendFinishRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkey append succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public PasskeyAppendFinishRsp passkeyAppendFinish(PasskeyAppendFinishReq passkeyAppendFinishReq) throws ApiException {
        ApiResponse<PasskeyAppendFinishRsp> localVarResp = passkeyAppendFinishWithHttpInfo(passkeyAppendFinishReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Completes a challenge for creating a new passkey
     * @param passkeyAppendFinishReq  (optional)
     * @return ApiResponse&lt;PasskeyAppendFinishRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkey append succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<PasskeyAppendFinishRsp> passkeyAppendFinishWithHttpInfo(PasskeyAppendFinishReq passkeyAppendFinishReq) throws ApiException {
        okhttp3.Call localVarCall = passkeyAppendFinishValidateBeforeCall(passkeyAppendFinishReq, null);
        Type localVarReturnType = new TypeToken<PasskeyAppendFinishRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Completes a challenge for creating a new passkey
     * @param passkeyAppendFinishReq  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkey append succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call passkeyAppendFinishAsync(PasskeyAppendFinishReq passkeyAppendFinishReq, final ApiCallback<PasskeyAppendFinishRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = passkeyAppendFinishValidateBeforeCall(passkeyAppendFinishReq, _callback);
        Type localVarReturnType = new TypeToken<PasskeyAppendFinishRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for passkeyAppendStart
     * @param passkeyAppendStartReq  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkey append challenge has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call passkeyAppendStartCall(PasskeyAppendStartReq passkeyAppendStartReq, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = passkeyAppendStartReq;

        // create path and map variables
        String localVarPath = "/passkey/append/start";

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
    private okhttp3.Call passkeyAppendStartValidateBeforeCall(PasskeyAppendStartReq passkeyAppendStartReq, final ApiCallback _callback) throws ApiException {
        return passkeyAppendStartCall(passkeyAppendStartReq, _callback);

    }

    /**
     * 
     * Starts a challenge for creating a new passkey
     * @param passkeyAppendStartReq  (optional)
     * @return PasskeyAppendStartRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkey append challenge has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public PasskeyAppendStartRsp passkeyAppendStart(PasskeyAppendStartReq passkeyAppendStartReq) throws ApiException {
        ApiResponse<PasskeyAppendStartRsp> localVarResp = passkeyAppendStartWithHttpInfo(passkeyAppendStartReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Starts a challenge for creating a new passkey
     * @param passkeyAppendStartReq  (optional)
     * @return ApiResponse&lt;PasskeyAppendStartRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkey append challenge has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<PasskeyAppendStartRsp> passkeyAppendStartWithHttpInfo(PasskeyAppendStartReq passkeyAppendStartReq) throws ApiException {
        okhttp3.Call localVarCall = passkeyAppendStartValidateBeforeCall(passkeyAppendStartReq, null);
        Type localVarReturnType = new TypeToken<PasskeyAppendStartRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Starts a challenge for creating a new passkey
     * @param passkeyAppendStartReq  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkey append challenge has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call passkeyAppendStartAsync(PasskeyAppendStartReq passkeyAppendStartReq, final ApiCallback<PasskeyAppendStartRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = passkeyAppendStartValidateBeforeCall(passkeyAppendStartReq, _callback);
        Type localVarReturnType = new TypeToken<PasskeyAppendStartRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for passkeyLoginFinish
     * @param passkeyLoginFinishReq  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkey login succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call passkeyLoginFinishCall(PasskeyLoginFinishReq passkeyLoginFinishReq, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = passkeyLoginFinishReq;

        // create path and map variables
        String localVarPath = "/passkey/login/finish";

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
    private okhttp3.Call passkeyLoginFinishValidateBeforeCall(PasskeyLoginFinishReq passkeyLoginFinishReq, final ApiCallback _callback) throws ApiException {
        return passkeyLoginFinishCall(passkeyLoginFinishReq, _callback);

    }

    /**
     * 
     * Completes a challenge for an existing passkey
     * @param passkeyLoginFinishReq  (optional)
     * @return PasskeyLoginFinishRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkey login succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public PasskeyLoginFinishRsp passkeyLoginFinish(PasskeyLoginFinishReq passkeyLoginFinishReq) throws ApiException {
        ApiResponse<PasskeyLoginFinishRsp> localVarResp = passkeyLoginFinishWithHttpInfo(passkeyLoginFinishReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Completes a challenge for an existing passkey
     * @param passkeyLoginFinishReq  (optional)
     * @return ApiResponse&lt;PasskeyLoginFinishRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkey login succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<PasskeyLoginFinishRsp> passkeyLoginFinishWithHttpInfo(PasskeyLoginFinishReq passkeyLoginFinishReq) throws ApiException {
        okhttp3.Call localVarCall = passkeyLoginFinishValidateBeforeCall(passkeyLoginFinishReq, null);
        Type localVarReturnType = new TypeToken<PasskeyLoginFinishRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Completes a challenge for an existing passkey
     * @param passkeyLoginFinishReq  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkey login succeeded </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call passkeyLoginFinishAsync(PasskeyLoginFinishReq passkeyLoginFinishReq, final ApiCallback<PasskeyLoginFinishRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = passkeyLoginFinishValidateBeforeCall(passkeyLoginFinishReq, _callback);
        Type localVarReturnType = new TypeToken<PasskeyLoginFinishRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for passkeyLoginStart
     * @param passkeyLoginStartReq  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkey login challenge has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call passkeyLoginStartCall(PasskeyLoginStartReq passkeyLoginStartReq, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = passkeyLoginStartReq;

        // create path and map variables
        String localVarPath = "/passkey/login/start";

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
    private okhttp3.Call passkeyLoginStartValidateBeforeCall(PasskeyLoginStartReq passkeyLoginStartReq, final ApiCallback _callback) throws ApiException {
        return passkeyLoginStartCall(passkeyLoginStartReq, _callback);

    }

    /**
     * 
     * Starts a challenge for an existing passkey
     * @param passkeyLoginStartReq  (optional)
     * @return PasskeyLoginStartRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkey login challenge has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public PasskeyLoginStartRsp passkeyLoginStart(PasskeyLoginStartReq passkeyLoginStartReq) throws ApiException {
        ApiResponse<PasskeyLoginStartRsp> localVarResp = passkeyLoginStartWithHttpInfo(passkeyLoginStartReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Starts a challenge for an existing passkey
     * @param passkeyLoginStartReq  (optional)
     * @return ApiResponse&lt;PasskeyLoginStartRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkey login challenge has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<PasskeyLoginStartRsp> passkeyLoginStartWithHttpInfo(PasskeyLoginStartReq passkeyLoginStartReq) throws ApiException {
        okhttp3.Call localVarCall = passkeyLoginStartValidateBeforeCall(passkeyLoginStartReq, null);
        Type localVarReturnType = new TypeToken<PasskeyLoginStartRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Starts a challenge for an existing passkey
     * @param passkeyLoginStartReq  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkey login challenge has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call passkeyLoginStartAsync(PasskeyLoginStartReq passkeyLoginStartReq, final ApiCallback<PasskeyLoginStartRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = passkeyLoginStartValidateBeforeCall(passkeyLoginStartReq, _callback);
        Type localVarReturnType = new TypeToken<PasskeyLoginStartRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for passkeyMediationFinish
     * @param passkeyMediationFinishReq  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkey mediation has been success, thus we can return a userID </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call passkeyMediationFinishCall(PasskeyMediationFinishReq passkeyMediationFinishReq, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = passkeyMediationFinishReq;

        // create path and map variables
        String localVarPath = "/passkey/mediation/finish";

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
    private okhttp3.Call passkeyMediationFinishValidateBeforeCall(PasskeyMediationFinishReq passkeyMediationFinishReq, final ApiCallback _callback) throws ApiException {
        return passkeyMediationFinishCall(passkeyMediationFinishReq, _callback);

    }

    /**
     * 
     * Completes a challenge for an existing passkey (Conditional UI)
     * @param passkeyMediationFinishReq  (optional)
     * @return PasskeyMediationFinishRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkey mediation has been success, thus we can return a userID </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public PasskeyMediationFinishRsp passkeyMediationFinish(PasskeyMediationFinishReq passkeyMediationFinishReq) throws ApiException {
        ApiResponse<PasskeyMediationFinishRsp> localVarResp = passkeyMediationFinishWithHttpInfo(passkeyMediationFinishReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Completes a challenge for an existing passkey (Conditional UI)
     * @param passkeyMediationFinishReq  (optional)
     * @return ApiResponse&lt;PasskeyMediationFinishRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkey mediation has been success, thus we can return a userID </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<PasskeyMediationFinishRsp> passkeyMediationFinishWithHttpInfo(PasskeyMediationFinishReq passkeyMediationFinishReq) throws ApiException {
        okhttp3.Call localVarCall = passkeyMediationFinishValidateBeforeCall(passkeyMediationFinishReq, null);
        Type localVarReturnType = new TypeToken<PasskeyMediationFinishRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Completes a challenge for an existing passkey (Conditional UI)
     * @param passkeyMediationFinishReq  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkey mediation has been success, thus we can return a userID </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call passkeyMediationFinishAsync(PasskeyMediationFinishReq passkeyMediationFinishReq, final ApiCallback<PasskeyMediationFinishRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = passkeyMediationFinishValidateBeforeCall(passkeyMediationFinishReq, _callback);
        Type localVarReturnType = new TypeToken<PasskeyMediationFinishRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for passkeyMediationStart
     * @param passkeyMediationStartReq  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkey login challenge has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call passkeyMediationStartCall(PasskeyMediationStartReq passkeyMediationStartReq, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = passkeyMediationStartReq;

        // create path and map variables
        String localVarPath = "/passkey/mediation/start";

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
    private okhttp3.Call passkeyMediationStartValidateBeforeCall(PasskeyMediationStartReq passkeyMediationStartReq, final ApiCallback _callback) throws ApiException {
        return passkeyMediationStartCall(passkeyMediationStartReq, _callback);

    }

    /**
     * 
     * Starts a challenge for an existing passkey (Conditional UI)
     * @param passkeyMediationStartReq  (optional)
     * @return PasskeyMediationStartRsp
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkey login challenge has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public PasskeyMediationStartRsp passkeyMediationStart(PasskeyMediationStartReq passkeyMediationStartReq) throws ApiException {
        ApiResponse<PasskeyMediationStartRsp> localVarResp = passkeyMediationStartWithHttpInfo(passkeyMediationStartReq);
        return localVarResp.getData();
    }

    /**
     * 
     * Starts a challenge for an existing passkey (Conditional UI)
     * @param passkeyMediationStartReq  (optional)
     * @return ApiResponse&lt;PasskeyMediationStartRsp&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkey login challenge has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<PasskeyMediationStartRsp> passkeyMediationStartWithHttpInfo(PasskeyMediationStartReq passkeyMediationStartReq) throws ApiException {
        okhttp3.Call localVarCall = passkeyMediationStartValidateBeforeCall(passkeyMediationStartReq, null);
        Type localVarReturnType = new TypeToken<PasskeyMediationStartRsp>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Starts a challenge for an existing passkey (Conditional UI)
     * @param passkeyMediationStartReq  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Passkey login challenge has been created </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call passkeyMediationStartAsync(PasskeyMediationStartReq passkeyMediationStartReq, final ApiCallback<PasskeyMediationStartRsp> _callback) throws ApiException {

        okhttp3.Call localVarCall = passkeyMediationStartValidateBeforeCall(passkeyMediationStartReq, _callback);
        Type localVarReturnType = new TypeToken<PasskeyMediationStartRsp>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
