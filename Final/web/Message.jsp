<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./Message/style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <title>Message</title>
    </head>
    <script>
        function logout() {
            window.location.href = "Manage?action=Logout";
        }
        function user() {
            window.location.href = "Manage";
        }
    </script>

    <body>
        <header>
            <button class="left"><img src="./Manage/Message.png" alt="Button 1"></button>
            <div class="title">
                <h1>
                    <%= session.getAttribute("messageName") %>
                </h1>
            </div>
            <button class="right" onclick="logout()"><img src="./Manage/logout.png" alt="Button 2"></button>
            <button class="right" onclick="user()"><img src="./Manage/user.png" alt="Button 1"></button>
        </header>
        <div class="bodyDiv">

        </div>
    </body>

    </html>