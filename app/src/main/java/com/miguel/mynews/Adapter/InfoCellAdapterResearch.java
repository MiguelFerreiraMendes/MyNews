package com.miguel.mynews.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.miguel.mynews.Models.JsonResponseResearch;
import com.miguel.mynews.R;

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
    public void onBindViewHolder(MyViewHolderResearch myViewHolder, int position) {
        myViewHolder.displayResume(jsonResponse.get(position));
        myViewHolder.displayDate(jsonResponse.get(position));
        myViewHolder.displaySection(jsonResponse.get(position));
        myViewHolder.displayPicture(jsonResponse.get(position), mContext);


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

    public MyViewHolderResearch(View itemView) {
        super(itemView);

        mPicture = itemView.findViewById(R.id.imageButton_recycler);
        mSection = itemView.findViewById(R.id.textView);
        mDate = itemView.findViewById(R.id.date_recycler);
        mResume = itemView.findViewById(R.id.resume_recycler);
    }


    void displayPicture(JsonResponseResearch.Doc jsonResponse, Context context) {

        List<JsonResponseResearch.Doc.Multimedium> multimedia = jsonResponse.getMultimedia();
        if (multimedia.size() != 0 ) {
            Log.i("test", "multimedia " + multimedia);
            String URLPhoto = multimedia.get(1).getUrl();
            Log.i("test", "url photo" + URLPhoto);
            Glide.with(context).load(URLPhoto).into(mPicture);
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

}
