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

    @Column(name = "Username", nullable = false, length = 40)
    private String username;

    @Column(name = "fname", nullable = false, length = 50)
    private String firstName;

    @Column(name = "lname", nullable = false, length = 50)
    private String lastName;

    @Column(name = "role", nullable = false, unique = false, length = 20)
    private String role;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Task> tasks = new ArrayList<>();


    //Constructor - no args
    public User() {}
    public User(String Username, String email, String firstName, String lastName, String role) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    //Getters and Setters
    public void setId(Long id){ this.id = id;}
    public Long getId(){ return id; }
    public void setUsername(String u){ this.username = u;}
    public String getUsername(){ return username; }
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
