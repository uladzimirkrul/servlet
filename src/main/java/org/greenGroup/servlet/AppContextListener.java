package org.greenGroup.servlet;

import org.greenGroup.dao.UserDao;
import org.greenGroup.service.UserService;
import org.greenGroup.util.DBUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener{
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext ctx = servletContextEvent.getServletContext();
        UserService userService = new UserService();
        ctx.setAttribute("userService", userService);
    }
}
