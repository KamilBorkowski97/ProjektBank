package networkOperations;

import ObjectFactory.AccountBean;
import ObjectFactory.Address;
import ObjectFactory.UserBean;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Random;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 *
 * @author adria
 */
public class Rejestracja {
    
    private static String emailLogin;

    public Rejestracja() {
        
    }
    
    public static void registration(UserBean user){
        
        int idUser = addUserGetId(user);
        addAccount(user.getAccountBean(),idUser);
        int idAdress = addAddressGetId(user.getAddress());
        addUser(user,idAdress,idUser);
        

        sendEmail(user);
        
    }
    
    private static void sendEmail(UserBean user){ //do wysyłania maila z loginem
        
      String to = user.getEmail();

      final String username = "kierunek.informatyka@o2.pl";
      final String password = "2017akademiaSAN";
      
      String host = "localhost";

      Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "poczta.o2.pl");
        props.setProperty("mail.user", "kierunek.informatyka@o2.pl");
        props.setProperty("mail.password", "2017akademiaSAN");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.from", "kierunek.informatyka@o2.pl");

      Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

       try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(user.getEmail()));
            message.setSubject("Witamy w Fake Banku !");
            message.setText("Cześć," + user.getFirstName() + "!\n"
                + "\n\n jest nam niezmiernie miło powitać Cię w naszym fake banku jedynym takim fake banku w Polsce!\n"
                + "Twoj Login: " + emailLogin + "\n\n Pozdrawiam z piwnicy Kamil B. wraz z zarządem FakeBank");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
   
    }
   /* public static boolean registration(UserBean user){
        
        int idUser = addUserGetId(user);
        if(idUser >0){
        addAccount(user.getAccount(),idUser);
        int idAdress = addAddressGetId(user.getAddress());
        
        if(idAdress > 0){
        return addUser(user,idAdress,idUser);
            }
        }
        
      return false;

        
    }*/
    
    private static boolean addUser(UserBean user,int idAdress, int idUser){
        
          try{
              Connection con = MyConnection.getConnection();
              PreparedStatement ps=con.prepareStatement("insert into `person`(`First_Name`,`Last_Name`,`Join_Date`,`email`,`phone`,`address_fk`,`user_fk`) values(?,?,?,?,?,?,?)");
          
              
              ps.setString(1, user.getFirstName());
              ps.setString(2, user.getLastName());
              ps.setDate(3, Rejestracja.currentDate());
              ps.setString(4, user.getEmail());
              ps.setString(5,user.getPhoneNumber());
              ps.setInt(6, idAdress);
              ps.setInt(7, idUser);
            return  ps.execute();
              
          }catch(Exception e){
          System.err.println(e.toString());}
      return false;
    }
    
    
    private static int addAddressGetId(Address addres){
        int idAdress = -1;
        try{     
         Connection con = MyConnection.getConnection();
         PreparedStatement ps=con.prepareStatement("insert into `addresses`(`Country`,`City`,`Address`,`Postal_Code`) values(?,?,?,?)");
         
        
              ps.setString(1, addres.getCountry());
              ps.setString(2, addres.getCity());
              ps.setString(3, addres.getAddress());
              ps.setString(4, addres.getPostalCode());
              ps.execute();
            
                ResultSet rs=ps.executeQuery("select * from addresses");
                if(rs.last()){
                idAdress=rs.getInt("id_address");
                ps.close();
                rs.close();
                
                return idAdress;
                }
              
        }catch(Exception e){
            System.err.println(e);
        }            
         return idAdress;
    }
    private static int addUserGetId(UserBean user){
        int idUser = -1;
        try{     
             Connection con = MyConnection.getConnection();
             PreparedStatement ps=con.prepareStatement("insert into `user`(`Login`,`Password`) values(?,?)");
              ps.setString(1, user.getLogin());
              ps.setString(2, user.getPassword());
              ps.execute();
                
                ResultSet rs=ps.executeQuery("select * from user");
                if(rs.last()){
                idUser=rs.getInt("id_user");
                return idUser;
                }
                ps.close();
                rs.close();
              
              
        }catch(Exception e){
            System.err.println(e);
        }
        return idUser;
    }            
      
    
     private static boolean addAccount(AccountBean account,int idUser){
            boolean  b  = false;
        try{ 
            Connection con = MyConnection.getConnection();
            PreparedStatement ps= con.prepareStatement("insert into `account`(`account_number`,`account_balance`,`assumption_date`,`fk_user`) values(?,?,?,?)");
             
              ps.setString(1, account.getAccountNumber());
              ps.setInt(2, account.getAccountBalance());
              ps.setDate(3, Rejestracja.currentDate());
              ps.setInt(4, idUser);
              b = ps.execute();
              
              
              ps.close();
                
        }catch(Exception e){
            System.err.println(e);
        }   
        return b;
        
    }
   
        public static boolean accountNumberValid(String accountNumber){//sprawdza czy login jest w bazie
        PreparedStatement ps = null;   
        ResultSet rs = null;  
        boolean more = false;
        
        
        String query = "SELECT * FROM `account` WHERE `account_number` =? ";
         
        try{
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, accountNumber);
            rs = ps.executeQuery();
            
            more= rs.next();

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
        return more;
    }
        public static String rndAccountNb(){//randomowy login
        Random rnd =new Random();
        StringBuilder sb = new StringBuilder();
        
            for(int i =0;i<15;i++){
                 sb.append(String.valueOf(rnd.nextInt(10)));
            }
    
            return sb.toString();
    }
       public static Date currentDate(){
        
       return new java.sql.Date(Calendar.getInstance().getTime().getTime());
     // return   (Date) Date.from(java.time.ZonedDateTime.now().toInstant());

    }
 
    public static boolean loginValid(String login){//sprawdza czy login jest w bazie
        PreparedStatement ps = null;   
        ResultSet rs = null;  
        boolean more = false;
        
        
        String query = "SELECT * FROM `user` WHERE `Login` =? ";
         
        try{
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, login);
            rs = ps.executeQuery();
            
            more= rs.next();

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
        return more;
    }
    
    public static String rndLogin(){//randomowy login
        Random rnd =new Random();
        StringBuilder sb = new StringBuilder();
        
            for(int i =0;i<8;i++){
                 sb.append(String.valueOf(rnd.nextInt(10)));
            }
            
            emailLogin = sb.toString();
            return sb.toString();
    }
    //walidator emaila
   public static boolean isValidEmailAddress(String email) {
   boolean result = true;
   try {
      InternetAddress emailAddr = new InternetAddress(email);
      emailAddr.validate();
   } catch (AddressException ex) {
      result = false;
   }
   return result;
}
  


}
