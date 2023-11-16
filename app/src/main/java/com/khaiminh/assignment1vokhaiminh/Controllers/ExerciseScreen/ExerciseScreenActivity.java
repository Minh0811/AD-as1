package com.khaiminh.assignment1vokhaiminh.Controllers.ExerciseScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.khaiminh.assignment1vokhaiminh.R;

public class ExerciseScreenActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ExerciseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_screen);

// Initialize RecyclerView and Adapter
        recyclerView = findViewById(R.id.recyclerViewExercises); // Replace with your RecyclerView ID
        adapter = new ExerciseAdapter(/* your exercises list */);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Get the Intent that started this activity and extract the fitnessChallengeId
        Intent intent = getIntent();
        int fitnessChallengeId = intent.getIntExtra("fitnessChallengeId", -1);
        Log.d("ExerciseScreenActivity", "Received fitnessChallengeId: " + fitnessChallengeId);
    }
}