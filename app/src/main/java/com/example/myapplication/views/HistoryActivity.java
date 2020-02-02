package com.example.myapplication.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.example.myapplication.R;


import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        AnyChartView anyChart = (AnyChartView) findViewById(R.id.historyChart);

        Cartesian chart = AnyChart.column();

        /*
        *  These Data can be retrieved directly from ROOM persistent database and the latest data are stored as soon as the report is generated.
        *  The data are hardcoded due to lack of data in the db.
        *  The database has been set up and can be viewed in db package.
        *
        * */

        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("Week 05", 71 ));
        data.add(new ValueDataEntry("Week 06", 70 ));
        data.add(new ValueDataEntry("Week 07", 68 ));
        data.add(new ValueDataEntry("Week 08", 51 ));
        data.add(new ValueDataEntry("Week 09", 72 ));
        data.add(new ValueDataEntry("Week 10", 66 ));
        data.add(new ValueDataEntry("Week 11", 74 ));
        data.add(new ValueDataEntry("Week 12", 75 ));
        data.add(new ValueDataEntry("Week 13", 80 ));
        data.add(new ValueDataEntry("Week 14", 78 ));
        data.add(new ValueDataEntry("Week 15", 88 ));
        data.add(new ValueDataEntry("Week 16", 70 ));
        data.add(new ValueDataEntry("Week 17", 75 ));
        data.add(new ValueDataEntry("Week 18", 71 ));
        data.add(new ValueDataEntry("Week 19", 77 ));
        data.add(new ValueDataEntry("Week 20", 74 ));
        data.add(new ValueDataEntry("Week 21", 76 ));



        Collections.reverse(data);
        chart.title("Score percentile");

        chart.animation(true);
        chart.xScroller(true);
        chart.xZoom().setTo(0, 0.3);

        chart.data(data);
        anyChart.setChart(chart);



    }
}
