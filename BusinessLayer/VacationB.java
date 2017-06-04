package BusinessLayer;

import DataAccesLayer.VacationGateway;
import Model.Stay;
import Model.Vacation;
import Validation.Valid;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;


public class VacationB {

    public boolean addVacation(String country,String type,int space){
        Valid v=new Valid();
        if(v.validVacation(country,type,space)==false){
            return false;
        }
        VacationGateway emp = new VacationGateway();
        emp.createVacation(country,type,space);
        return true;
    }

    public boolean updateVacation(int id,String country,String type,int space){


        VacationGateway c =new VacationGateway();
        c.updateVacation(id,country,type,space);
        return true;
    }

    public boolean deleteVacation(int id,String type){
        Valid v=new Valid();
        if(!v.validDeleteV(id)){
            return false;
        }

        VacationGateway c = new VacationGateway();
        c.deleteVacation(id,type);
        return true;
    }

    public DefaultTableModel readVacations(){
        ArrayList<Vacation> c = VacationGateway.readallVacation();
        String[] colum ={"id","country","type","space"};

        DefaultTableModel table = new DefaultTableModel(colum,0);
        //table.addRow(colum);

        for(int i=0;i<c.size();i++){
            Object[] row = {
                    c.get(i).getId(),
                    c.get(i).getCountry(),
                    c.get(i).getType(),
                    c.get(i).getSpace()


            };
            table.addRow(row);
        }

        return table;
    }


    public boolean addStay(int vacationId,String sight){
        Valid v=new Valid();
        if(v.validStay(vacationId,"stay")==false){
            return false;
        }
        VacationGateway emp = new VacationGateway();
        emp.createStay(vacationId,sight);
        return true;
    }

    public boolean updateStay(int id,int vacationId,String sight){


        VacationGateway c =new VacationGateway();
        c.updateStay(id,vacationId,sight);
        return true;
    }

    public boolean deleteStay(int id){
        Valid v=new Valid();
        if(!v.validDeleteS(id)){
            return false;
        }

        VacationGateway c = new VacationGateway();
        c.deleteStay(id);
        return true;
    }

    public DefaultTableModel readStay(){
        ArrayList<Stay> c = VacationGateway.readallStay();
        String[] colum ={"id","vacationId","sight"};

        DefaultTableModel table = new DefaultTableModel(colum,0);
        //table.addRow(colum);

        for(int i=0;i<c.size();i++){
            Object[] row = {
                    c.get(i).getId(),
                    c.get(i).getVacationId(),
                    c.get(i).getSight(),


            };
            table.addRow(row);
        }

        return table;
    }


}
