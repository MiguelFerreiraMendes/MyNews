package com.miguel.mynews;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Filterfragment extends Fragment implements View.OnClickListener {

    //Constructor
    public Filterfragment (){}
    //Declare Callback
    private OnButtonClickedListener mCallback;
    //Declare our interface that will be implemented by any container activity
    public interface OnButtonClickedListener {
        public void OnButtonClicked(View view);
    }

    public static Filterfragment newInstance() {
        Filterfragment frag1 = new Filterfragment();
        Log.i("test", "3");
        return (frag1);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.filter, container, false);

        EditText editText = result.findViewById(R.id.activity_main_name_input);
        CheckBox ArtcheckBox = result.findViewById(R.id.Artcheck);
        CheckBox SportcheckBox = result.findViewById(R.id.Sportscheck);
        CheckBox BusinesscheckBox = result.findViewById(R.id.Businesscheck);
        CheckBox TravelcheckBox = result.findViewById(R.id.Travelcheck);
        CheckBox EntrepreneurscheckBox = result.findViewById(R.id.Entrepreneurscheck);
        CheckBox PoliticscheckBox = result.findViewById(R.id.Politicscheck);
        result.findViewById(R.id.search_buttonfilter).setOnClickListener(this);



        return result;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        //call the method that creating callback after being attached to parent activity
        this.createCallbackToFilterActivity();
    }


    @Override
    public void onClick(View v) {
        //Send the click to the parent activity
        mCallback.OnButtonClicked(v);

    }



    private void createCallbackToFilterActivity(){
        try {
            mCallback = (OnButtonClickedListener) getActivity();
        }catch (ClassCastException e){
            throw new ClassCastException(e.toString() + "must implement OnButtonClickedListener");
        }
    }
}

