package AccountCollection;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private int bankId;

    private List<BankAccount> accounts;

    public Customer(int bankId) {
        this.bankId = bankId;
        this.accounts = new ArrayList<>();
    }



    public void addAccountToList(String accountType) {
        accounts.add(AccountFactory.createAccount(accountType));  //Creating an account with createAccount() from class AccountFactory
        // and adding to Customer List<BankAccount> accounts
    }

    public void deleteAccountInList(BankAccount bankAccount) {
        accounts.remove(0);  //More logic need for removing the correct account. Maybe with account.getAccountNumber
    }

    public int getBankId() {
        return bankId;
    }
}
