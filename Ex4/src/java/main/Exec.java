package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Exec extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String array = request.getParameter("array");
        String operation = request.getParameter("option");
        String action = request.getParameter("action");

        Calc current = new Calc(array, operation);
        System.out.println(current.values);
        System.out.println(current.results);

        if (action.equals("exec1")) {
            printAnswer(request, response, current);
        } else {
            if (!current.error.equals("") || current.results.size() == 0) {
                request.setAttribute("error", current.error);
            } else if (addCalc(current, request)) {
                request.setAttribute("result", current.results);
            } else {
                request.setAttribute("error", "Execution existed");
            }

            ArrayList<Calc> history = (ArrayList<Calc>) request.getSession().getAttribute("history");
            request.setAttribute("text", current.text);
            request.setAttribute("result", current.getResults());
            request.setAttribute("history", history);
            request.getRequestDispatcher("MyExcution.jsp").forward(request, response);
        }
    }

    public boolean addCalc(Calc current, HttpServletRequest request) {
        ArrayList<Calc> history = (ArrayList<Calc>) request.getSession().getAttribute("history");

        if (history == null) {
            history = new ArrayList<Calc>();
        }

        for (Calc h : history) {
            if (h.isEquals(current)) {
                return false;
            }
        }

        history.add(current);
        request.getSession().setAttribute("history", history);
        return true;
    }

    public void printAnswer(HttpServletRequest request, HttpServletResponse response, Calc current) throws IOException {
        PrintWriter out = response.getWriter();
        String result;
        if (current.error.equals("")) {
            result = "a = " + current.text + " -> output: ";

            for (Integer i : current.results) {
                result += i + " ";
            }

            out.println(result);
        } else {
            out.println(current.error);
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