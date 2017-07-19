package com.galaxyvibesdreams.www.classschedule;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.galaxyvibesdreams.www.classschedule.Database.DatabaseManager;
import com.galaxyvibesdreams.www.classschedule.Pojo.ClassData;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view_class);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //initial views
        tvDays= (TextView) findViewById(R.id.tvDays);
        tvInstitute= (TextView) findViewById(R.id.tvInstitute);
        tvLocation= (TextView) findViewById(R.id.tvLocation);
        tvTime= (TextView) findViewById(R.id.tvTime);
        tvNotes= (TextView) findViewById(R.id.tvNote);

        dbManager = new DatabaseManager(this);


//get data from Intent
        Intent intent = getIntent();
        String day = intent.getStringExtra("day");
        int id = intent.getIntExtra("id", 65446239);
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

            long timeInMills = (Long.parseLong(classDatas.get(0).getClassStartTime()));
            Calendar mCalendar=Calendar.getInstance();
            mCalendar.setTimeInMillis(timeInMills);

            DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            String time = dateFormat.format(mCalendar.getTime());

            if(classDatas.get(0).getClassEndTime()!=null&& !classDatas.get(0).getClassEndTime().equals(" "))
            {


                tvTime.setText(time +" - "+classDatas.get(0).getClassEndTime());
            }
            else {
                tvTime.setText(time);
            }

        }

    }
}
