package com.miguel.mynews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        String URL = getIntent().getStringExtra("url");

        WebView webView = findViewById(R.id.webview);
        webView.loadUrl(URL);
    }
}
