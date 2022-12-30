package org.greenGroup.servlet;

import org.greenGroup.entity.User;
import org.greenGroup.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UsersListServlet", urlPatterns = {"/users-list"})
public class UsersListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = (UserService) request.getServletContext().getAttribute("userService");
        List<User> users = userService.getAllUsers();
        HttpSession session = request.getSession();
        session.setAttribute("users", users);
        response.sendRedirect("list.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}