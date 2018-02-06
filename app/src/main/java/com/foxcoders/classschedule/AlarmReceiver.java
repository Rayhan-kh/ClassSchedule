package com.foxcoders.classschedule;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

import com.foxcoders.classschedule.Database.DatabaseManager;
import com.foxcoders.classschedule.Pojo.ClassData;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class AlarmReceiver extends BroadcastReceiver {

    private final String stringDay;
    private Calendar calendar;
    private String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};


    public AlarmReceiver() {
        calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        stringDay = days[day];
    }

    public String getDay()
    {
        calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        return days[day];
    }


    @Override
    public void onReceive(Context context, Intent intent) {

        String alarmTime = intent.getStringExtra("alarmTime");
        if (alarmTime == null || alarmTime.equals("")) {
            //do Nothing
        } else {
            DatabaseManager dbManager = new DatabaseManager(context);
            ArrayList<ClassData> dataList = dbManager.getClassesOfTheDayByStartTime(stringDay, alarmTime);

            if (dataList.size() > 0) {
                for (ClassData x : dataList) {
                    String title = x.getClassTitle();
                    String text = x.getClassNotes();
                    NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                    Intent notificationIntent = new Intent(context, DetailViewClass.class);

                    Bundle bundle = new Bundle();
                    bundle.putString("day",getDay() );
                    bundle.putInt("id",x.getClassId());
                    notificationIntent.putExtras(bundle);
                    notificationIntent.setFlags(
                            Intent.FLAG_ACTIVITY_SINGLE_TOP);

                    Random random = new Random();
                    int notID = random.nextInt(99999 - 1000) + 1000;
                    PendingIntent pendingIntent = PendingIntent.getActivity(context, notID,
                            notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);


                    NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
                    builder.setContentIntent(pendingIntent)
                            .setTicker(title)
                            .setContentTitle(title)
                            .setSmallIcon(R.drawable.calendar_round)
                            .setContentText(text)
                            .setAutoCancel(true)
                            .setDefaults(Notification.DEFAULT_ALL);
                    if (notificationManager != null) {
                        notificationManager.notify(notID, builder.build());
                    }
                }
            }

        }
    }
}


