package com.khaiminh.assignment1vokhaiminh.Models;
//Fields might include id, name, description, fitnessChallengeId.
public class MealPlan {
    private int id;
    private String name;
    private String description;
    private int calories;
    private int protein;
    private int carbs;
    private int fats;



    // Constructor
    public MealPlan(int id, String name, String description, int calories, int protein, int carbs, int fats) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
    }

}
