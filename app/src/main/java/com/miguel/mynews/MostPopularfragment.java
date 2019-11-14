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
import com.miguel.mynews.Models.MostPopular;
import com.miguel.mynews.Utils.CellInformationCalls;

import java.util.ArrayList;
import java.util.List;


public class MostPopularfragment extends Fragment implements CellInformationCalls.Callbacks {

    public String KEYLIST = "mostpopularArrayList";
    private ProgressBar progressBar;
    private List<MostPopular> mostpopularlist;
    private View result;

    public static MostPopularfragment newInstance() {
        MostPopularfragment frag1 = new MostPopularfragment();
        Log.i("test", "3");
        return(frag1);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.mostpopular, container, false);
        RelativeLayout rootView = result.findViewById(R.id.relativelayout);
        this.progressBar = result.findViewById(R.id.mostpop_progress_bar);
        this.result = result;

     //   Bundle bundle = new Bundle();

    //   if (mostpopularlist == null) {
    progressBar.setVisibility(View.VISIBLE);
    executeHttpRequestWithRetrofit();
    //       isRequestFinish(bundle);
    //   }

    //   if (isRequestFinish(bundle)) {
    //       List<MostPopular> mostpopularlist = (List<MostPopular>) bundle.getSerializable("KEYLIST");
    //       Log.i("list", "list quand on la récup" + mostpopularlist);
    //       InfoCellAdapter mondapteur;
    //       RecyclerView recyclerView = result.findViewById(R.id.recycleview_view);
    //       recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    //       mondapteur = new InfoCellAdapter(mostpopularlist);
    //       recyclerView.setAdapter(mondapteur);
    //   }
    //
        return result;
    }

    @Override
    public void onResponse(@Nullable List<MostPopular> mostpopularList) {
        Toast.makeText(getContext(), "Sucess", Toast.LENGTH_LONG).show();
        Log.i("test", "OnResponse" + mostpopularList);
        ArrayList<MostPopular> mostpopularListArrayList = new ArrayList<>(mostpopularList);

        Bundle bundle = new Bundle();
        bundle.putSerializable(KEYLIST, mostpopularListArrayList);
        InfoCellAdapter mondapteur;
        RecyclerView recyclerView = result.findViewById(R.id.recycleview_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mondapteur = new InfoCellAdapter(mostpopularlist);
        recyclerView.setAdapter(mondapteur);


    }

    @Override
    public void onFailure() {
        Toast.makeText(getContext(),"Failed", Toast.LENGTH_LONG).show();
        Log.i("test", "failed");

    }
    public void executeHttpRequestWithRetrofit(){
        CellInformationCalls.fetchMostPopularList(this);
    }


    public boolean isRequestFinish(Bundle bundle){
        return (List<MostPopular>) bundle.getSerializable("KEYLIST") != null;
    }

    public static Long waitForResponse(){

        Long endTime = System.currentTimeMillis() + 1000;
        while (System.currentTimeMillis() <  endTime) {
            //Loop
        }

        return endTime;
    }
}