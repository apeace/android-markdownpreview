package com.apeace.markdownpreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MARKDOWN = "com.apeace.markdownpreview.MARKDOWN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void preview(View view) {
        EditText editText = (EditText) findViewById(R.id.markdown_text);
        String markdown = editText.getText().toString();

        Intent intent = new Intent(this, PreviewActivity.class);
        intent.putExtra(EXTRA_MARKDOWN, markdown);
        startActivity(intent);
    }

}
