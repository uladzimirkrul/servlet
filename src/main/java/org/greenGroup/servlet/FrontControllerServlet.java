package org.greenGroup.servlet;


import org.greenGroup.commands.FrontCommand;
import org.greenGroup.commands.UnknownCommand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FrontControllerServlet", value = "/front-controller")
public class FrontControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FrontCommand command = getCommand(request);
        command.init(getServletContext(), request, response);
        command.process();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FrontCommand command = getCommand(request);
        command.init(getServletContext(), request, response);
        command.process();
    }

    private FrontCommand getCommand(HttpServletRequest request) {
        try {
            Class command = Class.forName(String.format(
                    "org.greenGroup." + "commands.%sCommand",
                    request.getParameter("command")));
            return (FrontCommand) command
                    .asSubclass(FrontCommand.class)
                    .newInstance();
        } catch (Exception e) {
            return new UnknownCommand();
        }
    }
}
