package BusinessLayer;

import DataAccesLayer.ClientGateway;
import Model.Client;
import Validation.Valid;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;


public class ClientB{

    public boolean addClient(String username,String password,String mail){
        Valid v=new Valid();
        if(v.validClient(username,password,mail)==false){
            return false;
        }
        if(v.existingClient(username)){
            return false;
        }
        ClientGateway emp = new ClientGateway();
        emp.create(username,password,mail);
        return true;
    }

    public boolean updateClient(String username,String password,String mail){


        ClientGateway c =new ClientGateway();
        c.update(username,password,mail);
        return true;
    }

    public boolean delete(String username){
        Valid v=new Valid();
        if(!v.validDeleteE(username)){
            return false;
        }

        ClientGateway c = new ClientGateway();
        c.delete(username);
        return true;
    }

    public DefaultTableModel readClients(){
        ArrayList<Client> c = ClientGateway.readall();
        String[] colum ={"id","username","password","mail"};

        DefaultTableModel table = new DefaultTableModel(colum,0);
        //table.addRow(colum);

        for(int i=0;i<c.size();i++){
            Object[] row = {
                    c.get(i).getId(),
                    c.get(i).getUsername(),
                    c.get(i).getPassword(),
                    c.get(i).getMail()


            };
            table.addRow(row);
        }

        return table;
    }

    public int getId(String username){
        ClientGateway cg= new ClientGateway();
        return cg.getId(username);
    }


}
