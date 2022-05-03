package com.example.mvvm_retrofit.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    private static final Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static final Retrofit retrofit = retrofitBuilder.build();

    private static final ApiService requestApi = retrofit.create(ApiService.class);

    public static ApiService getRetroClient(){
        return requestApi;
    }
}
