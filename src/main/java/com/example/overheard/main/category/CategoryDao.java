package com.example.overheard.main.category;

import com.example.overheard.main.common.BaseDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryDao extends BaseDao {

    public List<Category> findAll() {
        final String sql = "SELECT * FROM category";

        try(
        Connection connection = getConnection();
        Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            List<Category> categories = new ArrayList<>();
            while (resultSet.next()) {
                Category category = mapRecord(resultSet);
                categories.add(category);
            }
            return categories;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Category> findById (int id) {
        final String sql = "SELECT * FROM category WHERE id=?";
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Category category = mapRecord(resultSet);
                return Optional.of(category);
            } else {
                return Optional.empty();
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private Category mapRecord(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        return new Category(id, name, description);
    }
}
