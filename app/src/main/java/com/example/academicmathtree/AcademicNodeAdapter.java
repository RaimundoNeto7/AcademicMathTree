package com.example.academicmathtree;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;

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
        ((AcademicNodeViewHolder)viewHolder).textvalueNodeName.setText(data.toString());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(viewHolder.itemView.getContext(), data.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}
