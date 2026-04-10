package com.example.taskmanager.controller;
import com.example.taskmanager.dto.CreateTaskRequest;
import com.example.taskmanager.dto.UpdateTask;
import com.example.taskmanager.exception.TaskNotFoundException;
import com.example.taskmanager.model.TaskModel;
import com.example.taskmanager.service.TaskService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskModel> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable int id) {
        Optional<TaskModel> task = taskService.getTaskById(id);
        if (task.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of("Error", "Task not Found with ID: " + id));
        }
        return ResponseEntity.ok(task.get());
    }

    @PostMapping
    public ResponseEntity<TaskModel> createTask(@RequestBody CreateTaskRequest request) {
        TaskModel created = taskService.createTask(request.getTitle(), request.getDescription(), request.isCompleted());
        return ResponseEntity.status(201).body(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable int id) {
        boolean deleted = taskService.deleteTask(id);
        if (!deleted) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskModel> taskUpdate(
            @PathVariable int id,
            @RequestBody UpdateTask update) {
        Optional<TaskModel> updated = taskService.updateTask(id, update.getTitle(), update.getDescription());

        if (updated.isPresent()) {
            return ResponseEntity.ok(updated.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleTaskNotFound(TaskNotFoundException ex) {
        return Map.of("error", ex.getMessage());
    }
}