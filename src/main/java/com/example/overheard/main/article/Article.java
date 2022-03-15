package com.example.overheard.main.article;

import java.time.LocalDateTime;

public class Article {
    private Integer id;
    private String title;
    private String url;
    private String description;
    private LocalDateTime date;
    private Integer categoryId;

    public Article(Integer id, String title, String url, String description, LocalDateTime date, Integer categoryId) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.description = description;
        this.date = date;
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Integer getCategoryId() {
        return categoryId;
    }
}
