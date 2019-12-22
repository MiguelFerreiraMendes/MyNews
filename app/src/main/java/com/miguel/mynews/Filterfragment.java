package com.miguel.mynews;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import static android.content.Context.MODE_PRIVATE;
import static java.lang.reflect.Modifier.PRIVATE;

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
        SharedPreferences mSharedPreferences = getActivity().getSharedPreferences("checkbox",MODE_PRIVATE);
        EditText editText = result.findViewById(R.id.activity_main_name_input);
        CheckBox ArtcheckBox = result.findViewById(R.id.Artcheck);
        CheckBox SportcheckBox = result.findViewById(R.id.Sportscheck);
        CheckBox BusinesscheckBox = result.findViewById(R.id.Businesscheck);
        CheckBox TravelcheckBox = result.findViewById(R.id.Travelcheck);
        CheckBox EntrepreneurscheckBox = result.findViewById(R.id.Entrepreneurscheck);
        CheckBox PoliticscheckBox = result.findViewById(R.id.Politicscheck);
        result.findViewById(R.id.search_buttonfilter).setOnClickListener(this);
        onCheckboxClicked(getView(), mSharedPreferences);




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

    public void onCheckboxClicked(View view, SharedPreferences mSharedPreferences) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.Artcheck:
                if (checked) {
                    Log.i("Art", "avant check"+ mSharedPreferences.getString("Art", "defValue"));
                    mSharedPreferences.edit()
                            .putString("Art", "Artcheck")
                            .apply();
                    Log.i("Art", "aprés check"+ mSharedPreferences.getString("Art", "defValue"));
                }

                else {
                    Log.i("Art", "avant uncheck"+ mSharedPreferences.getString("Art", "defValue"));
                    if (!mSharedPreferences.getString("Art", "").equals("Artcheck")) {
                        mSharedPreferences.edit()
                                .putString("Art", "")
                                .apply();
                        Log.i("Art", "après uncheck"+ mSharedPreferences.getString("Art", "defValue"));
                    }
                }
                break;
            case R.id.Travelcheck:
                if (checked) {
                    Log.i("Travel", "avant check"+ mSharedPreferences.getString("Travel", "defValue"));
                    mSharedPreferences.edit()
                            .putString("Travel", "Travelcheck")
                            .apply();
                    Log.i("Travel", "aprés check"+ mSharedPreferences.getString("Travel", "defValue"));
                }

                else {
                    Log.i("Travel", "avant uncheck"+ mSharedPreferences.getString("Travel", "defValue"));
                    if (!mSharedPreferences.getString("Travel", "").equals("Travelcheck")) {
                        mSharedPreferences.edit()
                                .putString("Travel", "")
                                .apply();
                        Log.i("Travel", "après uncheck"+ mSharedPreferences.getString("Travel", "defValue"));

                }}
                break;
            case R.id.Politicscheck:
                if (checked) {
                    Log.i("Politics", "avant check"+ mSharedPreferences.getString("Politics", "defValue"));
                    mSharedPreferences.edit()
                            .putString("Politics", "Politicscheck")
                            .apply();
                    Log.i("Politics", "aprés check"+ mSharedPreferences.getString("Politics", "defValue"));
                }

                else {
                    Log.i("Politics", "avant uncheck"+ mSharedPreferences.getString("Politics", "defValue"));
                    if (!mSharedPreferences.getString("Politics", "").equals("Politicscheck")) {
                        mSharedPreferences.edit()
                                .putString("Politics", "")
                                .apply();
                        Log.i("Politics", "après uncheck"+ mSharedPreferences.getString("Politics", "defValue"));

                    }}
                break;
            case R.id.Entrepreneurscheck:
                if (checked) {
                    Log.i("Entrepreneurs", "avant check"+ mSharedPreferences.getString("Entrepreneurs", "defValue"));
                    mSharedPreferences.edit()
                            .putString("Entrepreneurs", "Entrepreneurscheck")
                            .apply();
                    Log.i("Entrepreneurs", "aprés check"+ mSharedPreferences.getString("Entrepreneurs", "defValue"));
                }

                else {
                    Log.i("Entrepreneurs", "avant uncheck"+ mSharedPreferences.getString("Entrepreneurs", "defValue"));
                    if (!mSharedPreferences.getString("Entrepreneurs", "").equals("Entrepreneurscheck")) {
                        mSharedPreferences.edit()
                                .putString("Entrepreneurs", "")
                                .apply();
                        Log.i("Entrepreneurs", "après uncheck"+ mSharedPreferences.getString("Entrepreneurs", "defValue"));

                    }}
                break;
            case R.id.Sportscheck:
                if (checked) {
                    Log.i("Sports", "avant check"+ mSharedPreferences.getString("Sports", "defValue"));
                    mSharedPreferences.edit()
                            .putString("Sports", "Sportscheck")
                            .apply();
                    Log.i("Sports", "aprés check"+ mSharedPreferences.getString("Sports", "defValue"));
                }

                else {
                    Log.i("Sports", "avant uncheck"+ mSharedPreferences.getString("Sports", "defValue"));
                    if (!mSharedPreferences.getString("Sports", "").equals("Sportscheck")) {
                        mSharedPreferences.edit()
                                .putString("Sports", "")
                                .apply();
                        Log.i("Sports", "après uncheck"+ mSharedPreferences.getString("Sports", "defValue"));

                    }}
                break;
            case R.id.Businesscheck:
                if (checked) {
                    Log.i("Business", "avant check"+ mSharedPreferences.getString("Business", "defValue"));
                    mSharedPreferences.edit()
                            .putString("Business", "Businesscheck")
                            .apply();
                    Log.i("Business", "aprés check"+ mSharedPreferences.getString("Business", "defValue"));
                }

                else {
                    Log.i("Business", "avant uncheck"+ mSharedPreferences.getString("Business", "defValue"));
                    if (!mSharedPreferences.getString("Business", "").equals("Businesscheck")) {
                        mSharedPreferences.edit()
                                .putString("Business", "")
                                .apply();
                        Log.i("Business", "après uncheck"+ mSharedPreferences.getString("Business", "defValue"));

                    }}
                break;
    }}



    private void createCallbackToFilterActivity(){
        try {
            mCallback = (OnButtonClickedListener) getActivity();
        }catch (ClassCastException e){
            throw new ClassCastException(e.toString() + "must implement OnButtonClickedListener");
        }
    }
}

