package com.example.academicmathtree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.academicmathtree.model.AcademicModel;

import java.util.ArrayList;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewAcademics;
    private ArrayList<AcademicModel>  listAcademicsRandom;
    private ArrayAdapter<String> adapterListAcademics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewAcademics = findViewById(R.id.recyclerview_academics);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewAcademics.setLayoutManager(layoutManager);
        initializeListAcademics();

        populateListAcademics(adapterListAcademics);
    }

    private void initializeListAcademics(){
        listAcademicsRandom = new ArrayList<>();
    }

    private void populateListAcademics(ArrayAdapter adapterListAcademics){
        listAcademicsRandom.add(new AcademicModel(UUID.randomUUID().toString(), "Beatriz Albuquerque", "Universidade Federal do Amazonas"));
        listAcademicsRandom.add(new AcademicModel(UUID.randomUUID().toString(), "Raimundo Neto", "Universidade Federal do Amazonas"));
        listAcademicsRandom.add(new AcademicModel(UUID.randomUUID().toString(), "Alguém de São Paulo", "Universidade de São Paulo"));
        listAcademicsRandom.add(new AcademicModel(UUID.randomUUID().toString(), "Mulher do Impa", "Instituto de Matemática Pura e Aplicada"));
        adapterListAcademics.notifyDataSetChanged();
    }
}
