package com.miguel.mynews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public class InfoCellAdapter extends RecyclerView.Adapter<MyViewHolder> {

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.recyclerview_cell, viewGroup, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {

    private ImageButton mPicture;
    private TextView mContinent;
    private TextView mCountry;
    private TextView mDate;
    private TextView mResume;

    public MyViewHolder(View itemView) {
        super(itemView);

        mPicture = itemView.findViewById(R.id.imageButton_recycler);
        mContinent = itemView.findViewById(R.id.textView);
        mCountry = itemView.findViewById(R.id.textView2_recycler);
        mDate = itemView.findViewById(R.id.date_recycler);
        mResume = itemView.findViewById(R.id.resume_recycler);
    }

    void displayAll(){
        displayPicture();
        displayContinent();
        displayCountry();
        displayDate();
        displayResume();
    }

    void displayPicture(){

    }

    void displayContinent(){

    }

    void displayCountry() {

    }

    void displayDate() {

    }

    void displayResume () {

    }








}
