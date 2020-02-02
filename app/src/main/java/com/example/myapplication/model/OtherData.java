package com.example.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OtherData {

    @SerializedName("avg_hours_prep")
    @Expose
    private Integer avgHoursPrep;
    @SerializedName("avg_physics")
    @Expose
    private Integer avgPhysics;
    @SerializedName("avg_chem")
    @Expose
    private Integer avgChem;
    @SerializedName("avg_bio")
    @Expose
    private Integer avgBio;
    @SerializedName("avg_time_per_quest")
    @Expose
    private Integer avgTimePerQuest;
    @SerializedName("avg_correct_ans")
    @Expose
    private Integer avgCorrectAns;

    public Integer getAvgHoursPrep() {
        return avgHoursPrep;
    }

    public void setAvgHoursPrep(Integer avgHoursPrep) {
        this.avgHoursPrep = avgHoursPrep;
    }

    public Integer getAvgPhysics() {
        return avgPhysics;
    }

    public void setAvgPhysics(Integer avgPhysics) {
        this.avgPhysics = avgPhysics;
    }

    public Integer getAvgChem() {
        return avgChem;
    }

    public void setAvgChem(Integer avgChem) {
        this.avgChem = avgChem;
    }

    public Integer getAvgBio() {
        return avgBio;
    }

    public void setAvgBio(Integer avgBio) {
        this.avgBio = avgBio;
    }

    public Integer getAvgTimePerQuest() {
        return avgTimePerQuest;
    }

    public void setAvgTimePerQuest(Integer avgTimePerQuest) {
        this.avgTimePerQuest = avgTimePerQuest;
    }

    public Integer getAvgCorrectAns() {
        return avgCorrectAns;
    }

    public void setAvgCorrectAns(Integer avgCorrectAns) {
        this.avgCorrectAns = avgCorrectAns;
    }

}