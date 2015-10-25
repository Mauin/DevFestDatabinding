package com.mtramin.devfestdatabinding.data;

import android.util.Log;

import com.mtramin.devfestdatabinding.network.ApiClient;

/**
 * TODO: JAVADOC
 */
public class Speaker {
    public String name;
    public String title;
    public String company;
    public String country;
    private String photoUrl;
    public String bio;

    public String getPhotoUrl() {
        // Converts the relative path of the PhotoUrl to the global url
        Log.e("TEST", "getPhotoUrl ");
        return ApiClient.DEVFEST_BASE_URL + photoUrl.replace("../..", "");
    }
}
