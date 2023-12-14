public abstract class Account extends AccountFactory {

    private int accountNumber;
    protected double balance;

    public void deposit(double amount) {}
    public void withdraw(double amount) {}
    public double getBalance() {
        return balance;
    }
    //getRandomizedAccountNr()

}
