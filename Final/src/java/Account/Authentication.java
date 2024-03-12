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
        boolean completed = false;

        try (PrintWriter out = response.getWriter()) {
            DBContext db = new DBContext();
            ResultSet rs = db.getQuery("select * from Users");

            while (rs.next()) {
                if (!user) {
                    if (rs.getString("name").equals(userName)) {
                        user = true;
                        if (rs.getString("password").equals(password)) {
                            if (rs.getString("active").equals("1")) {
                                completed = true;
                            }
                        }
                        break;
                    }
                }
            }

            if (accountAction.equals("Login")) {
                if (completed) {
                    request.setAttribute("accountStatus", "Login successful");
                } else {
                    request.setAttribute("accountStatus", "Login failed");
                }
            } else {
                if (!user) {
                    request.setAttribute("accountStatus", "Register successful");
                    completed = true;

                    UserDetails newUser = new UserDetails(
                            request.getParameter("firstName"),
                            request.getParameter("lastName"),
                            request.getParameter("email"),
                            request.getParameter("userName"),
                            request.getParameter("password"));

                    db.registerUser(newUser);

                } else if (user) {
                    completed = false;
                    request.setAttribute("accountStatus", "Register failed");
                }
            }

            if (completed) {
                request.getSession().setAttribute("user", userName);
                response.sendRedirect("./AccountManage");
            }

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/" + accountAction + ".jsp");
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
