package com.fourimpact.taskManager.dto;

public class UserResponse {
    private Long id;
    private String Username;
    private String email;
    private String firstName;
    private String lastName;
    private String role;

    public UserResponse(Long id, String Username, String email,
                             String firstName, String lastName, String role) {
        this.id = id;
        this.Username = Username;
        this.email = email;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUsername() { return Username; }
    public void setUsername(String Username) { this.Username = Username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
