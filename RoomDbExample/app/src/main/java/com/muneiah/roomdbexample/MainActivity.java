package com.muneiah.roomdbexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText et_stuName,et_stu_number;
RecyclerView rec;
static StudentDatabase database;
Student_Entity studentEntity;
List<Student_Entity> studentEntityList;
StudentAdaper adaper;
static MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_stu_number=findViewById(R.id.student_rollnumber);
        et_stuName=findViewById(R.id.student_name);
        rec=findViewById(R.id.recycler);
        /*database=Room.databaseBuilder(this,StudentDatabase.class,"studentsdb")
                .allowMainThreadQueries()
                .build();*/ //for normal room db
        viewModel= ViewModelProviders.of(this).get(MyViewModel.class);
        viewModel.liveData().observe(this, new Observer<List<Student_Entity>>() {
            @Override
            public void onChanged(List<Student_Entity> student_entities) {
                adaper=new StudentAdaper(MainActivity.this,student_entities);
                rec.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                rec.setAdapter(adaper);
            }
        });
}

    public void saveData(View view)
    {
        String myname=et_stuName.getText().toString();
        String myrollnumber=et_stu_number.getText().toString();
        studentEntity=new Student_Entity();
        studentEntity.setName(myname);
        studentEntity.setRollnumber(myrollnumber);
        database.studentDAO().insert(studentEntity);
        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();

    }
/*normal db */
    /*public void retriveData(View view) {
        studentEntityList=database.studentDAO().retrive();
        adaper=new StudentAdaper(this,studentEntityList);
        rec.setLayoutManager(new LinearLayoutManager(this));
        rec.setAdapter(adaper);
    }*/
}
