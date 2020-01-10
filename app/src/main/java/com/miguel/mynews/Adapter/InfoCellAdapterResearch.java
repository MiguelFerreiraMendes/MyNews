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
import com.miguel.mynews.FilterActivity;
import com.miguel.mynews.Filterfragment;
import com.miguel.mynews.Models.JsonResponseResearch;
import com.miguel.mynews.R;
import com.miguel.mynews.WebViewActivity;

import java.util.List;

public class InfoCellAdapterResearch extends RecyclerView.Adapter<MyViewHolderResearch> {

    private List<JsonResponseResearch.Doc> jsonResponse;
    private Context mContext;

    public InfoCellAdapterResearch(JsonResponseResearch jsonResponseList, Context context){
        mContext = context;
        Log.i("json", "json juste avant de récup les docs " + jsonResponseList);
        jsonResponse = jsonResponseList.getDocs();
    }


    @Override
    public MyViewHolderResearch onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.recyclerview_cell, viewGroup, false);
        return new MyViewHolderResearch(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolderResearch myViewHolder, final int position) {
        myViewHolder.displayResume(jsonResponse.get(position));
        myViewHolder.displayDate(jsonResponse.get(position));
        myViewHolder.displaySection(jsonResponse.get(position));
        myViewHolder.displayPicture(jsonResponse.get(position), mContext);
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("test", "notre lien = " + jsonResponse.get(position).getWebUrl());
                Intent intent = new Intent(mContext, WebViewActivity.class);
                intent.putExtra("url", jsonResponse.get(position).getWebUrl());
                mContext.startActivity(intent);
            }});


    }

    @Override
    public int getItemCount() {
        return jsonResponse.size();
    }
}

class MyViewHolderResearch extends RecyclerView.ViewHolder {

    private ImageButton mPicture;
    private TextView mSection;
    private TextView mDate;
    private TextView mResume;
    private ConstraintLayout mLayout;
    private View.OnClickListener mCallback;

    public interface RecyclerviewOnClickListener{
        void OnLayoutClicked(int position);
    }



    public MyViewHolderResearch(View itemView) {
        super(itemView);

        mPicture = itemView.findViewById(R.id.imageButton_recycler);
        mSection = itemView.findViewById(R.id.textView);
        mDate = itemView.findViewById(R.id.date_recycler);
        mResume = itemView.findViewById(R.id.resume_recycler);
        mLayout = itemView.findViewById(R.id.recycleview_cell);
    }


    void displayPicture(JsonResponseResearch.Doc jsonResponse, Context context) {

        List<JsonResponseResearch.Doc.Multimedium> multimedia = jsonResponse.getMultimedia();
        if (multimedia.size() != 0 ) {
            Log.i("test", "multimedia " + multimedia);
            String URLPhoto = multimedia.get(1).getUrl();
            Log.i("test", "url photo" + URLPhoto);
            String FinalURLPhoto = "https://api.nytimes.com/" + URLPhoto;
            Log.i("photo", "" + FinalURLPhoto + URLPhoto);
            Glide.with(context).load(FinalURLPhoto).into(mPicture);
        }else{
            mPicture.setVisibility(View.INVISIBLE);
        }
    }

    void displaySection(JsonResponseResearch.Doc jsonResponse){
        mSection.setText(jsonResponse.getSectionName());

    }

    void displayDate(JsonResponseResearch.Doc jsonResponse) {
        mDate.setText(jsonResponse.getPubDate().subSequence(0,10));

    }

    void displayResume (JsonResponseResearch.Doc jsonResponse) {
        mResume.setText(jsonResponse.getLeadParagraph());

    }

    void displayWebView (final JsonResponseResearch.Doc jsonResponse){
        mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              // String url = jsonResponse.getWebUrl();
              // Intent webviewIntent = new Intent(FilterActivity.class, WebViewActivity.class);
              // startActivity(webviewIntent);

            }
        });
    }

}
