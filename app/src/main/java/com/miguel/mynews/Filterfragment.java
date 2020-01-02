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

import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static java.lang.reflect.Modifier.PRIVATE;

public class Filterfragment extends Fragment implements View.OnClickListener {

    private List<String> checkboxList;

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
        EditText editText = result.findViewById(R.id.filter_research_input);
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
        checkCheckbox(getView() , getActivity().getSharedPreferences("checkbox",MODE_PRIVATE));
        saveEditText(getActivity().getSharedPreferences("checkbox",MODE_PRIVATE));


    }

    public void saveEditText (SharedPreferences sharedPreferences) {
        EditText editText = getView().findViewById(R.id.filter_research_input);
        Log.i("edittext","edittext quand on le récup la premiere fois" + editText.getText().toString());
        sharedPreferences.edit()
                .putString("editText", editText.getText().toString())
                .apply();
    }

    public void checkCheckbox(View result, SharedPreferences mSharedPreferences) {
        onArtCheckboxClicked(result.findViewById(R.id.Artcheck), mSharedPreferences);
        onBusinessCheckboxClicked(result.findViewById(R.id.Businesscheck), mSharedPreferences);
        onTravelCheckboxClicked(result.findViewById(R.id.Travelcheck), mSharedPreferences);
        onSportsCheckboxClicked(result.findViewById(R.id.Sportscheck), mSharedPreferences);
        onEntrepreneursCheckboxClicked(result.findViewById(R.id.Entrepreneurscheck), mSharedPreferences);
        onPoliticsCheckboxClicked(result.findViewById(R.id.Politicscheck), mSharedPreferences);
    }

    public void onArtCheckboxClicked(View view, SharedPreferences mSharedPreferences) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        if (checked) {
            Log.i("Art", "avant check" + mSharedPreferences.getString("Art", "defValue"));
            mSharedPreferences.edit()
                    .putString("Art", "Artcheck")
                    .apply();
            Log.i("Art", "aprés check" + mSharedPreferences.getString("Art", "defValue"));

        } else {
            Log.i("Art", "avant uncheck" + mSharedPreferences.getString("Art", "defValue"));
                mSharedPreferences.edit()
                        .putString("Art", "")
                        .apply();
                Log.i("Art", "après uncheck" + mSharedPreferences.getString("Art", "defValue"));
        }
    }


    public void onTravelCheckboxClicked(View view, SharedPreferences mSharedPreferences) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            Log.i("Travel", "avant check"+ mSharedPreferences.getString("Travel", "defValue"));
            mSharedPreferences.edit()
                    .putString("Travel", "Travelcheck")
                    .apply();
            Log.i("Travel", "aprés check"+ mSharedPreferences.getString("Travel", "defValue"));
        }

        else {
            Log.i("Travel", "avant uncheck"+ mSharedPreferences.getString("Travel", "defValue"));
                mSharedPreferences.edit()
                        .putString("Travel", "")
                        .apply();
                Log.i("Travel", "après uncheck"+ mSharedPreferences.getString("Travel", "defValue"));
            }}


    public void onPoliticsCheckboxClicked(View view, SharedPreferences mSharedPreferences) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
                if (checked) {
                    Log.i("Politics", "avant check"+ mSharedPreferences.getString("Politics", "defValue"));
                    mSharedPreferences.edit()
                            .putString("Politics", "Politicscheck")
                            .apply();
                    Log.i("Politics", "aprés check"+ mSharedPreferences.getString("Politics", "defValue"));
                }

                else {
                    Log.i("Politics", "avant uncheck"+ mSharedPreferences.getString("Politics", "defValue"));
                    mSharedPreferences.edit()
                                .putString("Politics", "")
                                .apply();
                        Log.i("Politics", "après uncheck"+ mSharedPreferences.getString("Politics", "defValue"));

                    }}


        public void onEntrepreneursCheckboxClicked(View view, SharedPreferences mSharedPreferences) {
        // Is the view now checked?
            boolean checked = ((CheckBox) view).isChecked();
            if (checked) {
                Log.i("Entrepreneurs", "avant check"+ mSharedPreferences.getString("Entrepreneurs", "defValue"));
                mSharedPreferences.edit()
                        .putString("Entrepreneurs", "Entrepreneurscheck")
                        .apply();
                Log.i("Entrepreneurs", "aprés check"+ mSharedPreferences.getString("Entrepreneurs", "defValue"));
            }

            else {
                Log.i("Entrepreneurs", "avant uncheck"+ mSharedPreferences.getString("Entrepreneurs", "defValue"));

                    mSharedPreferences.edit()
                            .putString("Entrepreneurs", "")
                            .apply();
                    Log.i("Entrepreneurs", "après uncheck"+ mSharedPreferences.getString("Entrepreneurs", "defValue"));

                }}

    public void onSportsCheckboxClicked(View view, SharedPreferences mSharedPreferences) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
                if (checked) {
                    Log.i("Sports", "avant check"+ mSharedPreferences.getString("Sports", "defValue"));
                    mSharedPreferences.edit()
                            .putString("Sports", "Sportscheck")
                            .apply();
                    Log.i("Sports", "aprés check"+ mSharedPreferences.getString("Sports", "defValue"));
                }

                else {
                    Log.i("Sports", "avant uncheck"+ mSharedPreferences.getString("Sports", "defValue"));

                        mSharedPreferences.edit()
                                .putString("Sports", "")
                                .apply();
                        Log.i("Sports", "après uncheck"+ mSharedPreferences.getString("Sports", "defValue"));

                    }}

    public void onBusinessCheckboxClicked(View view, SharedPreferences mSharedPreferences) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
                if (checked) {
                    Log.i("Business", "avant check"+ mSharedPreferences.getString("Business", "defValue"));
                    mSharedPreferences.edit()
                            .putString("Business", "Businesscheck")
                            .apply();
                    Log.i("Business", "aprés check"+ mSharedPreferences.getString("Business", "defValue"));
                }

                else {
                    Log.i("Business", "avant uncheck"+ mSharedPreferences.getString("Business", "defValue"));

                        mSharedPreferences.edit()
                                .putString("Business", "")
                                .apply();
                        Log.i("Business", "après uncheck"+ mSharedPreferences.getString("Business", "defValue"));

                    }}



    private void createCallbackToFilterActivity(){
        try {
            mCallback = (OnButtonClickedListener) getActivity();
        }catch (ClassCastException e){
            throw new ClassCastException(e.toString() + "must implement OnButtonClickedListener");
        }
    }
}

