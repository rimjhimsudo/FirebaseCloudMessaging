package com.example.fcmdemo;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MyforegroundService  extends Service {
    private static  final String TAG="MyforegroundService";
    @Override
    public void onCreate(){
        super.onCreate();
        Log.d(TAG,"onCreate of foreground sevice worked ");
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startID){
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0, notificationIntent, 0);
        String channelId=String.valueOf(R.string.channel_id);
        Notification notification = new NotificationCompat.Builder(this, channelId)
                .setContentTitle("foreground Service")
                .setContentText("started")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentIntent(pendingIntent)
                .setColor(getResources().getColor(R.color.colorAccent))
                .build();
        startForeground(1, notification);
       // not sticky because foreground is unlike to be killed.
        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
