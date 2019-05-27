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
import static networkOperations.BuyCurrency.addKantor;
import static networkOperations.BuyCurrency.ifExist;

/**
 *
 * @author adria
 */
public class SellCurrency {
    
    
        public static boolean  sellCurrency(UserBean user, String type){

        switch(type){
            
            case"USD":

                if(ifExist(user)){
                     updateSellBalance(user,"UPDATE currency SET dolar=dolar-? WHERE id_user=?;","USD");
                     updatePLBalance(user,"UPDATE account SET account_balance=account_balance+? WHERE account_number=?;","USD");
                    break;
                }else{
                     addKantor(user);
                     updateSellBalance(user,"UPDATE currency SET dolar=dolar-? WHERE id_user=?;","USD");
                     updatePLBalance(user,"UPDATE account SET account_balance=account_balance+? WHERE account_number=?;","USD");
                    break;
                }
            case"EUR":
                if(ifExist(user)){
                    updateSellBalance(user,"UPDATE currency SET euro=euro-? WHERE id_user=?;","EUR");
                    updatePLBalance(user,"UPDATE account SET account_balance=account_balance+? WHERE account_number=?;","EUR");
                    break;
                }else{
                    addKantor(user);
                    updateSellBalance(user,"UPDATE currency SET euro=euro-? WHERE id_user=?;","EUR");
                    updatePLBalance(user,"UPDATE account SET account_balance=account_balance+? WHERE account_number=?;","EUR");
                   break;
                }
             
            case"GBP":
                if(ifExist(user)){
                    updateSellBalance(user,"UPDATE currency SET funt=funt-? WHERE id_user=?;","GBP");
                    updatePLBalance(user,"UPDATE account SET account_balance=account_balance+? WHERE account_number=?;","GBP");
                    return true;
                }else{
                    addKantor(user);
                    updateSellBalance(user,"UPDATE currency SET funt=funt-? WHERE id_user=?;","GBP");
                    updatePLBalance(user,"UPDATE account SET account_balance=account_balance+? WHERE account_number=?;","GBP");
                    return true;
                }
        }
        
        return true;
    }
        
      public static boolean updatePLBalance(UserBean user,String query, String type){
           PreparedStatement ps = null;
        
        try {
            String accNumber = user.getAccountBean().getAccountNumber();
            
            if(type.equals("USD")){
                user.getKantor().setsAmount(user.getKantor().usdsConvert());
            }else if(type.equals("EUR")){
                user.getKantor().setsAmount(user.getKantor().eursConvert());
            }else{
                user.getKantor().setsAmount(user.getKantor().gbpsConvert());
            }
            
            
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setInt(1, (int) user.getKantor().getsAmount());
            ps.setString(2, accNumber);
            ps.executeUpdate();
            
            
            user.getAccountBean().addBalance((int)user.getKantor().getsAmount());
            
            
        }catch(Exception e){
            System.err.println(e);
            return false;
        }            
        return true;
        
    }
       public static boolean updateSellBalance(UserBean user,String query,String currency){
        if(user == null || query == null || query.equals("")){
            return false;
        }
        try{     
         Connection con = MyConnection.getConnection();
         PreparedStatement ps=con.prepareStatement(query);
         
         Kantor k = user.getKantor();
         
             if(currency.equals("USD")){
                  k.setUsdBalance(k.getUsdBalance()-k.getAmount()); 
                  ps.setDouble(1, k.getAmount());
                  ps.setInt(2, user.getIdUser());
               
                  ps.execute();
             }else if(currency.equals("EUR")){
                  user.getKantor().setEuroBalance(k.getEuroBalance() -k.getAmount());
                  ps.setDouble(1, k.getAmount());
                  ps.setInt(2, user.getIdUser());
              
                  ps.execute();
             }else{
                  user.getKantor().setGbpBalance(k.getGbpBalance() -k.gbpsConvert());
                  ps.setDouble(1, user.getKantor().gbpsConvert());
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
