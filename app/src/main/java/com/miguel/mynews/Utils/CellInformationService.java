package com.miguel.mynews.Utils;


import com.miguel.mynews.Models.BusinessResponse;
import com.miguel.mynews.Models.MostPopularResponse;
import com.miguel.mynews.Models.ResearchResponse;
import com.miguel.mynews.Models.TopStoriesResponse;
import com.miguel.mynews.Researchfragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CellInformationService {


    @GET("svc/mostpopular/v2/emailed/7.json")
    Call<MostPopularResponse> getMostPopular(@Query("api-key") String apiKey);

    @GET("svc/topstories/v2/home.json")
    Call<TopStoriesResponse> getTopStories(@Query("api-key") String apiKey);

    @GET("svc/topstories/v2/business.json")
    Call<BusinessResponse> getBusiness(@Query("api-key") String apiKey);

    @GET("svc/search/v2/articlesearch.json")
    Call<ResearchResponse> getSearch(@Query("api-key") String apiKey, @Query("fq") List<String> sectionname, @Query("q") String editText);


    //https://api.nytimes.com/svc/search/v2/articlesearch.json?q=Macron&fq=section_name:("World" "Politics")&begin_date=20191219&end_date=20191226





   //Retrofit retrofit = new Retrofit.Builder()
   //        .baseUrl("https://api.nytimes.com/")
   //        .client(client.build())
   //        .addConverterFactory(GsonConverterFactory.create())
   //        .build();





}
