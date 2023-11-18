package com.khaiminh.assignment1vokhaiminh.Controllers.MealPlanScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.khaiminh.assignment1vokhaiminh.Models.MealPlan;
import com.khaiminh.assignment1vokhaiminh.R;
import com.khaiminh.assignment1vokhaiminh.Utils.JsonUtils;

import java.util.List;
import java.util.stream.Collectors;

public class MealPlanActivity extends AppCompatActivity {

    private EditText editTextWeight;
    private EditText editTextHeight;
    private Button buttonCalculate;
    private TextView textViewBmiResult;
    private RecyclerView recyclerViewMealPlans;
    private MealPlanAdapter mealPlanAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_plan);

        ImageButton btnBackToExercise = findViewById(R.id.btnBackToExercise);
        btnBackToExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the current activity
                finish();
            }
        });

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

        recyclerViewMealPlans = findViewById(R.id.recyclerViewMealPlans);
        recyclerViewMealPlans.setLayoutManager(new LinearLayoutManager(this));
    }

    private void calculateBMI() {
        String weightStr = editTextWeight.getText().toString();
        String heightStr = editTextHeight.getText().toString();

        if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
            float weight = Float.parseFloat(weightStr);
            float height = Float.parseFloat(heightStr) / 100; // Convert cm to meters

            float bmi = weight / (height * height);
            textViewBmiResult.setText("Your BMI: " + bmi);

            // Load and filter meal plans
            displayMealPlansForBMI(bmi);
        }
    }

    private void displayMealPlansForBMI(float bmi) {
        String json = JsonUtils.loadJSONFromAsset(this, "meal_plans.json");
        List<MealPlan> mealPlans = JsonUtils.parseMealPlans(json);
        List<MealPlan> filteredMealPlans = mealPlans.stream()
                .filter(mealPlan -> bmi >= mealPlan.getMinBmi() && bmi <= mealPlan.getMaxBmi())
                .collect(Collectors.toList());

        mealPlanAdapter = new MealPlanAdapter(filteredMealPlans);
        recyclerViewMealPlans.setAdapter(mealPlanAdapter);
    }
}
