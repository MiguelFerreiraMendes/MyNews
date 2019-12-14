package com.miguel.mynews;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class FilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter_activity);
        //1 - Configuring Toolbar
        this.configureToolbar();

        EditText editText = findViewById(R.id.activity_main_name_input);
        CheckBox ArtcheckBox = findViewById(R.id.Artcheck);
        CheckBox SportcheckBox = findViewById(R.id.Sportscheck);
        CheckBox BusinesscheckBox = findViewById(R.id.Businesscheck);
        CheckBox TravelcheckBox = findViewById(R.id.Travelcheck);
        CheckBox EntrepreneurscheckBox = findViewById(R.id.Entrepreneurscheck);
        CheckBox PoliticscheckBox = findViewById(R.id.Politicscheck);
        Button button = findViewById(R.id.search_buttonfilter);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(FilterActivity.this, Researchfragment.class);
                startActivity(myIntent);
            }
        });








    }

    private void configureToolbar(){
        //Get the toolbar (Serialise)
        Toolbar toolbar = findViewById(R.id.activity_main_toolbar);
        //Set the toolbar
        setSupportActionBar(toolbar);
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
    }
}
