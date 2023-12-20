package AccountCollection;

import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {

    private int accountNumber;
    protected double balance;
    private String accountType;
    private List<Transaction> transactionHistory = new ArrayList<>();


    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void withdraw(double amount) {
        if (balance > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("There is not enough founds on your account");
        }
    }

    public void addTransactionHistory (Transaction transaction) {
        transactionHistory.add(transaction);
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

/*    @Override
    public String toString() {
        return "BankAccount{" +
                "transactionHisrtjdktlufkjytttfhstory=" + transactionHistory +
                '}';
    }*/
}
