<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <title>TODO supply a title</title>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
        </head>

        <body>
            <form action="doCalc" method="get">
                <input type="hidden" name="form" value="form2.jsp">
                <table>
                    <tr>
                        <td>Enter an integer array:</td>
                        <td><input type="text" name="text" value="${text}"></td>
                    </tr>
                    <tr>
                        <td>Choose an option:</td>
                        <td>
                            <label><input type="radio" name="isOdd" value="true" required>Odd </label>
                            <label><input type="radio" name="isOdd" value="false" required>Even</label>
                        </td>
                    </tr>
                    <tr>
                        <td>Result: </td>
                        <td><input type="text" readonly value="${result}"></td>
                    </tr>
                    <tr>
                        <td>
                            <button type="submit">SUM</button>
                        </td>
                        <td>
                            <b>${error}</b>
                        </td>
                    </tr>
                </table>

            </form>

            <p>List of Executions: </p>
            <table border="1">
                <tr>
                    <th>Array</th>
                    <th>Option</th>
                    <th>Result</th>
                </tr>
                <c:forEach var="item" items="${list}">
                    <tr>
                        <td>${item.text}</td>
                        <td>${item.isOdd}</td>
                        <td>${item.result}</td>
                    </tr>
                </c:forEach>
            </table>
        </body>

        </html>