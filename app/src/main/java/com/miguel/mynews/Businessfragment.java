package com.miguel.mynews;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Businessfragment extends Fragment {

    public static TopStoriesfragment newInstance() {
        TopStoriesfragment frag1 = new TopStoriesfragment();
        return(frag1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.tab_fragment3, container, false);
    }

}