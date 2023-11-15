package com.khaiminh.assignment1vokhaiminh.Models;
//Fields might include id, name, description, fitnessChallengeId.
public class MealPlan {
    private int id;
    private String name;
    private String description;
    private int fitnessChallengeId;

    // Constructor
    public MealPlan(int id, String name, String description, int fitnessChallengeId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.fitnessChallengeId = fitnessChallengeId;
    }

}
