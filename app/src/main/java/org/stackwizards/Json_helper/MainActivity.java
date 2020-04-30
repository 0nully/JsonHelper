package org.stackwizards.Json_helper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.stackwizards.jsonloader.IUtilHandler;
import org.stackwizards.jsonloader.UrlUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IUtilHandler {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UrlUtils.setContext(this)
                .setCallbackHandler(this)
                .setTypeCollection(Minion.class)
                .urlRequest("http://nully000-001-site1.atempurl.com/hexo_data.json");
    }

    @Override
    public <T> List<T> onReceive(List<T> objs) {
        for (Object l : objs) {
            Log.d("UrlUtils", ((Minion) l).Name);
        }
        return null;
    }
}
