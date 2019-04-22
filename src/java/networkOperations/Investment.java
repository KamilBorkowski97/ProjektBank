package networkOperations;

import ObjectFactory.UserBean;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Investment {
    
    public static void addMoney(UserBean user, int amount, int percent){
        
        PreparedStatement ps = null;
        
        try {
            
            double result;
            double kwota = (double) amount;
            
            result = (kwota * (double) percent)/100.00;

            String query = "UPDATE account SET account_balance=account_balance+? WHERE account_number=?;";  
            String accNumber = user.getAccountBean().getAccountNumber();
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setInt(1, (int) result);
            ps.setString(2, accNumber);
            ps.executeUpdate();
            
            user.getAccountBean().addBalance((int)result);
            
        } catch (SQLException ex) {
            Logger.getLogger(Investment.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
         if (ps != null){
            try {
               ps.close();
            } catch (SQLException e) {}
               ps = null;
            }
        }
    }
}