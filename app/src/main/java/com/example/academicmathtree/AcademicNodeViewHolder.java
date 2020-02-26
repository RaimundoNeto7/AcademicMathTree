package com.example.academicmathtree;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import de.blox.graphview.ViewHolder;

public class AcademicNodeViewHolder extends ViewHolder {
    TextView textvalueNodeName;

    public AcademicNodeViewHolder(@NonNull View itemView) {
        super(itemView);
        textvalueNodeName = itemView.findViewById(R.id.textvalue_node_name);
    }
}
