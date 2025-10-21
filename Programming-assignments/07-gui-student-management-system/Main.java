import javax.swing.*;
// import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // frame
        JFrame frame = new JFrame("Hiii");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // execute code here:
        MainMenu mm = new MainMenu(frame);
        mm.run();

        frame.add(mm.getPanel());
        frame.setVisible(true);
    }
}

class MainMenu {
    private JPanel panel = new JPanel();
    private JFrame frame; // keep reference to parent frame

    String[] menuItems = {
            "1. View all student records",
            "2. View total number of students",
            "3. View last ID",
            "4. Add a new student",
            "5. Change student details",
            "6. Find a student by ID",
            "7. Exit"
    };

    public MainMenu(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void run() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // create buttons with actions
        for (int i = 0; i < menuItems.length; i++) {
            JButton button = new JButton(menuItems[i]);
            final int index = i; // for use in lambda
            button.addActionListener(e -> handleAction(index));
            panel.add(button);
        }
    }

    private void handleAction(int index) {
        switch (index) {
            case 0 -> JOptionPane.showMessageDialog(frame, "Viewing all student records...");
            case 1 -> JOptionPane.showMessageDialog(frame, "Total students: [placeholder]");
            case 2 -> JOptionPane.showMessageDialog(frame, "Last ID: [placeholder]");
            case 3 -> JOptionPane.showMessageDialog(frame, "Add new student clicked!");
            case 4 -> JOptionPane.showMessageDialog(frame, "Change student details clicked!");
            case 5 -> JOptionPane.showMessageDialog(frame, "Find student by ID clicked!");
            case 6 -> System.exit(0);
        }
    }
}
