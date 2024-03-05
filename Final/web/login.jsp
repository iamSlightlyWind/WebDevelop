<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="AccountManage" method="get">
            <label for="userName">Username: </label>
            <input type="text" id="userName" name="userName"><br>
            <label for="password">Password: </label>
            <input type="text" id="password" name="password" required><br>
            <input type="submit" name="action" value="Login">
            <input type="submit" name="action" value="Register">
        </form>
        <p>${accountStatus}</p>
    </body>
</html>