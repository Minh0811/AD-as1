package com.khaiminh.assignment1vokhaiminh.Utils;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.khaiminh.assignment1vokhaiminh.Models.Exercise;
import com.khaiminh.assignment1vokhaiminh.Models.FitnessChallenge;
import com.khaiminh.assignment1vokhaiminh.Models.MealPlan;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

// Utility class for JSON operations
public class JsonUtils {

    // Loads JSON data from a file in the assets folder
    public static String loadJSONFromAsset(Context context, String fileName) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(fileName);
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

    // Parses a JSON string into a list of FitnessChallenge objects
    public static List<FitnessChallenge> parseFitnessChallenges(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<FitnessChallenge>>(){}.getType();
        return gson.fromJson(json, type);
    }

    // Parses a JSON string into a list of Exercise objects
    public static List<Exercise> parseExercises(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Exercise>>(){}.getType();
        return gson.fromJson(json, type);
    }

    // Parses a JSON string into a list of MealPlan objects
    public static List<MealPlan> parseMealPlans(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<MealPlan>>(){}.getType();
        return gson.fromJson(json, type);
    }
}

