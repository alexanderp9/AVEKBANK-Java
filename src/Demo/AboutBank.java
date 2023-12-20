package Demo;

import AccountCollection.Customer;

import java.util.Scanner;

public class AboutBank extends PageCreator{
    public AboutBank(Context context, Customer customer, Scanner scanner) {
        super(context, customer, scanner);
    }

    @Override
    public void printState(){
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++" +
                "\n\t\t\t\tInfo om banken" +
                "\nVi är AVEK Bank. Vi tar hand om dina pengar säkert." +
                "\n+++++++++++++++++++++++++++++++++++++++++++++++++" +
                "\nÖppettider måndag - fredag 8 - 16" +
                "\nAdress: Javavägen 1, 19 222, Stockholm" +
                "\nTelefon nummer: 07 123 456 78");
        System.out.println("\n0 - Return to homepage");

        int userChoice;

        while (true){
            userChoice = getScanner().nextInt();
            if (userChoice == 0) {
                MainMenu mainMenu = new MainMenu(getContext(),getCustomer(),getScanner());
                getContext().refreshState(mainMenu);
            } else {
                System.out.println("Invalid input. Try again.");
                getScanner().nextLine();
            }
        }

    }
}
