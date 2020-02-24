package com.example.academicmathtree;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AcademicViewAdapter extends RecyclerView.Adapter<AcademicViewAdapter.AcademicViewHolder> {

    public AcademicViewAdapter() {
    }

    @Override
    public int getItemCount() {
        return 0;
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
        AcademicViewHolder(View view){
            super(view);
        }
    }
}
