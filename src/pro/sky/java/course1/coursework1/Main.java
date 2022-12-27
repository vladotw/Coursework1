package pro.sky.java.course1.coursework1;

public class Main {
    public static void main(String[] args) {

        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addEmployee(new Employee("Иванов Иван Иванович", 1, 25000));
        employeeBook.addEmployee(new Employee("Сергеев Сергей Сергеевич", 2, 25000));
        employeeBook.addEmployee(new Employee("Петров Петр Петрович", 2, 32000));
        employeeBook.addEmployee(new Employee("Семенов Семен Семенович", 3, 18000));
        employeeBook.addEmployee(new Employee("Мышкина Александра Ивановна", 4, 11000));
        employeeBook.addEmployee(new Employee("Селиванов Андрей Владимирович", 1, 52000));
        employeeBook.addEmployee(new Employee("Карпенко Наталья Константиновна", 5, 44000));
        employeeBook.addEmployee(new Employee("Зубец Юлия Андреевна", 5, 14000));
        employeeBook.addEmployee(new Employee("Ногин Святослав Евпатиевич", 3, 23000));
        employeeBook.addEmployee(new Employee("Ким Ильдар Иннокентиевич", 4, 30000));


        System.out.println();
        employeeBook.printEployeesList();
        System.out.println();
        System.out.println("Сумма затрат на зарплаты: " + employeeBook.calculateSalarySum());
        System.out.println(employeeBook.findMinSalary());
        System.out.println(employeeBook.findMaxSalary());
        System.out.println("Среднее значение зарплат = " + employeeBook.calculateAverageSalaryValue());
        System.out.println();
        employeeBook.printEmployeeFio();
        System.out.println();
        employeeBook.indexSalary();
        System.out.println();
        System.out.println(employeeBook.findMinSalaryEmployeeInDep(3));
        System.out.println(employeeBook.findMaxSalaryEmployeeInDep(3));
        System.out.println();
        System.out.println(employeeBook.calculateAverageSalaryValueInDep(3));
        System.out.println();
        System.out.println(employeeBook.calculateSalarySumInDep(3));
        System.out.println();
        System.out.println();
        employeeBook.calculateIndexEmployeeSalaryInDep(3, 12);
        employeeBook.printEmployeesListDep(3);
        System.out.println();
        employeeBook.printEmployeesLess(28_000);
        System.out.println();
        employeeBook.printEmployeesMore(28_000);
        System.out.println();
        employeeBook.deleteEmployeeById(3);
        System.out.println();
        employeeBook.createNewEmployee("Крюков Кирилл Ефимович", 4, 38000);
        System.out.println();
        employeeBook.deleteEmployeeByFio("Сергеев Сергей Сергеевич");
        System.out.println();
        employeeBook.changeEmployeeSalary("Карпенко Наталья Константиновна", 35000);
        employeeBook.changeEmployeeDep("Ким Ильдар Иннокентиевич", 3);
        employeeBook.printEmployees();
    }

}