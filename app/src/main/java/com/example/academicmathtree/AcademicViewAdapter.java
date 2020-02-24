package com.example.academicmathtree;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.academicmathtree.model.AcademicModel;

import java.util.List;

public class AcademicViewAdapter extends RecyclerView.Adapter<AcademicViewAdapter.AcademicViewHolder> {

    List<AcademicModel> listAcademics;

    public AcademicViewAdapter(List<AcademicModel> listAcademics) {
        this.listAcademics = listAcademics;
    }

    @Override
    public int getItemCount() {
        return this.listAcademics.size();
    }

    @NonNull
    @Override
    public AcademicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AcademicViewHolder holder, int position) {

    }

    public static class AcademicViewHolder extends RecyclerView.ViewHolder {
        TextView textValueName;
        TextView textValueUniversity;

        AcademicViewHolder(View view){
            super(view);
            textValueName = view.findViewById(R.id.item_academic_name);
            textValueUniversity = view.findViewById(R.id.item_academic_university);
        }
    }
}
