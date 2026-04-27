package com.fourimpact.taskManager.controller;

import com.fourimpact.taskManager.dto.CreateTagRequest;
import com.fourimpact.taskManager.dto.TagResponse;
import com.fourimpact.taskManager.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController {
    private final TagService tagService;
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public ResponseEntity<List<TagResponse>> getAllTags() {
        return ResponseEntity.ok(tagService.getAllTags());
    }

    @PostMapping
    public ResponseEntity <TagResponse> createTag(@RequestBody CreateTagRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(tagService.createTag(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity <TagResponse> updateTag(@PathVariable long id, @RequestBody CreateTagRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(tagService.updateTag(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <TagResponse> deleteTag(@PathVariable Long id){
        tagService.deleteTag(id);
        return ResponseEntity.noContent().build();
    }
}
