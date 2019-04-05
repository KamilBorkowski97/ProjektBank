package ObjectFactory;

public class UserBean {
	
    private String password;
    private String login;
    private String FirstName;
    private String LastName;
    public boolean valid;

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

    public boolean isValid(){
       return valid;
    }

    public void setValid(boolean newValid){
       valid = newValid;
    }	
}