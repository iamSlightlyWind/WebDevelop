package Account;

import SQL.DBContext;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class AccountManage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        DBContext db = new DBContext();

        if (action.equals("Logout")) {
            request.getSession().invalidate();
            response.sendRedirect(request.getContextPath() + "/Authentication");
            return;
        }

        if (action.equals("changePassword")) {
            if (db.getPassword((String) request.getSession().getAttribute("user"))
                    .equals(request.getParameter("oldPassword"))) {
                db.changePassword((String) request.getSession().getAttribute("user"),
                        request.getParameter("newPassword"));
                request.setAttribute("changePasswordStatus", "Password changed");
            } else {
                request.setAttribute("changePasswordStatus", "Old password is wrong!");
            }
        }

        if (action.equals("deleteAccount")) {
            db.deleteUser((String) request.getSession().getAttribute("user"));
            request.getSession().invalidate();
            response.sendRedirect(request.getContextPath() + "/Authentication");
            return;
        }

        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/AccountManage.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
