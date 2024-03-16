package SQLManage;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Add extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        DBContext db = new DBContext();
        String action = request.getParameter("action");

        ArrayList<Author> authorList = new ArrayList();
        ResultSet authorResult = db.authorList();

        while (authorResult.next()) {
            authorList.add(new Author(authorResult.getString("AuthorName"), authorResult.getInt("AuthorID")));
        }
        System.out.println("Got here");

        if (action != null) {
            if (action.equals("add")) {
                System.out.println(request.getParameter("paperID"));
                System.out.println(request.getParameter("title"));
                System.out.println(request.getParameter("date"));
                
                String[] selectedIds = request.getParameterValues("id");
                int[] selectedIdsInt = new int[selectedIds.length];

                if (selectedIds != null) {
                    for (int i = 0; i < selectedIds.length; i++) {
                        selectedIdsInt[i] = Integer.parseInt(selectedIds[i]);
                    }
                }

                db.addPaper(selectedIdsInt, new Paper(
                        Integer.parseInt((String) request.getParameter("paperID")),
                        (String) request.getParameter("title"),
                        (String) request.getParameter("date")));
            }
        }

        try (PrintWriter out = response.getWriter()) {
            request.setAttribute("authorList", authorList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/add.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
