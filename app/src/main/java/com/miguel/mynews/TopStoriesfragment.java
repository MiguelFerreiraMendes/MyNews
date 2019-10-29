package com.miguel.mynews;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.miguel.mynews.Adapter.InfoCellAdapter;


public class TopStoriesfragment extends Fragment {

    public TopStoriesfragment(){}

    public static TopStoriesfragment newInstance() {
        TopStoriesfragment frag1 = new TopStoriesfragment();
        return(frag1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.topstories, container, false);
        RelativeLayout rootView = result.findViewById(R.id.relativelayout);
        RecyclerView recyclerView = result.findViewById(R.id.recycleview_view);
        return result;

    }

    RecyclerView mRecyclerView;
    InfoCellAdapter monadapteur;

}