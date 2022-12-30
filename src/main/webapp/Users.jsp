<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import ="org.greenGroup.entity.User"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Users</title>
    </head>
    <body>
        <table align="center">
        <tr><td><h1>Users</h1></td></tr>
        <tr>
            <td>Id</td>
            <td>First Name</td>
            <td>Last Name</td>
            <td>Age</td>

        </tr>

        <%ArrayList<User> users=(ArrayList<User>) request.getAttribute("users");
        for (User user: users) {%>
        <tr>
            <form action="./users/delete" method="post">
            <td>        <input type="hidden" name="id"
                            value=<%=user.getId()%>></td>
            <td><%=user.getId()%></td>
            <td><%=user.getFirstName()%></td>
            <td><%=user.getLastName()%></td>
            <td><%=user.getAge()%></td>
                        <td>
                                        <input type="submit" value="delete">
                        </td>
            </form>
        </tr>
        <%}%>
        <tr><td>
        <td><input type="button" value="Back"
                onclick="window.location.href='./index.jsp'" /></td>
        </tr></td>
        </table>
    </body>
</html>

