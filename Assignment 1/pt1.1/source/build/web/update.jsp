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
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Employees");
                while (rs.next()) {
                    int id = rs.getInt(1);
        %>
        <form action="updateDetails.jsp" method="post">
            <input type="hidden" name="id" value="<%=id%>">
            <input type="submit" value="Update Employee <%=id%>">
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
