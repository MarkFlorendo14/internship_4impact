package com.fourimpact.taskManager.service;

import com.fourimpact.taskManager.dto.CreateTagRequest;
import com.fourimpact.taskManager.dto.TagResponse;
import com.fourimpact.taskManager.entity.Tag;
import com.fourimpact.taskManager.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public TagResponse createTag(CreateTagRequest createTagRequest) {
        Tag tag = new Tag();
        tag.setName(createTagRequest.getTagName());
        tagRepository.save(tag);
        return toResponse(tag);
    }

    public List<TagResponse> getAllTags() {
        return tagRepository.findAll().stream().map(this::toResponse).collect(Collectors.toList());
    }

    public TagResponse toResponse(Tag tag) {
        return new TagResponse(
                tag.getId(),
                tag.getName()
        );
    }
}
