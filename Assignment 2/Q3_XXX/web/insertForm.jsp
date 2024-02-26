<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Insert Employee</title>
</head>
<body>
    <form action="<%= request.getContextPath() %>/insert" method="post">
        ID <input type="text" name="id"><br>
        Name <input type="text" name="name"><br>
        Gender  <input type="radio" name="gender" value="true"> Male
                <input type="radio" name="gender" value="false"> Female<br>
        DOB <input type="date" name="dob"><br>
        Skills <br>
        <% List<String> skills = (List<String>) request.getAttribute("skills");
           if (skills != null) {
               for (String skill : skills) { %>
                <input type="checkbox" name="skills" value="<%= skill %>"> <%= skill %><br>
        <%     }
           } %>
        <input type="submit" value="Insert">
    </form>
</body>
</html>