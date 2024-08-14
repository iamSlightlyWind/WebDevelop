<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html>

        <head>
            <title>Register</title>
        </head>

        <body>
            <h1>Register <a href="login.jsp">Login</a></h1>
            <form action="auth" method="post">
                <div>
                    <label for="username">Username:</label>
                    <input type="text" name="username" required />
                </div>
                <div>
                    <label for="password">Password:</label>
                    <input type="password" name="password" required />
                </div>
                <div>
                    <label>Role:</label>
                    <input type="radio" name="role" value="1" required /> Admin
                    <input type="radio" name="role" value="2" required /> User
                </div>
                <div>
                    <button type="submit" name="action" value="register">Register</button>
                </div>
            </form>
            <p>${status}</p>
        </body>