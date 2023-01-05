<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users list</title>
</head>
<body>
<h1>Users</h1>
<%@ page import="org.greenGroup.entity.User" %>
<%@ page import="java.util.List" %>

<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Age</th>
        <th></th>
        <th></th>
    </tr>
    </thead>

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
                <td><button type="submit" formaction="front-controller?command=Update">Delete</button></td>
            </tr>
            </form>
            <%
                }
            %>
</table>
<p>
</p>
<p></p>
<form method="post" action="front-controller?command=Update">
    <label>Id for update:
        <input type="number" name="id" min="1">
    </label>
    <button type="submit">Submit</button>
</form>
<p></p>
<form method="post" action="front-controller?command=Delete">
    <label>Id for delete:
        <input type="number" name="id" min="1">
    </label>
    <button type="submit">Submit</button>
</form>
<p></p>
<a href="front-controller?command=Add">Add user</a>
<p></p>
<a href="index.jsp">Go back</a>
</body>
</html>
