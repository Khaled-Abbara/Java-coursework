import java.util.ArrayList;
import java.util.Scanner;

// =====================| MAIN |=====================
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdministratorInterface adminInterface = new AdministratorInterface(scanner);
        adminInterface.launch();
    }

    static <T> int findEmptyIndex(T[] array) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == null) {
                return index;
            }
        }
        return -1;
    }
}

// =====================| ENUM |=====================
enum Message {
    SUCCESS,
    INDEX_OUT_OF_BOUNDS,
    ARRAY_IS_FULL,
    COURSE_ALREADY_EXISTS,
    INCORRECT_COURSE_CODE,
    INCORRECT_STUDENT_ID,
    INCORRECT_STUDENT_NAME
}

// =====================| STUDENT CLASS |=====================
class Student {
    private static int idCounter = 0;
    private final int id;
    private String name;
    private ArrayList<Course> enrolledCourses = new ArrayList<>();
    private ArrayList<Integer> grades = new ArrayList<>();

    public Student(String name) {
        this.id = ++idCounter;
        this.name = name;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Instance Methods
    public void enrollCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            grades.add(-1); // placeholder for unassigned grade
        }
    }

    public void assignGrade(Course course, int grade) {
        int index = enrolledCourses.indexOf(course);
        if (index != -1) {
            grades.set(index, grade);
        }
    }

    public int calculateOverallGrade() {
        int total = 0, count = 0;
        for (int grade : grades) {
            if (grade >= 0) {
                total += grade;
                count++;
            }
        }
        return count == 0 ? 0 : total / count;
    }

    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }
}

// =====================| COURSE CLASS |=====================
class Course {
    private String code;
    private String name;
    private int capacity;
    private static int totalEnrolledStudents = 0;

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
        totalEnrolledStudents++;
    }
}

// =====================| ENROLLMENT CLASS |=====================
class Enrollment {
    private String compositeId;
    private Course course;
    private Student student;
    private int grade;

    public Enrollment(Course course, Student student) {
        this.course = course;
        this.student = student;
        this.grade = -1;
        this.compositeId = course.getCode() + "_" + student.getId();
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

    public void setGrade(int grade) {
        this.grade = grade;
    }
}

// =====================| COURSE MANAGEMENT |=====================
class CourseManagement {
    private static Student[] students = new Student[500];
    private static Course[] courses = new Course[5];
    private static ArrayList<Enrollment> enrollments = new ArrayList<>();

    // Add new student
    static void addStudent(String name) {
        int index = Main.findEmptyIndex(students);
        if (index != -1) {
            students[index] = new Student(name);
        } else {
            System.out.println("Student array is full.");
        }
    }

    // Add new course
    static Message addCourse(String code, String name, int capacity) {
        if (courseExists(code))
            return Message.COURSE_ALREADY_EXISTS;

        int index = Main.findEmptyIndex(courses);
        if (index == -1)
            return Message.ARRAY_IS_FULL;

        courses[index] = new Course(code, name, capacity);
        return Message.SUCCESS;
    }

    // Enroll student
    static Message enrollStudent(int studentId, String courseCode) {
        if (!studentExists(studentId))
            return Message.INCORRECT_STUDENT_ID;

        if (!courseExists(courseCode))
            return Message.INCORRECT_COURSE_CODE;

        Student targetStudent = findStudentById(studentId);
        Course targetCourse = findCourseByCode(courseCode);

        targetStudent.enrollCourse(targetCourse);
        enrollments.add(new Enrollment(targetCourse, targetStudent));
        Course.incrementTotalEnrolledStudents();
        return Message.SUCCESS;
    }

    // Assign grade
    static void assignGrade(int studentId, String courseCode, int grade) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent().getId() == studentId &&
                    enrollment.getCourse().getCode().equals(courseCode)) {
                enrollment.setGrade(grade);
                enrollment.getStudent().assignGrade(enrollment.getCourse(), grade);
            }
        }
    }

    // Calculate overall grade
    static int calculateOverallGrade(int studentId) {
        Student student = findStudentById(studentId);
        return (student != null) ? student.calculateOverallGrade() : 0;
    }

    // View Methods
    static void viewAllStudents() {
        System.out.println("Student Id, Name");
        System.out.println("_________________________________________________________");
        for (Student student : students) {
            if (student != null)
                System.out.println(student.getId() + " , " + student.getName());
        }
        System.out.println("_________________________________________________________");
    }

    static void viewAllCourses() {
        System.out.println("Course Code, Name, Capacity");
        System.out.println("_________________________________________________________");
        for (Course course : courses) {
            if (course != null)
                System.out.println(course.getCode() + " , " + course.getName() + " , " + course.getCapacity());
        }
        System.out.println("_________________________________________________________");
    }

    static void viewAllEnrollments() {
        System.out.println("Course Code, Student Id, Grade");
        System.out.println("_________________________________________________________");
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.getCourse().getCode() + " , " + enrollment.getStudent().getId()
                    + " , " + enrollment.getGrade());
        }
        System.out.println("_________________________________________________________");
    }

    // Helper methods
    static Course findCourseByCode(String code) {
        for (Course course : courses) {
            if (course != null && course.getCode().equals(code))
                return course;
        }
        return null;
    }

    static Student findStudentById(int id) {
        for (Student student : students) {
            if (student != null && student.getId() == id)
                return student;
        }
        return null;
    }

    static boolean courseExists(String code) {
        for (Course course : courses) {
            if (course != null && course.getCode().equals(code))
                return true;
        }
        return false;
    }

    static boolean studentExists(int id) {
        for (Student student : students) {
            if (student != null && student.getId() == id)
                return true;
        }
        return false;
    }
}

// =====================| ADMINISTRATOR INTERFACE |=====================
class AdministratorInterface {
    private int choice = 0;
    private Scanner scanner;

    public AdministratorInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public void launch() {
        do {
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
            scanner.nextLine();

            switch (choice) {
                case 1 -> handleAddCourse();
                case 2 -> handleAddStudent();
                case 3 -> handleEnrollStudent();
                case 4 -> handleAssignGrade();
                case 5 -> handleCalculateOverallGrade();
                case 6 -> handleViewAllStudents();
                case 7 -> handleViewAllCourses();
                case 8 -> handleViewAllEnrollments();
                case 9 -> System.out.println("Exiting system... Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);
    }

    private void handleAddCourse() {
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

    private void handleAddStudent() {
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        CourseManagement.addStudent(name);
        System.out.println("Student added successfully.");
    }

    private void handleEnrollStudent() {
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();

        Message result = CourseManagement.enrollStudent(studentId, courseCode);
        System.out.println("Result: " + result);
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

        CourseManagement.assignGrade(studentId, courseCode, grade);
        System.out.println("Grade assigned successfully.");
    }

    private void handleCalculateOverallGrade() {
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        int totalGrade = CourseManagement.calculateOverallGrade(studentId);
        System.out.println("Overall grade for student " + studentId + " is: " + totalGrade);
    }

    private void handleViewAllStudents() {
        CourseManagement.viewAllStudents();
    }

    private void handleViewAllCourses() {
        CourseManagement.viewAllCourses();
    }

    private void handleViewAllEnrollments() {
        CourseManagement.viewAllEnrollments();
    }
}
