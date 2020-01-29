package com.miguel.mynews.Models;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.miguel.mynews.R;
import com.miguel.mynews.Utils.CellInformationCallsResearch;

import java.util.ArrayList;
import java.util.List;

import static android.app.NotificationChannel.DEFAULT_CHANNEL_ID;
import static android.content.Context.MODE_PRIVATE;

public class AlertReceiver extends BroadcastReceiver implements CellInformationCallsResearch.Callbacks {

    private NotificationManagerCompat notificationManager;
    private Context mContext;



    @Override
    public void onReceive(Context context, Intent intent) {


        SharedPreferences mSharedPreferences = context.getSharedPreferences("checkbox", MODE_PRIVATE);
        List<String> tagList = new ArrayList<>();

        String editText = mSharedPreferences.getString("editText", "");
        Log.i("test", editText);

        if (mSharedPreferences.getString("Art", "defValue").equals("Artcheck")) {
            tagList.add("\"Art\"");
        }
        if (mSharedPreferences.getString("Business", "defValue").equals("Businesscheck")) {
            tagList.add("\"Business\"");
        }
        if (mSharedPreferences.getString("Travel", "defValue").equals("Travelcheck")) {
            tagList.add("\"Travel\"");
        }
        if (mSharedPreferences.getString("Politics", "defValue").equals("Politicscheck")) {
            tagList.add("\"Politics\"");
        }
        if (mSharedPreferences.getString("Sports", "defValue").equals("Sportscheck")) {
            tagList.add("\"Sports\"");
        }
        if (mSharedPreferences.getString("Entrepreneurs", "defValue").equals("Entrepreneurscheck")) {
            tagList.add("\"Entrepreneurs\"");
            Log.i("list", "list de tags : " + tagList);
        }
        mContext = context;

        notificationManager = NotificationManagerCompat.from(context);

        CellInformationCallsResearch.fetchResearch(this, tagList, editText);



    }

    @Override
    public void onResponse(@Nullable JsonResponseResearch users) {
        int sizeNotifications = users.getDocs().size();
        updateNotification(sizeNotifications);

    }

    @Override
    public void onFailure() {
        Log.i("test", "Failed reasearch alarm");
    }

    private void updateNotification(int size){
        Notification notification = new NotificationCompat.Builder(mContext, DEFAULT_CHANNEL_ID)
                .setContentTitle("List of articles found with your tags")
                .setContentText("Number of articles found : " + size + ".")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_ALARM)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .build();
        notificationManager.notify(1, notification);

    }
}