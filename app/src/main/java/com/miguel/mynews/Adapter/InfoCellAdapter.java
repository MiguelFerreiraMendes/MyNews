package com.miguel.mynews.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.miguel.mynews.Models.JsonResponse;
import com.miguel.mynews.R;
import com.miguel.mynews.Researchfragment;
import com.miguel.mynews.WebViewActivity;

import java.util.List;

public class InfoCellAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<JsonResponse> mJsonResponseList;

    public InfoCellAdapter(List<JsonResponse> jsonResponseList){
        mJsonResponseList = jsonResponseList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.recyclerview_cell, viewGroup, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final MyViewHolder myViewHolder, int position) {
        myViewHolder.displayResume(mJsonResponseList.get(position));
        myViewHolder.displayDate(mJsonResponseList.get(position));
        myViewHolder.displaySection(mJsonResponseList.get(position));
        myViewHolder.displayPicture(mJsonResponseList.get(position), myViewHolder.itemView.getContext());

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(myViewHolder.itemView.getContext(), WebViewActivity.class);
                    intent.putExtra("url", mJsonResponseList.get(myViewHolder.getAdapterPosition()).getUrl());
                    myViewHolder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mJsonResponseList.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {

    private ImageButton mPicture;
    private TextView mSection;
    private TextView mDate;
    private TextView mResume;

    public MyViewHolder(View itemView) {
        super(itemView);

        mPicture = itemView.findViewById(R.id.imageButton_recycler);
        mSection = itemView.findViewById(R.id.textView);
        mDate = itemView.findViewById(R.id.date_recycler);
        mResume = itemView.findViewById(R.id.resume_recycler);
    }

   void displayPicture(JsonResponse jsonResponse, Context context) {

           String URLPhoto = jsonResponse.getThumbnailUrl();
           Glide.with(context).load(URLPhoto).into(mPicture);

   }

    void displaySection(JsonResponse jsonResponse){
        mSection.setText(jsonResponse.getSection());

    }

    void displayDate(JsonResponse jsonResponse) {
        mDate.setText(jsonResponse.getPublishedDate().subSequence(0,10));

    }

    void displayResume (JsonResponse jsonResponse) {
        mResume.setText(jsonResponse.getTitle());

    }
}
