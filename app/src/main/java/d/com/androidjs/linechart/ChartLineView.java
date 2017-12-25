package d.com.androidjs.linechart;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;


import org.json.JSONObject;

import d.com.androidjs.R;

/**
 * Created by wangwei on 2017/12/20.
 * 折线图View
 */

public class ChartLineView extends LinearLayout {
    private WebView mWebview;
    String jsPre;

    public ChartLineView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.layout_chart_container, this);
        mWebview = findViewById(R.id.chartshow_wb);
        initWebView();
    }

    public ChartLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_chart_container, this);
        mWebview = findViewById(R.id.chartshow_wb);
        initWebView();
    }

    private void initWebView() {
        mWebview.getSettings().setJavaScriptEnabled(true);
        WebSettings webSettings = mWebview.getSettings();
        // User settings
        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);//设置可以访问文件

        mWebview.setHorizontalScrollBarEnabled(false);//水平不显示
        mWebview.setVerticalScrollBarEnabled(false); //垂直不显示


    }


    public void createLineChart(final JSONObject lineJson) {
        jsPre = "javascript:createChart(" + lineJson + ")";
        mWebview.loadUrl("file:///android_asset/echart/chartLine.html");
        mWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                Log.w("webview", "shouldOverrideUrlLoading");
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                Log.w("webview", "onPageStarted");

                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                Log.w("webview", "onPageFinished");

                mWebview.loadUrl(jsPre);
            }
        });
    }

}

