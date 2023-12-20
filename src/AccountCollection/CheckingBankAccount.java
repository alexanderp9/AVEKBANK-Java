package AccountCollection;


public class CheckingBankAccount extends BankAccount {

    private double creditWithdrawLimit = 5000.00; // maxgräns för kredit på Checking account

    @Override

    public void withdraw(double amount) {
        if (amount <= balance + creditWithdrawLimit) {
            balance -= amount;
        } else {
            System.out.println("You have exceeded the credit limit! Withdrawal was denied. Maximum Credit is 5000.");
        }
    }

}
