package myrovh.onlinenewsreader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        //Get Url
        String url = getIntent().getStringExtra("url");

        //Configure WebView
        WebView webView = (WebView) findViewById(R.id.webView);
        if (webView != null) {
            webView.getSettings().setLoadsImagesAutomatically(true);
            webView.getSettings().setUseWideViewPort(true);
            webView.getSettings().setLoadWithOverviewMode(true);
            webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl(url);
        } else {
            finish();
        }
    }
}
