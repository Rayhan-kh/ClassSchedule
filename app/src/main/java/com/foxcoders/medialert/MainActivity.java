package com.foxcoders.medialert;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.foxcoders.medialert.Adapters.MainListAdapter;
import com.foxcoders.medialert.Database.DatabaseManager;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatabaseManager dbManager;
    private TextView tvDay;
    private ListView lvMain;
    private Calendar calendar;
    private String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize view

        tvDay = (TextView) findViewById(R.id.tvDay);
        lvMain = (ListView) findViewById(R.id.lvMain);

        //initial tools
        dbManager = new DatabaseManager(this);
        calendar = Calendar.getInstance();


        //setDayDate
        int day = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        String stringDay = days[day];


        tvDay.setText(stringDay);


        android.support.design.widget.FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click action
                Intent intent = new Intent(MainActivity.this, AddClassActivity.class);
                startActivity(intent);
            }
        });

        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String day = tvDay.getText().toString();
                int id = dbManager.getClassesOfTheDay(day).get(i).getClassId();
                Intent intent = new Intent(getApplicationContext(), DetailViewClass.class);
                intent.putExtra("day", day);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        String tableName = tvDay.getText().toString();
        setDataToListView(tableName);
        super.onResume();
    }

    private void setDataToListView(String day) {


        MainListAdapter adapter = new MainListAdapter(this, dbManager.getClassesOfTheDay(day));
        lvMain.setAdapter(adapter);

    }

    public void showNext(View view) {
        int date = calendar.get(Calendar.DAY_OF_MONTH) + 1;
        calendar.set(Calendar.DAY_OF_MONTH, date);


        //setDayDate
        String stringDay = days[calendar.get(Calendar.DAY_OF_WEEK) - 1];


        tvDay.setText(stringDay);


        setDataToListView(stringDay);
    }

}
