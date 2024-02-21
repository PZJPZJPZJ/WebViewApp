package com.example.webviewapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    WebView myWebView;
    WebSettings webSettings;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 创建 WebView 实例并通过 id 绑定我们刚在布局中创建的 WebView 标签
        // 这里的 R.id.webview 就是 activity_main.xml 中的 WebView 标签的 id
        myWebView = (WebView) findViewById(R.id.webview);
        webSettings = myWebView.getSettings();
        // 设置 WebView 允许执行 JavaScript 脚本
        webSettings.setJavaScriptEnabled(true);
        // 确保跳转到另一个网页时仍然在当前 WebView 中显示
        myWebView.setWebViewClient(new WebViewClient());
        // 加载指定网页
        myWebView.loadUrl("https://www.bing.com");
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 若有浏览记录则执行页面返回
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        // 若没有历史记录则执行系统默认返回
        return super.onKeyDown(keyCode, event);
    }
}