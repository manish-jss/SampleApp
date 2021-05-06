package com.mobile.sampleapp.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieList {

  @SerializedName("results")
  private List<MovieModel> movieModels;

  public List<MovieModel> getMovieModels() {
    return movieModels;
  }

  public void setMovieModels(List<MovieModel> movieModels) {
    this.movieModels = movieModels;
  }
}