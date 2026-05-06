package com.fourimpact.taskManager.controller;
import com.fourimpact.taskManager.entity.*;
import com.fourimpact.taskManager.service.CategoryService;
import com.fourimpact.taskManager.service.TagService;
import com.fourimpact.taskManager.service.TaskService;
import com.fourimpact.taskManager.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/tasks")
public class TaskWebController {
    private final TaskService taskService;
    private final UserService userService;
    private final CategoryService CategoryService;
    private final TagService tagService;


    public TaskWebController(TaskService taskService, UserService userService, TagService tagService, CategoryService categoryService) {
        this.taskService = taskService;
        this.userService = userService;
        this.CategoryService = categoryService;
        this.tagService = tagService;
    }

    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("task", taskService.getAllTasks());
        model.addAttribute("pageTitle", "All Tasks");
        return "tasks/list";
    }

    @GetMapping("/new")
    public String newTaskForm(Model model) {
        model.addAttribute("categories", CategoryService.getAllCategories());
        model.addAttribute("task", new Task());
        model.addAttribute("status", Status.values());
        model.addAttribute("priority", Priority.values());
        model.addAttribute("pageTitle", "New Task");
        return "tasks/form";
    }

    @PostMapping
    public String createTask(@Valid @ModelAttribute Task task,
                             @RequestParam(required = false) String newCategoryName, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", CategoryService.getAllCategories());
            model.addAttribute("statuses", Status.values());
            model.addAttribute("priority", Priority.values());
            model.addAttribute("pageTitle", "New Task");
            return "tasks/form";
        }
        if (newCategoryName != null && !newCategoryName.isBlank()) {
            Category category = new Category();
            category.setName(newCategoryName);
            CategoryService.save(category);
            task.setCategory(category);
        }
        taskService.save(task);
        return "redirect:/tasks";
    }

    @PostMapping("/{id}")
    public String updateTask(@PathVariable Long id,
                             @Valid @ModelAttribute Task task,
                             @RequestParam(required = false) String newCategoryName,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            model.addAttribute("statuses", Status.values());
            model.addAttribute("priority", Priority.values());
            model.addAttribute("pageTitle", "Edit Task");
            return "tasks/form";
        }
        if (newCategoryName != null && !newCategoryName.isBlank()) {
            Category category = new Category();
            category.setName(newCategoryName);
            CategoryService.save(category);
            task.setCategory(category);
        }

        if (task.getUser() != null) {
            userService.saveUser(task.getUser());
        }

        task.setId(id);
        userService.saveUser(task.getUser());
        taskService.save(task);
        return "redirect:/tasks";
    }

    @PostMapping("/{id}/del")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }

    @PatchMapping("/{id}/complete")
    @ResponseBody
    public ResponseEntity<Void> markComplete(@PathVariable Long id) {
        taskService.markCompleteTask(id);
        return ResponseEntity.ok().build();
    }

}



