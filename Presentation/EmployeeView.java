package Presentation;

import BusinessLayer.ClientB;
import BusinessLayer.ReserveB;
import BusinessLayer.VacationB;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EmployeeView extends JFrame {

        private JPanel panel;
    private JFrame j;
    private JTable table;
        public EmployeeView(){
            setBounds(100, 100, 545, 250);

            panel = new JPanel();
            panel.setBorder(new EmptyBorder(3,3,3,3));
            setContentPane(panel);
            panel.setLayout(null);

            JButton but1 = new JButton("Vacation Operations");
            but1.setBounds(30,30,150,30);
            panel.add(but1);
            JButton but2 = new JButton("Client Operations");
            but2.setBounds(30,60,150,30);
            panel.add(but2);
            JButton but3 = new JButton("Reserve trip");
            but3.setBounds(30,90,150,30);
            panel.add(but3);
            JButton but4 = new JButton("View Requests");
            but4.setBounds(30,120,150,30);
            panel.add(but4);
            JButton but5 = new JButton("View Clients");
            but5.setBounds(200,60,150,30);
            panel.add(but5);
            JButton but6 = new JButton("View Vacations");
            but6.setBounds(200,90,150,30);
            panel.add(but6);
            panel.setVisible(true);


            but1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    VacationOp vo = new VacationOp();
                    vo.setVisible(true);
                    //setVisible(false);
                }
            });

            but2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ClientOp co = new ClientOp();
                    co.setVisible(true);
                    //setVisible(false);
                }
            });

            but3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Reserve r=new Reserve();
                    r.setVisible(true);
                    //setVisible(false);
                }
            });

            but4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent z) {
                    ReserveB emp = new ReserveB();
                    j = new JFrame();
                    j.setSize(600, 400);
                    table = new JTable();
                    table.setModel(emp.readRequest());
                    JScrollPane scr = new JScrollPane(table);
                    j.add(scr);
                    j.setVisible(true);
                }
            });
            but5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent z) {
                    ClientB emp = new ClientB();
                    j = new JFrame();
                    j.setSize(600, 400);
                    table = new JTable();
                    table.setModel(emp.readClients());
                    JScrollPane scr = new JScrollPane(table);
                    j.add(scr);
                    j.setVisible(true);
                }
            });
            but6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent z) {
                    VacationB emp = new VacationB();
                    j = new JFrame();
                    j.setSize(600, 400);
                    table = new JTable();
                    table.setModel(emp.readVacations());
                    JScrollPane scr = new JScrollPane(table);
                    j.add(scr);
                    j.setVisible(true);
                }
            });


        }




    }

