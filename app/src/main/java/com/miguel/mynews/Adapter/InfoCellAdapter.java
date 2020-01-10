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
    private Context mContext;
    private int Jsonindex;

    public InfoCellAdapter(List<JsonResponse> jsonResponseList, Context context, int index){
        mJsonResponseList = jsonResponseList;
        mContext = context;
        Jsonindex = index;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.recyclerview_cell, viewGroup, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final MyViewHolder myViewHolder, final int position) {
        myViewHolder.displayResume(mJsonResponseList.get(position));
        myViewHolder.displayDate(mJsonResponseList.get(position));
        myViewHolder.displaySection(mJsonResponseList.get(position));
        myViewHolder.displayPicture(mJsonResponseList.get(position), mContext, Jsonindex);
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Jsonindex != 2) {
                    Log.i("test", "notre lien = " + mJsonResponseList.get(position).getUrl());
                    Intent intent = new Intent(mContext, WebViewActivity.class);
                    intent.putExtra("url", mJsonResponseList.get(position).getUrl());
                    mContext.startActivity(intent);
                } else{
                    Intent intent = new Intent(mContext, WebViewActivity.class);
                    intent.putExtra("url", mJsonResponseList.get(position).getUrl());
                    mContext.startActivity(intent);
                }


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
    private ConstraintLayout mButton;

    public MyViewHolder(View itemView) {
        super(itemView);

        mPicture = itemView.findViewById(R.id.imageButton_recycler);
        mSection = itemView.findViewById(R.id.textView);
        mDate = itemView.findViewById(R.id.date_recycler);
        mResume = itemView.findViewById(R.id.resume_recycler);
        mButton = itemView.findViewById(R.id.recycleview_cell);
    }


   void displayPicture(JsonResponse jsonResponse, Context context, int jsonIndex) {

       if (jsonIndex != 2) {
           List<JsonResponse.Multimedia> multimedia = jsonResponse.getMultimedia();
           if (multimedia.size() != 0 ) {
               Log.i("test", "multimedia " + multimedia);
               String URLPhoto = multimedia.get(0).getUrl();
               Log.i("test", "url photo" + URLPhoto);
               Glide.with(context).load(URLPhoto).into(mPicture);
           }else{
               mPicture.setVisibility(View.INVISIBLE);
           }

       }else{
           List<JsonResponse.Multimedia> multimedia = jsonResponse.getMultimediaMostpop();
           Log.i("test","multimedialist" + multimedia);
           String URLPhoto = multimedia.get(0).getMediaMetadata().get(0).getUrl();
           Glide.with(context).load(URLPhoto).into(mPicture);
       }
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

    void displayWebView (JsonResponse jsonResponse) {
        final String url = jsonResponse.getShort_url();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   WebViewFragment webViewFragment = new WebViewFragment();
             //   FragmentManager fragmentManager= getActivity().getFragmentManager();
             //   FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
             //   fragmentTransaction.replace(R.id.content_main,fragment2,"tag");
             //   fragmentTransaction.addToBackStack(null);
             //   fragmentTransaction.commit();
            }
        });

    }

}
