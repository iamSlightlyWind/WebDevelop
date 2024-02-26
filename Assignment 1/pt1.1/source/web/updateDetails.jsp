<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Employee</title>
    </head>
    <body>
        <h1>Update Employee</h1>
        <%
            try {
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String URL = "jdbc:sqlserver://localhost;databaseName=EMPDB;user=sa;password=sa";
                Connection connection = DriverManager.getConnection(URL);
                PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Employees WHERE id = ?");
                pstmt.setInt(1, Integer.parseInt(request.getParameter("id")));
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
        %>
                    <form action="update" method="post">
                        <input type="hidden" name="id" value="<%=rs.getInt(1)%>">
                        First name: <input type="text" name="firstname" value="<%=rs.getString(2)%>"><br>
                        Last name: <input type="text" name="lastname" value="<%=rs.getString(3)%>"><br>
                        Age: <input type="text" name="age" value="<%=rs.getInt(4)%>"><br>
                        <input type="submit" value="Update Employee">
                    </form>
        <%
                }
                connection.close();
            } catch (Exception e) {
                out.print("Error: " + e.getMessage());
            }
        %>
    </body>
</html>