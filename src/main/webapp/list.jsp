<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users list</title>
</head>
<body>
<h1>Users</h1>
<%@ page import="org.greenGroup.entity.User" %>
<%@ page import="java.util.List" %>

<table cellpadding="7">
    <tr>
        <th></th>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Age</th>
        <th></th>
        <th></th>
    </tr>
            <%
                for (User user : (List<User>) session.getAttribute("users")) {
            %>
            <form method="post">
            <tr>
                <td><input type="hidden" name="id" value=<%=user.getId()%>></td>
            <td><%=user.getId()%></td>
            <td><%=user.getFirstName()%></td>
            <td><%=user.getLastName()%></td>
            <td><%=user.getAge()%></td>
                <td><button type="submit" formaction="front-controller?command=Update">Update</button></td>
                <td><button type="submit" formaction="front-controller?command=Delete">Delete</button></td>
            </tr>
            </form>
            <%
                }
            %>
</table>
<p>
</p>
<p></p>
<p></p>
<a href="front-controller?command=Add">Add user</a>
<p></p>
<a href="index.jsp">Go back</a>
</body>
</html>
