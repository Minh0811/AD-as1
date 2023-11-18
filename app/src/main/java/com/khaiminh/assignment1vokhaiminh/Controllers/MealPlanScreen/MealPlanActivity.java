package com.khaiminh.assignment1vokhaiminh.Controllers.MealPlanScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.khaiminh.assignment1vokhaiminh.R;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MealPlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_plan);

        ImageButton btnBackToExercise = findViewById(R.id.btnBackToExercise);
        btnBackToExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Your click handling code
            }
        });

    }
}