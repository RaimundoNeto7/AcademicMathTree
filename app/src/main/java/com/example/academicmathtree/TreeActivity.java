package com.example.academicmathtree;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.academicmathtree.data.AcademicStaticData;
import com.example.academicmathtree.data.AcademicTreeContract;
import com.example.academicmathtree.data.AcademicTreeContract.AcademicEntry;
import com.example.academicmathtree.data.AcademicTreeContract.GuideEntry;
import com.example.academicmathtree.model.AcademicModel;
import com.example.academicmathtree.model.GuideModel;

import java.util.ArrayList;
import java.util.HashMap;

import de.blox.graphview.Graph;
import de.blox.graphview.GraphView;
import de.blox.graphview.Node;
import de.blox.graphview.tree.BuchheimWalkerAlgorithm;
import de.blox.graphview.tree.BuchheimWalkerConfiguration;

public class TreeActivity extends AppCompatActivity {

    private int nodeCount = 0;
    GraphView graphViewAcademic;
    Graph graphAcademic;
    AcademicNodeAdapter nodeAdapter;

    HashMap<Integer, ArrayList<AcademicModel>> academicRelationship;
    HashMap<Integer, AcademicModel> academicMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree);

        AcademicStaticData.insertStaticData(getApplicationContext());

        graphViewAcademic = findViewById(R.id.graphview_academic);
        graphAcademic = new Graph();

        final BuchheimWalkerConfiguration configuration = new BuchheimWalkerConfiguration.Builder()
                .setSiblingSeparation(200)
                .setLevelSeparation(400)
                .setSubtreeSeparation(400)
                .setOrientation(BuchheimWalkerConfiguration.ORIENTATION_LEFT_RIGHT)
                .build();

        getAcademicsFromDatabase();
        buildTree();
        nodeAdapter = new AcademicNodeAdapter();
        nodeAdapter.setAlgorithm(new BuchheimWalkerAlgorithm(configuration));
        nodeAdapter.setGraph(graphAcademic);
        graphViewAcademic.setAdapter(nodeAdapter);
    }

    private void getAcademicsFromDatabase() {
        String idRoot = "1";

        Uri uri = AcademicEntry.CONTENT_URI.buildUpon()
                .appendPath(AcademicEntry.COLUMN_ID_ROOT)
                .appendPath(idRoot)
                .build();
        Cursor root = getContentResolver().query(
                uri,
                null,
                null,
                null,
                null
        );

        academicRelationship = new HashMap<>();
        academicMap = new HashMap<>();

        if(root != null){
            while (root.moveToNext()){
                AcademicModel academicModel = new AcademicModel(root);
                academicRelationship.put(academicModel.getId(), new ArrayList<AcademicModel>());
                academicMap.put(academicModel.getId(), academicModel);
            }
            root.close();
        }

        for(Integer id : academicMap.keySet()) {
            Uri guideUri = GuideEntry.CONTENT_URI.buildUpon()
                    .appendPath(GuideEntry.COLUMN_ID_TEARCHER)
                    .appendPath(Integer.toString(id))
                    .build();
            Cursor guide = getContentResolver().query(
                    guideUri,
                    null,
                    null,
                    null,
                    null
            );
            if (guide != null){
                ArrayList<AcademicModel> academicModels = new ArrayList<>();
                while (guide.moveToNext()){
                    GuideModel guideModel = new GuideModel(guide);
                    AcademicModel academicStudent = academicMap.get(guideModel.getIdStudent());
                    academicModels.add(academicStudent);
                }
                academicRelationship.put(id, academicModels);
                guide.close();
            }
        }
    }

    private void buildTree(){
        for(Integer id : academicRelationship.keySet()){
            AcademicModel academicRoot = academicMap.get(id);
            Node root = new Node(academicRoot != null ? academicRoot.getName() : "null");

            ArrayList<AcademicModel> academicModels = academicRelationship.get(id);
            for(AcademicModel academicLeave : academicModels){
                Node leaves = new Node(academicLeave.getName());
                graphAcademic.addEdge(root, leaves);
            }
        }
    }
}
