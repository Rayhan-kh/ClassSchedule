package com.foxcoders.classschedule;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.foxcoders.classschedule.Database.DatabaseManager;
import com.foxcoders.classschedule.Database.SharedPreferencesManager;
import com.foxcoders.classschedule.Pojo.ClassData;

import java.util.Calendar;
import java.util.List;

import static android.content.Context.ALARM_SERVICE;


public class AlarmHandler extends BroadcastReceiver {
    Long nextDay;
    private Context context;
    private String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private Calendar calendar = Calendar.getInstance();


    @Override
    public void onReceive(Context context, Intent intent) {

        this.context = context;
        SharedPreferencesManager preferencesManager = new SharedPreferencesManager(context);
        setNextDaysAlarms();
        DatabaseManager databaseManager = new DatabaseManager(context);
        List<ClassData> dataList = databaseManager.getClassesOfTheDay(getCurrentDay());

        for (ClassData c : dataList) {
            Calendar curDate = Calendar.getInstance();
            int id = (int) calendar.getTimeInMillis();
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
            Intent alarmIntent = new Intent(context, AlarmReceiver.class);
            alarmIntent.putExtra("alarmTime", c.getClassStartTime());
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(Long.valueOf(c.getClassStartTime()));
            calendar.set(Calendar.YEAR, curDate.getTime().getYear());
            calendar.set(Calendar.MONTH, curDate.getTime().getMonth());
            calendar.set(Calendar.DAY_OF_MONTH, curDate.getTime().getDate());

            if (calendar.getTime().getHours() >= curDate.getTime().getHours()) {
                PendingIntent pendingIntent = PendingIntent.getBroadcast(context, id, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                if (alarmManager != null) {
                    alarmManager.set(AlarmManager.RTC_WAKEUP, Long.valueOf(c.getClassStartTime()), pendingIntent);
                }
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
        int id = (int) curTime.getTimeInMillis();
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);

        Intent nextIntent = new Intent(context, AlarmHandler.class);
        nextIntent.putExtra("alarmTime", getNextDayInMillies());
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
