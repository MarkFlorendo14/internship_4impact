package com.fourimpact.taskManager.dto;

public class TagResponse {
    private Long Id;
    private String name;

    public TagResponse(Long Id, String name) {
        this.Id = Id;
        this.name = name;
    }

    public Long getId() {
        return Id;
    }
    public void setId(Long Id) {
        this.Id = Id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
