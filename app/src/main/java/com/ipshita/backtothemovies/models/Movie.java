package com.ipshita.backtothemovies.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ipshita on 21-03-2018.
 */

public class Movie implements Parcelable{

    /*{
        "vote_count": 2934,
            "id": 353486,
            "video": false,
            "vote_average": 6.5,
            "title": "Jumanji: Welcome to the Jungle",
            "popularity": 107.464106,
            "poster_path": "/bXrZ5iHBEjH7WMidbUDQ0U2xbmr.jpg",
            "original_language": "en",
            "original_title": "Jumanji: Welcome to the Jungle",
            "genre_ids": [
        28,
                12,
                35,
                10751
],
        "backdrop_path": "/rz3TAyd5kmiJmozp3GUbYeB5Kep.jpg",
            "adult": false,
            "overview": "The tables are turned as four teenagers are sucked into Jumanji's world - pitted against rhinos, black mambas and an endless variety of jungle traps and puzzles. To survive, they'll play as characters from the game.",
            "release_date": "2017-12-09"
    },*/



    @SerializedName("title")
    private String name;

    @SerializedName("genre_ids")
    private long[] genre;

    @SerializedName("popularity")
    private Double popularity;

    @SerializedName("poster_path")
    private String imagePath;

    protected Movie(Parcel in) {
        name = in.readString();
        genre = in.createLongArray();
        if (in.readByte() == 0) {
            popularity = null;
        } else {
            popularity = in.readDouble();
        }
        imagePath = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long[] getGenre() {
        return genre;
    }

    public void setGenre(long[] genre) {
        this.genre = genre;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeLongArray(genre);
        if (popularity == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(popularity);
        }
        parcel.writeString(imagePath);
    }
}



