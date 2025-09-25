// Student Data Storage:
//
// Use individual variables to store student information such as name, ID, age, and grade.
//
// Student Management:
//
// Develop a set of logically separated methods/functions within a dedicated classless structure,
// employing static variables for storing the total number of students and the student list.
//
// Administrator Interface:
//
// Display a menu with options to add a new student, update student information, and view student details.
//
// Prompt the administrator for necessary inputs and perform the requested operations using the StudentManagement logic.
//
// Error Handling:
//
// Implement error handling to manage cases where the student ID is not found or invalid inputs are provided.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem(100);
        Dashboard dashboard = new Dashboard(studentSystem, scanner);

        dashboard.launch();
    }
}

class Dashboard {
    private final StudentSystem studentSystem;
    private final Scanner scanner;

    public Dashboard(StudentSystem studentSystem, Scanner scanner) {
        this.studentSystem = studentSystem;
        this.scanner = scanner;
    }

    public void launch() {
        int choice;
        do {
            System.out.println("\n======| Student Record MS |======");
            System.out.println("1. View all students");
            System.out.println("2. Add a new student");
            System.out.println("3. Change student details");
            System.out.println("4. Find a student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) { // input validation
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> handleViewAllStudents();
                case 2 -> handleAddStudent();
                case 3 -> handleUpdateStudent();
                case 4 -> handleFindStudent();
                case 5 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private void handleViewAllStudents() {
        studentSystem.viewAllStudents();
    }

    private void handleAddStudent() {
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

    private void handleUpdateStudent() {
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

    private void handleFindStudent() {
        System.out.print("Enter student ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Student student = studentSystem.findStudentById(id);
        if (student == null) {
            System.out.println("Error: Student with ID " + id + " not found.");
        } else {
            StudentSystem.viewStudent(student);
        }
    }
}

class Student {
    private static int idCounter = 0;

    private final int id;
    private String name;
    private int age;
    private int grade;

    public Student(String name, int age, int grade) {
        this.id = ++idCounter;
        this.name = name;
        this.age = age;
        this.grade = grade;
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
    private static int totalStudents = 0;
    private static Student[] students;

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
                try {
                    student.setAge(Integer.parseInt(newValue));
                    System.out.println("Student's age updated!");
                } catch (NumberFormatException e) {
                    System.out.println("Error: Age must be a number.");
                }
            }
            case "grade" -> {
                try {
                    student.setGrade(Integer.parseInt(newValue));
                    System.out.println("Student's grade updated!");
                } catch (NumberFormatException e) {
                    System.out.println("Error: Grade must be a number.");
                }
            }
            default -> System.out.println("Error: Invalid field.");
        }
    }
}
