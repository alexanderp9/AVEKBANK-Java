package Demo;

import AccountCollection.Customer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Home extends PageCreator{

    public Home(Context context, Customer customer, Scanner scanner) {
        super(context, customer, scanner);
        super.setContext(context);
        setScanner(getScanner());
    }

    public void printState(){
        System.out.println("Welcome to AVEK Bank!" +
                "\nPlease enter your ID number and verify yourself on BankID: ");

        try{
            int bankId = getScanner().nextInt();
            setCustomer(new Customer(bankId));
            System.out.println("Authentication Succed!" +
                    "\nWelcome customer: " + bankId);
            MainMenu mainMenu = new MainMenu(getContext(),getCustomer(),getScanner());
            getContext().refreshState(mainMenu);
        } catch (InputMismatchException e){
            System.out.println("BankID must be yyyymmdd");
        }
    }
}
