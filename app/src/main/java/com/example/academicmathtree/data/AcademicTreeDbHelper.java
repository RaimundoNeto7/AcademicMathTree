package com.example.academicmathtree.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.academicmathtree.data.AcademicTreeContract.*;

public class AcademicTreeDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "academictree.db";
    public static final int DATABASE_VERSION = 2;

    public AcademicTreeDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_ACADEMIC_TABLE =
                "CREATE TABLE " + AcademicEntry.TABLE_NAME + " (" +
                AcademicEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                AcademicEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                AcademicEntry.COLUMN_UNIVERSITY + " TEXT NOT NULL, " +
                AcademicEntry.COLUMN_EXPERTISE + " TEXT NOT NULL, " +
                AcademicEntry.COLUMN_JOB + " TEXT NOT NULL, " +
                AcademicEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL, " +
                AcademicEntry.COLUMN_ROOT + " BOOLEAN NOT NULL) ";

        db.execSQL(SQL_CREATE_ACADEMIC_TABLE);

        final String SQL_CREATE_GUIDE_TABLE =
                "CREATE TABLE " + GuideEntry.TABLE_NAME + " (" +
                GuideEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                GuideEntry.COLUMN_ID_TEARCHER + " INTEGER NOT NULL, " +
                GuideEntry.COLUMN_ID_STUDENT + " INTEGER NOT NULL)";

        db.execSQL(SQL_CREATE_GUIDE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + AcademicEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + GuideEntry.TABLE_NAME);
        onCreate(db);
    }
}
