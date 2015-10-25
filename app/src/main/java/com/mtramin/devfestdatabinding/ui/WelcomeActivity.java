package com.mtramin.devfestdatabinding.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mtramin.devfestdatabinding.R;
import com.mtramin.devfestdatabinding.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends AppCompatActivity {

    private ActivityWelcomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome);

        binding.welcomeText.setText(R.string.welcome_text);

        binding.welcomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSpeakerList();
            }
        });
    }

    private void showSpeakerList() {
        Intent spearkersIntent = SpeakersActivity.createIntent(this);
        startActivity(spearkersIntent);
    }
}
