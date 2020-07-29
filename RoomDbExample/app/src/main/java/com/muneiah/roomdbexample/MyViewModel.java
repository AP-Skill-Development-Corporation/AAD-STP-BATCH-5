package com.muneiah.roomdbexample;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel
{
    StudentRepo studentRepo;
    LiveData<List<Student_Entity>> listLiveData;

    public MyViewModel(@NonNull Application application) {
        super(application);
        studentRepo=new StudentRepo(application);
        listLiveData=studentRepo.liveData();

    }
    public void insert(Student_Entity entity){
        studentRepo.insert(entity);
    }

    public void update(Student_Entity entity){
        studentRepo.update(entity);
    }

    public void delete(Student_Entity entity){
        studentRepo.delete(entity);
    }
    public LiveData<List<Student_Entity>> liveData(){
        return listLiveData;
    }
}
