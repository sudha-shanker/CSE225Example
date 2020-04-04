package com.example.cse225_android;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressBarExample extends AppCompatActivity {
    private int i = 0;
    private Handler hdlr = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_example);
        final ProgressBar pgsBar = findViewById(R.id.pBar);
        final ProgressBar pgsBar1 = findViewById(R.id.pBarCircular);
        final TextView txtView = findViewById(R.id.tView);
        Button btn = findViewById(R.id.btnShow);
        Button btn1 = findViewById(R.id.btnReset);
        pgsBar1.setVisibility(View.INVISIBLE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pgsBar1.setVisibility(View.VISIBLE);
                i = pgsBar.getProgress();
                new Thread(new Runnable() {
                    public void run() {
                        while (i < 100) {
                            i += 1;
                            // Update the progress bar and display the current value in text view
                            hdlr.post(new Runnable() {
                                public void run() {
                                    pgsBar.setProgress(i);
                                    txtView.setText(i+"/"+pgsBar.getMax());
                                    if(i==100){
                                        pgsBar1.setVisibility(View.INVISIBLE);
                                    }
                                }
                            });
                            try {
                                // Sleep for 100 milliseconds to show the progress slowly.
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pgsBar.setProgress(0);
                txtView.setText(0+"/"+pgsBar.getMax());
            }
        });

    }


}
