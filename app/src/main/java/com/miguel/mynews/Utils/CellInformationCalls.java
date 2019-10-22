package com.miguel.mynews.Utils;

import android.support.annotation.Nullable;
import android.util.Log;

import com.miguel.mynews.Models.MostPopular;
import com.miguel.mynews.Models.MostPopularResponse;

import java.lang.ref.WeakReference;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CellInformationCalls {

    public static final String API_KEY = "SU6O2eY4HxGANHJGjiaEGYnOsXszUzyJ";

    public interface Callbacks {
        void onResponse(@Nullable List<MostPopular> users);
        void onFailure();
    }

    public static void fetchMostPopularList(Callbacks callbacks){

        final WeakReference<Callbacks> callbacksWeakReference = new WeakReference<Callbacks>(callbacks);

        CellInformationService cellInformationService = CellInformationService.retrofit.create(CellInformationService.class);

        Call<MostPopularResponse> call = cellInformationService.getMostPopular(API_KEY);
        call.enqueue(new Callback<MostPopularResponse>() {

            @Override
            public void onResponse(Call<MostPopularResponse> call, Response<MostPopularResponse> response) {
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onResponse(response.body().results);
                Log.i("tag", "response" + response+ "call" + call);
            }

            @Override
            public void onFailure(Call<MostPopularResponse> call, Throwable t) {
                Log.e("test", "", t);
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onFailure();
            }

        });
    }
}
