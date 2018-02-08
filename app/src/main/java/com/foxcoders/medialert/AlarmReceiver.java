package com.foxcoders.medialert;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

import com.foxcoders.medialert.Database.DatabaseManager;
import com.foxcoders.medialert.Pojo.ClassData;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class AlarmReceiver extends BroadcastReceiver {

    private final String stringDay;
    private Calendar calendar;
    private String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private List<ClassData> dataList;


    public AlarmReceiver() {
        calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        stringDay = days[day];
    }

    public String getDay() {
        calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        return days[day];
    }

    private List<ClassData> getDataList(Context context, String alarmTime) {
        DatabaseManager dbManager = new DatabaseManager(context);
        List<ClassData> dataList = new ArrayList<>();
        List<ClassData> dataList2 = dbManager.getClassesOfTheDayByStartTime(stringDay, alarmTime);
        List<ClassData> dataList3 = dbManager.getClassesOfTheDayByEndTime(stringDay, alarmTime);
        List<ClassData> dataList4 = dbManager.getClassesOfTheDayByEndTime2(stringDay, alarmTime);

        if (dataList2.size() > 0) {
            dataList = dataList2;
        } else if (dataList3.size() > 0) {
            dataList = dataList3;
        } else if (dataList4.size() > 0) {
            dataList = dataList4;
        }
        return dataList;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        String alarmTime = intent.getStringExtra("alarmTime");
        if (alarmTime == null || alarmTime.equals("")) {
            //do Nothing
        } else {

            dataList=getDataList(context, alarmTime);
            if (dataList.size() > 0) {
                for (ClassData x : dataList) {
                    String title = x.getClassTitle();
                    String text = x.getClassNotes();
                    NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                    Intent notificationIntent = new Intent(context, DetailViewClass.class);

                    Bundle bundle = new Bundle();
                    bundle.putString("day", getDay());
                    bundle.putInt("id", x.getClassId());
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
                            .setSmallIcon(R.drawable.syringr)
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


