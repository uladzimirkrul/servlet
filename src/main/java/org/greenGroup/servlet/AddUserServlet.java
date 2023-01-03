package org.greenGroup.servlet;

import org.greenGroup.entity.User;
import org.greenGroup.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddUserServlet", urlPatterns = {"/add-user"})
public class AddUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserService userService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("add.jsp");
        requestDispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        userService = (UserService) request.getServletContext().getAttribute("userService");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int age = Integer.parseInt(request.getParameter("age"));
        userService.saveUser(new User(firstName, lastName, age));
        response.sendRedirect("users-list");
    }
}
