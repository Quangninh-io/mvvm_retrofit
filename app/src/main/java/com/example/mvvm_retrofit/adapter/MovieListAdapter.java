package com.example.mvvm_retrofit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm_retrofit.R;
import com.example.mvvm_retrofit.model.MovieModel;
import com.example.mvvm_retrofit.network.ApiService;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder> {

    private Context context;
    private List<MovieModel> mList;

    public MovieListAdapter(Context context, List<MovieModel> mList) {
        this.context = context;
        this.mList = mList;
    }

    public void setList(List<MovieModel> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_movie, null, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle, txtBody;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtBody = itemView.findViewById(R.id.txt_body);
            txtTitle = itemView.findViewById(R.id.txt_title);
        }

        public void bind(MovieModel movieModel) {
            txtTitle.setText(movieModel.getTitle());
            txtBody.setText(movieModel.getBody());
        }


    }
}
