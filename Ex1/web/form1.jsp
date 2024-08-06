<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
        </head>

        <body>
            <form action="doCalc" method="get">
                <input type="hidden" name="form" value="1">
                <p>Enter a <input type="text" name="a" id="a"></p>
                <p>Enter b <input type="text" name="b" id="b"></p>
                <br>
                <button type="submit" name="action" value="+">a+b</button>
                <button type="submit" name="action" value="-">a-b</button>
                <button type="submit" name="action" value="*">a*b</button>
                <button type="submit" name="action" value="/">a/b</button>
                <button type="submit" name="action" value="ld">UCLN</button>
                <button type="submit" name="action" value="sm">BCNN</button>
                <button type="submit" name="action" value="prime">Prime</button>
                <button type="submit" name="action" value="perfect">Perfect</button>
                <button type="submit" name="action" value="square">Square</button>
            </form>

            <c:if test="${result != -1 or not empty results}">
                <p>result:</p>
                <c:if test="${result != -1}">
                    <p>${result}</p>
                </c:if>
                <c:forEach var="res" items="${results}">
                    <p>${res}</p>
                </c:forEach>
            </c:if>
        </body>

        </html>