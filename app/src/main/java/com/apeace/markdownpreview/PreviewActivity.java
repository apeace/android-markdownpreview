package com.apeace.markdownpreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PreviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        Intent intent = getIntent();
        String markdown = intent.getStringExtra(MainActivity.EXTRA_MARKDOWN);

        // TODO display HTML instead of text
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(markdown);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.markdown_preview);
        layout.addView(textView);
    }
}
