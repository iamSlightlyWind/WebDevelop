package Main;

import Database.Database;

public class User {
    public String username;
    public String password;
    public int role;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, int role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int login() {
        role = Database.login(this);
        return role;
    }

    public int register() {
        return Database.register(this);
    }
}
