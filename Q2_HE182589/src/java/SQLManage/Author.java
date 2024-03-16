package SQLManage;

public class Author {

    public String name;
    public int id;

    public Author(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
