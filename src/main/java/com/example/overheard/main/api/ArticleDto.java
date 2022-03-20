package com.example.overheard.main.api;

import java.time.LocalDateTime;

public class ArticleDto {
    private Integer id;
    private String title;
    private String url;
    private String description;
    private LocalDateTime date;
    private int voteSum;
    private String author;

    public ArticleDto(Integer id, String title, String url, String description, LocalDateTime date, int voteSum, String author) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.description = description;
        this.date = date;
        this.voteSum = voteSum;
        this.author = author;

    }
    public Integer getId() {
        return id;
    }

    public int getVoteSum() {
        return voteSum;
    }

    public String getAuthor() {
        return author;
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
