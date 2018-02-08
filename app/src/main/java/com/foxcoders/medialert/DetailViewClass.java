package com.foxcoders.medialert;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.foxcoders.medialert.Database.DatabaseManager;
import com.foxcoders.medialert.Pojo.ClassData;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class DetailViewClass extends AppCompatActivity {

    private TextView tvInstitute;
    private TextView tvLocation;
    private TextView tvTime;
    private TextView tvDays;
    private TextView tvNotes;
    private DatabaseManager dbManager;
    private String day;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view_class);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //initial views
        tvDays = (TextView) findViewById(R.id.tvDays);
        tvInstitute = (TextView) findViewById(R.id.tvInstitute);
        tvLocation = (TextView) findViewById(R.id.tvLocation);
        tvTime = (TextView) findViewById(R.id.tvTime);
        tvNotes = (TextView) findViewById(R.id.tvNote);

        dbManager = new DatabaseManager(this);


//get data from Intent
        Intent intent = getIntent();
        day = intent.getStringExtra("day");
        id = intent.getIntExtra("id", 65446239);
        setData(day, id);


    }

    public void setData(String day, int id)

    {
        ArrayList<ClassData> classDatas = dbManager.getClassesOfTheDayById(day, id);
        if (classDatas != null) {

            getSupportActionBar().setTitle(classDatas.get(0).getClassTitle());
            tvInstitute.setText(classDatas.get(0).getClassInstitute());
            tvLocation.setText(classDatas.get(0).getClassLocation());
            tvDays.setText(classDatas.get(0).getClassDays());
            tvNotes.setText(classDatas.get(0).getClassNotes());

            String time = getTimeInString(classDatas.get(0).getClassStartTime());
            if (classDatas.get(0).getClassEndTime() != null) {
                String s = getTimeInString(classDatas.get(0).getClassEndTime());
                time = time + " - " + s;
            } else time = time + "- N/A";

            if (classDatas.get(0).getClassEndTime2() != null) {
                String s = getTimeInString(classDatas.get(0).getClassEndTime2());
                time = time + " - " + s;
            } else time = time + "- N/A";
            tvTime.setText(time);


        }

    }

    private String getTimeInString(String timeInMillis) {
        Long time2 = Long.parseLong(timeInMillis);
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.setTimeInMillis(time2);

        DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        return dateFormat.format(mCalendar.getTime());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.details_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.delete) {
            dbManager.deleteClassesOfTheDayById(day, id);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
