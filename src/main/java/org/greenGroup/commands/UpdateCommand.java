package org.greenGroup.commands;

import org.greenGroup.entity.User;
import org.greenGroup.exception.UserNotFoundException;
import org.greenGroup.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UpdateCommand extends FrontCommand{
    @Override
    public void process() throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        UserService userService = (UserService) request.getServletContext().getAttribute("userService");
        try {
            User user = userService.getUserById(id);
            HttpSession session = request.getSession();
            session.setAttribute("id", id);
            session.setAttribute("user", user);
            forward("update");
        } catch (UserNotFoundException e) {
            request.getSession().setAttribute("errorMessage",e.getMessage());
            forward("error");
        }

    }
}
