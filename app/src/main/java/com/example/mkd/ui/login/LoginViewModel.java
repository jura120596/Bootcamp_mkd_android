package com.example.mkd.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.util.Patterns;

import com.example.mkd.ServerHelper;
import com.example.mkd.Storage;
import com.example.mkd.data.LoginDataSource;
import com.example.mkd.data.LoginRepository;
import com.example.mkd.data.Result;
import com.example.mkd.data.model.LoggedInUser;
import com.example.mkd.R;
import com.example.mkd.retrofit.requestbody.AuthBody;
import com.example.mkd.retrofit.requestbody.AuthResponse;
import com.example.mkd.retrofit.retorfitservices.ServerAuthService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    private MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    private LoginRepository loginRepository;

    LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    LiveData<LoginFormState> getLoginFormState() {
        return loginFormState;
    }

    LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    public void login(String username, String password) {
        // can be launched in a separate asynchronous job
        Retrofit r = ServerHelper.getRetrofit();
        ServerAuthService s = r.create(ServerAuthService.class);
        Call<AuthResponse> call = s.loginBody(new AuthBody(username, password));
        call.enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                System.out.println(response.code());
                if (response.code() == 200) {
                    LoggedInUser user = new LoggedInUser(
                            response.body().getUser().getId(),
                            response.body().getUser().getUsername(),
                            response.body().getToken()
                    );
                    Storage.user = user;
                    loginResult.setValue(new LoginResult(new LoggedInUserView(user.getDisplayName())));
                }
            }

            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {
                t.printStackTrace();
                loginResult.setValue(new LoginResult(R.string.login_failed));
            }
        });

    }

    public void loginDataChanged(String username, String password) {
        if (!isUserNameValid(username)) {
            loginFormState.setValue(new LoginFormState(R.string.invalid_username, null));
        } else if (!isPasswordValid(password)) {
            loginFormState.setValue(new LoginFormState(null, R.string.invalid_password));
        } else {
            loginFormState.setValue(new LoginFormState(true));
        }
    }

    // A placeholder username validation check
    private boolean isUserNameValid(String username) {
        if (username == null) {
            return false;
        }
        if (username.contains("@")) {
            return Patterns.EMAIL_ADDRESS.matcher(username).matches();
        } else {
            return !username.trim().isEmpty();
        }
    }

    // A placeholder password validation check
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }
}
