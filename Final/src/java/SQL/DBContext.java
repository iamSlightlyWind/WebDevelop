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
            String password = "123";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Final";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getID(String userName) throws SQLException {
        String query = "SELECT id FROM Users WHERE name = '" + userName + "';";
        return Integer.parseInt(getQueryString(query));
    }

    public void deleteUser(String userName) throws SQLException {
        String deletion = "UPDATE Users SET active = 0 WHERE name = '" + userName + "';";
        this.connection.prepareStatement(deletion).executeUpdate();
    }

    public void updateDetails(UserDetails user) throws NumberFormatException, SQLException {
        System.out.println("Got request!");
        int userID = getID(user.userName);
        String firstName = "update UserDetails set firstName = '" + user.firstName + "' where id = " + userID;
        String lastName = "update UserDetails set lastName = '" + user.lastName + "' where id = " + userID;
        String email = "update UserDetails set email = '" + user.email + "' where id = " + userID;
        this.connection.prepareStatement(firstName).executeUpdate();
        this.connection.prepareStatement(lastName).executeUpdate();
        this.connection.prepareStatement(email).executeUpdate();
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
        String detailInsert = "INSERT INTO UserDetails VALUES (" + (lastId + 1) + ", '" + newUser.firstName + "', '"
                + newUser.lastName + "', '" + newUser.email + "')";
        this.connection.prepareStatement(userInsert).executeUpdate();
        this.connection.prepareStatement(detailInsert).executeUpdate();
    }

    public ResultSet searchUserList(int currentUser, String searchString) throws SQLException {
        String query = "SELECT firstName, id FROM UserDetails WHERE id NOT IN (SELECT friendID FROM FriendStatus WHERE userID = "
                + currentUser + " UNION SELECT userID FROM FriendStatus WHERE friendID = " + currentUser + ") AND id != " + currentUser + " AND firstName LIKE '%" + searchString + "%'";
        return getQuery(query);
    }

    public ResultSet searchFriendList(int currentUser, String searchString) throws SQLException {
        String query = "SELECT firstName, id FROM UserDetails WHERE id IN (SELECT friendID FROM FriendStatus WHERE userID = "
                + currentUser + " UNION SELECT userID FROM FriendStatus WHERE friendID = " + currentUser
                + ") AND firstName LIKE '%" + searchString + "%'";
        return getQuery(query);
    }

    public String getName(int id) throws SQLException {
        String query = "SELECT name FROM Users WHERE id = " + id;
        return getQueryString(query);
    }

    public void addFriend(int userID, int friendID) throws SQLException {
        String query = "INSERT INTO FriendStatus VALUES (" + userID + ", " + friendID + ")";
        this.connection.prepareStatement(query).executeUpdate();
    }

    public void removeFriend(int userID, int friendID) throws SQLException {
        String query = "DELETE FROM FriendStatus WHERE (userID = " + userID + " AND friendID = " + friendID + ") OR (userID = " + friendID + " AND friendID = " + userID + ")";
        this.connection.prepareStatement(query).executeUpdate();
    }

    public UserDetails getUserDetails(String user) throws NumberFormatException, SQLException {
        int id = getID(user);
        String pass = getQueryString("select password from Users where name = '" + user + "'");
        String firstName = getQueryString("select firstName from UserDetails where id = " + id);
        String lastName = getQueryString("select lastName from UserDetails where id = " + id);
        String email = getQueryString("select email from UserDetails where id = " + id);

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
