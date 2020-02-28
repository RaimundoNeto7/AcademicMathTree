package com.example.academicmathtree.data;

import android.content.ContentValues;

import com.example.academicmathtree.data.AcademicTreeContract.AcademicEntry;
import com.example.academicmathtree.data.AcademicTreeContract.GuideEntry;
import com.example.academicmathtree.model.AcademicModel;
import com.example.academicmathtree.model.GuideModel;

public class AcademicContentValue {
    public static ContentValues getAcademicValues(AcademicModel academicModel) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(AcademicEntry._ID, academicModel.getId());
        contentValues.put(AcademicEntry.COLUMN_NAME, academicModel.getName());
        contentValues.put(AcademicEntry.COLUMN_UNIVERSITY, academicModel.getUniversity());
        contentValues.put(AcademicEntry.COLUMN_EXPERTISE, academicModel.getExpertise());
        contentValues.put(AcademicEntry.COLUMN_JOB, academicModel.getJob());
        contentValues.put(AcademicEntry.COLUMN_DESCRIPTION, academicModel.getDescription());
        contentValues.put(AcademicEntry.COLUMN_ROOT, academicModel.getRoot());
        return  contentValues;
    }

    public static ContentValues getGuideValues(GuideModel guideModel){
        ContentValues contentValues = new ContentValues();
        contentValues.put(GuideEntry._ID, guideModel.getId());
        contentValues.put(GuideEntry.COLUMN_ID_TEARCHER, guideModel.getIdTeacher());
        contentValues.put(GuideEntry.COLUMN_ID_STUDENT, guideModel.getIdStudent());
        return contentValues;
    }
}
