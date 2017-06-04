package Presentation;

import BusinessLayer.EmployeeB;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ciprian on 5/31/2017.
 */
public class AdminView extends JFrame {
    private JPanel panel;
    private JFrame j;
    private JTable table;

    public AdminView() {
        setTitle("Administrator Operations");
        setBounds(100, 100, 300, 300);

        panel = new JPanel();
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setSize(300, 300);
        setContentPane(panel);
        panel.setLayout(null);



        JButton but1 = new JButton("Add Employee");
        but1.setBounds(30, 30, 150, 30);
        panel.add(but1);
        JButton but2 = new JButton("Update Employee");
        but2.setBounds(30, 60, 150, 30);
        panel.add(but2);
        JButton but3 = new JButton("Delete Employee");
        but3.setBounds(30, 90, 150, 30);
        panel.add(but3);
        JButton but4 = new JButton("View Employees");
        but4.setBounds(30, 120, 150, 30);
        panel.add(but4);

        panel.setVisible(true);

        but1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent z) {
                try {
                    String username = JOptionPane.showInputDialog("Username");
                    String passwords = JOptionPane.showInputDialog("Password");
                    String role = JOptionPane.showInputDialog("Role");

                    EmployeeB emp = new EmployeeB();

                    boolean ok = emp.addEmployee(username,passwords,role);
                    if (ok == false) {
                        JOptionPane.showMessageDialog(null, "err");
                        return;
                    }
                    JOptionPane.showMessageDialog(null, "Employee Created!");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Eroare");
                }

            }
        });

        but2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent z) {
                try {
                    String username = JOptionPane.showInputDialog("Username");
                    String passwords = JOptionPane.showInputDialog("Password");
                    String role = JOptionPane.showInputDialog("Role");

                    EmployeeB emp = new EmployeeB();

                    boolean ok = emp.updateEmployee(username,passwords,role);
                    if (ok == false) {
                        JOptionPane.showMessageDialog(null, "err");
                        return;
                    }
                    JOptionPane.showMessageDialog(null, "Employee Updated! ");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Eroare");
                }

            }
        });

        but3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent z) {
                try {
                    String username = JOptionPane.showInputDialog("Username");

                    EmployeeB emp = new EmployeeB();

                    boolean ok = emp.delete(username);
                    if (ok == false) {
                        JOptionPane.showMessageDialog(null, "err");
                        return;
                    }
                    JOptionPane.showMessageDialog(null, "Employee Deleted! ");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Eroare");
                }

            }
        });

        but4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent z) {
                EmployeeB emp = new EmployeeB();
                j = new JFrame();
                j.setSize(600, 400);
                table = new JTable();
                table.setModel(emp.readEmployees());
                JScrollPane scr = new JScrollPane(table);
                j.add(scr);
                j.setVisible(true);
            }
        });



        panel.setVisible(true);

    }
}

