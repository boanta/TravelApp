package DataAccesLayer;

import DBConn.DBConnect;
import Model.Employee;
import Model.Request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class EmployeeGateway {


    public void create(String username,String password,String role) {
        try {

            Connection myConn = DBConnect.getConnection();

            String instr = "insert into Users (username,password,role) values (?, ?, ?)";
            PreparedStatement p = myConn.prepareStatement(instr);
            p.setString(1,username);
            p.setString(2, password);
            p.setString(3, role);


            int ok= p.executeUpdate();
            if(ok==1) {
                System.out.println("Employee inserted !");
            } else {
                System.out.println("Employee insert error !");

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    public static ArrayList<Request> readallRequests() {

        ArrayList<Request> c= new ArrayList<>();

        try {
            Connection myConn = DBConnect.getConnection();
            Statement stm = myConn.createStatement();

            String instr ="select * from Reservation";
            ResultSet result = stm.executeQuery(instr);
            //int nr = 0;
            while(result.next()) {
               Request emp = new Request();
                emp.setId(Integer.valueOf(result.getString(1)));
                emp.setId1(Integer.valueOf(result.getString(2)));
                emp.setId2(Integer.valueOf(result.getString(3)));


                c.add(emp);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public static ArrayList<Employee> readall() {

        ArrayList<Employee> c= new ArrayList<>();

        try {
            Connection myConn = DBConnect.getConnection();
            Statement stm = myConn.createStatement();

            String instr ="select * from Users where role like \"%employee%\"";
            ResultSet result = stm.executeQuery(instr);
            //int nr = 0;
            while(result.next()) {
                Employee emp = new Employee();
                emp.setId(Integer.valueOf(result.getString(1)));
                emp.setUsername(result.getString(2));
                emp.setPassword(result.getString(3));
                emp.setRole(result.getString(4));

                c.add(emp);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public void update(String username,String password,String role) {

        try {
            Connection myConn = DBConnect.getConnection();

            String instr = "update Users set password=?, role=? where username=?";
            PreparedStatement stm = myConn.prepareStatement(instr);

            stm.setString(1,password);
            stm.setString(2,role);
            stm.setString(3,username);

            int ok = stm.executeUpdate();
            if(ok==1){
                System.out.println("Updated Employee !");
            } else {
                System.out.println("Employee update error !");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(String username) {
        try {
            Connection myConn = DBConnect.getConnection();

            String instr = "delete from Users where username=?";
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

}
