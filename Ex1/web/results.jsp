<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
        </head>

        <body>
            <p>result: </p>
            <c:forEach var="result" items="${results}">
                <p>${result}</p>
            </c:forEach>
        </body>

        </html>