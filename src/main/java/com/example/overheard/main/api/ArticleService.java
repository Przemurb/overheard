package com.example.overheard.main.api;

import com.example.overheard.main.article.Article;
import com.example.overheard.main.article.ArticleDao;

import java.util.List;
import java.util.stream.Collectors;

public class ArticleService {
    private final ArticleDao articleDao = new ArticleDao();

    public List<ArticleDto>findAll() {
        return articleDao.findAll()
                .stream()
                .map(ArticleMapper::map)
                .collect(Collectors.toList());
    }

    private static class ArticleMapper {
        static ArticleDto map(Article article) {
            return new ArticleDto(article.getTitle(), article.getUrl(), article.getDescription(), article.getDate());
        }
    }
}
