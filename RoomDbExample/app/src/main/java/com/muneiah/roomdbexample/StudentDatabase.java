package com.muneiah.roomdbexample;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Student_Entity.class, version = 1, exportSchema = false)
public abstract class StudentDatabase extends RoomDatabase {
    private static StudentDatabase database;

    public abstract StudentDAO studentDAO();

    //for live data
    public static synchronized StudentDatabase getDataBase(Context context) {
        if (database == null) {
            database = Room.databaseBuilder(context, StudentDatabase.class, "studentsdb")
                    .allowMainThreadQueries()
                    .build();
        }
        return database;
    }

}
