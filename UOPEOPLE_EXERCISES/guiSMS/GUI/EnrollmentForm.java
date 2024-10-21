package guiSMS.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnrollmentForm extends JFrame {
    private JComboBox<String> studentComboBox;
    private JComboBox<String> courseComboBox;
    private JButton enrollButton;

    public EnrollmentForm() {
        setTitle("Enroll Student");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        // Assume methods getStudents() and getCourses() provide available data
        studentComboBox = new JComboBox<>(getStudents());
        courseComboBox = new JComboBox<>(getCourses());

        enrollButton = new JButton("Enroll");
        enrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enrollStudent();
            }
        });

        add(new JLabel("Select Student:"));
        add(studentComboBox);
        add(new JLabel("Select Course:"));
        add(courseComboBox);
        add(enrollButton);
    }

    private String[] getStudents() {
        return new String[] { "Student A", "Student B", "Student C" }; // Sample data
    }

    private String[] getCourses() {
        return new String[] { "Course 1", "Course 2", "Course 3" }; // Sample data
    }

    private void enrollStudent() {
        String student = studentComboBox.getSelectedItem().toString();
        String course = courseComboBox.getSelectedItem().toString();
        // Logic to enroll student in the selected course

        JOptionPane.showMessageDialog(this, student + " enrolled in " + course + "!", "Success",
                JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }
}
