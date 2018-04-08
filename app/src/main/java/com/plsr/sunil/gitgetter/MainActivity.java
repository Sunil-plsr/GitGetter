package com.plsr.sunil.gitgetter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.plsr.sunil.gitgetter.adapter.RepoAdapter;
import com.plsr.sunil.gitgetter.data.model.Item;
import com.plsr.sunil.gitgetter.data.model.SearchResponse;
import com.plsr.sunil.gitgetter.data.remote.ApiUtils;
import com.plsr.sunil.gitgetter.data.remote.SOService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.plsr.sunil.gitgetter.StaticMethods.displayToast;

public class MainActivity extends AppCompatActivity {

    private SOService mService;
    EditText searchEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mService = ApiUtils.getSOService();

        searchEditText = findViewById(R.id.editTextRepository);


    }

    //will be called when search button is clicked in main activity
    public void searchGitHub(View view) {

        String keyWord = searchEditText.getText().toString();


        mService.getRepositories(keyWord, "stars", "desc").enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {

                if (response.isSuccessful())
                    setListView(response.body().getItems());

                    log(response.body().getItems().get(0).getName());
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {

            }
        });
    }

    private void setListView(List<Item> repositories) {
        if (repositories.size() == 0) {
            displayToast("No Repositories with the search criteria", getApplicationContext());
        } else {
            //ToDo: setup listview here
//            adapter = new RepoAdapter(this, R.layout.row, repositories);
//            listView.setAdapter(adapter);
        }
    }

    private void log(String s) {
        Log.d("demo", s);
    }


}
