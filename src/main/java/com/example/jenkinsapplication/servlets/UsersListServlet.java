package com.example.jenkinsapplication.servlets;

import com.example.jenkinsapplication.dao.UserDao;
import com.example.jenkinsapplication.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class UsersListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = UserDao.getInstance();
        List<User> users = userDao.list();
        HttpSession session = request.getSession();
        session.setAttribute("users", users);
        response.sendRedirect("list.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
