package com.mtramin.devfestdatabinding.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mtramin.devfestdatabinding.R;
import com.mtramin.devfestdatabinding.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends AppCompatActivity {

    private ActivityWelcomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome);

        getFragmentManager().beginTransaction()
                .replace(R.id.content, new WelcomeFragment())
                .commit();

    }

    private void showSpeakerList() {
        Intent spearkersIntent = SpeakersActivity.createIntent(this);
        startActivity(spearkersIntent);
    }
}