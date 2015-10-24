package com.mtramin.devfestdatabinding.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mtramin.devfestdatabinding.R;
import com.mtramin.devfestdatabinding.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends AppCompatActivity {

    private ActivityWelcomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome);
    }
}
