package com.sqa.plannet.activity.todo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.sqa.plannet.R;


public class AlarmReceiver extends BroadcastReceiver {
    private static final String CHANNEL_ID  = "SAMPLE_CHANNEL";

    @Override
    public void onReceive(Context context, Intent intent) {
        int notificationId = intent.getIntExtra("notificationId", 0);
        String title = intent.getStringExtra("title");

        Intent mainIntent = new Intent(context, CreateActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, mainIntent, 0);
        NotificationManager myNotifiacation = (NotificationManager)  context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(context);
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("It's Time !")
                .setContentText(title)
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentIntent(contentIntent);
        myNotifiacation.notify(notificationId , builder.build());

    }
}
