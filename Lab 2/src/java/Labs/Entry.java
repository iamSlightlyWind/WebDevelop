package Labs;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/entry")
public class Entry extends HttpServlet {

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

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Add</title></head><body>");
        out.println("<p>Username: " + request.getParameter("username") + "</p>");
        out.println("<p>Password: " + request.getParameter("user-password") + "</p>");
        out.println("<p>Gender: " + request.getParameter("sex") + "</p>");
        out.println("<p>Hobbies:</p>");

        String[] sports = request.getParameterValues("sports");
        out.println("<ul>");
        if (sports != null) {
            for (String sport : sports) {
                out.println("<li>" + sport + "</li>");
            }
        }
        out.println("</ul>");

        out.println("<p>Address: " + request.getParameter("address") + "</p>");
        out.println("<p>City: " + request.getParameter("city") + "</p>");
        out.println("</body></html>");
    }
}