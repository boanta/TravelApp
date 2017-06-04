package BusinessLayer;

import DBConn.DBConnect;
import DataAccesLayer.EmployeeGateway;
import DataAccesLayer.VacationGateway;
import Model.Request;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Ciprian on 6/1/2017.
 */
public class ReserveB {

    public void reserve(int id,int id1){
        try {

            Connection myConn = DBConnect.getConnection();
            Statement stm = null;
            stm = myConn.createStatement();
            String instr = "select * from Vacation where id="+id1;
            ResultSet result = stm.executeQuery(instr);
            if(result.next()){
                int space=result.getInt("space")-1;
                VacationGateway vg= new VacationGateway();
                vg.updateVacation(id1,result.getString("country"),result.getString("type"),space);
            }
            Connection myConn1 = DBConnect.getConnection();

            String instr1 = "insert into ClientVacation (clientId,vacationId) values ( ?, ?)";
            PreparedStatement p = myConn1.prepareStatement(instr1);
            p.setInt(1,id);
            p.setInt(2, id1);


            int ok= p.executeUpdate();
            if(ok==1) {
                System.out.println("Vacation reserve !");
            } else {
                System.out.println("Vacation reserve error !");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void request(int id,int id1){
        try {

            Connection myConn = DBConnect.getConnection();
            Statement stm = null;
            stm = myConn.createStatement();
            String instr = "select * from Vacation where id="+id1;
            ResultSet result = stm.executeQuery(instr);
            if(result.next()){
                Connection myConn1 = DBConnect.getConnection();

                String instr1 = "insert into Reservation (clientId,vacationId) values ( ?, ?)";
                PreparedStatement p = myConn1.prepareStatement(instr1);
                p.setInt(1,id);
                p.setInt(2, id1);
                int ok= p.executeUpdate();
                if(ok==1) {
                    System.out.println("Vacation requested !");
                } else {
                    System.out.println("Vacation request error !");

                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DefaultTableModel readRequest(){
        ArrayList<Request> c = EmployeeGateway.readallRequests();
        String[] colum ={"id","clientId","vacationId"};

        DefaultTableModel table = new DefaultTableModel(colum,0);
        //table.addRow(colum);

        for(int i=0;i<c.size();i++){
            Object[] row = {
                    c.get(i).getId(),
                    c.get(i).getId1(),
                    c.get(i).getId2()


            };
            table.addRow(row);
        }

        return table;
    }

}
