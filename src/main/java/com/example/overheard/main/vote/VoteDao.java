package com.example.overheard.main.vote;

import com.example.overheard.main.common.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
