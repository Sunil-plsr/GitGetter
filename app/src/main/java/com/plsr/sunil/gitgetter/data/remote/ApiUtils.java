package com.plsr.sunil.gitgetter.data.remote;

/**
 * Created by sunil on 3/19/18.
 */

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "https://api.github.com/";

    public static SOService getSOService() {

        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }

}
