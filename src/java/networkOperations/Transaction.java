package networkOperations;

import ObjectFactory.UserBean;
import java.sql.*;

public class Transaction {
    
    public static boolean transfer(String title, String accNumber, int amount, UserBean user){
        
        if(amount>user.getAccountBean().getAccountBalance())
            return false;
        
        PreparedStatement ps = null;   
            //pierwsze zapytanie dodaje pieniądze na konto na które przelewamy, drugie odejmuje z konta currentUser
        String query = "UPDATE account SET account_balance=account_balance+? WHERE account_number=?;";  
        String query2 = "UPDATE account SET account_balance=? WHERE account_number=?;";
        
        String currentUserAccNumber = user.getAccountBean().getAccountNumber();
        int currentUserAccBalance = user.getAccountBean().getAccountBalance();
        int newValue = currentUserAccBalance - amount;
        try{
            
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setInt(1, amount);
            ps.setString(2, accNumber);
            ps.executeUpdate();
            
            ps = MyConnection.getConnection().prepareStatement(query2);
            ps.setInt(1, newValue);
            ps.setString(2, currentUserAccNumber);
            ps.executeUpdate();
            
            user.getAccountBean().setAccountBalance(newValue);
            
            ps.close();
            return true;
            
        }catch(SQLException e){
            e.getMessage();
        }catch(Exception e){
            e.getMessage();
        }
         finally {
         if (ps != null){
            try {
               ps.close();
            } catch (SQLException e) {}
               ps = null;
            }
      }
        return false;
    }
    
    public static boolean checkIfExists(String accNumber){

        try{
            PreparedStatement ps = null; 
            String check = "SELECT * FROM account WHERE account_number=?;";
        
            ps = MyConnection.getConnection().prepareStatement(check);
            ps.setString(1, accNumber);

            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                String result = rs.getString("account_number");
                if(result.equals(accNumber))
                    return true;
                else 
                    return false;
            }
            
            }catch(SQLException e){
                return false;
            }
        return false;

    }
    
}