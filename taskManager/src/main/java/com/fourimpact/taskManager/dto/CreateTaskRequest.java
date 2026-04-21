package com.fourimpact.taskManager.dto;

public class CreateTaskRequest {
    private Long userId;
    private Long categoryId;
    private String title;
    private String description;
    private String status; /* Can be ongoing, to do, and done*/
    private String priority; /* Can be low, medium and high */

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }
    public String getTitle() { return title; }
    public void setTitle(String t) { this.title = t; }
    public String getDescription() { return description; }
    public void setDescription(String d) { this.description = d; }
    public String getStatus() { return status; }
    public void setStatus(String s) { this.status = s; }
    public String getPriority() { return priority; }
    public void setPriority(String p) { this.priority = p; }
}
