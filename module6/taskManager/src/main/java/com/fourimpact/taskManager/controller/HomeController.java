package com.fourimpact.taskManager.controller;
import com.fourimpact.taskManager.entity.Priority;
import com.fourimpact.taskManager.entity.Status;
import com.fourimpact.taskManager.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController {
    private final TaskService taskService;

    public HomeController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Hello, Thymeleaf!");
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("titlePage", "Dashboard");
        model.addAttribute("task", taskService.getAllTasks());
        model.addAttribute("todoCount", taskService.countByStatus(Status.TODO));
        model.addAttribute("inProgressCount", taskService.countByStatus(Status.ONGOING));
        model.addAttribute("doneCount", taskService.countByStatus(Status.COMPLETED));
        model.addAttribute("priority", Priority.values());
        return "dashboard";

    }
}