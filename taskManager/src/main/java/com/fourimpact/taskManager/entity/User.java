package com.fourimpact.taskManager.entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "users")
public class User {
    //Primary key, Increment Generation by MS Sql just leave blank.
    //Column Creation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true, length = 40)
    private String Username;

    @Column(name = "fname", nullable = false, unique = true, length = 50)
    private String firstName;

    @Column(name = "lname", nullable = false, unique = true, length = 50)
    private String lastName;

    @Column(name = "role", nullable = false, unique = true, length = 20)
    private String role;

    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Task> tasks = new ArrayList<>();


    //Constructor - no args
    public User() {}
    public User(String username, String email, String firstName, String lastName, String role, Long id) {
        this.Username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.id = id;

    }

    //Getters and Setters
    public void setId(Long id){ this.id = id;}
    public Long getId(){ return id; }
    public void setUsername(String u){ this.Username = u;}
    public String getUsername(){ return Username; }
    public void setEmail(String e){ this.email = e; }
    public String getEmail(){ return email; }
    public List<Task> getTasks() {return tasks;}
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
