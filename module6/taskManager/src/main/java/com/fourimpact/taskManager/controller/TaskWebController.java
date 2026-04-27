package com.fourimpact.taskManager.controller;
import com.fourimpact.taskManager.entity.Task;
import com.fourimpact.taskManager.service.TaskService;
import com.fourimpact.taskManager.entity.Priority;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class TaskWebController {
    private final TaskService taskService;

    public TaskWebController(TaskService taskService) {
        this.taskService = taskService;
    }

        @GetMapping("/")
        public String home(Model model) {
            model.addAttribute("tasks", taskService.getAllTasks());
            return "index";
        }


    @GetMapping("/tasks/list")
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        model.addAttribute("pageTitle", "All Tasks");
        return "tasks/list";   // resolves to templates/tasks/list.html
    }

    @GetMapping("/tasks/form")
    public String newTaskForm(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("priority", Priority.values());
        model.addAttribute("pageTitle", "New Task");
        return "tasks/form";   // resolves to templates/tasks/list.html
    }

    @PostMapping("/tasks")
    public String createTask(@Valid @ModelAttribute("task") Task task, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "tasks/form";
        }
        taskService.saveTask(task);
        return "redirect:/tasks/list";
    }

    //Get tasks by ID
    @GetMapping("/tasks/detail/{id}")
    public String viewTask(@PathVariable Long id, Model model) {
        model.addAttribute("task", taskService.getTaskById(id));
        return "tasks/detail";

    }
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        model.addAttribute("todoCount", taskService.countByStatus("To-Do"));
        model.addAttribute("inProgressCount", taskService.countByStatus("In Progress"));
        model.addAttribute("doneCount", taskService.countByStatus("Done"));
        model.addAttribute("priorities", Priority.values());
        return "dashboard";

    }
}



