package PageFolder;

import java.util.Scanner;

public class LoginPage extends ExecutePageCreator{

    public LoginPage(Content contentpage) {
        super(contentpage);
    }

    @Override
    public void execute() {
        System.out.println("Enter your bankID");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        //after identity check success
        System.out.println("Login success. Please wait...");
        super.contentpage.setPage(new HomePage(super.contentpage));
        super.contentpage.executepage();

    }
}