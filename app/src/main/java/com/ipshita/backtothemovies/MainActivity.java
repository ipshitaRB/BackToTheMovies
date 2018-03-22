package com.ipshita.backtothemovies;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.ipshita.backtothemovies.models.Movie;
import com.ipshita.backtothemovies.models.Result;
import com.ipshita.backtothemovies.recyclerutils.RecyclerAdapter;
import com.ipshita.backtothemovies.retrofitutil.MovieApiClient;
import com.ipshita.backtothemovies.retrofitutil.MovieApiInterface;
import com.ipshita.backtothemovies.retrofitutil.NetworkUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Movie> movieList;


    private RecyclerAdapter adapter;

    private RecyclerView movieRecyclerView;

    private RecyclerView.LayoutManager layoutManager;


    private Context context;

    private MovieApiInterface movieApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        movieRecyclerView = (RecyclerView) findViewById(R.id.movie_recycler_view);

        movieApiInterface = MovieApiClient.getMovieApiClient().create(MovieApiInterface.class);
        movieList = new ArrayList<>();

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                false);
        movieRecyclerView.setLayoutManager(layoutManager);

        context = getApplicationContext();
        if ((savedInstanceState == null) ||
                (!savedInstanceState.containsKey(getString(R.string.movie_parcel_key)))) {
            if (null != movieList) {
                movieList.clear();
            }

            if (NetworkUtils.isNetworkAvailable(context)) {

                loadUpcomingMovies();
            } else {
                Toast.makeText(context, getResources().getString(R.string.no_internet),
                        Toast.LENGTH_LONG).show();
            }
        } else {
            if (null != movieList) {
                movieList.clear();
            }
            movieList = savedInstanceState.getParcelableArrayList(getString(R.string.movie_parcel_key));
            adapter = new RecyclerAdapter(movieList);
            movieRecyclerView.setAdapter(adapter);


        }
    }

    private void loadUpcomingMovies() {
        Call<Result> call = movieApiInterface.getUpcomingMovies("dd73b1394913e43c943416f4b52496d9");
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {

                //movieList = (ArrayList<Movie>) response.body();
                Log.i("response success", response.body().getMovieList().get(0).getName());

                movieList = (ArrayList<Movie>) response.body().getMovieList();

                // Done: 18-12-2017 update recyclerview
                adapter = new RecyclerAdapter(movieList);
                movieRecyclerView.setAdapter(adapter);



            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("response failed", t.getMessage());
            }
        });
    }
}
