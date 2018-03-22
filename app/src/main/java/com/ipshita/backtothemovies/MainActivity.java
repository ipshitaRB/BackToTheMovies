package com.ipshita.backtothemovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ipshita.backtothemovies.models.Movie;
import com.ipshita.backtothemovies.models.Result;
import com.ipshita.backtothemovies.retrofitutil.MovieApiClient;
import com.ipshita.backtothemovies.retrofitutil.MovieApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Movie> movieList;

    private MovieApiInterface movieApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieApiInterface = MovieApiClient.getMovieApiClient().create(MovieApiInterface.class);
        movieList = new ArrayList<>();
        loadUpcomingMovies();
    }

    private void loadUpcomingMovies() {
        Call<Result> call = movieApiInterface.getUpcomingMovies("dd73b1394913e43c943416f4b52496d9");
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {

                //movieList = (ArrayList<Movie>) response.body();
                Log.i("response success", response.body().getMovieList().get(0).getName());



            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("response failed", t.getMessage());
            }
        });
    }
}
