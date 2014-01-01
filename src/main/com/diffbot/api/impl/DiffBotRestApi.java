package com.diffbot.api.impl;


import com.diffbot.api.DiffBotApi;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Basic Api Implementation for DiffBot api.
 * User: alanl
 * Date: 1/1/14
 * Time: 3:24 PM
 */
public class DiffBotRestApi implements DiffBotApi<JSONObject> {

    private String apiUrl;
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public DiffBotRestApi(String apiUrl) {
        ClientConfig config = new DefaultClientConfig();
        this.client = Client.create(config);
        this.apiUrl = apiUrl;
    }

    @Override
    public JSONObject get(String token, String api, String url, String fields) throws UnsupportedEncodingException, JSONException {
        String crawlUrl = URLEncoder.encode(url, "ISO-8859-1");
        WebResource resource = client.resource(this.apiUrl);
        resource = resource.path(api);
        resource = resource.queryParam("token",token);
        resource = resource.queryParam("url",crawlUrl);
        if (fields != null){
            resource= resource.queryParam("fields",fields);
        }
        // Execute the call and get the response.
        String value = resource.accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);

        // build query parameters:
        return new JSONObject(value);
    }

}
