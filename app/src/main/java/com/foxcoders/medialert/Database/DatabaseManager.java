package com.foxcoders.medialert.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.foxcoders.medialert.Pojo.ClassData;

import java.util.ArrayList;

/**
 * Created by Ray on 1/23/2017.
 */

public class DatabaseManager {
    Context context;
    DatabaseHelper helper;
    SQLiteDatabase database;

    public DatabaseManager(Context context) {
        this.context = context;
        helper = new DatabaseHelper(context);
    }

    public void openDatabase() {
        database = helper.getWritableDatabase();
    }

    public void closeDatabase() {
        helper.close();
        database.close();
    }

    public boolean addTaskOnSat(ClassData classData)

    {
        this.openDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.CLASS_TITLE, classData.getClassTitle());
        cv.put(DatabaseHelper.CLASS_INSTITUTE, classData.getClassInstitute());
        cv.put(DatabaseHelper.CLASS_LOCATION, classData.getClassLocation());
        cv.put(DatabaseHelper.CLASS_DAYS, classData.getClassDays());
        cv.put(DatabaseHelper.START_TIME, classData.getClassStartTime());
        cv.put(DatabaseHelper.CLASS_NOTE, classData.getClassNotes());
        cv.put(DatabaseHelper.END_TIME, classData.getClassEndTime());
        cv.put(DatabaseHelper.END_TIME2, classData.getClassEndTime2());


        long inserted = database.insert(DatabaseHelper.TABLE_SAT, null, cv);
        this.closeDatabase();
        if (inserted > 0) {
            return true;
        } else return false;
    }

    public boolean addTaskOnSun(ClassData classData)

    {
        this.openDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.CLASS_TITLE, classData.getClassTitle());
        cv.put(DatabaseHelper.CLASS_INSTITUTE, classData.getClassInstitute());
        cv.put(DatabaseHelper.CLASS_LOCATION, classData.getClassLocation());
        cv.put(DatabaseHelper.CLASS_DAYS, classData.getClassDays());
        cv.put(DatabaseHelper.START_TIME, classData.getClassStartTime());
        cv.put(DatabaseHelper.CLASS_NOTE, classData.getClassNotes());
        cv.put(DatabaseHelper.END_TIME, classData.getClassEndTime());
        cv.put(DatabaseHelper.END_TIME2, classData.getClassEndTime2());


        long inserted = database.insert(DatabaseHelper.TABLE_SUN, null, cv);
        this.closeDatabase();
        if (inserted > 0) {
            return true;
        } else return false;
    }

    public boolean addTaskOnMon(ClassData classData)

    {
        this.openDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.CLASS_TITLE, classData.getClassTitle());
        cv.put(DatabaseHelper.CLASS_INSTITUTE, classData.getClassInstitute());
        cv.put(DatabaseHelper.CLASS_LOCATION, classData.getClassLocation());
        cv.put(DatabaseHelper.CLASS_DAYS, classData.getClassDays());
        cv.put(DatabaseHelper.START_TIME, classData.getClassStartTime());
        cv.put(DatabaseHelper.CLASS_NOTE, classData.getClassNotes());
        cv.put(DatabaseHelper.END_TIME, classData.getClassEndTime());
        cv.put(DatabaseHelper.END_TIME2, classData.getClassEndTime2());


        long inserted = database.insert(DatabaseHelper.TABLE_MON, null, cv);
        this.closeDatabase();
        if (inserted > 0) {
            return true;
        } else return false;
    }

    public boolean addTaskOnTue(ClassData classData)

    {
        this.openDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.CLASS_TITLE, classData.getClassTitle());
        cv.put(DatabaseHelper.CLASS_INSTITUTE, classData.getClassInstitute());
        cv.put(DatabaseHelper.CLASS_LOCATION, classData.getClassLocation());
        cv.put(DatabaseHelper.CLASS_DAYS, classData.getClassDays());
        cv.put(DatabaseHelper.START_TIME, classData.getClassStartTime());
        cv.put(DatabaseHelper.CLASS_NOTE, classData.getClassNotes());
        cv.put(DatabaseHelper.END_TIME, classData.getClassEndTime());
        cv.put(DatabaseHelper.END_TIME2, classData.getClassEndTime2());


        long inserted = database.insert(DatabaseHelper.TABLE_TUE, null, cv);
        this.closeDatabase();
        if (inserted > 0) {
            return true;
        } else return false;
    }

    public boolean addTaskOnWed(ClassData classData) {
        this.openDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.CLASS_TITLE, classData.getClassTitle());
        cv.put(DatabaseHelper.CLASS_INSTITUTE, classData.getClassInstitute());
        cv.put(DatabaseHelper.CLASS_LOCATION, classData.getClassLocation());
        cv.put(DatabaseHelper.CLASS_DAYS, classData.getClassDays());
        cv.put(DatabaseHelper.START_TIME, classData.getClassStartTime());
        cv.put(DatabaseHelper.CLASS_NOTE, classData.getClassNotes());
        cv.put(DatabaseHelper.END_TIME, classData.getClassEndTime());
        cv.put(DatabaseHelper.END_TIME2, classData.getClassEndTime2());


        long inserted = database.insert(DatabaseHelper.TABLE_WED, null, cv);
        this.closeDatabase();
        if (inserted > 0) {
            return true;
        } else return false;
    }

    public boolean addTaskOnThr(ClassData classData) {
        this.openDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.CLASS_TITLE, classData.getClassTitle());
        cv.put(DatabaseHelper.CLASS_INSTITUTE, classData.getClassInstitute());
        cv.put(DatabaseHelper.CLASS_LOCATION, classData.getClassLocation());
        cv.put(DatabaseHelper.CLASS_DAYS, classData.getClassDays());
        cv.put(DatabaseHelper.START_TIME, classData.getClassStartTime());
        cv.put(DatabaseHelper.CLASS_NOTE, classData.getClassNotes());
        cv.put(DatabaseHelper.END_TIME, classData.getClassEndTime());
        cv.put(DatabaseHelper.END_TIME2, classData.getClassEndTime2());


        long inserted = database.insert(DatabaseHelper.TABLE_THR, null, cv);
        this.closeDatabase();
        if (inserted > 0) {
            return true;
        } else return false;
    }

    public boolean addTaskOnFri(ClassData classData) {
        this.openDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.CLASS_TITLE, classData.getClassTitle());
        cv.put(DatabaseHelper.CLASS_INSTITUTE, classData.getClassInstitute());
        cv.put(DatabaseHelper.CLASS_LOCATION, classData.getClassLocation());
        cv.put(DatabaseHelper.CLASS_DAYS, classData.getClassDays());
        cv.put(DatabaseHelper.START_TIME, classData.getClassStartTime());
        cv.put(DatabaseHelper.CLASS_NOTE, classData.getClassNotes());
        cv.put(DatabaseHelper.END_TIME, classData.getClassEndTime());
        cv.put(DatabaseHelper.END_TIME2, classData.getClassEndTime2());


        long inserted = database.insert(DatabaseHelper.TABLE_FRI, null, cv);
        this.closeDatabase();
        if (inserted > 0) {
            return true;
        } else return false;
    }


    public ArrayList<ClassData> getClassesOfTheDay(String day) {
        this.openDatabase();
        ArrayList<ClassData> classesOfTheDay = new ArrayList<>();

        Cursor cursor = database.query(day,
                null, null, null, null, null, DatabaseHelper.START_TIME + " ASC ");


        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();

            for (int i = 0; i < cursor.getCount(); i++) {
                int classId = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_ID));
                String taskTitle = cursor.getString(cursor.getColumnIndex(DatabaseHelper.CLASS_TITLE));
                String taskLocation = cursor.getString(cursor.getColumnIndex(DatabaseHelper.CLASS_LOCATION));
                String taskDate = cursor.getString(cursor.getColumnIndex(DatabaseHelper.CLASS_DAYS));
                String taskTime = cursor.getString(cursor.getColumnIndex(DatabaseHelper.START_TIME));
                String taskInstitute = cursor.getString(cursor.getColumnIndex(DatabaseHelper.CLASS_INSTITUTE));
                String taskNote = cursor.getString(cursor.getColumnIndex(DatabaseHelper.CLASS_NOTE));
                String endTime = cursor.getString(cursor.getColumnIndex(DatabaseHelper.END_TIME));
                String endTime2 = cursor.getString(cursor.getColumnIndex(DatabaseHelper.END_TIME2));

                ClassData classData = new ClassData(classId, taskTitle, taskInstitute, taskLocation, taskTime, endTime, endTime2, taskNote, taskDate);
                classesOfTheDay.add(classData);

                cursor.moveToNext();
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        return classesOfTheDay;

    }

    public ArrayList<ClassData> getClassesOfTheDayById(String day, int id) {
        this.openDatabase();
        ArrayList<ClassData> classesOfTheDay = new ArrayList<>();

        Cursor cursor = database.query(day,
                null, DatabaseHelper.COL_ID + "= " + id, null, null, null, DatabaseHelper.START_TIME + " ASC ");


        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();

            for (int i = 0; i < cursor.getCount(); i++) {
                int classId = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_ID));
                String taskTitle = cursor.getString(cursor.getColumnIndex(DatabaseHelper.CLASS_TITLE));
                String taskLocation = cursor.getString(cursor.getColumnIndex(DatabaseHelper.CLASS_LOCATION));
                String taskDate = cursor.getString(cursor.getColumnIndex(DatabaseHelper.CLASS_DAYS));
                String taskTime = cursor.getString(cursor.getColumnIndex(DatabaseHelper.START_TIME));
                String taskInstitute = cursor.getString(cursor.getColumnIndex(DatabaseHelper.CLASS_INSTITUTE));
                String taskNote = cursor.getString(cursor.getColumnIndex(DatabaseHelper.CLASS_NOTE));
                String endTime = cursor.getString(cursor.getColumnIndex(DatabaseHelper.END_TIME));
                String endTime2 = cursor.getString(cursor.getColumnIndex(DatabaseHelper.END_TIME2));

                ClassData classData = new ClassData(classId, taskTitle, taskInstitute, taskLocation, taskTime, endTime, endTime2, taskNote, taskDate);
                classesOfTheDay.add(classData);

                cursor.moveToNext();
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        return classesOfTheDay;

    }


    public boolean deleteClassesOfTheDayById(String day, int id) {
        this.openDatabase();

        return database.delete(day, DatabaseHelper.COL_ID + "=" + id, null) > 0;
    }

    public ArrayList<ClassData> getClassesOfTheDayByStartTime(String day, String startTime) {
        this.openDatabase();
        ArrayList<ClassData> classesOfTheDay = new ArrayList<>();

        Cursor cursor = database.query(day,
                null, DatabaseHelper.START_TIME + "= " + startTime, null, null, null, DatabaseHelper.START_TIME + " ASC ");


        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();

            for (int i = 0; i < cursor.getCount(); i++) {
                int classId = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_ID));
                String taskTitle = cursor.getString(cursor.getColumnIndex(DatabaseHelper.CLASS_TITLE));
                String taskLocation = cursor.getString(cursor.getColumnIndex(DatabaseHelper.CLASS_LOCATION));
                String taskDate = cursor.getString(cursor.getColumnIndex(DatabaseHelper.CLASS_DAYS));
                String taskTime = cursor.getString(cursor.getColumnIndex(DatabaseHelper.START_TIME));
                String taskInstitute = cursor.getString(cursor.getColumnIndex(DatabaseHelper.CLASS_INSTITUTE));
                String taskNote = cursor.getString(cursor.getColumnIndex(DatabaseHelper.CLASS_NOTE));
                String endTime = cursor.getString(cursor.getColumnIndex(DatabaseHelper.END_TIME));
                String endTime2 = cursor.getString(cursor.getColumnIndex(DatabaseHelper.END_TIME2));

                ClassData classData = new ClassData(classId, taskTitle, taskInstitute, taskLocation, taskTime, endTime, endTime2, taskNote, taskDate);
                classesOfTheDay.add(classData);

                cursor.moveToNext();
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        return classesOfTheDay;

    }

    public ArrayList<ClassData> getClassesOfTheDayByEndTime(String day, String startTime) {
        this.openDatabase();
        ArrayList<ClassData> classesOfTheDay = new ArrayList<>();

        Cursor cursor = database.query(day,
                null, DatabaseHelper.END_TIME + "= " + startTime, null, null, null, DatabaseHelper.START_TIME + " ASC ");


        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();

            for (int i = 0; i < cursor.getCount(); i++) {
                int classId = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_ID));
                String taskTitle = cursor.getString(cursor.getColumnIndex(DatabaseHelper.CLASS_TITLE));
                String taskLocation = cursor.getString(cursor.getColumnIndex(DatabaseHelper.CLASS_LOCATION));
                String taskDate = cursor.getString(cursor.getColumnIndex(DatabaseHelper.CLASS_DAYS));
                String taskTime = cursor.getString(cursor.getColumnIndex(DatabaseHelper.START_TIME));
                String taskInstitute = cursor.getString(cursor.getColumnIndex(DatabaseHelper.CLASS_INSTITUTE));
                String taskNote = cursor.getString(cursor.getColumnIndex(DatabaseHelper.CLASS_NOTE));
                String endTime = cursor.getString(cursor.getColumnIndex(DatabaseHelper.END_TIME));
                String endTime2 = cursor.getString(cursor.getColumnIndex(DatabaseHelper.END_TIME2));

                ClassData classData = new ClassData(classId, taskTitle, taskInstitute, taskLocation, taskTime, endTime, endTime2, taskNote, taskDate);
                classesOfTheDay.add(classData);

                cursor.moveToNext();
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        return classesOfTheDay;

    }

    public ArrayList<ClassData> getClassesOfTheDayByEndTime2(String day, String startTime) {
        this.openDatabase();
        ArrayList<ClassData> classesOfTheDay = new ArrayList<>();

        Cursor cursor = database.query(day,
                null, DatabaseHelper.END_TIME2 + "= " + startTime, null, null, null, DatabaseHelper.START_TIME + " ASC ");


        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();

            for (int i = 0; i < cursor.getCount(); i++) {
                int classId = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_ID));
                String taskTitle = cursor.getString(cursor.getColumnIndex(DatabaseHelper.CLASS_TITLE));
                String taskLocation = cursor.getString(cursor.getColumnIndex(DatabaseHelper.CLASS_LOCATION));
                String taskDate = cursor.getString(cursor.getColumnIndex(DatabaseHelper.CLASS_DAYS));
                String taskTime = cursor.getString(cursor.getColumnIndex(DatabaseHelper.START_TIME));
                String taskInstitute = cursor.getString(cursor.getColumnIndex(DatabaseHelper.CLASS_INSTITUTE));
                String taskNote = cursor.getString(cursor.getColumnIndex(DatabaseHelper.CLASS_NOTE));
                String endTime = cursor.getString(cursor.getColumnIndex(DatabaseHelper.END_TIME));
                String endTime2 = cursor.getString(cursor.getColumnIndex(DatabaseHelper.END_TIME2));

                ClassData classData = new ClassData(classId, taskTitle, taskInstitute, taskLocation, taskTime, endTime, endTime2, taskNote, taskDate);
                classesOfTheDay.add(classData);

                cursor.moveToNext();
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        return classesOfTheDay;

    }


}
