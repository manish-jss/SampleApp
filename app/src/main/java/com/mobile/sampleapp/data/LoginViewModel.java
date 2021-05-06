package com.mobile.sampleapp.data;

import android.content.Context;
import android.content.Intent;
import android.util.Patterns;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.mobile.sampleapp.BR;
import com.mobile.sampleapp.ui.MovieGridActivity;

public class LoginViewModel extends BaseObservable {
    public static final int ACTION_NAVIGATE_TO_NEXT = 1000;
    private final LoginModel loginModel;
    private boolean buttonEnable=false;

    public LoginViewModel() {
        loginModel = new LoginModel("", "");
    }

    @Bindable
    public boolean getButtonEnable() {
        return buttonEnable;
    }

    @Bindable
    public String getUserEmail() {
        return loginModel.getEmail();
    }

    public void setUserEmail(String email) {
        loginModel.setEmail(email);
        buttonEnable=isValidEmailPassword(loginModel.getEmail(),loginModel.getPassword());
        notifyPropertyChanged(BR.userEmail);
        notifyPropertyChanged(BR.buttonEnable);
    }

    // getter and setter methods
    // for password variable
    @Bindable
    public String getUserPassword() {
        return loginModel.getPassword();
    }

    public void setUserPassword(String password) {
        loginModel.setPassword(password);
        buttonEnable=isValidEmailPassword(loginModel.getEmail(),loginModel.getPassword());
        notifyPropertyChanged(BR.userPassword);
        notifyPropertyChanged(BR.buttonEnable);
    }

    public boolean isValidEmailPassword(String email, String password) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length() >= 8 && password.length() <= 15;
    }

    public void onLoginClicked(View view) {
        Context context = view.getContext();
        Intent intent = new Intent(context, MovieGridActivity.class);
        context.startActivity(intent);
    }

}
