<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <title>Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./Auth/style.css">
    </head>

    <body>
        <form class="loginBlock" action="Auth" method="post">
            <div>
                <input type="submit" name="action" value="Login">
                <a href="Register">Don't have an account yet?</a>
            </div>
            <div>
                <div>
                    <input type="text" id="userName" name="userName" required placeholder="Username"><br>
                </div>
                <div>
                    <input type="password" id="password" name="password" required placeholder="Password"><br>
                </div>
                <p id="status">${accountStatus}</p>
            </div>
        </form>
        <div style="display: block;">
            <form action="Auth" method="post" >
                <input type="submit" name="action" value="create">
            </form>
        </div>
    </body>

    </html>