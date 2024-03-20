package Account;

import SQL.DBContext;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class AccountManage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        DBContext db = new DBContext();
        String action = db.nullCheck(request.getParameter("action"));

        if (action.equals("Logout")) {
            request.getSession().invalidate();
            response.sendRedirect(request.getContextPath() + "/Login");
            return;
        }

        if (action.equals("Save")) {
            db.updateDetails(new UserDetails(
                    request.getParameter("firstName"),
                    request.getParameter("lastName"),
                    request.getParameter("email"),
                    (String) request.getSession().getAttribute("user"),
                    "asd"));
        }

        if (action.equals("Change")) {
            if (db.getPassword((String) request.getSession().getAttribute("user"))
                    .equals(request.getParameter("oldPassword"))) {
                db.changePassword((String) request.getSession().getAttribute("user"),
                        request.getParameter("newPassword"));
                request.setAttribute("changePasswordStatus", "Password changed");
            } else {
                request.setAttribute("changePasswordStatus", "Old password is wrong!");
            }
        }

        if (action.equals("Delete")) {
            db.deleteUser((String) request.getSession().getAttribute("user"));
            request.getSession().invalidate();
            response.sendRedirect(request.getContextPath() + "/Login");
            return;
        }

        UserDetails currentUser = db.getUserDetails((String) request.getSession().getAttribute("user"));

        request.setAttribute("firstName", currentUser.firstName);
        request.setAttribute("lastName", currentUser.lastName);
        request.setAttribute("email", currentUser.email);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/AccountManage.jsp");
        dispatcher.forward(request, response);
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
