package AccountCollection;

public class AccountFactory {
    public static BankAccount createAccount(AccountType accountType) {

        BankAccount account = null;

        switch (accountType) {
            case CHECKING:
                account = new CheckingBankAccount();
                account.setAccountType(AccountType.CHECKING.accounttype);
                break;
            case CREDITCARD:
                CreditCardAccount creditCardAccount = new CreditCardAccount();
                creditCardAccount.setAccountType(AccountType.CREDITCARD.accounttype);
                creditCardAccount.getRandomizedCardNumber();
                creditCardAccount.getRandomizedPINCode();
                account = creditCardAccount;
                break;
            case SAVING:
                account = new SavingBankAccount();
                account.setAccountType(AccountType.SAVING.accounttype);
                break;
            default:
                System.out.println("Fel input i AccountFactory"); break;
        }
        return account;
    }
}
