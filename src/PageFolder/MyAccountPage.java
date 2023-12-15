/*package PageFolder;
import AccountCollection.AccountFactory;
import AccountCollection.BankAccount;
import AccountCollection.Customer;

import java.util.Scanner;

public class MyAccountPage extends ExecutePageCreator{

    public MyAccountPage(Content contentpage) {
        super(contentpage);
    }

    public MyAccountPage(Content contentpage, Customer customer) {
        super(contentpage, customer);
    }



    @Override
    public void execute() {
        System.out.println("Here is my account page");
        BankAccount a = AccountFactory.createAccount("Saving");
        System.out.println(a.print());

        System.out.println("Enter 1 to create an Account");
        System.out.println("Enter 2 to see your account");
        System.out.println("Enter 0 to Home Page");

        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int userChoice = sc.nextInt();
            System.out.println(userChoice);
            if (userChoice == 0){
                super.contentpage.setPage(new HomePage(super.contentpage, super.getCustomer()));
                super.contentpage.executepage();
            } else if (userChoice == 1) {
                //Create account
                String userInput = ""; //Checking or Saving
                //Customer.addAccountToList(userInput);
            } else if (userChoice == 2) {
                //Display List<Account> from Customer class
            }
        }
    }

    @Override
    public Customer getCustomer(){
        return customer;
    }


}

 */