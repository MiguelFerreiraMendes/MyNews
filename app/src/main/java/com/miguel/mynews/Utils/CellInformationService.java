package com.miguel.mynews.Utils;

import com.miguel.mynews.Models.CellInformation;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CellInformationService {

    @GET("svc/{blabla}/v2/emailed/7.json?api-key=SU6O2eY4HxGANHJGjiaEGYnOsXszUzyJ")
    Call<List<CellInformation>> getTitle(@Path("blabla") String test);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}