package AccountCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Customer {

    private int bankId;
    private List<BankAccount> accounts;

    //list<BankAccount> Saving;
    //list<BankAccount> Checking;

    public Customer(int bankId) {
        this.bankId = bankId;
        this.accounts = new ArrayList<>();
    }



    public void addAccountToList(AccountType accountType) {
        BankAccount newAccount = AccountFactory.createAccount(accountType);
        newAccount.setAccountNumber(getRandomizedAccountNr());
        accounts.add(newAccount);

        //accounts.add(AccountFactory.createAccount(accountType));  //Creating an account with createAccount() from class AccountFactory
        // and adding to Customer List<BankAccount> accounts
    }

    public int getRandomizedAccountNr(){
        Random random = new Random();
        return random.nextInt(100000,999999);
    }

    public void deleteAccountInList(BankAccount bankAccount) {
        accounts.remove(0);  //More logic need for removing the correct account. Maybe with account.getAccountNumber
    }

    public int getBankId() {
        return bankId;
    }
    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public String printoutAccountsWithIndex() {
        StringBuilder sb = new StringBuilder();
        //sb.append("Customer Bank ID: ").append(bankId).append("\n");
        for (int i = 0; i < accounts.size(); i++) {
            BankAccount account = accounts.get(i);
            sb.append("Account choice: ").append(i+1)
//                    .append(", Account-number: ").append(account.getAccountNumber())
                    .append(", ")
                    .append(account.getAccountType())
                    .append(" Account-number: ").append(account.getAccountNumber())
                    .append(", Balance: ").append(account.getBalance())
                    .append("\n");
        }
        return sb.toString();
    }

    public String printOutActualAccountBalance(int AccountIndex) {
        return "Balance: " + String.valueOf(accounts.get(AccountIndex - 1).getBalance());
    }
}
