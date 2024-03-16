<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        .half {
            display: inline-block;
            width: fit-content;
        }
    </style>
    <body>
        <form action="add" method="get">
            <div class="half">
                <label>Paper ID: </label><br>
                <label>Title: </label><br>
                <label>Date: </label><br>
            </div>
            <div class="half">
                <input type="text" name="paperID"><br>
                <input type="text" name="title"><br>
                <input type="text" name="date">(yyyy-MM-dd)
            </div>
            <br>
            <c:forEach var="author" items="${authorList}">
                <input type="checkbox" name="id" value="${author.id}">${author.name}<br>
            </c:forEach>
            <button type="submit" name="action" value="add">Save</button>
        </form>
    </body>
</html>
