package org.greenGroup.servlet;

import org.greenGroup.entity.User;
import org.greenGroup.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UpdateUserServlet", urlPatterns = {"/update-user"})
public class UpdateUserServlet extends HttpServlet {
    private UserService userService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        userService = (UserService) request.getServletContext().getAttribute("userService");
        User user = userService.getUserById(id);
        HttpSession session = request.getSession();
        session.setAttribute("id", id);
        session.setAttribute("user", user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("update.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Long id = (Long)session.getAttribute("id");

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int age = Integer.parseInt(request.getParameter("age"));
        User user = new User(name, surname, age);
        userService = (UserService) request.getServletContext().getAttribute("userService");
        userService.updateUserById(user, id);
        response.sendRedirect("users-list");
    }
}
