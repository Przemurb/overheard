package com.example.overheard.main.vote;

import java.time.LocalDateTime;

public class Vote {
    private Integer userId;
    private Integer articleId;
    private Type type;
    private LocalDateTime date;

    public Vote(Integer userId, Integer articleId, Type type, LocalDateTime date) {
        this.userId = userId;
        this.articleId = articleId;
        this.type = type;
        this.date = date;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public Type getType() {
        return type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public enum Type {
        UP, DOWN;
    }
}
