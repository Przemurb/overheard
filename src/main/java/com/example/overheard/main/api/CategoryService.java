package com.example.overheard.main.api;

import com.example.overheard.main.category.Category;
import com.example.overheard.main.category.CategoryDao;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryService {
    CategoryDao categoryDao = new CategoryDao();

    public List<CategoryDto> findAllCategoryNames() {
        return categoryDao.findAll()
                .stream()
                .map(CategoryMapper::map)
                .collect(Collectors.toList());
    }

    private static class CategoryMapper {
        static CategoryDto map(Category category) {
            return new CategoryDto(category.getId(), category.getName());
        }
    }
}