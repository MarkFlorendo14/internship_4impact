package com.fourimpact.taskManager.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false, length = 100)
    private String title;
    @Column(name = "description", columnDefinition = "NVARCHAR (MAX)")
    private String description;
    @Column(name = "status",  length = 50)
    private String status;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority", length = 100)
    private Priority priority;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "task_tags",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags = new ArrayList<>();

    public void addTags(Tag tag){
        this.tags.add(tag);
        tag.getTasks().add(this);
    }

    public List<Tag> getTags(){
        return tags;
    }

    @Transient
    private String displayLabel;


    //No-arg constructor JPA required
    public Task(){ }
        public Task (String title,String description, String status, Priority priority){
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        }

    public Long getId()                  { return id; }
    public String getTitle()             { return title; }
    public void setTitle(String t)       { this.title = t; }
    public String getDescription()       { return description; }
    public void setDescription(String d) { this.description = d; }
    public String getStatus()            { return status; }
    public void setStatus(String s)      { this.status = s; }
    public Priority getPriority()          { return priority; }
    public void setPriority(Priority priority)    { this.priority = priority; }
    public LocalDateTime getCreatedAt()  { return createdAt; }
    public Category getCategory()          { return category; }
    public void setCategory(Category category) { this.category = category; }
    public User getUser()             { return user; }
    public void setUser(User user) { this.user = user; }

    @Override
    public String toString() {
        return "Task{id=" + id + ", title='" + title + "', status='" + status + "'}";
    }
}
