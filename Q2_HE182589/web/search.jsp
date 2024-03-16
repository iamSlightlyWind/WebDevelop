<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }
        </style>
    </head>
    <body>
        <form action="search" method="post">
            <label>Authors: </label>
            <select name="selectedAuthorId">
                <c:forEach var="author" items="${authorList}">
                    <c:set var="selected" value="${author.id eq param.selectedAuthorId ? 'selected' : ''}" />
                    <option value="${author.id}" ${selected}>${author.name}</option>
                </c:forEach>
            </select>
            <button type="submit" name="action" value="search">Search</button>
        </form>

        <table>
            <tr>
                <th>Paper ID</th>
                <th>Title</th>
                <th>Published Date</th>
            </tr>
            <c:forEach var="paper" items="${paperList}">
                <tr>
                    <th>${paper.id}</th>
                    <th>${paper.title}</th>
                    <th>${paper.date}</th>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
