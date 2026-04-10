package com.example.taskmanager.exception;

public class TaskNotFoundException extends Exception {
    public TaskNotFoundException(int id) {
        super("Task not found with ID:  " + id);
    }
}
