package com.miguel.mynews;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.miguel.mynews.Models.JsonResponse;
import com.miguel.mynews.Utils.CellInformationCalls;

import java.util.List;

public class Researchfragment extends Fragment implements CellInformationCalls.Callbacks {

    private ProgressBar progressBar;
    private RecyclerView mRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.research, container, false);

        this.mRecyclerView = result.findViewById(R.id.recycleview_view_research);
        this.progressBar = result.findViewById(R.id.research_progress_bar);
        progressBar.setVisibility(View.VISIBLE);

        return result;
    }










    @Override
    public void onResponse(@Nullable List<JsonResponse> users) {

    }

    @Override
    public void onFailure() {

    }
}
