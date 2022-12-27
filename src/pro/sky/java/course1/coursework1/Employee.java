package pro.sky.java.course1.coursework1;

public class Employee {

    private final String fio;
    private int department;
    private int salary;
    private final int id;
    private static int counter;

    public Employee(String fio, int department, int salary) {
        this.fio = fio;
        this.department = department;
        this.salary = salary;
        id = counter;
        counter++;
    }

    public String getFio() {
        return this.fio;
    }

    public int getDepartment() {
        return  this.department;
    }

    public double getSalary() {
        return this.salary;
    }

    public int getId() {
        return this.id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", " +
                "ФИО='" + fio + '\'' +
                ", Отдел=" + department +
                ", ЗП=" + salary +
                '}';
    }
}
