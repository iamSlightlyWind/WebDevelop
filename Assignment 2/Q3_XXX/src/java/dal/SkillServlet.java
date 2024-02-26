package dal;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SkillServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DBContext db = new DBContext();
        try {
            Statement stmt = db.connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Skill");
            List<String> skills = new ArrayList<>();
            while (rs.next()) {
                skills.add(rs.getString("name"));
            }
            request.setAttribute("skills", skills);
            request.getRequestDispatcher("/insertForm.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DBContext db = new DBContext();
        try {
            String sql = "INSERT INTO Employee (id, name, gender, dob) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = db.connection.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(request.getParameter("id")));
            stmt.setString(2, request.getParameter("name"));
            stmt.setBoolean(3, Boolean.parseBoolean(request.getParameter("gender")));
            stmt.setDate(4, java.sql.Date.valueOf(request.getParameter("dob")));
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new employee was inserted successfully!");
            } else {
                System.out.println("Failed to insert employee.");
            }

            
            String[] skills = request.getParameterValues("skills");
            if (skills != null) {
                sql = "SELECT id FROM Skill WHERE name = ?";
                PreparedStatement selectStmt = db.connection.prepareStatement(sql);
                sql = "INSERT INTO Employee_Skill (eid, sid) VALUES (?, ?)";
                stmt = db.connection.prepareStatement(sql);
                for (String skill : skills) {
                    selectStmt.setString(1, skill);
                    ResultSet rs = selectStmt.executeQuery();
                    if (rs.next()) {
                        stmt.setInt(1, Integer.parseInt(request.getParameter("id")));
                        stmt.setInt(2, rs.getInt("id"));
                        stmt.executeUpdate();
                    }
                }
            }
            
            response.sendRedirect(request.getContextPath() + "/insert");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "Skill Servlet";
    }
}
