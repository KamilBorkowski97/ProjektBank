/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectFactory;

/**
 *
 * @author adria
 */
public class Kantor {
    
    private double amount;
    private double sAmount;
    
    private double usdBalance;
    private double euroBalance;
    private double gbpBalance;
    
    private  double usd;
    private  double eur;
    private  double gbp;

    public Kantor() {
    }
    

    public Kantor(double usdBalance, double euroBalance, double gbpBalance) {
        this.usdBalance = usdBalance;
        this.euroBalance = euroBalance;
        this.gbpBalance = gbpBalance;
    }

    public double getsAmount() {
        return sAmount;
    }

    public void setsAmount(double sAmount) {
        this.sAmount = sAmount;
    }

    
    public double getUsdBalance() {
        return usdBalance;
    }

    public void setUsdBalance(double usdBalance) {
       this.usdBalance = usdBalance;
  
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getEuroBalance() {
        return euroBalance;
    }

    public void setEuroBalance(double euroBalance) {
        this.euroBalance = euroBalance;
    }

    public double getGbpBalance() {
        return gbpBalance;
    }

    public void setGbpBalance(double gbpBalance) {
        this.gbpBalance = gbpBalance;
    }

    public double getUsd() {
        return usd;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }

    public double getEur() {
        return eur;
    }

    public void setEur(double eur) {
        this.eur = eur;
    }

    public double getGbp() {
        return gbp;
    }

    public void setGbp(double gbp) {
        this.gbp = gbp;
    }
    
    
    public double usdConvert(){
    return amount/usd;
    }
   public double eurConvert(){
    return amount/eur;
    }
      public double gbpConvert(){
    return amount/gbp;
    }
      
    public double usdsConvert(){
    return amount*usd;
    }
   public double eursConvert(){
    return amount*eur;
    }
      public double gbpsConvert(){
    return amount*gbp;
    }
      


    
    
    
}
