package com.muneiah.acivitylifycles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        label=findViewById(R.id.tv);
        label.append("onCreate() \n ");
        Toast.makeText(this, "App is Created", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        label.append("onStrat() \n");
        Toast.makeText(this, "App is Started", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        label.append("onResume() \n");
        Toast.makeText(this, "App is Resumed ", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        label.append("onPause()\n");
        Toast.makeText(this, "App is paused", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        label.append("ondestroy()\n");
        Toast.makeText(this, "App is destroyed", Toast.LENGTH_SHORT).show();
    }
}
