package com.example.kynansong.drinkable.Controllers;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.kynansong.drinkable.Models.MyBrowser;
import com.example.kynansong.drinkable.R;

public class WebViewActivity extends Activity {

    private WebView brandWebViewurl;
    ImageView back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        brandWebViewurl = (WebView) findViewById(R.id.brand_website);
        brandWebViewurl.setWebViewClient(new MyBrowser());

       // brandWebViewurl.

        brandWebViewurl.getSettings().setJavaScriptEnabled(true);
        brandWebViewurl.getSettings().setLoadsImagesAutomatically(true);

        brandWebViewurl.getSettings().setBuiltInZoomControls(true);

//        final AppCompatActivity activity = this;
//        brandWebViewurl.setWebViewClient(new WebViewClient() {
//            public boolean shouldOverrideUrlLoading(WebView view, String url){
//                brandWebViewurl.loadUrl("www.google.com");
//                return true;
//            }
//        });
        brandWebViewurl.loadUrl("http://www.facebook.com"); //Need to call on brand website.
            // if not working, try clean and rebuild project.
    }
}
