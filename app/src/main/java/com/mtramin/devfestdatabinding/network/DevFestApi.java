package com.mtramin.devfestdatabinding.network;

import com.mtramin.devfestdatabinding.data.Speaker;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

/**
 * TODO: JAVADOC
 */
public interface DevFestApi {

    @GET("/data/speakers.json")
    Call<List<Speaker>> getSpeakers();
}
