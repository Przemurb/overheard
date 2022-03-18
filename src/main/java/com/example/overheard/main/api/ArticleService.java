package com.example.overheard.main.api;

import com.example.overheard.main.article.Article;
import com.example.overheard.main.article.ArticleDao;
import com.example.overheard.main.user.UserDao;
import com.example.overheard.main.vote.VoteDao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ArticleService {
    private final ArticleDao articleDao = new ArticleDao();
    private final ArticleMapper articleMapper = new ArticleMapper();

    public List<ArticleDto>findAll() {
        return articleDao.findAll()
                .stream()
                .map(articleMapper::map)
                .collect(Collectors.toList());
    }

    public List<ArticleDto>findByCategory (int id) {
        return articleDao.findByCategory(id)
                .stream()
                .map(articleMapper::map)
                .collect(Collectors.toList());
    }

    public void add(NewArticleDto newArticle) {
        Article articleToSave = articleMapper.map(newArticle);
        articleDao.save(articleToSave);
    }
    private static class ArticleMapper {
        private final UserDao userDao = new UserDao();
        private final VoteDao voteDao = new VoteDao();

        ArticleDto map(Article article) {
            return new ArticleDto(article.getId(), article.getTitle(), article.getUrl(), article.getDescription(),
                    article.getDate(), voteDao.sumVoteByArticleId(article.getId()));
        }

        Article map(NewArticleDto article) {
            Integer userId = userDao.findByUsername(article.getAuthor()).orElseThrow().getId();
            return new Article(article.getTitle(), article.getUrl(), article.getDescription(),
                    LocalDateTime.now(), article.getCategoryId(), userId);
        }
    }
}
