package Presentation;

import BusinessLayer.ClientB;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ciprian on 5/31/2017.
 */
public class ClientOp extends JFrame {

    private JPanel panel;

    public ClientOp() {
        setBounds(100, 100, 545, 250);

        panel = new JPanel();
        panel.setBorder(new EmptyBorder(3, 3, 3, 3));
        setContentPane(panel);
        panel.setLayout(null);

        JButton but1 = new JButton("Add Client");
        but1.setBounds(30, 30, 150, 30);
        panel.add(but1);
        JButton but2 = new JButton("Modify Client");
        but2.setBounds(30, 60, 150, 30);
        panel.add(but2);
        panel.setVisible(true);


        but1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent z) {
                try {
                    String username = JOptionPane.showInputDialog("Username");
                    String password = JOptionPane.showInputDialog("Password");
                    String mail = JOptionPane.showInputDialog("Mail");

                    ClientB cb = new ClientB();

                    boolean ok = cb.addClient(username,password,mail);
                    if (ok == false) {
                        JOptionPane.showMessageDialog(null, "err");
                        return;
                    }
                    JOptionPane.showMessageDialog(null, "Client added!");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error");
                }

            }
        });

        but2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent z) {
                try {
                    String username = JOptionPane.showInputDialog("Username");
                    String password = JOptionPane.showInputDialog("Password");
                    String mail = JOptionPane.showInputDialog("Mail");

                    ClientB emp = new ClientB();

                    boolean ok = emp.updateClient(username,password,mail);
                    if (ok == false) {
                        JOptionPane.showMessageDialog(null, "err");
                        return;
                    }
                    JOptionPane.showMessageDialog(null, "Client Updated! ");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Eroare");
                }

            }
        });


    }


}

