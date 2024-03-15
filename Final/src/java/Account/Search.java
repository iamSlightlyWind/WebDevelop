package Account;

import SQL.DBContext;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Search extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        DBContext db = new DBContext();
        int userID = db.getID((String) request.getSession().getAttribute("user"));

        String searchString = request.getParameter("input");
        String search = "";

        if (action.equals("searchUsers")) {
            ArrayList<UserDetails> userList = new ArrayList();
            ResultSet results = db.searchUserList(userID, searchString);

            while (results.next()) {
                if (results.getInt("id") != userID) {
                    userList.add(new UserDetails(results.getString("firstName"), results.getInt("id") + "", "notNeeded",
                            "notNeeded", "notNeeded"));
                }
            }
            request.setAttribute("userList", userList);
        }

        if (action.equals("searchFriends")) {
            ArrayList<UserDetails> friendList = new ArrayList();
            ResultSet results = db.searchFriendList(userID, searchString);

            while (results.next()) {
                if (results.getInt("id") != userID) {
                    friendList
                            .add(new UserDetails(results.getString("firstName"), results.getInt("id") + "", "notNeeded",
                                    "notNeeded", "notNeeded"));
                }
            }
            request.setAttribute("friendList", friendList);
        }

        if (action.equals("addFriend")) {
            int friendID = Integer.parseInt(request.getParameter("id"));
            db.addFriend(userID, friendID);
        }

        if (action.equals("removeFriend")) {
            int friendID = Integer.parseInt(request.getParameter("id"));
            db.removeFriend(userID, friendID);
        }

        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Search.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ServletException | IOException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ServletException | IOException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
