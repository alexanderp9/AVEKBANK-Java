package AccountCollection;

import java.util.Random;

public class SavingBankAccount extends BankAccount {
    private double interestRate;

    public void deposit(double amount) {
        super.balance += amount;
    }
    public void withdraw(double amount) {
        super.balance -= amount;
    }
    public double getBalance() {
        return super.balance;
    }

    public int getRandomizedAccountNr(){
        Random random = new Random();
        return random.nextInt(100000,999999);
    }

}
