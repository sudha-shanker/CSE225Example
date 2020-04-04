package com.example.cse225_android;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Action;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.RemoteInput;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RemoteViews;

public class NotificationExample extends AppCompatActivity {


    NotificationManager notificationManager;
    Button button;

    public static final String channal_ID = "My Channel Id";
    public  static final int notification_ID = 10;
    public static final String myKey = "Remote Key";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_example);
        notificationManager =
                (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

    }

        public void showNotification (View view)        {
            myNotificationChannel();

          //  RemoteViews remoteCollapsedViews = new RemoteViews(getPackageName(), R.layout.activity_splash_screen_example_main);
           // RemoteViews remoteExpandedViews = new RemoteViews(getPackageName(), R.layout.activity_splash_screen_example);

            Intent i = new Intent(this, NotificationViewExample.class);
            PendingIntent pi = PendingIntent.getActivity(this,
                    1, i, PendingIntent.FLAG_ONE_SHOT);

            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(this, channal_ID);

            builder.setSmallIcon(R.drawable.ic_announcement_black_24dp);
            builder.setContentTitle("My Notification");
            builder.setContentText("This is my Notification");
          //  builder.setCustomContentView(remoteCollapsedViews)
            //    .setCustomBigContentView(remoteExpandedViews)
              // builder .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                //.setAutoCancel(true);
            builder.setLights(Color.RED, 3000, 3000);
            builder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
            builder.setContentIntent(pi);


            if (VERSION.SDK_INT >= VERSION_CODES.N) {

                RemoteInput ri =
                        new RemoteInput.Builder(myKey).setLabel("Replying..")
                                .build();
                NotificationCompat.Action action = new NotificationCompat.Action.
                        Builder(R.drawable.check, "Reply", pi)
                        .addRemoteInput(ri).build();
                builder.addAction(action);
            }

            builder.setAutoCancel(true);
            notificationManager.notify(notification_ID, builder.build());
        }

        public void myNotificationChannel()
        {
            if(VERSION.SDK_INT >= VERSION_CODES.O ) {
                String name = "My Channel Name";
                String desc = "My Channel Description";
                int importance = NotificationManager.IMPORTANCE_HIGH;
                NotificationChannel notificationChannel =
                        new NotificationChannel(channal_ID, name, importance);
                notificationChannel.setDescription(desc);
                notificationChannel.enableLights(true);
                notificationChannel.enableVibration(true);
                notificationChannel.canShowBadge();

                notificationManager.createNotificationChannel(notificationChannel);

            }
    }
}

