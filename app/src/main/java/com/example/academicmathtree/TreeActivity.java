package com.example.academicmathtree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

import de.blox.graphview.Graph;
import de.blox.graphview.GraphView;
import de.blox.graphview.Node;
import de.blox.graphview.tree.BuchheimWalkerAlgorithm;
import de.blox.graphview.tree.BuchheimWalkerConfiguration;

public class TreeActivity extends AppCompatActivity {

    private int nodeCount = 0;
    GraphView graphViewAcademic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree);

        graphViewAcademic = findViewById(R.id.graphview_academic);
        Graph graph = new Graph();
        Node node1 = new Node(getNodeText());
        Node node2 = new Node(getNodeText());
        Node node3 = new Node(getNodeText());

        graph.addEdge(node1, node2);
        graph.addEdge(node1, node3);

        AcademicNodeAdapter nodeAdapter = new AcademicNodeAdapter();
        nodeAdapter.setGraph(graph);
        graphViewAcademic.setAdapter(nodeAdapter);

        // set the algorithm here
        final BuchheimWalkerConfiguration configuration = new BuchheimWalkerConfiguration.Builder()
                .setSiblingSeparation(200)
                .setLevelSeparation(400)
                .setSubtreeSeparation(400)
                .setOrientation(BuchheimWalkerConfiguration.ORIENTATION_LEFT_RIGHT)
                .build();
        nodeAdapter.setAlgorithm(new BuchheimWalkerAlgorithm(configuration));
    }

    private String getNodeText() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Raimundo Neto");
        arrayList.add("Beatriz Albuquerque");
        arrayList.add("Vinícios Rebelo");
        return arrayList.get(nodeCount++);
    }
}
