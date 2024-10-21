
package guiSMS.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ViewStudentsForm extends JFrame {
    private JTable studentTable;

    public ViewStudentsForm(ArrayList<Student> students) {
        setTitle("View Students");
        setSize(500, 300);
        setLayout(new BorderLayout());

        String[] columnNames = { "ID", "Name", "Major" };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Student student : students) {
            model.addRow(new Object[] { student.getId(), student.getName(), student.getMajor() });
        }

        studentTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(studentTable);
        add(scrollPane, BorderLayout.CENTER);

        setLocationRelativeTo(null);
    }
}
