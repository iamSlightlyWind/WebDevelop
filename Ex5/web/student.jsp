<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html>

        <body>
            <table border="1">
                <tr>
                    <th>RollNo</th>
                    <th>Name</th>
                    <th>Mark</th>
                    <th>Action</th>
                </tr>
                <c:forEach items="${students}" var="student">
                    <tr>
                        <td>${student.rollNo}</td>
                        <td>${student.name}</td>
                        <td>${student.mark}</td>
                        <td>
                            <a href="?action=edit&rollNo=${student.rollNo}">Edit</a>
                            <a href="?action=delete&rollNo=${student.rollNo}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </body>

        </html>