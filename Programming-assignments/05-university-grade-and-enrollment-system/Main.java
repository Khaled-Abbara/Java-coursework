
/**
 * ============================================================
 *  University Enrollment and Grading System
 * ------------------------------------------------------------
 *  Description:
 *  This program simulates a simple university enrollment and grading system.
 *  It allows administrators to:
 *      - Add new students and courses
 *      - Enroll students into courses
 *      - Assign grades
 *      - Calculate overall grades
 *      - View student, course, and enrollment information
 * 
 * 
 * ============================================================
 *  PROGRAM STRUCTURE OVERVIEW
 * ------------------------------------------------------------
 *  The program is organized into several modular classes,
 *  each responsible for a specific part of the university
 *  enrollment and grading system.
 * 
 *  1. Main Class:
 *      - Entry point of the program.
 *      - Initializes the AdministratorInterface and starts the CLI.
 *      - Contains a generic helper method findEmptyIndex() for arrays.
 * 
 *  2. Message Enum:
 *      - Defines consistent feedback messages (SUCCESS, ERROR, INFO).
 *      - Used throughout the system for readable and maintainable output.
 * 
 *  3. Student Class:
 *      - Represents a student entity with ID, name, enrolled courses, and grades.
 *      - Uses encapsulation to protect student data.
 *      - Provides methods for enrolling in courses, assigning grades,
 *        and calculating overall grade performance.
 * 
 *  4. Course Class:
 *      - Represents a university course with a code, name, and capacity.
 *      - Tracks the total number of enrolled students via a static variable.
 * 
 *  5. Enrollment Class:
 *      - Represents the link between a Student and a Course.
 *      - Stores the assigned grade for that specific pairing.
 *      - Used to implement the **many-to-many relationship** between Students and Courses:
 *          → A Student can enroll in many Courses.
 *          → A Course can have many Students.
 *      - Each Enrollment instance uniquely associates one Student with one Course.
 * 
 *  6. CourseManagement Class:
 *      - Acts as the main system controller or "backend service".
 *      - Manages arrays of Students and Courses, and an ArrayList of Enrollments.
 *      - Provides static methods for adding, enrolling, grading, and viewing data.
 * 
 *  7. AdministratorInterface Class:
 *      - Provides a command-line interface (CLI) for administrators.
 *      - Handles input/output and delegates operations to CourseManagement.
 * 
 *  ------------------------------------------------------------
 *  Flow of Execution:
 *     Main → AdministratorInterface → CourseManagement → (Student / Course / Enrollment)
 * 
 * 
 * ============================================================
 *  DESIGN CHOICES
 * ------------------------------------------------------------
 *  • Object-Oriented Structure:
 *      - The system is fully object-oriented, separating logic by responsibility.
 *      - Each class mirrors a real-world concept (Student, Course, Enrollment).
 * 
 *  • Encapsulation:
 *      - All key variables are private with controlled access through getters/setters.
 *      - Prevents unauthorized direct modification of student or course data.
 * 
 *  • Many-to-Many Relationship Representation:
 *      - The Enrollment class serves as an intermediary entity that models
 *        the many-to-many relationship between Students and Courses.
 *      - This approach ensures scalable management of enrollments and grades
 *        without duplicating course or student data.
 * 
 *  • Static vs Instance Methods:
 *      - CourseManagement methods are static because they perform system-wide operations
 *        and do not depend on individual object state.
 *      - Student and Course use instance methods to maintain individual object behavior.
 * 
 *  • Use of Enum (Message):
 *      - The Message enum centralizes system messages for easier maintenance.
 *      - Improves readability and prevents hardcoding repeated text.
 * 
 *  • Data Structures:
 *      - Arrays used for Students and Courses to simulate fixed capacity.
 *      - ArrayList used for Enrollments for dynamic, scalable storage.
 * 
 *  • Error Handling and Feedback:
 *      - Methods return Message enums instead of raw strings or codes.
 *      - Provides consistent, user-friendly feedback throughout the system.
 * 
 *  • CLI Design:
 *      - Simple, menu-based administrator interface using Scanner for input.
 *      - Each option maps clearly to a specific system operation.
 * 
 *  • Grade Management:
 *      - Each Student keeps a parallel ArrayList of grades matching enrolled courses.
 *      - The Enrollment class also stores grades, ensuring consistent tracking.
 * 
 * 
 * ============================================================
 *  CRITERIA SATISFACTION
 * ------------------------------------------------------------
 * 
 *  1. Encapsulation:
 *      - Used in the Student, Course, and Enrollment classes.
 *      - All key variables are private to protect data and maintain control.
 * 
 *  2. Getters and Setters:
 *      - Added in the Student class to access and modify private data safely.
 *      - Example methods: getName(), setName(), getId().
 * 
 *  3. Instance Methods:
 *      - The Student class includes methods that update an object’s state:
 *        enrollCourse(), assignGrade(), and calculateOverallGrade().
 * 
 *  4. Student Data Management:
 *      - Student information (name, ID, enrolledCourses, and grades) is stored
 *        using private variables to ensure encapsulation.
 * 
 *  5. Course Enrollment:
 *      - The enrollCourse() method adds a course to a student’s list while
 *        checking for duplicates to prevent re-enrollment.
 * 
 *  6. Grade Assignment:
 *      - The assignGrade() method updates a student’s grade for a specific course.
 * 
 *  7. Course Data Encapsulation:
 *      - Course class stores details like code, name, and capacity in private fields.
 *      - Accessed through getter methods such as getCode(), getName(), and getCapacity().
 * 
 *  8. Static Tracking:
 *      - Course class includes a static variable to count total enrolled students.
 *      - Updated using incrementTotalEnrolledStudents().
 * 
 *  9. Centralized System Management:
 *      - CourseManagement class holds static arrays/lists for students, courses,
 *        and enrollments to manage all records in one place.
 * 
 * 10. Static Operations:
 *      - Major system functions (addCourse, addStudent, enrollStudent, assignGrade,
 *        calculateOverallGrade) are implemented as static methods in CourseManagement.
 * 
 * 11. Input Handling:
 *      - AdministratorInterface class handles all user input and validation,
 *        then passes data to CourseManagement for processing.
 * 
 * 12. Command-Line Interface:
 *      - The menu-driven interface in AdministratorInterface provides easy navigation
 *        for adding students, courses, enrollments, and viewing reports.
 * 
 * 13. Class Interaction:
 *      - The system follows a clear flow:
 *        AdministratorInterface → CourseManagement → Student/Course/Enrollment classes.
 * 
 * 
 * ============================================================
 *  LEARNING OUTCOMES AND REFLECTION
 *  ------------------------------------------------------------
 * 
 *  • I learned how to use enums in Java to organize and manage constant values
 *    like success, error, and info messages in a clean and maintainable way.
 *    The `Message` enum provides structured feedback across the system.
 * 
 *  • I learned how to **design complex object-oriented classes** that work together.
 *    For example, the Student class interacts with Course and Enrollment objects,
 *    demonstrating relationships between real-world entities.
 * 
 *  • I learned how to use Java Generics (`<T>`) to write reusable methods that
 *    can work with multiple data types, such as in `Main.findEmptyIndex(T[] array)`.
 * 
 *  • I learned how to use ArrayLists more effectively for storing dynamic data
 *    such as enrolled courses and student grades. I now understand how to use
 *    ArrayList methods like add(), contains(), indexOf(), and set() to manage lists.
 * 
 * 
 * ============================================================
 *  Conclusion:
 * ------------------------------------------------------------
 *  This project demonstrates strong understanding of:
 *      - Encapsulation and data protection
 *      - Getter and setter implementation
 *      - Static and instance method design
 *      - Use of enums, generics, and ArrayLists
 *      - Class relationships and interactive CLI design
 * 
 * 
**/

import java.util.ArrayList;
import java.util.Scanner;

// =====================| MAIN |=====================
// Entry point of the program
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdministratorInterface adminInterface = new AdministratorInterface(scanner);
        adminInterface.launch(); // start the admin menu
    }

    // Utility method to find empty index in an array
    static <T> int findEmptyIndex(T[] array) {
        // loop to find first null (empty) slot in the array
        for (int index = 0; index < array.length; index++) {
            if (array[index] == null) {
                return index;
            }
        }
        return -1; // no empty index found
    }
}

// =====================| ENUM |=====================
// Centralized message handler for feedback and errors
enum Message {
    // ---------- SUCCESS MESSAGES ----------
    SUCCESS_GENERAL("Operation completed successfully."),
    SUCCESS_COURSE_ADDED("Course added successfully."),
    SUCCESS_STUDENT_ADDED("Student added successfully."),
    SUCCESS_ENROLLMENT("Student enrolled in course successfully."),
    SUCCESS_GRADE_ASSIGNED("Grade assigned successfully."),
    SUCCESS_CALCULATION_DONE("Overall grade calculated successfully."),

    // ---------- ERROR MESSAGES ----------
    ERROR_INDEX_OUT_OF_BOUNDS("Index is out of bounds. Please check your input."),
    ERROR_ARRAY_FULL("The array is full. Cannot add more entries."),
    ERROR_COURSE_EXISTS("A course with this code already exists."),
    ERROR_COURSE_CODE_INVALID("Invalid course code. Please try again."),
    ERROR_STUDENT_ID_INVALID("Invalid student ID. Please try again."),
    ERROR_STUDENT_NAME_INVALID("Invalid or empty student name."),
    ERROR_STUDENT_NOT_FOUND("Student not found in the system."),
    ERROR_COURSE_NOT_FOUND("Course not found in the system."),
    ERROR_ENROLLMENT_EXISTS("Student is already enrolled in this course."),
    ERROR_UNKNOWN("An unknown error occurred. Please contact the administrator."),

    // ---------- INFO MESSAGES ----------
    INFO_NO_ENROLLMENTS("No enrollments found."),
    INFO_NO_STUDENTS("No students found in the system."),
    INFO_NO_COURSES("No courses available.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public void print() {
        System.out.println(message);
    }

    @Override
    public String toString() {
        return message;
    }
}

// =====================| STUDENT CLASS |=====================
// Represents a student with ID, name, courses, and grades
class Student {
    private static int idCounter = 0; // auto-increment ID
    private final int id;
    private String name;
    private ArrayList<Course> enrolledCourses = new ArrayList<>();
    private ArrayList<Integer> grades = new ArrayList<>();

    public Student(String name) {
        this.id = ++idCounter; // assign unique ID
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Enrolls the student in a new course
    public void enrollCourse(Course course) {
        // avoid duplicate course enrollment
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            grades.add(-1); // -1 indicates grade not assigned yet
        }
    }

    // Assigns grade to a specific course
    public void assignGrade(Course course, int grade) {
        // find index of course to update the corresponding grade
        int index = enrolledCourses.indexOf(course);
        if (index != -1)
            grades.set(index, grade);
    }

    // Calculates overall average grade
    public int calculateOverallGrade() {
        int total = 0, count = 0;
        for (int grade : grades) {
            // ignore unassigned grades (-1)
            if (grade >= 0) {
                total += grade;
                count++;
            }
        }
        // return average or 0 if no valid grades
        return count == 0 ? 0 : total / count;
    }

    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }
}

// =====================| COURSE CLASS |=====================
// Represents a course with code, name, and capacity
class Course {
    private String code;
    private String name;
    private int capacity;
    private static int totalEnrolledStudents = 0; // global tracker

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

    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }

    public static void incrementTotalEnrolledStudents() {
        totalEnrolledStudents++; // update global enrollment count
    }
}

// =====================| ENROLLMENT CLASS |=====================
// Links a student to a course and stores grade
class Enrollment {
    private String compositeId; // unique combination of course + student ID
    private Course course;
    private Student student;
    private int grade;

    public Enrollment(Course course, Student student) {
        this.course = course;
        this.student = student;
        this.grade = -1; // not yet graded
        this.compositeId = course.getCode() + "_" + student.getId(); // unique key
    }

    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }

    public int getGrade() {
        return grade;
    }

    public String getCompositeId() {
        return compositeId;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}

// =====================| COURSE MANAGEMENT |=====================
// Handles logic for students, courses, and enrollments
class CourseManagement {
    private static Student[] students = new Student[500];
    private static Course[] courses = new Course[5];
    private static ArrayList<Enrollment> enrollments = new ArrayList<>();

    // Add new course
    static Message addCourse(String code, String name, int capacity) {
        // check for duplicates before adding
        if (courseExists(code))
            return Message.ERROR_COURSE_EXISTS;

        // find free index to store the new course
        int index = Main.findEmptyIndex(courses);
        if (index == -1)
            return Message.ERROR_ARRAY_FULL;

        courses[index] = new Course(code, name, capacity);
        return Message.SUCCESS_COURSE_ADDED;
    }

    // Add new student
    static Message addStudent(String name) {
        // find free slot in student array
        int index = Main.findEmptyIndex(students);
        if (index != -1) {
            students[index] = new Student(name);
            return Message.SUCCESS_STUDENT_ADDED;
        } else
            return Message.ERROR_ARRAY_FULL;
    }

    // Enroll student to a course
    static Message enrollStudent(int studentId, String courseCode) {
        // validate IDs before processing
        if (!studentExists(studentId))
            return Message.ERROR_STUDENT_ID_INVALID;
        if (!courseExists(courseCode))
            return Message.ERROR_COURSE_CODE_INVALID;

        // get student and course objects
        Student targetStudent = findStudentById(studentId);
        Course targetCourse = findCourseByCode(courseCode);

        // prevent duplicate enrollment
        if (targetStudent.getEnrolledCourses().contains(targetCourse))
            return Message.ERROR_ENROLLMENT_EXISTS;

        // create link and update tracking structures
        targetStudent.enrollCourse(targetCourse);
        enrollments.add(new Enrollment(targetCourse, targetStudent));
        Course.incrementTotalEnrolledStudents();
        return Message.SUCCESS_ENROLLMENT;
    }

    // Assign grade to a student in a course
    static Message assignGrade(int studentId, String courseCode, int grade) {
        // iterate over enrollments to find matching record
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent().getId() == studentId &&
                    enrollment.getCourse().getCode().equals(courseCode)) {
                // update both enrollment and student record
                enrollment.setGrade(grade);
                enrollment.getStudent().assignGrade(enrollment.getCourse(), grade);
                return Message.SUCCESS_GRADE_ASSIGNED;
            }
        }
        // no match found
        return Message.ERROR_ENROLLMENT_EXISTS;
    }

    // Calculate average grade of a student
    static int calculateOverallGrade(int studentId) {
        Student student = findStudentById(studentId);
        return (student != null) ? student.calculateOverallGrade() : 0;
    }

    // Display all students
    static void viewAllStudents() {
        System.out.println("\nStudent Id, Name");
        System.out.println("-------------------------------------------------");
        boolean found = false;

        for (Student student : students) {
            if (student != null) {
                found = true;
                System.out.println(student.getId() + " , " + student.getName());
            }
        }

        if (!found)
            Message.INFO_NO_STUDENTS.print();
        System.out.println("-------------------------------------------------");
    }

    // Display all courses
    static void viewAllCourses() {
        System.out.println("\nCourse Code, Name, Capacity");
        System.out.println("-------------------------------------------------");
        boolean found = false;

        for (Course course : courses) {
            if (course != null) {
                found = true;
                System.out.println(course.getCode() + " , " + course.getName() + " , " + course.getCapacity());
            }
        }

        if (!found)
            Message.INFO_NO_COURSES.print();
        System.out.println("-------------------------------------------------");
    }

    // Display all enrollments
    static void viewAllEnrollments() {
        System.out.println("\nCourse Code + Student Id, Name, Grade");
        System.out.println("-------------------------------------------------");

        if (enrollments.isEmpty()) {
            Message.INFO_NO_ENROLLMENTS.print();
        } else {
            // print each enrollment info line by line
            for (Enrollment enrollment : enrollments) {
                System.out.println(enrollment.getCompositeId() + " , " +
                        enrollment.getStudent().getName() + " , " + enrollment.getGrade());
            }
        }
        System.out.println("-------------------------------------------------");
    }

    // ---------- Helper methods ----------
    static Course findCourseByCode(String code) {
        for (Course course : courses)
            if (course != null && course.getCode().equals(code))
                return course;
        return null;
    }

    static Student findStudentById(int id) {
        for (Student student : students)
            if (student != null && student.getId() == id)
                return student;
        return null;
    }

    static boolean courseExists(String code) {
        for (Course course : courses)
            if (course != null && course.getCode().equals(code))
                return true;
        return false;
    }

    static boolean studentExists(int id) {
        for (Student student : students)
            if (student != null && student.getId() == id)
                return true;
        return false;
    }
}

// =====================| ADMINISTRATOR INTERFACE |=====================
// Handles user interaction through a simple menu
class AdministratorInterface {
    private int choice = 0;
    private Scanner scanner;

    public AdministratorInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    // Main loop for menu options
    public void launch() {
        do {
            // menu display block
            System.out.println("\n========| University Enrollment and Grading System |========\n");
            System.out.println("1. Add New Course");
            System.out.println("2. Add New Student");
            System.out.println("3. Enroll Student to Course");
            System.out.println("4. Assign Grade");
            System.out.println("5. Calculate Overall Grade");
            System.out.println("---------------------------------");
            System.out.println("6. View Student list");
            System.out.println("7. View Course list");
            System.out.println("8. View Enrollment list");
            System.out.println("---------------------------------");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline

            // switch to handle user choice
            switch (choice) {
                case 1 -> handleAddCourse();
                case 2 -> handleAddStudent();
                case 3 -> handleEnrollStudent();
                case 4 -> handleAssignGrade();
                case 5 -> handleCalculateOverallGrade();
                case 6 -> CourseManagement.viewAllStudents();
                case 7 -> CourseManagement.viewAllCourses();
                case 8 -> CourseManagement.viewAllEnrollments();
                case 9 -> System.out.println("Exiting system... Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9); // repeat until user chooses to exit
    }

    // Menu option handlers
    private void handleAddCourse() {
        System.out.print("Enter Course Code: ");
        String code = scanner.nextLine();
        System.out.print("Enter Course Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();

        Message result = CourseManagement.addCourse(code, name, capacity);
        System.out.println(result);
    }

    private void handleAddStudent() {
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        Message result = CourseManagement.addStudent(name);
        System.out.println(result);
    }

    private void handleEnrollStudent() {
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();
        Message result = CourseManagement.enrollStudent(studentId, courseCode);
        System.out.println(result);
    }

    private void handleAssignGrade() {
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();
        System.out.print("Enter Grade: ");
        int grade = scanner.nextInt();
        scanner.nextLine();
        Message result = CourseManagement.assignGrade(studentId, courseCode, grade);
        System.out.println(result);
    }

    private void handleCalculateOverallGrade() {
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();
        int totalGrade = CourseManagement.calculateOverallGrade(studentId);
        System.out.println("Overall grade for student " + studentId + " is: " + totalGrade);
    }
}
