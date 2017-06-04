package Presentation;

import BusinessLayer.ReserveB;
import Validation.Valid;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ciprian on 5/31/2017.
 */
public class Reserve extends JFrame {

    private JPanel panel;
    private JTextField idC;
    private JTextField idV;

    public Reserve() {
        setBounds(100, 100, 545, 250);

        panel = new JPanel();
        panel.setBorder(new EmptyBorder(3, 3, 3, 3));
        setContentPane(panel);
        panel.setLayout(null);

        JButton but1 = new JButton("Reserve");
        but1.setBounds(30, 30, 150, 30);
        panel.add(but1);


        JLabel idLabel = new JLabel("Client id");
        idLabel.setBounds(350, 20, 100, 50);
        panel.add(idLabel);
        idC = new JTextField();
        idC.setBounds(350, 60, 50, 30);
        panel.add(idC);

        JLabel quantityLabel = new JLabel("Vacation id");
        quantityLabel.setBounds(450, 20, 100, 50);
        panel.add(quantityLabel);
        idV = new JTextField();
        idV.setBounds(450, 60, 50, 30);
        panel.add(idV);


        panel.setVisible(true);


        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Valid vo = new Valid();
                if(vo.notNullField(idC.getText())==false || vo.notNullField(idV.getText())==false) {
                    JOptionPane.showMessageDialog(null,"Invalid field !");
                    return;
                }

                int id=Integer.valueOf(idC.getText());
                int id1= Integer.valueOf(idV.getText());

                if(vo.validIdC(id)==false) {
                    JOptionPane.showMessageDialog(null,"Client does not exist!");
                    return;
                }
                if(vo.validIdV(id1)==false) {
                    JOptionPane.showMessageDialog(null,"Vacation does not exist!");
                    return;
                }
                if(vo.validSpace(id)==false){
                    JOptionPane.showMessageDialog(null,"Not enough space !");
                    return;
                }

                ReserveB bd = new ReserveB();
                bd.reserve(id,id1);
                JOptionPane.showMessageDialog(null,"Reservation complete !");


            }
        });




    }


}

