package pro.sky.java.course1.coursework1;

import static java.lang.Integer.*;

public class EmployeeBook {
    private final int SIZE = 10;
    private final Employee[] employees = new Employee[SIZE];

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
        System.out.println("Новый сотрудник " + employee.getEmployeeFio() + " добавлен.");
    }


    public void printEployeesList() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public double calculateSalarySum() {
        double salarySum = 0;
        for (Employee employee : employees) {
            salarySum = salarySum + employee.getEmployeeSalary();
        }
        return salarySum;
    }

    public String findMinSalary() {

        String minSalaryEmployee = null;
        int index = 0;
        double minSalary = employees[0].getEmployeeSalary();
        for (int i = 1; i < employees.length; i++) {
            if (minSalary > employees[i].getEmployeeSalary()) {

                minSalary = employees[i].getEmployeeSalary();
                index = i;
                minSalaryEmployee = employees[index].getEmployeeFio();
            }
        }
        return "Сотрудник " + minSalaryEmployee + " имеет минимальную ЗП (" + minSalary + ")";
    }

    public String findMaxSalary() {
        String maxSalaryEmployee = null;
        int index = 0;
        double maxSalary = employees[0].getEmployeeSalary();
        for (int i = 1; i < employees.length; i++) {
            if (maxSalary < employees[i].getEmployeeSalary()) {
                maxSalary = employees[i].getEmployeeSalary();
                index = i;
                maxSalaryEmployee = employees[index].getEmployeeFio();
            }
        }
        return "Сотрудник " + maxSalaryEmployee + " имеет максимальную ЗП (" + maxSalary + ")";
    }


    public double calculateAverageSalaryValue() {
        return calculateSalarySum() / SIZE;
    }

    public void printEmployeeFio() {
        for (Employee employee : employees) {
            System.out.println(employee.getEmployeeFio());
        }
    }

    public void indexSalary() {
        double indexPercent = 0.1;
        for (Employee employee : employees) {
            employee.setEmployeeSalary((int) (employee.getEmployeeSalary() + employee.getEmployeeSalary() * indexPercent));
            System.out.println(employee.getEmployeeFio() + " " + employee.getEmployeeSalary());
        }
    }


    public String findMinSalaryEmployeeInDep(int inDepartment) {

        int index;
        double minSalary = MAX_VALUE;
        String minSalaryEmployee = null;

        for (int i = 0; i < employees.length; i++) {

            if (employees[i].getEmployeeDepartment() == inDepartment && minSalary > employees[i].getEmployeeSalary()) {

                minSalary = employees[i].getEmployeeSalary();
                index = i;
                minSalaryEmployee = employees[index].getEmployeeFio();
            }
        }
        return "Сотрудник " + minSalaryEmployee + " отдела " + inDepartment + " имеет минимальную ЗП (" +
                minSalary + ")";
    }

    public String findMaxSalaryEmployeeInDep(int inDepartment) {

        int index;
        double maxSalary = MIN_VALUE;
        String maxSalaryEmployee = null;

        for (int i = 0; i < employees.length; i++) {

            if (employees[i].getEmployeeDepartment() == inDepartment && maxSalary < employees[i].getEmployeeSalary()) {

                maxSalary = employees[i].getEmployeeSalary();
                index = i;
                maxSalaryEmployee = employees[index].getEmployeeFio();
            }
        }
        return "Сотрудник " + maxSalaryEmployee + " отдела " + inDepartment + " имеет максимальную ЗП (" + maxSalary +
                ")";
    }

    // Затраты на ЗП по отделу
    public String calculateSalarySumInDep(int inDepartment) {
        double salarySumInDep = 0;
        for (Employee employee : employees) {
            if (employee.getEmployeeDepartment() == inDepartment) {
                salarySumInDep = salarySumInDep + employee.getEmployeeSalary();
            }
        }
        return "Затраты на зарплаты по отделу " + salarySumInDep;
    }

    // Средняя ЗП по одтелу
    public String calculateAverageSalaryValueInDep(int inDepartment) {
        int index = 0;
        double sum = 0.0;
        double averageSalaryValueInDep;

        for (Employee employee : employees) {

            if (employee.getEmployeeDepartment() == inDepartment) {
                sum = sum + employee.getEmployeeSalary();
                index = index + 1;
            }

        }
        averageSalaryValueInDep = sum / index;
        return "Средняя зарплата по отделу " + averageSalaryValueInDep;
    }

    // Переиндексация ЗП по отделу
    public void calculateIndexEmployeeSalaryInDep(int inDepartment, int inPercent) {
        double indexPercent = (double) inPercent / 100;
        for (Employee employee : employees) {
            if (employee.getEmployeeDepartment() == inDepartment) {
                employee.setEmployeeSalary((int) (employee.getEmployeeSalary() + employee.getEmployeeSalary() * indexPercent));

            }
        }
    }

    public void printEmployeesListDep(int inDepartment) {
        for (Employee employee : employees) {
            if (employee.getEmployeeDepartment() == inDepartment) {
                System.out.println("ID: " + employee.getId() + "; ФИО: " + employee.getEmployeeFio() + "; Оклад: " +
                        employee.getEmployeeSalary());
            }
        }
    }

    // Вывод сотрудников с ЗП меньше числа
    public void printEmployeesLess(int inCompareNumber) {
        for (Employee employee : employees) {
            if (employee.getEmployeeSalary() < inCompareNumber) {
                System.out.println("ID: " + employee.getId() + "; ФИО: " + employee.getEmployeeFio() + "; Оклад: " +
                        employee.getEmployeeSalary());
            }
        }
    }

    // Вывод сотрудников с ЗП больше числа
    public void printEmployeesMore(int inCompareNumber) {
        for (Employee employee : employees) {
            if (employee.getEmployeeSalary() > inCompareNumber) {
                System.out.println("ID: " + employee.getId() + "; ФИО: " + employee.getEmployeeFio() + "; Оклад: " +
                        employee.getEmployeeSalary());
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

    public void createNewEmployee() {
        int index = findFreeSpace();
        if (index == -1) {
            System.out.println("Книга заполнена.");
            return;
        }
        employees[index] = new Employee("Крюков Виталий Алексеевич", 5, 38000);
    }

    public void deleteEmployeeById(int id) {

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                employees[i] = null;
            }
        }
    }

    public void deleteEmployeeByFio(String fio) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getEmployeeFio().equals(fio)) {
                employees[i] = null;
            }
        }
    }

    public void changeEmployeeSalary(String fio, int salary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getEmployeeFio().equals(fio)) {
                employee.setEmployeeSalary(salary);
            }
        }
    }

    public void changeEmployeeDep(String fio, int department) {
        for (Employee employee : employees) {
            if (employee != null && employee.getEmployeeFio().equals(fio)) {
                employee.setEmployeeDepartment(department);
            }
        }
    }

    public void printEmployees() {

        for (int i = 1; i <= 5; i++) {
            System.out.println("Отдел " + i + " :");
            for (Employee employee : employees) {
                if (employee != null && employee.getEmployeeDepartment() == i) {
                    System.out.println(employee.getEmployeeFio());
                }
            }
        }
    }
}







