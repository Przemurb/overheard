package com.example.overheard.main.api;

public class VoteDto {
    private String username;
    private Integer articleId;
    private  String type;

    public VoteDto(String username, Integer articleId, String type) {
        this.username = username;
        this.articleId = articleId;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public String getType() {
        return type;
    }
}
