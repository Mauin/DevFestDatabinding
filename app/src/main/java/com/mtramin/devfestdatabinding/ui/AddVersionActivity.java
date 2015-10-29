package com.mtramin.devfestdatabinding.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

import com.mtramin.devfestdatabinding.R;
import com.mtramin.devfestdatabinding.viewmodel.AddVersionViewModel;

public class AddVersionActivity extends AppCompatActivity {

    private AddVersionViewModel viewModel;
    private EditText editText;

    public static Intent createIntent(Activity activity) {
        return new Intent(activity, AddVersionActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_version);

        setTitle(R.string.title_add_version);

        editText = (EditText) findViewById(R.id.edit_version);

        initTextWatcher();
    }

    private void initTextWatcher() {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateError(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void updateError(String s) {
        String error = getVersionNameError(s);
        editText.setError(error);
    }

    private String getVersionNameError(String s) {
        if (TextUtils.isEmpty(s)) {
            return null;
        }

        char codeNameLetter = s.charAt(0);
        if (Character.compare(codeNameLetter, 'M') <= 0) {
            return "Versions until 'M' are already released";
        }

        return null;
    }
}
