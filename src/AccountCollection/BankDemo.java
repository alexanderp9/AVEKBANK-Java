package AccountCollection;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BankDemo {

    private static final Scanner sc = new Scanner(System.in);
    private Customer currentCustomer;


    public BankDemo() {
        currentCustomer = null;
    }

    public void runBankApp() throws InterruptedException {
        authenticateCustomer();
        if (currentCustomer != null) {
            mainMenu();
        }

    }

    public void authenticateCustomer() {
        System.out.println("Welcome to AVEK Bank!");
        boolean isAuthenticated = false;
        while (!isAuthenticated) {
            System.out.println("\nPlease enter your ID number and verify yourself on BankID: ");
            try {
                String bankIdStr = sc.nextLine();
                if (bankIdStr.length() == 12 && bankIdStr.matches("\\d+")) {
                    long bankId = Long.parseLong(bankIdStr);
                    if (isValidBankid(bankId)) {
                        currentCustomer = new Customer(bankId);
                        System.out.println("Succesful authentication!\n" +
                                "\nWelcome customer: " + bankId);
                        isAuthenticated = true;
                    } else {
                        System.out.println("Invalid BankID, try again!");
                    }
                } else {
                    System.out.println("BankID must be 12-digit number");
                }
            } catch (NumberFormatException e) {
                System.out.println("BankID must be a 12-digit number");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean isValidBankid(long bankId) throws Exception {
        List<String> validIds = Files.readAllLines(Paths.get("src/AccountCollection/Register.txt"));
        return validIds.contains(String.valueOf(bankId));
        }

    private void mainMenu() throws InterruptedException {
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
                aboutBank();
            } else if (userChoice == 2) {
                accountsMenu();
            } else if (userChoice == 3) {
                contactBank();
            } else if (userChoice == 4) {
                System.out.println("Thank you. Bye.");
                System.exit(0);
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
    }

    private void aboutBank() throws InterruptedException {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++" +
                "\t\t\t\tInfo om banken" +
                "\nVi är AVEK Bank. Vi tar hand om dina pengar säkert." +
                "\n+++++++++++++++++++++++++++++++++++++++++++++++++" +
                "\nÖppettider måndag - fredag 8 - 16" +
                "\nAdress:" +
                "\nTelefon nummer:");
        System.out.println("\n0 - Return to homepage");

        int userChoice;

        while (true){
            userChoice = sc.nextInt();
            if (userChoice == 0) {
                mainMenu();
            } else {
                System.out.println("Invalid input. Try again.");
                sc.nextLine();
            }
        }
    }

    private void accountsMenu() throws InterruptedException {

        int userAccountChoice = -1;
        while (userAccountChoice != 0) { // kommer köra loopen tills vi trycker 0 så hoppar den ut och tillbaka till main loopen
            System.out.println("Account page of customer: " + currentCustomer.getBankId());
            if (currentCustomer.getAccounts().size() == 0){
                System.out.println("You have empty accounts now. Choose 8-9 to create one.");
            }
            System.out.println(currentCustomer.printoutAccountsWithIndex());
            System.out.println("1-7 - Choose account" +
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

            if (userAccountChoice >= 1 && userAccountChoice <= currentCustomer.getAccounts().size() && !currentCustomer.getAccounts().isEmpty()) {
                accountHandler(userAccountChoice);
            } else if (userAccountChoice == 8) {
                currentCustomer.addAccountToList(AccountType.CHECKING);
            } else if (userAccountChoice == 9) {
                currentCustomer.addAccountToList(AccountType.SAVING);
            } else if (userAccountChoice == 0) {
                mainMenu();
            } else {
                System.out.println("Input invalid. Try again.\n");
            }
        }
    }

    private void accountHandler(int accountIndex) {

        int userAccountChoice = -1;
        while (userAccountChoice != 0) {
            System.out.println("Accounthandler page of customer: " + currentCustomer.getBankId());
            System.out.println(currentCustomer.printOutActualAccountBalance(accountIndex));
            System.out.println("1 - Deposit" +
                            "\n2 - Withdraw" +
                            "\n3 - Simulate one year passing" +
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
                        currentCustomer.getAccounts().get(accountIndex-1).deposit(amountInput);
                        accountHandler(accountIndex);
                    }
                } else if (userAccountChoice == 2) { //Withdraw
                    System.out.println("How much do you want to withdraw your account? ");
                    amountInput = sc.nextDouble();
                    sc.nextLine();
                    if (checkIfAmountValid(amountInput)) {
                        currentCustomer.getAccounts().get(accountIndex - 1).withdraw(amountInput);
                        accountHandler(accountIndex);
                    }
                } else if (userAccountChoice == 3) {
                    simulateYear(accountIndex);

                } else if (userAccountChoice == 0) { //Back to handleAccount
                    accountsMenu();
                } else {
                    System.out.println("Input must be a positive number. Try again.\n");
                }
            } catch (InputMismatchException e){
                sc.nextLine();
                System.out.println("Input must be a positive number. Try again.\n");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void contactBank() throws InterruptedException {
        System.out.println("Customer: " + currentCustomer.getBankId() + "\nPlease enter your message: ");
        if (sc.hasNextLine()) {
            sc.nextLine();
        }
        String userMessageInput = sc.nextLine();

        if (!userMessageInput.isEmpty()) {
            System.out.println("Your message has been sent, thank you! " + "Customer: " + currentCustomer.getBankId());
            System.out.println("Returning to homepage..");
            Thread.sleep(3000);
            mainMenu();
        } else {
            System.out.println("Please enter a valid message.");
        }
    }

    public static boolean checkIfAmountValid(double amount){ //check if the user enter a valid amount of money
        return amount > 0 ? true : false;
    }

    private void simulateYear(int accountIndex) {
        BankAccount account = currentCustomer.getAccounts().get(accountIndex - 1);
        if (account instanceof SavingBankAccount) {
            ((SavingBankAccount) account).simulateOneYearPast();
            System.out.println("A year has now passed");
        } else {
            System.out.println("This option is only available for SavingsAccount\n");
        }
    }
}


