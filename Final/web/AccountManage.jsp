<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Account Manage</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
    $(document).ready(function(){
        $.get("Manage", function(data, status){
            // assuming data is a JSON object that your servlet returns
            $("#firstName").val(data.firstName);
            $("#lastName").val(data.lastName);
            $("#email").val(data.email);
            // add more as needed
        });
    });
    </script>
</head>
<body>
    <% String accountName=(String) request.getSession().getAttribute("user"); %>
    <p>Hello, <%= accountName %></p>

    <form action="Manage" method="get">
        <input type="submit" name="action" value="Logout">
    </form>

    <form action="Manage" method="get">
        <p>Change account details</p>
        <label for="firstName">First Name: </label>
        <input type="text" id="firstName" name="firstName" placeholder="First Name" required><br>
        <label for="lastName">Last Name: </label>
        <input type="text" id="lastName" name="lastName" placeholder="Last Name" required><br>
        <label for="email">Email: </label>
        <input type="email" id="email" name="email" placeholder="Email" required><br>
        <input type="submit" name="action" value="changeDetails">
    </form>

    <form action="Manage" method="get">
        <p>Change password </p>
        <label for="oldPassword">Old password: </label>
        <input type="password" id="oldPassword" name="oldPassword" required><br>
        <label for="newPassword">New password: </label>
        <input type="password" id="newPassword" name="newPassword" required><br>
        <input type="submit" name="action" value="changePassword">
        <p>${changePasswordStatus}</p>
    </form>

    <form action="Manage" method="get">
        <p>Delete account </p>
        <label for="deleteAccount">Tick to delete account: </label>
        <input type="checkbox" id="deleteAccount" name="deleteAccount" required><br>
        <input type="submit" name="action" value="deleteAccount">
    </form>
</body>
</html>