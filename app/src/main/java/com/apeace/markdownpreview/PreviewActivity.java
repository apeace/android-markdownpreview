package com.apeace.markdownpreview;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;

import com.apeace.markdownpreview.util.MarkdownUtils;
import com.apeace.markdownpreview.util.Optional;

public class PreviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        Intent intent = getIntent();
        String nullableMarkdown = intent.getStringExtra(MainActivity.EXTRA_MARKDOWN);
        Optional<String> markdown = Optional.ofNullable(nullableMarkdown);
        String nullableHtml = MarkdownUtils.markdownToHtml(markdown.orElse(""));
        Optional<String> html = Optional.ofNullable(nullableHtml);

        WebView webview = (WebView) findViewById(R.id.web_view);
        webview.loadData(html.orElse(""), "text/html", null);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle actionbar "up" button
        // http://stackoverflow.com/questions/11304483/proper-way-to-handle-action-bar-up-button/20306670#20306670
        if (item.getItemId() == android.R.id.home) {
            Intent intent = NavUtils.getParentActivityIntent(this);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
            NavUtils.navigateUpTo(this, intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
