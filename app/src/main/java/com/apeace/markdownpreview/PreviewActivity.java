package com.apeace.markdownpreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.github.rjeschke.txtmark.Processor;

public class PreviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        Intent intent = getIntent();
        String markdown = intent.getStringExtra(MainActivity.EXTRA_MARKDOWN);
        String html = Processor.process(markdown);

        WebView webview = (WebView) findViewById(R.id.web_view);
        webview.loadData(html, "text/html", null);
    }

}
