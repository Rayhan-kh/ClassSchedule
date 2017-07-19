package com.foxcoders.classschedule;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.foxcoders.classschedule.Database.DatabaseManager;
import com.foxcoders.classschedule.Pojo.ClassData;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddClassActivity extends AppCompatActivity {

    private EditText etTitle;
    private EditText etInstitute;
    private EditText etLocation;
    private EditText etStratTime;
    private EditText etEndTime;
    private EditText etNote;
    private CheckBox cbSat;
    private CheckBox cbSun;
    private CheckBox cbMon;
    private CheckBox cbTue;
    private CheckBox cbWed;
    private CheckBox cbThr;
    private CheckBox cbFri;
    private CheckBox cbEvery;

    private String timeInMillis;
    private String timeInMillis2;
    private Calendar myCalendar;
    private DatabaseManager dbManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);

        //Initial View Items
        timeInMillis2=" ";
        etTitle = (EditText) findViewById(R.id.etTitle);
        etInstitute = (EditText) findViewById(R.id.etInstitute);
        etLocation = (EditText) findViewById(R.id.etLocation);
        etStratTime = (EditText) findViewById(R.id.etStrartTime);
        etNote = (EditText) findViewById(R.id.etNote);
        etEndTime=(EditText)findViewById(R.id.etEndTime);

        cbSat = (CheckBox) findViewById(R.id.cbSat);
        cbSun = (CheckBox) findViewById(R.id.cbSun);
        cbMon = (CheckBox) findViewById(R.id.cbMon);
        cbTue = (CheckBox) findViewById(R.id.cbTue);
        cbWed = (CheckBox) findViewById(R.id.cbWed);
        cbThr = (CheckBox) findViewById(R.id.cbThr);
        cbFri = (CheckBox) findViewById(R.id.cbFri);
        cbEvery = (CheckBox) findViewById(R.id.cbEvery);

        cbEvery.setChecked(true);

        dbManager = new DatabaseManager(this);
        getSupportActionBar().setTitle("Add Schedule");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    public boolean isAllFilled() {
        String title = etTitle.getText().toString();
        String institute = etInstitute.getText().toString();
        String location = etLocation.getText().toString();
        String startTime = etStratTime.getText().toString();
        String note = etNote.getText().toString();


        if (title.equals("") || institute.equals("") || location.equals("") || startTime.equals("") || note.equals("")) {
            return false;
        } else return true;
    }

    public boolean isDaySelected() {
        if (cbEvery.isChecked() || cbFri.isChecked() || cbThr.isChecked() || cbWed.isChecked() || cbTue.isChecked()
                || cbMon.isChecked() || cbSun.isChecked() || cbSat.isChecked()) {
            return true;
        } else return false;
    }

    public ClassData getClassData() {
        ClassData classData = new ClassData();


        String days = "";


        if (cbEvery.isChecked()) {
            cbThr.setChecked(false);
            cbWed.setChecked(false);
            cbTue.setChecked(false);
            cbMon.setChecked(false);
            cbSun.setChecked(false);
            cbSat.setChecked(false);
            cbFri.setChecked(false);

            days = "Everyday";

        }

        if (cbSat.isChecked()) {
            days += "Saturday ";

        }
        if (cbSun.isChecked()) {
            days += "Sunday ";

        }
        if (cbMon.isChecked()) {
            days += "Monday ";

        }
        if (cbTue.isChecked()) {
            days += "Tuesday ";

        }
        if (cbWed.isChecked()) {
            days += "Wednesday ";

        }

        if (cbThr.isChecked()) {
            days += "ThursDay ";

        }
        if (cbFri.isChecked()) {
            days += "Friday ";

        }

        classData.setClassDays(days);
        classData.setClassInstitute(etInstitute.getText().toString());
        classData.setClassTitle(etTitle.getText().toString());
        classData.setClassLocation(etLocation.getText().toString());
        classData.setClassStartTime(timeInMillis);
        classData.setClassEndTime(etEndTime.getText().toString());
        classData.setClassNotes(etNote.getText().toString());


        return classData;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.add_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add) {

            if (isDaySelected() && isAllFilled()) {
                //save to data base
                ClassData classData = getClassData();
                if (cbEvery.isChecked()) {
                    cbThr.setChecked(false);
                    cbWed.setChecked(false);
                    cbTue.setChecked(false);
                    cbMon.setChecked(false);
                    cbSun.setChecked(false);
                    cbSat.setChecked(false);
                    cbFri.setChecked(false);


                    dbManager.addTaskOnSat(classData);
                    dbManager.addTaskOnSun(classData);
                    dbManager.addTaskOnMon(classData);
                    dbManager.addTaskOnTue(classData);
                    dbManager.addTaskOnWed(classData);
                    dbManager.addTaskOnThr(classData);
                    dbManager.addTaskOnFri(classData);

                }

                if (cbSat.isChecked()) {
                    dbManager.addTaskOnSat(classData);

                }
                if (cbSun.isChecked()) {
                    dbManager.addTaskOnSun(classData);

                }
                if (cbMon.isChecked()) {
                    dbManager.addTaskOnMon(classData);

                }
                if (cbTue.isChecked()) {
                    dbManager.addTaskOnTue(classData);

                }
                if (cbWed.isChecked()) {
                    dbManager.addTaskOnWed(classData);

                }

                if (cbThr.isChecked()) {
                    dbManager.addTaskOnThr(classData);

                }
                if (cbFri.isChecked()) {
                    dbManager.addTaskOnFri(classData);

                }
                Toast.makeText(this, "Class Schedule Added.", Toast.LENGTH_SHORT).show();
                finish();

            }
            else {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setIcon(R.mipmap.ic_launcher)
                        .setTitle("ooops!")
                        .setMessage("Did you fill all the fields properly? You can select Multiple Days.")
                        .setPositiveButton("Let me check", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .show();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void pickTime(final View view) {

        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

                DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
                    calendar.set(Calendar.HOUR_OF_DAY, selectedHour);
                    calendar.set(Calendar.MINUTE, selectedMinute);
                    etStratTime.setText(dateFormat.format(calendar.getTime()));
                    timeInMillis = String.valueOf(calendar.getTimeInMillis());


            }
        }, hour, minute, true);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }
    public void pickEndTime(final View view) {

        final Calendar mcalendar = Calendar.getInstance();
        int hour = mcalendar.get(Calendar.HOUR_OF_DAY);
        int minute = mcalendar.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

                DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
                mcalendar.set(Calendar.HOUR_OF_DAY, selectedHour);
                mcalendar.set(Calendar.MINUTE, selectedMinute);
                etEndTime.setText(dateFormat.format(mcalendar.getTime()));



            }
        }, hour, minute, true);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }
}
