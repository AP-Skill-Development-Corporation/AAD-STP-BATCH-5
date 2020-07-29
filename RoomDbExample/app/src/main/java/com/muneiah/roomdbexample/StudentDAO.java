package com.muneiah.roomdbexample;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDAO
{
    @Insert
    public void insert(Student_Entity studentEntity);
    @Update
    public void update(Student_Entity studentEntity);
    @Delete
    public void delete(Student_Entity studentEntity);

    @Query("SELECT * FROM student_table")
    //public List<Student_Entity> retrive();//for normal d
    public LiveData<List<Student_Entity>> livedata();//for live data
}
