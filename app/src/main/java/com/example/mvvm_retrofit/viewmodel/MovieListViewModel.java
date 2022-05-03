package com.example.mvvm_retrofit.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm_retrofit.model.MovieModel;
import com.example.mvvm_retrofit.network.ApiService;
import com.example.mvvm_retrofit.network.RetroInstance;

import java.io.Closeable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListViewModel extends ViewModel {

    private final MutableLiveData<List<MovieModel>> movieList;

    //initial mutable object
    public MovieListViewModel() {
        movieList = new MutableLiveData<>();
    }

    //use to call from main activity - return a live data
    public MutableLiveData<List<MovieModel>> getMovieListObserver(){
        return movieList;
    }

    //update data
    public void makeCallApi(){
        ApiService apiService = RetroInstance.getRetroClient();
        Call<List<MovieModel>> call = apiService.getMovieList();

        call.enqueue(new Callback<List<MovieModel>>() {
            @Override
            public void onResponse(Call<List<MovieModel>> call, Response<List<MovieModel>> response) {
                movieList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<MovieModel>> call, Throwable t) {
                movieList.postValue(null);
            }
        });
    }
}
