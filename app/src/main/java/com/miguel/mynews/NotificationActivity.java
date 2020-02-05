package com.miguel.mynews;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.miguel.mynews.Models.AlertReceiver;

import java.util.Calendar;

public class NotificationActivity extends AppCompatActivity {

    public static final String CHANNEL_1_ID = "channel1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter);

        Button button = findViewById(R.id.search_buttonfilter);
        button.setVisibility(View.INVISIBLE);
        CheckBox ArtcheckBox = findViewById(R.id.Artcheck);
        CheckBox SportcheckBox = findViewById(R.id.Sportscheck);
        CheckBox BusinesscheckBox = findViewById(R.id.Businesscheck);
        CheckBox TravelcheckBox = findViewById(R.id.Travelcheck);
        CheckBox EntrepreneurscheckBox = findViewById(R.id.Entrepreneurscheck);
        CheckBox PoliticscheckBox = findViewById(R.id.Politicscheck);
        final SharedPreferences mSharedPreferences = getSharedPreferences("CheckBoxAlert", MODE_PRIVATE);
        mSharedPreferences.edit()
                .putInt("CaseCheck", 0)
                .apply();

        ArtcheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences mSharedPreferences = getSharedPreferences("CheckBoxAlert", MODE_PRIVATE);
                int i = mSharedPreferences.getInt("CaseCheck", 0);
                if (isChecked) {
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
        });

        SportcheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences mSharedPreferences = getSharedPreferences("CheckBoxAlert", MODE_PRIVATE);
                int i = mSharedPreferences.getInt("CaseCheck", 0);
                if (isChecked) {
                    mSharedPreferences.edit()
                            .putString("Sport", "Sportcheck")
                            .putInt("CaseCheck", i + 1)
                            .apply();
                } else {
                    mSharedPreferences.edit()
                            .putString("Sport", "")
                            .apply();
                }
            }
        });

        BusinesscheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences mSharedPreferences = getSharedPreferences("CheckBoxAlert", MODE_PRIVATE);
                int i = mSharedPreferences.getInt("CaseCheck", 0);
                if (isChecked) {
                    mSharedPreferences.edit()
                            .putString("Business", "Businesscheck")
                            .putInt("CaseCheck", i + 1)
                            .apply();
                } else {
                    mSharedPreferences.edit()
                            .putString("Business", "")
                            .apply();
                }
            }
        });

        TravelcheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences mSharedPreferences = getSharedPreferences("CheckBoxAlert", MODE_PRIVATE);
                int i = mSharedPreferences.getInt("CaseCheck", 0);
                if (isChecked) {
                    mSharedPreferences.edit()
                            .putString("Travel", "Travelcheck")
                            .putInt("CaseCheck", i + 1)
                            .apply();
                } else {
                    mSharedPreferences.edit()
                            .putString("Travel", "")
                            .apply();
                }
            }
        });

        EntrepreneurscheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences mSharedPreferences = getSharedPreferences("CheckBoxAlert", MODE_PRIVATE);
                int i = mSharedPreferences.getInt("CaseCheck", 0);
                if (isChecked) {
                    mSharedPreferences.edit()
                            .putString("Entrepreneurs", "Entrepreneurscheck")
                            .putInt("CaseCheck", i + 1)
                            .apply();
                } else {
                    mSharedPreferences.edit()
                            .putString("Entrepreneurs", "")
                            .apply();
                }
            }
        });

        PoliticscheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences mSharedPreferences = getSharedPreferences("CheckBoxAlert", MODE_PRIVATE);
                int i = mSharedPreferences.getInt("CaseCheck", 0);
                if (isChecked) {
                    mSharedPreferences.edit()
                            .putString("Politics", "Politicscheck")
                            .putInt("CaseCheck", i + 1)
                            .apply();
                } else {
                    mSharedPreferences.edit()
                            .putString("Politics", "")
                            .apply();
                }
            }
        });

        final Switch sw = findViewById(R.id.switchnotif);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    if (mSharedPreferences.getInt("CaseCheck", 0) == 0) {
                        Toast.makeText(NotificationActivity.this, "Please select at least one categoy.", Toast.LENGTH_LONG).show();
                        sw.setChecked(false);
                    }
                    else {
                        startAlarm(mSharedPreferences);
                    }
                } else {
                    stopAlarm();
                }
            }
        });
        createNotificationChannels();
    }

    private void startAlarm(SharedPreferences mSharedPreferences) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR, 17);
        calendar.set(Calendar.MINUTE, 28);
        calendar.set(Calendar.SECOND, 0);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        EditText editText = findViewById(R.id.filter_research_input);
        mSharedPreferences.edit()
                .putString("editText", editText.getText().toString())
                .apply();
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
    }

    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel chanel1 = new NotificationChannel(CHANNEL_1_ID, "Channel 1", NotificationManager.IMPORTANCE_HIGH);
            chanel1.setDescription("Channel 1");
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(chanel1);
        }
    }

    private void stopAlarm(){
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 1253, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);
    }
}
