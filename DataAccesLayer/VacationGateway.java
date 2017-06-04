/**
 * Created by Ciprian on 3/17/2017.
 */

package DataAccesLayer;

import DBConn.DBConnect;
import Model.Stay;
import Model.Vacation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class VacationGateway {




    public void createVacation(String country,String type,int space) {
        try {

            Connection myConn = DBConnect.getConnection();

            String instr = "insert into Vacation (country,type,space) values ( ?, ?, ?)";
            PreparedStatement p = myConn.prepareStatement(instr);
            p.setString(1,country);
            p.setString(2, type);
            p.setInt(3, space);


            int ok= p.executeUpdate();
            if(ok==1) {
                System.out.println("Vacation created !");
            } else {
                System.out.println("Vacation create error !");

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void createStay(int vacationId,String sight) {
        try {

            Connection myConn = DBConnect.getConnection();

            String instr = "insert into Stay (vacationId,sight) values ( ?, ?)";
            PreparedStatement p = myConn.prepareStatement(instr);
            p.setInt(1,vacationId);
            p.setString(2, sight);


            int ok= p.executeUpdate();
            if(ok==1) {
                System.out.println("Stay created !");
            } else {
                System.out.println("Stay create error !");

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static ArrayList<Vacation> readallVacation() {

        ArrayList<Vacation> c= new ArrayList<>();

        try {
            Connection myConn = DBConnect.getConnection();
            Statement stm = myConn.createStatement();

            String instr ="select * from Vacation";
            ResultSet result = stm.executeQuery(instr);

            //int nr = 0;
            while(result.next()) {
                Vacation vac = new Vacation();
                vac.setId(result.getInt(1));
                vac.setCountry(result.getString(2));
                vac.setType(result.getString(3));
                vac.setSpace(result.getInt(4));

                c.add(vac);
                //  System.out.println(++nr + " : "+ cardNumber + " - " + clientName +" - " + pnc+" - "+address);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public static ArrayList<Stay> readallStay() {

        ArrayList<Stay> c= new ArrayList<>();

        try {
            Connection myConn = DBConnect.getConnection();
            Statement stm = myConn.createStatement();

            String instr ="select * from Stay";
            ResultSet result = stm.executeQuery(instr);

            //int nr = 0;
            while(result.next()) {
                Stay vac = new Stay();
                vac.setId(result.getInt(1));
                vac.setVacationId(result.getInt(2));
                vac.setSight(result.getString(3));
                c.add(vac);
                //  System.out.println(++nr + " : "+ cardNumber + " - " + clientName +" - " + pnc+" - "+address);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public void updateVacation(int id,String country,String type,int space) {

        try {
            Connection myConn = DBConnect.getConnection();
            Scanner scan = new Scanner(System.in);

            String instr = "update Vacation set country=?,type=?, space=? where id=? ";
            PreparedStatement stm = myConn.prepareStatement(instr);

            stm.setString(1,country);
            stm.setString(2,type);
            stm.setInt(3,space);
            stm.setInt(4,id);

            int ok = stm.executeUpdate();
            if(ok==1){
                System.out.println("Updated Vacation !");
            } else {
                System.out.println("Vacationt update error !");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateStay(int id,int vacationId,String sight) {

        try {
            Connection myConn = DBConnect.getConnection();
            Scanner scan = new Scanner(System.in);

            String instr = "update Vacation set vacationId=?,sight=? where id=? ";
            PreparedStatement stm = myConn.prepareStatement(instr);

            stm.setInt(1,vacationId);
            stm.setString(2,sight);
            stm.setInt(3,id);

            int ok = stm.executeUpdate();
            if(ok==1){
                System.out.println("Updated Stay !");
            } else {
                System.out.println("Stay update error !");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteVacation(int id,String type) {
        try {
            Connection myConn = DBConnect.getConnection();

            String instr = "delete from Vacation where id=?";
            String instr1= "delete from Stay where vacationId=?";
            PreparedStatement stm = myConn.prepareStatement(instr);
            stm.setInt(1,id);
            if(type.equals("stay")){
                PreparedStatement stm1 = myConn.prepareStatement(instr1);
                stm1.setInt(1,id);
                int ok1 = stm1.executeUpdate();
                if(ok1 ==1){
                    System.out.println(" Stay Deleted !");
                } else {
                    System.out.println("Stay Delete error !");
                }
            }


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

    public void deleteStay(int id) {
        try {
            Connection myConn = DBConnect.getConnection();

            String instr = "delete from Stay where id=?";
            PreparedStatement stm = myConn.prepareStatement(instr);
            stm.setInt(1,id);
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



}
