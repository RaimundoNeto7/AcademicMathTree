package com.example.academicmathtree.data;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.academicmathtree.data.AcademicTreeContract.AcademicEntry;
import com.example.academicmathtree.model.AcademicModel;

import java.util.ArrayList;
import java.util.List;

import static com.example.academicmathtree.data.AcademicContentValue.getAcademicValues;

public class AcademicStaticData {
    //public AcademicModel(String uid, String name, String university, String expertise, String job, String description, Boolean isRoot) {
    public static void insertStaticData(Context context){
        List<ContentValues> contentValues = new ArrayList<>();

        ContentValues values = getAcademicValues(new AcademicModel(1, "Raimundo Neto", "UFAM", "Science Computer", "Software Engineer", "Handsome", true));
        contentValues.add(values);
        ContentValues values2 = getAcademicValues(new AcademicModel(2, "RN", "UFAM", "Science Computer", "Software Engineer", "Handsome", true));
        contentValues.add(values2);
        ContentValues values3 = getAcademicValues(new AcademicModel(3, "Rai2mundo Neto", "UFAM", "Science Computer", "Software Engineer", "Handsome", true));
        contentValues.add(values3);
        int rowsInserted = context.getContentResolver().bulkInsert(
                AcademicEntry.CONTENT_URI,
                contentValues.toArray(new ContentValues[3])
        );

        Log.e("AcademicProvider", "Academics inserted: " + rowsInserted);
    }
}
