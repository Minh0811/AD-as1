package com.khaiminh.assignment1vokhaiminh.Controllers.ExerciseScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.khaiminh.assignment1vokhaiminh.Controllers.MealPlanScreen.MealPlanActivity;
import com.khaiminh.assignment1vokhaiminh.Models.Exercise;
import com.khaiminh.assignment1vokhaiminh.R;
import com.khaiminh.assignment1vokhaiminh.Utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

// Activity class for Exercise Screen
public class ExerciseScreenActivity extends AppCompatActivity {
    private RecyclerView recyclerView; // RecyclerView for displaying exercises
    private ExerciseAdapter adapter; // Adapter for RecyclerView
    private ViewPager2 viewPagerImageSlider; // ViewPager2 for image slider
    private ImageSliderAdapter sliderAdapter; // Adapter for ViewPager2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_screen);

        // Initialize and set up views and adapters
        ImageButton btnBackToHome = findViewById(R.id.btnBackToHome);
        btnBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
        Intent intent = getIntent();
        int fitnessChallengeId = intent.getIntExtra("fitnessChallengeId", -1);

        // Load and parse exercises
        String exercisesJson = JsonUtils.loadJSONFromAsset(this, "exercises.json");
        List<Exercise> allExercises = JsonUtils.parseExercises(exercisesJson);

        // Filter exercises based on fitnessChallengeId
        List<Exercise> filteredExercises = new ArrayList<>();
        for (Exercise exercise : allExercises) {
            if (exercise.getFitnessChallengeId() == fitnessChallengeId) {
                filteredExercises.add(exercise);
            }
        }

        // Set up RecyclerView with ExerciseAdapter
        recyclerView = findViewById(R.id.recyclerViewExercises);
        adapter = new ExerciseAdapter(filteredExercises, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Set up ViewPager2 with ImageSliderAdapter
        viewPagerImageSlider = findViewById(R.id.viewPagerImageSlider);
        sliderAdapter = new ImageSliderAdapter(this, filteredExercises);
        viewPagerImageSlider.setAdapter(sliderAdapter);

        // Button click listeners and other UI interactions
        Button btnToMealPlan = findViewById(R.id.btnToMealPlan);
        btnToMealPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExerciseScreenActivity.this, MealPlanActivity.class);
                startActivity(intent);
            }
        });
    }
    // Handles options item selected in the ActionBar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}