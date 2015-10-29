package com.mtramin.devfestdatabinding.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.mtramin.devfestdatabinding.R;

public class WelcomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ((TextView) findViewById(R.id.welcome_text)).setText(R.string.welcome_text);

        findViewById(R.id.welcome_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSpeakerList();
            }
        });
    }

    private void showSpeakerList() {
        Intent spearkersIntent = VersionListActivity.createIntent(this);
        startActivity(spearkersIntent);
    }
}