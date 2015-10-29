package com.mtramin.devfestdatabinding.ui;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mtramin.devfestdatabinding.R;
import com.mtramin.devfestdatabinding.databinding.ActivityAddVersionBinding;
import com.mtramin.devfestdatabinding.viewmodel.AddVersionViewModel;

public class AddVersionActivity extends AppCompatActivity {

    private ActivityAddVersionBinding binding;
    private AddVersionViewModel viewModel;

    public static Intent createIntent(Activity activity) {
        return new Intent(activity, AddVersionActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_version);
        viewModel = new AddVersionViewModel();
        binding.setViewModel(viewModel);

        setTitle(R.string.title_add_version);
    }
}
