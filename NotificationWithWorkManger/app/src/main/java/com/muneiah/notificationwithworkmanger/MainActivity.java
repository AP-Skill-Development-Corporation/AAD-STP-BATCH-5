package com.muneiah.notificationwithworkmanger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
NotificationManager nm;
PendingIntent pi;
Intent i;
public static final String CHANNEL_ID="muneiah.tellakula.apssdc";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i=new Intent(this,MainActivity.class);
        pi=PendingIntent.getActivity(this,123,i,PendingIntent.FLAG_UPDATE_CURRENT);
        nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        createChannel();
    }

    private void createChannel() {
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            NotificationChannel nc=new NotificationChannel(CHANNEL_ID,"muni",NotificationManager.IMPORTANCE_HIGH);
            nc.setLightColor(Color.BLUE);
            nc.enableVibration(true);
            nm.createNotificationChannel(nc);

        }
    }

    public void showMyNotification(View view) {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,CHANNEL_ID);
        builder.setContentTitle("This is My Notification");
        builder.setContentText("This is my own notification this property belogs to me..");
        builder.setSmallIcon(R.drawable.ic_notifications_black_24dp);
        builder.setDefaults(Notification.DEFAULT_ALL);
        builder.setContentIntent(pi);
        nm.notify(12345,builder.build());


    }
}
/* Intent intentObj=new Intent(this,MainACtivity.class)
PendingIntent pi=PendingIntent.getActivty(reqcode,this,intentObj,PendingIntent.FLAG_UPDATE_CURRENT);

* */