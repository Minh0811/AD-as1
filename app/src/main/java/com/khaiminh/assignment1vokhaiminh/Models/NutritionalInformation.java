package com.khaiminh.assignment1vokhaiminh.Models;
//mealPlanId, calories, protein, carbs, fats.
public class NutritionalInformation {
    private int mealPlanId;
    private int calories;
    private int protein;
    private int carbs;
    private int fats;

    // Constructor
    public NutritionalInformation(int mealPlanId, int calories, int protein, int carbs, int fats) {
        this.mealPlanId = mealPlanId;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
    }
}
