package com.example.faraday.sqlitepage.initial.utils;

import com.example.faraday.sqlitepage.initial.objects.LoginResponse;
import com.example.faraday.sqlitepage.initial.objects.TeamList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIInterface {


    @FormUrlEncoded
    @POST("Rest/login")
    Call<LoginResponse> login(@Field("email") String email,@Field("password") String password,@Field("android_id") String androidid);



}
