package com.e.bhartiyaparivar.utils;

import com.e.bhartiyaparivar.interfaces.Api;
import com.e.bhartiyaparivar.interfaces.ApiInterface;
import com.e.bhartiyaparivar.model.OTPResponse;
import com.e.bhartiyaparivar.model.SendOTP;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiUtils {


    public static void generateOTP(SendOTP otpModel, final ApiInterface apiInterface) {
        try {
            Api iRestInterfaces = URLUtils.getAPIService();
            Call<OTPResponse> call = iRestInterfaces.generateOTP(otpModel);
            call.enqueue(new Callback<OTPResponse>() {
                @Override
                public void onResponse(@NotNull Call<OTPResponse> call, @NotNull Response<OTPResponse> response) {
                    if (response.code() == 200) {
                        apiInterface.onSuccess("1234");
                    } else apiInterface.onFailed("Error " + response.code());
                }

                @Override
                public void onFailure(@NotNull Call<OTPResponse> call, @NotNull Throwable t) {
                    apiInterface.onFailed(t.getLocalizedMessage());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
