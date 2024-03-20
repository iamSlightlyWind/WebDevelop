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
        DBContext db = new DBContext();
        String action = db.nullCheck(request.getParameter("action"));
        int userID = db.getID((String) request.getSession().getAttribute("user"));

        if (action.equals("sendRequest")) {
            int friendID = Integer.parseInt(request.getParameter("id"));
            db.sendFriendRequest(userID, friendID);
        }

        if (action.equals("acceptFriendRequest")) {
            int friendID = Integer.parseInt(request.getParameter("id"));
            System.out.println("Accepting friend request from " + friendID + " to " + userID);
            db.acceptFriendRequest(userID, friendID);
        }

        if (action.equals("PullFriendRequest")) {
            int friendID = Integer.parseInt(request.getParameter("id"));
            db.PullFriendRequest(userID, friendID);
        }

        if (action.equals("removeFriend")) {
            int friendID = Integer.parseInt(request.getParameter("id"));
            db.removeFriend(userID, friendID);
        }

        ArrayList<UserDetails> userList = new ArrayList();
        ArrayList<UserDetails> friendList = new ArrayList();

        String userString = "";
        String friendString = "";

        if (action.equals("searchUsers")) {
            userString = db.nullCheck(request.getParameter("userInput"));
        } else if (action.equals("searchFriends")) {
            friendString = db.nullCheck(request.getParameter("friendInput"));
        }

        ResultSet userResults = db.searchUserList(userID, userString);
        ResultSet friendResult = db.searchFriendList(userID, friendString);

        while (userResults.next()) {
            if (userResults.getInt("id") != userID) {
                userList.add(new UserDetails(
                        userResults,
                        db.friendStatus(userID, userResults.getInt("id"))));
            }
        }

        while (friendResult.next()) {
            if (friendResult.getInt("id") != userID) {
                friendList
                        .add(new UserDetails(friendResult.getString("firstName"), friendResult.getString("lastName"),
                                friendResult.getInt("id") + "",
                                "notNeeded", "notNeeded"));
            }
        }

        request.setAttribute("userList", userList);
        request.setAttribute("friendList", friendList);

        if (action.equals("message")) {
            int friendID = Integer.parseInt(request.getParameter("id"));
            request.getSession().setAttribute("messageID", friendID);
            request.getSession().setAttribute("messageName", db.getName(friendID));
            response.sendRedirect("./Mess");
        } else {
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
