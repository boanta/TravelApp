package Presentation;

import Validation.Valid;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ciprian on 5/4/2017.
 */
public class MainLogin extends JFrame {

    private JPanel panel;
    private JTextField usernameF;
    private JPasswordField passwordF;


    public static void main(String[] args){
        try{
            MainLogin frame = new MainLogin();
            frame.setVisible(true);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MainLogin(){
        this.login();
    }

    private void login(){
        setTitle("Login");
        setBounds(100, 100, 700, 250);

        panel = new JPanel();
        panel.setBorder(new EmptyBorder(3,3,3,3));

        setContentPane(panel);
        panel.setLayout(null);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(30,50,100,50);
        panel.add(usernameLabel);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(30,100,100,50);
        panel.add(passwordLabel);

        usernameF = new JTextField();
        usernameF.setBounds(130,50,200,30);
        panel.add(usernameF);

        passwordF=new JPasswordField();
        passwordF.setBounds(130,100,200,30);
        panel.add(passwordF);

        JButton loginE = new JButton("Employee");
        loginE.setBounds(140,140,100,30);
        panel.add(loginE);

        JButton loginC = new JButton("Client");
        loginC.setBounds(240,140,100,30);
        panel.add(loginC);

        loginE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String username= usernameF.getText();
                    String password= passwordF.getText();
                    Valid v = new Valid();
                    if(v.validField(username,password)==false) {
                        JOptionPane.showMessageDialog(null,"Incorrect data!");
                        return;
                    }
                    if(v.validEmployee(username,password).equals("none")){
                        JOptionPane.showMessageDialog(null,"Username or password is incorrect!");
                    }
                    else if(v.validEmployee(username,password).equals("employee")){
                            EmployeeView empV=new EmployeeView();
                            empV.setVisible(true);
                            setVisible(false);
                    }
                    else if(v.validEmployee(username,password).equals("admin")){
                        AdminView av=new AdminView();
                        av.setVisible(true);
                        setVisible(false);
                    }


                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Login error");
                }
            }
        });

        loginC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String username= usernameF.getText();
                    String password= passwordF.getText();
                    Valid v = new Valid();
                    if(v.validField(username,password)==false) {
                        JOptionPane.showMessageDialog(null,"Incorrect data!");
                        return;
                    }
                    if(v.validClient(username,password)==false){
                        JOptionPane.showMessageDialog(null,"Username or password is incorrect!");
                    }
                    else{
                        ClientView cv=new ClientView(username);
                        cv.setVisible(true);
                        setVisible(false);
                    }



                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Login error!");
                }
            }
        });

    }
}

