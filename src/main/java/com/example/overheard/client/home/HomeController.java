package com.example.overheard.client.home;

import com.example.overheard.main.api.ArticleDto;
import com.example.overheard.main.api.ArticleService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeController", value = "")
public class HomeController extends HttpServlet {
    private ArticleService articleService = new ArticleService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ArticleDto> articles = articleService.findAll();
        request.setAttribute("articles", articles);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
