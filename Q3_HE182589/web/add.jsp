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
        <form>
            <div class="half">
                <label>Paper ID: </label><br>
                <label>Title: </label><br>
                <label>Title: </label><br>
            </div>
            <div class="half">
                <input type="text" name="paperID"><br>
                <input type="text" name="paperID"><br>
                <input type="text" name="paperID">(yyyy-MM-dd)<br>
            </div>
            <c:forEach>
                
            </c:forEach>
        </form>
    </body>
</html>
