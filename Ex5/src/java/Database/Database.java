package Database;

import Main.Student;
import Main.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    public static Connection connection;

    static {
        try {
            String username = "sa";
            String password = System.getenv("SQLPASSWORD") != null ? System.getenv("SQLPASSWORD") : "123";
            String database = "StudentDB";

            String url = "jdbc:sqlserver://localhost:1433;databaseName=" + database;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Student> getAll() {
        ArrayList<Student> list = new ArrayList<Student>();
        String sql = "select * from Student";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Student s = new Student(rs.getString("rollNo"), rs.getString("name"), rs.getFloat("mark"));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public static Student findStudentByRollNo(String rollNo) {
        String sql = "select * from Student where RollNo = ?";
        Student s = null;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, rollNo);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                s = new Student();
                s.setRollNo(rs.getString("rollNo"));
                s.setName(rs.getString("name"));
                s.setMark(rs.getFloat("mark"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return s;
    }

    public static void insert(Student student) {
        String sql = "INSERT INTO Student (RollNo, Name, Mark) VALUES (?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, student.getRollNo());
            ps.setString(2, student.getName());
            ps.setFloat(3, student.getMark());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void deleteStudent(String roll) {
        String sql = "DELETE from student where RollNo = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, roll);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void editStudent(Student st) {
        String sql = "UPDATE STUDENT SET name = ?, mark = ? where RollNo = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, st.getName());
            ps.setFloat(2, st.getMark());
            ps.setString(3, st.getRollNo());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static int login(User current) {
        String sql = "select role from Account where username = ? and password = ?";
        int role = -1;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, current.username);
            st.setString(2, current.password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                role = rs.getInt("role");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return role;
    }

    public static int register (User current){
        String sql = "{call register(?,?,?,?)}";
        int result = -1;
        try {
            CallableStatement st = connection.prepareCall(sql);
            st.setString(1, current.username);
            st.setString(2, current.password);
            st.setInt(3, current.role);
            st.registerOutParameter(4, Types.INTEGER);
            st.execute();
            result = st.getInt(4);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }
}
