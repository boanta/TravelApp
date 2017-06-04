package Validation;

import DBConn.DBConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Ciprian on 5/31/2017.
 */
public class Valid {

    public boolean validField(String username, String password) {
        if (username.equals("") == false && password.equals("") == false) {
            return true;
        }
        return false;
    }

    public boolean validEmployee(String username,String password,String role){

        if(username.equals("")||password.equals("")||!role.equals("employee"))
        {
            return false;
        }

        return true;
    }



    public String validEmployee(String username, String password) {
        String s="none";
        try {
            Connection myConn = DBConnect.getConnection();
            Statement stm = myConn.createStatement();
            String instr = "select * from Users where username like \"%"+username+"%\"";
            ResultSet result = stm.executeQuery(instr);

            if(result.next()){
                if(password.equals(result.getString("password"))) {
                    if(result.getString("role").equals("admin")){
                        s="admin";
                    }
                    else if(result.getString("role").equals("employee")){
                        s="employee";
                    }

                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return s;
    }

    public boolean existingClient(String username){
        try {
            Connection myConn = DBConnect.getConnection();
            Statement stm = myConn.createStatement();
            String instr = "select * from Clients where username like \"%"+username+"%\"";
            ResultSet result = stm.executeQuery(instr);


            if(result.next()){
                    return true;
                }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    public boolean validClient(String username,String password,String mail){
        if(username.equals("")||password.equals("")||mail.equals(""))
        {
            return false;
        }

        return true;
    }

    public boolean validClient(String username, String password) {
        try {
            Connection myConn = DBConnect.getConnection();
            Statement stm = myConn.createStatement();
            String instr = "select * from Clients where username like \"%"+username+"%\"";
            ResultSet result = stm.executeQuery(instr);


            if(result.next()){
                if(password.equals(result.getString("password"))) {
                    return true;
                }
            }
            else return false;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    public boolean validDeleteE(String username){


        try {
            if(username.equals("")== true )
            {
                return false;
            }
            Connection myConn = DBConnect.getConnection();
            Statement stm = null;
            stm = myConn.createStatement();
            String instr = "select * from Users where username like \"%"+username+"%\"";
            ResultSet result = stm.executeQuery(instr);
            if(result.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean validVacation(String country,String type,int space){

        if(country.equals("")||type.equals("")||space<0)
        {
            return false;
        }

        return true;
    }

    public boolean validDeleteV(int id){


        try {

            Connection myConn = DBConnect.getConnection();
            Statement stm = null;
            stm = myConn.createStatement();
            String instr = "select * from Vacation where id="+id;
            ResultSet result = stm.executeQuery(instr);
            if(result.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean validDeleteS(int id){


        try {

            Connection myConn = DBConnect.getConnection();
            Statement stm = null;
            stm = myConn.createStatement();
            String instr = "select * from Stay where id="+id;
            ResultSet result = stm.executeQuery(instr);
            if(result.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean notNullField(String input){
        if(input.equals("")==true) return false;
        return true;
    }


    public boolean validStay(int id,String type){


        try {

            Connection myConn = DBConnect.getConnection();
            Statement stm = null;
            stm = myConn.createStatement();
            String instr = "select * from Vacation where id="+id+" and type like \"%" + type + "%\"";
            ResultSet result = stm.executeQuery(instr);
            if(result.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean validIdC(int id){
        try {

            Connection myConn = DBConnect.getConnection();
            Statement stm = null;
            stm = myConn.createStatement();
            String instr = "select * from Clients where id="+id;
            ResultSet result = stm.executeQuery(instr);
            if(result.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean validIdV(int id){
        try {

            Connection myConn = DBConnect.getConnection();
            Statement stm = null;
            stm = myConn.createStatement();
            String instr = "select * from Vacation where id="+id;
            ResultSet result = stm.executeQuery(instr);
            if(result.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean validSpace(int id){
        try {

            Connection myConn = DBConnect.getConnection();
            Statement stm = null;
            stm = myConn.createStatement();
            String instr = "select * from Vacation where id="+id;
            ResultSet result = stm.executeQuery(instr);
            if(result.next()){
                if(result.getInt("space")==0){
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

}
