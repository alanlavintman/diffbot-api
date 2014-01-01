package com.diffbot.api;

import com.diffbot.api.impl.DiffBotRestApi;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * Created with IntelliJ IDEA.
 * User: alanl
 * Date: 1/1/14
 * Time: 4:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class DiffBotTest
{
    @Test
    public void testDiffBot(){
        try {
            DiffBotRestApi api = new DiffBotRestApi("http://api.diffbot.com/v2");
            JSONObject jsonObject = api.get("f38fcba6ec54956f66cee703c1717a71", "article", "http://www.xconomy.com/san-francisco/2012/07/25/diffbot-is-using-computer-vision-to-reinvent-the-semantic-web/", "meta,querystring,images(*)");
            jsonObject = jsonObject; //TODO: Do some real unit test here.
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();  // URL Encoding exception
        } catch (JSONException e) {
            e.printStackTrace();  // Invalid Json from the server exception.
        }
    }
}