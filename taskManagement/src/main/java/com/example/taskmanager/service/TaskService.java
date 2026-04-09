package com.example.taskmanager.service;
import com.example.taskmanager.model.TaskModel;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskrepo;

    public TaskService (TaskRepository taskrepo){
        this.taskrepo = taskrepo;
    }

    public List<TaskModel> getAllTasks() {
        return taskrepo.findAll();
    }

    public Optional<TaskModel> getTaskById(int id) {
        return taskrepo.findById(id);
    }

    public Optional<TaskModel> updateTask(int id, String title, String description){
        Optional<TaskModel> existing = taskrepo.findById(id);

        if (existing.isPresent()) {
            TaskModel task = existing.get();
            task.setTitle(title);
            task.setDescription(description);
            return Optional.of(taskrepo.save(task));
        }
        return Optional.empty();
    }

    /// This is a test comment
    /// @param title Test
    public TaskModel createTask(String title, String description, boolean completed) {
        TaskModel task = new TaskModel(0, title, description, true);
        return taskrepo.save(task);
    }

    public boolean deleteTask(int id) {
        return taskrepo.deleteById(id);
    }
}
