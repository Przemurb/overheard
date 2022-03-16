package com.example.overheard.main.api;

public class CategoryDto {
    private Integer id;
    private String name;

    public CategoryDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

