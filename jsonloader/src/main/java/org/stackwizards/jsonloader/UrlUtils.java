package org.stackwizards.jsonloader;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.lang.reflect.Type;
import java.util.List;

public class UrlUtils {
    private static RequestQueue mQueue;
    private static Type collectionType;
    private static IUtilHandler callback;
    private static UrlUtils urlUtils;

    public static UrlUtils setContext(Context context) {
        mQueue = Volley.newRequestQueue(context);
        return urlUtils;
    }

    public static UrlUtils setCallbackHandler(IUtilHandler handler) {
        callback = handler;
        return urlUtils;
    }

    public static UrlUtils setTypeCollection(Type type) {
        collectionType = TypeToken.getParameterized(List.class, type).getType();
        return urlUtils;
    }

    public static void urlRequest(final String url) {
        if (mQueue == null || callback == null || collectionType == null) {
            throw new NullPointerException("UrlUtils: mQueue or callback or collectionType were not set");
        }
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("UrlUtils", "RESPONSE: " + response.toString());
                        callback.onReceive(parseJsonToListCollectionType(response.toString()));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.d("UrlUtils", "SOMETHING WENT WRONG WHILE GETTING JSON DATA FROM URL: " + url);
            }
        });
        mQueue.add(request);
    }

    private static <T> List<T> parseJsonToListCollectionType(String json) {
        checkJsonContentIsOfTypeArray(json);
        Gson gson = new Gson();
        List<T> list = gson.fromJson(json, collectionType);
        Log.d("UrlUtils", "SIZE: " + list.size());
        return list;
    }

    private static void checkJsonContentIsOfTypeArray(String data) {
        Object json = null;
        try {
            json = new JSONTokener(data).nextValue();
            if (json instanceof JSONObject) {
                throw new Exception("UrlUtils: expecting json array but received json object");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("UrlUtils", "UrlUtils: Problem parsing json array");
        }
    }

}
