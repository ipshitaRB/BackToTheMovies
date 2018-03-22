package com.ipshita.backtothemovies.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ipshita on 21-03-2018.
 */

public class Result {

    @SerializedName("results")
    private List<Movie> movieList;

    public List<Movie> getMovieList() {
        return movieList;
    }
}
