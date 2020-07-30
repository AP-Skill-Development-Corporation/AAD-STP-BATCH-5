package com.muneiah.serviceeample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView img;
int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=findViewById(R.id.myimage);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (i==0){
                    i++;
                    Intent i=new Intent(MainActivity.this,MyService.class);
                    startService(i);
                    img.setImageResource(R.drawable.ic_stop_black_24dp);


                }

                else {
                    i--;
                    Intent i=new Intent(MainActivity.this,MyService.class);
                    stopService(i);
                    img.setImageResource(R.drawable.ic_play_arrow_black_24dp);

                }


            }
        });
    }
}
