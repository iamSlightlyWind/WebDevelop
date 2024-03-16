package SQLManage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBContext {

    public Connection connection;

    public DBContext() {
        try {
            String username = "sa";
            String password = "123";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=PT2";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet authorList() throws SQLException {
        String query = "select * from Author";
        return getQuery(query);
    }

    public ResultSet getPaper(int authorID) throws SQLException {
        String query = "SELECT Paper.* FROM Paper INNER JOIN Author_Paper ON Paper.PaperID = Author_Paper.PaperID WHERE Author_Paper.AuthorID = " + authorID;
        return getQuery(query);
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
