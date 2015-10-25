package com.mtramin.devfestdatabinding.network;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * TODO: JAVADOC
 */
public class ApiClient {

    private static final String DEVFEST_BASE_URL = "http://devfest.de/";

    private static DevFestApi instance = null;

    public static DevFestApi getDevFestApiInstance() {
        if (instance == null) {
            instance = createDevFestApi();
        }

        return instance;
    }

    private static DevFestApi createDevFestApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DEVFEST_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(DevFestApi.class);
    }
}
