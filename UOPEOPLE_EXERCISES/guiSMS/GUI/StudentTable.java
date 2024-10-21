package guiSMS.GUI;

import guiSMS.Student; // Make sure this import is correct
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class StudentTable extends JDialog {
    private JTable table;

    public StudentTable(JFrame parent, ArrayList<Student> students) {
        setTitle("Student Details");
        setSize(600, 400);
        setLocationRelativeTo(parent);

        String[] columnNames = { "Student ID", "Student Name", "Major" };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Student student : students) {
            Object[] row = { student.getId(), student.getName(), student.getMajor() };
            model.addRow(row);
        }

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        setVisible(true);
    }
}
