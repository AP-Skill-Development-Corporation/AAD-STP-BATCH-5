package com.muneiah.roomdbexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
EditText editText_name,editText_rollnumber;
Student_Entity studentEntity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        editText_name=findViewById(R.id.student_name_update);
        editText_rollnumber=findViewById(R.id.student_rollnumber_update);
        Intent i=getIntent();
        String sn=i.getStringExtra("name");
        String sr=i.getStringExtra("roll");
        editText_name.setText(sn);
        editText_rollnumber.setText(sr);
        editText_rollnumber.setKeyListener(null);//we don't modify the edittext field

    }

    public void updateData(View view) {
        String myUpdatename=editText_name.getText().toString();
        String myUpdaterollnum=editText_rollnumber.getText().toString();
        studentEntity=new Student_Entity();
        studentEntity.setName(myUpdatename);
        studentEntity.setRollnumber(myUpdaterollnum);
       // MainActivity.database.studentDAO().update(studentEntity);//normal data update
        MainActivity.viewModel.update(studentEntity);//for live data update
        Toast.makeText(this, "updated"+myUpdatename, Toast.LENGTH_SHORT).show();
    Intent intent=new Intent(this,MainActivity.class);
    startActivity(intent);
    }
}
