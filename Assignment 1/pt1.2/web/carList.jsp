<!DOCTYPE html>
<html>
    <head>
        <title>Car List</title>
    </head>
    <body>
        <h1>Welcome, ${user.fullName}!</h1>
        <form action="CarListServlet" method="get">
            <input type="text" name="search" placeholder="Search for cars...">
            <input type="submit" value="Search">
        </form>
        <table>
            <tr>
                <th>Car ID</th>
                <th>Car Name</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="car" items="${cars}">
                <tr>
                    <td>${car.carID}</td>
                    <td>${car.carName}</td>
                    <td>
                        <a href="CarListServlet?action=delete&carID=${car.carID}">Delete</a> |
                        <a href="#" onclick="document.getElementById('updateForm${car.carID}').style.display = 'block'">Update</a>
                        <div id="updateForm${car.carID}" style="display:none">
                            <form action="CarListServlet" method="post">
                                <input type="hidden" name="action" value="update">
                                <input type="hidden" name="carID" value="${car.carID}">
                                New Car Name: <input type="text" name="carName">
                                <input type="submit" value="Update">
                            </form>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>