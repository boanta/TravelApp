package Presentation;

import BusinessLayer.ClientB;
import BusinessLayer.ReserveB;
import BusinessLayer.VacationB;
import Validation.Valid;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ciprian on 5/31/2017.
 */
public class ClientView extends JFrame {
    private JPanel panel;
    private JFrame j;
    private JTable table;
    private JTextField idV;

    public ClientView(String userId) {
        setTitle("Client");
        setBounds(100, 100, 500, 300);

        panel = new JPanel();
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setSize(500, 300);
        setContentPane(panel);
        panel.setLayout(null);

        JLabel quantityLabel = new JLabel("Vacation id");
        quantityLabel.setBounds(300, 20, 100, 50);
        panel.add(quantityLabel);
        idV = new JTextField();
        idV.setBounds(300, 60, 50, 30);
        panel.add(idV);

        JButton but1 = new JButton("View Vacations");
        but1.setBounds(30, 30, 150, 30);
        panel.add(but1);
        JButton but2 = new JButton("View Stays");
        but2.setBounds(30, 60, 150, 30);
        panel.add(but2);
        JButton but3 = new JButton("Request Vacation");
        but3.setBounds(30, 90, 150, 30);
        panel.add(but3);


        panel.setVisible(true);

        but1.addActionListener(new ActionListener() {
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

        but2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent z) {
                VacationB emp = new VacationB();
                j = new JFrame();
                j.setSize(600, 400);
                table = new JTable();
                table.setModel(emp.readStay());
                JScrollPane scr = new JScrollPane(table);
                j.add(scr);
                j.setVisible(true);
            }
        });

        but3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent z) {
                int id= Integer.parseInt(String.valueOf(idV.getText()));
                ClientB  cb= new ClientB();
                int idClient = cb.getId(userId);
                if(idClient!=0){
                try {

                    Valid vo = new Valid();
                    if(vo.validIdV(id)==false) {
                        JOptionPane.showMessageDialog(null,"Vacation does not exist!");
                        return;
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Eroare");
                }
                ReserveB bd = new ReserveB();
                bd.request(idClient,id);
                JOptionPane.showMessageDialog(null,"Request complete !");
            }}
        });

        



        panel.setVisible(true);

    }
}

