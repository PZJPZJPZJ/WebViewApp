package com.example.webviewapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 创建 WebView 实例并通过 id 绑定我们刚在布局中创建的 WebView 标签
        // 这里的 R.id.webview 就是 activity_main.xml 中的 WebView 标签的 id
        WebView myWebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = myWebView.getSettings();
        // 设置 WebView 允许执行 JavaScript 脚本
        webSettings.setJavaScriptEnabled(true);
        // 确保跳转到另一个网页时仍然在当前 WebView 中显示
        myWebView.setWebViewClient(new WebViewClient());
        // 加载指定网页
        myWebView.loadUrl("https://www.bing.com");
    }
}