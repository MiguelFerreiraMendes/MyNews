package com.miguel.mynews.Utils;

import android.support.annotation.Nullable;
import android.util.Log;

import com.miguel.mynews.BuildConfig;
import com.miguel.mynews.Models.BusinessResponse;
import com.miguel.mynews.Models.JsonResponse;
import com.miguel.mynews.Models.MostPopularResponse;
import com.miguel.mynews.Models.ResearchResponse;
import com.miguel.mynews.Models.TopStoriesResponse;

import java.lang.ref.WeakReference;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CellInformationCalls {

    public static final String API_KEY = BuildConfig.ApiKey;

    public interface Callbacks {
        void onResponse(@Nullable List<JsonResponse> users);
        void onFailure();
    }

    public static void fetchMostPopularList(Callbacks callbacks){

        final WeakReference<Callbacks> callbacksWeakReference = new WeakReference<Callbacks>(callbacks);
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.addInterceptor(loggingInterceptor);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nytimes.com/")
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CellInformationService cellInformationService = retrofit.create(CellInformationService.class);


        Call<MostPopularResponse> call = cellInformationService.getMostPopular(API_KEY);
        call.enqueue(new Callback<MostPopularResponse>() {

            @Override
            public void onResponse(Call<MostPopularResponse> call, Response<MostPopularResponse> response) {
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onResponse(response.body().results);
                Log.i("tag", "response" + response+ "call" + call);

            }

            @Override
            public void onFailure(Call<MostPopularResponse> call, Throwable t) {
                Log.e("test", "throwable", t);
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onFailure();
            }

        });
    }

    public static void fetchMostTopStories(Callbacks callbacks){
        final WeakReference<Callbacks> callbacksWeakReference = new WeakReference<Callbacks>(callbacks);
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.addInterceptor(loggingInterceptor);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nytimes.com/")
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CellInformationService cellInformationService = retrofit.create(CellInformationService.class);


        Call<TopStoriesResponse> call = cellInformationService.getTopStories(API_KEY);
        call.enqueue(new Callback<TopStoriesResponse>() {

            @Override
            public void onResponse(Call<TopStoriesResponse> call, Response<TopStoriesResponse> response) {
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onResponse(response.body().results);
                Log.i("tag", "response" + response+ "call" + call);

            }

            @Override
            public void onFailure(Call<TopStoriesResponse> call, Throwable t) {
                Log.e("test", "throwable", t);
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onFailure();
            }

        });
    }
    public static void fetchBusiness(Callbacks callbacks){
        final WeakReference<Callbacks> callbacksWeakReference = new WeakReference<Callbacks>(callbacks);
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.addInterceptor(loggingInterceptor);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nytimes.com/")
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CellInformationService cellInformationService = retrofit.create(CellInformationService.class);


        Call<BusinessResponse> call = cellInformationService.getBusiness(API_KEY);
        call.enqueue(new Callback<BusinessResponse>() {

            @Override
            public void onResponse(Call<BusinessResponse> call, Response<BusinessResponse> response) {
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onResponse(response.body().results);
                Log.i("tag", "response" + response+ "call" + call);

            }

            @Override
            public void onFailure(Call<BusinessResponse> call, Throwable t) {
                Log.e("test", "throwable", t);
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onFailure();
            }

        });
    }

  // public static void fetchResearch(Callbacks callbacks, String sectionname, String editText){
  //     final WeakReference<Callbacks> callbacksWeakReference = new WeakReference<Callbacks>(callbacks);
  //     OkHttpClient.Builder client = new OkHttpClient.Builder();
  //     HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
  //     loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
  //     client.addInterceptor(loggingInterceptor);
  //     Retrofit retrofit = new Retrofit.Builder()
  //             .baseUrl("https://api.nytimes.com/")
  //             .client(client.build())
  //             .addConverterFactory(GsonConverterFactory.create())
  //             .build();
  //     CellInformationService cellInformationService = retrofit.create(CellInformationService.class);


  //     Call<ResearchResponse> call = cellInformationService.getSearch(API_KEY, sectionname, editText);
  //     call.enqueue(new Callback<ResearchResponse>() {

  //         @Override
  //         public void onResponse(Call<ResearchResponse> call, Response<ResearchResponse> response) {
  //             if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onResponse(response.body().results);
  //             Log.i("tag", "response" + response+ "call" + call);

  //         }

  //         @Override
  //         public void onFailure(Call<ResearchResponse> call, Throwable t) {
  //             Log.e("test", "throwable", t);
  //             if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onFailure();
  //         }

  //     });
    // }
}
