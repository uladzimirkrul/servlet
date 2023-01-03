package org.greenGroup.commands;

import org.greenGroup.service.UserService;

import javax.servlet.ServletException;
import java.io.IOException;

public class DeleteCommand extends FrontCommand{
    @Override
    public void process() throws ServletException, IOException {
        UserService userService = (UserService) request.getServletContext().getAttribute("userService");
        userService.deleteUserById(Long.parseLong(request.getParameter("id")));
        redirectToList();
    }
}
