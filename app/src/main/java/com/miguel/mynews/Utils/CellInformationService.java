package com.miguel.mynews.Utils;


import com.miguel.mynews.Models.MostPopularResponse;


import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CellInformationService {

    @GET("svc/mostpopular/v2/viewed/1.json")
    Call<MostPopularResponse> getMostPopular(@Query("api-key") String apiKey);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
