package PageFolder;

import java.util.Scanner;

public class MyAccountPage extends ExecutePageCreator{
    public MyAccountPage(Content contentpage) {
        super(contentpage);
    }



    @Override
    public void execute() {
        System.out.println("Here is my account page");
        System.out.println("Enter 0 to Home Page");

        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int userChoice = sc.nextInt();
            System.out.println(userChoice);
            if (userChoice == 0){
                super.contentpage.setPage(new HomePage(super.contentpage));
                super.contentpage.executepage();
            }
        }
    }
}