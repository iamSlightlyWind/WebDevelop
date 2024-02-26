package dal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Search extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String query = request.getParameter("query");
        try (PrintWriter out = response.getWriter()) {
            
            DBContext dbContext = new DBContext();
            Connection connection = dbContext.connection;
            PreparedStatement stmt;
            
            if (query == null || query.isEmpty()) {
                stmt = connection.prepareStatement("SELECT * FROM Student");
            } else {
                stmt = connection.prepareStatement("SELECT * FROM Student WHERE name LIKE ?");
                stmt.setString(1, "%" + query + "%");
            }
            ResultSet rs = stmt.executeQuery();

            out.println("<h1>Search Results:</h1>");

            while (rs.next()) {
                out.println("<p>ID: " + rs.getString("id") + ", Name: " + rs.getString("name") + "</p>");
            }

            out.println("</body>");
            out.println("</html>");

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
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
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Search servlet";
    }

}