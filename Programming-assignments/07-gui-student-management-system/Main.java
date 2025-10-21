import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Initialize system with sample data
        StudentSystem studentSystem = new StudentSystem(100);
        studentSystem.addStudent("Khaled Abbara", 11, 6);
        studentSystem.addStudent("Karel van zijil", 12, 4);
        studentSystem.addStudent("Dana Banana", 8, 2);
        studentSystem.addStudent("Leeanah Tanis", 12, 7);

        // Create and show the frame
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Student Record Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 400);
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

    // Dark theme colors
    private final Color bgColor = new Color(40, 44, 52);
    private final Color btnColor = new Color(60, 63, 70);
    private final Color textColor = new Color(220, 220, 220);
    private final Color accentColor = new Color(85, 170, 255);

    public Dashboard(StudentSystem studentSystem, JFrame frame) {
        this.studentSystem = studentSystem;
        this.frame = frame;
        this.panel = createPanel();
    }

    public JPanel getPanel() {
        return panel;
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 1, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        panel.setBackground(bgColor);

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
            JButton button = createStyledButton(actions[i]);
            final int index = i;
            button.addActionListener(e -> handleAction(index));
            panel.add(button);
        }

        return panel;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(btnColor);
        button.setForeground(textColor);
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setBorder(BorderFactory.createLineBorder(accentColor, 1));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return button;
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

        // Create table data
        String[] columns = { "ID", "Name", "Age", "Grade" };
        Object[][] data = new Object[StudentSystem.totalStudents][4];
        for (int i = 0; i < StudentSystem.totalStudents; i++) {
            Student s = StudentSystem.students[i];
            data[i][0] = s.getId();
            data[i][1] = s.getName();
            data[i][2] = s.getAge();
            data[i][3] = s.getGrade();
        }

        JTable table = new JTable(new DefaultTableModel(data, columns));
        styleTable(table);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(bgColor);
        scrollPane.setPreferredSize(new Dimension(450, 200));

        JOptionPane.showMessageDialog(frame, scrollPane, "All Students", JOptionPane.PLAIN_MESSAGE);
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

    // ----------------- UI Helper Methods -----------------
    private void styleTable(JTable table) {
        table.setEnabled(false);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        table.setRowHeight(24);
        table.setForeground(textColor);
        table.setBackground(new Color(50, 54, 61));
        table.setGridColor(new Color(80, 80, 80));
        table.getTableHeader().setBackground(btnColor);
        table.getTableHeader().setForeground(accentColor);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
    }

    private String prompt(String message) {
        UIManager.put("OptionPane.background", bgColor);
        UIManager.put("Panel.background", bgColor);
        UIManager.put("OptionPane.messageForeground", textColor);
        return JOptionPane.showInputDialog(frame, message);
    }

    private void showMessage(String msg) {
        showMessage(msg, "Message");
    }

    private void showMessage(String msg, String title) {
        UIManager.put("OptionPane.background", bgColor);
        UIManager.put("Panel.background", bgColor);
        UIManager.put("OptionPane.messageForeground", textColor);
        JOptionPane.showMessageDialog(frame, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }

    private void showError(String msg) {
        UIManager.put("OptionPane.background", bgColor);
        UIManager.put("Panel.background", bgColor);
        UIManager.put("OptionPane.messageForeground", textColor);
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
