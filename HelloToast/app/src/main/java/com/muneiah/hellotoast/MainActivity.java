package com.muneiah.hellotoast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
int count=0;
TextView tv;
public static final String KEY="muneiah";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //here we need to inisilize or connect a xml componts id's through findViewById()
        tv=findViewById(R.id.mytextview);
        if (savedInstanceState!=null && savedInstanceState.containsKey(KEY)){
            int data=savedInstanceState.getInt(KEY);
            tv.setText(String.valueOf(data));
        }

    }
//for show toast message
    public void showToastMessage(View view) {
        Toast.makeText(this, "Count is :"+count, Toast.LENGTH_SHORT).show();
    }

    //incresing the count
    public void increaseCount(View view) {
        count++;
        tv.setText(String.valueOf(count));
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //here data in form of KEY and VALUE Paire
        outState.putInt(KEY,count);
    }
}
