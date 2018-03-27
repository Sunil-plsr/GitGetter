package com.plsr.sunil.gitgetter.data.remote;

import com.plsr.sunil.gitgetter.data.model.SearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by sunil on 3/19/18.
 */

public interface SOService {

    /**
     * Master:
     * /search/repositories?q=customnotify&sort=stars&order=desc
     */
    @GET("/search/repositories?q=customnotify&sort=stars&order=desc")
    Call<SearchResponse> getRepositories();



    /**
     * getRepositories("repositories")
     * is equal to master
     */
    @GET("/search/{searchIn}?q=customNotify&sort=stars&order=desc")
    Call<SearchResponse> getRepositories(@Path("searchIn") String searchIn);



    /**
     * getRepositories("customNotify", "stars", "desc")
     * is equal to master
     */
    @GET("/search/repositories")
    Call<SearchResponse> getRepositories(@Query("q") String searchKeyword,
                                         @Query("sort") String sortBy,
                                         @Query("order") String orderBy);

}
