package com.muneiah.notificationwithworkmanger;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class SeconClass extends Worker {
    NotificationManager nm;
    PendingIntent pi;
    Intent i;
    public static final String CHANNEL_ID="muneiah.tellakula.apssdc";

    public SeconClass(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public ListenableWorker.Result doWork() {
        nm = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        i = new Intent(getApplicationContext(), MainActivity.class);
        pi = PendingIntent.getActivity(getApplicationContext(), 87687, i, PendingIntent.FLAG_UPDATE_CURRENT);
        createChannel();
        showMyNotification();
        return ListenableWorker.Result.success();
    }

    private void createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel nc = new NotificationChannel(CHANNEL_ID, "muni", NotificationManager.IMPORTANCE_HIGH);
            nc.setLightColor(Color.BLUE);
            nc.enableVibration(true);
            nm.createNotificationChannel(nc);
        }

    }
    public void showMyNotification() {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(getApplicationContext(),CHANNEL_ID);
        builder.setContentTitle("This is My Notification");
        builder.setContentText("This is my own notification this property belogs to me..");
        builder.setSmallIcon(R.drawable.ic_notifications_black_24dp);
        builder.setDefaults(Notification.DEFAULT_ALL);
        builder.setContentIntent(pi);
        nm.notify(12345,builder.build());


    }
}
