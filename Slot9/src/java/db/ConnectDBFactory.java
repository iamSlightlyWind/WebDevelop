package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDBFactory {
    private static Connection con;

    public static Connection CreateSqlConnection() throws Exception {
        String user = "sa";
        String pass = "sa";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String dburl = "jdbc:sqlserver://localhost;databaseName=qlsp";
        con = DriverManager.getConnection(dburl, user, pass);
        return con;
    }
}
