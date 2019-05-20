package ObjectFactory;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class UserBean {
	
    private String password;
    private String login;
    private String FirstName;
    private String LastName;
    private String email;
    private String phoneNumber;
    public boolean valid;
    
    private boolean isAdmin;
    
    Address address;
    AccountBean account = new AccountBean(); 



    public UserBean(String password, String login, String FirstName, String LastName, String email,String phoneNumber, Address address, AccountBean account) {
        this.password = password;
        this.login = login;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.account = account;
    }
    public UserBean(){
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public AccountBean getAccountBean() {
        return account;
    }

    public void setAccount(AccountBean account) {
        this.account = account;
    }

    

    public String getPassword(){
       return password;
    }

    public void setPassword(String newPassword){
        
       password = newPassword;
    }

    public String getLogin(){
       return login;
    }

    public void setLogin(String newLogin){
       login = newLogin;
    }
    
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }
        public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
      public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isValid(){
       return valid;
    }

    public void setValid(boolean newValid){
       valid = newValid;
    }	
    
    
    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
   
}