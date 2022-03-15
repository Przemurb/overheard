package com.example.overheard.main.api;

import java.time.LocalDateTime;

public class ArticleDto {
    private String title;
    private String url;
    private String description;
    private LocalDateTime date;

    public ArticleDto(String title, String url, String description, LocalDateTime date) {
        this.title = title;
        this.url = url;
        this.description = description;
        this.date = date;
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
}
