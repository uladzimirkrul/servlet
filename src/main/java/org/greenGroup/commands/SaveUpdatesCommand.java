package org.greenGroup.commands;

import org.greenGroup.entity.User;
import org.greenGroup.exception.UserNotFoundException;
import org.greenGroup.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SaveUpdatesCommand extends FrontCommand{
    @Override
    public void process() throws ServletException, IOException {
        HttpSession session = request.getSession();
        Long id = (Long)session.getAttribute("id");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int age = Integer.parseInt(request.getParameter("age"));
        User user = new User(name, surname, age);
        UserService userService = (UserService) request.getServletContext().getAttribute("userService");
        try {
            userService.updateUserById(user, id);
            redirectToList();
        } catch (UserNotFoundException e) {
            request.getSession().setAttribute("errorMessage", e.getMessage());
            forward("error");
        }


    }
}
