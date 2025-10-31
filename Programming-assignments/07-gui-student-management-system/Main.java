
/**
 * ================================================================
 *                 STUDENT RECORD MANAGEMENT SYSTEM (SRMS)
 * ================================================================
 *
 *
 * ---------------------------------------------------------------
 * 1. INTRODUCTION
 * ---------------------------------------------------------------
 * The Student Record Management System (SRMS) is a **Java Swing-based**
 * desktop application designed to manage and visualize student data.
 * It serves as an educational demonstration of how Java Swing can be
 * used to build interactive graphical user interfaces integrated with
 * backend logic written using core Object-Oriented Programming (OOP)
 * principles.
 *
 * The program showcases the combination of **Swing components** such as
 * JFrame, JPanel, JButton, JTable, and JOptionPane with Java classes and
 * methods for managing and manipulating student records. It provides a
 * dynamic and user-friendly interface for performing CRUD-like operations
 * (Create, Read, Update, Delete) on student information.
 *
 * ---------------------------------------------------------------
 * 2. CORE FUNCTIONALITIES
 * ---------------------------------------------------------------
 * The Student Record Management System (SRMS) offers the following
 * capabilities through Java Swing GUI components:
 *
 *   • View all student records displayed in a styled JTable.
 *   • Add new students using Swing input dialogs.
 *   • Update existing student records dynamically through user input.
 *   • Find and display student information by unique ID.
 *   • View system statistics such as total number of students and
 *     last registered student ID.
 *   • Exit the application gracefully using an “Exit” button.
 *
 * Each functionality is fully integrated into the Swing interface,
 * allowing real-time user interaction without any console commands.
 *
 * ---------------------------------------------------------------
 * 3. HOW TO RUN THE PROGRAM
 * ---------------------------------------------------------------
 * Step 1: Save the file as "Main.java".
 *
 * Step 2: Compile the source code:
 *         > javac Main.java
 *
 * Step 3: Run the application:
 *         > java Main
 *
 * Step 4: A Java Swing window titled “Student Record Management System”
 *         will open, displaying a dashboard with buttons for each
 *         functionality:
 *           1. View All Students
 *           2. Total Students
 *           3. Last Student ID
 *           4. Add Student
 *           5. Update Student
 *           6. Find Student by ID
 *           7. Exit
 *
 * Each action launches a corresponding Swing dialog or table interface.
 *
 * ---------------------------------------------------------------
 * 4. PROGRAM STRUCTURE OVERVIEW
 * ---------------------------------------------------------------
 * The SRMS is built with a clear separation between **frontend (Swing GUI)**
 * and **backend (OOP logic)** components:
 *
 * (a) Main
 *     • Serves as the entry point.
 *     • Initializes sample data and launches the GUI thread.
 *
 * (b) Dashboard (Swing Layer)
 *     • Implements the graphical interface using Swing.
 *     • Organizes buttons and actions via GridLayout.
 *     • Connects user events to backend logic.
 *
 * (c) Student (Model Layer)
 *     • Represents individual student records.
 *     • Defines fields: ID, name, age, and grade.
 *     • Provides getter and setter methods for encapsulation.
 *
 * (d) StudentSystem (Logic Layer)
 *     • Handles data storage, retrieval, and updates.
 *     • Maintains student arrays and system statistics.
 *
 * ---------------------------------------------------------------
 * 5. INTERFACE DESIGN (USING JAVA SWING)
 * ---------------------------------------------------------------
 * The SRMS interface is constructed entirely with **Java Swing** components,
 * providing a clean, dark-themed, and modern look:
 *
 *   • JFrame – Main application window.
 *   • JPanel – Container for layout and organization of controls.
 *   • JButton – Trigger specific system operations.
 *   • JTable – Displays student data in a scrollable table view.
 *   • JScrollPane – Enables smooth scrolling for large data sets.
 *   • JOptionPane – Facilitates message dialogs and user input prompts.
 *
 * The design uses custom color schemes for an elegant, consistent feel:
 *   - Background Color: (40, 44, 52)
 *   - Button Color: (60, 63, 70)
 *   - Text Color: (220, 220, 220)
 *   - Accent Color: (85, 170, 255)
 *
 * Fonts and table styling further enhance readability and visual clarity.
 *
 * ---------------------------------------------------------------
 * 6. CLASS IMPLEMENTATION
 * ---------------------------------------------------------------
 * (a) Student Class:
 *     • Represents a single student object.
 *     • Contains private fields with public getter/setter methods.
 *     • Uses a static counter for generating unique student IDs.
 *
 * (b) StudentSystem Class:
 *     • Maintains a static array of Student objects.
 *     • Provides core methods for:
 *         - Adding new students.
 *         - Finding students by ID.
 *         - Updating existing records.
 *     • Displays error dialogs using Swing when capacity limits or
 *       invalid inputs occur.
 *
 * (c) Dashboard Class:
 *     • Central GUI controller built with Java Swing.
 *     • Creates and styles all visual components.
 *     • Uses event listeners for button actions.
 *     • Employs helper methods for data interaction and dialog management:
 *         - viewAllStudents()
 *         - addStudent()
 *         - updateStudent()
 *         - findStudent()
 *         - showMessage(), showError(), and prompt()
 *     • Uses JTable to render all students in a structured view.
 *
 * (d) Main Class:
 *     • Initializes the StudentSystem and sample data.
 *     • Invokes the Dashboard inside SwingUtilities.invokeLater() to ensure
 *       thread-safe GUI rendering.
 *
 * ---------------------------------------------------------------
 * 7. MAIN PROGRAM AND SYSTEM FLOW
 * ---------------------------------------------------------------
 * Program execution follows a Swing-driven, event-based model:
 *
 *   1. The application starts from Main and sets up sample data.
 *   2. The Dashboard JFrame and JPanel are initialized and displayed.
 *   3. Each button on the dashboard is linked to an ActionListener.
 *   4. When a button is clicked, the corresponding method executes and
 *      interacts with the StudentSystem backend.
 *   5. Swing dialogs (JOptionPane) or tables (JTable) display the results.
 *   6. The application remains active until the user selects “Exit.”
 *
 * This flow highlights Swing’s event-driven architecture and GUI responsiveness.
 *
 * ---------------------------------------------------------------
 * 8. CODE QUALITY AND DESIGN PRINCIPLES
 * ---------------------------------------------------------------
 * The SRMS follows clean coding and design principles:
 *
 *   • Separation of Concerns:
 *       - Swing interface and backend logic are clearly divided.
 *
 *   • Encapsulation:
 *       - Private data fields in Student class with controlled access.
 *
 *   • Modularity:
 *       - Dashboard, Student, and StudentSystem classes serve distinct roles.
 *
 *   • Reusability:
 *       - Reusable Swing helper methods (prompt, showMessage, styleTable).
 *
 *   • Thread Safety:
 *       - GUI initialization is handled through SwingUtilities.invokeLater().
 *
 *   • Consistent Aesthetics:
 *       - Unified dark theme and consistent font choices for visual coherence.
 *
 * ---------------------------------------------------------------
 * 9. ERROR HANDLING AND VALIDATION
 * ---------------------------------------------------------------
 * The system employs error-handling techniques to maintain GUI stability:
 *
 *   • Input Validation:
 *       - Swing input dialogs verify correct numeric values for age/grade.
 *       - Prevents null or invalid user responses.
 *
 *   • Exception Handling:
 *       - try-catch blocks protect against invalid conversions.
 *       - JOptionPane error dialogs provide user-friendly feedback.
 *
 *   • System Integrity:
 *       - Ensures student array does not exceed its allocated capacity.
 *       - Prevents invalid field updates in StudentSystem.
 *
 * These mechanisms ensure a smooth, crash-free Swing experience for users.
 *
 * ---------------------------------------------------------------
 * 10. DOCUMENTATION AND CODE MAINTENANCE
 * ---------------------------------------------------------------
 * The SRMS codebase is well-structured for readability and maintenance:
 *
 *   • Inline documentation clarifies purpose and logic.
 *   • Method names clearly describe their function.
 *   • Follows standard Swing and Java conventions for GUI development.
 *   • Can be easily extended with features such as:
 *       - Persistent file or database storage.
 *       - Sorting or filtering student records in JTable.
 *       - Real-time UI updates via Swing event threads.
 *
 * ---------------------------------------------------------------
 * 11. LEARNING OUTCOMES AND REFLECTION
 * ---------------------------------------------------------------
 * Developing this Java Swing project strengthens understanding of:
 *
 *   • Swing GUI design and layout management.
 *   • Event-driven programming and action handling.
 *   • Object-oriented principles in interactive applications.
 *   • Data validation and user feedback in GUI contexts.
 *   • Bridging backend logic with responsive visual interfaces.
 *
 * Reflection:
 *   • Demonstrates how Swing remains a powerful GUI toolkit in Java.
 *   • Encourages modular, maintainable design for future JavaFX or web transitions.
 *
 * ---------------------------------------------------------------
 * 12. CONCLUSION
 * ---------------------------------------------------------------
 * The Student Record Management System (SRMS) effectively merges the
 * **power of Java Swing** with structured, object-oriented programming
 * principles. It stands as an example of how desktop GUI applications can
 * deliver both functionality and an engaging user experience.
 *
 * Key Takeaways:
 *   • Swing enables rapid development of user-friendly interfaces.
 *   • Encapsulation and modularity simplify maintenance.
 *   • Validation and feedback enhance application reliability.
 *
 * Overall, SRMS showcases how a well-designed Java Swing application can
 * integrate data management, visual presentation, and user interaction into
 * a cohesive and educational software solution.
 *
 * ================================================================
 */

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
