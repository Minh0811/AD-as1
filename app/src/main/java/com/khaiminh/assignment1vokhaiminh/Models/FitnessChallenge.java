package com.khaiminh.assignment1vokhaiminh.Models;

public class FitnessChallenge {
    private int id;
    private String name;
    private String description;
    private int duration; // in days
    private String challengeType;

    // Constructor
    public FitnessChallenge(int id, String name, String description, int duration, String challengeType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.challengeType = challengeType;
    }

    // Getters and setters
    // ...
}