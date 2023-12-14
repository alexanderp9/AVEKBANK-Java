public class CheckingAccount extends Account{
    public void deposit(double amount) {
        super.balance =+ amount;
    }
    public void withdraw(double amount) {
        super.balance =- amount;
    }
    public double getBalance() {
        return super.balance;
    }
}
