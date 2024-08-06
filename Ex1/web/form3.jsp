<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <script>
                function onlyOne(checkbox) {
                    var checkboxes = document.getElementsByName('action');
                    checkboxes.forEach((item) => {
                        if (item !== checkbox) item.checked = false;
                    });
                }
            </script>
        </head>

        <body>
            <form action="doCalc" method="get">
                <input type="hidden" name="form" value="3">
                <p>Enter a <input type="number" name="a" id="a" step="0.1"></p>
                <p>Enter b <input type="number" name="b" id="b" step="0.1"></p>
                <p>
                    Select operation:
                    <br>
                    <input type="checkbox" name="action" value="+" onclick="onlyOne(this)"> Add
                    <br>
                    <input type="checkbox" name="action" value="-" onclick="onlyOne(this)"> Minus
                    <br>
                    <input type="checkbox" name="action" value="*" onclick="onlyOne(this)"> Multiply
                    <br>
                    <input type="checkbox" name="action" value="/" onclick="onlyOne(this)"> Divide
                    <br>
                    <input type="checkbox" name="action" value="lg" onclick="onlyOne(this)"> UCLN
                    <br>
                    <input type="checkbox" name="action" value="sm" onclick="onlyOne(this)"> BCNN
                    <br>
                    <input type="checkbox" name="action" value="prime" onclick="onlyOne(this)"> Prime
                    <br>
                    <input type="checkbox" name="action" value="perfect" onclick="onlyOne(this)"> Perfect
                    <br>
                    <input type="checkbox" name="action" value="square" onclick="onlyOne(this)"> Square
                </p>
                <br>
                <button type="submit">Calculate</button>
                <button type="reset">Reset</button>
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