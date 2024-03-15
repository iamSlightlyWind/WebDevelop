package Account;

public class UserDetails {
    public String firstName;
    public String lastName;
    public String email;
    public String userName;
    public String password;
    
    public UserDetails(String firstName, String lastName, String email, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
