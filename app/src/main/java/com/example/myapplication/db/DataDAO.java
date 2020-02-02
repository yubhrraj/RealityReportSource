package com.example.myapplication.db;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.db.entity.SavedData;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DataDAO {

    @Insert
    public long addData(SavedData data);

    @Update
    public void updateData(SavedData data);

    @Delete
    public void deleteData(SavedData data);

    @Query("select * from data")
    public List<SavedData> getData();


    @Query("select * from data where test_id ==:id")
    public SavedData getData(int id);


}
