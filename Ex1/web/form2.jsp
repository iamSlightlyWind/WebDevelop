<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
        </head>

        <body>
            <form action="doCalc" method="get">
                <input type="hidden" name="form" value="2">
                <p>Enter a <input type="number" name="a" id="a"></p>
                <p>Enter b <input type="number" name="b" id="b"></p>
                <p>
                    Select operation:
                    <select name="action" id="action">
                        <option value="+">Add</option>
                        <option value="-">Minus</option>
                        <option value="*">Multiply</option>
                        <option value="/">Divide</option>
                        <option value="lg">UCLN</option>
                        <option value="sm">BCNN</option>
                        <option value="prime">Prime</option>
                        <option value="perfect">Perfect</option>
                        <option value="square">Square</option>
                    </select>
                </p>
                <br>
                <button type="submit">Calculate</button>
                <button type="reset">Reset</button>

                <c:if test="${result != -1 or not empty results}">
                    <p>result:</p>
                    <c:if test="${result != -1}">
                        <p>${result}</p>
                    </c:if>
                    <c:forEach var="res" items="${results}">
                        <p>${res}</p>
                    </c:forEach>
                </c:if>
            </form>
        </body>

        </html>