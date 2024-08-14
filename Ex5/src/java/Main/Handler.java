package Main;

import Database.Database;
import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Handler extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("role") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "update":
                    update(request, response);
                    viewAll(request, response);
                    break;
                case "edit":
                    edit(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    viewAll(request, response);
                    break;
            }
        } else
            viewAll(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rollNo = request.getParameter("rollNo");
        String name = request.getParameter("name");
        float mark = Float.parseFloat(request.getParameter("mark"));

        Student current = new Student(rollNo, name, mark);
        System.out.println(current);
        Database.editStudent(current);
    }

    protected void viewAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Student> list = Database.getAll();

        request.setAttribute("students", list);
        request.setAttribute("role", Integer.parseInt(request.getSession().getAttribute("role").toString()));
        request.getRequestDispatcher("student.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rollNo = request.getParameter("rollNo");
        Student current = Database.findStudentByRollNo(rollNo);
        System.out.println(current);
        request.setAttribute("student", current);
        request.getRequestDispatcher("modify.jsp").forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rollNo = request.getParameter("rollNo");
        Database.deleteStudent(rollNo);
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
