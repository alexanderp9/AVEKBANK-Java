package AccountCollection;

public class AccountFactory {
    public static BankAccount createAccount(String accountType){
        if (accountType.equals("Saving")){
            return new SavingBankAccount();
        }
        throw new IllegalArgumentException("invalid input");
    }
}
