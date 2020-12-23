package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.listview);
        String[] names = {"Sai","Sai1","Sai3","Sai4","Sai5","Sai6",
                "Sai","Sai1","Sai3","Sai4","Sai5","Sai6",
                "Sai","Sai1","Sai3","Sai4","Sai5","Sai6",};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,names);
        lv.setAdapter(adapter);

    }
}