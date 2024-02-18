package student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentManagementSystemGUI extends JFrame {
    private StudentManagementSystem system;
    private DefaultTableModel tableModel;

    public StudentManagementSystemGUI() {
        super("Student Management System");
        system = new StudentManagementSystem();
        tableModel = new DefaultTableModel(new String[]{"Name", "Roll Number", "Grade"}, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Student");
        JButton removeButton = new JButton("Remove Student");
        JButton searchButton = new JButton("Search Student");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Enter student name:");
                if (name == null || name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Invalid name. Please enter a valid name.");
                    return;
                }
                int rollNumber;
                try {
                    rollNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter student roll number:"));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid roll number. Please enter a valid number.");
                    return;
                }
                String grade = JOptionPane.showInputDialog("Enter student grade:");
                if (grade == null || grade.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Invalid grade. Please enter a valid grade.");
                    return;
                }
                system.addStudent(new Student(name, rollNumber, grade));
                updateTable();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a student to remove.");
                    return;
                }
                int rollNumber = (int) table.getValueAt(selectedRow, 1);
                system.removeStudent(rollNumber);
                updateTable();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rollNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter roll number of student to search:"));
                Student student = system.searchStudent(rollNumber);
                if (student != null) {
                    JOptionPane.showMessageDialog(null, "Student found:\nName: " + student.getName() + "\nRoll Number: " + student.getRollNumber() + "\nGrade: " + student.getGrade());
                } else {
                    JOptionPane.showMessageDialog(null, "Student not found.");
                }
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(searchButton);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(scrollPane, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // Center the window
        setVisible(true);

        updateTable();
    }

    private void updateTable() {
        tableModel.setRowCount(0);
        for (Student student : system.getAllStudents()) {
            tableModel.addRow(new Object[]{student.getName(), student.getRollNumber(), student.getGrade()});
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentManagementSystemGUI();
            }
        });
    }
}
