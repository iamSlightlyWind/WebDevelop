package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class doCalc extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String text = request.getParameter("text");
        boolean isOdd = request.getParameter("isOdd").equals("true");
        String form = request.getParameter("form");
        Calc current = null;

        try {
            current = new Calc(text, isOdd);
            request.setAttribute("result", current.result);
            if (form.equals("form2.jsp")) {
                if (!addCalc(current, request)) {
                    request.setAttribute("error", "Execution existed!");
                    request.setAttribute("result", "");
                }
            }
        } catch (NullPointerException e) {
            request.setAttribute("result", "invalid input");
        }

        request.setAttribute("list", request.getSession().getAttribute("history"));
        request.setAttribute("text", text);
        request.getRequestDispatcher(form + "").forward(request, response);

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
