package AccountCollection;

public class AccountFactory {
    public static BankAccount createAccount(AccountType accountType) {

        BankAccount account = null;

        switch (accountType) {
            case CHECKING:
                account = new CheckingBankAccount();
                account.setAccountType(AccountType.CHECKING.accounttype); //register the account type to the account
                break;
            case CREDITCARD:
                account = new CreditCardAccount();
                account.setAccountType(AccountType.CREDITCARD.accounttype);
                break;
            case SAVING:
                account = new SavingBankAccount();
                account.setAccountType(AccountType.SAVING.accounttype); //register the account type to the account
                break;
            default:
                System.out.println("Fel input i AccountFactory"); break;
        }
        return account;
    }
}
