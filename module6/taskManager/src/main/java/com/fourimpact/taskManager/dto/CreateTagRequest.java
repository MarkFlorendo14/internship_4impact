package com.fourimpact.taskManager.dto;

public class CreateTagRequest {
    private Long tagId;
    private String tagName;


    public CreateTagRequest(String tagName, Long tagId) {
        this.tagId = tagId;
        this.tagName = tagName;
    }

    public String getTagName() {
        return tagName;
    }
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
    public Long getTagId() {
        return tagId;
    }
    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }
}
