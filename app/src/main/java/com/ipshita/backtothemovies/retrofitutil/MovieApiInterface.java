package com.ipshita.backtothemovies.retrofitutil;

import com.ipshita.backtothemovies.models.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ipshita on 21-03-2018.
 */

public interface MovieApiInterface {

    @GET("3/movie/upcoming")
    Call<Result> getNowPlayingMovies(@Query("api_key") String apiKey);

    @GET("3/movie/now_playing")
    Call<Result> getUpcomingMovies(@Query("api_key") String apiKey);
}
