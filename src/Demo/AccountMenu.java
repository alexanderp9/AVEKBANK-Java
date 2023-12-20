package Demo;

import AccountCollection.AccountType;
import AccountCollection.Customer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountMenu extends PageCreator {
    public AccountMenu(Context context, Customer customer, Scanner scanner) {
        super(context, customer, scanner);
    }

    @Override
    public void printState() {

        int userAccountChoice = -1;
        while (userAccountChoice != 0) { // kommer köra loopen tills vi trycker 0 så hoppar den ut och tillbaka till main loopen
            System.out.println("Account page of customer: " + getCustomer().getBankId());
            if (getCustomer().getAccounts().size() == 0){
                System.out.println("You have empty accounts now. Choose 8-9 to create one.");
            }
            System.out.println(getCustomer().printoutAccountsWithIndex());
            System.out.println("1-7 - Choose account" +
                    "\n8 - Create a new Checking account" +
                    "\n9 - Create a new Saving account" +
                    "\n0 - Return to homepage"
            );

            try {
                userAccountChoice = getScanner().nextInt();
            } catch (InputMismatchException e){
                getScanner().nextLine();
                System.out.println("Input must be a number. Try again.\n");
                continue;
            }

            getScanner().nextLine();

            if (userAccountChoice >= 1 && userAccountChoice <= getCustomer().getAccounts().size() && !getCustomer().getAccounts().isEmpty()) {
                AccountHandler accountHandler = new AccountHandler(getContext(),getCustomer(),getScanner());
                accountHandler.setUserChoice(userAccountChoice);
                getContext().refreshState(accountHandler);
            } else if (userAccountChoice == 8) {
                getCustomer().addAccountToList(AccountType.CHECKING);
            } else if (userAccountChoice == 9) {
                getCustomer().addAccountToList(AccountType.SAVING);
            } else if (userAccountChoice == 0) {
                MainMenu mainMenu = new MainMenu(getContext(),getCustomer(),getScanner());
                getContext().refreshState(mainMenu);
            } else {
                System.out.println("Input invalid. Try again.\n");
            }
        }
    }
}