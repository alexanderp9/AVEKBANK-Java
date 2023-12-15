package AccountCollection;

import java.util.Scanner;

public class BankDemo {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to AVEK Bank!");
        System.out.println("Please enter your ID number and verify yourself on BankID: ");

        int bankId = sc.nextInt();
        Customer customer = new Customer(bankId);
        System.out.println("Authentication Succed!");
        System.out.println("Welcome customer: " + bankId);
        mainMenu(customer);
    }

    private static void accountsMenu(Customer customer) {

        int userAccountChoice = -1;
        while (userAccountChoice != 0) { // kommer köra loopen tills vi trycker 0 så hoppar den ut och tillbaka till main loopen
            System.out.println("Account page of customer: " + customer.getBankId());
            if (customer.getAccounts().size()==0){
                System.out.println("You have empty accounts now. Choose 8-9 to create one.");
            }
            System.out.println(customer.printoutAccountsWithIndex());
            System.out.println("1-7 - Choose account");
            System.out.println("8 - Create a new Checking account");
            System.out.println("9 - Create a new Saving account");
            System.out.println("0 - Return to homepage");

            userAccountChoice = sc.nextInt();
            sc.nextLine();

            if (userAccountChoice >= 1 && userAccountChoice <= 7 && !customer.getAccounts().isEmpty()) {
                System.out.println(customer.printOutActualAccountBalance(1));
                accountHandler(customer, userAccountChoice);
            } else if (userAccountChoice == 8) {
                customer.addAccountToList(AccountType.CHECKING);
            } else if (userAccountChoice == 9) {
                customer.addAccountToList(AccountType.SAVING);
            } else if (userAccountChoice >= 10) {
                System.out.println("Invalid option");
            } else if (userAccountChoice == 0) {
                mainMenu(customer);
            }
        }
    }

    private static void aboutBank(Customer customer) {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("\t\t\t\tInfo om banken" +
                "\nVi är SVEK Bank. Vi tar hand om dina pengar säkert.");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("\n0 - Return to homepage");

        int userChoice;

        while (true){
             userChoice = sc.nextInt();
            if (userChoice == 0) {
                mainMenu(customer);
            } else {
                System.out.println("Invalid input. Try again.");
                sc.nextLine();
            }
        }
    }

    private static void mainMenu(Customer customer) {
        System.out.println("1 - About Bank");
        System.out.println("2 - My Accounts");
        System.out.println("3 - Log out");


        int userChoice;
        while (true) {
            userChoice = sc.nextInt();

            if (userChoice == 1) {
                aboutBank(customer);
            } else if (userChoice == 2) {
                accountsMenu(customer);
            } else if (userChoice == 3) {
                System.out.println("Thank you. Bye.");
                System.exit(0);
            } else {
                System.out.println("Invalid input. Try again.");
            }
            sc.nextLine();
        }
    }

    private static void accountHandler(Customer customer, int accountIndex) {
        int userAccountChoice = -1;
        while (userAccountChoice != 0) {
            System.out.println("Accounthandler page of customer: " + customer.getBankId());
            System.out.println(customer.printOutActualAccountBalance(accountIndex));
            System.out.println("1 - Deposit");
            System.out.println("2 - Withdraw");
            System.out.println("0 - Go back to Account page");

            userAccountChoice = sc.nextInt();
            sc.nextLine();

            if (userAccountChoice == 1) { //Deposit
                System.out.println("How much do you want to deposit into your account? ");
                userAccountChoice = sc.nextInt();
                sc.nextLine();
                customer.getAccounts().get(accountIndex-1).deposit(userAccountChoice);
                accountHandler(customer, accountIndex);
            } else if (userAccountChoice == 2) { //Withdraw
                System.out.println("How much do you want to withdraw your account? ");
                userAccountChoice = sc.nextInt();
                sc.nextLine();
                customer.getAccounts().get(accountIndex-1).withdraw(userAccountChoice);
                accountHandler(customer, accountIndex);
            } else if (userAccountChoice == 0) { //Back to handleAccount
                accountsMenu(customer);
            }
        }
    }
}


