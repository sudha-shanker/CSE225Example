package com.example.cse225_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class RatingBarExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar_example);
        final RatingBar simpleRatingBar = findViewById(R.id.simpleRatingBar);
        RatingBar simpleRating = findViewById(R.id.simpleRating);
        Button submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String totalStars = "Total Stars:: " + simpleRatingBar.getNumStars();
                String rating = "Rating :: " + simpleRatingBar.getRating();
                Toast.makeText(getApplicationContext(), totalStars + "\n" + rating, Toast.LENGTH_LONG).show();
            }
        });

        simpleRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(RatingBarExample.this, "rating" + rating, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
