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

        if (action.equals("searchUsers")) {
            ArrayList<UserDetails> userList = new ArrayList();
            ResultSet results = db.searchUserList(userID, searchString);

            while (results.next()) {
                if (results.getInt("id") != userID) {
                    userList.add(new UserDetails(
                            results,
                            db.friendStatus(userID, results.getInt("id")))
                    );
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
                            .add(new UserDetails(results.getString("firstName"), results.getString("lastName"), results.getInt("id") + "",
                                    "notNeeded", "notNeeded"));
                }
            }
            request.setAttribute("friendList", friendList);
        }

        if (action.equals("sendRequest")) {
            int friendID = Integer.parseInt(request.getParameter("id"));
            db.sendFriendRequest(userID, friendID);
        }

        if (action.equals("acceptFriendRequest")) {
            int friendID = Integer.parseInt(request.getParameter("id"));
            System.out.println("Accepting friend request from " + friendID + " to " + userID);
            db.acceptFriendRequest(userID, friendID);
        }

        if(action.equals("PullFriendRequest")){
            int friendID = Integer.parseInt(request.getParameter("id"));
            db.PullFriendRequest(userID, friendID);
        }

        if (action.equals("removeFriend")) {
            int friendID = Integer.parseInt(request.getParameter("id"));
            db.removeFriend(userID, friendID);
        }

        if (action.equals("message")) {
            int friendID = Integer.parseInt(request.getParameter("id"));
            request.getSession().setAttribute("messageID", friendID);
            request.getSession().setAttribute("messageName", db.getName(friendID));
            response.sendRedirect("./Mess");
        } else try (PrintWriter out = response.getWriter()) {
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
