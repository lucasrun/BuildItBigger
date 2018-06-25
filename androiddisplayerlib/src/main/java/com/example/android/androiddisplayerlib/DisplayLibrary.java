package com.example.android.androiddisplayerlib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayLibrary extends AppCompatActivity {

    TextView tv;

    private static final String JOKE = "JOKE";
    private static final String joker = "Wanna hear infinite joke?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_library);

        tv = findViewById(R.id.joke_text);

        String joke = null;

        Intent intent = getIntent();

        // check suggested by reviewer
        if (intent.hasExtra(JOKE)) {
            joke = intent.getStringExtra(JOKE);
        }

        if (joke != null) {
            tv.setText(joke);
        } else {
            tv.setText(joker);
        }
    }
}
