package networkOperations;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUser {
 
    public static void deleteUser(String toDelete){
        
        String query = "DELETE FROM user WHERE login=?;";
        
        PreparedStatement ps = null;
        
        try{
            
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, toDelete);
            
            ps.executeUpdate(query);
            
        }catch(SQLException e){
            e.getMessage();
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