import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);

    AdministratorInterface AdminInterface = new AdministratorInterface(scanner);

    static <T> int findEmptyIndex(T[] array) {

        for (int index = 0; index < array.length; index++) {
            if (array[index] == null) {
                return index;
            }
        }
        return -1;
    }
}

enum Message {
    SUCCESS,
    INDEX_OUT_OF_BOUNDS,
    ARRAY_IS_FULL,
    COURSE_ALREADY_EXISTS,
    INCORRECT_COURSE_CODE,
    INCORRECT_STUDENT_ID,
    INCORRECT_STUDENT_NAME;
}

class Student {
    static int idCounter = 0;

    final private int id;
    private String name;

    public Student(String name) {
        this.id = ++idCounter;
        this.name = name;

    }

    // getters and setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

class Course {
    private String code;
    private String name;
    private int capacity;

    public Course(String code, String name, int capacity) {
        this.code = code;
        this.name = name;
        this.capacity = capacity;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}

class Enrollment {
    public String compositeId;
    public Course course;
    public Student student;
    public int grade;

    public Enrollment(String compositeId, Course course, Student student, int grade) {
        this.course = course;
        this.student = student;
        this.grade = grade;
    }
}

class CourseManagement {
    private static Student[] students = new Student[500];
    private static Course[] courses = new Course[5];
    private static ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();

    // =====================|Main Methods|=====================

    static void addStudent(String name) {
        int index = Main.findEmptyIndex(students);
        students[index] = new Student(name);

    }

    static Message addCourse(String code, String name, int capacity) {
        if (courseExists(code))
            return Message.COURSE_ALREADY_EXISTS;

        int index = Main.findEmptyIndex(courses);

        if (index == -1)
            return Message.ARRAY_IS_FULL;

        courses[index] = new Course(code, name, capacity);

        return Message.SUCCESS;

    }

    static Message enrollStudent(int studentId, String courseCode) {
        if (!StudentExists(studentId))
            return Message.INCORRECT_COURSE_CODE;

        if (!courseExists(courseCode))
            return Message.INCORRECT_STUDENT_ID;

        Student targetStudent = findStudentById(studentId);
        Course targetCourse = findCourseByCode(courseCode);
        String compositeId = targetCourse.getCode() + targetStudent.getId();

        enrollments.add(new Enrollment(compositeId, targetCourse, targetStudent, -1));

        return Message.SUCCESS;
    }

    static void assignGrade(int studentId, String courseCode, int grade) {

        for (Enrollment enrollment : enrollments) {
            if (enrollment.student.getId() == studentId && enrollment.course.getCode() == courseCode) {
                enrollment.grade = grade;
            }
        }
    }

    static int calculateOverallGrade(int studentId) {
        int totalGrades = 0;

        for (Enrollment enrollment : enrollments) {
            if (enrollment.student.getId() == studentId) {
                totalGrades += enrollment.grade;
            }
        }

        return totalGrades;
    }

    // =====================|Helper Methods|=====================

    static Course findCourseByCode(String code) {

        for (Course course : courses) {
            if (course.getCode() == code) {
                return course;
            }
        }
        return null;
    }

    static Student findStudentById(int id) {

        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    static Student findStudentByName(String name) {

        for (Student student : students) {
            if (student.getName() == name) {
                return student;
            }
        }
        return null;

    }

    static boolean courseExists(String code) {
        for (Course course : courses) {
            if (course.getCode() == code) {
                return true;
            }
        }

        return false;
    }

    static boolean StudentExists(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return true;
            }
        }

        return false;
    }
}

class AdministratorInterface {
    int choice = 0;
    Scanner scanner;

    public AdministratorInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public void launch() {
        do {
            // Display menu options
            System.out.println("\n========| University Enrollment and Grading System |========\n");
            System.out.println("1. Add New Course");
            System.out.println("2. Add New Student");
            System.out.println("3. Enroll Student to Course");
            System.out.println("4. Assign Grade");
            System.out.println("5. Calculate Overall Grade");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> addCourse();
                case 2 -> addStudent();
                case 3 -> enrollStudent();
                case 4 -> assignGrade();
                case 5 -> calculateOverallGrade();
                case 6 -> System.out.println("Exiting system... Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);
    }

    private void addCourse() {
        System.out.print("Enter Course Code: ");
        String code = scanner.nextLine();
        System.out.print("Enter Course Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();

        Message result = CourseManagement.addCourse(code, name, capacity);
        System.out.println("Result: " + result);
    }

    private void addStudent() {
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        CourseManagement.addStudent(name);
        System.out.println("Student added successfully.");
    }

    private void enrollStudent() {
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();

        Message result = CourseManagement.enrollStudent(studentId, courseCode);
        System.out.println("Result: " + result);
    }

    private void assignGrade() {
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();
        System.out.print("Enter Grade: ");
        int grade = scanner.nextInt();
        scanner.nextLine();

        CourseManagement.assignGrade(studentId, courseCode, grade);
        System.out.println("Grade assigned successfully.");
    }

    private void calculateOverallGrade() {
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        int totalGrade = CourseManagement.calculateOverallGrade(studentId);
        System.out.println("Overall grade for student " + studentId + " is: " + totalGrade);
    }
}