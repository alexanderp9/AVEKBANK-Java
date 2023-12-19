package AccountCollection;

import java.util.Random;

public abstract class BankAccount {

    private int accountNumber;
    protected double balance;

    private String accountType;

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }


    public String getAccountType(){
        return this.accountType;
    }

    public void setAccountType(String accountType){ //register the account type to the account
        this.accountType = accountType;
    }

}
