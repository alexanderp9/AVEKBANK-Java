package AccountCollection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankDemo {

    private static final Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        System.out.println("Welcome to AVEK Bank!" +
                "\nPlease enter your ID number and verify yourself on BankID: ");

        try{
            long bankId = sc.nextLong();
            Customer customer = new Customer(bankId);
            System.out.println("Authentication Succed!" +
                    "\nWelcome customer: " + bankId);
            mainMenu(customer);
        } catch (InputMismatchException e){
            System.out.println("BankID must be yyyymmdd");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void mainMenu(Customer customer) throws InterruptedException {
        System.out.println("1 - About Bank " +
                "\n2 - My Accounts " +
                "\n3 - Contact Bank" +
                "\n4 - Log out");

        int userChoice;
        while (true) {
            try{
                userChoice = sc.nextInt();
            } catch (InputMismatchException e){
                sc.nextLine();
                System.out.println("Input must be a number. Try again.");
                continue;
            }

            if (userChoice == 1) {
                aboutBank(customer);
            } else if (userChoice == 2) {
                accountsMenu(customer);
            } else if (userChoice == 3) {
                contactBank(customer);
            } else if (userChoice == 4) {
                System.out.println("Thank you. Bye.");
                System.exit(0);
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
    }

    private static void aboutBank(Customer customer) throws InterruptedException {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/AccountCollection/aboutBank.txt"))) {
            String fromFile;
            while ((fromFile = bufferedReader.readLine()) != null){
                System.out.println(fromFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading file");
        }

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

    private static void accountsMenu(Customer customer) throws InterruptedException {

        int userAccountChoice = -1;
        while (userAccountChoice != 0) {
            System.out.println("Account page of customer: " + customer.getBankId());
            if (customer.getAccounts().size() == 0){
                System.out.println("You have no accounts yet. Choose 7-9 to create one.");
            }
            System.out.println(customer.printoutAccountsWithIndex());
            System.out.println("1-6 - Choose account" +
                            "\n7 - Create a new Creditcard account" +
                            "\n8 - Create a new Checking account" +
                            "\n9 - Create a new Saving account" +
                            "\n0 - Return to homepage"
            );

            try {
                userAccountChoice = sc.nextInt();
            } catch (InputMismatchException e){
                sc.nextLine();
                System.out.println("Input must be a number. Try again.\n");
                continue;
            }

            sc.nextLine();

            if (userAccountChoice >= 1 && userAccountChoice <= customer.getAccounts().size() && !customer.getAccounts().isEmpty()) {
                accountHandler(customer, userAccountChoice);
            } else if (userAccountChoice == 7) {
                customer.addAccountToList(AccountType.CREDITCARD);
            } else if (userAccountChoice == 8) {
                customer.addAccountToList(AccountType.CHECKING);
            } else if (userAccountChoice == 9) {
                customer.addAccountToList(AccountType.SAVING);
            } else if (userAccountChoice == 0) {
                mainMenu(customer);
            } else {
                System.out.println("Input invalid. Try again.\n");
            }
        }
    }

    private static void accountHandler(Customer customer, int accountIndex) {
        int userAccountChoice = -1;
        while (userAccountChoice != 0) {
            System.out.println("Accounthandler page of customer: " + customer.getBankId());
            System.out.println(customer.printOutActualAccountBalance(accountIndex));
            System.out.println("1 - Deposit" +
                            "\n2 - Withdraw" +
                    //3 - Change PIN here if CreditAccount
                            "\n0 - Go back to Account page");

            try {
                userAccountChoice = sc.nextInt();
            } catch (InputMismatchException e){
                sc.nextLine();
                System.out.println("Input must be a number. Try again.\n");
                continue;
            }
            sc.nextLine();

            double amountInput = -1;

            try {
                if (userAccountChoice == 1) { //Deposit
                    System.out.println("How much do you want to deposit into your account? ");
                    amountInput = sc.nextDouble();
                    sc.nextLine();
                    if (checkIfAmountValid(amountInput)){
                        customer.getAccounts().get(accountIndex-1).deposit(amountInput);
                        accountHandler(customer, accountIndex);
                    }
                } else if (userAccountChoice == 2) { //Withdraw
                    System.out.println("How much do you want to withdraw your account? ");
                    amountInput = sc.nextDouble();
                    sc.nextLine();
                    if (checkIfAmountValid(amountInput)){
                        customer.getAccounts().get(accountIndex-1).withdraw(amountInput);
                        accountHandler(customer, accountIndex);
                    }
                } else if (userAccountChoice == 0) { //Back to handleAccount
                    accountsMenu(customer);
                } else {
                    System.out.println("Wrong input. Try again.\n");
                }
            } catch (InputMismatchException e){
                sc.nextLine();
                System.out.println("Input must be a positive number. Try again.\n");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void contactBank(Customer customer) throws InterruptedException {
        System.out.println("Customer: " + customer.getBankId() + "\nPlease enter your message: ");
        if (sc.hasNextLine()) {
            sc.nextLine();
        }
        String userMessageInput = sc.nextLine();

        if (!userMessageInput.isEmpty()) {
            System.out.println("Your message has been sent, thank you! " + "Customer: " + customer.getBankId());
            System.out.println("Returning to homepage..");
            Thread.sleep(2000);
            mainMenu(customer);
        } else {
            System.out.println("Please enter a valid message.");
        }
    }

    public static boolean checkIfAmountValid(double amount){ //check if the user enter a valid amount of money
        return amount > 0 ? true : false;
    }
}


