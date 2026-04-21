package com.fourimpact.taskManager.entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (unique = true, nullable = false, length = 50)
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Task> tasks = new ArrayList<>();

    public Tag() {}
    public Tag(String name) {
        this.name = name;
    }
    public Long getId() { return id; }
    public String getName() { return name; }
    public List<Task> getTasks() { return tasks; }
}
