package guiSMS.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AdminPanel extends JPanel {
    private ArrayList<Student> students;

    public AdminPanel() {
        students = new ArrayList<>(); // Initialize the student list
        setLayout(new FlowLayout());

        JButton addStudentButton = new JButton("Add Student");
        JButton updateStudentButton = new JButton("Update Student");
        JButton viewStudentsButton = new JButton("View Students");
        JButton enrollButton = new JButton("Enroll Student");
        JButton assignGradeButton = new JButton("Assign Grade");

        add(addStudentButton);
        add(updateStudentButton);
        add(viewStudentsButton);
        add(enrollButton);
        add(assignGradeButton);

        addStudentButton.addActionListener(e -> new StudentForm(students).setVisible(true));
        updateStudentButton.addActionListener(e -> new UpdateStudentForm(students).setVisible(true));
        viewStudentsButton.addActionListener(e -> new ViewStudentsForm(students).setVisible(true));
        enrollButton.addActionListener(e -> new EnrollStudentForm(students).setVisible(true));
        assignGradeButton.addActionListener(e -> new AssignGradeForm(students).setVisible(true));
    }
}
