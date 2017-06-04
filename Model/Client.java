package Model;

/**
 * Created by Ciprian on 5/31/2017.
 */
public class Client {

    private int id;
    private String username;
    private String password;
    private String mail;

    public Client(){};

    public Client(int id,String username,String password, String mail){
        this.id=id;
        this. username=username;
        this.password=password;
        this.mail=mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


}
