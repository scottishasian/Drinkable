package com.example.kynansong.drinkable.Controllers;

import android.app.Activity;
import android.content.Intent;
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

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();

        String websiteLink = extras.getString("weblink");

        brandWebViewurl = (WebView) findViewById(R.id.brand_website);
        brandWebViewurl.setWebViewClient(new MyBrowser());

       // brandWebViewurl.

        brandWebViewurl.getSettings().setJavaScriptEnabled(true);
        brandWebViewurl.getSettings().setLoadsImagesAutomatically(true);

        brandWebViewurl.getSettings().setBuiltInZoomControls(true);

        brandWebViewurl.loadUrl(websiteLink); //Need to call on brand website.
            // if not working, try clean and rebuild project.
    }
}
