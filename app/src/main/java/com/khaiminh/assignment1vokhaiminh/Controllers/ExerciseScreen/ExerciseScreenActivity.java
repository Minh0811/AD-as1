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

public class ExerciseScreenActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ExerciseAdapter adapter;
    private ViewPager2 viewPagerImageSlider;
    private ImageSliderAdapter sliderAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_screen);

        ImageButton btnBackToHome = findViewById(R.id.btnBackToHome);
        btnBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the current activity
                finish();
            }
        });
        // Set up the toolbar
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Exercise");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
        // Enable the back button in the ActionBar
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        }
        // Get the Intent that started this activity and extract the fitnessChallengeId
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

        // Initialize RecyclerView and Adapter
        recyclerView = findViewById(R.id.recyclerViewExercises);
        adapter = new ExerciseAdapter(filteredExercises, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Initialize ViewPager2 and Adapter
        viewPagerImageSlider = findViewById(R.id.viewPagerImageSlider);
        sliderAdapter = new ImageSliderAdapter(this, filteredExercises);
        viewPagerImageSlider.setAdapter(sliderAdapter);

        // Button to go to Meal Plan
        Button btnToMealPlan = findViewById(R.id.btnToMealPlan);
        btnToMealPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExerciseScreenActivity.this, MealPlanActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}