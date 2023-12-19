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
        if (balance > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("There is not enough founds on your account");
        }
    }

    public double getBalance() {
        return balance;
    }

    public int getRandomizedAccountNr(){
        Random random = new Random();
        return random.nextInt(100000,999999);
    }

    public String getAccountType(){
        return this.accountType;
    }

    public void setAccountType(String accountType){ //register the account type to the account
        this.accountType = accountType;
    }

}
