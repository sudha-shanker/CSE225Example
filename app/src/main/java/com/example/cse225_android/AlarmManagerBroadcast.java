package com.example.cse225_android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class AlarmManagerBroadcast extends BroadcastReceiver {
    MediaPlayer mp;
    @Override
    public void onReceive(Context context, Intent intent) {
        /*Vibrator vibrator =
                (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(2000);*/
        mp=MediaPlayer.create(context, R.raw.alarm);
        mp.start();
        Toast.makeText(context, "Message", Toast.LENGTH_LONG).show();
    }
}
