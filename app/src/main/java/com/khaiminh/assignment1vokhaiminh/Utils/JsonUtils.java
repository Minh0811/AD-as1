package com.khaiminh.assignment1vokhaiminh.Utils;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.khaiminh.assignment1vokhaiminh.Models.FitnessChallenge;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

// JsonUtils.java
public class JsonUtils {

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

    public static List<FitnessChallenge> parseFitnessChallenges(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<FitnessChallenge>>(){}.getType();
        return gson.fromJson(json, type);
    }
}
