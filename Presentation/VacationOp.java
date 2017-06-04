package Presentation;

import BusinessLayer.VacationB;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ciprian on 5/31/2017.
 */
public class VacationOp extends JFrame {

    private JPanel panel;

    public VacationOp() {
        setBounds(100, 100, 545, 250);

        panel = new JPanel();
        panel.setBorder(new EmptyBorder(3, 3, 3, 3));
        setContentPane(panel);
        panel.setLayout(null);

        JButton but1 = new JButton("Add Vacation");
        but1.setBounds(30, 30, 150, 30);
        panel.add(but1);
        JButton but2 = new JButton("Modify Vacation");
        but2.setBounds(30, 60, 150, 30);
        panel.add(but2);
        JButton but3 = new JButton("Delete Vacation");
        but3.setBounds(30, 90, 150, 30);
        panel.add(but3);
        JButton but4 = new JButton("Add Stay");
        but4.setBounds(30, 120, 150, 30);
        panel.add(but4);
        JButton but5 = new JButton("Modify Stay");
        but5.setBounds(30, 150, 150, 30);
        panel.add(but5);
        JButton but6 = new JButton("Delete Stay");
        but6.setBounds(30, 180, 150, 30);
        panel.add(but6);
        panel.setVisible(true);


        but1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent z) {
                try {
                    String username = JOptionPane.showInputDialog("Country");
                    String password = JOptionPane.showInputDialog("Type");
                    int mail = Integer.parseInt(JOptionPane.showInputDialog("Space"));

                    VacationB cb= new VacationB();

                    boolean ok = cb.addVacation(username,password,mail);
                    if (ok == false) {
                        JOptionPane.showMessageDialog(null, "err");
                        return;
                    }
                    JOptionPane.showMessageDialog(null, "Vacation added!");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error");
                }

            }
        });

        but2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent z) {
                try {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
                    String username = JOptionPane.showInputDialog("Country");
                    String password = JOptionPane.showInputDialog("Type");
                    int mail = Integer.parseInt(JOptionPane.showInputDialog("Space"));

                    VacationB emp = new VacationB();

                    boolean ok = emp.updateVacation(id,username,password,mail);
                    if (ok == false) {
                        JOptionPane.showMessageDialog(null, "err");
                        return;
                    }
                    JOptionPane.showMessageDialog(null, "Vacation Updated! ");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Eroare");
                }

            }
        });

        but3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent z) {
                try {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
                    String password = JOptionPane.showInputDialog("Type");



                    VacationB emp = new VacationB();

                    boolean ok = emp.deleteVacation(id,password);
                    if (ok == false) {
                        JOptionPane.showMessageDialog(null, "err");
                        return;
                    }
                    JOptionPane.showMessageDialog(null, "Vacationdeleted! ");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Eroare");
                }

            }
        });


        but4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent z) {
                try {
                    int username = Integer.parseInt(JOptionPane.showInputDialog("VacationId"));
                    String password = JOptionPane.showInputDialog("Sight");

                    VacationB cb= new VacationB();

                    boolean ok = cb.addStay(username,password);
                    if (ok == false) {
                        JOptionPane.showMessageDialog(null, "err");
                        return;
                    }
                    JOptionPane.showMessageDialog(null, "Vacation added!");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error");
                }

            }
        });

        but5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent z) {
                try {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
                    int mail = Integer.parseInt(JOptionPane.showInputDialog("Vacation Id"));
                    String password = JOptionPane.showInputDialog("sight");


                    VacationB emp = new VacationB();

                    boolean ok = emp.updateStay(id,mail,password);
                    if (ok == false) {
                        JOptionPane.showMessageDialog(null, "err");
                        return;
                    }
                    JOptionPane.showMessageDialog(null, "Stay Updated! ");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Eroare");
                }

            }
        });

        but6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent z) {
                try {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Id"));



                    VacationB emp = new VacationB();

                    boolean ok = emp.deleteStay(id);
                    if (ok == false) {
                        JOptionPane.showMessageDialog(null, "err");
                        return;
                    }
                    JOptionPane.showMessageDialog(null, "Stay deleted! ");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Eroare");
                }

            }
        });
    }


}

