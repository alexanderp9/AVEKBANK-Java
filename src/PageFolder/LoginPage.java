/*package PageFolder;

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
        int bankID = 0;

        //after identity check success
        //List<BankAccount> bankAccounts = new ArrayList<>();
        Customer customer = new Customer();
        //customer.addAccountToList(BankAccount );


        if (sc.hasNextInt()) {
            bankID = sc.nextInt();
        } else {
            System.out.println("No valid id");
        }
        Customer customer1 = new Customer(bankID);

        System.out.println("Login success. Please wait...");
        super.contentpage.setPage(new HomePage(super.contentpage, customer));
        super.contentpage.executepage();

    }
}

 */