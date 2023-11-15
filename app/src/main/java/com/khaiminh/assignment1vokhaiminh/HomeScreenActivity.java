package com.khaiminh.assignment1vokhaiminh;

import com.khaiminh.assignment1vokhaiminh.Models.FitnessChallenge;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList; // Import ArrayList
import java.util.List;

public class HomeScreenActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FitnessChallengeAdapter adapter;
    private List<FitnessChallenge> fitnessChallenges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        recyclerView = findViewById(R.id.recyclerViewFitnessChallenges);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize and populate the fitnessChallenges list
        fitnessChallenges = new ArrayList<>();
        // Add some sample data to the list
        fitnessChallenges.add(new FitnessChallenge(1, "Challenge 1", "Description 1", 30, "Type 1"));
        fitnessChallenges.add(new FitnessChallenge(2, "Challenge 2", "Description 2", 45, "Type 2"));
        fitnessChallenges.add(new FitnessChallenge(3, "Challenge 3", "Description 3", 60, "Type 3"));
        // ... Add as many challenges as you want

        adapter = new FitnessChallengeAdapter(fitnessChallenges);
        recyclerView.setAdapter(adapter);
    }
}
