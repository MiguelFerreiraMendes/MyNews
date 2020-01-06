package com.miguel.mynews;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;


public class FilterActivity extends AppCompatActivity implements Filterfragment.OnButtonClickedListener{

    SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter_activity);
        //1 - Configuring Toolbar
        this.configureToolbar();
        mSharedPreferences = this.getSharedPreferences("checkbox", MODE_PRIVATE);



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

    @Override
    public void OnButtonClicked(View view) {
        Log.i("test", "test");
        Researchfragment newfragment = new Researchfragment();
        Fragment prevfragment = getSupportFragmentManager().findFragmentById(R.id.fragmentfilter);
       FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
       fragmentTransaction.replace(R.id.fragmentfilter, newfragment);
       fragmentTransaction.addToBackStack(null);
       fragmentTransaction.commit();
    }
}
