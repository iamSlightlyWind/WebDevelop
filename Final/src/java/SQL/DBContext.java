package SQL;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBContext {

    public Connection connection;

    public DBContext() {
        try {
            String username = "sa";
            String password = "sa";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Final";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void registerUser(String userName, String password) throws SQLException{
        String registeration = "insert into Users values ('" + userName + "', '" + password + "', 1)";
        this.connection.prepareStatement(registeration).executeUpdate();
    }

    public ResultSet getQuery(String query) throws SQLException {
        PreparedStatement stmt = this.connection.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        return rs;
    }
    
    public void runQuery(String query) throws SQLException {
        this.connection.prepareStatement(query).executeUpdate();
    }
}
