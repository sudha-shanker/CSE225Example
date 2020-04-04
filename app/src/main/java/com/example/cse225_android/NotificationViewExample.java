package com.example.cse225_android;


import android.app.NotificationManager;

import android.support.v4.app.RemoteInput;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NotificationViewExample extends AppCompatActivity {

    TextView tv;
    NotificationManager nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_view_example);

        tv = findViewById(R.id.tv);


        Bundle b1= RemoteInput.getResultsFromIntent(getIntent());
        if(b1 != null)
        {
            tv.setText(b1.getString(NotificationExample.myKey));
        }

        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        nm.cancel(NotificationExample.notification_ID);
    }
}
