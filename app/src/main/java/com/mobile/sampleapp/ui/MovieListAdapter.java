package com.mobile.sampleapp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mobile.sampleapp.R;
import com.mobile.sampleapp.data.MovieModel;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {

    private final List<MovieModel> dataList;
    private Context context;

    public MovieListAdapter(Context context, List<MovieModel> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        private ImageView imvThumb;

        MovieViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.txt_name);
            imvThumb = itemView.findViewById(R.id.image_view);
        }
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_movie_grid, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        MovieModel movieModel = dataList.get(position);
        holder.tvTitle.setText(movieModel.getTitle());

        Glide.with(context.getApplicationContext())
                .asBitmap()
                .load("https://image.tmdb.org/t/p/w500/"+movieModel.getImageUrl())
                .into(holder.imvThumb);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}