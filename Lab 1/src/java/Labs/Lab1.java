package Labs;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/hello")
public class Lab1 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String[][] array = new String[5][4];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = "[" + i + "," + j + "]";
            }
        }

        out.println("<html><body>");
        out.println("<table border='1'>");

        for (int i = 0; i < 5; i++) {
            out.println("<tr>");

            for (int j = 0; j < 4; j++) {
                out.println("<td>" + array[i][j] + "</td>");
            }

            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body></html>");
    }
}