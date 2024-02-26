package console;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Enroll extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String financialSource = request.getParameter("financialSource");
        String level = request.getParameter("level");
        String doe = request.getParameter("doe");

        request.setAttribute("name", name);
        request.setAttribute("financialSource", financialSource);
        request.setAttribute("level", level);
        request.setAttribute("doe", doe);

        request.getRequestDispatcher("enroll.jsp").forward(request, response);
    }
}