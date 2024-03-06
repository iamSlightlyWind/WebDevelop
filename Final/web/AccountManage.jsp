<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account</title>
    </head>

    <body>
        <% String accountName=(String) request.getSession().getAttribute("user"); %>
            <p>Name: <%= accountName %>
            </p>

            <form action="Authentication" method="get">
                <input type="submit" name="action" value="Logout">
            </form>

            <form action="AccountManage" method="get">
                <p>Change password </p>
                <label for="oldPassword">Old password: </label>
                <input type="text" id="oldPassword" name="oldPassword" required><br>
                <label for="newPassword">New password: </label>
                <input type="text" id="newPassword" name="newPassword" required><br>
                <input type="submit" name="action" value="Change password">
            </form>

            <form action="AccountManage" method="get">
                <p>Delete account </p>
                <label for="deleteAccount">Tick to delete account: </label>
                <input type="checkbox" id="deleteAccount" name="deleteAccount" required><br>
                <input type="submit" name="action" value="Delete account">
            </form>
    </body>

    </html>