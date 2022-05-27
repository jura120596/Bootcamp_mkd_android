package com.example.mkd.retrofit.retorfitservices;

import com.example.mkd.retrofit.requestbody.AuthBody;
import com.example.mkd.retrofit.requestbody.AuthResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ServerAuthService {

    @POST("/auth/login")
    Call<Void> login(
            @Query("login") String login,
            @Query("password") String password
    );
    @POST("auth/login")
    Call<AuthResponse> loginBody(
            @Body AuthBody body
    );
}
