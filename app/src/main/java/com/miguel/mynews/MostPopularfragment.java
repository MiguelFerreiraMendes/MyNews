package com.miguel.mynews;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.miguel.mynews.Adapter.InfoCellAdapter;
import com.miguel.mynews.Models.MostPopular;

import java.util.ArrayList;


public class MostPopularfragment extends Fragment {

    public static TopStoriesfragment newInstance() {
        TopStoriesfragment frag1 = new TopStoriesfragment();
        return(frag1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.tab_fragment1, container, false);
        RelativeLayout rootView = result.findViewById(R.id.relativelayout);
        Bundle bundle = new Bundle();
        ArrayList<String> mostpopularlist = bundle.getStringArrayList("mostpopularArrayList");
        return result;


        InfoCellAdapter mondapteur;
        RecyclerView recyclerView = result.findViewById(R.id.recycleview_view);
        mondapteur = new InfoCellAdapter(mostpopularlist);
        recyclerView.setAdapter(mondapteur);

    }

}