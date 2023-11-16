package com.khaiminh.assignment1vokhaiminh.Controllers.ExerciseScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.khaiminh.assignment1vokhaiminh.Models.Exercise;
import com.khaiminh.assignment1vokhaiminh.R;
import com.khaiminh.assignment1vokhaiminh.Utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

public class ExerciseScreenActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ExerciseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_screen);

        // Enable the back button in the ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
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
        adapter = new ExerciseAdapter(filteredExercises);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks
        int id = item.getItemId();

        // If the back button is pressed, navigate back
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}