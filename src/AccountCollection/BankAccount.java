package AccountCollection;

import java.util.Random;

public abstract class BankAccount {

    private int accountNumber;
    protected double balance;

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public  double getBalance() {
        return balance;
    }
    public int getRandomizedAccountNr(){
        Random random = new Random();
        return random.nextInt(100000,999999);
    }

    public String print(){return "From BankAccount ";};
}
