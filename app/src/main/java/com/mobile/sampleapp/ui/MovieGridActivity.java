package com.mobile.sampleapp.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.sampleapp.R;
import com.mobile.sampleapp.data.ApiInterface;
import com.mobile.sampleapp.data.MovieList;
import com.mobile.sampleapp.data.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieGridActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_grid);

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));


        apiInterface= RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
        Call<MovieList> call=apiInterface.getMovieList();
        call.enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                MovieList movieList = response.body();
                MovieListAdapter adapter = new MovieListAdapter(MovieGridActivity.this,movieList.getMovieModels());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {
                Log.d("#######","################");
            }
        });

    }
}