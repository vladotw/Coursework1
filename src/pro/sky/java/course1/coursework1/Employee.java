package pro.sky.java.course1.coursework1;

public class Employee {

    private String employeeFio;
    private int employeeDepartment;
    private int employeeSalary;
    private final int id;
    private static int counter;

    public Employee(String fio, int department, int salary) {
        this.employeeFio = fio;
        this.employeeDepartment = department;
        this.employeeSalary = salary;
        id = counter;
        counter++;
    }

    public String getEmployeeFio() {
        return this.employeeFio;
    }

    public int getEmployeeDepartment() {
        return  this.employeeDepartment;
    }

    public double getEmployeeSalary() {
        return this.employeeSalary;
    }

    public int getId() {
        return this.id;
    }

    public void setEmployeeFio(String employeeFio) {
        this.employeeFio = employeeFio;
    }

    public void setEmployeeDepartment(int employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", " +
                "ФИО='" + employeeFio + '\'' +
                ", Отдел=" + employeeDepartment +
                ", ЗП=" + employeeSalary +
                '}';
    }
}
