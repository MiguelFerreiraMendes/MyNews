package com.miguel.mynews.Utils;

import android.support.annotation.Nullable;

import com.miguel.mynews.Models.CellInformation;

import java.lang.ref.WeakReference;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CellInformationCalls {

    public interface Callbacks {
        void onResponse(@Nullable List<CellInformation> users);
        void onFailure();
    }

    public static void fetchCellInformationTitle(Callbacks callbacks, String title){

        final WeakReference<Callbacks> callbacksWeakReference = new WeakReference<Callbacks>(callbacks);

        CellInformationService cellInformationService = CellInformationService.retrofit.create(CellInformationService.class);

        Call<List<CellInformation>> call = cellInformationService.getTitle(title);
        call.enqueue(new Callback<List<CellInformation>>() {

            @Override
            public void onResponse(Call<List<CellInformation>> call, Response<List<CellInformation>> response) {
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onResponse(response.body());
            }

            @Override
            public void onFailure(Call<List<CellInformation>> call, Throwable t) {
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onFailure();
            }
        });
    }
}
