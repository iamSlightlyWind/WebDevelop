package console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    public User getUser(String userID, String password) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String URL = "jdbc:sqlserver://localhost:1433;databaseName=CarManagement;user=sa;password=sa";
            Connection connection = DriverManager.getConnection(URL);
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tblUsers WHERE userID = ? AND password = ?");
            stmt.setString(1, userID);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setUserID(rs.getString("userID"));
                user.setFullName(rs.getString("fullName"));
                // Set other properties as needed
                return user;
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}