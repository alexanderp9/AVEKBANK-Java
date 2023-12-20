package Demo;

import AccountCollection.Customer;
import java.util.Scanner;

public class BankDemo {
    public static void main(String[] args) {

        Context context = new Context();
        Customer customer = null;
        Scanner scanner = new Scanner(System.in);

        Home home = new Home(context, customer, scanner);
        context.refreshState(home);
    }
}


