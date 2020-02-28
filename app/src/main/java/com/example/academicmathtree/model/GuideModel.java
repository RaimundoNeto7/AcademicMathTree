package com.example.academicmathtree.model;

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
