package com.example.myapplication.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.anychart.APIlib;
import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.charts.Radar;
import com.anychart.core.cartesian.series.Column;
import com.anychart.core.radar.series.Line;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.Align;
import com.anychart.enums.MarkerType;
import com.example.myapplication.R;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String testName, hoursPrep, avgTimePerQuest, avgHoursPrep, avgTimePerQuestOthers;

    int scorePhy,scoreChem,scoreBio,expScorePhy,expScoreBio,expScoreChem,correctAnswers, totalScore;
    int avgCorrectAns, avgBio,avgPhy,avgChem, avgScore;

    double scoreImporv, timeImprov, overallPercent;

    TextView testNameView, percentileView;

    TextView totalScoreView, avgTimePerQuestView, totalSyllabusView, timeImprovView, scoreImprovView, preHoursView, avgPrepHoursView;

    AnyChartView anyChartView, radarChart;

    Button historyButton, detailedReportButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        get_json();

        anyChartView = (AnyChartView)findViewById(R.id.barChart);
        APIlib.getInstance().setActiveAnyChartView(anyChartView);

        displayAnyChart();

        setDetailCards();

        radarChart = (AnyChartView)findViewById(R.id.radarChart);
        APIlib.getInstance().setActiveAnyChartView(radarChart);

        displayRadarChart();

        historyButton = (Button)findViewById(R.id.historyButton);
        detailedReportButton = (Button)findViewById(R.id.detaledReportButton);

        detailedReportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailedReportActivity.class);
                startActivity(intent);
            }
        });

        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });

    }

    private void setDetailCards() {
        totalScoreView = (TextView) findViewById(R.id.totalScoreView);
        totalSyllabusView= (TextView) findViewById(R.id.totalSyllabusDoneView);
        timeImprovView= (TextView) findViewById(R.id.timeImprovView);
        scoreImprovView= (TextView) findViewById(R.id.scoreImrpovView);
        preHoursView= (TextView) findViewById(R.id.prepHourView);
        avgPrepHoursView= (TextView) findViewById(R.id.avgPrepHourView);
        avgTimePerQuestView= (TextView) findViewById(R.id.averageQuestionTimeView);


        //These values would be stored in string resouces folder and called via their ids

        totalScoreView.setText(Html.fromHtml("<b>Total Score:</b> " + totalScore));
        totalSyllabusView.setText(Html.fromHtml("<b>Total Syllabus Completed:</b> " + "68%"));
        timeImprovView.setText(Html.fromHtml("<b>Time Improvement:</b>  "+timeImprov+"%"));
        scoreImprovView.setText(Html.fromHtml("<b>Score Improvment:</b>  "+ scoreImporv+"%"));
        avgTimePerQuestView.setText(Html.fromHtml("<b>Average Time per Question:</b> " + avgTimePerQuest));
        preHoursView.setText(Html.fromHtml("<b>Preparation hours for tes:</b> "+ hoursPrep));
        avgPrepHoursView.setText(Html.fromHtml("<b>Average Preparation Hours:</b> "+avgHoursPrep));
    }


    /*
    *   The JSON File is directly read from the local storage stored in assests folder as USER.JSON
    *
    *   The JSON File recieved via REST APIs would be read and analysed by Retrofit. The services have been set up in servie and model package
    *
    * */

    public void get_json(){
        String json;
        InputStream js;
        try  {
            js = getAssets().open("UserData.JSON");
            int size = js.available();
            byte[] buffer = new byte[size];
            js.read(buffer);
            js.close();
            json = new String(buffer, "UTF-8");

            JSONObject obj = new JSONObject(json);
            JSONObject user = obj.getJSONObject("user_data");
            JSONObject otherData = obj.getJSONObject("other_data");

            setUserData(user);
            setOtherData(otherData);

        }
        catch(Exception e)
        {
            Log.v("This", e.toString());
            e.printStackTrace();
        }

    }

    /*
    *   Some of the data can be stored and retrieved directly from the database such as hoursPrep, expected score etc.
    *   scoreImprov can be directly calculated locally by storing and retrieving previous scores.
    * */

    public void setUserData(JSONObject obj) throws JSONException {

        testName = obj.get("test_name").toString();
        overallPercent = obj.getDouble("overall_percentile");
        scorePhy = obj.getInt("score_physics");
        scoreBio = obj.getInt("score_biology");
        scoreChem = obj.getInt("score_chemistry");
        expScoreBio = obj.getInt("expected_biology");
        expScoreChem = obj.getInt("expected_chemistry");
        expScorePhy = obj.getInt("expected_physics");
        correctAnswers = obj.getInt("correct_ans");
        hoursPrep = getTime(obj.getInt("hours_prep"));
        avgTimePerQuest = getTime(obj.getInt("avg_time_per_quest"));
        scoreImporv = obj.getDouble("score_improv");
        timeImprov = obj.getDouble("time_imporv");
        totalScore = scoreBio + scoreChem + scorePhy;

        setUserViews();
    }

    /*
    *   These data are used to comparison with performance of other users. These are calculated and sent from the backend servers.
    * */


    public void setOtherData(JSONObject obj) throws JSONException {
        avgPhy = obj.getInt("avg_physics");
        avgChem = obj.getInt("avg_chem");
        avgBio = obj.getInt("avg_bio");
        avgCorrectAns = obj.getInt("avg_correct_ans");
        avgHoursPrep = getTime(obj.getInt("avg_hours_prep"));
        avgTimePerQuestOthers = getTime(obj.getInt("avg_correct_ans"));

    }

    private void setUserViews() {
        testNameView = (TextView)findViewById(R.id.testName);
        testNameView.setText("Test "+ testName);

        percentileView = (TextView)findViewById(R.id.percentile);
        percentileView.setText("Percentile "+overallPercent + "%");
    }

    private void displayAnyChart() {

        Cartesian pie = AnyChart.column();
        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("Phy", scorePhy));
        data.add(new ValueDataEntry("Exp Phy", expScorePhy));
        data.add(new ValueDataEntry("Chem", scoreChem));
        data.add(new ValueDataEntry("Exp Chem", expScoreChem));
        data.add(new ValueDataEntry("Bio", scoreBio));
        data.add(new ValueDataEntry("Exp Bio", expScoreBio));

        pie.data(data);

        pie.animation(true);

        anyChartView.setChart(pie);
    }

    private void displayRadarChart() {
        Radar radar = AnyChart.radar();

        radar.title("Score Comparison");
        radar.yScale().minimum(0d);
        radar.yScale().minimumGap(0d);
        radar.yScale().ticks().interval(10d);

        radar.xAxis().labels().padding(5d, 5d, 5d, 5d);

        radar.legend()
                .align(Align.CENTER)
                .enabled(true);

        List<DataEntry> radarData = new ArrayList<>();
        radarData.add(new CustomDataEntry("Phy", scorePhy, avgPhy));
        radarData.add(new CustomDataEntry("Chem", scoreChem, avgChem));
        radarData.add(new CustomDataEntry("Bio", scoreBio, avgBio));
        radarData.add(new CustomDataEntry("Total", correctAnswers, avgCorrectAns));
        radarData.add(new CustomDataEntry("Physics", scorePhy, avgPhy));

        Set set = Set.instantiate();
        set.data(radarData);

        Mapping score = set.mapAs("{ x: 'x', value: 'value' }");
        Mapping avg = set.mapAs("{ x: 'x', value: 'value2' }");

        Line scoreLine = radar.line(score);
        scoreLine.name("Score");
        scoreLine.markers()
                .enabled(true)
                .type(MarkerType.CIRCLE)
                .size(3d);

        Line otherLine = radar.line(avg);

        otherLine.name("Avg Score");

        otherLine.markers()
                .enabled(true)
                .type(MarkerType.CIRCLE)
                .size(3d);

        radar.tooltip().format("Value: {%Value}");

        radarChart.setChart(radar);

    }

    private class CustomDataEntry extends ValueDataEntry {
        public CustomDataEntry(String x, Number value, Number value2) {
            super(x, value);
            setValue("value2", value2);
        }
    }

    public String getTime(int x){
        String time;
        x= x/1000;
        if(x/3600 < 1){
            time = x/60 + " minutes " + x%60 + " seconds";
        } else{
            time = x/3600 + " Hours " + x%60 + " Minutes";
        }
        return time;
    }
}
