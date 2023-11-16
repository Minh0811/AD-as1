package com.khaiminh.assignment1vokhaiminh.Models;

import java.util.List;

public class Exercise {
    private int id;
    private String name;
    private String description;
    private String videoUrl;
    private int fitnessChallengeId;
    private List<String> imageNames; // List of image names

    // Constructor
    public Exercise(int id, String name, String description, String videoUrl, int fitnessChallengeId, List<String> imageNames) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.videoUrl = videoUrl;
        this.fitnessChallengeId = fitnessChallengeId;
        this.imageNames = imageNames; // Initialize the list of image names
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
    public String getVideoUrl() {
        return videoUrl;
    }
    public int getFitnessChallengeId() {
        return fitnessChallengeId;
    }
    public List<String> getImageNames() { // Getter for the list of image names
        return imageNames;
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
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
    public void setFitnessChallengeId(int fitnessChallengeId) {
        this.fitnessChallengeId = fitnessChallengeId;
    }
    public void setImageNames(List<String> imageNames) { // Setter for the list of image names
        this.imageNames = imageNames;
    }
}
