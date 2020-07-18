package com.example.implicitintenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void makeaCall(View view) {
        //Implicit Intent we have two parameers
        // Action,URI
        Uri u = Uri.parse("tel:1234567890");
        Intent i = new Intent(Intent.ACTION_DIAL,u);
        startActivity(i);

    }

    public void openUrl(View view) {
        Uri u = Uri.parse("https://www.google.com");
        Intent i = new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);

    }

    public void openMap(View view) {
        //Uri u = Uri.parse("geo:15.7742,78.0568");
        //If you want to add the marker
        //Uri u = Uri.parse("geo:0,0?q=15.7742,78.0568");

        //Near by places
        Uri u = Uri.parse("geo:15.7742,78.0568?q=policestation");
        Intent i = new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }
}
