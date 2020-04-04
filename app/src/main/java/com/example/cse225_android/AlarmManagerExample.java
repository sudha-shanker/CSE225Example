package com.example.cse225_android;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AlarmManagerExample extends AppCompatActivity {

    Button start;
    Button RStart;
    Button cancel;
    EditText text;
    int i;
    Intent intent;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_intent_example);
        start = findViewById(R.id.button);
        RStart = findViewById(R.id.RStart);
        cancel = findViewById(R.id.cancel_button);
        text = findViewById(R.id.time);

        intent = new Intent(AlarmManagerExample.this,
                AlarmManagerBroadcast.class);
        pendingIntent = PendingIntent.getBroadcast
                (AlarmManagerExample.this,234,intent,0 );

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = Integer.parseInt(text.getText().toString());
                alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP,
                        System.currentTimeMillis()
                        + (i * 1000), pendingIntent);
                Toast.makeText(AlarmManagerExample.this,
                        "Alarm set in " + i + " seconds",Toast.LENGTH_LONG).show();
            }
        });
        RStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.setRepeating
                        (AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),
                                (1000*5),pendingIntent);
                Toast.makeText(AlarmManagerExample.this,
                        "Repeating Alarm 5 Seconds",Toast.LENGTH_LONG).show();


            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmManager.cancel(pendingIntent);
                Toast.makeText(AlarmManagerExample.this,
                        "Alarm Cancelled", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
