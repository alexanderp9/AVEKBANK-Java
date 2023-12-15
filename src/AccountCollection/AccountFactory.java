package AccountCollection;

public class AccountFactory {
    public static BankAccount createAccount(AccountType accountType) {

        BankAccount account = null;

        switch (accountType) {
            case CHECKING:
                account = new CheckingBankAccount();
                account.setAccountType(AccountType.CHECKING.accounttype);
                break;
            case SAVING:
                account = new SavingBankAccount();
                account.setAccountType(AccountType.SAVING.accounttype);
                break;
            default:
                System.out.println("Fel input i AccountFactory"); break;
//                throw new IllegalArgumentException("Invalid shape type: " + accountType);
        }
        return account;
    }
}
