package com.e.bhartiyaparivar.utils;

import com.e.bhartiyaparivar.interfaces.Api;

public class URLUtils {
    public static final String BASE_URL = "http://bankjaal.in/api/";

    public static Api getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(Api.class);
    }
}
