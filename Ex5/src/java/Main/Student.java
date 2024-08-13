package Main;

public class Student {
    String rollNo, name;
    float mark;

    public Student(String rollNo, String name, float mark) {
        this.rollNo = rollNo;
        this.name = name;
        this.mark = mark;
    }

    public String toString() {
        return rollNo + " " + name + " " + mark;
    }

    public Student() {
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

}