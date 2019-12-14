package com.miguel.mynews;

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
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.miguel.mynews.Adapter.InfoCellAdapter;
import com.miguel.mynews.Models.JsonResponse;
import com.miguel.mynews.Utils.CellInformationCalls;

import java.util.List;



public class MostPopularfragment extends Fragment implements CellInformationCalls.Callbacks {

    public static int JsonId = 2;
    private ProgressBar progressBar;
    private View result;
    private RecyclerView mRecyclerView;
    private List<JsonResponse> test;

    public static MostPopularfragment newInstance() {
        MostPopularfragment frag1 = new MostPopularfragment();
        Log.i("test", "3");
        return (frag1);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.mostpopular, container, false);
        RelativeLayout rootView = result.findViewById(R.id.relativelayout);
        this.progressBar = result.findViewById(R.id.mostpop_progress_bar);
        this.result = result;

        progressBar.setVisibility(View.VISIBLE);
        executeHttpRequestWithRetrofit();
        RecyclerView recyclerView = result.findViewById(R.id.recycleview_view_mostpop);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        this.mRecyclerView = recyclerView;

        return result;
    }

    @Override
    public void onResponse(@Nullable List<JsonResponse> mostpopularList) {
        Toast.makeText(getContext(), "Sucess", Toast.LENGTH_LONG).show();
        Log.i("test", "sucess most pop");

        updateRecycleView(mostpopularList, mRecyclerView);


    }


    @Override
    public void onFailure() {
        Toast.makeText(getContext(), "Failed mostpop", Toast.LENGTH_LONG).show();
        Log.i("test", "failed mostpop");

    }

    public void executeHttpRequestWithRetrofit() {
        CellInformationCalls.fetchMostPopularList(this);
    }

    public void updateRecycleView (List<JsonResponse> jsonResponseList, RecyclerView recyclerView) {

       InfoCellAdapter mondapteur;
       mondapteur = new InfoCellAdapter(jsonResponseList, getContext(), JsonId);
       recyclerView.setAdapter(mondapteur);
       progressBar.setVisibility(View.INVISIBLE);
    }
}
