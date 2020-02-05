package com.miguel.mynews;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

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
        return (frag1);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.filter, container, false);
        SharedPreferences mSharedPreferences = getActivity().getSharedPreferences("checkbox",MODE_PRIVATE);
        mSharedPreferences.edit()
                .putInt("CaseCheck", 0)
                .apply();
        Switch switchnotif = result.findViewById(R.id.switchnotif);
        switchnotif.setVisibility(View.INVISIBLE);
        TextView textView = result.findViewById(R.id.textnotif);
        textView.setVisibility(View.INVISIBLE);
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
        checkCheckbox(getView() , getActivity().getSharedPreferences("checkbox",MODE_PRIVATE));
        if (getActivity().getSharedPreferences("checkbox",MODE_PRIVATE).getInt("CaseCheck", 0) == 0){
            Toast.makeText(getContext(), "Please select at least one category.",Toast.LENGTH_LONG).show();
        }else {
            mCallback.OnButtonClicked(v);
            saveEditText(getActivity().getSharedPreferences("checkbox", MODE_PRIVATE));
        }
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
            int i = mSharedPreferences.getInt("CaseCheck", 0);
            mSharedPreferences.edit()
                    .putString("Art", "Artcheck")
                    .putInt("CaseCheck", i + 1)
                    .apply();
        } else {
                mSharedPreferences.edit()
                        .putString("Art", "")
                        .apply();
        }
    }

    public void onTravelCheckboxClicked(View view, SharedPreferences mSharedPreferences) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            int i = mSharedPreferences.getInt("CaseCheck", 0);
            mSharedPreferences.edit()
                    .putString("Travel", "Travelcheck")
                    .putInt("CaseCheck", i + 1)
                    .apply();
        } else {
                mSharedPreferences.edit()
                        .putString("Travel", "")
                        .apply();
            }}

    public void onPoliticsCheckboxClicked(View view, SharedPreferences mSharedPreferences) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            int i = mSharedPreferences.getInt("CaseCheck", 0);
            mSharedPreferences.edit()
                    .putString("Politics", "Politicscheck")
                    .putInt("CaseCheck", i + 1)
                    .apply();
        } else {
            mSharedPreferences.edit()
                    .putString("Politics", "")
                    .apply();
        }}

        public void onEntrepreneursCheckboxClicked(View view, SharedPreferences mSharedPreferences) {
        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            int i = mSharedPreferences.getInt("CaseCheck", 0);
            mSharedPreferences.edit()
                    .putString("Entrepreneurs", "Entrepreneurscheck")
                    .putInt("CaseCheck", i + 1)
                    .apply();
        } else {
            mSharedPreferences.edit()
                    .putString("Entrepreneurs", "")
                    .apply();
        }}

    public void onSportsCheckboxClicked(View view, SharedPreferences mSharedPreferences) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            int i = mSharedPreferences.getInt("CaseCheck", 0);
            mSharedPreferences.edit()
                    .putString("Sports", "Sportscheck")
                    .putInt("CaseCheck", i + 1)
                    .apply();
        } else {
            mSharedPreferences.edit()
                    .putString("Sports", "")
                    .apply();
        }}

    public void onBusinessCheckboxClicked(View view, SharedPreferences mSharedPreferences) {

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            int i = mSharedPreferences.getInt("CaseCheck", 0);
            mSharedPreferences.edit()
                    .putString("Business", "Businesscheck")
                    .putInt("CaseCheck", i + 1)
                    .apply();
        } else {
            mSharedPreferences.edit()
                    .putString("Business", "")
                    .apply();
        }}

    private void createCallbackToFilterActivity(){
        try {
            mCallback = (OnButtonClickedListener) getActivity();
        }catch (ClassCastException e){
            throw new ClassCastException(e.toString() + "must implement OnButtonClickedListener");
        }
    }
}

