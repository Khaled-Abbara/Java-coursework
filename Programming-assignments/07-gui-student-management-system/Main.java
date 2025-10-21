import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Initialize system with sample data
        StudentSystem studentSystem = new StudentSystem(100);
        studentSystem.addStudent("Khaled Abbara", 11, 6);
        studentSystem.addStudent("Karel van zijil", 12, 4);
        studentSystem.addStudent("Dana Banana", 8, 2);
        studentSystem.addStudent("Leeanah Tanis", 12, 7);

        // Create frame
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Student Record Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 350);
            frame.setLocationRelativeTo(null);
            frame.setContentPane(new Dashboard(studentSystem, frame).getPanel());
            frame.setVisible(true);
        });
    }
}

class Dashboard {
    private final StudentSystem studentSystem;
    private final JFrame frame;
    private final JPanel panel;

    public Dashboard(StudentSystem studentSystem, JFrame frame) {
        this.studentSystem = studentSystem;
        this.frame = frame;
        this.panel = createPanel();
    }

    public JPanel getPanel() {
        return panel;
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        String[] actions = {
                "View All Students",
                "Total Students",
                "Last Student ID",
                "Add Student",
                "Update Student",
                "Find Student by ID",
                "Exit"
        };

        for (int i = 0; i < actions.length; i++) {
            JButton button = new JButton(actions[i]);
            final int index = i;
            button.addActionListener(e -> handleAction(index));
            panel.add(button);
        }

        return panel;
    }

    private void handleAction(int index) {
        switch (index) {
            case 0 -> viewAllStudents();
            case 1 -> showMessage("Total Students: " + StudentSystem.totalStudents);
            case 2 -> showMessage("Last Student ID: " + Student.getLastId());
            case 3 -> addStudent();
            case 4 -> updateStudent();
            case 5 -> findStudent();
            case 6 -> System.exit(0);
        }
    }

    private void viewAllStudents() {
        if (StudentSystem.totalStudents == 0) {
            showMessage("No students found.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < StudentSystem.totalStudents; i++) {
            Student s = StudentSystem.students[i];
            sb.append(String.format("ID: %d | Name: %s | Age: %d | Grade: %d%n",
                    s.getId(), s.getName(), s.getAge(), s.getGrade()));
        }

        showMessage(sb.toString(), "All Students");
    }

    private void addStudent() {
        try {
            String name = prompt("Enter student name:");
            if (name == null)
                return;
            int age = Integer.parseInt(prompt("Enter student age:"));
            int grade = Integer.parseInt(prompt("Enter student grade:"));

            studentSystem.addStudent(name, age, grade);
            showMessage("Student added successfully!");
        } catch (Exception e) {
            showError("Invalid input. Please try again.");
        }
    }

    private void updateStudent() {
        try {
            int id = Integer.parseInt(prompt("Enter student ID to update:"));
            Student student = studentSystem.findStudentById(id);
            if (student == null) {
                showMessage("Student not found!");
                return;
            }

            String field = prompt("Enter field to update (name / age / grade):");
            String newValue = prompt("Enter new value:");
            StudentSystem.updateStudent(student, field, newValue);
            showMessage("Student updated successfully!");
        } catch (Exception e) {
            showError("Error updating student.");
        }
    }

    private void findStudent() {
        try {
            int id = Integer.parseInt(prompt("Enter student ID:"));
            Student s = studentSystem.findStudentById(id);
            if (s == null) {
                showMessage("Student not found.");
                return;
            }

            String info = String.format("""
                    ID: %d
                    Name: %s
                    Age: %d
                    Grade: %d
                    """, s.getId(), s.getName(), s.getAge(), s.getGrade());
            showMessage(info, "Student Info");
        } catch (Exception e) {
            showError("Invalid input.");
        }
    }

    // Helper methods for dialogs
    private String prompt(String message) {
        return JOptionPane.showInputDialog(frame, message);
    }

    private void showMessage(String msg) {
        JOptionPane.showMessageDialog(frame, msg);
    }

    private void showMessage(String msg, String title) {
        JOptionPane.showMessageDialog(frame, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }

    private void showError(String msg) {
        JOptionPane.showMessageDialog(frame, msg, "Error", JOptionPane.ERROR_MESSAGE);
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
