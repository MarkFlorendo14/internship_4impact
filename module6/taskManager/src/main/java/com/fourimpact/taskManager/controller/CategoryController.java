package com.fourimpact.taskManager.controller;

import com.fourimpact.taskManager.dto.CategoryResponse;
import com.fourimpact.taskManager.dto.CreateCategoryRequest;
import com.fourimpact.taskManager.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @PostMapping
    public ResponseEntity <CategoryResponse> createCategory(@RequestBody CreateCategoryRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(request));
    }

    @PutMapping("{id}")
    public ResponseEntity <CategoryResponse> updateTag(@PathVariable long id, @RequestBody CreateCategoryRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.updateCategory(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <CategoryResponse> deleteTag(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
