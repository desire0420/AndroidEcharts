package d.com.androidjs.jsbridge;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import com.github.lzyzsd.jsbridge.DefaultHandler;
import com.google.gson.Gson;

import d.com.androidjs.R;

/**
 * Created by wangwei on 2018/3/27.
 */

public class JSBridgeActivity extends AppCompatActivity {

    private static final String TAG = "WebActivity";


    private BridgeWebView mBridgeWebView;

    private UserInfo mUserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.js_bridge_layout);

        Intent intent = this.getIntent();
        String email = "sdfvghj";
        mUserInfo = new UserInfo(email);
        mBridgeWebView = (BridgeWebView) findViewById(R.id.web_view);
        mBridgeWebView.setDefaultHandler(new DefaultHandler());
        mBridgeWebView.loadUrl("file:///android_asset/getuserinfo.html");
        registerHandler();
    }

    private void registerHandler() {

        //  提供操作给Js调用
        mBridgeWebView.registerHandler("getUserInfo", new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                Log.i(TAG, "handler = getUserInfo, data from web = " + data);
                function.onCallBack(new Gson().toJson(mUserInfo));
            }
        });


    }

}
