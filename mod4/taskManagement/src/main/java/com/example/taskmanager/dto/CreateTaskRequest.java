package com.example.taskmanager.dto;

public class CreateTaskRequest {
    private String title;
    private String description;
    private boolean completed;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public boolean isCompleted() { return completed; }
}