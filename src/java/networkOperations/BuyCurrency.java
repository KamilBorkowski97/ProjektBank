/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkOperations;

import ObjectFactory.Kantor;
import ObjectFactory.UserBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adria
 */
public class BuyCurrency {
    
    
    public static boolean  buyCurrency(UserBean user, String type){
        updatePLNBalance(user,"UPDATE account SET account_balance=account_balance-? WHERE account_number=?;");
        switch(type){
            
            case"USD":
                if(ifExist(user)){
                     updateBalance(user,"UPDATE currency SET dolar=dolar+? WHERE id_user=?;","USD");
                    break;
                }else{
                     addKantor(user);
                     updateBalance(user,"UPDATE currency SET dolar=dolar+? WHERE id_user=?;","USD");
                    break;
                }
            case"EUR":
                if(ifExist(user)){
                    updateBalance(user,"UPDATE currency SET euro=euro+? WHERE id_user=?;","EUR");
                    break;
                }else{
                    addKantor(user);
                    updateBalance(user,"UPDATE currency SET euro=euro+? WHERE id_user=?;","EUR");
                    break;
                }
             
            case"GBP":
                if(ifExist(user)){
                    updateBalance(user,"UPDATE currency SET funt=funt+? WHERE id_user=?;","GBP");
                    break;
                }else{
                    addKantor(user);
                    updateBalance(user,"UPDATE currency SET funt=funt+? WHERE id_user=?;","GBP");
                    break;
                }
        }
        
        return true;
    }
    
    public static boolean addKantor(UserBean user){
            boolean  b  = false;
        try{ 
            Connection con = MyConnection.getConnection();
            PreparedStatement ps= con.prepareStatement("insert into `currency`(`id_user`,`dolar`,`euro`,`funt`) values(?,?,?,?)");
             
              ps.setInt(1, user.getIdUser());
              ps.setDouble(2, 0);
              ps.setDouble(3, 0);
              ps.setDouble(4,0);
              b = ps.execute();
              
              
              ps.close();
                
        }catch(Exception e){
            System.err.println(e);
        }   
        return b;
        
    }
    
    public static boolean ifExist(UserBean user){
        
        PreparedStatement ps = null;   
        ResultSet rs = null;  
        boolean more = false;
        
        
        String query = "SELECT * FROM `currency` WHERE `id_user` =? ";
         
        try{
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setInt(1, user.getIdUser());
            rs = ps.executeQuery();
            
            more= rs.next();

            }catch(Exception e){
            System.err.println(e);
            return more;
        }            
        return more;
    }
    
    
    public static boolean updatePLNBalance(UserBean user,String query){
           PreparedStatement ps = null;
        
        try {
            String accNumber = user.getAccountBean().getAccountNumber();
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setInt(1, (int) user.getKantor().getAmount());
            ps.setString(2, accNumber);
            ps.executeUpdate();
            
            user.getAccountBean().addBalance(-(int)user.getKantor().getAmount());
            
         }catch(Exception e){
            System.err.println(e);
            return false;
        }            
        return true;
        
    }
        public static boolean updateBalance(UserBean user,String query,String currency){
        if(user == null || query == null || query.equals("")){
            return false;
        }
        try{     
         Connection con = MyConnection.getConnection();
         PreparedStatement ps=con.prepareStatement(query);
         
         Kantor k = user.getKantor();
         
             if(currency.equals("USD")){
                  user.getKantor().setUsdBalance(k.usdConvert()+k.getUsdBalance()); 
                  ps.setDouble(1, user.getKantor().usdConvert());
                  ps.setInt(2, user.getIdUser());
               
                  ps.execute();
             }else if(currency.equals("EUR")){
                  user.getKantor().setEuroBalance(k.eurConvert()+k.getEuroBalance());
                  ps.setDouble(1, user.getKantor().eurConvert());
                  ps.setInt(2, user.getIdUser());
              
                  ps.execute();
             }else{
                  user.getKantor().setGbpBalance(k.gbpConvert()+k.getGbpBalance());
                  ps.setDouble(1, user.getKantor().gbpConvert());
                  ps.setInt(2, user.getIdUser());
              
                  ps.execute();
             }     
              
        }catch(Exception e){
            System.err.println(e);
            return false;
        }            
        return true;
    }
          
       

           

                

    
    
    
    
}
