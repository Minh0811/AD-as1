package com.khaiminh.assignment1vokhaiminh.Controllers.HomeScreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.khaiminh.assignment1vokhaiminh.Controllers.ExerciseScreen.ExerciseScreenActivity;
import com.khaiminh.assignment1vokhaiminh.Models.FitnessChallenge;
import com.khaiminh.assignment1vokhaiminh.R;
import com.khaiminh.assignment1vokhaiminh.Utils.JsonUtils;


public class HomeScreenActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FitnessChallengeAdapter adapter;
    private List<FitnessChallenge> fitnessChallenges;
    private List<FitnessChallenge> filteredChallenges;
    private SearchView searchView;
    private Spinner sortingSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        SearchView searchView = findViewById(R.id.searchView);
        searchView.setIconifiedByDefault(false); // This will expand the SearchView
        searchView.setQueryHint("Search here..."); // Optional: Set a hint for the search input


        recyclerView = findViewById(R.id.recyclerViewFitnessChallenges);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Use JsonUtils to load and parse the JSON
        String json = JsonUtils.loadJSONFromAsset(this, "fitness_challenges.json");
        fitnessChallenges = JsonUtils.parseFitnessChallenges(json);
        filteredChallenges = new ArrayList<>(fitnessChallenges);
        FitnessChallengeAdapter.OnItemClickListener itemClickListener = new FitnessChallengeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int fitnessChallengeId) {
                Intent intent = new Intent(HomeScreenActivity.this, ExerciseScreenActivity.class);
                intent.putExtra("fitnessChallengeId", fitnessChallengeId);
                startActivity(intent);
            }
        };

        adapter = new FitnessChallengeAdapter(fitnessChallenges, itemClickListener);
        recyclerView.setAdapter(adapter);

        searchView = findViewById(R.id.searchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterChallenges(newText);
                return true;
            }
        });

        sortingSpinner = findViewById(R.id.sortingSpinner);
        sortingSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    // No Sorting
                    adapter.updateFitnessChallenges(fitnessChallenges);
                } else {
                    // Sort based on the selected option
                    sortFitnessChallenges(position == 1); // 1 for Ascending, 2 for Descending
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // This method is required but can be left empty
            }
        });
    }


    private void filterChallenges(String text) {
        List<FitnessChallenge> filteredList = new ArrayList<>();
        if (text.isEmpty()) {
            filteredList.addAll(fitnessChallenges);
        } else {
            for (FitnessChallenge challenge : fitnessChallenges) {
                if (challenge.getName().toLowerCase().contains(text.toLowerCase())) {
                    filteredList.add(challenge);
                }
            }
        }
        adapter.updateFitnessChallenges(filteredList);
    }

    private void sortFitnessChallenges(boolean ascending) {
        if (ascending) {
            Collections.sort(filteredChallenges, (o1, o2) -> Integer.compare(o1.getDifficulty(), o2.getDifficulty()));
        } else {
            Collections.sort(filteredChallenges, (o1, o2) -> Integer.compare(o2.getDifficulty(), o1.getDifficulty()));
        }
        adapter.updateFitnessChallenges(filteredChallenges);
    }
}
