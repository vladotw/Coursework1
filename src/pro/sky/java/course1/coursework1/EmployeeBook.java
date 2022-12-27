package pro.sky.java.course1.coursework1;

import static java.lang.Integer.*;

public class EmployeeBook {
    private final int size = 10;
    private final Employee[] employees = new Employee[size];

    public void addEmployee(Employee employee) {
        int index = -1;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                index = i;
                break;
            }
        }

        if (index < 0) {
            System.out.println("В справочнике нет места.");
        }

        employees[index] = employee;
        System.out.println("Новый сотрудник " + employee.getFio() + " добавлен.");
    }


    public void printEployeesList() {

        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public double calculateSalarySum() {
        double salarySum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                salarySum = salarySum + employee.getSalary();
            }
        }
        return salarySum;
    }

    public Employee findMinSalary() {

        int index = 0;
        double minSalary = MAX_VALUE;
        for (int i = 1; i < employees.length; i++) {
            if (employees[i] != null && minSalary > employees[i].getSalary()) {
                minSalary = employees[i].getSalary();
                index = i;
            }
        }
        return employees[index];
    }

    public Employee findMaxSalary() {
        int index = 0;
        double maxSalary = MIN_VALUE;
        for (int i = 1; i < employees.length; i++) {
            if (employees[i] != null && maxSalary < employees[i].getSalary()) {
                maxSalary = employees[i].getSalary();
                index = i;
            }
        }
        return employees[index];
    }


    public double calculateAverageSalaryValue() {
        int index = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                index += 1;
            }
        }
        return calculateSalarySum() / index;
    }

    public void printEmployeeFio() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFio());
            }
        }
    }

    public void indexSalary() {
        double indexPercent = 0.1;
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary((int) (employee.getSalary() +
                        employee.getSalary() * indexPercent));
                System.out.println(employee.getFio() + " " + employee.getSalary());
            }
        }
    }


    public Employee findMinSalaryEmployeeInDep(int inDepartment) {

        int index = 0;
        double minSalary = MAX_VALUE;

        for (int i = 0; i < employees.length; i++) {

            if (employees[i] != null && employees[i].getDepartment() == inDepartment && minSalary >
                    employees[i].getSalary()) {

                minSalary = employees[i].getSalary();
                index = i;
            }
        }
        return employees[index];
    }

    public Employee findMaxSalaryEmployeeInDep(int inDepartment) {

        int index = 0;
        double maxSalary = MIN_VALUE;

        for (int i = 0; i < employees.length; i++) {

            if (employees[i] != null && employees[i].getDepartment() == inDepartment &&
                    maxSalary < employees[i].getSalary()) {

                maxSalary = employees[i].getSalary();
                index = i;
            }
        }
        return employees[index];
    }

    // Затраты на ЗП по отделу
    public double calculateSalarySumInDep(int inDepartment) {
        double salarySumInDep = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == inDepartment) {
                salarySumInDep = salarySumInDep + employee.getSalary();
            }
        }
        return salarySumInDep;
    }

    // Средняя ЗП по одтелу
    public double calculateAverageSalaryValueInDep(int inDepartment) {
        int index = 0;
        double sum = 0.0;
        double averageSalaryValueInDep;

        for (Employee employee : employees) {

            if (employee != null && employee.getDepartment() == inDepartment) {
                sum = sum + employee.getSalary();
                index = index + 1;
            }

        }
        averageSalaryValueInDep = sum / index;
        return averageSalaryValueInDep;
    }

    // Переиндексация ЗП по отделу
    public void calculateIndexEmployeeSalaryInDep(int inDepartment, int inPercent) {
        double indexPercent = (double) inPercent / 100;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == inDepartment) {
                employee.setSalary((int) (employee.getSalary() +
                        employee.getSalary() * indexPercent));
            }
        }
    }

    public void printEmployeesListDep(int inDepartment) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == inDepartment) {
                System.out.println("ID: " + employee.getId() + "; ФИО: " + employee.getFio() + "; Оклад: " +
                        employee.getSalary());
            }
        }
    }

    // Вывод сотрудников с ЗП меньше числа
    public void printEmployeesLess(int inCompareNumber) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < inCompareNumber) {
                System.out.println("ID: " + employee.getId() + "; ФИО: " + employee.getFio() + "; Оклад: " +
                        employee.getSalary());
            }
        }
    }

    // Вывод сотрудников с ЗП больше числа
    public void printEmployeesMore(int inCompareNumber) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > inCompareNumber) {
                System.out.println("ID: " + employee.getId() + "; ФИО: " + employee.getFio() + "; Оклад: " +
                        employee.getSalary());
            }
        }
    }

    public int findFreeSpace() {

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void createNewEmployee(String fio,int department, int salary) {
        int index = findFreeSpace();
        if (index == -1) {
            System.out.println("Книга заполнена.");
            return;
        }
        employees[index] = new Employee(fio, department, salary);
    }

    public void deleteEmployeeById(int id) {

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
            }
        }
    }

    public void deleteEmployeeByFio(String fio) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getFio().equals(fio)) {
                employees[i] = null;
            }
        }
    }

    public void changeEmployeeSalary(String fio, int salary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getFio().equals(fio)) {
                employee.setSalary(salary);
            }
        }
    }

    public void changeEmployeeDep(String fio, int department) {
        for (Employee employee : employees) {
            if (employee != null && employee.getFio().equals(fio)) {
                employee.setDepartment(department);
            }
        }
    }

    public void printEmployees() {

        for (int i = 1; i <= 5; i++) {
            System.out.println("Отдел " + i + " :");
            for (Employee employee : employees) {
                if (employee != null && employee.getDepartment() == i) {
                    System.out.println(employee.getFio());
                }
            }
        }
    }
}







