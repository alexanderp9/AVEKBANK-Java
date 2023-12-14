public class AccountFactory {
    public static Account createAccount(String accountType) {
        Account account;
        switch (accountType) {
            case "Checking":
                account = new CheckingAccount();
                break;
            case "Saving":
                account = new SavingAccount();
                break;
            default:
                System.out.println("Hej");
                //throw new IllegalArgumentException("Invalid shape type: " + accountType);
        }
        return account;
    }
}
