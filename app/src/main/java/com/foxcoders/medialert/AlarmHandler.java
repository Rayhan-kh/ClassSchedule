package com.foxcoders.medialert;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.foxcoders.medialert.Database.DatabaseManager;
import com.foxcoders.medialert.Pojo.ClassData;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import static android.content.Context.ALARM_SERVICE;


public class AlarmHandler extends BroadcastReceiver {
    Long nextDay;
    private Context context;
    private String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private Calendar calendar = Calendar.getInstance();
    private ArrayList<ClassData> dataList = new ArrayList<>();


    @Override
    public void onReceive(Context context, Intent intent) {


        this.context = context;
        if (intent.getIntExtra("alarmTime", 0) == 1) {
            String time = intent.getStringExtra("time");
            DatabaseManager databaseManager = new DatabaseManager(context);
            dataList = databaseManager.getClassesOfTheDayByStartTime(getCurrentDay(), time);
        } else {
            setNextDaysAlarms();
        }

        if (dataList.size() > 0) {
            for (ClassData c : dataList) {
                setAlarm(c.getClassStartTime());
                if (c.getClassEndTime() != null) {
                    setAlarm(c.getClassEndTime());
                }
                if (c.getClassEndTime2() != null) {
                    setAlarm(c.getClassEndTime2());
                }
            }
        }
    }

    private void setAlarm(String time) {
        Calendar curDate = Calendar.getInstance();
        Random random = new Random();
        int notID = (int) (random.nextInt(99999 - 1000) + 1000 + curDate.getTimeInMillis());
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
        Intent alarmIntent = new Intent(context, AlarmReceiver.class);
        alarmIntent.putExtra("alarmTime", time);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(Long.valueOf(time));
        calendar.set(Calendar.YEAR, curDate.get(Calendar.YEAR));
        calendar.set(Calendar.MONTH, curDate.get(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH, curDate.get(Calendar.DAY_OF_MONTH));

        if (calendar.get(Calendar.HOUR_OF_DAY) >= curDate.get(Calendar.HOUR_OF_DAY)) {
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, notID, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            if (alarmManager != null) {
                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
            }
        }
    }

    private String getCurrentDay() {
        calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        return days[day];
    }

    private void setNextDaysAlarms() {
        setForNextDay();
    }

    private void setForNextDay() {
        nextDay = getNextDayInMillies();
        final Calendar curTime = Calendar.getInstance();
        Random random = new Random();
        int id = (int) (random.nextInt(99999 - 1000) + 1000 + curTime.getTimeInMillis());
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);

        Intent nextIntent = new Intent(context, AlarmHandler.class);
        nextIntent.putExtra("alarmTime", 0);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, id, nextIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        if (alarmManager != null) {
            alarmManager.set(AlarmManager.RTC_WAKEUP, getNextDayInMillies(), pendingIntent);

        }
    }

    private Long getNextDayInMillies() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTimeInMillis();
    }
}
