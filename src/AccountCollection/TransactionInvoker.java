package AccountCollection;

import java.util.ArrayList;
import java.util.List;

public class TransactionInvoker {

    private List<Transaction> transactionList;

    public TransactionInvoker() {
        transactionList = new ArrayList<>();
    }

    public void executeTransaction(Transaction transaction) {
        transactionList.add(transaction);
        transaction.execute();
    }
}
