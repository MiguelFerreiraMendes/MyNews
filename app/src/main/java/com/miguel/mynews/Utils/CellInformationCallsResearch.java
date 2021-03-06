package com.miguel.mynews.Utils;

import android.support.annotation.Nullable;
import android.util.Log;

import com.miguel.mynews.BuildConfig;
import com.miguel.mynews.Models.JsonResponseResearch;
import com.miguel.mynews.Models.ResearchResponse;

import java.lang.ref.WeakReference;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CellInformationCallsResearch {

    public static final String API_KEY = BuildConfig.ApiKey;

    public interface Callbacks {
        void onResponse(@Nullable JsonResponseResearch users);
        void onFailure();
    }

    public static void fetchResearch(final CellInformationCallsResearch.Callbacks callbacks, List<String> sectionname, String editText, int date) {

        OkHttpClient.Builder client = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nytimes.com/")
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CellInformationService cellInformationService = retrofit.create(CellInformationService.class);
        Call<ResearchResponse> call = cellInformationService.getSearch(API_KEY, sectionname, editText, date);
        call.enqueue(new Callback<ResearchResponse>() {

            @Override
            public void onResponse(Call<ResearchResponse> call, Response<ResearchResponse> response) {
                callbacks.onResponse(response.body().response);
            }

            @Override
            public void onFailure(Call<ResearchResponse> call, Throwable t) {
                Log.e("test", "throwable", t);
                callbacks.onFailure();
            }
        });
    }}
