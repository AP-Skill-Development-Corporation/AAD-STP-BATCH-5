package com.muneiah.roomdbexample;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class StudentRepo {
    StudentDatabase database;
    LiveData<List<Student_Entity>> listLiveData;
    public StudentRepo(Application app){
        database=StudentDatabase.getDataBase(app);
        listLiveData=database.studentDAO().livedata();
    }
    //background task
    //insert
    public class MyAysncTaskInsert extends AsyncTask<Student_Entity,Void,Void>{
        @Override
        protected Void doInBackground(Student_Entity... student_entities) {
            database.studentDAO().insert(student_entities[0]);
            return null;
        }
    }
        //UPDATE
    public class MyAysncTaskUpdate extends AsyncTask<Student_Entity,Void,Void>{

        @Override
        protected Void doInBackground(Student_Entity... student_entities) {
            database.studentDAO().update(student_entities[0]);
            return null;
        }
    }
    //Delete
    public class MyAysncTaskDelete extends AsyncTask<Student_Entity,Void,Void>{

        @Override
        protected Void doInBackground(Student_Entity... student_entities) {
            database.studentDAO().delete(student_entities[0]);
            return null;
        }
    }
    public void insert(Student_Entity entity){
         new MyAysncTaskInsert().execute(entity);
    }
    public void update(Student_Entity entity){
        new MyAysncTaskUpdate().execute(entity);
    }
    public void delete(Student_Entity entity){
        new MyAysncTaskDelete().execute(entity);
    }
    //For Retrive
    public LiveData<List<Student_Entity>> liveData(){
        return listLiveData;
    }

}
