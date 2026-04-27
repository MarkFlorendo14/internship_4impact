package com.fourimpact.taskManager.dto;
import com.fourimpact.taskManager.entity.Priority;


public class CreateTaskRequest {
    private Long userId;
    private Long categoryId;
    private String title;
    private String description;
    private String status; /* Can be ongoing, to do, and done*/
    private Priority priority; /* Can be low, medium and high */
    private String tag;

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
    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }
    public String getTag() { return tag; }
    public void setTag(String t) { this.tag = t; }
}
