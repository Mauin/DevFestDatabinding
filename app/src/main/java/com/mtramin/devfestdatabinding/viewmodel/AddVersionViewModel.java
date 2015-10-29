package com.mtramin.devfestdatabinding.viewmodel;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

/**
 * TODO: JAVADOC
 */
public class AddVersionViewModel {

    private String versionName;

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String name) {
        this.versionName = name;
    }

    public String getVersionNameError() {
        if (TextUtils.isEmpty(versionName)) {
            return null;
        }

        char codeNameLetter = versionName.charAt(0);
        if (Character.compare(codeNameLetter, 'M') <= 0) {
            return "Versions until 'M' are already released";
        }

        return null;
    }

    public TextWatcher textChanged() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setVersionName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Do nothing
            }
        };
    }

    public View.OnClickListener saveButtonClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("TEST", "onClick " + versionName);
            }
        };
    }

}
