package com.example.hackathonfinale.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App {

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.43.161:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public static ApiService getApi() {
        return retrofit.create(ApiService.class);
    }

}
