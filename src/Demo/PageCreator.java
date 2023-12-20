package Demo;

import AccountCollection.Customer;

import java.util.Scanner;

public abstract class PageCreator implements State{
    private Context context;
    private Customer customer;
    private Scanner scanner;

    public PageCreator(Context context, Customer customer, Scanner scanner) {
        this.context = context;
        this.context.setPageState(this);
        this.customer = customer;
        this.scanner = scanner;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
        context.setPageState(this);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
