package com.plsr.sunil.gitgetter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.plsr.sunil.gitgetter.data.model.SearchResponse;
import com.plsr.sunil.gitgetter.data.remote.ApiUtils;
import com.plsr.sunil.gitgetter.data.remote.SOService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private SOService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mService = ApiUtils.getSOService();

        loadRepositories();
    }

    private void loadRepositories() {
        mService.getRepositories("customNotify", "stars", "desc").enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {

                if (response.isSuccessful())
                    log(response.body().getItems().get(0).getName());
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {

            }
        });
    }

    private void log(String s) {
        Log.d("demo", s);
    }
}
