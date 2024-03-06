<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <title>Authentication</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <body>
        <%
            String user = (String) request.getSession().getAttribute("user");
            String status;
            if(user == null) {
                status = "You are not logged in";
            }else {
                status = "You are logged in as " + user;
            }
        %>
        <p>${status}</p>
        <form action="Auth" method="get">
            <label for="userName">Username: </label>
            <input type="text" id="userName" name="userName"><br>
            <label for="password">Password: </label>
            <input type="text" id="password" name="password" required><br>
            <input type="submit" name="action" value="Login">
            <input type="submit" name="action" value="Register">
        </form>
        <p id="status">${accountStatus}</p>
        <p id="redirectMessage"></p>
        <script>
            var status = document.getElementById('status').innerText;
            if (status === 'Login successful' || status === 'Register successful') {
                var counter = 3;
                var interval = setInterval(function () {
                    counter--;
                    // Display 'counter' wherever you want to display it.
                    document.getElementById('redirectMessage').innerText = 'You will be redirected in ' + counter + ' seconds...';
                    if (counter <= 0) {
                        // Display a login/register success message if you want to
                        clearInterval(interval);
                        // Navigate to /AccountManage
                        window.location.href = './AccountManage';
                    }
                }, 1000);
            }
        </script>
    </body>

    </html>