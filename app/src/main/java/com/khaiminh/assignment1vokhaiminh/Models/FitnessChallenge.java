package com.khaiminh.assignment1vokhaiminh.Models;

public class FitnessChallenge {
    private int id;
    private String name;
    private String description;
    private int duration; // in days
    private String challengeType;
    private String imageName;
    private int difficulty;

    // Constructor
    public FitnessChallenge(int id, String name, String description, int duration, String challengeType, String imageName, int difficulty) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.challengeType = challengeType;
        this.imageName = imageName;
        this.difficulty = difficulty;
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
    public String getImageName() {
        return imageName;
    }
    public int getDifficulty() {
        return difficulty;
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
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}