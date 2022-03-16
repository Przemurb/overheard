package com.example.overheard.client.home;

import com.example.overheard.main.api.ArticleDto;
import com.example.overheard.main.api.ArticleService;
import com.example.overheard.main.api.CategoryDto;
import com.example.overheard.main.api.CategoryService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeController", value = "")
public class HomeController extends HttpServlet {
    private final ArticleService articleService = new ArticleService();
    private final CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ArticleDto> articles = articleService.findAll();
        request.setAttribute("articles", articles);
        List<CategoryDto> categories = categoryService.findAllCategoryNames();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request, response);
    }
}
