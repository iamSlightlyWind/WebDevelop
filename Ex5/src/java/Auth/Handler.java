package Auth;

import java.io.IOException;

import Main.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Handler extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "login":
                login(request, response);
                break;
            case "register":
                register(request, response);
                break;
            case "logout":
                request.getSession().invalidate();
                response.sendRedirect("login.jsp");
                break;
        }
    }

    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User current = new User(username, password);

        switch (current.login()) {
            case 1:
            case 2:
                request.getSession().setAttribute("user", current);
                request.getSession().setAttribute("role", current.role);
                response.sendRedirect("view");
                break;
            case -1:
                request.setAttribute("status", "Invalid username or password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
        }
    }

    protected void register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int role = Integer.parseInt(request.getParameter("role"));
        User current = new User(username, password, role);

        switch (current.register()) {
            case 1:
                request.setAttribute("status", "Registration successful");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
            case -1:
                request.setAttribute("status", "Username already in use");
                request.getRequestDispatcher("register.jsp").forward(request, response);
                break;
        }
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
