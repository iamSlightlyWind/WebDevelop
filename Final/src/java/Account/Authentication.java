package Account;

import SQL.DBContext;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import java.util.logging.*;

public class Authentication extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String accountAction = request.getParameter("action");
        boolean user = false;
        boolean pass = false;
        boolean completed = false;

        try (PrintWriter out = response.getWriter()) {
            DBContext db = new DBContext();
            ResultSet rs = db.getQuery("select * from Users");

            while (rs.next()) {
                if (!user) {
                    if (rs.getString("name").equals(userName)) {
                        user = true;
                        if (rs.getString("password").equals(password)) {
                            pass = true;
                            if(rs.getString("active").equals("1")){
                                completed = true;
                            }
                        }
                        break;
                    }
                }
            }

            if (accountAction.equals("Login")) {
                if (user && pass) {
                    request.setAttribute("accountStatus", "Login successful");
                } else {
                    request.setAttribute("accountStatus", "Login failed");
                }
            } else {
                if (!user) {
                    db.registerUser(userName, password);
                    request.setAttribute("accountStatus", "Register sucessfully");
                    completed = true;
                } else if (user) {
                    request.setAttribute("accountStatus", "Register failed");
                }
            }

            if (completed) {
                request.getSession().setAttribute("user", userName);
            }

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Authentication.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Search servlet";
    }
}
