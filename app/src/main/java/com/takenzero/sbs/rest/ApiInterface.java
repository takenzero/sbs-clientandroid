package com.takenzero.sbs.rest;

import com.takenzero.sbs.model.LoginReq;
import com.takenzero.sbs.model.LoginResp;
import com.takenzero.sbs.model.UserDetail;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @POST("auth/login")
    Call<LoginResp> postLogin(@Header("Client-Service") String clientService,
                              @Header("Auth-Key") String authKey,
                              @Body LoginReq body);

    @GET("user/detail")
    Call<UserDetail> getLogin(@Header("Client-Service") String clientService,
                              @Header("Auth-Key") String authKey,
                              @Header("USER-ID") String idUser,
                              @Header("Authorization") String tokenCode);
}
