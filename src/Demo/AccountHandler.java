package Demo;

import AccountCollection.Customer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountHandler extends PageCreator{

    private int userChoice;
    public AccountHandler(Context context, Customer customer, Scanner scanner) {
        super(context, customer, scanner);
    }

    public int getUserChoice() {
        return userChoice;
    }

    public void setUserChoice(int userChoice) {
        this.userChoice = userChoice;
    }

    @Override
    public void printState() {
        Customer customer = getCustomer();
        Scanner sc = getScanner();
        int accountIndex = getUserChoice();
        int userAccountChoice = -1;
        while (userAccountChoice != 0) {
            System.out.println("Accounthandler page of customer: " + customer.getBankId());
            System.out.println(customer.printOutActualAccountBalance(accountIndex));
            System.out.println("1 - Deposit" +
                    "\n2 - Withdraw" +
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
                        System.out.println(customer.getAccounts().get(accountIndex-1).printAllHistory());
                        break;
                    }
                } else if (userAccountChoice == 2) { //Withdraw
                    System.out.println("How much do you want to withdraw your account? ");
                    amountInput = sc.nextDouble();
                    sc.nextLine();
                    if (checkIfAmountValid(amountInput)){
                        customer.getAccounts().get(accountIndex-1).withdraw(amountInput);
                        System.out.println(customer.getAccounts().get(accountIndex-1).printAllHistory());
                        break;
                    }
                } else if (userAccountChoice == 0) { //Back to handleAccount
                    break;
                } else {
                    System.out.println("Input must be a positive number. Try again.\n");
                    continue;
                }
                AccountMenu accountMenu = new AccountMenu(getContext(),getCustomer(),getScanner());
                getContext().refreshState(accountMenu);
            } catch (InputMismatchException e){
                sc.nextLine();
                System.out.println("Input must be a positive number. Try again.\n");
            }
        }
    }

    public static boolean checkIfAmountValid(double amount){ //check if the user enter a valid amount of money
        return amount > 0 ? true : false;
    }
}
