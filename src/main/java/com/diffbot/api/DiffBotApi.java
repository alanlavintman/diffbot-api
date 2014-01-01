package com.diffbot.api;

import org.codehaus.jettison.json.JSONException;

import java.io.UnsupportedEncodingException;

/**
 * Interface that consumers will be able to use in order to mock a rest call to
 * the real DiffBotApi.
 * User: alanl
 * Date: 1/1/14
 * Time: 3:24 PM
 */
public interface DiffBotApi<T> {

    /**
     * Main get method that consumers can use in order to invoke all the apis of DiffBot.
     * The parameters will allow the consumer to customize the url, the api they may want to call, the fields
     * to retrieve and the version of the api.
     * @param url The url where diffbot is hosting the services.
     * @param token The token aquired by diffbot
     * @param api The Api they may want to call.
     * @param fields The fields they want to get from the api (Field expansion)
     * @return A Generic type so the consumer can mock according to its needs.
     */
    T get(String token, String api, String url, String fields) throws UnsupportedEncodingException, JSONException;

}
