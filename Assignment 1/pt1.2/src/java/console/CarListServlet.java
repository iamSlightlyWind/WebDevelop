package console;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CarListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String carID = request.getParameter("carID");

        CarDAO carDAO = new CarDAO();

        if ("delete".equals(action)) {
            carDAO.deleteCar(carID);
        } else if ("update".equals(action)) {
            // Handle update action//
        }

        if ("update".equals(action)) {
            String carName = request.getParameter("carName");
            Car car = new Car();
            car.setCarID(carID);
            car.setCarName(carName);
            carDAO.updateCar(car);
        }

        request.setAttribute("cars", carDAO.getAllCars());
        request.getRequestDispatcher("carList.jsp").forward(request, response);
    }
}