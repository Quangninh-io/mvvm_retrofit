package com.example.mvvm_retrofit.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mvvm_retrofit.R;
import com.example.mvvm_retrofit.adapter.MovieListAdapter;
import com.example.mvvm_retrofit.model.MovieModel;
import com.example.mvvm_retrofit.viewmodel.MovieListViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MovieListAdapter movieListAdapter;
    private List<MovieModel> movieModelList;
    private MovieListViewModel movieListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleView);
        movieModelList = new ArrayList<>();
        movieListAdapter = new MovieListAdapter(this, movieModelList);
        recyclerView.setAdapter(movieListAdapter);

        movieListViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);
        movieListViewModel.getMovieListObserver().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                movieListAdapter.setList(movieModels);
            }
        });

        movieListViewModel.makeCallApi();
    }
}