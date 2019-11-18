package com.miguel.mynews.Utils;


import com.miguel.mynews.Models.MostPopularResponse;


import okhttp3.OkHttpClient;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CellInformationService {


    @GET("svc/mostpopular/v2/viewed/1.json")
    Call<MostPopularResponse> getMostPopular(@Query("api-key") String apiKey);

   // @GET("svc/mostpopular/v2/viewed/1.json")
   // Call<TopStoriesResponse> getTopStories(@Query("api-key") String apiKey);;




   //Retrofit retrofit = new Retrofit.Builder()
   //        .baseUrl("https://api.nytimes.com/")
   //        .client(client.build())
   //        .addConverterFactory(GsonConverterFactory.create())
   //        .build();





}
