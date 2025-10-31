/*
================================================================================
PROGRAM DOCUMENTATION
================================================================================

INTRODUCTION
------------
This Java program demonstrates the use of Java Streams, Functional Interfaces,
and Lambda Expressions to manipulate and analyze a list of employee data.
It focuses on transforming, filtering, and aggregating employee information
in a functional programming style.

CORE FUNCTIONALITIES
--------------------
1. Display each employee’s name with their respective department.
2. Compute the average salary across all employees.
3. Display a list of employees older than 30 (with their name and age).
4. Display employees older than 28 who work in the IT department.
5. Display names of employees whose names start with 'K'.

HOW TO RUN THE PROGRAM
----------------------
1. Ensure Java (JDK 8 or higher) is installed on your system.
2. Save this file as `Main.java`.
3. Compile the program using:
       javac Main.java
4. Run the compiled class using:
       java Main
5. The output will be printed in the console window.

PROGRAM STRUCTURE OVERVIEW
--------------------------
- Class `Employee`: Represents an employee entity with name, age,
  department, and salary fields, including standard getters and setters.
- Class `Main`: Contains the `main()` method, which initializes data,
  defines functional mappings, applies stream operations, and prints results.

MAIN PROGRAM AND SYSTEM FLOW
----------------------------
1. Create a list of `Employee` objects with sample data.
2. Use functional mappings and stream operations to:
   - Map employees to specific string representations.
   - Filter employees based on age, department, or name.
   - Compute the average salary.
3. Collect and print results for each transformation.

CODE QUALITY AND DESIGN PRINCIPLES
----------------------------------
- Uses Java Streams API for concise and readable data manipulation.
- Demonstrates the separation of data (Employee class) and logic (Main class).
- Employs Functional Interfaces (`Function<Employee, String>`) to improve
  modularity and reusability.
- Encourages immutability and stateless operations within stream pipelines.

DOCUMENTATION AND CODE MAINTENANCE
----------------------------------
- All major operations and logic steps are clearly commented.
- The code follows a clear and consistent naming convention.
- Modular design allows easy expansion (e.g., adding new filters or operations).
- The `Employee` class is designed for reusability in other contexts.

LEARNING OUTCOMES AND REFLECTION
--------------------------------
Through this program, I learned:
- Understand how to use Java Streams for data filtering, mapping, and aggregation.
- the advantages of functional programming techniques in Java.
- Gain experience in designing clear, maintainable, and well-documented code.

REFLECTION
--------------------------------
Having previously learned React, I was already familiar with 
concepts like method chaining and the use of lambda functions. 
Working on this Java program felt refreshing because Java Streams 
follow a similar functional programming style. It was interesting to see how these patterns, 
which I had used extensively in JavaScript, can be applied effectively in Java 
to write cleaner, more concise, and expressive code.

================================================================================
*/

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Sample data to work on
        List<Employee> employees = Arrays.asList(
                new Employee("Dana", 28, "Programming", 50000),
                new Employee("Prakash", 35, "IT", 70000),
                new Employee("Khaled", 40, "Finance", 60000),
                new Employee("Majed", 23, "IT", 56000),
                new Employee("Leeanah", 29, "IT", 65000),
                new Employee("Karel", 25, "Programming", 58000));

        // Function to change employee object to String that contains name, department.
        Function<Employee, String> employeeDepartmentString = e -> e.getName() + " , " + e.getDepartment();

        // The use of streams to create a new list of concatenated strings
        List<String> employeeStrings = employees.stream().map(employeeDepartmentString).collect(Collectors.toList());

        // The use of streams to create a new variable that stores the average Salary
        double averageSalary = employees.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
        averageSalary = Math.round(averageSalary * 100.0) / 100.0;

        // Function to change employee object to a String that contains name, age.
        Function<Employee, String> employeeAgeString = e -> e.getName() + ", " + e.getAge();

        // The use of streams to create a new list of concatenated strings where the
        // employee age is above 30
        List<String> employeesAbove30 = employees.stream().filter(emp -> emp.getAge() > 30).map(employeeAgeString)
                .collect(Collectors.toList());

        // Function to change employee object to a String that contains
        // name, age, Department.
        Function<Employee, String> employeeAgeDepartmentString = e -> e.getName() + ", " + e.getAge() + ", "
                + e.getDepartment();

        // The use of streams to create a new list of concatenated strings where the
        // employee age is above 28 and works in the "IT" department.
        List<String> employeesAbove28AndIT = employees.stream()
                .filter(emp -> emp.getAge() > 28 && emp.getDepartment() == "IT").map(employeeAgeDepartmentString)
                .collect(Collectors.toList());

        // The use of streams to create a new list of string name where the
        // employee's name starts with 'K'
        List<String> employeesStartWithK = employees.stream().filter(emp -> emp.getName().startsWith("K"))
                .map(emp -> emp.getName()).collect(Collectors.toList());

        // ============================== Output ==============================
        System.out.println("\n");

        // Employee, Department list
        System.out.println("(Employee , Department)");
        employeeStrings.forEach(e -> System.out.println(e));
        System.out.println("\n");

        // The average salary in the company
        System.out.println("The average salary at the company is " + averageSalary);
        System.out.println("\n");

        // Employee, Age list where age is more than 30
        System.out.println("(Employee, Age > 30)");
        employeesAbove30.forEach(e -> System.out.println(e));
        System.out.println("\n");

        System.out.println("(Employee, Age > 28, Department = IT)");
        employeesAbove28AndIT.forEach(e -> System.out.println(e));
        System.out.println("\n");

        System.out.println("(Employee starts with 'K')");
        employeesStartWithK.forEach(e -> System.out.println(e));
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
