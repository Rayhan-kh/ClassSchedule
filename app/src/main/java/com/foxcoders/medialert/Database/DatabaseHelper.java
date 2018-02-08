package com.foxcoders.medialert.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ray on 1/23/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ScheduleDB";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_SAT = "Saturday";
    public static final String TABLE_SUN = "Sunday";
    public static final String TABLE_MON = "Monday";
    public static final String TABLE_TUE = "Tuesday";
    public static final String TABLE_WED = "Wednesday";
    public static final String TABLE_THR = "Thursday";
    public static final String TABLE_FRI = "Friday";


    public static final String COL_ID = "id";
    public static final String CLASS_TITLE = "class_title";
    public static final String CLASS_LOCATION = "class_location";
    public static final String CLASS_DAYS = "class_days";
    public static final String START_TIME = "start_time";
    public static final String END_TIME = "end_time";
    public static final String END_TIME2 = "end_time2";
    public static final String CLASS_INSTITUTE = "class_institute";
    public static final String CLASS_NOTE = "class_note";

    private static final String CREATE_USER_TABLE_SAT = " CREATE TABLE " + TABLE_SAT +
            " ( " + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CLASS_TITLE + " TEXT NOT NULL, " + CLASS_LOCATION + " TEXT, "
            + CLASS_DAYS + " TEXT, " + CLASS_INSTITUTE + " TEXT, "
            + START_TIME + " TEXT, " + END_TIME + " TEXT, " + END_TIME2 + " TEXT, " + CLASS_NOTE + " TEXT )";

    private static final String CREATE_USER_TABLE_SUN = " CREATE TABLE " + TABLE_SUN +
            " ( " + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CLASS_TITLE + " TEXT NOT NULL, " + CLASS_LOCATION + " TEXT, "
            + CLASS_DAYS + " TEXT, " + CLASS_INSTITUTE + " TEXT, "
            + START_TIME + " TEXT, " + END_TIME + " TEXT, " + END_TIME2 + " TEXT, " + CLASS_NOTE + " TEXT )";

    private static final String CREATE_USER_TABLE_MON = " CREATE TABLE " + TABLE_MON +
            " ( " + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CLASS_TITLE + " TEXT NOT NULL, " + CLASS_LOCATION + " TEXT, "
            + CLASS_DAYS + " TEXT, " + CLASS_INSTITUTE + " TEXT, "
            + START_TIME + " TEXT, " + END_TIME + " TEXT, " + END_TIME2 + " TEXT, " + CLASS_NOTE + " TEXT )";

    private static final String CREATE_USER_TABLE_TUE = " CREATE TABLE " + TABLE_TUE +
            " ( " + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CLASS_TITLE + " TEXT NOT NULL, " + CLASS_LOCATION + " TEXT, "
            + CLASS_DAYS + " TEXT, " + CLASS_INSTITUTE + " TEXT, "
            + START_TIME + " TEXT, " + END_TIME + " TEXT, " + END_TIME2 + " TEXT, " + CLASS_NOTE + " TEXT )";

    private static final String CREATE_USER_TABLE_WED = " CREATE TABLE " + TABLE_WED +
            " ( " + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CLASS_TITLE + " TEXT NOT NULL, " + CLASS_LOCATION + " TEXT, "
            + CLASS_DAYS + " TEXT, " + CLASS_INSTITUTE + " TEXT, "
            + START_TIME + " TEXT, " + END_TIME + " TEXT, " + END_TIME2 + " TEXT, " + CLASS_NOTE + " TEXT )";

    private static final String CREATE_USER_TABLE_THR = " CREATE TABLE " + TABLE_THR +
            " ( " + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CLASS_TITLE + " TEXT NOT NULL, " + CLASS_LOCATION + " TEXT, "
            + CLASS_DAYS + " TEXT, " + CLASS_INSTITUTE + " TEXT, "
            + START_TIME + " TEXT, " + END_TIME + " TEXT, " + END_TIME2 + " TEXT, " + CLASS_NOTE + " TEXT )";

    private static final String CREATE_USER_TABLE_FRI = " CREATE TABLE " + TABLE_FRI +
            " ( " + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CLASS_TITLE + " TEXT NOT NULL, " + CLASS_LOCATION + " TEXT, "
            + CLASS_DAYS + " TEXT, " + CLASS_INSTITUTE + " TEXT, "
            + START_TIME + " TEXT, " + END_TIME + " TEXT, " + END_TIME2 + " TEXT, " + CLASS_NOTE + " TEXT )";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_USER_TABLE_SAT);
        sqLiteDatabase.execSQL(CREATE_USER_TABLE_SUN);
        sqLiteDatabase.execSQL(CREATE_USER_TABLE_MON);
        sqLiteDatabase.execSQL(CREATE_USER_TABLE_TUE);
        sqLiteDatabase.execSQL(CREATE_USER_TABLE_WED);
        sqLiteDatabase.execSQL(CREATE_USER_TABLE_THR);
        sqLiteDatabase.execSQL(CREATE_USER_TABLE_FRI);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
