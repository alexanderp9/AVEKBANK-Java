package AccountCollection;

public class AccountFactory {
    public static BankAccount createAccount(String accountType) {
        BankAccount account = null;

        switch (accountType) {
            case "Checking":
                account = new CheckingBankAccount();
                break;
            case "Saving":
                account = new SavingBankAccount();
                break;
            default:
                System.out.println("Fel input i AccountFactory");
                //throw new IllegalArgumentException("Invalid shape type: " + accountType);
        }
        return account;
    }
}
