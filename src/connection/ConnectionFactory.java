package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Alex Da Silva Alves
 */
public class ConnectionFactory {
    public static Connection getConnection()throws SQLException{
         return DriverManager.getConnection("jdbc:mysql://localhost/dbreserva", "root", "root");
    }
}
