package com.example.overheard.main.article;

import java.time.LocalDateTime;

public class Article {
    private Integer id;
    private String title;
    private String url;
    private String description;
    private LocalDateTime date;
    private Integer categoryId;
    private Integer userId;

    public Article(Integer id, String title, String url, String description, LocalDateTime date, Integer categoryId, Integer userId) {
        this(title, url, description, date, categoryId, userId);
        this.id = id;
    }

    public Article(String title, String url, String description, LocalDateTime date, Integer categoryId, Integer userId) {
        this.title = title;
        this.url = url;
        this.description = description;
        this.date = date;
        this.categoryId = categoryId;
        this.userId = userId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getUserId() {
        return userId;
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
