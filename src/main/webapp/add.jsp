<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>
<form method="post" action="front-controller?command=SaveUser">
    <label>Name:
        <input required type="text" name="firstName" minlength="2"
               maxlength="30" pattern="[a-zA-Zа-яА-Я]*" placeholder="only letters are allowed"><br />
    </label>

    <label>Surname:
        <input required type="text" name="lastName" minlength="2"
               maxlength="30" pattern="[a-zA-Zа-яА-Я]*" placeholder="only letters are allowed"/><br />
    </label>

    <label>Age:
        <input required type="number" name="age" min="0" max="130"><br />
    </label>
    <button type="submit">Submit</button>
</form>
<button onclick="history.back()">Back</button>
</body>
</html>