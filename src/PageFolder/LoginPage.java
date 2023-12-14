package PageFolder;

import AccountCollection.AccountFactory;
import AccountCollection.BankAccount;
import AccountCollection.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginPage extends ExecutePageCreator{

    public LoginPage(Content contentpage) {
        super(contentpage);
    }

    @Override
    public void execute() {
        System.out.println("Enter your bankID");
        Scanner sc = new Scanner(System.in);

        //after identity check success
        List<BankAccount> bankAccounts = new ArrayList<>();
        Customer customer = new Customer(bankAccounts);
        System.out.println("Login success. Please wait...");
        super.contentpage.setPage(new HomePage(super.contentpage));
        super.contentpage.executepage();

    }
}