package networkOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    
    
    // create a function to connect with mysql database
    
    public static Connection getConnection(){
     
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //uwaga bez cj. nie zadziala
            con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/H384ZyMAzK?autoReconnect=true&useSSL=false", "H384ZyMAzK", "8Wy2z1vPRb");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return con;
    }
    
}