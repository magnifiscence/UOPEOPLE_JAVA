package guiSMS.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UpdateStudentForm extends JFrame {
    private JComboBox<String> studentComboBox;
    private JTextField nameField;
    private JTextField majorField;
    private ArrayList<Student> students;

    public UpdateStudentForm(ArrayList<Student> students) {
        this.students = students;
        setTitle("Update Student");
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Select Student:"));
        studentComboBox = new JComboBox<>(getStudentNames());
        add(studentComboBox);

        add(new JLabel("New Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("New Major:"));
        majorField = new JTextField();
        add(majorField);

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(e -> updateStudent());
        add(updateButton);

        setLocationRelativeTo(null);
    }

    private String[] getStudentNames() {
        return students.stream().map(Student::getName).toArray(String[]::new);
    }

    private void updateStudent() {
        int selectedIndex = studentComboBox.getSelectedIndex();
        if (selectedIndex != -1) {
            Student student = students.get(selectedIndex);
            student.setName(nameField.getText());
            student.setMajor(majorField.getText());
            JOptionPane.showMessageDialog(this, "Student updated successfully!");
            dispose();
        }
    }
}
