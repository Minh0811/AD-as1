package com.khaiminh.assignment1vokhaiminh.Models;

public class MealPlan {
    private int id;
    private String name;
    private String description;
    private int calories;
    private int protein;
    private int carbs;
    private int fats;
    private float minBmi;
    private float maxBmi;

    // Constructor
    public MealPlan(int id, String name, String description, int calories, int protein, int carbs, int fats, float minBmi, float maxBmi) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
        this.minBmi = minBmi;
        this.maxBmi = maxBmi;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public int getProtein() {
        return protein;
    }

    public int getCarbs() {
        return carbs;
    }

    public int getFats() {
        return fats;
    }

    public float getMinBmi() {
        return minBmi;
    }

    public float getMaxBmi() {
        return maxBmi;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public void setMinBmi(float minBmi) {
        this.minBmi = minBmi;
    }

    public void setMaxBmi(float maxBmi) {
        this.maxBmi = maxBmi;
    }
}
