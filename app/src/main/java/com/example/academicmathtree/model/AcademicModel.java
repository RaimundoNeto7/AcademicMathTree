package com.example.academicmathtree.model;

public class AcademicModel {
    private String uid;
    private String name;
    private String university;
    private String expertise;
    private String job;
    private String description;

    public AcademicModel(){

    }

    public AcademicModel(String uid, String name, String university, String expertise, String job, String description) {
        this.uid = uid;
        this.name = name;
        this.university = university;
        this.expertise = expertise;
        this.job = job;
        this.description = description;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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
}
