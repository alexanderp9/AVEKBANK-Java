package AccountCollection;

public enum AccountType {
    SAVING("Saving"),
    CHECKING("Checking");

    final String accounttype;

    AccountType(String accounttype){
        this.accounttype = accounttype;
    }
}
