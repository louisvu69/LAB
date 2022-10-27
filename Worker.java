package entity;

public class Worker {

    private String ID;
    private String name;
    private int age;
    private double salary;
    private String status;
    private String date;
    public static String HEADER_FORMAT = "%-5s%-15s%-5s%-10s%-10s%-20s\n";
    public static final String DISPLAY_HEADER = String.format(HEADER_FORMAT, "Code", "Name", "Age",
                "Salary", "Status", "Date");

    public Worker() {
    }

    public Worker(String ID, String name, int age, double salary, String workLocation, String date) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status = workLocation;
        this.date = date;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getWorkLocation() {
        return status;
    }

    public void setWorkLocation(String workLocation) {
        this.status = workLocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    

    @Override
    public String toString() {
        return String.format("%-5s%-15s%-5d%10.1f%15s", ID, name, age, salary, status);
    }

}
