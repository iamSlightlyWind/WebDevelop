<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" href="./Search/style.css">
            <title>Search</title>
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
                        <input type="text" name="input" placeholder="Users">
                        <button type="submit" name="action" value="searchUsers">Search</button>
                        <p>${searchString}</p>
                    </form>
                    <c:forEach var="user" items="${userList}">
                        <div class="user">
                            <form action="SearchFor" method="post">
                                <p>${user.firstName}</p>
                                <input type="hidden" name="id" value="${user.lastName}">
                                <button class="addFriend" type="submit" name="action" value="addFriend">Add
                                    Friend</button>
                            </form>
                        </div>
                    </c:forEach>
                </div>
                <div class="half">
                    <form action="SearchFor" method="post">
                        <input type="text" name="input" placeholder="Friends">
                        <button type="submit" name="action" value="searchFriends">Search</button>
                        <p>${searchString}</p>
                    </form>
                    <c:forEach var="user" items="${friendList}">
                        <div class="user">
                            <form action="SearchFor" method="post">
                                <p>${user.firstName}</p>
                                <input type="hidden" name="id" value="${user.lastName}">
                                <div class="friendOptions">
                                    <button class="removeFriend" type="submit" name="action" value="removeFriend">Remove
                                        Friend</button>
                                    <button class="messageFriend" type="submit" name="action"
                                        value="message">Message</button>
                                </div>
                            </form>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </body>

        </html>