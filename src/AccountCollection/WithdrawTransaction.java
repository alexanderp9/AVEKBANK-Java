package AccountCollection;

public class WithdrawTransaction implements Transaction{

    private BankAccount account;
    private double amount;

    public WithdrawTransaction(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }


    @Override
    public void execute() {
        account.withdraw(amount);
        account.addTransactionHistory(this);
    }

    @Override
    public String toString() {
        return "Withdraw " + amount + "kr from account number " + account.getAccountNumber();
    }
}
