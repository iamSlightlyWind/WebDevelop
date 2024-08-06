package main;

import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class doCalc extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        String form = request.getParameter("form");

        if (action == null) {
            request.setAttribute("result", -1);
            request.getRequestDispatcher("form" + form + ".jsp").forward(request, response);
            return;
        }

        double a = 0;
        double b = 0;
        double result = -1;
        ArrayList<Double> results = new ArrayList<Double>();

        try {
            a = Double.parseDouble(request.getParameter("a"));
            b = Double.parseDouble(request.getParameter("b"));
        } catch (NumberFormatException e) {
            request.setAttribute("result", "Invalid input");
            request.getRequestDispatcher("form" + form + ".jsp").forward(request, response);
            return;
        }

        switch (action) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            case "ld":
                result = 1;
                for (int i = 2; i <= Math.min(a, b); i++) {
                    if (a % i == 0 && b % i == 0) {
                        result = i;
                    }
                }
                break;
            case "sm":
                result = Math.max(a, b);
                while (result % a != 0 || result % b != 0) {
                    result++;
                }
                break;
            case "prime":
                if (checkBoundaries(a, b, request, response)) {
                    for (int i = (int) a; i <= b; i++) {
                        boolean isPrime = true;
                        for (int j = 2; j <= Math.sqrt(i); j++) {
                            if (i % j == 0) {
                                isPrime = false;
                                break;
                            }
                        }
                        if (isPrime) {
                            results.add((double) i);
                        }
                    }
                }
                break;
            case "perfect":
                if (checkBoundaries(a, b, request, response)) {
                    for (int i = (int) a; i <= b; i++) {
                        int sum = 0;
                        for (int j = 1; j < i; j++) {
                            if (i % j == 0) {
                                sum += j;
                            }
                        }
                        if (sum == i) {
                            results.add((double) i);
                        }
                    }
                }
                break;
            case "square":
                if (checkBoundaries(a, b, request, response)) {
                    for (int i = (int) a; i <= b; i++) {
                        if (Math.sqrt(i) % 1 == 0) {
                            results.add((double) i);
                        }
                    }
                }
                break;
        }

        request.setAttribute("results", results);
        request.setAttribute("result", result);
        request.getRequestDispatcher("form" + form + ".jsp").forward(request, response);
    }

    protected boolean checkBoundaries(double a, double b, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (a > b) {
            request.setAttribute("result", "a cannot be less than b");
            request.getRequestDispatcher("result.jsp").forward(request, response);
            return false;
        } else
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
