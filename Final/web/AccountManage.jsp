<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Manage</title>
        <link rel="stylesheet" href="./Manage/style.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200..1000;1,200..1000&display=swap"
            rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Aboreto&family=Condiment&display=swap" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                var firstName = '<%= request.getAttribute("firstName") %>';
                var lastName = '<%= request.getAttribute("lastName") %>';
                var email = '<%= request.getAttribute("email") %>';

                $('#firstName').val(firstName);
                $('#lastName').val(lastName);
                $('#email').val(email);
            });
            function logout() {
                window.location.href = "Manage?action=Logout";
            }
            function search() {
                window.location.href = "SearchFor";
            }
        </script>
    </head>

    <body>
        <header>
            <button class="left"><img src="./Manage/user.png" alt="Button 1"></button>
            <div class="title">
                <h1 class="web">Account Management</h1>
            </div>
            <button class="right" onclick="logout()"><img src="./Manage/logout.png" alt="Button 2"></button>
            <button class="right" onclick="search()"><img src="./Manage/search.png" alt="Button 1"></button>
        </header>
        <div class="bodyDiv">
            <h1 class="Welcome">Hello, <%= session.getAttribute("user") %>
            </h1>
            <div class="forms">
                <form action="Manage" method="post">
                    <p class="formTitle"><b>Change account details</b></p>

                    <div class="container">
                        <div class="halfBox">
                            <label for="firstName">First Name: </label><br>
                            <input type="text" id="firstName" name="firstName" placeholder="First Name" required>
                        </div>
                        <div class="halfBox" style="float: right;">
                            <label style="margin-left: 4%;" class="halfBox" for="lastName">Last Name: </label><br>
                            <input style="float: right;" type="text" id="lastName" name="lastName"
                                placeholder="Last Name" required>
                        </div>
                    </div>

                    <div class="fullBox">
                        <label for="email">Email: </label>
                        <input type="email" id="email" name="email" placeholder="Email" required><br>
                    </div>
                    <input style="float: right; margin-right: 5%;" type="submit" name="action" value="Save">
                </form>
            </div>

            <div class="forms">
                <form action="Manage" method="post">
                    <p class="formTitle"><b>Change password</b></p>

                    <div class="container">
                        <div class="fullBox" style="margin-bottom: 2%;">
                            <label for="oldPassword">Old password: </label><br>
                            <input type="password" id="oldPassword" name="oldPassword" required>
                        </div>
                        <div class="fullBox">
                            <label for="newPassword">New password: </label><br>
                            <input type="password" id="newPassword" name="newPassword" required>
                        </div>
                    </div>

                    <input style="float: right; margin-right: 5%;" type="submit" name="action" value="Change">
                    <p>${changePasswordStatus}</p>
                </form>
            </div>

            <div class="forms">
                <form action="Manage" method="post" class="deleteForm">
                    <p class="formTitle"><b>Delete account</b></p>
                    <label for="deleteAccount" style="font-size: 17.5px;">Tick to delete account: </label>
                    <input type="checkbox" id="deleteAccount" name="deleteAccount" required><br>
                    <input type="submit" style="margin-top: 2%;" name="action" value="Delete">
                </form>
            </div>
        </div>
    </body>

    </html>