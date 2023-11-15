package com.khaiminh.assignment1vokhaiminh;

import com.khaiminh.assignment1vokhaiminh.Models.FitnessChallenge;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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

        // Initialize your fitnessChallenges list here
        // ...

        adapter = new FitnessChallengeAdapter(fitnessChallenges);
        recyclerView.setAdapter(adapter);
    }
}
