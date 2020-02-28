package com.example.academicmathtree.model;

import android.database.Cursor;

import com.example.academicmathtree.data.AcademicTreeContract;
import com.example.academicmathtree.data.AcademicTreeContract.GuideEntry;

public class GuideModel {
    private int id;
    private int idTeacher;
    private int idStudent;

    public GuideModel() {}

    public GuideModel(int id, int idTeacher, int idStudent) {
        this.id = id;
        this.idTeacher = idTeacher;
        this.idStudent = idStudent;
    }

    public GuideModel(Cursor cursor){
        this.id = cursor.getInt(cursor.getColumnIndex(GuideEntry._ID));
        this.idTeacher = cursor.getInt(cursor.getColumnIndex(GuideEntry.COLUMN_ID_TEARCHER));
        this.idStudent = cursor.getInt(cursor.getColumnIndex(GuideEntry.COLUMN_ID_STUDENT));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }
}
