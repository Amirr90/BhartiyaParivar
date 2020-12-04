package com.e.bhartiyaparivar.utils;

import com.e.bhartiyaparivar.interfaces.Api;
import com.e.bhartiyaparivar.interfaces.ApiInterface;
import com.e.bhartiyaparivar.model.SendOTP;
import com.e.bhartiyaparivar.model.User;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiUtils {


    public static void generateOTP(SendOTP otpModel, final ApiInterface apiInterface) {
        try {
            Api iRestInterfaces = URLUtils.getAPIService();
            Call<Void> call = iRestInterfaces.generateOTP(otpModel);
            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(@NotNull Call<Void> call, @NotNull Response<Void> response) {
                    if (response.code() == 200) {
                        apiInterface.onSuccess("sent");
                    } else apiInterface.onFailed("Error " + response.code());
                }

                @Override
                public void onFailure(@NotNull Call<Void> call, @NotNull Throwable t) {
                    apiInterface.onFailed(t.getLocalizedMessage());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void verifyOTP(SendOTP otp, final ApiInterface apiInterface) {
        try {
            Api iRestInterfaces = URLUtils.getAPIService();
            Call<String> call = iRestInterfaces.verifyOTP(otp);
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(@NotNull Call<String> call, @NotNull Response<String> response) {
                    if (response.code() == 200) {
                        apiInterface.onSuccess("sent");
                    } else apiInterface.onFailed("Error " + response.code());
                }

                @Override
                public void onFailure(@NotNull Call<String> call, @NotNull Throwable t) {
                    apiInterface.onFailed(t.getLocalizedMessage());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void registerUser(User user, final ApiInterface apiInterface) {
        try {
            Api iRestInterfaces = URLUtils.getAPIService();
            Call<List<User>> call = iRestInterfaces.registerUser(user);
            call.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(@NotNull Call<List<User>> call, @NotNull Response<List<User>> response) {
                    if (response.code() == 200) {
                        apiInterface.onSuccess(response.body().get(0));
                    } else apiInterface.onFailed("Error " + response.code());
                }

                @Override
                public void onFailure(@NotNull Call<List<User>> call, @NotNull Throwable t) {
                    apiInterface.onFailed(t.getLocalizedMessage());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void getUserProfile(User user, final ApiInterface apiInterface) {
        try {
            Api iRestInterfaces = URLUtils.getAPIService();
            Call<List<User>> call = iRestInterfaces.getUserProfile(user);
            call.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(@NotNull Call<List<User>> call, @NotNull Response<List<User>> response) {
                    if (response.code() == 200) {
                        apiInterface.onSuccess("sent");
                    } else apiInterface.onFailed("Error " + response.code());
                }

                @Override
                public void onFailure(@NotNull Call<List<User>> call, @NotNull Throwable t) {
                    apiInterface.onFailed(t.getLocalizedMessage());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
