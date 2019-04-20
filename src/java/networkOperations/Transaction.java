package networkOperations;

import java.sql.*;
public class Transaction {
    
    
    public static void transfer(String title, String accNumber, int amount){
        //robi przelew, ale nie zapisuje go
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;    

        //String query = "UPDATE account SET account_balance=account_balance" + amount + " WHERE account_number=" + accNumber + ";";  
        String query = "UPDATE account SET account_balance=account_balance+? WHERE account_number=?;";  
        try{
            
            ps = MyConnection.getConnection().prepareStatement(query);
            //stmt = MyConnection.getConnection().createStatement();
            //stmt.executeUpdate(query);
            ps.setInt(1, amount);
            ps.setString(2, accNumber);
            ps.executeUpdate();
            //rs = ps.executeUpdate();
            
        }catch(SQLException e){
            e.getMessage();
        }catch(Exception e){
            e.getMessage();
        }
         finally {
         if (rs != null){
            try {
               rs.close();
            } catch (SQLException e) {}
               rs = null;
            }
	
         if (stmt != null) {
            try {
               stmt.close();
            } catch (SQLException e) {}
               stmt = null;
            }
      }
    }
}