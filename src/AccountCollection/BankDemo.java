package AccountCollection;

import java.util.Arrays;
import java.util.Scanner;

import static AccountCollection.AccountFactory.createAccount;

public class BankDemo {

   private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to AVEK Bank!");
        System.out.println("Please enter your ID number and verify yourself on BankID: ");

        int bankId = sc.nextInt();
        Customer customer = new Customer(bankId);
        System.out.println("Authentication Succed!");
        System.out.println("Welcome customer: " + bankId);

        int userChoice;
        while (true) {
            showMenu();
            userChoice = sc.nextInt();
            sc.nextLine();

            if (userChoice == 1) {
                aboutBank();
            } else if (userChoice == 2) {
                handleAccounts(customer);
            } else if (userChoice == 3) {
                System.exit(0);
            } else if (userChoice == 0) {

            }
        }

    }

    private static void handleAccounts(Customer customer) {

        //logik för att hantera att skapa nya accounts med customer objektet som skapades tidigare.
        // vi kan printa ut listan av accounts objekts som skapats här antar jag
        // om det inte finnns några kan vi ha meny att välja att skapa en med createAccount här kanske och läggs till i listan
        // vi kan displaya listan hela tiden och kanske ha någon logik om den är tom att bara skriva en sträng att man inte har några konton
        int userAccountChoice = -1;
        while (userAccountChoice != 0) { // kommer köra loopen tills vi trycker 0 så hoppar den ut och tillbaka till main loopen
            System.out.println("Account page of customer: " + customer.getBankId());
            System.out.println("Print accounts from the list here maybe");
            System.out.println("1 - Create a new account");
            System.out.println("0 - Return to homepage");


            userAccountChoice = sc.nextInt();
            sc.nextLine();

            if (userAccountChoice == 1) {
                //createAccount(customer);
                customer.addAccountToList("Checking");
                System.out.println("Här är dina konton: " + Arrays.toString(customer.getAccounts().toArray()));

                // behöver ha logik att skapa accounts, men den måste nog ha en customer referens för att veta vilket objekt som ska skapa sina account objekt till sig själv
            } else if (userAccountChoice != 0) {
                System.out.println("Invalid option");
            }

        }
    }

/*    private static void createAccount(Customer customer) {

        // fabriken här inne tror jag blir bra med logiken if/case kanske enums för att välja vilket typ av account objekt man skapar

    }*/

    private static void aboutBank() {
        System.out.println("Info om banken");
    }

    private static void showMenu() {
        System.out.println("1 - About Bank");
        System.out.println("2 - My Accounts");
        System.out.println("3 - Log out");
        System.out.println("0 - Return to homepage");
    }
}
