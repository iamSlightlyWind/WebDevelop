package Messaging;

import SQL.DBContext;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Account.UserDetails;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Messaging extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        DBContext db = new DBContext();
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        int groupID = db.groupID(
                (Integer) request.getSession().getAttribute("userID"),
                (Integer) request.getSession().getAttribute("messageID"));

        if (action.equals("send")) {
            String message = request.getParameter("message");
            int senderID = (Integer) request.getSession().getAttribute("userID");
            db.sendMessage(message, senderID, groupID);
        }

        ArrayList<Message> messageList = new ArrayList();
        ResultSet results = db.messageList(groupID);

        while (results.next()) {
            messageList.add(new Message(
                    results.getString("senderID"),
                    results.getString("message"),
                    (Integer) request.getSession().getAttribute("userID")));
        }
        request.setAttribute("messageList", messageList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/Message.jsp");
        dispatcher.forward(request, response);
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
