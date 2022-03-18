package com.example.overheard.client.vote;

import com.example.overheard.main.api.VoteDto;
import com.example.overheard.main.api.VoteService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "VoteController", value = "/article/vote")
@ServletSecurity(
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "GET", rolesAllowed = "USER")
        }
)
public class VoteController extends HttpServlet {
    VoteService voteService = new VoteService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VoteDto vote = createVote(request);
        voteService.addVote(vote);
        response.sendRedirect(request.getContextPath());
    }

    private VoteDto createVote(HttpServletRequest request) {
        String username = request.getUserPrincipal().getName();
        int id = Integer.parseInt(request.getParameter("id"));
        String type = request.getParameter("type");
        return new VoteDto(username, id, type);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
