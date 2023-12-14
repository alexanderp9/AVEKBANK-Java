package AccountCollection;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private List<BankAccount> accounts;

    public Customer(List<BankAccount> accounts) {
        this.accounts = accounts;
    }

    public void addAccountToList(BankAccount bankAccount) {
        accounts.add(bankAccount);
    }

    public void deleteAccountInList(BankAccount bankAccount) {
        accounts.remove(0);  //More logic need for removing the correct account. Maybe with account.getAccountNumber
    }
}
