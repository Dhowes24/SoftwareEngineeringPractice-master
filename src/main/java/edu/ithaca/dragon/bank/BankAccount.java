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
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
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
        if(amount>0 && amount<=balance)
        balance -= amount;
    }

    /**
     *This checks whether the given string contains a '@' symbol.
     * If it does then is returns a true, if not it returns false.
     * @param email
     * @return boolean
     */
    public static boolean isEmailValid(String email){
        if (email.indexOf('@') == -1){
            return false;
        }
        else {
            return true;
        }
    }
}
