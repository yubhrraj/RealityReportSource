package com.example.myapplication.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.myapplication.db.entity.SavedData;

@Database(entities = {SavedData.class}, version = 1)
public abstract class InfoDatabase extends RoomDatabase {

    public abstract DataDAO getDataDAO();


}
