package com.example.overheard.main.article;

import com.example.overheard.db.DataSourceProvider;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao {
    private final DataSource dataSource;

    public ArticleDao() {
        try {
            this.dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Article>findAll() {
        final String sql = "SELECT * FROM article";

        try(
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            List<Article> allArticles = new ArrayList<>();
            while (resultSet.next()) {
                Article article = mapRecord(resultSet);
                allArticles.add(article);
            }
            return allArticles;
        }catch (SQLException e) {
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
        return new Article(id, title, url, description, date, categoryId);
    }
}
