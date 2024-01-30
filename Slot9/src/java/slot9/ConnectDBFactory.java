package slot9;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDBFactory {
    private static Connection con;

    public static Connection CreateSqlConnection() throws Exception {
        String user = "sa";
        String pass = "123";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String dburl = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=qlsp";
        con = DriverManager.getConnection(dburl, user, pass);
        return con;
    }
}
