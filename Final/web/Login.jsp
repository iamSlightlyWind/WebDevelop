<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <title>Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./Auth/style.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200..1000;1,200..1000&display=swap"
            rel="stylesheet">
    </head>

    <body>
        <form class="loginBlock" action="Auth" method="post">
            <div>
                <h1>DropLetter</h1>
                <input style="font-weight: bold;" type="submit" name="action" value="Login">
                <a href="Register"><b>Don't have an account yet?</b></a>
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
    </body>

    </html>