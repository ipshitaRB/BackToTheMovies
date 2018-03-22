package com.ipshita.backtothemovies.recyclerutils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ipshita.backtothemovies.R;
import com.ipshita.backtothemovies.models.Movie;

import java.util.List;

/**
 * Created by Ipshita on 22-03-2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private List<Movie> movieList;

    private Movie currentMovie;

    private Context context;

    public RecyclerAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }
    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.movie_row,
                parent, false);

        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        currentMovie = movieList.get(position);
        holder.nameTextView.setText(currentMovie.getName());
        holder.popularityTextView.setText(currentMovie.getPopularity().toString());
        if (null != currentMovie.getImagePath() && !currentMovie.getImagePath().isEmpty()){
            //TODO load image with Picasso

        }

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
