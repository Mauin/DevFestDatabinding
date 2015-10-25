package com.mtramin.devfestdatabinding.ui;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mtramin.devfestdatabinding.R;
import com.mtramin.devfestdatabinding.databinding.FragmentWelcomeBinding;

/**
 * TODO
 */
public class WelcomeFragment extends Fragment {

    public WelcomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentWelcomeBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false);

        binding.welcomeText.setText(R.string.welcome_text);

//        binding.welcomeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showSpeakerList();
//            }
//        });

        return binding.getRoot();
    }

}
