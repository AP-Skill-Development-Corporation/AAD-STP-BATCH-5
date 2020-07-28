package com.muneiah.roomdbexample;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = Student_Entity.class,version = 1,exportSchema = false)
public abstract class StudentDatabase extends RoomDatabase {
    private StudentDatabase database;
    public abstract StudentDAO studentDAO();

}
