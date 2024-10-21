package guiSMS;

import guiSMS.GUI.AdminPanel; // Correctly import AdminPanel from the guiSMS.GUI package
import javax.swing.*;

public class StudentManagementSystem extends JFrame {

    public StudentManagementSystem() {
        setTitle("Student Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        AdminPanel adminPanel = new AdminPanel(); // Assuming AdminPanel is defined correctly elsewhere
        add(adminPanel);

        setVisible(true); // Set frame to be visible
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentManagementSystem());
    }
}
