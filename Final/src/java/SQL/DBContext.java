package SQL;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import Account.UserDetails;

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

    public void deleteUser(String userName) throws SQLException {
        String deletion = "UPDATE Users SET active = 0 WHERE name = '" + userName + "';";
        this.connection.prepareStatement(deletion).executeUpdate();
    }

    public void changePassword(String userName, String password) throws SQLException {
        String deletion = "UPDATE Users SET password = '" + password + "' WHERE name = '" + userName + "';";
        this.connection.prepareStatement(deletion).executeUpdate();
    }

    public String getPassword(String userName) throws SQLException {
        String password = "SELECT password FROM Users WHERE name = '" + userName + "';";
        return getQueryString(password);
    }

    public void registerUser(UserDetails newUser) throws SQLException {
        String getLastId = getQueryString("SELECT MAX(id) FROM Users");
        int lastId = getLastId == null ? 0 : Integer.parseInt(getLastId);
        String userInsert = "INSERT INTO Users VALUES ('" + newUser.userName + "', '" + newUser.password + "', 1)";
        String detailInsert = "INSERT INTO UserDetails VALUES (" + (lastId + 1) + ", '" + newUser.firstName + "', '" + newUser.lastName + "', '" + newUser.email + "')";
        this.connection.prepareStatement(userInsert).executeUpdate();
        this.connection.prepareStatement(detailInsert).executeUpdate();
    }

    public UserDetails getUserDetails(String user) throws NumberFormatException, SQLException{
        int userID = Integer.parseInt(getQueryString("select ID from Users where name = '" + user + "'"));
        String pass = getQueryString("select password from Users where name = '" + user + "'");
        String firstName = getQueryString("select firstName from UserDetails where id = " + userID);
        String lastName = getQueryString("select lastName from UserDetails where id = " + userID);
        String email = getQueryString("select email from UserDetails where id = " + userID);
        
        UserDetails currentUser = new UserDetails(firstName, lastName, email, user, pass);

        return currentUser;
    }

    public ResultSet getQuery(String query) throws SQLException {
        PreparedStatement stmt = this.connection.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        return rs;
    }

    public String getQueryString(String query) throws SQLException {
        PreparedStatement stmt = this.connection.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        String result = "";
        while (rs.next()) {
            result = rs.getString(1);
        }
        return result;
    }

    public void runQuery(String query) throws SQLException {
        this.connection.prepareStatement(query).executeUpdate();
    }
}
