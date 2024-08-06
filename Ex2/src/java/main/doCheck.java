package main;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class doCheck extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fullname = request.getParameter("fullName");
        String subject = request.getParameter("subject");
        String gender = request.getParameter("gender");
        double mark = Double.parseDouble(request.getParameter("mark"));

        String result = "";
        if (mark <= 0 || mark > 10) {
            result = "Invalid mark!";
        } else if (mark >= 5) {
            result = "Congrats " + fullname + ", you have passed the " + subject + " exam with the mark of " + mark
                    + "!";
        } else {
            result = "Good luck next time " + fullname;
        }

        request.setAttribute("result", result);
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
}
