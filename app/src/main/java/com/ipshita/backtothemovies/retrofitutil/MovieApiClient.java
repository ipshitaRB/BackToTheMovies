package com.ipshita.backtothemovies.retrofitutil;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ipshita on 21-03-2018.
 */

public class MovieApiClient {



    public static final String BASE_URL = "https://api.themoviedb.org";


    public static Retrofit retrofit;

    public static Retrofit getMovieApiClient(){
        if( retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
