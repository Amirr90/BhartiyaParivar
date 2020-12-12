package com.e.bhartiyaparivar;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.e.bhartiyaparivar.databinding.ActivitySignupBinding;

import java.util.Locale;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignupBinding signUpBinding;
    NavController navController;

    public static SignUpActivity instance;

    public static SignUpActivity getInstance() {
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signUpBinding = DataBindingUtil.setContentView(this, R.layout.activity_signup);
        instance = this;
    }

    @Override
    protected void onStart() {
        super.onStart();
        instance = this;
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);



    }



    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp();
    }
}