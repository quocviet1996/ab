package com.example.didongdn.api;

import com.example.didongdn.model.Nguoidung;
import com.example.didongdn.model.Topic;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataService {
    @GET("topics")
    Call<List<Topic>> GetDataTopic();

    @FormUrlEncoded
    @POST("auth/login")
    Call<List<Nguoidung>> LoginData(@Field("email") String email,@Field("password") String password);
}
