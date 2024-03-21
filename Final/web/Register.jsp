<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <title>Register</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./Auth/style.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200..1000;1,200..1000&display=swap"
            rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Condiment&display=swap" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Aboreto&family=Condiment&display=swap" rel="stylesheet">
    </head>

    <body>

        <form class="loginBlock" action="Auth" method="post">
            <div>
                <h1 class="dropletter">DropLetter</h1>
                <input style="font-weight: bold;" type="submit" name="action" value="Register">
                <a href="Login"><b>Already have an account?</b></a>
            </div>
            <div>
                <div>
                    <input type="text" id="firstName" name="firstName" required placeholder="First Name"><br>
                </div>
                <div>
                    <input type="text" id="lastName" name="lastName" required placeholder="Last Name"><br>
                </div>
                <div>
                    <input type="email" id="email" name="email" required placeholder="Email"><br>
                </div>
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