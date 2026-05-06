package com.fourimpact.taskManager.dto;
import com.fourimpact.taskManager.entity.Priority;
import com.fourimpact.taskManager.entity.Status;


public class CreateTaskRequest {
    private Long userId;
    private String title;
    private Long CategoryId;
    private String description;
    private Status status; /* Can be ongoing, to do, and done*/
    private Priority priority; /* Can be low, medium and high */
    private String tag;

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String t) {
        this.title = t;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String d) {
        this.description = d;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status s) {
        this.status = s;
    }
    public Priority getPriority() {
        return priority;
    }
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String t) {
        this.tag = t;
    }
    public Long getCategoryId() {
        return CategoryId;
    }
    public void setCategoryId(Long c) {
        this.CategoryId = c;
    }
}
