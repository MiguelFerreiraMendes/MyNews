package com.miguel.mynews.Utils;

import android.support.annotation.Nullable;
import android.util.Log;

import com.miguel.mynews.BuildConfig;
import com.miguel.mynews.Models.MostPopular;
import com.miguel.mynews.Models.MostPopularResponse;

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
        void onResponse(@Nullable List<MostPopular> users);
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
        Log.i("test", "avant");
        CellInformationService cellInformationService = retrofit.create(CellInformationService.class);
        Log.i("test", "après");


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
}
