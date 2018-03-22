package com.ipshita.backtothemovies.recyclerutils;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ipshita.backtothemovies.R;

/**
 * Created by Ipshita on 21-03-2018.
 */

public class MovieViewHolder extends RecyclerView.ViewHolder {

    TextView nameTextView;
    TextView popularityTextView;

    ImageView moviePosterImageView;

    public MovieViewHolder(View itemView) {
        super(itemView);

        nameTextView = (TextView)itemView.findViewById(R.id.movieNameTextView);
        popularityTextView = (TextView)itemView.findViewById(R.id.moviePopularityTextView);
        moviePosterImageView = (ImageView) itemView.findViewById(R.id.movieImageView);


    }
}
