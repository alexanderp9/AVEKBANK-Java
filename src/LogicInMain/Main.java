/*package LogicInMain;

import AccountCollection.Customer;

import java.beans.Customizer;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Customer customer;

    public static void login(){
        System.out.println("Enter your bankID");
        String s = sc.nextLine();
        //after identity check success
        //otherwise print error msg
        customer = new Customer();
    }

    public static int homePage(){
        System.out.println("welcome to AVEKBank" +
                "\n1. About Bank" +
                "\n2. Bank opening time and address" +
                "\n3. My accounts" +
                "\n0. log out");
        int temp = sc.nextInt();
        //after control of choice is between 0-3
        return temp;
        //otherwise throw new exception ("Invalid input. Try again.")
    }

    public static void myAccountPage(){

    }

    public static int aboutBank(){
        System.out.println("We are AVEK Bank!");
        return sc.nextInt();
    }

    public static void logout(){
        System.exit(0);
    }


    public static void pageHandler(){
        while (true){
            switch (homePage()){
                case 0: logout(); break;
                case 1: System.out.println("About bank page"); break;
                case 2: System.out.println("Bank opening hours and address page"); break;
                case 3: System.out.println("My account page"); break;
            }

            switch (aboutBank()){
                case 0: homePage();break;
            }
        }
    }

    public static void main(String[] args) {
        pageHandler();
    }
}

 */
