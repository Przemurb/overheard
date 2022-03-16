package com.example.overheard.client.home;

import com.example.overheard.main.api.ArticleDto;
import com.example.overheard.main.api.ArticleService;
import com.example.overheard.main.api.CategoryFullDto;
import com.example.overheard.main.api.CategoryService;
import com.example.overheard.main.category.CategoryDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryController", value = "/category")
public class CategoryController extends HttpServlet {
    private final CategoryService categoryService = new CategoryService();
    private final ArticleService articleService = new ArticleService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        CategoryFullDto category = categoryService.findById(id)
                .orElseThrow();
        request.setAttribute("category", category);
        List<ArticleDto> articles = articleService.findByCategory(id);
        request.setAttribute("articles", articles);
        request.getRequestDispatcher("/category.jsp").forward(request, response);
    }
}
