package com.example.myapplication.db.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "data")
public class SavedData {

    @ColumnInfo(name="test_id")
    @PrimaryKey(autoGenerate = false)
    private long id;

    @ColumnInfo(name = "score")
    private long  score;

    @ColumnInfo(name="exp_score")
    private long  expScore;

    @ColumnInfo(name= "hours_studied")
    private long  hoursStudied;

    @ColumnInfo(name="avg_time_p_ques")
    private long  avgTimePQuest;

    public SavedData(long  id, long  score, long  expScore, long  hoursStudied, long  avgTimePQuest) {
        this.id = id;
        this.score = score;
        this.expScore = expScore;
        this.hoursStudied = hoursStudied;
        this.avgTimePQuest = avgTimePQuest;
    }

    public long  getId() {
        return id;
    }

    public void setId(long  id) {
        this.id = id;
    }

    public long  getScore() {
        return score;
    }

    public void setScore(long  score) {
        this.score = score;
    }

    public long  getExpScore() {
        return expScore;
    }

    public void setExpScore(long  expScore) {
        this.expScore = expScore;
    }

    public long  getHoursStudied() {
        return hoursStudied;
    }

    public void setHoursStudied(long  hoursStudied) {
        this.hoursStudied = hoursStudied;
    }

    public long  getAvgTimePQuest() {
        return avgTimePQuest;
    }

    public void setAvgTimePQuest(long  avgTimePQuest) {
        this.avgTimePQuest = avgTimePQuest;
    }
}
