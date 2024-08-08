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
                <input type="hidden" name="form" value="form1.jsp">
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
                </table>
                <button type="submit">SUM</button>
            </form>

            <p>${result}</p>
        </body>

        </html>