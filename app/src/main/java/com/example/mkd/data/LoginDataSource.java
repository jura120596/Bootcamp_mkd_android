package com.example.mkd.data;

import com.example.mkd.ServerHelper;
import com.example.mkd.data.model.LoggedInUser;
import com.example.mkd.retrofit.requestbody.AuthBody;
import com.example.mkd.retrofit.requestbody.AuthResponse;
import com.example.mkd.retrofit.retorfitservices.ServerAuthService;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication

        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
        return new Result.Error(new IOException("Error logging in", new Exception()));
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
