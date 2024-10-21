
package guiSMS.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AssignGradeForm extends JFrame {
    private JComboBox<String> studentComboBox;
    private JComboBox<String> courseComboBox;
    private JTextField gradeField;
    private ArrayList<Student> students;

    public AssignGradeForm(ArrayList<Student> students) {
        this.students = students;
        setTitle("Assign Grade");
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Select Student:"));
        studentComboBox = new JComboBox<>(getStudentNames());
        add(studentComboBox);

        add(new JLabel("Select Course:"));
        courseComboBox = new JComboBox<>();
        add(courseComboBox);

        add(new JLabel("Grade:"));
        gradeField = new JTextField();
        add(gradeField);

        JButton assignButton = new JButton("Assign Grade");
        assignButton.addActionListener(e -> assignGrade());
        add(assignButton);

        studentComboBox.addActionListener(e -> updateCourseComboBox());

        setLocationRelativeTo(null);
    }

    private String[] getStudentNames() {
        return students.stream().map(Student::getName).toArray(String[]::new);
    }

    private void updateCourseComboBox() {
        int selectedIndex = studentComboBox.getSelectedIndex();
        if (selectedIndex != -1) {
            Student student = students.get(selectedIndex);
            courseComboBox.removeAllItems();
            for (String course : student.getCourses()) {
                courseComboBox.addItem(course);
            }
        }
    }

    private void assignGrade() {
        int selectedStudentIndex = studentComboBox.getSelectedIndex();
        String selectedCourse = (String) courseComboBox.getSelectedItem();
        if (selectedStudentIndex != -1 && selectedCourse != null) {
            Student student = students.get(selectedStudentIndex);
            String grade = gradeField.getText();
            student.assignGrade(selectedCourse, grade);
            JOptionPane.showMessageDialog(this, "Grade assigned successfully!");
            dispose();
        }
    }
}
