package com.khaiminh.assignment1vokhaiminh.Models;

//Fields might include id, name, description, videoUrl, fitnessChallengeId
public class Exercise {
    private int id;
    private String name;
    private String description;
    private String videoUrl;
    private int fitnessChallengeId;

    public Exercise(int id, String name, String description, String videoUrl, int fitnessChallengeId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.videoUrl = videoUrl;
        this.fitnessChallengeId = fitnessChallengeId;
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
}
