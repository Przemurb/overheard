package com.example.overheard.client.article;

import com.example.overheard.main.api.ArticleService;
import com.example.overheard.main.api.CategoryDto;
import com.example.overheard.main.api.CategoryService;
import com.example.overheard.main.api.NewArticleDto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "NewArticleController", value = "/article/new")
@ServletSecurity(
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "GET", rolesAllowed = "USER"),
                @HttpMethodConstraint(value = "POST", rolesAllowed = "USER")
        }
)
public class NewArticleController extends HttpServlet {
    private ArticleService articleService = new ArticleService();
    private CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CategoryDto> categories = categoryService.findAllCategoryNames();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/WEB-INF/pages/new-article.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NewArticleDto newArticle = createNewArticle(request);
    }

    private NewArticleDto createNewArticle(HttpServletRequest request) {
        String username = request.getUserPrincipal().getName();
        return new NewArticleDto(
                request.getParameter("title"),
                request.getParameter("url"),
                request.getParameter("description"),
                Integer.valueOf(request.getParameter("categoryId")),
                username);
    }
}
