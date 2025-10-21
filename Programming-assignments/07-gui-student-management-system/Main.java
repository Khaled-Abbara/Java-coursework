import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Initialize system with sample data
        StudentSystem studentSystem = new StudentSystem(100);
        studentSystem.addStudent("Khaled Abbara", 11, 6);
        studentSystem.addStudent("Karel van zijil", 12, 4);
        studentSystem.addStudent("Dana Banana", 8, 2);
        studentSystem.addStudent("Safa Saber", 12, 7);

        // Create frame
        JFrame frame = new JFrame("Student Record Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Create dashboard (GUI)
        Dashboard dashboard = new Dashboard(studentSystem, frame);
        frame.add(dashboard.getPanel());

        frame.setVisible(true);
    }
}

class Dashboard {
    private final StudentSystem studentSystem;
    private final JFrame frame;
    private final JPanel panel;

    public Dashboard(StudentSystem studentSystem, JFrame frame) {
        this.studentSystem = studentSystem;
        this.frame = frame;
        this.panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        String[] buttons = {
                "1. View all student records",
                "2. View total number of students",
                "3. View last ID",
                "4. Add a new student",
                "5. Change student details",
                "6. Find a student by ID",
                "7. Exit"
        };

        for (int i = 0; i < buttons.length; i++) {
            JButton btn = new JButton(buttons[i]);
            final int index = i;
            btn.addActionListener(e -> handleAction(index));
            panel.add(btn);
        }
    }

    public JPanel getPanel() {
        return panel;
    }

    private void handleAction(int index) {
        switch (index) {
            case 0 -> viewAllStudents();
            case 1 -> viewTotalStudents();
            case 2 -> viewLastId();
            case 3 -> addStudent();
            case 4 -> updateStudent();
            case 5 -> findStudent();
            case 6 -> System.exit(0);
        }
    }

    private void viewAllStudents() {
        if (StudentSystem.totalStudents == 0) {
            JOptionPane.showMessageDialog(frame, "No students found.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < StudentSystem.totalStudents; i++) {
            Student s = StudentSystem.students[i];
            sb.append("ID: ").append(s.getId())
                    .append(", Name: ").append(s.getName())
                    .append(", Age: ").append(s.getAge())
                    .append(", Grade: ").append(s.getGrade())
                    .append("\n");
        }

        JOptionPane.showMessageDialog(frame, sb.toString(), "All Students", JOptionPane.INFORMATION_MESSAGE);
    }

    private void viewTotalStudents() {
        JOptionPane.showMessageDialog(frame, "Total Students: " + StudentSystem.totalStudents);
    }

    private void viewLastId() {
        JOptionPane.showMessageDialog(frame, "Last Student ID: " + Student.getLastId());
    }

    private void addStudent() {
        try {
            String name = JOptionPane.showInputDialog(frame, "Enter student name:");
            if (name == null)
                return;

            String ageStr = JOptionPane.showInputDialog(frame, "Enter student age:");
            if (ageStr == null)
                return;
            int age = Integer.parseInt(ageStr);

            String gradeStr = JOptionPane.showInputDialog(frame, "Enter student grade:");
            if (gradeStr == null)
                return;
            int grade = Integer.parseInt(gradeStr);

            studentSystem.addStudent(name, age, grade);
            JOptionPane.showMessageDialog(frame, "Student added successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Invalid input. Please try again.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateStudent() {
        try {
            String idStr = JOptionPane.showInputDialog(frame, "Enter student ID to update:");
            if (idStr == null)
                return;
            int id = Integer.parseInt(idStr);

            Student student = studentSystem.findStudentById(id);
            if (student == null) {
                JOptionPane.showMessageDialog(frame, "Student not found!");
                return;
            }

            String field = JOptionPane.showInputDialog(frame, "Enter field to update (name/age/grade):");
            if (field == null)
                return;
            String newValue = JOptionPane.showInputDialog(frame, "Enter new value:");
            if (newValue == null)
                return;

            StudentSystem.updateStudent(student, field, newValue);
            JOptionPane.showMessageDialog(frame, "Student updated successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error updating student.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void findStudent() {
        try {
            String idStr = JOptionPane.showInputDialog(frame, "Enter student ID:");
            if (idStr == null)
                return;
            int id = Integer.parseInt(idStr);

            Student s = studentSystem.findStudentById(id);
            if (s == null) {
                JOptionPane.showMessageDialog(frame, "Student not found.");
                return;
            }

            String info = "ID: " + s.getId() +
                    "\nName: " + s.getName() +
                    "\nAge: " + s.getAge() +
                    "\nGrade: " + s.getGrade();

            JOptionPane.showMessageDialog(frame, info, "Student Info", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Invalid input.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

// Same Student and StudentSystem classes as before (unchanged)
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
            JOptionPane.showMessageDialog(null, "Error: Student list is full.");
            return;
        }
        students[totalStudents++] = new Student(name, age, grade);
    }

    public Student findStudentById(int id) {
        for (int i = 0; i < totalStudents; i++) {
            if (students[i].getId() == id)
                return students[i];
        }
        return null;
    }

    public static void updateStudent(Student student, String variable, String newValue) {
        switch (variable.toLowerCase()) {
            case "name" -> student.setName(newValue);
            case "age" -> student.setAge(Integer.parseInt(newValue));
            case "grade" -> student.setGrade(Integer.parseInt(newValue));
            default -> JOptionPane.showMessageDialog(null, "Invalid field name.");
        }
    }
}
