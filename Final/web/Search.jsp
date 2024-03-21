<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" href="./Search/style.css">
            <title>Search</title>
            <link rel="preconnect" href="https://fonts.googleapis.com">
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
            <link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200..1000;1,200..1000&display=swap"
                rel="stylesheet">
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
                function user() {
                    window.location.href = "Manage";
                }
            </script>
        </head>

        <body>
            <header>
                <button class="left"><img src="./Manage/search.png" alt="Button 1"></button>
                <div class="title">
                    <h1>Search</h1>
                </div>
                <button class="right" onclick="logout()"><img src="./Manage/logout.png" alt="Button 2"></button>
                <button class="right" onclick="user()"><img src="./Manage/user.png" alt="Button 1"></button>
            </header>

            <div class="bodyDiv">
                <div class="half">
                    <form action="SearchFor" method="post">
                        <input type="text" name="userInput" placeholder="Users">
                        <button type="submit" style="padding: 0.5% 1%;" name="action"
                            value="searchUsers">Search</button>
                        <p>${userString}</p>
                    </form>
                    <c:forEach var="user" items="${userList}">
                        <div class="user">
                            <form action="SearchFor" method="post">
                                <p>${user.firstName} ${user.lastName}</p>
                                <input type="hidden" name="id" value="${user.id}">
                                <c:choose>
                                    <c:when test="${user.status == -1}">
                                        <button class="sfr" type="submit" name="action" value="sendRequest"><b>Send
                                                Friend
                                                Request</b></button>
                                    </c:when>
                                    <c:when test="${user.status == 1}">
                                        <button class="afr" type="submit" name="action"
                                            value="acceptFriendRequest"><b>Accept
                                                Friend Request</b></button>
                                    </c:when>
                                    <c:otherwise>
                                        <button class="rfr" type="submit" name="action"
                                            value="PullFriendRequest"><b>Pull
                                                Friend Request</b></button>
                                    </c:otherwise>
                                </c:choose>
                            </form>
                        </div>
                    </c:forEach>
                </div>
                <div class="half">
                    <form action="SearchFor" method="post">
                        <input type="text" name="friendInput" placeholder="Friends">
                        <button type="submit" style="padding: 0.5% 1%;" name="action"
                            value="searchFriends">Search</button>
                        <p>${friendString}</p>
                    </form>
                    <c:forEach var="user" items="${friendList}">
                        <div class="user">
                            <form action="SearchFor" method="post">
                                <p class="friendName">${user.firstName} ${user.lastName}</p>
                                <input type="hidden" name="id" value="${user.email}">
                                <div class="friendOptions">
                                    <button class="removeFriend" type="submit" name="action"
                                        value="removeFriend"><b>Remove Friend</b></button>
                                    <button class="messageFriend" type="submit" name="action"
                                        value="message"><b>Message</b></button>
                                </div>
                            </form>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </body>

        </html>