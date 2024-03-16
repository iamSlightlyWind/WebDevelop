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

public class Search extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        DBContext db = new DBContext();
        String action = request.getParameter("action");

        ArrayList<Author> authorList = new ArrayList();
        ResultSet authorResult = db.authorList();

        ArrayList<Paper> paperList = new ArrayList();
        ResultSet paperResult;

        while (authorResult.next()) {
            authorList.add(new Author(authorResult.getString("AuthorName"), authorResult.getInt("AuthorID")));
        }

        if (action != null) {
            if (action.equals("search")) {
                int id = Integer.parseInt(request.getParameter("selectedAuthorId"));
                paperResult = db.getPaper(id);

                while (paperResult.next()) {
                    paperList.add(new Paper(
                            paperResult.getInt("PaperID"),
                            paperResult.getString("Title"),
                            paperResult.getString("PublicationDate")
                    ));
                }
                request.setAttribute("paperList", paperList);
            }
        }

        try (PrintWriter out = response.getWriter()) {
            request.setAttribute("authorList", authorList);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/search.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
