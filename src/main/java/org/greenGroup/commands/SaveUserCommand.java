package org.greenGroup.commands;

import org.greenGroup.entity.User;
import org.greenGroup.service.UserService;

import javax.servlet.ServletException;
import java.io.IOException;

public class SaveUserCommand extends FrontCommand{
    @Override
    public void process() throws ServletException, IOException {
        UserService userService = (UserService) request.getServletContext().getAttribute("userService");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int age = Integer.parseInt(request.getParameter("age"));
        userService.saveUser(new User(firstName, lastName, age));
        redirectToList();
    }
}
