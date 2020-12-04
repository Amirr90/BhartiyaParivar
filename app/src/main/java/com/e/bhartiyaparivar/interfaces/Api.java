package com.e.bhartiyaparivar.interfaces;

import com.e.bhartiyaparivar.model.OTPResponse;
import com.e.bhartiyaparivar.model.SendOTP;
import com.e.bhartiyaparivar.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {

    @POST("userMaster/sendOTP")
    Call<Void> generateOTP(
            @Body SendOTP otp);

    @POST("userMaster/verifyOTP")
    Call<String> verifyOTP(
            @Body SendOTP otp);

    @POST("userMaster/getUserDetails")
    Call<List<User>> getUserProfile(
            @Body User user);

    @POST("userMaster/registerUser")
    Call<List<User>> registerUser(
            @Body User user);
}
