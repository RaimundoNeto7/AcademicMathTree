package com.example.academicmathtree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listViewAcademics;
    private ArrayList<String>  listAcademicsRandom;
    private ArrayAdapter<String> adapterListAcademics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewAcademics = findViewById(R.id.listview_academics);
        initializeListAcademics();
        adapterListAcademics = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, listAcademicsRandom);
        listViewAcademics.setAdapter(adapterListAcademics);

        populateListAcademics(adapterListAcademics);
    }

    private void initializeListAcademics(){
        listAcademicsRandom = new ArrayList<>();
    }

    private void populateListAcademics(ArrayAdapter adapterListAcademics){
        listAcademicsRandom.add("Beatriz Albuquerque");
        listAcademicsRandom.add("Ana Albuquerque");
        listAcademicsRandom.add("Raimundo Neto");
        listAcademicsRandom.add("Carol Alguma Coisa");

        adapterListAcademics.notifyDataSetChanged();
    }
}
