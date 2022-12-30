package org.greenGroup.servlet;

import org.greenGroup.entity.User;
import org.greenGroup.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteUserServlet", urlPatterns = {"/delete-user"})
public class DeleteUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserService userService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userService = (UserService) request.getServletContext().getAttribute("userService");
        userService.deleteUserById(Long.parseLong(request.getParameter("id")));
        response.sendRedirect("users-list");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    }
}
