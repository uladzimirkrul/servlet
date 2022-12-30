<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Details</title>
</head>
<body>

    <form action="./users/delete" method="post">
        <table>
            <tr>
                <td>Enter ID:</td>
                <td><input type="text" name="id" maxlength="6" size="7" /></td>
            </tr>

        </table>
        <br /> <input type="submit" value="Delete user" />
    </form>
    <br />

            <form action="." method="post">
                <input type="submit" value="back">
            </form>

</body>

</html>