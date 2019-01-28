package edu.ithaca.dragon.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email)){
            this.email = email;
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
        if (isAmountValid(startingBalance)){
            this.balance = startingBalance;
        }
        else{
            throw new IllegalArgumentException("$"+startingBalance+" is not a valid amount");

        }
    }

    /**
     * This function checks if the given amount is valid
     * by checking if it a positive number with no more than 2 decimal places
     * @param amount
     * @return
     */
    public boolean isAmountValid(double amount){
        if(amount>=0){
            String string =Double.toString(amount);
            String arr[] =string.split("\\.");
            if(arr[1].length()>2){
                return false;
            }
            else{
                return true;
            }
        }
        else{
        return false;}
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }

/**
 * This function withdraws an amount from the bank if the bank contains enough money
 * The amount must be a positive amount that has no more or less than two decimal places
 */
    public void withdraw (double amount)  {
        if(isAmountValid(amount) && amount<=balance)
        balance -= amount;
    }

    /**
     *This checks whether the given string contains a '@' symbol.
     * It also checks if there are characters before and after the '@' symbol
     * followed by at .com in the end
     * @param email
     * @return boolean
     */
    public static boolean isEmailValid(String email){
        String arr[] = email.split("@");
        if (email.indexOf('@') == -1 || arr.length!=2 || !email.contains(".com")){
            return false;
        }
        else if(arr[0].length()<1 ||arr[1].length()<5){
            return false;
        }
        else{
            return true;
        }
    }
}
