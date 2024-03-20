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

    public int groupID(int user1ID, int user2ID) throws SQLException {
        String query = "select groupID from MessageGroup where user1ID = " + user1ID + " and user2ID = " + user2ID;
        String result = getQueryString(query);
        int id;
        if (result.equals("")) {
            query = "select groupID from MessageGroup where user1ID = " + user2ID + " and user2ID = " + user1ID;
            result = getQueryString(query);
            if (result.equals("")) {
                try {
                    id = Integer.parseInt(getQueryString("select max(groupID) from MessageGroup")) + 1;
                } catch (NumberFormatException e) {
                    id = 1;
                }
                query = "insert into MessageGroup values (" + id + ", " + user1ID + ", " + user2ID + ")";
                this.connection.prepareStatement(query).executeUpdate();
                return id;
            }
        }

        return Integer.parseInt(result);
    }

    public String getName(int id) throws SQLException {
        String query = "SELECT name FROM Users WHERE id = " + id;
        return getQueryString(query);
    }

    public ResultSet searchFriendList(int currentUser, String searchString) throws SQLException {
        String query = "SELECT firstName, id FROM UserDetails WHERE id IN (SELECT friendID FROM FriendStatus WHERE userID = ? AND status = 1 UNION SELECT userID FROM FriendStatus WHERE friendID = ? AND status = 1) AND firstName LIKE ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, currentUser);
        statement.setInt(2, currentUser);
        statement.setString(3, "%" + searchString + "%");
        return statement.executeQuery();
    }

    public ResultSet searchUserList(int currentUser, String searchString) throws SQLException {
        String query = "SELECT firstName, lastName, id FROM UserDetails WHERE id NOT IN (SELECT friendID FROM FriendStatus WHERE userID = ? AND status = 1 UNION SELECT userID FROM FriendStatus WHERE friendID = ? AND status = 1) AND id != ? AND firstName LIKE ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, currentUser);
        statement.setInt(2, currentUser);
        statement.setInt(3, currentUser);
        statement.setString(4, "%" + searchString + "%");
        return statement.executeQuery();
    }

    public void sendFriendRequest(int userID, int friendID) throws SQLException {
        String checkQuery = "SELECT * FROM FriendStatus WHERE (userID = ? AND friendID = ?) OR (userID = ? AND friendID = ?)";
        PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
        checkStatement.setInt(1, userID);
        checkStatement.setInt(2, friendID);
        checkStatement.setInt(3, friendID);
        checkStatement.setInt(4, userID);
        ResultSet rs = checkStatement.executeQuery();
        if (!rs.next()) {
            String insertQuery = "INSERT INTO FriendStatus VALUES (?, ?, 0)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setInt(1, userID);
            insertStatement.setInt(2, friendID);
            insertStatement.executeUpdate();
        }
    }

    public void acceptFriendRequest(int userID, int friendID) throws SQLException {
        String query = "UPDATE FriendStatus SET status = 1 WHERE userID = ? AND friendID = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, friendID);
        statement.setInt(2, userID);
        statement.executeUpdate();
    }

    public void PullFriendRequest(int userID, int friendID) throws SQLException {
        String query = "DELETE FROM FriendStatus WHERE userID = ? AND friendID = ? AND status != 1";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, userID);
        statement.setInt(2, friendID);
        statement.executeUpdate();
    }

    public int friendStatus(int userID, int friendID) throws SQLException {
        String query = "SELECT userID, status FROM FriendStatus WHERE (userID = ? AND friendID = ?) OR (userID = ? AND friendID = ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, userID);
        statement.setInt(2, friendID);
        statement.setInt(3, friendID);
        statement.setInt(4, userID);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            if (rs.getInt("userID") == userID) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return -1;
        }
    }

    public void removeFriend(int userID, int friendID) throws SQLException {
        String query = "DELETE FROM FriendStatus WHERE (userID = " + userID + " AND friendID = " + friendID
                + ") OR (userID = " + friendID + " AND friendID = " + userID + ")";
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

    public ResultSet messageList(int groupID) throws SQLException {
        String query = "SELECT * FROM Messages WHERE groupID = ? ORDER BY time ASC";
        PreparedStatement stmt = this.connection.prepareStatement(query);
        stmt.setInt(1, groupID);
        return stmt.executeQuery();
    }

    public void sendMessage(String message, int senderID, int groupID) throws SQLException {
        String query = "EXEC InsertMessage ?, ?, ?";
        PreparedStatement stmt = this.connection.prepareStatement(query);
        stmt.setInt(1, groupID);
        stmt.setInt(2, senderID);
        stmt.setString(3, message);
        stmt.executeUpdate();
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
}