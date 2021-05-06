package com.mobile.sampleapp.data;

import java.util.List;
 
import retrofit2.Call;
import retrofit2.http.GET;
 
public interface ApiInterface {
 
 
    @GET("popular?api_key=4a085644e7ae6b3461229b0633c290c8&language=en-US&page=1")
    public Call<MovieList> getMovieList();
}