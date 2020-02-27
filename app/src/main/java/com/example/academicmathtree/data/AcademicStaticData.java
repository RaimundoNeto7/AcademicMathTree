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
        int rowsInserted = context.getContentResolver().bulkInsert(
                AcademicEntry.CONTENT_URI,
                contentValues.toArray(new ContentValues[contentValues.size()])
        );

        Log.e("AcademicProvider", "Rows inserted: " + rowsInserted);
    }
}
