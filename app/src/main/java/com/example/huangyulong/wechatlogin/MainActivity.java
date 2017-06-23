package com.example.huangyulong.wechatlogin;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView = (WebView) findViewById(R.id.test);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            mWebView .setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }

        mWebView.loadUrl( "file:///android_asset/"+"test.html");


        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setDomStorageEnabled(true);

        // 将图片调整到适合webview的大小
        mWebView.getSettings().setUseWideViewPort(true);

        // 设置一些，JS可以调用的本地函数
        MyJSObj jsObj = new MyJSObj();
        mWebView.addJavascriptInterface(jsObj, "jsObj");

    }

    private class MyJSObj {
        @JavascriptInterface
        public void share(String  json){
            Toast.makeText(MainActivity.this, json, Toast.LENGTH_SHORT).show();
            //Toast.makeText(MainActivity.this, "json.size():" + json.size(), Toast.LENGTH_SHORT).show();
        }
    }

}
