package com.mobile.sampleapp.data;

import com.google.gson.annotations.SerializedName;

public class MovieModel {
    @SerializedName("title")
    private String title;
    @SerializedName("poster_path")
    private String imageUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
