package com.khaiminh.assignment1vokhaiminh.Controllers.MealPlanScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.khaiminh.assignment1vokhaiminh.R;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

// Inside MealPlanActivity.java

import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class MealPlanActivity extends AppCompatActivity {

    private EditText editTextWeight;
    private EditText editTextHeight;
    private Button buttonCalculate;
    private TextView textViewBmiResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_plan);

        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewBmiResult = findViewById(R.id.textViewBmiResult);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightStr = editTextWeight.getText().toString();
        String heightStr = editTextHeight.getText().toString();

        if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
            float weight = Float.parseFloat(weightStr);
            float height = Float.parseFloat(heightStr) / 100; // Convert cm to meters

            float bmi = weight / (height * height);
            textViewBmiResult.setText("Your BMI: " + bmi);
            // Here you can add logic to recommend a meal plan based on the BMI
        }
    }
}
