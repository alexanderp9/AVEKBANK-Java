package AccountCollection;

public class DepositTransaction implements  Transaction{
    private BankAccount account;
    private double amount;

    public DepositTransaction(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }


    @Override
    public void execute() {
        account.deposit(amount);
        account.addTransactionHistory(this);
    }

    @Override
    public String toString() {
        return "Deposited " + amount + "kr to account number " + account.getAccountNumber();

    }
}
