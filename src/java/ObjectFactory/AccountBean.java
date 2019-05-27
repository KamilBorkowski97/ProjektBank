package ObjectFactory;

public class AccountBean {

    private String accountNumber;
    private int accountBalance;



    public AccountBean(String accountNumber, int accountBalance) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        
    }
    
    public AccountBean(){}
    
   
    
    public void addBalance(int value){
        accountBalance+=value;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    
}