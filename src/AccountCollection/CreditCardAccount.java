package AccountCollection;

import java.util.Random;

public class CreditCardAccount extends BankAccount{
    @Override
    public void deposit(double amount) {
        super.balance += amount;
    }
    @Override
    public void withdraw(double amount) {
        super.balance -= amount;
    }
    @Override
    public double getBalance() {
        return super.balance;
    }
    @Override
    public int getRandomizedAccountNr(){
        Random random = new Random();
        return random.nextInt(100000,999999);
    }
}
