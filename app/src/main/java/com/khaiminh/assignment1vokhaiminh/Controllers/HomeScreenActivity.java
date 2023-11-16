package com.khaiminh.assignment1vokhaiminh.Controllers;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.khaiminh.assignment1vokhaiminh.Models.FitnessChallenge;
import com.khaiminh.assignment1vokhaiminh.Controllers.FitnessChallengeAdapter;
import com.khaiminh.assignment1vokhaiminh.R;


public class HomeScreenActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FitnessChallengeAdapter adapter;
    private List<FitnessChallenge> fitnessChallenges;
    private List<FitnessChallenge> filteredChallenges;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        recyclerView = findViewById(R.id.recyclerViewFitnessChallenges);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String json = loadJSONFromAsset();
        fitnessChallenges = parseFitnessChallenges(json);
        filteredChallenges = new ArrayList<>(fitnessChallenges);

        adapter = new FitnessChallengeAdapter(filteredChallenges);
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



    private String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("fitness_challenges.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
    private List<FitnessChallenge> parseFitnessChallenges(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<FitnessChallenge>>(){}.getType();
        return gson.fromJson(json, type);
    }
    private int getImageResId(String imageName) {
        return getResources().getIdentifier(imageName, "drawable", getPackageName());
    }

}
