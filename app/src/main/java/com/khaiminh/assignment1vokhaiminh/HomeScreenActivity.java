package com.khaiminh.assignment1vokhaiminh;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.io.IOException;
import java.io.InputStream;
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

        String json = loadJSONFromAsset();
        List<FitnessChallenge> fitnessChallenges = parseFitnessChallenges(json);

        adapter = new FitnessChallengeAdapter(fitnessChallenges);
        recyclerView.setAdapter(adapter);
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

}
