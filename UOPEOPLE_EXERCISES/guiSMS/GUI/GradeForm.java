package guiSMS.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeForm extends JFrame {
    private JComboBox<String> studentComboBox;
    private JComboBox<String> courseComboBox;
    private JTextField gradeField;
    private JButton assignGradeButton;

    public GradeForm() {
        setTitle("Assign Grade");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        studentComboBox = new JComboBox<>(getStudents());
        courseComboBox = new JComboBox<>(getCourses());

        gradeField = new JTextField();
        assignGradeButton = new JButton("Assign Grade");
        assignGradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignGrade();
            }
        });

        add(new JLabel("Select Student:"));
        add(studentComboBox);
        add(new JLabel("Select Course:"));
        add(courseComboBox);
        add(new JLabel("Enter Grade:"));
        add(gradeField);
        add(assignGradeButton);
    }

    private String[] getStudents() {
        return new String[] { "Student A", "Student B", "Student C" }; // Sample data
    }

    private String[] getCourses() {
        return new String[] { "Course 1", "Course 2", "Course 3" }; // Sample data
    }

    private void assignGrade() {
        String student = studentComboBox.getSelectedItem().toString();
        String course = courseComboBox.getSelectedItem().toString();
        String grade = gradeField.getText();
        // Logic to assign grade to the selected student

        JOptionPane.showMessageDialog(this, "Grade " + grade + " assigned to " + student + " for " + course, "Success",
                JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }
}
