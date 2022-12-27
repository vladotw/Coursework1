package pro.sky.java.course1.coursework1;

import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);

    static int size = 10;
    static Employee[] employees = new Employee[10];
    static int inDepartment = 3;
    static int inPercent = 12;
    static int inCompareNumber = 28_000;


    static Employee addEmployee(Employee employee) {
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
        return employee;
    }

    // Вывод списка сотрудников
    static void printEployeesList() {
        for (Employee employee: employees) {
            System.out.println(employee);
        }
    }

    // Затраты на ЗП
    static double calculateSalarySum() {
        double salarySum = 0;
        for (Employee employee : employees) {
            salarySum = salarySum + employee.getEmployeeSalary();
        }
        return salarySum;
    }

    static String findMinSalary() {     // Минимальная ЗП

        String minSalaryEmployee = null;
        int index;
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

    // Максимальная ЗП
    static String findMaxSalary() {
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

    // Средняя ЗП
    static double calculateAverageSalaryValue() {
        double averageSalaryValue;
        averageSalaryValue = calculateSalarySum() / size;
        return averageSalaryValue;
    }

    // Вывод ФИО сотрудников
    static void printEmployeeFio() {
        for (Employee employee : employees) {
            System.out.println(employee.getEmployeeFio());
        }
    }

    // Переиндексация ЗП
    static void indexSalary() {
        double indexPercent = 0.1;
        for (Employee employee : employees) {
            employee.setEmployeeSalary(employee.getEmployeeSalary() + employee.getEmployeeSalary() * indexPercent);
            System.out.println(employee.getEmployeeFio() + " " + employee.getEmployeeSalary());
        }
    }

    // Минимальная ЗП в отделе
    static String findMinSalaryEmployeeInDep(int inDepartment) {

        int index;
        double minSalary = 1000000000.0;
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

    // Максимальная ЗП в отделе
    static String findMaxSalaryEmployeeInDep() {

        int index;
        double maxSalary = 0.0;
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
    static String calculateSalarySumInDep(int inDepartment) {
        double salarySumInDep = 0;
        for (Employee employee : employees) {
            if (employee.getEmployeeDepartment() == inDepartment) {
                salarySumInDep = salarySumInDep + employee.getEmployeeSalary();
            }
        }
        return "Затраты на зарплаты по отделу " + salarySumInDep;
    }

    // Средняя ЗП по одтелу
    static String calculateAverageSalaryValueInDep(int inDepartment) {
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
    static void calculateIndexEmployeeSalaryInDep(int inDepartment, int inPercent) {
        double indexPercent = inPercent / 100;
        for (Employee employee : employees) {
            if (employee.getEmployeeDepartment() == inDepartment) {
                employee.setEmployeeSalary(employee.getEmployeeSalary() + employee.getEmployeeSalary() * indexPercent);

            }
        }
    }

    // Вывод списка сотрудников отдела
    static void printEmployeesListDep(int inDepartment) {
        for (Employee employee : employees) {
            if (employee.getEmployeeDepartment() == inDepartment) {
                System.out.println("ID: " + employee.getId() + "; ФИО: " + employee.getEmployeeFio() + "; Оклад: " +
                        employee.getEmployeeSalary());
            }
        }
    }

    // Вывод сотрудников с ЗП меньше полученного числа
    static void printEmployeesLess(int inCompareNumber) {
        for (Employee employee : employees) {
            if (employee.getEmployeeSalary() < inCompareNumber) {
                System.out.println("ID: " + employee.getId() + "; ФИО: " + employee.getEmployeeFio() + "; Оклад: " +
                        employee.getEmployeeSalary());
            }
        }
    }

    // Вывод сотрудников с ЗП больше полученного числа
    static void printEmployeesMore(int inCompareNumber) {
        for (Employee employee : employees) {
            if (employee.getEmployeeSalary() > inCompareNumber) {
                System.out.println("ID: " + employee.getId() + "; ФИО: " + employee.getEmployeeFio() + "; Оклад: " +
                        employee.getEmployeeSalary());
            }
        }
    }

    public static void main(String[] args) {

        addEmployee(new Employee("Иванов Иван Иванович", 1, 25000));
        addEmployee(new Employee("Сергеев Сергей Сергеевич", 2, 25000));
        addEmployee(new Employee("Петров Петр Петрович", 2, 32000));
        addEmployee(new Employee("Семенов Семен Семенович", 3, 18000));
        addEmployee(new Employee("Мышкина Александра Ивановна", 4, 11000));
        addEmployee(new Employee("Селиванов Андрей Владимирович", 1, 52000));
        addEmployee(new Employee("Карпенко Наталья Константиновна", 5, 44000));
        addEmployee(new Employee("Зубец Юлия Андреевна", 5, 14000));
        addEmployee(new Employee("Ногин Святослав Евпатиевич", 3, 23000));
        addEmployee(new Employee("Ким Ильдар Иннокентиевич", 4, 30000));


        System.out.println();
        printEployeesList();
        System.out.println();
        System.out.println("Сумма затрат на зарплаты: " + calculateSalarySum());
        System.out.println(findMinSalary());
        System.out.println(findMaxSalary());
        System.out.println("Среднее значение зарплат = " + calculateAverageSalaryValue());
        System.out.println();
        printEmployeeFio();
        System.out.println();
        indexSalary();
        System.out.println();
        System.out.println(findMinSalaryEmployeeInDep(inDepartment));
        System.out.println(findMaxSalaryEmployeeInDep());
        System.out.println();
        System.out.println(calculateAverageSalaryValueInDep(inDepartment));
        System.out.println();
        System.out.println(calculateSalarySumInDep(inDepartment));
        System.out.println();
        System.out.println();
        calculateIndexEmployeeSalaryInDep(inDepartment, inPercent);
        printEmployeesListDep(inDepartment);
        System.out.println();
        printEmployeesLess(inCompareNumber);
        System.out.println();
        printEmployeesMore(inCompareNumber);


    }
}