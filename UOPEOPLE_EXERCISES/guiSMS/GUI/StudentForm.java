package guiSMS.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentForm extends JFrame {
    private JTextField idField;
    private JTextField nameField;
    private JButton submitButton;

    public StudentForm() {
        setTitle("Add Student");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        // Add Student ID
        add(new JLabel("Student ID: "));
        idField = new JTextField();
        add(idField);

        // Add Student Name
        add(new JLabel("Student Name: "));
        nameField = new JTextField();
        add(nameField);

        // Submit Button
        submitButton = new JButton("Add");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });
        add(submitButton);
    }

    private void addStudent() {
        String id = idField.getText();
        String name = nameField.getText();

        // Basic validation
        if (id.isEmpty() || name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Logic to store the student
        System.out.println("Adding Student: ID = " + id + ", Name = " + name);

        // Show success message
        JOptionPane.showMessageDialog(this, "Student added!", "Success", JOptionPane.INFORMATION_MESSAGE);
        this.dispose(); // Close the form after adding
    }
}
