public abstract class Account {

    private int accountNumber;
    protected double balance;

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public  double getBalance() {
        return balance;
    }
    //getRandomizedAccountNr()

}
