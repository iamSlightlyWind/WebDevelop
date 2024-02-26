package console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {

    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String URL = "jdbc:sqlserver://localhost:1433;databaseName=CarManagement;user=sa;password=sa";
            Connection connection = DriverManager.getConnection(URL);
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tblCars");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Car car = new Car();
                car.setCarID(rs.getString("carID"));
                car.setCarName(rs.getString("carName"));
                cars.add(car);
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cars;
    }

    public void updateCar(Car car) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String URL = "jdbc:sqlserver://localhost:1433;databaseName=CarManagement;user=sa;password=sa";
            Connection connection = DriverManager.getConnection(URL);
            PreparedStatement stmt = connection.prepareStatement("UPDATE tblCars SET carName = ? WHERE carID = ?");
            stmt.setString(1, car.getCarName());
            stmt.setString(2, car.getCarID());
            stmt.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCar(String carID) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String URL = "jdbc:sqlserver://localhost:1433;databaseName=CarManagement;user=sa;password=sa";
            Connection connection = DriverManager.getConnection(URL);
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM tblCars WHERE carID = ?");
            stmt.setString(1, carID);
            stmt.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
