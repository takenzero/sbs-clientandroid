package com.takenzero.sbs.rest;

import com.takenzero.sbs.model.DownlineResp;
import com.takenzero.sbs.model.LoginReq;
import com.takenzero.sbs.model.LoginResp;
import com.takenzero.sbs.model.UserDetailResp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {
    @POST("auth/login")
    Call<LoginResp> postLogin(@Header("Client-Service") String clientService,
                              @Header("Auth-Key") String authKey,
                              @Body LoginReq body);

    @GET("user/detail/{id_user}")
    Call<UserDetailResp> getUserDetail(@Header("Client-Service") String clientService,
                                       @Header("Auth-Key") String authKey,
                                       @Header("Authorization") String tokenCode,
                                       @Path("id_user") String idUser);

    @GET("user/downline/{id_user}")
    Call<DownlineResp> getDownline(@Header("Client-Service") String clientService,
                                   @Header("Auth-Key") String authKey,
                                   @Header("Authorization") String tokenCode,
                                   @Path("id_user") String idUser);
}
