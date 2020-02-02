package com.example.myapplication.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.R;

import java.util.ArrayList;

public class DetailedReportActivity extends AppCompatActivity {

    ArrayList<String> details;
    RecyclerView mRecyclerview;
    RecyclerView.LayoutManager mLayoutManger;
    RecyclerView.Adapter mAdapter;

    /*
    *   The format and data in the detailed report is unkown. Thus Garbage data has be displayed in the recycler view.
    *   Once the format is know, the layout can be adjusted and the data can be added via additional tweaking in the retrofit model.
    *
    * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_report);

        mRecyclerview = (RecyclerView)findViewById(R.id.detailedReportRecyclerView);

        details = new ArrayList<>();

        details.add("Physics Detailed Report");
        details.add("Lorem ipsum dolor sit amet");
        details.add("Lorem ipsum dolor sit amet");
        details.add("Physics Detailed Report");
        details.add("Lorem ipsum dolor sit amet");
        details.add("Physics Detailed Report");
        details.add("Lorem ipsum dolor sit amet");
        details.add("Lorem ipsum dolor sit amet");
        details.add("Lorem ipsum dolor sit amet");
        details.add("Lorem ipsum dolor sit amet");
        details.add("Lorem ipsum dolor sit amet");
        details.add("Physics Detailed Report");
        details.add("Lorem ipsum dolor sit amet");
        details.add("Lorem ipsum dolor sit amet");
        details.add("Biology Detailed Report");
        details.add("Lorem ipsum dolor sit amet");
        details.add("Lorem ipsum dolor sit amet");
        details.add("Lorem ipsum dolor sit amet");
        details.add("Biology Detailed Report");
        details.add("Lorem ipsum dolor sit amet");
        details.add("Lorem ipsum dolor sit amet");
        details.add("Lorem ipsum dolor sit amet");
        details.add("Biology Detailed Report");
        details.add("Lorem ipsum dolor sit amet");
        details.add("Biology Detailed Report");

        mRecyclerview.setHasFixedSize(true);
        mLayoutManger = new LinearLayoutManager(this);
        mAdapter = new MainAdapter(details);
        mRecyclerview.setLayoutManager(mLayoutManger);
        mRecyclerview.setAdapter(mAdapter);

    }
}
