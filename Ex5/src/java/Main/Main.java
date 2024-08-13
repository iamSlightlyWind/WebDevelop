package Main;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> list = Database.getAll();
        System.out.println(list);
    }
}