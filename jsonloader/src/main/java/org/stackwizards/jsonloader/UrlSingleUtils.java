package org.stackwizards.jsonloader;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.lang.reflect.Type;

public class UrlSingleUtils {
    private static String TAG = "HELPER_UTILS";
    private static RequestQueue mQueue;
    private static Type mType;
    private static IUrlRequestSingleHandler callback;
    private static UrlSingleUtils Instance;

    public static UrlSingleUtils setContext(Context context) {
        mQueue = Volley.newRequestQueue(context);
        return Instance;
    }

    public static UrlSingleUtils setCallbackHandler(IUrlRequestSingleHandler handler) {
        callback = handler;
        return Instance;
    }

    public static UrlSingleUtils setType(Type type) {
        mType = type;
        return Instance;
    }

    public static void urlRequest(final String url) {
        if (mQueue == null || callback == null || mType == null) {
            throw new NullPointerException("UrlSingleUtils: mQueue or callback or mType were not set");
        }

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, "Got response from :" + url);
                        callback.onComplete(parseJsonToType(response.toString()));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, error.toString());
                    }
                }
        );

        mQueue.add(request);
    }

    private static <T> T parseJsonToType(String json) {
        checkJsonContentIsOfTypeObject(json);
        Gson gson = new Gson();
        T obj = gson.fromJson(json, mType);
        return obj;
    }

    private static void checkJsonContentIsOfTypeObject(String data) {
        Object json = null;
        try {
            json = new JSONTokener(data).nextValue();
            if (!(json instanceof JSONObject)) {
                throw new Exception("UrlSingleUtils: expecting json object but received json array");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "UrlSingleUtils: Problem parsing json array");
        }
    }
}
