package com.miguel.mynews;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.miguel.mynews.Adapter.InfoCellAdapter;
import com.miguel.mynews.Adapter.InfoCellAdapterResearch;
import com.miguel.mynews.Models.JsonResponse;
import com.miguel.mynews.Models.JsonResponseResearch;
import com.miguel.mynews.Utils.CellInformationCalls;
import com.miguel.mynews.Utils.CellInformationCallsResearch;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class Researchfragment extends Fragment implements CellInformationCallsResearch.Callbacks {

    private ProgressBar progressBar;
    private RecyclerView mRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.research, container, false);

        this.progressBar = result.findViewById(R.id.research_progress_bar);
        progressBar.setVisibility(View.VISIBLE);
        RecyclerView recyclerView = result.findViewById(R.id.recycleview_view_research);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        this.mRecyclerView = recyclerView;
        researchFilterAndLaunchRetrofit();

        return result;
    }





    @Override
    public void onResponse(JsonResponseResearch jsonResponseList) {

        Toast.makeText(getContext(), "sucess research", Toast.LENGTH_LONG).show();
        Log.i("json", "json quand on le récup dans le on response" + jsonResponseList);
        Log.i("test", "sucess research");

        updateRecycleView(jsonResponseList, mRecyclerView);


    }

    @Override
    public void onFailure() {
        Toast.makeText(getContext(), "Failed research", Toast.LENGTH_LONG).show();
        Log.i("test", "Failed reasearch");

    }

    public void executeHttpRequestWithRetrofit(List<String> sectionname, String editText) {
        CellInformationCallsResearch.fetchResearch(this, sectionname, editText);
    }

    public void updateRecycleView (JsonResponseResearch jsonResponseList, RecyclerView recyclerView) {

        Log.i("json", "json quand on le passe a update recycleview" + jsonResponseList);

        InfoCellAdapterResearch mondapteur;
        mondapteur = new InfoCellAdapterResearch(jsonResponseList, getContext());
        recyclerView.setAdapter(mondapteur);
        progressBar.setVisibility(View.INVISIBLE);
    }

    private void researchFilterAndLaunchRetrofit() {

        SharedPreferences mSharedPreferences = getActivity().getSharedPreferences("checkbox",MODE_PRIVATE);
        List<String> tagList = new ArrayList<>();

        String editText = mSharedPreferences.getString("editText", "");
        Log.i("editText","editText quand on le récup dans le second fragment" + editText);
        if (mSharedPreferences.getString("Art", "defValue").equals("Artcheck")){
            tagList.add("\"Art\"");
        }
        if (mSharedPreferences.getString("Business", "defValue").equals("Businesscheck")){
            tagList.add("\"Business\"");
        }
        if (mSharedPreferences.getString("Travel", "defValue").equals("Travelcheck")){
            tagList.add("\"Travel\"");
        }
        if (mSharedPreferences.getString("Politics", "defValue").equals("Politicscheck")){
            tagList.add("\"Politics\"");
        }
        if (mSharedPreferences.getString("Sports", "defValue").equals("Sportscheck")){
            tagList.add("\"Sports\"");
        }
        if (mSharedPreferences.getString("Entrepreneurs", "defValue").equals("Entrepreneurscheck")){
            tagList.add("\"Entrepreneurs\"");
            Log.i("list", "list de tags : " + tagList);
        }

        executeHttpRequestWithRetrofit(tagList, editText);


}

}
