package com.example.academicmathtree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.academicmathtree.data.AcademicTreeContract;
import com.example.academicmathtree.data.AcademicTreeContract.AcademicEntry;
import com.example.academicmathtree.model.AcademicModel;

public class DetailAcademicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_academic);

        Intent currentIntent = getIntent();

        TextView textValueUniversity = findViewById(R.id.textvalue_university);
        TextView textValueExpertise = findViewById(R.id.textvalue_expertise);
        TextView textValueJob = findViewById(R.id.textvalue_job);
        TextView textValueDescription = findViewById(R.id.textvalue_description);

        AcademicModel academicModel = new AcademicModel(
                currentIntent.getIntExtra(AcademicEntry._ID, -1),
                currentIntent.getStringExtra(AcademicEntry.COLUMN_NAME),
                currentIntent.getStringExtra(AcademicEntry.COLUMN_UNIVERSITY),
                currentIntent.getStringExtra(AcademicEntry.COLUMN_EXPERTISE),
                currentIntent.getStringExtra(AcademicEntry.COLUMN_JOB),
                currentIntent.getStringExtra(AcademicEntry.COLUMN_DESCRIPTION),
                currentIntent.getIntExtra(AcademicEntry.COLUMN_ID_ROOT, -1)
        );

        setTitle(academicModel.getName());
        textValueUniversity.setText(academicModel.getUniversity());
        textValueExpertise.setText(academicModel.getExpertise());
        textValueJob.setText(academicModel.getJob());
        textValueDescription.setText(academicModel.getDescription());
    }
}
