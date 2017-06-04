package DBConn;

/**
 * Created by Ciprian on 3/22/2017.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    private static String mysql = "jdbc:mysql://localhost:3306/travel";
    private static String user = "root";
    private static String pass = "1234";

    public static Connection getConnection()  {
        try {
            return DriverManager.getConnection(mysql,user,pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
