<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
        </head>

        <body>
            <form action="exe" method="get">
                <table>
                    <tr>
                        <td>Enter an integer array:</td>
                        <td><input type="text" name="array" value="${text}" /></td>
                    </tr>
                    <tr>
                        <td>Choose an option:</td>
                        <td>
                            <input type="radio" name="option" value="perfect" />Perfects
                            <input type="radio" name="option" value="prime" />Primes
                        </td>
                    </tr>
                    <tr>
                        <td>Result:</td>
                        <td><input type="text" name="result" value="${result}"/></td>
                    </tr>
                    <tr>
                        <td>
                            <button type="submit" name="action" value="exec2">Execute</button>
                        </td>
                        <td>
                            <b>${error}</b>
                        </td>
                    </tr>
                </table>
            </form>

            <br>

            <p>List of Executions: </p>
            <table border="1">
                <tr>
                    <th>Array</th>
                    <th>Option</th>
                    <th>Result</th>
                </tr>
                <c:forEach var="item" items="${history}">
                    <tr>
                        <td>${item.text}</td>
                        <td>${item.operation}</td>
                        <td>${item.results}</td>
                    </tr>
                </c:forEach>
            </table>
        </body>

        </html>