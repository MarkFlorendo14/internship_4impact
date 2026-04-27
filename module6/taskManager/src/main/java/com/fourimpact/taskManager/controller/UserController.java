package com.fourimpact.taskManager.controller;
import com.fourimpact.taskManager.dto.CreateUserRequest;
import com.fourimpact.taskManager.dto.UserResponse;
import com.fourimpact.taskManager.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(request));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getUser() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
