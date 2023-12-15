package PageFolder;

import AccountCollection.Customer;

public abstract class ExecutePageCreator implements ExecutePage{
    Customer customer;

    Content contentpage;
    public ExecutePageCreator(Content contentpage, Customer customer){
        this.contentpage = contentpage;
        this.customer = customer;

    }

    public ExecutePageCreator(Content contentpage){
        this.contentpage = contentpage;
    }

    public Customer getCustomer(){
        return customer;
    }
}

