package Account;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDetails {
    public String firstName;
    public String lastName;
    public String email;
    public String userName;
    public String password;
    public int status;
    public int id;

    public UserDetails(String firstName, String lastName, String email, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public UserDetails(ResultSet result, int status) throws SQLException {
        this.firstName = result.getString("firstName");
        this.lastName = result.getString("lastName");
        this.id = (Integer) result.getInt("id");
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
