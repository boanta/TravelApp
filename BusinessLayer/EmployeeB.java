package BusinessLayer;

import DataAccesLayer.EmployeeGateway;
import Model.Employee;
import Validation.Valid;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;


public class EmployeeB {

    public boolean addEmployee(String username,String password,String role){
        Valid v=new Valid();
        if(v.validEmployee(username,password,role)==false){
            return false;
        }
        if(v.validEmployee(username,password).equals("admin")
                ||v.validEmployee(username,password).equals("employee")
                ||v.validClient(username,password) == true){
            return false;
        }
        EmployeeGateway emp = new EmployeeGateway();
        emp.create(username,password,role);
        return true;
    }

    public boolean updateEmployee(String username,String password,String role){


        EmployeeGateway c =new EmployeeGateway();
        c.update(username,password,role);
        return true;
    }

    public boolean delete(String username){
        Valid v=new Valid();
        if(!v.validDeleteE(username)){
            return false;
        }

        EmployeeGateway c = new EmployeeGateway();
        c.delete(username);
        return true;
    }

    public DefaultTableModel readEmployees(){
        ArrayList<Employee> c = EmployeeGateway.readall();
        String[] colum ={"id","username","password","role"};

        DefaultTableModel table = new DefaultTableModel(colum,0);
        //table.addRow(colum);

        for(int i=0;i<c.size();i++){
            Object[] row = {
                    c.get(i).getId(),
                    c.get(i).getUsername(),
                    c.get(i).getPassword(),
                    c.get(i).getRole()


            };
            table.addRow(row);
        }

        return table;
    }


}
