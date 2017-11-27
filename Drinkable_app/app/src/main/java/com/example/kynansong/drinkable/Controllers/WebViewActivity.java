package com.example.kynansong.drinkable.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.kynansong.drinkable.R;

public class WebViewActivity extends AppCompatActivity {

    private WebView brandWebViewurl;
    ImageView back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        brandWebViewurl = (WebView) findViewById(R.id.brand_website);

        brandWebViewurl.getSettings().setJavaScriptEnabled(true);

        brandWebViewurl.getSettings().setBuiltInZoomControls(true);
        final AppCompatActivity activity = this;
        brandWebViewurl.setWebViewClient(new WebViewClient() {
            public void onRecievedError(WebView view, int errorCode, String description
                    , String failingUrl){
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
        });
        brandWebViewurl.loadUrl("www.google.com"); //Need to call on brand website.

    }
}
