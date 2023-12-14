//package PageFolder;
//
//import java.util.Scanner;
//
//public class HomePage extends ExecutePageCreator{
//
//    public HomePage(Content contentpage) {
//        super(contentpage);
//    }
//    @Override
//    public void execute() {
//        System.out.println("welcome to AVEKBank" +
//                "\n1. About Bank" +
////                "\n2. Bank opening time and address" +
//                "\n3. My accounts" +
//                "\n0. log out");
//
//        Scanner sc = new Scanner(System.in);
//        if (sc.hasNextInt()){
//            int userChoice = sc.nextInt();
//            if (userChoice == 1){
//                super.contentpage.setPage(new AboutBankPage(super.contentpage));
//                super.contentpage.executepage();
//            } else if (userChoice == 3){
//                super.contentpage.setPage(new MyAccountPage(super.contentpage));
//                super.contentpage.executepage();
//            } else if (userChoice == 0){
//                super.contentpage.setPage(new LogoutPage(super.contentpage));
//                super.contentpage.executepage();
//            }
//        }
//
//        sc.close();
//    }
//}