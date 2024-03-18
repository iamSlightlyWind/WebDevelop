<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <title>Register</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./Auth/style.css">
    </head>

    <body>

        <form class="loginBlock" action="Auth" method="post">
            <div>
                <input type="submit" name="action" value="Register">
                <a href="Login">Already have an account?</a>
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