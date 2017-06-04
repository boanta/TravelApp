/**
 * Created by Ciprian on 3/17/2017.
 */

package DataAccesLayer;

import DBConn.DBConnect;
import Model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientGateway {




    public void create(String username,String password,String mail) {
        try {

            Connection myConn = DBConnect.getConnection();

            String instr = "insert into Clients (username,password,mail) values ( ?, ?, ?)";
            PreparedStatement p = myConn.prepareStatement(instr);
            p.setString(1,username);
            p.setString(2, password);
            p.setString(3, mail);


            int ok= p.executeUpdate();
            if(ok==1) {
                System.out.println("Client inserted !");
            } else {
                System.out.println("Client insert error !");

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static ArrayList<Client> readall() {

        ArrayList<Client> c= new ArrayList<>();

        try {
            Connection myConn = DBConnect.getConnection();
            Statement stm = myConn.createStatement();

            String instr ="select * from Clients";
            ResultSet result = stm.executeQuery(instr);

            //int nr = 0;
            while(result.next()) {
                Client client = new Client();
                client.setId(result.getInt(1));
                client.setUsername(result.getString(2));
                client.setPassword(result.getString(3));
                client.setMail(result.getString(4));

                c.add(client);
                //  System.out.println(++nr + " : "+ cardNumber + " - " + clientName +" - " + pnc+" - "+address);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public void update(String username,String password,String mail) {

        try {
            Connection myConn = DBConnect.getConnection();
            Scanner scan = new Scanner(System.in);

            String instr = "update Clients set password=?, mail=? where username=?";
            PreparedStatement stm = myConn.prepareStatement(instr);

            stm.setString(1,password);
            stm.setString(2,mail);
            stm.setString(3,username);

            int ok = stm.executeUpdate();
            if(ok==1){
                System.out.println("Updated Client !");
            } else {
                System.out.println("Client update error !");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(String username) {
        try {
            Connection myConn = DBConnect.getConnection();

            String instr = "delete from Clients where username=?";
            PreparedStatement stm = myConn.prepareStatement(instr);

            stm.setString(1,username);

            int ok = stm.executeUpdate();
            if(ok ==1){
                System.out.println("Deleted !");
            } else {
                System.out.println("Delete error !");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getId(String username){
        try {
            Connection myConn = DBConnect.getConnection();
            Statement stm = myConn.createStatement();
            String instr = "select * from Clients where username like \"%" + username + "%\"";
            ResultSet result = stm.executeQuery(instr);
            if(result.next()){
                return result.getInt(1);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
return 0;
    }

}
