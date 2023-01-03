package org.greenGroup.servlet;

import org.greenGroup.entity.User;
import org.greenGroup.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UsersServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UserService userService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        userService = (UserService) request.getServletContext().getAttribute("userService");
        List<User> users = userService.readAllUsers();
        request.setAttribute("users", users);
        request.getRequestDispatcher("Users.jsp").forward(request, response);
    }
}
