package com.example.academicmathtree;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.academicmathtree.data.AcademicTreeContract;
import com.example.academicmathtree.data.AcademicTreeContract.AcademicEntry;
import com.example.academicmathtree.model.AcademicModel;

import de.blox.graphview.BaseGraphAdapter;
import de.blox.graphview.ViewHolder;

public class AcademicNodeAdapter extends BaseGraphAdapter<ViewHolder> {
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.node_academic, parent, false);
        return new AcademicNodeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final Object data, int position) {
        final AcademicModel academicModel = (AcademicModel) data;
        ((AcademicNodeViewHolder)viewHolder).textvalueNodeName.setText(academicModel.getName());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = viewHolder.itemView.getContext();
                Intent intentDetail = new Intent(context, DetailAcademicActivity.class);
                intentDetail.putExtra(AcademicEntry._ID, academicModel.getId());
                intentDetail.putExtra(AcademicEntry.COLUMN_NAME, academicModel.getName());
                intentDetail.putExtra(AcademicEntry.COLUMN_UNIVERSITY, academicModel.getUniversity());
                intentDetail.putExtra(AcademicEntry.COLUMN_EXPERTISE, academicModel.getExpertise());
                intentDetail.putExtra(AcademicEntry.COLUMN_JOB, academicModel.getJob());
                intentDetail.putExtra(AcademicEntry.COLUMN_DESCRIPTION, academicModel.getDescription());
                context.startActivity(intentDetail);
            }
        });
    }


}
