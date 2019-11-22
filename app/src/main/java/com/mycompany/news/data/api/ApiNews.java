package com.mycompany.news.data.api;

import com.mycompany.news.data.model.News;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiNews {
    @GET("v2/top-headlines")
    Single<News> getTopHeadlinesNews(@Query("country") String country, @Query("apiKey") String apiKey);

    @GET("v2/everything")
    Single<News> getEverythingNews(@Query("country") String country, @Query("apiKey") String apiKey);
}
