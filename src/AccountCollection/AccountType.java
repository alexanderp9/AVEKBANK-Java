package AccountCollection;

public enum AccountType {
    SAVING("Saving"),
    CREDITCARD("Creditcard"),
    CHECKING("Checking");
    final String accounttype;

    AccountType(String accounttype){
        this.accounttype = accounttype;
    }
}
