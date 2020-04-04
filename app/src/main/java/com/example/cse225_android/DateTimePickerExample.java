package com.example.cse225_android;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class DateTimePickerExample extends AppCompatActivity implements
        View.OnClickListener{

    Button btnDatePicker, btnTimePicker;
    EditText txtDate, txtTime, editText;
    private int mYear, mMonth, mDay, mHour, mMinute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_picker_example);

        btnDatePicker= findViewById(R.id.btn_date);
        btnTimePicker= findViewById(R.id.btn_time);
        txtDate= findViewById(R.id.in_date);
        txtTime= findViewById(R.id.in_time);
        editText= findViewById(R.id.Birthday);

        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();


        }

        if (v == btnTimePicker) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {
                            String AM_PM ;
                            if(hourOfDay < 12) {
                                AM_PM = "AM";
                            } else {
                                AM_PM = "PM";
                            }
                            if(AM_PM=="PM")
                                hourOfDay = hourOfDay - 12;
                            if(hourOfDay==0)
                                hourOfDay=hourOfDay+12;
                            if(minute<10)
                                txtTime.setText(hourOfDay + ":"+0+ minute + " " +AM_PM);
                            else
                                txtTime.setText(hourOfDay + ":" + minute + " " +AM_PM);

                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }

    }

}