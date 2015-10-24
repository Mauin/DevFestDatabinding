package com.mtramin.devfestdatabinding.network;

import retrofit.http.GET;

/**
 * TODO: JAVADOC
 */
public interface DevFestApi {

    @GET("/data/speakers.json")
    void getSpeakers();
}
