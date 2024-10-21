
package guiSMS.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EnrollStudentForm extends JFrame {
    private JComboBox<String> studentComboBox;
    private JTextField courseField;
    private ArrayList<Student> students;

    public EnrollStudentForm(ArrayList<Student> students) {
        this.students = students;
        setTitle("Enroll Student");
        setSize(300, 150);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Select Student:"));
        studentComboBox = new JComboBox<>(getStudentNames());
        add(studentComboBox);

        add(new JLabel("Course Name:"));
        courseField = new JTextField();
        add(courseField);

        JButton enrollButton = new JButton("Enroll");
        enrollButton.addActionListener(e -> enrollStudent());
        add(enrollButton);

        setLocationRelativeTo(null);
    }

    private String[] getStudentNames() {
        return students.stream().map(Student::getName).toArray(String[]::new);
    }

    private void enrollStudent() {
        int selectedIndex = studentComboBox.getSelectedIndex();
        if (selectedIndex != -1) {
            Student student = students.get(selectedIndex);
            String course = courseField.getText();
            student.enrollCourse(course);
            JOptionPane.showMessageDialog(this, "Student enrolled in " + course + " successfully!");
            dispose();
        }
    }
}
