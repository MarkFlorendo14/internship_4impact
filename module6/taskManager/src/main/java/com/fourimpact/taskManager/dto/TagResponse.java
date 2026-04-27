package com.fourimpact.taskManager.dto;

public class TagResponse {
    private Long Id;
    private String Name;

    public TagResponse(Long Id, String tagName) {
        this.Id = Id;
        this.Name = Name;
    }

    public Long getTagId() {
        return Id;
    }
    public void setTagId(Long Id) {
        this.Id = Id;
    }
    public String getTagName() {
        return Name;
    }
    public void setTagName(String Name) {
        this.Name = Name;
    }

}
