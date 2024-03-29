package com.android.example.alc4phase1;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutALC extends AppCompatActivity {

    private WebView mWebView;
    private String mAboutALCLink;
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);

        // Get the reference for our web view layout and
        // set properties to it.
        mWebView = this.findViewById(R.id.wv_about_alc);
        mWebView.setWebViewClient(new mWebViewBrowser());

        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setDatabaseEnabled(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);

        // Get and display the content of About ALC link that was passed from MainActivity
        Intent intentThatStartedThisActivity = getIntent();
        if (intentThatStartedThisActivity != null) {
            if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
                mAboutALCLink = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT);
                mWebView.loadUrl(mAboutALCLink);
            }
        }
    }

    private class mWebViewBrowser extends WebViewClient {
        // This method will be triggered when the Page Started Loading
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            mProgressDialog = ProgressDialog.show(AboutALC.this, null,
                    getString(R.string.progress_bar_message));
            mProgressDialog.setCancelable(true);
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }

        // Handle errors from when loading our web view
        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();
        }

        // This method will be triggered when the Page loading is completed
        @Override
        public void onPageFinished(WebView view, String url) {
            mProgressDialog.dismiss();
            super.onPageFinished(view, url);
        }
    }
}