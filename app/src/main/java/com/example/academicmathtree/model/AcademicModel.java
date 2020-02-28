package com.example.academicmathtree.model;

import android.database.Cursor;

import com.example.academicmathtree.data.AcademicTreeContract;
import com.example.academicmathtree.data.AcademicTreeContract.AcademicEntry;

public class AcademicModel {
    private int id;
    private String name;
    private String university;
    private String expertise;
    private String job;
    private String description;
    private int idRoot;

    public AcademicModel(){

    }

    public AcademicModel(int id, String name, String university, String expertise, String job, String description, int idRoot) {
        this.id = id;
        this.name = name;
        this.university = university;
        this.expertise = expertise;
        this.job = job;
        this.description = description;
        this.idRoot = idRoot;
    }

    public AcademicModel(Cursor cursor){
        this.id = cursor.getInt(cursor.getColumnIndex(AcademicEntry._ID));
        this.name = cursor.getString(cursor.getColumnIndex(AcademicEntry.COLUMN_NAME));
        this.university = cursor.getString(cursor.getColumnIndex(AcademicEntry.COLUMN_UNIVERSITY));
        this.expertise = cursor.getString(cursor.getColumnIndex(AcademicEntry.COLUMN_EXPERTISE));
        this.job = cursor.getString(cursor.getColumnIndex(AcademicEntry.COLUMN_JOB));
        this.description = cursor.getString(cursor.getColumnIndex(AcademicEntry.COLUMN_DESCRIPTION));
        this.idRoot = cursor.getInt(cursor.getColumnIndex(AcademicEntry.COLUMN_ID_ROOT));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdRoot() {
        return idRoot;
    }

    public void setIdRoot(int idRoot) {
        this.idRoot = idRoot;
    }
}
