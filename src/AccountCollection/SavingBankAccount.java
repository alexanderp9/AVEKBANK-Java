package AccountCollection;

public class SavingBankAccount extends BankAccount {
    public void deposit(double amount) {
        super.balance =+ amount;
    }
    public void withdraw(double amount) {
        super.balance =- amount;
    }
    public double getBalance() {
        return super.balance;
    }
    @Override
    public String print(){
        return "i have saving account 1";
    }
}
