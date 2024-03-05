package Account;

import SQL.DBContext;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import java.util.logging.*;

public class AccountManage extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String accountAction = request.getParameter("action");
        boolean user = false;
        boolean pass = false;
        
        try (PrintWriter out = response.getWriter()) {
            DBContext db = new DBContext();
            ResultSet rs = db.getQuery("select * from Users");
            
            while (rs.next()) {
                if (!user) {
                    if (rs.getString("name").equals(userName)) {
                        user = true;
                        if (rs.getString("password").equals(password)) {
                            pass = true;
                        }
                        break;
                    }
                }
            }
            
            /* request.setAttribute("accountStatus", userName + " " + password); */
            
            if (accountAction.equals("login")) {
                if (user && pass) {
                    request.setAttribute("accountStatus", "Login successful");
                } else {
                    request.setAttribute("accountStatus", "Login failed");
                }
            } else {
                if (user == false) {
                    db.runQuery("insert into Users values ('" + userName + "', '" + password + "')");
                    request.setAttribute("accountStatus", "Register sucessfully");
                } /* else if (user == true) {
                    request.setAttribute("accountStatus", "Register failed");
                } */
            }
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AccountManage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AccountManage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Search servlet";
    }
}
