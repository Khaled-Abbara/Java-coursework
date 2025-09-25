/*
 * ==============================================
 *   Student Record Management System (Console)
 * ==============================================
 *
 * This program is a simple console-based Student Record
 * Management System written in Java. It allows users to:
 *
 *  1. View all student records
 *  2. View total number of students
 *  3. View the last assigned student ID
 *  4. Add a new student
 *  5. Update student details (name, age, grade)
 *  6. Find a student by their ID
 *  7. Exit the program
 *
 * -------------------------
 *  STRUCTURE OF THE PROGRAM
 * -------------------------
 *
 *  - Main:
 *      Entry point of the application.
 *      Initializes the StudentSystem and Dashboard,
 *      adds some sample students, and launches the dashboard menu.
 *
 *  - Dashboard:
 *      Handles user interaction via a text-based menu.
 *      Uses a Scanner to read input and invokes
 *      corresponding methods from StudentSystem.
 *
 *  - Student:
 *      Represents a student with attributes:
 *      ID, Name, Age, and Grade.
 *      IDs are auto-incremented using a static counter (idCounter).
 *
 *  - StudentSystem:
 *      Core management system that stores students in
 *      an array (with a fixed capacity set at initialization).
 *      Provides methods to add, view, find, and update students.
 *
 * -------------------------
 *  USE OF STATIC
 * -------------------------
 *
 *  - In Student:
 *      A static counter (idCounter) is used to auto-generate
 *      unique IDs for each student. A static method (getLastId)
 *      allows retrieving the last assigned ID.
 *
 *  - In StudentSystem:
 *      The array of students (students[]) and the student count
 *      (totalStudents) are static, meaning they are shared across
 *      all instances of StudentSystem.
 *      Some utility methods (viewStudent, updateStudent) are also
 *      defined as static since they operate directly on
 *      provided Student objects rather than instance data.
 *
 * -------------------------
 *  HOW IT WORKS
 * -------------------------
 *
 *  - The program starts with the main menu in Dashboard.
 *  - Users select an option by entering a number (1–7).
 *  - Student data is stored in an array within StudentSystem.
 *  - Students can be added, viewed, updated, or searched by ID.
 *  - The program continues looping until the user selects Exit (option 7).
 *
 * -------------------------
 *  LIMITATIONS
 * -------------------------
 *
 *  - Students are stored in a fixed-size array.
 *    (No dynamic resizing or database integration.)
 *  - Designed for demonstration/learning purposes only.
 *
 * -------------------------
 *  GOOD DESIGN CHOICES
 * -------------------------
 *
 *  - Separation of Concerns:
 *      Different classes handle different responsibilities:
 *      Main (entry point), Dashboard (UI), StudentSystem (logic),
 *      and Student (data model).
 *
 *  - Encapsulation:
 *      Student properties are private with getter/setter methods
 *      to control access and updates.
 *
 *  - Auto-incremented IDs:
 *      Using a static counter in Student ensures each student
 *      has a unique ID without manual tracking.
 *
 *  - Menu-Driven Flow:
 *      The dashboard provides a clear, user-friendly interface
 *      for navigating the system in a loop until exit.
 *
 *  - Reusable Utility Methods:
 *      Static methods in StudentSystem (viewStudent, updateStudent)
 *      make common operations reusable and concise.
 *
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem(100);
        Dashboard dashboard = new Dashboard(studentSystem, scanner);

        // Sample data:
        studentSystem.addStudent("Alice Johnson", 6, 1);
        studentSystem.addStudent("Khaled Abbara", 11, 6);
        studentSystem.addStudent("Karel van zijil", 12, 4);
        studentSystem.addStudent("Dana Banana", 8, 2);
        studentSystem.addStudent("Safa Saber", 12, 7);

        dashboard.launch();
    }
}

class Dashboard {

    final StudentSystem studentSystem;
    final Scanner scanner;

    public Dashboard(StudentSystem studentSystem, Scanner scanner) {
        this.studentSystem = studentSystem;
        this.scanner = scanner;
    }

    public void launch() {
        int choice;

        do {
            System.out.println("\n========| Student Record MS |========\n");
            System.out.println("-------------------------------------");
            System.out.println("1. View all student records");
            System.out.println("2. View total number of students");
            System.out.println("3. View last ID");
            System.out.println("-------------------------------------");
            System.out.println("4. Add a new student");
            System.out.println("5. Change student details");
            System.out.println("6. Find a student by ID");
            System.out.println("-------------------------------------");
            System.out.println("7. Exit");
            System.out.println("-------------------------------------");

            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                // =======================================
                case 1 -> handleViewAllStudents();
                case 2 -> handleCountStudents();
                case 3 -> handleViewLastId();

                // =======================================
                case 4 -> handleAddStudent();
                case 5 -> handleUpdateStudent();
                case 6 -> handleFindStudent();

                // =======================================
                case 7 -> System.out.println("Exiting... Goodbye!");

                // =======================================
                default -> System.err.println("Invalid choice. Please try again.");

            }
        } while (choice != 7);

    }

    public void handleViewAllStudents() {
        System.out.println("\n\n");
        System.out.println("-----");
        studentSystem.viewAllStudents();

    }

    public void handleCountStudents() {

        System.out.println("\n");
        System.out.println("Number of Students in the system: " + StudentSystem.totalStudents);
    }

    public void handleViewLastId() {

        System.out.println("\n");
        System.out.println("The last student Id: " + Student.getLastId());
    }

    public void handleAddStudent() {

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        System.out.print("Enter grade: ");
        int grade = scanner.nextInt();
        scanner.nextLine(); // consume newline

        studentSystem.addStudent(name, age, grade);
        System.out.println("Student added successfully!");
    }

    public void handleUpdateStudent() {

        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Student student = studentSystem.findStudentById(id);
        if (student == null) {
            System.out.println("Error: Student with ID " + id + " not found.");
            return;
        }

        System.out.print("Enter field to update (name/age/grade): ");
        String field = scanner.nextLine();
        System.out.print("Enter new value: ");
        String newValue = scanner.nextLine();

        StudentSystem.updateStudent(student, field, newValue);
    }

    public void handleFindStudent() {

        System.out.print("Enter student ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Student student = studentSystem.findStudentById(id);

        if (student == null) {
            System.out.println("Error: Student with ID " + id + " not found.");
        } else {
            System.out.println("\n");
            System.out.println("-----");
            StudentSystem.viewStudent(student);
            System.out.println("-----");
        }
    }

}

class Student {

    static int idCounter = 0;

    final int id;
    String name;
    int age;
    int grade;

    public Student(String name, int age, int grade) {
        this.id = ++idCounter;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    static int getLastId() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}

class StudentSystem {

    static int totalStudents = 0;
    static Student[] students;

    public StudentSystem(int capacity) {

        students = new Student[capacity];
    }

    public void addStudent(String name, int age, int grade) {

        if (totalStudents >= students.length) {
            System.out.println("Error: Student list is full.");
            return;
        }
        students[totalStudents++] = new Student(name, age, grade);
    }

    public void viewAllStudents() {

        if (totalStudents == 0) {
            System.out.println("No students found.");
            return;
        }

        for (int i = 0; i < totalStudents; i++) {
            viewStudent(students[i]);
            System.out.println("-----");
        }
    }

    public Student findStudentById(int id) {

        for (int i = 0; i < totalStudents; i++) {
            if (students[i].getId() == id) {
                return students[i];
            }
        }
        return null;
    }

    public static void viewStudent(Student student) {

        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("Grade: " + student.getGrade());
    }

    public static void updateStudent(Student student, String variable, String newValue) {

        switch (variable.toLowerCase()) {
            case "name" -> {
                student.setName(newValue);
                System.out.println("Student's name updated!");
            }

            case "age" -> {
                student.setAge(Integer.parseInt(newValue));
                System.out.println("Student's age updated!");
            }

            case "grade" -> {
                student.setGrade(Integer.parseInt(newValue));
                System.out.println("Student's grade updated!");
            }

            default -> System.out.println("Error: Invalid field.");
        }
    }
}
