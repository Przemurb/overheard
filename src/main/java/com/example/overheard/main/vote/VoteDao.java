package com.example.overheard.main.vote;

import com.example.overheard.main.article.Article;
import com.example.overheard.main.common.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VoteDao extends BaseDao {
    public void save (Vote vote) {
        final String sql = "INSERT INTO vote (user_id, article_id, type, date) VALUES (?, ?, ?, ?) ON DUPLICATE KEY UPDATE type=?";

        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, vote.getUserId());
            statement.setInt(2, vote.getArticleId());
            statement.setString(3, vote.getType().toString());
            statement.setObject(4, vote.getDate());
            statement.setString(5, vote.getType().toString());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int sumVoteByArticleId() {
        return sumVoteByArticleId();
    }

    public int sumVoteByArticleId(int articleId) {
        final String sql = """
             SELECT
                (SELECT COUNT(article_id) FROM vote WHERE article_id = ? AND type = 'UP')
                -
                (SELECT COUNT(article_id) FROM vote WHERE article_id = ? AND type = 'DOWN')
                AS
                vote_count;
                """;
        try(Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, articleId);
            statement.setInt(2, articleId);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("vote_count");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
