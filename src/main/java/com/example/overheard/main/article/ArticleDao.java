package com.example.overheard.main.article;

import com.example.overheard.main.common.BaseDao;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao extends BaseDao {

    public List<Article> findAll() {
        final String sql = "SELECT * FROM article";

        try (
                Connection connection = getConnection();
                Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            List<Article> allArticles = new ArrayList<>();
            while (resultSet.next()) {
                Article article = mapRecord(resultSet);
                allArticles.add(article);
            }
            return allArticles;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Article> findByCategory(int id) {
        final String sql = "SELECT * FROM article WHERE category_id=?";

        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            List<Article> articles = new ArrayList<>();
            while (resultSet.next()) {
                Article article = mapRecord(resultSet);
                articles.add(article);
            }
            return articles;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Article mapRecord(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        String url = resultSet.getString("url");
        String description = resultSet.getString("description");
        LocalDateTime date = resultSet.getTimestamp("date").toLocalDateTime();
        int categoryId = resultSet.getInt("category_id");
        int userId = resultSet.getInt("user_id");
        return new Article(id, title, url, description, date, categoryId, userId);
    }

    public void save(Article article) {
        final String sql = "INSERT INTO article (title, url, description, date, category_id, user_id) VALUES (?,?,?,?,?,?)";
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, article.getTitle());
            statement.setString(2, article.getUrl());
            statement.setString(3, article.getDescription());
            statement.setObject(4, article.getDate());
            statement.setInt(5, article.getCategoryId());
            statement.setInt(6, article.getUserId());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(generatedKeys.next()) {
                article.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
