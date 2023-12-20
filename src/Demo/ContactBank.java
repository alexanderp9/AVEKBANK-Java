package Demo;

import AccountCollection.Customer;

import java.util.Scanner;

public class ContactBank extends PageCreator{
    public ContactBank(Context context, Customer customer, Scanner scanner) {
        super(context, customer, scanner);
    }

    @Override
    public void printState() {
        Customer customer = getCustomer();
        Scanner sc = getScanner();
        System.out.println("Customer: " + customer.getBankId() + "\nPlease enter your message: ");
        if (sc.hasNextLine()) {
            sc.nextLine();
        }
        String userMessageInput = sc.nextLine();

        if (!userMessageInput.isEmpty()) {
            System.out.println("Your message has been sent, thank you! " + "Customer: " + customer.getBankId());
            System.out.println("Returning to homepage..");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            MainMenu mainMenu = new MainMenu(getContext(),getCustomer(),getScanner());
            getContext().refreshState(mainMenu);
        } else {
            System.out.println("Please enter a valid message.");
        }
    }
}
