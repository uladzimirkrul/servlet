<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user page</title>
</head>
<body>
<form method="post">
    <label>Name:
        <input type="text" name="firstName"><br />
    </label>

    <label>Surname:
        <input type="text" name="lastName"><br />
    </label>

    <label>Age:
        <input type="number" name="age" min="0"><br />
    </label>
    <button type="submit">Submit</button>
</form>
</body>
</html>