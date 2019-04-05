package networkOperations;

import ObjectFactory.UserBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Logowanie {
   
    public static UserBean login(UserBean ub){
    
        PreparedStatement ps = null;   
        ResultSet rs = null;    
        
        String userLogin = ub.getLogin();
        String userPassword = ub.getPassword();
        
        String query = "SELECT * FROM `user` WHERE `Login` =? AND `Password` =?";
         
        try{
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, userLogin);
            ps.setString(2, userPassword);
            rs = ps.executeQuery();
            
            boolean more = rs.next();
            if(!more){
                System.out.println("Sorry, you are not a registered user! Please sign up first");
                ub.setValid(false);
                ub.setLogin(null);
                ub.setPassword(null);
            } 
            else{   
                int idUser = rs.getInt("id_user");
                // jezeli user jest w bazie to pobierz jego imie i nazwisko
            String newQuery = "SELECT * FROM `person` WHERE `user_fk` =? ";
            rs.close();
            ps.close();
                
            ps = MyConnection.getConnection().prepareStatement(newQuery);
            ps.setInt(1, idUser);
            rs = ps.executeQuery();
            more = rs.next();
            
                if(!more)
                    System.out.println("bład zapytania");
                else{
                    ub.setFirstName(rs.getString("First_Name"));
                    ub.setLastName(rs.getString("Last_Name"));

                    System.out.println("Welcome " + ub.getFirstName() + " " + ub.getLastName());
                    ub.setValid(true);
                }
            }
        } 
        catch(SQLException e){
            System.out.println(e.getMessage()); 
        } 
        finally {
         if (rs != null)	{
            try {
               rs.close();
            } catch (SQLException e) {}
               rs = null;
            }
	
         if (ps != null) {
            try {
               ps.close();
            } catch (SQLException e) {}
               ps = null;
            }
      }

        return ub;
    }
        
}