/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import networkOperations.Investment;
import networkOperations.MyConnection;

/**
 *
 * @author adria
 */
public class Loan {
    
    /*-Pobranie kredytu przez wypełnienie formularza(kwota kredytu, stałe oprocentowanie, okres kredytu). 
    Wyliczana jest suma kredytu i wyświetlana. Pieniądze wędrują do użytkownika.*/
    
    private int amount;
    private double interest;
    private int loanPeriod;

    public Loan() {
        setInterest();
    }
    

    public Loan(int amount, int loanPeriod) {
        this.amount = amount;
        this.loanPeriod = loanPeriod*12;
        setInterest();
    }

 
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getInterest() {
        return interest;
    }

    public int getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(int loanPeriod) {
        this.loanPeriod = loanPeriod;
    }
    
    private void setInterest(){
        Random rnd = new Random();
        interest = rnd.nextInt(4)+5;
        
    }
    
    public int odsetki(){
   
    double amount1 = (double)amount;
    int result = (int)(amount1 * interest/100);
    
    return result;
    }
    
    public int installment(){
       return (amount+odsetki())/loanPeriod; 
    }
    public int fullcost(){
        return loanPeriod * installment();
    }

   public static void updateAccount(UserBean user, int amount){
          
        PreparedStatement ps = null;
        
        try {

            String query = "UPDATE account SET account_balance=account_balance+? WHERE account_number=?;";  
            String accNumber = user.getAccountBean().getAccountNumber();
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setInt(1, (int) amount);
            ps.setString(2, accNumber);
            ps.executeUpdate();
            
            user.getAccountBean().addBalance((int)amount);
            
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
