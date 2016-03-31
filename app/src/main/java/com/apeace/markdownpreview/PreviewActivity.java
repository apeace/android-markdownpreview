package com.apeace.markdownpreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.RelativeLayout;

public class PreviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        Intent intent = getIntent();
        String markdown = intent.getStringExtra(MainActivity.EXTRA_MARKDOWN);

        // TODO convert markdown to html
        String html = "<p>Testing</p>";

        WebView webview = new WebView(this);
        webview.loadData(html, "text/html", null);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.markdown_preview);
        layout.addView(webview);
    }

}
