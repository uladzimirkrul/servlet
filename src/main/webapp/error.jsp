<%--
  Created by IntelliJ IDEA.
  User: uladzimir
  Date: 1/4/23
  Time: 5:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error page</title>
</head>
<body>
<%String message = (String)session.getAttribute("errorMessage");%>
<%=message%>

</body>
</html>
