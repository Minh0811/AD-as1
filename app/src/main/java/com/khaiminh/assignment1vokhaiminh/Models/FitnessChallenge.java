package com.khaiminh.assignment1vokhaiminh.Models;

public class FitnessChallenge {
    private int id;
    private String name;
    private String description;
    private int duration; // in days
    private String challengeType;
    private int imageResId;

    // Constructor
    public FitnessChallenge(int id, String name, String description, int duration, String challengeType, int imageResId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.challengeType = challengeType;
        this.imageResId = imageResId;
    }

    // Getters and setters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getDuration() {
        return duration;
    }
    public String getChallengeType() {
        return challengeType;
    }
    public int getImageResId() {
        return imageResId;
    }


    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setChallengeType(String challengeType) {
        this.challengeType = challengeType;
    }
    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
}