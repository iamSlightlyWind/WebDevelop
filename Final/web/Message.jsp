<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" href="./Message/style.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
            <title>Message</title>
            <link rel="preconnect" href="https://fonts.googleapis.com">
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
            <link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200..1000;1,200..1000&display=swap"
                rel="stylesheet">
            <link rel="preconnect" href="https://fonts.googleapis.com">
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
            <link href="https://fonts.googleapis.com/css2?family=Aboreto&family=Condiment&display=swap"
                rel="stylesheet">
        </head>
        <script>
            function logout() {
                window.location.href = "Manage?action=Logout";
            }
            function user() {
                window.location.href = "Manage";
            }
            window.onload = function () {
                var messageDiv = document.getElementById('messageDiv');
                messageDiv.scrollTop = messageDiv.scrollHeight;
            }
        </script>

        <body>
            <header>
                <button class="left"><img src="./Manage/Message.png" alt="Button 1"></button>
                <div class="title">
                    <h1 class="web">
                        <%= session.getAttribute("messageName") %>
                    </h1>
                </div>
                <button class="right" onclick="logout()"><img src="./Manage/logout.png" alt="Button 2"></button>
                <button class="right" onclick="user()"><img src="./Manage/user.png" alt="Button 1"></button>
            </header>
            <div class="bodyDiv">
                <div id="messageDiv" class="messageDiv">
                    <c:forEach var="message" items="${messageList}">
                        <div>
                            <p class="${message.senderID == 0 ? 'float-left' : 'float-right'}">${message.message}</p>
                            <c:if test="${message.senderID == 1}">
                                <form class="deleteForm" action="./Mess" method="post">
                                    <input type="hidden" name="messageBody" value="${message.message}">
                                    <input type="hidden" name="messageTime" value="${message.time}">
                                    <button class="deleteButton" type="submit" name="action" value="delete">
                                        <img class="deleteImage" src="./Message/delete.png">
                                    </button>
                                </form>
                            </c:if>
                            <br>
                        </div>
                    </c:forEach>
                </div>
                <div class="inputDiv">
                    <div class="innerInputDiv">
                        <form name="Mess" method="post">
                            <input type="text" placeholder="Type a message" name="message">
                            <button type="submit" name="action" value="send"><b>Send</b></button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>