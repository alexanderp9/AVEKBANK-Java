package Demo;

import AccountCollection.Customer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu extends PageCreator{
    public MainMenu(Context context, Customer customer, Scanner scanner) {
        super(context, customer, scanner);
    }

    public void printState(){
        System.out.println("1 - About Bank " +
                "\n2 - My Accounts " +
                "\n3 - Contact Bank" +
                "\n4 - Log out");

        int userChoice;
        while (true) {
            try{
                userChoice = getScanner().nextInt();
            } catch (InputMismatchException e){
                getScanner().nextLine();
                System.out.println("Input must be a number. Try again.");
                continue;
            }

            if (userChoice == 1) {
                AboutBank aboutBank = new AboutBank(getContext(),getCustomer(),getScanner());
                getContext().refreshState(aboutBank);
            } else if (userChoice == 2) {
                AccountMenu accountMenu = new AccountMenu(getContext(),getCustomer(),getScanner());
                getContext().refreshState(accountMenu);
            } else if (userChoice == 3) {
                ContactBank contactBank = new ContactBank(getContext(),getCustomer(),getScanner());
                getContext().refreshState(contactBank);
            } else if (userChoice == 4) {
                System.out.println("Thank you. Bye.");
                System.exit(0);
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
    }
}
