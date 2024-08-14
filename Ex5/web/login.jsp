<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html>

        <head>
            <title>Login</title>
        </head>

        <body>
            <h1>Login <a href="register.jsp">Register</a></h1>
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
                    <button type="submit" name="action" value="login">Login</button>
                </div>
            </form>
            <p>${status}</p>
        </body>