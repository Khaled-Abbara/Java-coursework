import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Dana", 28, "HR", 50000),
                new Employee("Prakash", 35, "IT", 70000),
                new Employee("Khaled", 40, "Finance", 60000),
                new Employee("Leeanah", 31, "IT", 65000),
                new Employee("Karel", 25, "Programming", 58000));

        // Function to change employee object to String that contains name, department.
        Function<Employee, String> employeeDepartmentString = emp -> emp.getName() + " , " + emp.getDepartment();

        // The use of streams to create a new list of concatenated strings
        List<String> employeeStrings = employees.stream().map(employeeDepartmentString).collect(Collectors.toList());

        // The use of streams to create a new variable that stores the average Salary
        double averageSalary = employees.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);

        // Function to change employee object to a String that contains name, age.
        Function<Employee, String> employeeAgeString = emp -> emp.getName() + ", " + emp.getAge();

        // The use of streams to create a new list of concatenated strings where the
        // employee age is above 30
        List<String> employeesAbove30 = employees.stream().filter(emp -> emp.getAge() > 30).map(employeeAgeString)
                .collect(Collectors.toList());

        // Output:
        System.out.println("\n");

        // Employee, Department list
        System.out.println("(Employee , department)");
        employeeStrings.forEach(e -> System.out.println(e));
        System.out.println("\n");

        // The average salary in the company
        System.out.println("The average salary at the company is " + averageSalary);
        System.out.println("\n");

        // Employee, Age list where age is more than 30
        System.out.println("(Employee, Age > 30)");
        employeesAbove30.forEach(e -> System.out.println(e));
        System.out.println("\n");

    }
}

// simple employee object
class Employee {
    private String name;
    private int age;
    private String department;
    private double salary;

    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
