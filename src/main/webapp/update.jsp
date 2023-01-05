<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update user</title>
</head>
<body>
<h2>Update user by id = <%out.println(session.getAttribute("id"));%>:</h2>
<%@ page import="org.greenGroup.entity.User" %>
<%User user = (User)session.getAttribute("user");%>
<form method="post" action="front-controller?command=SaveUpdates">
  <label>Name:
    <input required type="text" name="name" minlength="2" maxlength="30"
           value="<%=user.getFirstName()%>" pattern="[a-zA-Zа-яА-Я]*"><br />
  </label>

  <label>Surname:
    <input required type="text" name="surname" minlength="2" maxlength="30"
           value="<%=user.getLastName()%>" pattern="[a-zA-Zа-яА-Я]*"><br />
  </label>

  <label>Age:
    <input required type="number" name="age" min="0" max="130" value="<%=user.getAge()%>"><br />
  </label>
  <button type="submit">Submit</button>
</form>
<button onclick="history.back()">Back</button>
</body>
</html>