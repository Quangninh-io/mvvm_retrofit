package com.example.mvvm_retrofit.network;

import com.example.mvvm_retrofit.model.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("posts")
    Call<List<MovieModel>> getMovieList();
}
