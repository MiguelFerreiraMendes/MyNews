package com.miguel.mynews.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.miguel.mynews.Models.MostPopular;
import com.miguel.mynews.MostPopularfragment;
import com.miguel.mynews.R;

import java.util.ArrayList;
import java.util.List;

public class InfoCellAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<MostPopular> mMostPopularList;

    public InfoCellAdapter(List<MostPopular> mostPopularList){
        mMostPopularList = mostPopularList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.recyclerview_cell, viewGroup, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        myViewHolder.displayCountry(mMostPopularList.get(position));


    }

    @Override
    public int getItemCount() {
        return mMostPopularList.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {

    private ImageButton mPicture;
    private TextView mContinent;
    private TextView mCountry;
    private TextView mDate;
    private TextView mResume;
    private WebView mWebView;

    public MyViewHolder(View itemView) {
        super(itemView);

        mPicture = itemView.findViewById(R.id.imageButton_recycler);
        mContinent = itemView.findViewById(R.id.textView);
        mCountry = itemView.findViewById(R.id.textView2_recycler);
        mDate = itemView.findViewById(R.id.date_recycler);
        mResume = itemView.findViewById(R.id.resume_recycler);
    }


    void displayPicture(){

    }

    void displayContinent(){

    }

    void displayCountry(MostPopular mostPopular) {
        mCountry.setText(mostPopular.getGeo());

    }

    void displayDate() {

    }

    void displayResume () {

    }








}
