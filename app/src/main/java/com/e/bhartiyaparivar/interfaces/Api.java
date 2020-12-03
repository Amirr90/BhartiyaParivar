package com.e.bhartiyaparivar.interfaces;

import com.e.bhartiyaparivar.model.OTPResponse;
import com.e.bhartiyaparivar.model.SendOTP;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {

    @POST("userMaster/sendOTP")
    Call<OTPResponse> generateOTP(
            @Body SendOTP otp);
}
