package Labs;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/add")
public class Add extends HttpServlet {

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
        String a = request.getParameter("first");
        String b = request.getParameter("second");

        if (a == null || a.isEmpty() || b == null || b.isEmpty()) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><head><title>Error</title></head><body>");
            out.println("<p>Please provide both numbers.</p>");
            out.println("</body></html>");
            return;
        }

        int sum = Integer.parseInt(a) + Integer.parseInt(b);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Add</title></head><body>");
        out.println("<p>The sum of " + a + " and " + b + " is " + sum + ".</p>");
        out.println("</body></html>");
    }
}