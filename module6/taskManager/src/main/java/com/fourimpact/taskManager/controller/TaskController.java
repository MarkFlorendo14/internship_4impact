package com.fourimpact.taskManager.controller;

import com.fourimpact.taskManager.dto.CreateTaskRequest;
import com.fourimpact.taskManager.dto.TaskResponse;
import com.fourimpact.taskManager.service.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    //CREATE
    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@RequestBody CreateTaskRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(request));
    }

    @PostMapping("/{taskId}/tags/{tagId}")
    public ResponseEntity<TaskResponse> addTagToTask(@PathVariable Long taskId,
                                                     @PathVariable Long tagId) {
        return ResponseEntity.ok(taskService.addTagToTask(taskId, tagId));
    }

    //READ
    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<TaskResponse>> getTaskPaginated(
            @RequestParam Long id,
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "desc") String direction) {
        return ResponseEntity.ok(taskService.getTasksPaged(id, page, size, sortBy, direction));
    }

    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTask(@PathVariable Long id,
                                                   @RequestBody CreateTaskRequest request) {
        return ResponseEntity.ok(taskService.updateTask(id, request));
    }
    @PatchMapping("/{id}/complete")
    public ResponseEntity<Void> markComplete(@PathVariable Long id) {
        taskService.markCompleteTask(id); //Sets task.status to "COMPLETE"
        return ResponseEntity.ok().build();
    }

    //DELETE
    @DeleteMapping("/{id}")

    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

}


