package com.fourimpact.taskManager.service;

import com.fourimpact.taskManager.dto.CreateTagRequest;
import com.fourimpact.taskManager.dto.TagResponse;
import com.fourimpact.taskManager.entity.Tag;
import com.fourimpact.taskManager.exception.ResourceNotFoundException;
import com.fourimpact.taskManager.repository.TagRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }
    //Create
    @Transactional
    public TagResponse createTag(CreateTagRequest createTagRequest) {
        Tag tag = new Tag();
        tag.setName(createTagRequest.getTagName());
        tagRepository.save(tag);
        return toResponse(tag);
    }
    //Read
    @Transactional(readOnly = true)
    public List<TagResponse> getAllTags() {
        return tagRepository.findAll().stream().map(tag -> toResponse(tag)).collect(Collectors.toList());

    }
    @Transactional(readOnly = true)
    public TagResponse getTagByID(Long id) {
        Tag tags = tagRepository.findById(id)
                .orElseThrow (() -> new ResourceNotFoundException("Tag", id));
        return toResponse(tags);
    }
    //Update
    @Transactional
    public TagResponse updateTag(Long id, CreateTagRequest createTagRequest) {
        Tag tags = tagRepository.findById(id)
                .orElseThrow (() -> new ResourceNotFoundException("Tag", id));
        tags.setName(createTagRequest.getTagName());
        tagRepository.save(tags);
        return toResponse(tags);
    }
    //Delete
    @Transactional
    public void deleteTag(Long id) {
        if(!tagRepository.existsById(id)) {
            throw new ResourceNotFoundException("Task", id);
        } else {
            tagRepository.deleteById(id);
        }
    }

    public TagResponse toResponse(Tag tag) {
        return new TagResponse(
                tag.getId(),
                tag.getName()
        );
    }
}
