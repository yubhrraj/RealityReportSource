package com.example.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserData_ {

    /*
    *   This has been set up according the format and data in UserData.JSON File located in assets folder.
    * */

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("test_name")
    @Expose
    private String testName;
    @SerializedName("overall_percentile")
    @Expose
    private Integer overallPercentile;
    @SerializedName("score_physics")
    @Expose
    private Integer scorePhysics;
    @SerializedName("expected_physics")
    @Expose
    private Integer expectedPhysics;
    @SerializedName("score_biology")
    @Expose
    private Integer scoreBiology;
    @SerializedName("expected_biology")
    @Expose
    private Integer expectedBiology;
    @SerializedName("score_chemistry")
    @Expose
    private Integer scoreChemistry;
    @SerializedName("expected_chemistry")
    @Expose
    private Integer expectedChemistry;
    @SerializedName("avg_time_per_quest")
    @Expose
    private Integer avgTimePerQuest;
    @SerializedName("hours_prep")
    @Expose
    private Integer hoursPrep;
    @SerializedName("score_improv")
    @Expose
    private Double scoreImprov;
    @SerializedName("time_imporv")
    @Expose
    private Integer timeImporv;
    @SerializedName("correct_ans")
    @Expose
    private Integer correctAns;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Integer getOverallPercentile() {
        return overallPercentile;
    }

    public void setOverallPercentile(Integer overallPercentile) {
        this.overallPercentile = overallPercentile;
    }

    public Integer getScorePhysics() {
        return scorePhysics;
    }

    public void setScorePhysics(Integer scorePhysics) {
        this.scorePhysics = scorePhysics;
    }

    public Integer getExpectedPhysics() {
        return expectedPhysics;
    }

    public void setExpectedPhysics(Integer expectedPhysics) {
        this.expectedPhysics = expectedPhysics;
    }

    public Integer getScoreBiology() {
        return scoreBiology;
    }

    public void setScoreBiology(Integer scoreBiology) {
        this.scoreBiology = scoreBiology;
    }

    public Integer getExpectedBiology() {
        return expectedBiology;
    }

    public void setExpectedBiology(Integer expectedBiology) {
        this.expectedBiology = expectedBiology;
    }

    public Integer getScoreChemistry() {
        return scoreChemistry;
    }

    public void setScoreChemistry(Integer scoreChemistry) {
        this.scoreChemistry = scoreChemistry;
    }

    public Integer getExpectedChemistry() {
        return expectedChemistry;
    }

    public void setExpectedChemistry(Integer expectedChemistry) {
        this.expectedChemistry = expectedChemistry;
    }

    public Integer getAvgTimePerQuest() {
        return avgTimePerQuest;
    }

    public void setAvgTimePerQuest(Integer avgTimePerQuest) {
        this.avgTimePerQuest = avgTimePerQuest;
    }

    public Integer getHoursPrep() {
        return hoursPrep;
    }

    public void setHoursPrep(Integer hoursPrep) {
        this.hoursPrep = hoursPrep;
    }

    public Double getScoreImprov() {
        return scoreImprov;
    }

    public void setScoreImprov(Double scoreImprov) {
        this.scoreImprov = scoreImprov;
    }

    public Integer getTimeImporv() {
        return timeImporv;
    }

    public void setTimeImporv(Integer timeImporv) {
        this.timeImporv = timeImporv;
    }

    public Integer getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(Integer correctAns) {
        this.correctAns = correctAns;
    }

}