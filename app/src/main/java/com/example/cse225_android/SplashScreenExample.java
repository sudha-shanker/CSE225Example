package com.example.cse225_android;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenExample extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_example);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreenExample.this, SplashScreenExampleMain.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
