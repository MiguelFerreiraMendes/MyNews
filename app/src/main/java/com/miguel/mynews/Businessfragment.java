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

import java.util.ArrayList;
import java.util.List;

public class Businessfragment extends Fragment implements CellInformationCalls.Callbacks {

    public static int JsonId = 3;
    private ProgressBar progressBar;
    private View result;
    private RecyclerView mRecyclerView;

    public static Businessfragment newInstance() {
        Businessfragment frag1 = new Businessfragment();
        return(frag1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.business, container, false);
        RelativeLayout rootView = result.findViewById(R.id.relativelayout);
        this.progressBar = result.findViewById(R.id.business_progress_bar);
        this.result = result;
        RecyclerView recyclerView = result.findViewById(R.id.recycleview_view_business);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        this.mRecyclerView = recyclerView;

        progressBar.setVisibility(View.VISIBLE);
        executeHttpRequestWithRetrofit();

        return result;

    }

    @Override
    public void onResponse(List<JsonResponse> jsonResponseList) {

        Toast.makeText(getContext(), "sucess Business", Toast.LENGTH_LONG).show();
        Log.i("test", "sucess Business");

        updateRecycleView(jsonResponseList, mRecyclerView);

    }

    @Override
    public void onFailure() {
        Toast.makeText(getContext(), "Failed Business", Toast.LENGTH_LONG).show();
        Log.i("test", "Failed Business");

    }

    public void executeHttpRequestWithRetrofit() {
        CellInformationCalls.fetchBusiness(this);
    }

    public void updateRecycleView (List<JsonResponse> jsonResponseList, RecyclerView recyclerView) {

        InfoCellAdapter mondapteur;
        mondapteur = new InfoCellAdapter(jsonResponseList, getContext(), JsonId);
        recyclerView.setAdapter(mondapteur);
        progressBar.setVisibility(View.INVISIBLE);
    }

}

