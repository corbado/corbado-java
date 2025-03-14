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


package com.corbado.generated.model;

import java.util.Objects;
import com.corbado.generated.model.ConnectTokenDataPasskeyAppend;
import com.corbado.generated.model.ConnectTokenDataPasskeyDelete;
import com.corbado.generated.model.ConnectTokenDataPasskeyList;
import com.corbado.generated.model.ConnectTokenDataPasskeyLogin;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Arrays;



import java.io.IOException;
import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;

import com.corbado.generated.invoker.JSON;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-14T05:38:33.191503012Z[Etc/UTC]", comments = "Generator version: 7.13.0-SNAPSHOT")
public class ConnectTokenData extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(ConnectTokenData.class.getName());

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!ConnectTokenData.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'ConnectTokenData' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<ConnectTokenDataPasskeyAppend> adapterConnectTokenDataPasskeyAppend = gson.getDelegateAdapter(this, TypeToken.get(ConnectTokenDataPasskeyAppend.class));
            final TypeAdapter<ConnectTokenDataPasskeyDelete> adapterConnectTokenDataPasskeyDelete = gson.getDelegateAdapter(this, TypeToken.get(ConnectTokenDataPasskeyDelete.class));
            final TypeAdapter<ConnectTokenDataPasskeyList> adapterConnectTokenDataPasskeyList = gson.getDelegateAdapter(this, TypeToken.get(ConnectTokenDataPasskeyList.class));
            final TypeAdapter<ConnectTokenDataPasskeyLogin> adapterConnectTokenDataPasskeyLogin = gson.getDelegateAdapter(this, TypeToken.get(ConnectTokenDataPasskeyLogin.class));

            return (TypeAdapter<T>) new TypeAdapter<ConnectTokenData>() {
                @Override
                public void write(JsonWriter out, ConnectTokenData value) throws IOException {
                    if (value == null || value.getActualInstance() == null) {
                        elementAdapter.write(out, null);
                        return;
                    }

                    // check if the actual instance is of the type `ConnectTokenDataPasskeyAppend`
                    if (value.getActualInstance() instanceof ConnectTokenDataPasskeyAppend) {
                        JsonElement element = adapterConnectTokenDataPasskeyAppend.toJsonTree((ConnectTokenDataPasskeyAppend)value.getActualInstance());
                        elementAdapter.write(out, element);
                        return;
                    }
                    // check if the actual instance is of the type `ConnectTokenDataPasskeyDelete`
                    if (value.getActualInstance() instanceof ConnectTokenDataPasskeyDelete) {
                        JsonElement element = adapterConnectTokenDataPasskeyDelete.toJsonTree((ConnectTokenDataPasskeyDelete)value.getActualInstance());
                        elementAdapter.write(out, element);
                        return;
                    }
                    // check if the actual instance is of the type `ConnectTokenDataPasskeyList`
                    if (value.getActualInstance() instanceof ConnectTokenDataPasskeyList) {
                        JsonElement element = adapterConnectTokenDataPasskeyList.toJsonTree((ConnectTokenDataPasskeyList)value.getActualInstance());
                        elementAdapter.write(out, element);
                        return;
                    }
                    // check if the actual instance is of the type `ConnectTokenDataPasskeyLogin`
                    if (value.getActualInstance() instanceof ConnectTokenDataPasskeyLogin) {
                        JsonElement element = adapterConnectTokenDataPasskeyLogin.toJsonTree((ConnectTokenDataPasskeyLogin)value.getActualInstance());
                        elementAdapter.write(out, element);
                        return;
                    }
                    throw new IOException("Failed to serialize as the type doesn't match oneOf schemas: ConnectTokenDataPasskeyAppend, ConnectTokenDataPasskeyDelete, ConnectTokenDataPasskeyList, ConnectTokenDataPasskeyLogin");
                }

                @Override
                public ConnectTokenData read(JsonReader in) throws IOException {
                    Object deserialized = null;
                    JsonElement jsonElement = elementAdapter.read(in);

                    int match = 0;
                    ArrayList<String> errorMessages = new ArrayList<>();
                    TypeAdapter actualAdapter = elementAdapter;

                    // deserialize ConnectTokenDataPasskeyAppend
                    try {
                        // validate the JSON object to see if any exception is thrown
                        ConnectTokenDataPasskeyAppend.validateJsonElement(jsonElement);
                        actualAdapter = adapterConnectTokenDataPasskeyAppend;
                        match++;
                        log.log(Level.FINER, "Input data matches schema 'ConnectTokenDataPasskeyAppend'");
                    } catch (Exception e) {
                        // deserialization failed, continue
                        errorMessages.add(String.format("Deserialization for ConnectTokenDataPasskeyAppend failed with `%s`.", e.getMessage()));
                        log.log(Level.FINER, "Input data does not match schema 'ConnectTokenDataPasskeyAppend'", e);
                    }
                    // deserialize ConnectTokenDataPasskeyDelete
                    try {
                        // validate the JSON object to see if any exception is thrown
                        ConnectTokenDataPasskeyDelete.validateJsonElement(jsonElement);
                        actualAdapter = adapterConnectTokenDataPasskeyDelete;
                        match++;
                        log.log(Level.FINER, "Input data matches schema 'ConnectTokenDataPasskeyDelete'");
                    } catch (Exception e) {
                        // deserialization failed, continue
                        errorMessages.add(String.format("Deserialization for ConnectTokenDataPasskeyDelete failed with `%s`.", e.getMessage()));
                        log.log(Level.FINER, "Input data does not match schema 'ConnectTokenDataPasskeyDelete'", e);
                    }
                    // deserialize ConnectTokenDataPasskeyList
                    try {
                        // validate the JSON object to see if any exception is thrown
                        ConnectTokenDataPasskeyList.validateJsonElement(jsonElement);
                        actualAdapter = adapterConnectTokenDataPasskeyList;
                        match++;
                        log.log(Level.FINER, "Input data matches schema 'ConnectTokenDataPasskeyList'");
                    } catch (Exception e) {
                        // deserialization failed, continue
                        errorMessages.add(String.format("Deserialization for ConnectTokenDataPasskeyList failed with `%s`.", e.getMessage()));
                        log.log(Level.FINER, "Input data does not match schema 'ConnectTokenDataPasskeyList'", e);
                    }
                    // deserialize ConnectTokenDataPasskeyLogin
                    try {
                        // validate the JSON object to see if any exception is thrown
                        ConnectTokenDataPasskeyLogin.validateJsonElement(jsonElement);
                        actualAdapter = adapterConnectTokenDataPasskeyLogin;
                        match++;
                        log.log(Level.FINER, "Input data matches schema 'ConnectTokenDataPasskeyLogin'");
                    } catch (Exception e) {
                        // deserialization failed, continue
                        errorMessages.add(String.format("Deserialization for ConnectTokenDataPasskeyLogin failed with `%s`.", e.getMessage()));
                        log.log(Level.FINER, "Input data does not match schema 'ConnectTokenDataPasskeyLogin'", e);
                    }

                    if (match == 1) {
                        ConnectTokenData ret = new ConnectTokenData();
                        ret.setActualInstance(actualAdapter.fromJsonTree(jsonElement));
                        return ret;
                    }

                    throw new IOException(String.format("Failed deserialization for ConnectTokenData: %d classes match result, expected 1. Detailed failure message for oneOf schemas: %s. JSON: %s", match, errorMessages, jsonElement.toString()));
                }
            }.nullSafe();
        }
    }

    // store a list of schema names defined in oneOf
    public static final Map<String, Class<?>> schemas = new HashMap<String, Class<?>>();

    public ConnectTokenData() {
        super("oneOf", Boolean.FALSE);
    }

    public ConnectTokenData(Object o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("ConnectTokenDataPasskeyAppend", ConnectTokenDataPasskeyAppend.class);
        schemas.put("ConnectTokenDataPasskeyDelete", ConnectTokenDataPasskeyDelete.class);
        schemas.put("ConnectTokenDataPasskeyList", ConnectTokenDataPasskeyList.class);
        schemas.put("ConnectTokenDataPasskeyLogin", ConnectTokenDataPasskeyLogin.class);
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return ConnectTokenData.schemas;
    }

    /**
     * Set the instance that matches the oneOf child schema, check
     * the instance parameter is valid against the oneOf child schemas:
     * ConnectTokenDataPasskeyAppend, ConnectTokenDataPasskeyDelete, ConnectTokenDataPasskeyList, ConnectTokenDataPasskeyLogin
     *
     * It could be an instance of the 'oneOf' schemas.
     */
    @Override
    public void setActualInstance(Object instance) {
        if (instance instanceof ConnectTokenDataPasskeyAppend) {
            super.setActualInstance(instance);
            return;
        }

        if (instance instanceof ConnectTokenDataPasskeyDelete) {
            super.setActualInstance(instance);
            return;
        }

        if (instance instanceof ConnectTokenDataPasskeyList) {
            super.setActualInstance(instance);
            return;
        }

        if (instance instanceof ConnectTokenDataPasskeyLogin) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be ConnectTokenDataPasskeyAppend, ConnectTokenDataPasskeyDelete, ConnectTokenDataPasskeyList, ConnectTokenDataPasskeyLogin");
    }

    /**
     * Get the actual instance, which can be the following:
     * ConnectTokenDataPasskeyAppend, ConnectTokenDataPasskeyDelete, ConnectTokenDataPasskeyList, ConnectTokenDataPasskeyLogin
     *
     * @return The actual instance (ConnectTokenDataPasskeyAppend, ConnectTokenDataPasskeyDelete, ConnectTokenDataPasskeyList, ConnectTokenDataPasskeyLogin)
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `ConnectTokenDataPasskeyAppend`. If the actual instance is not `ConnectTokenDataPasskeyAppend`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `ConnectTokenDataPasskeyAppend`
     * @throws ClassCastException if the instance is not `ConnectTokenDataPasskeyAppend`
     */
    public ConnectTokenDataPasskeyAppend getConnectTokenDataPasskeyAppend() throws ClassCastException {
        return (ConnectTokenDataPasskeyAppend)super.getActualInstance();
    }

    /**
     * Get the actual instance of `ConnectTokenDataPasskeyDelete`. If the actual instance is not `ConnectTokenDataPasskeyDelete`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `ConnectTokenDataPasskeyDelete`
     * @throws ClassCastException if the instance is not `ConnectTokenDataPasskeyDelete`
     */
    public ConnectTokenDataPasskeyDelete getConnectTokenDataPasskeyDelete() throws ClassCastException {
        return (ConnectTokenDataPasskeyDelete)super.getActualInstance();
    }

    /**
     * Get the actual instance of `ConnectTokenDataPasskeyList`. If the actual instance is not `ConnectTokenDataPasskeyList`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `ConnectTokenDataPasskeyList`
     * @throws ClassCastException if the instance is not `ConnectTokenDataPasskeyList`
     */
    public ConnectTokenDataPasskeyList getConnectTokenDataPasskeyList() throws ClassCastException {
        return (ConnectTokenDataPasskeyList)super.getActualInstance();
    }

    /**
     * Get the actual instance of `ConnectTokenDataPasskeyLogin`. If the actual instance is not `ConnectTokenDataPasskeyLogin`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `ConnectTokenDataPasskeyLogin`
     * @throws ClassCastException if the instance is not `ConnectTokenDataPasskeyLogin`
     */
    public ConnectTokenDataPasskeyLogin getConnectTokenDataPasskeyLogin() throws ClassCastException {
        return (ConnectTokenDataPasskeyLogin)super.getActualInstance();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to ConnectTokenData
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        // validate oneOf schemas one by one
        int validCount = 0;
        ArrayList<String> errorMessages = new ArrayList<>();
        // validate the json string with ConnectTokenDataPasskeyAppend
        try {
            ConnectTokenDataPasskeyAppend.validateJsonElement(jsonElement);
            validCount++;
        } catch (Exception e) {
            errorMessages.add(String.format("Deserialization for ConnectTokenDataPasskeyAppend failed with `%s`.", e.getMessage()));
            // continue to the next one
        }
        // validate the json string with ConnectTokenDataPasskeyDelete
        try {
            ConnectTokenDataPasskeyDelete.validateJsonElement(jsonElement);
            validCount++;
        } catch (Exception e) {
            errorMessages.add(String.format("Deserialization for ConnectTokenDataPasskeyDelete failed with `%s`.", e.getMessage()));
            // continue to the next one
        }
        // validate the json string with ConnectTokenDataPasskeyList
        try {
            ConnectTokenDataPasskeyList.validateJsonElement(jsonElement);
            validCount++;
        } catch (Exception e) {
            errorMessages.add(String.format("Deserialization for ConnectTokenDataPasskeyList failed with `%s`.", e.getMessage()));
            // continue to the next one
        }
        // validate the json string with ConnectTokenDataPasskeyLogin
        try {
            ConnectTokenDataPasskeyLogin.validateJsonElement(jsonElement);
            validCount++;
        } catch (Exception e) {
            errorMessages.add(String.format("Deserialization for ConnectTokenDataPasskeyLogin failed with `%s`.", e.getMessage()));
            // continue to the next one
        }
        if (validCount != 1) {
            throw new IOException(String.format("The JSON string is invalid for ConnectTokenData with oneOf schemas: ConnectTokenDataPasskeyAppend, ConnectTokenDataPasskeyDelete, ConnectTokenDataPasskeyList, ConnectTokenDataPasskeyLogin. %d class(es) match the result, expected 1. Detailed failure message for oneOf schemas: %s. JSON: %s", validCount, errorMessages, jsonElement.toString()));
        }
    }

    /**
     * Create an instance of ConnectTokenData given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ConnectTokenData
     * @throws IOException if the JSON string is invalid with respect to ConnectTokenData
     */
    public static ConnectTokenData fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, ConnectTokenData.class);
    }

    /**
     * Convert an instance of ConnectTokenData to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

