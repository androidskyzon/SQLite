package com.example.faraday.sqlitepage.initial.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {

    private static Retrofit retrofit=null;

    public static APIInterface getservices(){

        if(retrofit==null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl("https://rabbitcrm.com/taskApp/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        APIInterface apiInterface = retrofit.create(APIInterface.class);
        return  apiInterface;

    }
}
