package org.stackwizards.Json_helper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.stackwizards.jsonloader.IUrlRequestArrayHandler;
import org.stackwizards.jsonloader.IUrlRequestSingleHandler;
import org.stackwizards.jsonloader.UrlSingleUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IUrlRequestArrayHandler, IUrlRequestSingleHandler {
    private static String TAG = "HELPER_UTILS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        UrlArrayUtils.setContext(this)
//                .setCallbackHandler(this)
//                .setType(Minion.class)
//                .urlRequest("http://nully000-001-site1.atempurl.com/hexo_data.json");

        UrlSingleUtils.setContext(this)
                .setCallbackHandler(this)
                .setType(Request.class)
                .urlRequest("https://api.edamam.com/search?q=beef&app_id=7b790015&app_key=15264eee8cbce932a6ab6af4a739b7c0&from=0&to=30");
    }

    @Override
    public <T> List<T> onComplete(List<T> objs) {
        for (Object l : objs) {
            Log.d(TAG, ((Minion) l).Name);
        }
        return null;
    }

    @Override
    public <T> T onComplete(T obj) {
        Log.d(TAG, ((Request) obj).q);
        List<Hit> recipes = ((Request) obj).hits;
        Log.d(TAG, recipes.size() + "");
        for(int i=0; i<recipes.size(); i++){
            Log.d(TAG, recipes.get(i).recipe.label);
            Log.d(TAG, recipes.get(i).recipe.image);
        }
        return null;
    }
}