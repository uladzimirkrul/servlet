package org.greenGroup.commands;

import org.greenGroup.entity.User;
import org.greenGroup.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ListCommand extends FrontCommand{
    @Override
    public void process() throws ServletException, IOException {
        UserService userService = (UserService) request.getServletContext().getAttribute("userService");
        List<User> users = userService.getAllUsers();
        HttpSession session = request.getSession();
        session.setAttribute("users", users);
        forward("list");
    }
}
