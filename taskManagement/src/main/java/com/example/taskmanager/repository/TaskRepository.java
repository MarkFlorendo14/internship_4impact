package com.example.taskmanager.repository;
import com.example.taskmanager.model.TaskModel;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class TaskRepository {
    private final Map<Integer, TaskModel> tasks = new HashMap<>();
    private int nextId = 1;

    public List<TaskModel> findAll() {
        return new ArrayList<>(tasks.values());
    }

    public Optional<TaskModel> findById(int id) {
        return Optional.ofNullable(tasks.get(id));
    }

    public TaskModel save(TaskModel task) {
        if (task.getId() == 0) {
            task.setId(nextId++);
        }
        tasks.put(task.getId(), task);
        return task;
    }
    public boolean deleteById(int id) {
        return tasks.remove(id) != null;
    }
}


